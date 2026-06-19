 # 📄 Invoice Generator Web Application

A full-stack **Invoice Generator Web Application** developed using **React.js**, **Spring Boot**, and **MySQL**. The application enables users to create, calculate, save, view, print, and manage GST invoices with dynamic invoice items.

---

# 📌 Project Overview

The Invoice Generator Web Application simplifies the process of generating GST invoices by allowing users to enter company details, client details, shipping information, and multiple invoice items. The application automatically calculates GST (CGST & SGST), generates invoice totals, converts the total amount into words, and stores invoice records in a MySQL database.

---

# 🚀 Features

## Company Details

* Company Name
* GST Number
* Address
* Email
* Phone Number
* Bank Name
* Account Number
* IFSC Code
* Branch

## Client Details

* Client Name
* GST Number
* Address
* Email
* Phone Number

## Shipping Details

* Shipping Port
* Delivery Terms

## Invoice Features

* Auto Generated Invoice Number
* Invoice Date
* Dynamic Item Addition
* Dynamic Item Removal
* GST (CGST + SGST) Calculation
* Grand Total Calculation
* Amount in Words
* Save Invoice to Database
* View All Invoices
* View Single Invoice
* Print Invoice

---

# 🛠 Technologies Used

## Frontend

* React.js
* React Router DOM
* Axios
* HTML5
* CSS3

## Backend

* Java 21
* Spring Boot
* Spring Data JPA
* Hibernate
* Maven

## Database

* MySQL

## Tools

* IntelliJ IDEA
* Visual Studio Code
* Postman
* Git
* GitHub

---

# 📂 Project Structure

## Backend

```text
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
```

## Frontend

```text
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
```

---

# ⚙ Backend Setup

## 1. Clone the Repository

```bash
git clone https://github.com/amitrajbhar2306/Invoice-Generator.git
```

## 2. Navigate to Backend

```bash
cd invoice-generator
```

## 3. Create MySQL Database

```sql
CREATE DATABASE invoice_generator;
```

## 4. Configure Database

Update your `application.properties` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/invoice_generator
spring.datasource.username=root
spring.datasource.password=User@123

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## 5. Run Backend

```bash
mvn spring-boot:run
```

Backend Server:

```text
http://localhost:8080
```

---

# 💻 Frontend Setup

Navigate to the frontend project:

```bash
cd invoice-frontend
```

Install dependencies:

```bash
npm install
```

Run the application:

```bash
npm run dev
```

Frontend Server:

```text
http://localhost:5173
```

---

# 📡 REST API Endpoints

## Company APIs

| Method | Endpoint            |
| ------ | ------------------- |
| POST   | `/api/company`      |
| GET    | `/api/company`      |
| GET    | `/api/company/{id}` |
| PUT    | `/api/company/{id}` |
| DELETE | `/api/company/{id}` |

## Invoice APIs

| Method | Endpoint             |
| ------ | -------------------- |
| POST   | `/api/invoices`      |
| GET    | `/api/invoices`      |
| GET    | `/api/invoices/{id}` |
| DELETE | `/api/invoices/{id}` |

---

# 🗄 Database

### Database Name

```text
invoice_generator
```

### Tables

* company
* invoice
* invoice_item

---

# 📷 Screenshots


---

# ▶️ How to Use

1. Start the Spring Boot backend.
2. Start the React frontend.
3. Open `http://localhost:5173`.
4. Enter Company Details.
5. Enter Client Details.
6. Enter Shipping Details.
7. Add one or more Invoice Items.
8. Click **Save Invoice**.
9. View all invoices.
10. Open any invoice.
11. Print the invoice.

---

# 🌟 Future Enhancements

* User Authentication
* Dashboard
* PDF Download
* Email Invoice
* Search Invoice
* Update Invoice
* Company Logo Upload

---

# 👨‍💻 Author

**Amit Rajbhar**

