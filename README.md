# Spring framework RESTful Web API To do Lists

Demonstrates a simple RESTful web service using Spring framework and Java. This web service provides an in-memory order management service, with the capability to GET, PATCH, and POST. 


## Starting the Service
To start this web service, cd into RESTfulWebAPI, and execute the following command

    mvn spring-boot:run
    
Once the web service is started, it can be reached at

    http://localhost:8080/RESTfulWebAPI/todoList/

## Test
Under PostmanTests folder, there are three unit tests file for GET, POST and PATCH, one integration test file, these can be used in Postman. All cases passed. Because this service doesn't implement DELETE, it requires to restart the service when each test is finished.

## Incompelete implementation
The requirements for the POST is 
##### Done when an unsuccessful POST due to any reason returns an HTTP 400 status 
The service will only returns HTTP 400 status when there is already an exist to do list, it may have some other corner cases for this implement.
