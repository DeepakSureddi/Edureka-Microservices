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


#Day 4
Transaction Management:
Issue: If one transaction is not completed the dependent transaction will be rolled back. (when write transactions)

Solution:
1.	Every transaction as single synchronous commit. 
2.	One microservice will be primary handler for the transaction. (It will make asynchronous call to all places, it plays a role like a commander. Microservices makes changes without commit and sent back acknowledgement and primary handler send the commit command if it receives acknowledgement from all microservices.) It is also called as two phase commit. If no successful acknowledgement, then it will send rollback but prior to that it will also make retries.
3.	Idempontence: Eventual committing. End result should be same. Use message JMS/Broker for all transaction. 
4.	SAGA Pattern: Mostly used and efficient solution. 
Go to here to learn about it:
https://microservices.io/patterns/data/saga.html
https://martinfowler.com/articles/201701-event-driven.html
https://www.slideshare.net/arafkarsh/microservices-architecture-part-2-event-sourcing-and-saga

Two problems:
a.	Business Failure: We don’t do retry. E.g. Insufficient fund
b.	Technical Failure: We do retry. E.g. Network failure. Three retries done.

#ActiveMQ


ActivMQ:
http://activemq.apache.org/download.html
goto activemq extracted bin folder--> activmq start
for mac start command: ./activemq start and you will get follwing info:

INFO: Loading '/Users/apiltiwari/Downloads/apache-activemq-5.15.8//bin/env'
INFO: Using java '/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/bin/java'
INFO: Starting - inspect logfiles specified in logging.properties and log4j.properties to get details
INFO: pidfile created : '/Users/apiltiwari/Downloads/apache-activemq-5.15.8//data/activemq.pid' (pid '17189')


http://127.0.0.1:8161/admin
username: admin
password: admin

once commandms deployed goto http://localhost:8989/messages/<your message here> This message will be queued in commandms to be send to activemq_1 and activemq_2. Once they are  up they will listen to the message and will be dequeued/comsumed by receiver activemqs.

DDD(Domain Driven Development)
Context: Different module in your application which will map to each microservices. It is general description of group of concepts. 
Attached some screenshots in Screenshots package. 

#Hystrix: When one of your microservices is down Hystrix will play a role as circuit breaker pattern. It makes your service calls more resilient by keeping track of each endpoint’s status. Normally, when you face expensive request timeouts when an endpoint becomes unavailable. It saves you from such timeouts by “breaking” the connection to the endpoint (this is why Hystrix is called a “circuit breaker”). It then reports that the service as unavailable so that subsequent requests don’t run into the same timeouts. Hystrix then continues to poll the service in the background to see when it’s available again. (But generally the service will be up within 15-20 mins due to automated system.)


Database design Recall:
Three types of design:
a.	Single DB Single Schema different Tables
b.	Single DB different Schema
c.	Different DB 
Aggregator- Here join on tables are done in microservice level. It will get data from all micorservices required and combines and return the result. 

Moving from Monolith to Microservices
a.	Big Bang (From Day 1: Never go for this approach)
b.	Gradual (Netflix is one successful big company to use this approach)

How will you not break the contract between the services?
(No code share but share a contract)
(*Create view object as immutable which is read only and client who access it cannot modify. It can be versioned. Client can choose which version to use. The Microservice should support backward compatibility if it is versioned)

