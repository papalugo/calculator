# Instructions to run


#Arbitrary Precision
- 0 -> UP
- 1 -> DOWN;
- 2 -> CEILING;
- 3 -> FLOOR;
- 4 -> HALF_UP;
- 5 -> HALF_DOWN;
- 6 -> HALF_EVEN;
- 7 -> UNNECESSARY;


#RebbitMQ
- docker run -d -p 5672:5672 -p 15672:15672 --name my-rabbit rabbitmq:3-management

- (username / password = guest / guest)