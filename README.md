# URL

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

