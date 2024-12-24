package com.taha.ecommerce.product;

import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;

@Configuration
public class ProductClient {

    @Bean
    public HttpGraphQlClient graphQlClient(@Value("${application.config.product-graphql-url}") String productGraphQlUrl) {
        return HttpGraphQlClient.builder()
                .url(productGraphQlUrl)
                .build();
    }

}