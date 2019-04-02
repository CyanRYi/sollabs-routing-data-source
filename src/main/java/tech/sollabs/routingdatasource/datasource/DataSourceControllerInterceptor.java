package tech.sollabs.routingdatasource.datasource;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class DataSourceControllerInterceptor extends HandlerInterceptorAdapter {

    private static final String DATA_SOURCE_TYPE_HEADER_NAME = "service-name";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String dataSourceTypeName = request.getHeader(DATA_SOURCE_TYPE_HEADER_NAME);

        if (dataSourceTypeName.isEmpty()) {
            throw new IllegalArgumentException("Request header [" + DATA_SOURCE_TYPE_HEADER_NAME + "] is not exist");
        }

        DataSourceLookupKeyContextHolder.set(DataSourceType.valueOf(dataSourceTypeName));

        return super.preHandle(request, response, handler);
    }
}
