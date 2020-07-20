# Reg Whitton's solution to DWP online test

## Setup and Build

### Java 8

You will need to have the Java 8 JDK (or higher) installed.  Check by typing the following into the command line:

    $ java -version
    java version "1.8.0_202"
    Java(TM) SE Runtime Environment (build 1.8.0_202-b08)
    Java HotSpot(TM) 64-Bit Server VM (build 25.202-b08, mixed mode)
    
    $ javac -version
    javac 1.8.0_202

If these are not found or show a version lower than 1.8 then download and install the latest Java 8 JDK from [Oracle](https://www.oracle.com/technetwork/java/javase/downloads/index.html).

Once installed, the directory containing java should have been added to your PATH environment variable, so that the above `java` and `javac` commands will work from the command line. 

### Building and starting the server from the command line

    cd path/to/this/dir
    mvnw package            (./mvnw - if using bash)
    mvnw spring-boot:run    (Use Control-C or task-manager to stop)
    
Browse to <http://localhost:8080/swagger-ui/> expand the controller and "Try it out".

## Running in an IDE

This project uses Lombok to insert getters, setters and other boiler plate code during runtime.  As a consequence the raw code will show compilation errors in an IDE such as Eclipse, IntelliJ or Netbeans.

To avoid this use the Lombok plugin go to <https://projectlombok.org/> and select the installation instructions for your IDE from the "Install" menu.

## Architecture

### Spring-Webflux

I have chosen to use Spring-Webflux and Spring-Boot to solve this test.
In a high volume service, Webflux should stream the results from the onward ReST source without blocking and using less threads and memory. 

A more traditional Spring-MVC would have required broadly similar code.