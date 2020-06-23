package cointwo.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DaoConfig {

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DataSource ds = new DataSource();
        ds.setDriverClassName("org.mariadb.jdbc.Driver");
        ds.setUrl("jdbc:mariadb://localhost:3306/cointwo?characterEncoding=utf8");
        ds.setUsername("dohpkim");
        ds.setPassword("8175");
        ds.setInitialSize(2);
        ds.setMaxActive(10);
        ds.setMaxIdle(10);
        ds.setTestWhileIdle(true);
        ds.setMinEvictableIdleTimeMillis(1000 * 60 * 3); // 3 min
        ds.setTimeBetweenEvictionRunsMillis(1000 * 10);
        return ds;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager tm = new DataSourceTransactionManager();
        tm.setDataSource(dataSource());

        return tm;
    }

}