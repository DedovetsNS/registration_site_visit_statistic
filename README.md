# Application for recording and tracking the number of site visitors  

#### The application allows you to keep track of site visitors

### EndPoints
/statistic/[POST] - for registration new visits. Input data in JSON format, ID of the user and the page he visited.
Example: 
>  {
>   "userId": "2",
>   "pageId": "1"
>  }
           
Response - total number of visitors per day and unique one.

/statistic/[GET] - to get statistics for the period. Input data in JSON format, two dates indicating the time period in format "dd-MM-yyyy HH:mm:ss".
Example: 
>  {
>    "dateFrom": "25-03-2020 08:11:53",
>    "dateTo": "27-03-2020 08:11:53"
>   }

Response - total number of visitors per period, unique one and number of regular users(who visited more than 10 pages per period).

### Used technologies
Java 11, Spring Boot, PostgresQL, Spring Data, REST Api, Git, Gradle, Lombok, RabbitMQ, Flyway.

### How to start
* Annotation processor should be enabled in Intellij IDEA settings.
* Set up database
    * install Postresql on your PC
    * choose DB port 5432 or leave it as default
    * set up `spring.datasource.username` and `spring.datasource.password` as postgres and 0123456kKk OR change according fields in      properties file if you want to set other ones
create database statistic in postresql
* Set up message broker RabbitMQ
     * install RabbitMQ on your PC
     * choose RabbitMQ port 5672 or leave it as default
     * run RabbitMQ server
