# VoyansiRoomManager
Sample Room Manager API for Voyansi


Build JAR

```
mvn clean package spring-boot:repackage
```

Run JAR

```
java -jar target\VoyansiRoomManager-1.0-SNAPSHOT.jar
```

Sample POST request (createRoom) via Curl

```
curl -H "Content-type:application/json"  -d "{\"id\" : \"insertRoomId\", \"name\" : \"insertRoomName\", \"number\" : \"insertRoomNumber\", \"occupant\" : \"insertOccupant\"}" http://localhost:8080/api/createRoom
```

Build and run with Docker Compose

```
docker-compose build
docker-compose up
```