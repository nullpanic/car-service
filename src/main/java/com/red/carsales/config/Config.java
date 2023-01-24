package com.red.carsales.config;

import com.red.carsales.carService.CarService;
import com.red.carsales.carService.carServiveImpl.CarServiceImpl;
import com.red.carsales.dao.CarDao;
import com.red.carsales.dao.CarDaoImpl;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@ComponentScan("com.red.carsales")
@EnableWebMvc
@EnableTransactionManagement
public class Config {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CarService carService() {
        return new CarServiceImpl();
    }

    @Bean
    public CarDao carDao() {
        return new CarDaoImpl();
    }

    @Bean
    public DataSource dataSource() {

        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/cars");
        dataSource.setUsername("ROOT");
        dataSource.setPassword("112003");

        return dataSource;
    }

//    @Bean(name = "entityManagerFactory")
//    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
//
//        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactoryBean.setDataSource(dataSource);
//        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        entityManagerFactoryBean.setPackagesToScan("com.red.carsales.entity");
//
//        Properties jpaProperties = new Properties();
//
//        //Configures the used database dialect. This allows Hibernate to create SQL
//        //that is optimized for the used database.
//        jpaProperties.setProperty("hibernate.dialect",
//                "org.hibernate.dialect.PostgreSQLDialect");
//
//        //Specifies the action that is invoked to the database when the Hibernate
//        //SessionFactory is created or closed.
//        jpaProperties.setProperty("hibernate.hbm2ddl.auto", "create");
//
//        //Configures the naming strategy that is used when Hibernate creates
//        //new database objects and schema elements
//        //jpaProperties.put(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY));
//
//        //If the value of this property is true, Hibernate writes all SQL
//        //statements to the console.
//        jpaProperties.setProperty("hibernate.show_sql",
//                "true");
//
//        entityManagerFactoryBean.setJpaProperties(jpaProperties);
//
//        return entityManagerFactoryBean;
//    }


    @Bean
    public LocalSessionFactoryBean localSessionFactoryBean() throws PropertyVetoException {

        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();

        localSessionFactoryBean.setDataSource(dataSource());

        localSessionFactoryBean.setPackagesToScan("com.red.carsales.entity");

        Properties hibernate = new Properties();

        hibernate.setProperty("hibernate.dialect",
                "org.hibernate.dialect.PostgreSQLDialect");

        hibernate.setProperty("hibernate.show_sql",
                "true");

        hibernate.setProperty("hibernate.hbm2ddl.auto", "create");

        localSessionFactoryBean.setHibernateProperties(hibernate);

        return localSessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager() throws PropertyVetoException {

        HibernateTransactionManager transactionManager = new HibernateTransactionManager();

        transactionManager.setSessionFactory(localSessionFactoryBean().getObject());

        return transactionManager;
    }

}
