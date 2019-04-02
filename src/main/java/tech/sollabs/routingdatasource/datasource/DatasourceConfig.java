package tech.sollabs.routingdatasource.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;

@Configuration
public class DatasourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "datasource.a")
    public TypedDataSourceWrapper aDataSource() {
        return new TypedDataSourceWrapper();
    }

    @Bean
    @ConfigurationProperties(prefix = "datasource.o")
    public TypedDataSourceWrapper oDataSource() {
        return new TypedDataSourceWrapper();
    }

    @Bean
    @ConfigurationProperties(prefix = "datasource.t")
    public TypedDataSourceWrapper tDataSource() {
        return new TypedDataSourceWrapper();
    }

    @Bean(name = "dataSource")
    @Autowired
    public DataSource routingDataSource(TypedDataSourceWrapper... dataSources) {

        RoutingDataSource.Builder builder = new RoutingDataSource.Builder();

        Arrays.stream(dataSources)
                .forEach(builder::addTargetDataSource);
        builder.setDefaultDataSource(DataSourceType.A);

        return builder.build();
    }
}
