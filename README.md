# Product Management App

A Spring Boot application for managing products and categories. This application supports basic CRUD operations and includes filtering and pagination for products.

## Features

- Manage Products: Add, edit, view, and delete products.
- Manage Categories: Add, edit, view, and delete categories.
- Filtering: Filter products by category and price range.
- Pagination: View products with pagination support.
- Dynamic Specifications: Use criteria for filtering products with dynamic queries.

## Technologies

- Java
- Spring Boot
- Spring Data JPA
- Thymeleaf
- H2 Database (for development)
- Lombok (for simplifying Java code)
- Maven

## Prerequisites

- Java 17 or newer
- Maven
- (Optional) IDE such as IntelliJ IDEA or Eclipse

## Getting Started

### Clone the repository

```bash
git clone https://github.com/usermlc/pr-manage.git
cd pr-manage
```

### Build the application

Make sure you have Maven installed, then build the application with:

```bash
mvn clean install
```

### Run the application

To start the application, use:

```bash
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`.

## Usage

- **Home Page**: Navigate to `/main` to access the main page.
- **Product Management**: 
  - View all products: `/products/list`
  - Add new product: `/products/add`
  - Edit a product: `/products/edit/{id}`
- **Category Management**:
  - View all categories: `/categories`
  - Add new category: `/categories/add`
  - Edit a category: `/categories/edit/{id}`

### Filtering Products

- Use the product list page (`/products/list`) to filter products by category or price range.

## Database Configuration

The application is configured to use an H2 in-memory database by default. To change the database, update the `application.properties` file in `src/main/resources`.

### H2 Database Console

Access the H2 console at `http://localhost:8080/h2-console`. The default credentials are set in `application.properties`.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.
