# Welcome to EmployeeStatus Service

## Current version 1.0.0

## Microservice purpose:
This microservice helps to get employee status.

## ROUTES
- http://localhost:8098/
- **EUREKA SERVICE NAME**: EMPSTATUS
## Currently supported APIs:
- /empstatus/info
- /empstatus/all
- /empstatus/getstatus/{employeeId}
- /empstatus/updatestatus/{employeeId}/{newStatus}
- /empstatus/delete/{employeeId}
- /empstatus/add?employeeId={employeeId}&newStatus={newStatus}

## Message formats and error handling
This microservice uses JSON for all input and output messages.
It uses GET/PUT/DELETE methods.

## Sample input and output

- /empstatus/getstatus/{employeeId}

Method: GET

**Input JSON:**
------------------------------------------------------------------
~~~
{
    "employeeId": "11111"
}
~~~
------------------------------------------------------------------

**Output JSON:**
------------------------------------------------------------------
~~~
{
    "employeeId": "11111"
    "empStatus":  "Active"
}
~~~
------------------------------------------------------------------

**Error JSON:**
------------------------------------------------------------------
~~~
{
    "employeeId": "11111"
    "empStatus": "NOT_FOUND"
}
~~~
------------------------------------------------------------------

### Guides
The following guides illustrates how to use certain features correctly:

* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
