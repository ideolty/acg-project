package me.blog.acg.config;

import lombok.Data;
import org.hibernate.dialect.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef="PostgresEntityManagerFactory",
        transactionManagerRef = "PostgresTransactionManager",
        basePackages = {"me.blog.acg.article.repository"})
@ConfigurationProperties("spring.jpa.properties.postgres")
@Data
public class PostgresConfig {
    @Autowired
    private JpaProperties jpaProperties;

    @Qualifier("PostgresDataSource")
    @Autowired
    private DataSource postgresDataSource;

    String dialect;
    String hbm2ddl;

    @Bean(name = "PostgresEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary (EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(postgresDataSource)
                .properties(getVendorProperties())
                .packages("me.blog.acg.article.domain") //设置实体类所在位置
                .persistenceUnit("postgresPersistenceUnit")
                .build();
    }

    private Map<String, Object> getVendorProperties() {
        Map<String,String> map = new HashMap<>();
        map.put("hibernate.dialect", dialect);
        map.put("hibernate.hbm2ddl.auto", hbm2ddl);
        map.put("hibernate.temp.use_jdbc_metadata_defaults", "false");
        jpaProperties.setProperties(map);
        return jpaProperties.getHibernateProperties(new HibernateSettings());
    }

    @Bean(name = "PostgresEntityManager")
    public EntityManager entitymanager(EntityManagerFactoryBuilder builder){
        return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
    }

    @Bean(name = "PostgresTransactionManager")
    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
    }
}
