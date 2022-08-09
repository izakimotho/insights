package com.lunna.insight.DAO.CoreDal.CoreDalImpl;

import com.lunna.insight.DAO.CoreDal.CityDao;
import com.lunna.insight.Core.Enum.ActiveStatus;
import com.lunna.insight.Models.DTO.Common.City;
import com.lunna.insight.Models.DTO.Common.RestPayload;

public class CityDaoImpl implements CityDao {


    @Override
    public RestPayload getCities(int page, int replaceRemoved, int maxRecords, ActiveStatus status, String searchKey, int cntryId) throws Exception {
        return null;
    }

    @Override
    public RestPayload getCities(int page, int replaceRemoved, int maxRecords, ActiveStatus status, String searchKey) throws Exception {
        return null;
    }

    @Override
    public City getCity(int id) throws Exception {
        return null;
    }


    //    @Override
//    public RestPayload getCities(int page, int replaceRemoved, int maxRecords, ActiveStatus status, String searchKey, int cntryId) throws Exception {
//        return null;
//    }
//
//    @Override
//    public RestPayload getCities(int page, int replaceRemoved, int maxRecords, ActiveStatus status, String searchKey) throws Exception {
//        return null;
//    }
//
//    @Override
//    public City getCity(int id, Operations ops, boolean commitTrans) throws Exception {
//        CoreQuery coreQuery = new CoreQuery("from mmCountries where mmCountries.cntryId = :id ", "id",  true);
//        coreQuery.addParam("locId");
//        List country = conOps.fetch(coreQuery, ops);
//        if (Validator.validateListFirstObject(country)) {
//            return (MdCountriesLocaleMap) country.get(0);
//        }
//        return null;
//    }
}
