package com.ram.sah.springbootecommerce.config;

import com.ram.sah.springbootecommerce.entity.Product;
import com.ram.sah.springbootecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class SpringDataRestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        HttpMethod[] myHttpMethods = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metdata, httpMethods1) -> httpMethods1.disable(myHttpMethods))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(myHttpMethods));

        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metdata, httpMethods1) -> httpMethods1.disable(myHttpMethods))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(myHttpMethods));

        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
    }
}
