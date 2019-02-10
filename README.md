# Edureka-Microservices
#Day1
# Spring boot
It uses Tomcat server internally to override the default port you need to explicitly define port no as 
server.port=8081
# Swagger file 
Simple steps to configure swagger.
You need to configure the swagger file for your spring boot application. Simply create a class with SwaggerConfig and annotations @Configuration and @EnableSwagger2
Also, need to create a method stub with @Bean annotated 
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
For swagger ui go to localhost url/swagger-ui.html
# H2 Database
Set up H2 DB in your Intellij first. You need to download drivers for the first time setup. 
Then go to your localhost url/h2-console and login with sa user
In your application.properties file add
spring.h2.console.enabled=true

# Service Discovery
# Richardson Maturity Model final level
#Day2
Added spring data rest  for reducing the code for CRUD fuctionality.
Added spring fox data rest maven as 2.9 has bug for spring data rest.
We created new Eureka server and register all microservices in the
server. Also, tried to add some logic for load balancing using
@LoadBalanced which is handled by the each micro services, it is also
called as CSLB: Client Side Load Balancing, embedded in each
microservices which uses RIBBON ie. Round Robin algorithm for client
Requests. Also, discussed on Resilience and Chaos Monkey used to test
Resilience in Microservices.
