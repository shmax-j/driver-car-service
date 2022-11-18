# :car: Driver-car service

Simple JavaEE based web application, which can perform some of CRUD, and some other operations 

<details>
  <summary> <h4> Table of Contents </h4>  </summary>
    <ul>
        <li><a href="#wrench-functionality">Features</a></li>
        <li><a href="#-deployed-on-heroku--status-">Deploy</a></li>
        <li><a href="#blue_book-project-structure">Project stucture</a></li>
        <li><a href="#-technologies">Technologies</a></li>
        <li><a href="#-setup-guide">SetUp guide</a></li>
    </ul>
</details>

## :wrench: Functionality
### Authentication
Authentication with Driver as user

Registration by adding drivers

### Entity management:

Ability to add/remove Drivers, Cars and Manufacturers; Adding Driver replaces registration

Ability to display existent Drivers, Cars, Manufacturers

Ability to connect Driver to Car

Ability to display all Cars connected to authenticated Driver

## ![](https://img.icons8.com/windows/38/heroku.png) Deployed on Heroku | status: ![](https://heroku-status-badges.herokuapp.com/tranquil-wave-04624)

[link](https://tranquil-wave-04624.herokuapp.com/login)

## :blue_book: Project structure

### N-tier architecture

Project structure consists of 3 + db levels:
1. Preview level: packages taxi.controller, taxi.filter; jsp page resources <- HTTP requests handling
2. Business level: packages taxi.service, taxi.model <- On this stage, only calls dao level methods, contains model classes
3. Persistance level: package taxi.dao <- database manipulation
- MySql database

### DB Schema
![image](https://user-images.githubusercontent.com/26524991/202564948-0ca37bd8-0771-4291-9916-98645fbc288d.png)

## ⚙ Technologies

### Database

- [MySql](https://www.mysql.com) database; Instance, deployed on heroku, uses remote MySql db hosted on [freedb.tech](https://freedb.tech)

- JDBC with [MySql connector](https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.22) driver

### Web

- [Apache Tomcat](https://tomcat.apache.org) v9.0.68 as servlet context / server

- JavaEE as web framework | [Javax servlet API v4.0.1](https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api/4.0.1)

- [JSTL](https://mvnrepository.com/artifact/jstl/jstl) <- Tag library for jsp pages

- Heroku [webapp-runner](https://elements.heroku.com/buildpacks/heroku/webapp-runner) as launcher

### Testing

- [Junit5](https://junit.org/junit5/) for testing

### Etc

- [Apache Maven](https://maven.apache.org) as building system

- [Apache Log4j2](https://logging.apache.org/log4j/2.x/) as logger

- [Project Lombok](https://projectlombok.org)

- IntellyJ IDEA as IDE

## 🦮 SetUp guide

### Prerequisites

You must have JDK at least 11 version, and maven installed to build and launch the application, and Git to clone repository. Since it have Heroku webapp-runner as dependency, you should install Tomcat only if you want to launch it from IDE. Also you should install MySql with Workbench and CLI to create MySql database, or use another solution like remote MySql repository services. 

- [JDK installation instruction for Windows](https://access.redhat.com/documentation/en-us/openjdk/11/html-single/installing_and_using_openjdk_11_for_windows/index)
- [Maven installation instruction](https://maven.apache.org/install.html)
- [Tomcat installation instruction](http://www.yorku.ca/jhuang/examples/tomcat-install.html)
- [MySql installation guide](https://dev.mysql.com/doc/mysql-installation-excerpt/5.7/en/)

### Initializing DB

Launch MySql Workbench and [create new db connection](https://dev.mysql.com/doc/workbench/en/wb-getting-started-tutorial-create-connection.html). Remember connection related parameters such as hostname/port, username and password as it will be needed when we configure connection to this db in the application.
Using [sql query tool](https://www.youtube.com/watch?v=M-OXq10Tj-E&ab_channel=GeekyShows) run [this](/src/main/resources/init_db.sql) SQL script to initialize db. This will create db schema that uses in this app.

### Configuring application

Clone repository using Git CLI or IDE. In `src/main/resources` create new file `app.properties` and fill it with your db parameters, as in example:(without {} braces):

    db.url=jdbc:mysql://{Your db host(localhost if you have local db instance)}:{DB port}/{Schema name(taxi if init_db.sql were used)}?serverTimezone={Your timezone(UTC for example)}
    db.username={The username used to create the conection}
    db.password={The password used to create the conection}
    db.driver-path=com.mysql.cj.jdbc.Driver

### Manual launching | using heroku webapp-runner

After your project configured, you can build it with maven and run with webapp-runner. For this:

1. In project directory run `mvn clean package` - this will download dependencies, build app, and run tests
2. When you have `BUILD SUCCESSFUL` run `java -jar target/dependency/webapp-runner.jar target/*.war` - this will run your builded .war archive on tomcat on localhost:8080
3. Test your build: go to he http://localhost:8080/ - You should see login page

### Running with IDE | using IntellyJ IDEA Ultimate

*You should have Tomcat installed*

[tutorial](https://mkyong.com/intellij/intellij-idea-run-debug-web-application-on-tomcat/)


