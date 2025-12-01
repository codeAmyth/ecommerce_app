# 🛒 E-Commerce Backend (Spring Boot)

A production-ready E-Commerce backend built using **Spring Boot**, following clean architecture, modular design, and industry-standard practices.  
Includes authentication, product management, cart, orders, payments, and admin controls.

---

## 🚀 Features

- User Registration & Login (JWT Authentication)
- Product Management (CRUD + Search + Filters)
- Category & Inventory Management
- Cart & Wishlist APIs
- Order Placement & Tracking
- Payment Integration (Dummy / Razorpay)
- Role-based Access (User/Admin)
- Global Exception Handling
- API Documentation using Swagger / Springdoc OpenAPI

---

## 🛠️ Tech Stack

- **Java 17+**
- **Spring Boot 3+**
- Spring Web
- Spring Data JPA + Hibernate
- MySQL / PostgreSQL
- Spring Security (JWT)
- Lombok
- Maven
- Swagger / OpenAPI
- Docker (optional)

---

## 📁 Project Structure
src/main/java/com/example/ecommerce
│
├── config/ # Security & Swagger config
├── controller/ # REST controllers
├── dto/ # Request/Response DTOs
├── entity/ # JPA entities
├── repository/ # JPA repositories
├── service/ # Business logic
├── exception/ # Custom exceptions & handlers
└── util/ # Helper classes
## ⚙️ Setup Instructions (Local)

### **1. Clone the repository**
```bash
git clone https://github.com/codeAmyth/ecommerce_app.git
cd ecommerce_app

 2. Update MySQL credentials

Inside application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
spring.datasource.username=root
spring.datasource.password=your_password

3. Run the project
mvn spring-boot:run

📘 API Documentation (Swagger)

Once the application is running, open:

http://localhost:8080/swagger-ui/index.html

🤝 Contributing

Feel free to open issues or submit pull requests.

📄 License

This project is licensed under the MIT License.

👤 Author

Divyanshu Amit
Java Backend Developer
GitHub: https://github.com/
codeAmyth
