# Driver-car service

Simple JavaEE based web application, which can perform some of CRUD, and some other operations

## Functionality
### Authentication
Authentication with Driver as user

Registration by adding drivers

### Managing Entities:

Ability to add/remove Drivers, Cars and Manufacturers; Adding Driver replaces registration

Ability to display existent Drivers, Cars, Manufacturers

Ability to connect Driver to Car

Ability to display all Cars connected to authenticated Driver

## Deployed on Heroku | status: ![](https://heroku-status-badges.herokuapp.com/tranquil-wave-04624)

[link](https://tranquil-wave-04624.herokuapp.com/login)

## Project structure

### N-tier architecture

Project structure consists of 3 + db levels:
1. Preview level: packages taxi.controller, taxi.filter; jsp page resources <- HTTP requests handling
2. Business level: packages taxi.service, taxi.model <- On this stage, only calls dao level methods, contains model classes
3. Persistance level: package taxi.dao <- database manipulation
- MySql database

### DB Schema
![image](https://user-images.githubusercontent.com/26524991/202564948-0ca37bd8-0771-4291-9916-98645fbc288d.png)

## Technologies

[MySql](https://www.mysql.com) database; Instance, deployed on heroku, uses remote MySql db hosted on [freedb.tech](https://freedb.tech)

[Apache Maven](https://maven.apache.org) as building system

[Apache Tomcat](https://tomcat.apache.org) v9.0.68 as server

JavaEE as web framework (Javax servlet API v4.0.1)

[JSTL](https://mvnrepository.com/artifact/jstl/jstl)

[Apache Log4j2](https://logging.apache.org/log4j/2.x/) as logger

[Project Lombok](https://projectlombok.org)

[Junit5](https://junit.org/junit5/) for testing


