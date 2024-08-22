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

//    @Bean
//    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
//
//        return builder.routes()
//                .route(
//                        p -> p.path("/get")
//                                .filters(
//                                        f -> f
//                                                .addRequestHeader("NewHeader", "HeaderValue")
//                                                .addRequestParameter("paramKey", "paramValue")
//
//                                )
//                                .uri("http://google.com")
//                )
//
////                .route()
//                .build();
//
//        //bkup
//        /*
//                Function<PredicateSpec, Buildable<Route>> routeFunction
//                = p -> p.path("/get")
//                .filters(
//                        f -> f
//                                .addRequestHeader("NewHeader", "HeaderValue")
//                                .addRequestParameter("paramKey", "paramValue")
//
//                )
//                .uri("http://google.com");
//         */
//
//    }
}
