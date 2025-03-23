# DEMOWEBSHOP-_PROJECT
# Demo Web Shop Application - Manual & Automation Testing (SDET Project)

## Project Overview
This repository contains the test scripts, test cases, and reports for testing the **Demo Web Shop Application**. This project was conducted individually as part of an **SDET (Software Development Engineer in Test)** initiative. The focus was on both **manual and automated testing** using **Cucumber with Selenium (POM model integration)**.  

The testing covered core functionalities of the e-commerce platform, including:
- **User Authentication** (Sign In, Login)
- **Home Page Navigation**
- **Product Search**
- **Add to Cart Functionality**
- **Checkout Process**
- **Extent Reports Generation** for test execution reports

---

## 👩‍💻 Author
**Puja Kumari** - QA Engineer  
📧 puja291196m@gmail.com  

---

## 📌 Table of Contents
- [Testing Scenarios](#testing-scenarios)
- [Manual Testing](#manual-testing)
- [Automated Testing with Selenium & Cucumber](#automated-testing-with-selenium--cucumber)
- [Bug Reports](#bug-reports)
- [Test Cases](#test-cases)
- [Project Setup](#project-setup)
- [Collaboration & Workflow](#collaboration--workflow)
- [Conclusion](#conclusion)

---

## ✅ Testing Scenarios
The key testing scenarios include:  

1. **Sign In & Login**  
   - Test user authentication with valid and invalid credentials.  

2. **Home Page Navigation**  
   - Verify that all sections (Featured Products, Categories, etc.) load correctly.  

3. **Product Search**  
   - Ensure users can search for products and receive accurate results.  

4. **Add to Cart**  
   - Test that products can be added to the cart and reflected properly.  

5. **Checkout Process**  
   - Validate order completion, including payment and order summary generation.  

6. **Extent Reports**  
   - Generate detailed execution reports for test cases.  

---

## 📝 Manual Testing
### 🔹 Test Case 1: Login with Valid Credentials  
**Pre-condition:** User must have an existing account.  
**Steps:**
1. Navigate to the login page.  
2. Enter valid credentials.  
3. Click on "Login".  
**Expected Result:** User should be redirected to the homepage successfully.  

### 🔹 Test Case 2: Product Search  
**Pre-condition:** Products exist in the database.  
**Steps:**
1. Enter a product name in the search bar.  
2. Click on "Search".  
**Expected Result:** Related products should be displayed.  

### 🔹 Test Case 3: Checkout Process  
**Pre-condition:** User has at least one item in the cart.  
**Steps:**
1. Click on "Cart".  
2. Proceed to checkout.  
3. Enter payment and shipping details.  
4. Confirm the order.  
**Expected Result:** Order should be successfully placed with confirmation.  

---

## 🤖 Automated Testing with Selenium & Cucumber
### 🔹 Automated Test Cases
Automated tests were written using:
- **Selenium WebDriver** for browser automation  
- **Cucumber** for Behavior-Driven Testing  
- **POM (Page Object Model)** for better maintainability  

### 🔹 Key Automated Tests:
- **Login Test:** Verify login with valid/invalid credentials.  
- **Product Search Test:** Ensure accurate product search results.  
- **Cart Test:** Validate the cart functionality (adding/removing products).  
- **Checkout Test:** Complete an end-to-end purchase flow.  

---

## 🐞 Bug Reports
| Bug ID | Description | Severity | Status |
|--------|------------|----------|--------|
| #001 | Login fails with valid credentials | High | Fixed |
| #002 | Search does not return expected products | Medium | Fixed |
| #003 | Checkout button unresponsive on some browsers | High | Fixed |

---

## ⚙️ Project Setup
To run the automated tests locally:

### 🔹 Clone the Repository
```sh
git clone https://github.com/pujakumari/DemoWebShopTesting.git
cd DemoWebShopTesting
