package com.liantong.integration.test.conf;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

/**
 * @author 王培忠
 * @Email 805705089@qq.com
 * @date 2020/8/25 11:12
 * @Description
 * @Reason ADDREASON
 * @since JDK 1.8
 */
@Configuration
public class CustomizeDataSourceInitializer {

    @Value("classpath:/INIT_TABLE.sql")
    private Resource functionScript;

    @Bean
    public DataSourceInitializer dataSourceInitializer(@Qualifier("testDataSource") DataSource dataSource){

        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);
        initializer.setDatabasePopulator(databasePopulator());
        return initializer;
    }
    private DatabasePopulator databasePopulator() {
        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScripts(functionScript);
        //populator.setSeparator("$$");
        return populator;
    }
}
