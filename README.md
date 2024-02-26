This is a microservice based demo where we have different services like UserService,HotelService,RatingService.We have serviceRegistry where all the other services are registered.It keeps the track of all the other services.Api Gateway to route traffic to different services based on the incoming request.Config server to keep the configuration properties externally.

Softwares Needed:
1)IDE
2)MySQL
3)Postman(Optional)

1)Download all the projects.
2)Run ServiceRegistry at http://localhost:8761/
3)Start ConfigServer
4)Start UserService-http://localhost:8081/swagger-ui/
5)HotelServcie-http://localhost:8082/swagger-ui/
6)RatingService-http://localhost:8083/swagger-ui/

A)USerService APIs:
i)​CreateUser-/users
ii)getUserById-/users/{userId}
iii)getAllUsers-/users

B)HotelService APIs:
i)CreateHotel-​/hotels
ii)getHotel-​/hotels​/{id}
iii)getAllHotels-/hotels

C)RatingService APIs:
i)createRating-/ratings
ii)getRatingByUserId-​/ratings​/users​/{userId}
iii)getRatingByHotelId-/ratings/hotels/{hotelId}





