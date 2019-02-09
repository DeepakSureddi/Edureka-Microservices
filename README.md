# Edureka-Microservices
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
