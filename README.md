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


## Connecting to Postgres DB using Docker:
```docker run --name postgres-spring -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres:alpine```
postgres-spring is the name used
-e is environment
-d is detached
-p is port mapping the generic 5432 to 5432
postgress:alpine is the smallest

Now you have a container running and exposting a port on 5432:
```docker ps```

```docker port postgres-spring```
shows you port 5432/tcp -> 0.0.0.0:5432
mapped to localhost

Bash into this container and create a db:
```docker exec -it b009f6217779 bin/bash```
-it for interactive
containerid - b009f6217779

To get inside the postgres shell:
```psql -U postgres```
-U is username
 
show list of DBs:
```\l```

Create the DB:
```CREATE DATABASE demodb;```

Connect to this db:
```\c demodb```

ssh into this box
