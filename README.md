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

H2-Console-url: jdbc:h2:mem:testdb

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

Day 3rd: Discussed on client server communication

Stateful: Sticky session- use load balancer and Session replication- to replicate each session to available instances
it limmits scability
Stateless: request itself contains all information. nothing stored in server or server doesnot store state of client. Handled by Authorization server which will act as gateway


Communication style:

one to one- only one consumer e.g queue one consumer for one message.
one to many- more than one consumer each receiver receives same message e.g Topic pub/sub model


API Gateway/Zuul Proxy: act as proxy server/url hiding/security
Actuator: it helps in managing endpoints localhost/actuator/routes to get all routing paths from api gateway

