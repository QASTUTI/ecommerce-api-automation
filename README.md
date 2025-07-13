
# 🛒 E-Commerce API Automation Framework

A comprehensive **API Test Automation** framework designed using **Rest Assured**, **TestNG**, and **Allure Reports**, integrated with **Jenkins CI/CD**. This project automates REST API endpoints from [DummyJSON](https://dummyjson.com), including login, product management, and user flows, following the **Service Object Model (SOM)** for scalable and reusable test design.

---

## 📁 Project Structure

```
EcommerceAPIAutomation/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/ecommerce/
│   │           ├── base/             # Base setup (e.g., BaseTest.java)
│   │           ├── utilities/        # AuthUtility for token generation
│   │           └── services/         # Optional: service classes for each module
│   └── test/
│       └── java/
│           └── com/ecommerce/tests/
│               └── LoginPage.java    # Sample login test
├── pom.xml
└── README.md
```

---

## 🔧 Technologies Used

| Tool/Library     | Purpose                                     |
|------------------|---------------------------------------------|
| **Java 1.8+**     | Programming language                        |
| **Maven**         | Build and dependency management             |
| **Rest Assured**  | API testing library                         |
| **TestNG**        | Test framework with annotations             |
| **Allure Reports**| Generate rich, visual test reports          |
| **Jenkins**       | CI/CD automation                            |

---

## ✅ Features

- Token-based login validation
- Status code & response body assertions
- Utility class for token generation (`AuthUtility`)
- Organized using **Service Object Model**
- Cross-verification using **JSONPath**
- Clean console logs with `response.asPrettyString()`
- Integrated with **Allure** for report generation
- Configured for **Jenkins** CI pipeline

---

## 🚀 How to Run

### 1️⃣ Prerequisites

- Java JDK 8+
- Maven 3.6+
- Git
- Jenkins (optional)
- Allure CLI (for local reports):  
  Install via:
  ```bash
  brew install allure  # Mac
  ```

---

### 2️⃣ Clone the Repository

```bash
git clone https://github.com/QASTUTI/ecommerce-api-automation.git
cd ecommerce-api-automation
```

---

### 3️⃣ Run Tests via Maven

```bash
mvn clean test
```

---

### 4️⃣ Generate Allure Report

```bash
allure serve target/allure-results
```

Or if you're using Jenkins:
- Install **Allure Plugin**
- Add Allure Commandline under **Global Tool Configuration**
- Post-build action: “Allure Report”

---

## 🧪 Sample Test (Login)

```java
@Test(description = "Verify login and token generation")
public void loginTest() {
    Response response = AuthUtility.getToken("michaelw", "michaelwpass");
    System.out.println(response.asPrettyString());
    assertEquals(response.getStatusCode(), 200);
    assertNotNull(response.jsonPath().get("accessToken"));
}
```

---

## 📦 Maven Dependencies (`pom.xml` highlights)

```xml
<dependencies>
  <dependency>
    <groupId>io.rest-assured</groupId>
    <artifactId>rest-assured</artifactId>
    <version>5.3.0</version>
  </dependency>
  <dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.10.2</version>
    <scope>test</scope>
  </dependency>
  <dependency>
    <groupId>io.qameta.allure</groupId>
    <artifactId>allure-testng</artifactId>
    <version>2.24.1</version>
  </dependency>
</dependencies>
```

---

## 🧰 Jenkins Integration

1. Install Jenkins + Allure Plugin
2. Configure:
   - Maven (Global Tools)
   - Allure Commandline (e.g., version 2.34.1)
3. Add build steps:
   - `mvn clean test`
   - Post-build: Allure Report
4. Optional: Add Git webhook for CI

---

## 🧱 Design Pattern Used: Service Object Model

Each service (like login, products) is modeled as a separate class. This:
- Encourages **modularity**
- Promotes **code reusability**
- Improves **maintenance**

---

## 📊 Allure Report Sample

> After tests, Allure provides:
- Summary of passed/failed/skipped
- Detailed logs per test
- Attachments and request/response bodies

---

## 🙋‍♀️ Maintainer

**👩‍💻 Astuti Mishra (QASTUTI)**  
🔗 [GitHub](https://github.com/QASTUTI)  
📧 Feel free to connect for collaborations or feedback.

---

## 📜 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

---

> 🔖 _Test early. Test often. Automate always._ 🚀
