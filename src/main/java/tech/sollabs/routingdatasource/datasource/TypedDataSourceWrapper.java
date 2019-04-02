package tech.sollabs.routingdatasource.datasource;

import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;

public class TypedDataSourceWrapper {

    private DataSourceType name;
    private DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();;

    public DataSourceType getName() {
        return name;
    }
    public void setName(DataSourceType name) {
        this.name = name;
    }
    public DataSource getDataSource() {
        return this.dataSourceBuilder.build();
    }

    // ConfigurationProperties를 통해 직접 Binding하기 위한 setter
    public void setUrl(String url) {
        this.dataSourceBuilder.url(url);
    }
    public void setDriverClassName(String driverClassName) {
        this.dataSourceBuilder.driverClassName(driverClassName);
    }
    public void setUsername(String username) {
        this.dataSourceBuilder.username(username);
    }
    public void setPassword(String password) {
        this.dataSourceBuilder.password(password);
    }
    public void setType(Class<? extends DataSource> type) {
        this.dataSourceBuilder.type(type);
    }
}