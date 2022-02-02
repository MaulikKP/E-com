package com.mau.ecommerce.config;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.mau.ecommerce.entity.Product;
import com.mau.ecommerce.entity.ProductCategory;

public class MyDataRestConfig implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		// TODO Auto-generated method stub
		RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
		
		HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};
		
		// disable HTTP methods for product : PUT, POST, DELETE
		config.getExposureConfiguration()
			.forDomainType(Product.class)
			.withItemExposure((metdata, httpMethod) -> httpMethods.disable(theUnsupportedAction))
			.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedAction));
		
		// disable HTTP methods for product category : PUT, POST, DELETE
				config.getExposureConfiguration()
					.forDomainType(ProductCategory.class)
					.withItemExposure((metdata, httpMethod) -> httpMethods.disable(theUnsupportedAction))
					.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedAction));
		
			
	}

}
