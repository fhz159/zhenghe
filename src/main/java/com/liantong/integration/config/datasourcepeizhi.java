package com.liantong.integration.config;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.util.DruidPasswordCallback;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages="com.liantong.integration.mapper",sqlSessionFactoryRef ="sqlSessionTemplate")
public class datasourcepeizhi {

    @Value("${spring.datasource.testmysqldemo.url}")
    private String url;
    @Value("${spring.datasource.testmysqldemo.username}")
    private String userName;
    @Value("${spring.datasource.testmysqldemo.password}")
    private String passWord;
    @Value("${spring.datasource.testmysqldemo.type}")
    private String type;


    @Bean(name = "testmysqldemo_dataSource" )
    @ConfigurationProperties(prefix = "spring.datasource.testmysqldemo")
    public DataSource testDataSource() {
        DruidDataSource dataSource=new DruidDataSource();
        try {

            dataSource.setUrl(url);
            dataSource.setUsername(userName);
            dataSource.setDbType(type);
            dataSource.setPassword(passWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }
    @Bean(name = "testmysqldemo_dataSource_sqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("testmysqldemo_dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setConfigLocation(new ClassPathResource("Configuration.xml"));
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:com/lianong/interation/mapper/*.xml"));
        return bean.getObject();
    }
    @Bean(name = "TransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("testmysqldemo_dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("testmysqldemo_dataSource_sqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
