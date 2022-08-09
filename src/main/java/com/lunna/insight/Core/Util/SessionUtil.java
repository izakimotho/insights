
package com.lunna.insight.Core.Util;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;


@EnableTransactionManagement
public class SessionUtil {


//
//    @Autowired
//    private Environment env;
//
////
//    @Bean(name = "dataSource")
//    public DataSource getDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//        // See: application.properties
//        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
//        dataSource.setUrl(env.getProperty("spring.datasource.url"));
//        dataSource.setUsername(env.getProperty("spring.datasource.username"));
//        dataSource.setPassword(env.getProperty("spring.datasource.password"));
//        System.out.println("## getDataSource: " + dataSource);
//        return dataSource;
//    }
//
//
//      @Autowired
//    @Bean(name = "sessionFactory")
//    public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
//        Properties properties = new Properties();
//        // See: application.properties
//        properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
//          properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
//          properties.put("hibernate.allow_update_outside_transaction", env.getProperty("hibernate.allow_update_outside_transaction"));
//
//        properties.put("current_session_context_class", //
//                env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));
//        // Fix Postgres JPA Error:
//        // Method org.postgresql.jdbc.PgConnection.createClob() is not yet implemented.
//        // properties.put("hibernate.temp.use_jdbc_metadata_defaults",false);
//        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
//        // Package contain entity classes
//        factoryBean.setPackagesToScan(new String[] { "" });
//        factoryBean.setDataSource(dataSource);
//        factoryBean.setHibernateProperties(properties);
//        factoryBean.afterPropertiesSet();
//        //
//        SessionFactory sf = factoryBean.getObject();
//        System.out.println("## getSessionFactory: " + sf);
//        return sf;
//    }
//
//


//
//    @Autowired
//    @Bean(name = "transactionManager")
//    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
//        return transactionManager;
//    }
//
//
//    @Autowired
//    @Bean("transactionManagerName")
//    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory)
//            throws SQLException, NamingException {
//        final HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(sessionFactory.getSessionFactory());
//        return transactionManager;
//    }


}
