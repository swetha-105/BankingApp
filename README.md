# 🏦 Banking Management System (Console-Based Java Project)

A simple **console-based banking system** built using **Core Java**, **JDBC**, and **MySQL**.  
It allows users to create accounts, log in, deposit, withdraw, and check balances.

---

## 🚀 Features
✅ Create a new bank account  
✅ Secure login using PIN  
✅ Deposit and withdraw money  
✅ Check balance  
✅ Data stored in MySQL database  

---

## 🧰 Tech Stack
- **Java (Core Java + JDBC)**
- **MySQL** (Database)
- **Eclipse / IntelliJ / VS Code** (IDE)

---

## 🗄️ Database Setup

Run the following SQL script in MySQL to create the database and table:

```sql
CREATE DATABASE bankdb;
USE bankdb;

CREATE TABLE accounts (
  acc_no INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  pin VARCHAR(10),
  balance DOUBLE
);

⚙️ How to Run

Clone the repo:

git clone https://github.com/<your-username>/<repo-name>.git


Open the project in your IDE.

Update your MySQL credentials in DBConnection.java:

private static final String url = "jdbc:mysql://localhost:3306/bankdb";
private static final String un = "root";
private static final String pwd = "password";


Compile and run:

javac *.java
java BankApp

📸 Output Example
BANK SYSTEM MENU
1. Create Account
2. Login
3. Exit
Enter choice: 1
Enter Name: Swetha
Set 4-Digit PIN: 1234
Initial Deposit: 1000
✅ Account created successfully!

👩‍💻 Author

Swetha Kotala

⭐ Show your support

If you like this project, please ⭐ star the repo!
