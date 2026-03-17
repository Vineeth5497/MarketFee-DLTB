# Market Fee Calculator

A Spring Boot application for calculating and recording daily market fees from various sources (D.I, MCP, Govt, Ep, Others).

## Prerequisites

- Java 17+
- Maven 3.6+
- PostgreSQL

## Setup

1. Create a PostgreSQL database named `MARKET_FEE`
2. Configure database connection (optional - defaults work for local development):
   - `DB_URL` - JDBC URL 
   - `DB_USERNAME` - Database username 
   - `DB_PASSWORD` - Database password

## Running the Application

```bash
mvn spring-boot:run
```

For production:
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```


## API

- **POST** `/amc/insert` - Submit market fee data (JSON body)

## Project Structure

- `presentation/` - Controllers, DTOs
- `business/` - Service layer
- `entity/` - JPA entities
- `repository/` - Data access
- `exception/` - Global exception handling
