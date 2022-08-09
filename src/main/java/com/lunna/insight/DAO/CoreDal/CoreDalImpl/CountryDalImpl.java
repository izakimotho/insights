package com.lunna.insight.DAO.CoreDal.CoreDalImpl;

import com.lunna.insight.Core.Enum.ActiveStatus;
import com.lunna.insight.Core.commons.Validator;
import com.lunna.insight.DAO.CoreDal.CountryDal;
import com.lunna.insight.Models.DB.Countries;
import com.lunna.insight.Models.DTO.Common.Country;
import com.lunna.insight.Models.DTO.Common.RestPayload;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.TransactionManager;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional(propagation = Propagation.REQUIRES_NEW)
@Component
public class CountryDalImpl implements CountryDal {

    @Autowired
    private SessionFactory sessionFactory;


    private  EntityManagerFactory entityManagerFactory;
    private  EntityManager entityManager;

    public CountryDalImpl(EntityManagerFactory entityManagerFactory, EntityManager entityManager) {
        this.sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
        this.entityManagerFactory = entityManagerFactory;
        this.entityManager = entityManager;
    }




    @Override
    public RestPayload getCountry(int page, int replaceRemoved, int maxRecords, ActiveStatus status, String searchKey) throws Exception {
        Session session = this.sessionFactory.getCurrentSession();

        try {
            int startIndex = 0;
            RestPayload restPayload = new RestPayload(page, maxRecords);
            if (replaceRemoved > 0) {
                if (page > 1) {
                    startIndex = (maxRecords + ((page * maxRecords) - maxRecords)) - replaceRemoved;
                } else {
                    startIndex = maxRecords - replaceRemoved;
                }
                maxRecords = replaceRemoved;
            } else {
                if (page > 1) {
                    startIndex = (page * maxRecords) - maxRecords;
                }
            }
            List<Country> rtnData = new LinkedList<>();
            List fetchList;
            fetchList = new ArrayList();

            List inlineCount= new ArrayList();

            if (searchKey != null && !searchKey.equalsIgnoreCase("")) {
                if (status == ActiveStatus.ALL) {

                    String sql= ("from Countries where (cntryCode like '%"+searchKey + "%' And status = "+(status == ActiveStatus.ACTIVE)+")   or (cntryName like '%"+searchKey + "%' And status = "+(status == ActiveStatus.ACTIVE)+")     ");
                    Query query = session.createQuery(sql);
                    fetchList= query.list();


                    String inlineCountQuery = ("Select Count(cntryName) FROM Countries where (cntryCode like '%"+searchKey + "%' And status = "+(status == ActiveStatus.ACTIVE)+")   or (cntryName like '%"+searchKey + "%' And status = "+(status == ActiveStatus.ACTIVE)+")     ");
                    Query inlinequery = session.createQuery(inlineCountQuery);
                    inlineCount= inlinequery.list();
                } else {

                    String sql= ("from Countries where (cntryCode like '%"+searchKey + "%' And status = "+(status == ActiveStatus.ACTIVE)+")   or (cntryName like '%"+searchKey + "%' And status = "+(status == ActiveStatus.ACTIVE)+")     ");
                    Query query = session.createQuery(sql);
                    fetchList= query.list();


                    String inlineCountQuery = ("Select Count(cntryName) FROM Countries where (cntryCode like '%"+searchKey + "%' And status = "+(status == ActiveStatus.ACTIVE)+")   or (cntryName like '%"+searchKey + "%' And status = "+(status == ActiveStatus.ACTIVE)+")     ");
                    Query inlinequery = session.createQuery(inlineCountQuery);
                    inlineCount=  inlinequery.list();



                }
            } else {
                if (status == ActiveStatus.ALL) {
                    String sql= ("from Countries");

                    Query query = session.createQuery(sql);
                    query.setCacheable(true);
                    fetchList= query.list();

                    String inlineCountQuery = ("Select Count(1) FROM Countries ");
                    Query inlinequery = session.createQuery(inlineCountQuery);
                    inlinequery.setCacheable(true);
                    inlineCount=  inlinequery.list();


                } else {
                    String sql= ("from Countries where  status = "+(status == ActiveStatus.ACTIVE));
                    Query query = session.createQuery(sql);
                    query.setEntity("active", (status == ActiveStatus.ACTIVE));
                    fetchList= query.list();

                    String inlineCountQuery = ("Select Count(cntryName) FROM Countries WHERE status = :active ");
                    Query inlinequery = session.createQuery(inlineCountQuery);
                    inlineCount=  inlinequery.list();

                }
            }
            if (Validator.validateList(fetchList)) {
                for (Object country : fetchList) {
                    if (country != null) {
                        rtnData.add(new Country(((Countries) country).getCntryId(),
                                ((Countries) country).getCntryName(),
                                ((Countries) country).getCntryCode(),
                                ((Countries) country).isStatus()));
                    }
                }
            }



            if (inlineCount != null) {
                restPayload.setInlineCount(inlineCount.size());
            } else {
                restPayload.setInlineCount(0);
            }

            restPayload.setResults(rtnData);
            return restPayload;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }




    @Override
    public Country getCountry(UUID id) throws Exception {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            Countries country = session.get(Countries.class, id);

            //session.getTransaction().commit();
            Country rtnCountry = new Country();
            if (country != null) {
                rtnCountry =
                        new Country(country.getCntryId(), country.getCntryCode(), country.getCntryName(), country.isStatus());
            }

            return rtnCountry;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }


}
