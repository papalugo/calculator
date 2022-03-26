# Instructions to run
 - git clone https://github.com/papalugo/calculator.git
 - cd calculator
 - mvn clean install

# Run RabbitMQ
- docker run -d -p 5672:5672 -p 15672:15672 --name my-rabbit rabbitmq:3-management
- username / password = guest / guest)
 
# Run REST module
 - java -jar rest/target/rest-1.0.0.jar

# Run CALC module
 - java -jar calc/target/calc-1.0.0.jar   

# Colletion Postman 
- You can import a collection postman to test it is in /Calculator.postman_collection.json project

#Arbitrary Precision
- 0 -> UP
- 1 -> DOWN;
- 2 -> CEILING;
- 3 -> FLOOR;
- 4 -> HALF_UP;
- 5 -> HALF_DOWN;
- 6 -> HALF_EVEN;
- 7 -> UNNECESSARY;

- In all calc operation is possible using an Arbitrary Precision, but is possible configure it in file application.properties at Rest module.
- Example using Arbitrary Precision: localhost:8080/api/calc/division?a=3.777&b=3&methodRound=1
 

