# Spring Prices API

Developed using Maven, Spring Boot, and Java, an API that allows to obtain the price of a product.


An example of use of the API to obtain the price of a product (use Postman or similar):
```
curl --location 'http://localhost:8080/api/prices?applicationDate=2020-06-14T10:00:00&productId=35455&brandId=1' \
--data ''
```

- Documentation with Swagger: [http://localhost:8080/doc/priceservice/swagger-ui/index.html](http://localhost:8080/doc/priceservice/swagger-ui/index.html)

To execute with Docker:
1. Navigate to the directory where the Dockerfile is located.
2. Build the Docker image:
    ```
    docker build -t spring-boot-price-service:spring-price-service .
    ```
3. (Optional) Clean up all unused Docker resources:
    ```
    docker system prune -a 
    ```
4. Run the Docker container:
    ```
    docker run -p 8080:8080 spring-boot-price-service:spring-price-service
    ```

