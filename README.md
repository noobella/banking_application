# banking-application

This project contains a Spring Boot Web app for an online banking app. Its functionalities include:
- Allowing users to create user accounts, login and make multiple bank accounts (current or savings)
- Adding and withdrawing funds into bank accounts
- Setting overdraft limits to current account which can't be exceeded
- Viewing account transactions through REST API endpoints

Before you run this project, please refer to the following requirements below:

 - Eclipse v4.26.0 
 - JavaSE-17

To run this project:

 1. Change `spring.datasource.password` and `spring.datasource.username` to your own details found in 
`banking_app\banking-application-noobella\banking-app\src\main\resources\application.properties`
 2. When initially running, change `spring.jpa.hibernate.ddl-auto=update` to `spring.jpa.hibernate.ddl-auto=create`
 3. Using Eclipse, run the project using 'Spring Boot App' option
 3. Access web app via `http://localhost:8080/`

