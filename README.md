**🚀 Features**

User registration and login

JWT-based authentication and authorization

Secure password hashing

MySQL database integration

RESTful API endpoints

Role-based access control

Exception handling and validation

**Technologies Used**

Java 17

Spring Boot

Spring Security

MySQL

JWT (JSON Web Token)

Maven 

Hibernate / JPA

**Project Structure**

src/main/java/com/example/project
│
├── controller     # REST controllers
├── service        # Business logic
├── repository     # Database access layer
├── model          # Entity classes
├── security       # JWT & security configuration
└── config         # Application configuration

**Clone the repository**

git clone https://github.com/your-username/project-name.git

**Update application.properties**
spring.datasource.url=jdbc:mysql://localhost:3306/project_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

**running the application**
mvn spring-boot:run

**The server will start on:**
http://localhost:7888/hit/api
