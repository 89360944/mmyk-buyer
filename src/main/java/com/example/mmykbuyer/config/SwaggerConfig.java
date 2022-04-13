package com.example.mmykbuyer.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SwaggerConfig {
//    @Bean
//    public GroupedOpenApi groupedApi() {
//        return GroupedOpenApi.builder()
//                .group("my-api")
//                .pathsToMatch("/api/**")
//                .build();
//    }

    @Bean
    public OpenAPI api() {
        List<Server> servers = new ArrayList<>();
        servers.add(new Server().url("182.254.192.61"));
        return new OpenAPI().servers(servers);
    }

}
