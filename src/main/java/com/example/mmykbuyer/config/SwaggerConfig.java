package com.example.mmykbuyer.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi groupedApi() {
        return GroupedOpenApi.builder()
                .group("my-api")
                .pathsToMatch("/api/**")
                .build();
    }

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info().title("My API")
                        .description("My sample application")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("https://blog.csdn.net/zhoudingding")))
                .externalDocs(new ExternalDocumentation()
                        .description("My Blog")
                        .url("https://blog.csdn.net/zhoudingding"));
    }

}
