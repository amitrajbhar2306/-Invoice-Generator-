

Invoice Generator Web Application
📌 Project Overview

The Invoice Generator Web Application is a full-stack web application developed 
using React.js, Spring Boot, and MySQL. It enables users to create, calculate, save,
view, print, and manage GST invoices with dynamic invoice items.

  Features
  
Company Details
Company Name
GST Number
Address
Email
Phone Number
Bank Name
Account Number
IFSC Code
Branch

Client Details

Client Name
GST Number
Address
Email
Phone Number

Shipping Details

Shipping Port
Delivery Terms

Invoice

Auto Generated Invoice Number
Invoice Date
Dynamic Item Addition/Removal
GST (CGST + SGST) Calculation
Grand Total Calculation
Amount in Words
Save Invoice to Database
View All Invoices
View Single Invoice
Print Invoice

 Technologies Used

Frontend

React.js
React Router DOM
Axios
HTML5
CSS3

Backend

Java 21
Spring Boot
Spring Data JPA
Hibernate
Maven

Database

MySQL

Tools

IntelliJ IDEA
Visual Studio Code
Postman
Git & GitHub


📂 Project Structure

Backend
invoice-generator
│
├── controller
├── dto
├── entity
├── repository
├── service
├── serviceImpl
├── config
├── util
└── exception


Frontend

invoice-frontend
│
├── src
│   ├── api
│   ├── components
│   ├── css
│   ├── pages
│   ├── services
│   ├── App.jsx
│   └── main.jsx


Create a MySQL database:

CREATE DATABASE invoice_generator;

Update application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/invoice_generator
spring.datasource.username=root
spring.datasource.password=User@123

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

Run Backend
mvn spring-boot:run

Backend runs on

http://localhost:8080


💻 Frontend Setup

Navigate to frontend folder

cd invoice-frontend

Install dependencies

npm install

Run React

npm run dev

Frontend runs on

http://localhost:5173


📡 REST API Endpoints
Company
Method	Endpoint
POST	/api/company
GET	/api/company
GET	/api/company/{id}
PUT	/api/company/{id}
DELETE	/api/company/{id}

Invoice
Method	Endpoint
POST	/api/invoices
GET	/api/invoices
GET	/api/invoices/{id}
DELETE	/api/invoices/{id}


📷 Screenshots

 
 Database

Database Name
invoice_generator

Tables

company
invoice
invoice_item


▶️ How to Use
Open the application.
Enter Company Details.
Enter Client Details.
Add Shipping Details.
Add one or more Invoice Items.
Click Save Invoice.
View all invoices.
Open an invoice.
Print the invoice.

 
👨‍💻 Author
Amit Rajbhar
