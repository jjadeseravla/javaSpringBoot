# Springboot Java REST App

Spring Boot is an amazing framework for building Java applications. It makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".

REST Api with a DAO to separate the different layers of code and be able to change DBs efficiently without changing other layer of code
and also including a fake DB to use too. 

Amigoscode Tutorial followed: https://www.youtube.com/watch?v=vtPkZShrvXQ


## To Run:
Navigate to targets folder (if not there, go to maven menu and press install to generate one).

``` $ java -jar demo-0.0.1-SNAPSHOT.jar```
This starts the server tomcat on port 8080.
Navigate to ```localhost:8080/api/v1/person```
to see a JSON that you can consume and distribute it.
