package com.price.priceservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for OpenAPI documentation.
 */
@Configuration
public class OpenAPIConfig {

    /**
     * Creates a custom OpenAPI object with specified information.
     *
     * @return the custom OpenAPI object
     */
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Price Service API")
                        .version("1.0")
                        .description("Price Service API Documentation")
                        .contact(new Contact()
                                .name("Diana Losada")
                                .email("dlosada@k-lagan.com"))
                        .termsOfService("http://swagger.io/terms/")
                );
    }
}