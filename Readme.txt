This solution was made with Java(Spring Boot), and is managed with Maven. 

The way to start the application is to install all dependencies from pom.xml file with:

./mvnw package (from the main directory) or mvn package

And then to start the application:

./mvnw spring-boot:run 

The REST API listens on port 8080 by default.
Application has predefined in-memory H2 "database" with some users which is loaded on start.

Endpoint for services:

POST - "/services/" (No authorization needed)
Query params:
    timezone: timezone of the user
    userId: string id of the user
    cc: country code of the user
Response contains information about enabled services in json format:
    Sample json:  {“multiplayer”: “enabled”, ”user-support”: “disabled”, “ads”: “enabled”},
If userId does not exists in database, all services are disabled.

Endpoints for admin users (username: "admin", password: "password", Basic Auth)

GET - "/admin/users/" 
Response contains list of all userId's.

GET - "/admin/users/{userId}" 
Response contains details about one user in json format: 
{
    "userId": "frodo",
    "name": "Frodo",
    "last_name": "Baggins",
    "e_mail": "frodo.baggins@gmail.com",
    "experience": 0
}

POST - "/admin/users/" (Create new user - used for testing)
Request body (application/json) : 
{
    "userId": "frodo",
    "name": "Frodo",
    "last_name": "Baggins",
    "e_mail": "frodo.baggins@gmail.com"
}

DELETE "/admin/users/{userId}"
Response status 200 if user is deleted, otherwise 500