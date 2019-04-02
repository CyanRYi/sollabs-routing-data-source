package tech.sollabs.routingdatasource.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.HashMap;
import java.util.Map;

public class RoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceLookupKeyContextHolder.get();
    }

    public static class Builder {

        private DataSourceType defaultDataSourceType;
        private Map<Object, Object> targetDataSources = new HashMap<>();

        public Builder addTargetDataSource(TypedDataSourceWrapper dataSourceWrapper) {
            targetDataSources.put(dataSourceWrapper.getName(), dataSourceWrapper.getDataSource());
            return this;
        }

        public Builder setDefaultDataSource(DataSourceType type) {
            this.defaultDataSourceType = type;
            return this;
        }

        public RoutingDataSource build() {

            RoutingDataSource routingDataSource = new RoutingDataSource();
            routingDataSource.setTargetDataSources(targetDataSources);
            routingDataSource.setDefaultTargetDataSource(targetDataSources.get(defaultDataSourceType));

            return routingDataSource;
        }
    }
}
