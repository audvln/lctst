# Test solution for JSON API with Spring Boot

API when run is accessible on port 8080 root context e.g. http://localhost:8080/
There are two precreated users in inmemory security provider user:password (role USER) and admin:password (role ADMIN,USER). Only admin have access to update user, restaurant and menuitem objects.

## Objects

### User

#### Properties
id - integer
name - string
role - string (unused), intended for Spring security provider e.g. JDBC

#### Methods
POST /users, PUT /users/{id}, DELETE /users/{$id}, GET

### User

#### Properties
id - integer
name - string
role - string (unused), intended for Spring security provider e.g. JDBC

#### Methods
POST /users, PUT /users/{id}, DELETE /users/{$id}, GET

### Restaurant

#### Properties
id - integer
name - string
menuItemCollection - collection of menuItem objects (only with GET to). Intended to retrieve restaurants and items  with single request

#### Methods
POST /restaurants, PUT /restaurants/{id}, DELETE /restaurants/{$id}, GET /restautants(full list), GET /restautants?q=today (includes only today active menu items)

### MenuItem

#### Properties
id - integer
description - string
date - date when item is active or null meaning always active 
price - integer (kinda currency)
restaurant - integer id of restaurant object

#### Methods
POST /menuitems, PUT /menuitems/{id}, DELETE /menuitems/{$id}, GET /menuitems 

### Vote

#### Properties
user - integer id of voting user
date - date last voted, only current date votes are accounted in summary
restaurant - integer id of restaurant object


#### Methods
POST /votes, PUT /votes (identical to POST. both take user from security and put current date) , GET /votes?q=summary

## Installation
Then you can run Maven to package the application:
```
mvn clean package
```

Now you can run the Java application quite easily:
```
cd target
java -jar lctst-1.0.0.jar
```

## Sample requests

curl -H "Content-Type: application/json" -X POST -d "{\"restaurantId\": 2 } }" --basic --user useris:password http://localhost:8080/votes
curl -H "Content-Type: application/json" --basic --user useris:password http://localhost:8080/votes
curl -H "Content-Type: application/json" --basic --user useris:password http://localhost:8080/votes?q=summary
curl -H "Content-Type: application/json" -X POST -d "{\"name\": \"busi trecias\" } }" --basic --user admin:password http://localhost:8080/restaurants
curl -H "Content-Type: application/json" --basic --user useris:password http://localhost:8080/restaurants
curl -H "Content-Type: application/json" -X PUT -d "{\"name\": \"trecias\" } }" --basic --user admin:password http://localhost:8080/restaurants/3
curl -H "Content-Type: application/json" -X DELETE --basic --user admin:password http://localhost:8080/restaurants/3

curl -H "Content-Type: application/json" -X POST -d "{\"description\": \"cepai\", \"price\": 12, \"restaurant\": 2 } }" --basic --user admin:password http://localhost:8080/menuitems
curl -H "Content-Type: application/json" -X PUT -d "{\"description\": \"cepelinai\", \"price\": 12, \"restaurant\": 2 }" --basic --user admin:password http://localhost:8080/menuitems/4
curl -H "Content-Type: application/json" -X DELETE --basic --user admin:password http://localhost:8080/menuitems/3

curl -H "Content-Type: application/json" -X POST -d "{\"name\": \"vardas\", \"role\" : \"USER\" } }" --basic --user admin:password http://localhost:8080/users
curl -H "Content-Type: application/json" -X PUT -d "{\"name\": \"vardasas\", \"role\" : \"USER\" } }" --basic --user admin:password http://localhost:8080/users/3
curl -H "Content-Type: application/json" -X DELETE --basic --user admin:password http://localhost:8080/users/3
