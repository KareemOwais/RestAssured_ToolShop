# RestAssured ToolShop

API test framework for the [Practice Software Testing Toolshop](https://api.practicesoftwaretesting.com) demo API, plus a GraphQL and WebSocket test.

## What it tests

- **End-to-end admin flow:** log in, create and update brands, categories and sub-categories, create/update/delete a product, then clean everything up.
- **End-to-end user flow:** register, log in, build a cart, change quantities, pay, then have an admin delete the user and create the invoice.
- **Negative cases:** for example, deleting a category that still has children (409) or a cart that doesn't exist (404).
- **Cucumber scenarios:** create, update and delete a product, written in `product.feature`.
- **GraphQL:** inserts a todo, subscribes over WebSocket, updates it, and asserts the update arrives.

## Structure

| Folder | Role |
|---|---|
| `POJO/` | Request and response models (Users, Product, Cart, Invoice and others) |
| `Steps/` | Reusable API steps that call the endpoint and validate the status code |
| `Utils/` | REST client, GraphQL / WebSocket client, constants, env loader |
| `src/test` | TestNG tests, Cucumber step definitions and the suite file (`ApiTests.xml`) |

## Stack

Java 21, REST Assured, TestNG, Cucumber, Jackson / Gson, Java-WebSocket, Lombok, Log4j2, Allure, Maven

## Run it

Requires JDK 21 and Maven. Credentials are read from a `.env` file (or from environment variables):

```
ADMIN_USERNAME=...
ADMIN_PASSWORD=...
USER_USERNAME=...
USER_PASSWORD=...
```

```bash
git clone https://github.com/KareemOwais/RestAssured_ToolShop.git
cd RestAssured_ToolShop
mvn test
```

## CI

A GitHub Actions workflow (`.github/workflows/maven.yaml`) compiles the project and runs the tests on every push and pull request to `master`. The four credentials above are stored as repository secrets.
