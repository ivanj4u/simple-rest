/*
 * Copyright (c) 2017.
 */

package com.aribanilia.rest.simple.hcms;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "mssEntityManagerFactory",
        transactionManagerRef = "mssTransactionManager",
        basePackages = {"com.aribanilia.rest.simple.hcms.dao"}
)
public class SimpleHcmsConfig {

    @Primary
    @Bean(name = "mssDataSource")
    @ConfigurationProperties(prefix = "mss.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "mssJpaProperties")
    @ConfigurationProperties(prefix = "mss.hibernate")
    public Properties jpaProperties() {
        return new Properties();
    }

    @Primary
    @Bean(name = "mssEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("mssDataSource") DataSource dataSource,
            @Qualifier("mssJpaProperties") Properties properties
    ) {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = builder.dataSource(dataSource)
                .packages("com.aribanilia.rest.simple.hcms.entity")
                .persistenceUnit("hcms")
                .build();
        localContainerEntityManagerFactoryBean.setJpaProperties(properties);

        return localContainerEntityManagerFactoryBean;

    }

    @Primary
    @Bean("mssTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("mssEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
