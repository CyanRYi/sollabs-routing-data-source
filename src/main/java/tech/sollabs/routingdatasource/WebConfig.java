package tech.sollabs.routingdatasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tech.sollabs.routingdatasource.datasource.DataSourceControllerInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private DataSourceControllerInterceptor dataSourceControllerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(dataSourceControllerInterceptor);
    }
}
