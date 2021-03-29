package com.liantong.integration.test.conf;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
@Configuration
@MapperScan(basePackages ="com.liantong.integration.mapper", sqlSessionTemplateRef  = "testSqlSessionTemplateH2DEMO")
public class AppConf {

        @Bean(name = "testDataSource")
        @ConfigurationProperties(prefix = "spring.datasource.h2demo")
        @Primary
        public DataSource testDataSource() {
            System.out.println("----------------");
           return DataSourceBuilder.create().type(com.alibaba.druid.pool.DruidDataSource.class).build();
               }
        @Bean(name = "sqlSessionFactory")
        public SqlSessionFactory testSqlSessionFactory(@Qualifier("testDataSource") DataSource dataSource) throws Exception {
            SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
            bean.setDataSource(dataSource);
            bean.setConfigLocation(new ClassPathResource("Configuration.xml"));
            bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/*.xml"));
            return bean.getObject();
        }
        @Bean(name = "TransactionManager")
        public DataSourceTransactionManager testTransactionManager(@Qualifier("testDataSource") DataSource dataSource) {
            return new DataSourceTransactionManager(dataSource);
        }
        @Bean(name = "testSqlSessionTemplateH2DEMO")
        public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
            return new SqlSessionTemplate(sqlSessionFactory);
        }

}
