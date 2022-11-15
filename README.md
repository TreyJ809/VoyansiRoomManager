# VoyansiRoomManager
Sample Room Manager API for Voyansi

```
NOT currently deployed or running
```

Build JAR

```
mvn clean package spring-boot:repackage
```

Run JAR

```
java -jar target\VoyansiRoomManager-1.0-SNAPSHOT.jar
```

GET request URL (get list of all rooms and details)

```
http://voyansiroommanagerbeanstalk-env-1.eba-7hq2gey4.us-east-1.elasticbeanstalk.com/api/rooms
```

Sample POST request (createRoom) via Curl

```
curl -H "Content-type:application/json"  -d "{\"id\" : \"newRoomId\", \"name\" : \"insertRoomName\", \"number\" : \"insertRoomNumber\", \"occupant\" : \"insertOccupant\"}" http://voyansiroommanagerbeanstalk-env-1.eba-7hq2gey4.us-east-1.elasticbeanstalk.com/api/createRoom
```

Sample PUT request (updateRoom) via Curl

```
curl -X PUT -H "Content-type:application/json"  -d "{\"id\" : \"insertRoomId\", \"occupant\" : \"newOccupant\"}" http://voyansiroommanagerbeanstalk-env-1.eba-7hq2gey4.us-east-1.elasticbeanstalk.com/api/updateRoom
```

Sample DELETE request (deleteRoom) via Curl

```
curl -X DELETE http://voyansiroommanagerbeanstalk-env-1.eba-7hq2gey4.us-east-1.elasticbeanstalk.com/api/deleteRoom  -H "Content-type:application/json" -d "{\"id\" : \"insertRoomId\"}"
```

Build and run with Docker Compose

```
docker-compose build
docker-compose up
```

Note that the application needs to be set to Port 5000 because AWS Elastic Beanstalk uses Nginx webserver that forwards requests to port 5000. Adding the following to the Elastic Beanstalk configurations sets the port as needed.

```
Name = SERVER_PORT : Value 5000
```

Alternatively the Port can be set in the application properties file
