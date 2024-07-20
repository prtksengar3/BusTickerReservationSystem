Ticket Reservation System
To setup the project create the following tables and update db credentials in application.properties

CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `buses` (
  `bus_id` int NOT NULL AUTO_INCREMENT,
  `bus_number` varchar(255) NOT NULL,
  `total_seats` int NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`bus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `routes` (
  `route_id` int NOT NULL AUTO_INCREMENT,
  `bus_id` int NOT NULL,
  `departure_city` varchar(100) NOT NULL,
  `arrival_city` varchar(100) NOT NULL,
  `departure_time` time NOT NULL,
  `arrival_time` time NOT NULL,
  `date` date NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `status` tinyint NOT NULL COMMENT '1->Active, 0-> Inactive',
  PRIMARY KEY (`route_id`),
  KEY `bus_id` (`bus_id`),
  CONSTRAINT `routes_ibfk_1` FOREIGN KEY (`bus_id`) REFERENCES `buses` (`bus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `reservations` (
  `reservation_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `bus_id` int NOT NULL,
  `seats` int NOT NULL,
  `reservation_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `status` tinyint DEFAULT NULL COMMENT '1-> Active, 0->Inactive, 2->Completed',
  `payment_via` varchar(255) NOT NULL,
  PRIMARY KEY (`reservation_id`),
  KEY `user_id` (`user_id`),
  KEY `bus_id` (`bus_id`),
  CONSTRAINT `reservations_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `reservations_ibfk_2` FOREIGN KEY (`bus_id`) REFERENCES `buses` (`bus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

REST API's for Use Case 1:

/login - Login Api
method type - POST

Request :
{
    "username": "prateek", // mandatory
    "password": "12345678" // mandatory
}
Response :
{
    "user_id": 1,
    "message": "success",
    "response_code": 1
}

REST API's for Use Case 2:

/getBusSchedule - API to get all bus schedules. By default it give all active buses on routes. We can also filter by arrival city,departure city and date.
method type - POST
Request :
{
    "arrival_city" : "Manali",
    "departure_city" : "Delhi",
    "date" : "2024-07-21"
}

Response :

{
    "message": "success",
    "response_code": 1,
    "bus_list": [
        {
            "bus_number": "HR26AM1234",
            "departure_city": "Delhi",
            "arrival_city": "Manali",
            "departure_time": "20:00:00",
            "arrival_time": "07:00:00",
            "date": "2024-07-21"
        }
    ]
}

REST API's for Use Case 3:

/getAvailableSeats?busId=1
method type - GET
Response
{
    "seats": 28,
    "message": "success",
    "response_code": 1
}

REST API's for Use Case 4:
/makeReservation
Request :
{
    "bus_id":1,
    "user_id":1,
    "seats":4,
    "payment_via":"credit_card"
}

Response :
{
    "reservation_id": 1,
    "message": "success",
    "response_code": 1
}


