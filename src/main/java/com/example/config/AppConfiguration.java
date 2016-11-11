package com.example.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by hrushikeshp on 11/10/2016.
 */

@Configuration
/*
 Note:
 Excluding datasource and Jpa related autoconfiguration
*/
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
/*
Note :
    We are using autoconfiguration for spring mvc
*/

// WebMvcAutoConfiguration.class
//@EnableWebMvc

/*
Note :
Defining basePackage is required otherwise application does not recognize the entities defined
*/
@EnableJpaRepositories(basePackages = "com.example")
@EnableTransactionManagement
public class AppConfiguration {
     /* Data source java configuration */
    @Bean
    public DataSource dataSource() {
        DataSourceBuilder builder=DataSourceBuilder.create();
        builder.url("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=- 1;DB_CLOSE_ON_EXIT=FALSE");
        builder.password("");
        builder.username("sa");
        builder.driverClassName("org.h2.Driver");
        return builder.build();
    }
    /* Entity manager configuraion JPA  */
   @Bean
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        // Note : setPackagesToScan is required . If not defined then application needs persistance.xml
        factory.setPackagesToScan("com.example");
        factory.setDataSource(dataSource());
        factory.afterPropertiesSet();
        return factory.getObject();
    }
    /* Transaction manager configuration for handling transaction */
    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager(entityManagerFactory());
        //txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }
}
