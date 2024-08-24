# MakeSharks Supplier API

This project is a Spring Boot application that provides an API for querying supplier information.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java 11 or higher
- Maven
- Your favorite IDE (IntelliJ IDEA, Eclipse, etc.)

### Installing

1. Clone the repository
2.  Navigate to the project directory:cd makesharks-api
3.   Build the project:mvn clean install
4.   Run the application:Run the application:
   The application should now be running on `http://localhost:9090`.

## API Usage

### Query Suppliers

To query suppliers, use the following curl command:

```
curl -X POST http://localhost:9090/api/supplier/query \
-H "Content-Type: application/json" \
-d '{
 "location": "India",
 "natureOfBusiness": "LARGE_SCALE",
 "manufacturingProcess": "MOULDING",
 "page": 1,
 "size": 20
}'
This will return a JSON response with a list of suppliers matching the given criteria, along with pagination information.
```



