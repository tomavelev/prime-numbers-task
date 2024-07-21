### Project - Create a Prime Number Selector

It is implemented with Micro Service architecture:

1) Spring Boot - Micro Services
2) Docker + Docker Compose
3) Writing the input and output to CSV Files
4) Connecting With RabbitMQ Message Queue

## Requirements

- Docker Compose
- Java 21
- Maven - Build and Dependency Management System

## After Download

You have the scripts to Build the producer and the consumer:

```
# in the producer directory

mvn clean package -Pproduction
docker build -t producer-service .

# in the consumer directory

mvn clean package -Pproduction
docker build -t consumer-service .

# finally - run the app
docker-compose up
```

### How the two Micro Service communicate?

I have put in place two ways of communication between them
- message queue rabbitmq 
- http requests (active out of the box)

There is some commented code needed if you want tn use message queue (it is not left-over or junk)


## Producer:
The producer generates a stream of random numbers (up to 5 numbers per second /
filled stream size of maximum 100 numbers) and sends them to the consumer. 
Also - it writes them down to a csv file so that the result can be verified against it.

## Consumer:
The consumer consumes the stream of random numbers and identifies prime numbers from it. 
The identified prime numbers are written to a csv file. 


### Side Notes

I've added two plugins on the consumer microservice that add 
- Code Coverage report
- Do Static Code Analysis

They are executed with 

```
mvn clean test
target/site/jococo/index.html
```

```
mvn clean verify spotbugs:check
```

