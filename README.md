# challenge-slingr-math

## Math web services
The requirement is to build a public RESTful API that allows to solve math expressions. So given a math expression a number is returned as a response.

###### The first service will use a GET as the method and you can set the following parameters:

- expression: math expression to be evaluated.
- precision: number of significant digits in formatted output. It is optional.

###### The second available service will use a POST as the method and it is possible to set the following fields in the payload:
- expression: math expression to be evaluated.
- precision: number of significant digits in formatted output. It is optional.

###### The next expressions are samples for the input of the services:
- 2*(7-3)
- 1.2 * (2 + 4.5)
- 2+3*sqrt(4)

### Requirements:
Share the code in a public repository in github.
Host the API in a free cloud service (like AWS, GCP, Cloud Foundry, etc) and remember to share API URLs.


### Resolution

#### Technologies

- Microservices Architecture
- Java 11
- Maven
- Spring Boot
- Docker
- AWS - EC2


#### Login Service
http://ec2-3-128-76-174.us-east-2.compute.amazonaws.com:8081/swagger-ui.html

```shell
curl -X POST "http://ec2-3-128-76-174.us-east-2.compute.amazonaws.com:8081/login" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"pwd\": \"admin\", \"username\": \"admin\"}"
```

Default user Admin
```json
{
  "username":"admin",
  "pwd": "admin"
}
```

#### Expression Service
http://ec2-3-128-76-174.us-east-2.compute.amazonaws.com/swagger-ui.html


Remplace "token" by Beaver + JWT

```shell
curl -X GET "http://ec2-3-128-76-174.us-east-2.compute.amazonaws.com/expressions?expression=2*(7-3)&precision=2" -H "accept: application/json" -H "Authorization: token"
```


```shell
curl -X POST "http://ec2-3-128-76-174.us-east-2.compute.amazonaws.com/expressions" -H "accept: application/json" -H "Authorization: token" -H "Content-Type: application/json" -d "{ \"expression\": \"2+3*sqrt(4)\", \"precision\": 3}"
```

You can run the application locally with Docker on Linux

```shell
bash deploy.sh
```

If you need to run app on IDE. Requires to install challenge-slinger-math-common dependency on local maven with command

```shell
cd challenge-slingr-math-common
mvn install
```
