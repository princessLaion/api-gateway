# Pre-requisite
- Start Docker MySQL and zipkin

# Zipkin URL
http://localhost:9411/zipkin/

## Github Dependent projects
[Currency Exchange](https://github.com/princessLaion/currency-exchange-service)  
[Currency Conversion](https://github.com/princessLaion/currency-conversion-service)  
[API Gateway](https://github.com/princessLaion/api-gateway)  
[Naming Server](https://github.com/princessLaion/naming-server)

## Currency Exchange
Orig URL:
http://localhost:8000/v1/currency-exchange/from/AUD/to/PHP

Gateway:
Invalid after we implemented Routing as we removed other property file config
http://localhost:8765/currency-exchange-service/v1/currency-exchange/from/AUD/to/PHP

Rerouting:
http://localhost:8765/v1/currency-exchange/from/AUD/to/PHP

## Currency Conversion
http://localhost:8100/v1/currency-conversion/from/USD/to/PHP/quantity/10

Gateway: 
Invalid after we implemented Routing as we removed other property file config
http://localhost:8765/currency-conversion-service/v1/currency-conversion/from/USD/to/PHP/quantity/10

Routing:
http://localhost:8765/v1/currency-conversion/from/USD/to/PHP/quantity/10

Feign
http://localhost:8100/v1/currency-conversion/feign/from/USD/to/PHP/quantity/10

Gateway:
Invalid after we implemented Routing as we removed other property file config
http://localhost:8765/currency-conversion-service/v1/currency-conversion/feign/from/USD/to/PHP/quantity/10

Routing
http://localhost:8765/v1/currency-conversion/feign/from/USD/to/PHP/quantity/10

## Distributed Tracing Add-ons
- Add 3 pom dependency libraries
```
		<dependency>
			<groupId>io.micrometer</groupId>
			<artifactId>micrometer-observation</artifactId>
		</dependency>
		<dependency>
			<groupId>io.micrometer</groupId>
			<artifactId>micrometer-tracing-bridge-otel</artifactId>
		</dependency>
		<dependency>
			<groupId>io.opentelemetry</groupId>
			<artifactId>opentelemetry-exporter-zipkin</artifactId>
		</dependency>
```
- Add the following to application properties to manage the amount of logs to display
```
management.tracing.sampling.probability=1.0
logging.pattern.level=%5p [${spring.application.name:},%X{traceId:-},%X{spanId:-}] #SB3
```
- Add extra configuration for feign
```
	<dependency>
  		<groupId>io.github.openfeign</groupId>
  		<artifactId>feign-micrometer</artifactId>
  	</dependency>
```
- Make the new RestTemplate to be Configuration for CurrencyConversion
```
@Configuration (proxyBeanMethods = false)
public class RestTemplateConfiguration {

    @Bean
    RestTemplate restTemplate (RestTemplateBuilder builder) {
        return builder.build();
    }
}
```
