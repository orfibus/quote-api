# Quote API Documentation

## Description

```Quote API``` is a sample project of a spring MVC rest api. The API is responsible for providing quotes of famous people upon request.
All quotes come from the zenquotes.io API. ```Quote API``` implements a small H2 in-memory database in order to demonstrate persistence capabilities, although this was not explicitly requested.

## Build instructions

To build the project you need to install the following dependencies:

- OpenJDK 1.8 or another Java 8 JDK
- Maven 3.x

### How to build from source

In order to build the API from source you must follow this steps:

1. Clone or download this git repository git clone https://github.com/orfibus/quote-api.git
2. Move into the downloaded API root folder and run ```mvn compile```
3. Finally, run ```mvn package``` to produce the final JAR file

### How to run the Quote API

In order to run the API you need to either build it from source or downloaded the jar file from Releases page on github.
To run the jar file you just need to use the command:

```java -jar quote-api-0.0.1-SNAPSHOT.jar``` if downloaded the release

OR

```java -jar target/quote-api-0.0.1-SNAPSHOT.jar``` if you built from source

When running the API listens at ```localhost``` and port ```8080```.

### How to make requests for quotes

After the API is set-up and running you can make requests to it. To make a request you simply need to hit the http://localhost:8080/quote URL.
You can do this via:
- Opening this URL on a browser.
- Using an application that sends HTTP Requests i.e. Postman
- Developing a custom application capable of sending HTTP Requests

