package com.lrp.api_gateway.configuration;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {

        return builder.routes()
                .route(
                        //http://localhost:8765/get
                        p -> p.path("/get")
                                .filters(
                                        f -> f
                                                .addRequestHeader("NewHeader", "HeaderValue")
                                                .addRequestParameter("paramKey", "paramValue")

                                )
                                .uri("http://httpbin.org:80")
                )

                .route(
                        //http://localhost:8765/v1/currency-exchange/from/AUD/to/PHP
                        p -> p.path("/v*/currency-exchange*/**")
                                .uri("lb://currency-exchange-service")
                ).route(
                        //http://localhost:8765/v1/currency-conversion/feign/from/USD/to/PHP/quantity/10
                        p -> p.path("/v*/currency-conversion*/**")
                                .uri("lb://currency-conversion-service")
                )
                //based from path, redirect to new
//                .route(
//                        //http://localhost:8765/v1/currency-conversion-new/feign/from/USD/to/PHP/quantity/10
//                        p -> p.path("/v*/currency-conversion-new/**")
//                                .filters(
//                                        f -> f.rewritePath(
//                                                "/v1/currency-conversion-new/(?<segment>.*)",
//                                                "/v1/currency-conversion/feign/${segment}"
//                                        )
//                                ).uri("lb://currency-conversion-service")
//                )
                .build();

        //bkup
        /*
                Function<PredicateSpec, Buildable<Route>> routeFunction
                = p -> p.path("/get")
                .filters(
                        f -> f
                                .addRequestHeader("NewHeader", "HeaderValue")
                                .addRequestParameter("paramKey", "paramValue")

                )
                .uri("http://google.com");
         */

    }
}
