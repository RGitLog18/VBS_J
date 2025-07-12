# 🏦 Virtual Banking System

A **Java Swing Desktop Application** to simulate core banking operations. It allows users to securely manage their accounts and lets administrators oversee system activity.  

---

## ✨ Features

- 👥 **Three User Roles:**
  - **Admin**
    - View credentials of all users.
    - Monitor banking operations.
  - **Existing User**
    - Login and manage account.
    - Transfer, withdraw, and deposit funds.
    - Change password and update profile credentials.
  - **New User**
    - Register a new account with secure credentials.
  
- 💳 **User Operations**
  - **Transfer Funds:** Send money to other users securely.
  - **Withdraw Funds:** Withdraw balance with validation checks.
  - **Deposit Funds:** Add funds into account.
  - **Profile Settings:** Change username, password, and personal details.

- 🔒 **Secure Authentication**
  - Login system with role-based access control.

- 🗄 **Database**
  - Built using **MySQL** to store user credentials and transaction history.

- 🖥 **Frontend**
  - Java Swing GUI for an intuitive and interactive user experience.

---

## 🛠 Tech Stack

- **Frontend:** Java Swing (Desktop UI)
- **Backend:** Java
- **Database:** MySQL
- **Connector:** JDBC (Java Database Connectivity)

---

## 📂 Folder Structure
![vbsstructure](https://github.com/RGitLog18/Stock_Comparison_System/blob/main/vbssturcture.PNG)

## 🚀 Getting Started

### 📥 Prerequisites

- Java JDK 8 or higher
- MySQL Server
- IntelliJ IDEA or any Java IDE
- JDBC Connector JAR

---

### ⚙️ Setup Instructions

1. **Clone Repository**
   ```bash
   git clone https://github.com/your-username/VirtualBankingSystem.git
   ```
2. **Open Project**
    - Open in IntelliJ IDEA or your preferred IDE.

3. **Setup Database**
   - Import database.sql into MySQL.
   - Create a database (e.g., virtual_bank) and configure credentials in DBConnection.java
```java
String url = "jdbc:mysql://localhost:3306/virtual_bank";
String username = "root";
String password = "yourpassword";
```
4. **Add JDBC Driver**
   -Download [MySQL Connector/J.](https://dev.mysql.com/downloads/connector/j/)
   - Add the JAR file to your project libraries
     
5. **Run Application**
   - Execute Landing.java.
   - Start exploring as Admin or create a new user account


