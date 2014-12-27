javaws
======

Java contract first web service example (SOAP)
-----------

### Instalation Guide

* Install Java jdk 1.7
* Install Maven 3.x
* Set environment variable JAVA_HOME
* Set environment variable MAVEN_HOME
* Put JAVA_HOME\bin and MAVEN_HOME\bin on environment variable Path
* Clone application: git clone https://github.com/thiagoprocaci/javaws.git
* Execute "mvn install" on project root folder
* Execute "mvn tomcat6:run -P tomcat" on root folder to run the application
* Go to http://localhost:8080/javaws/person.svc

### Instructions

* All entities exposed by Soap web service are defined at Domain.xsd and Elements.xsd.
* Elements.xsd contains the entities related to the http request and response.
* Domain.xsd contains the entities related to the model that we want to expose via web service.
* Person.wsdl defines the web service interface (PersonInterface).
* Class PersonSoap is the endpoint. It implements PersonInterface.
* PersonRepository is our mock database.






