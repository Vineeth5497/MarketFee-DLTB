# Market Fee Calculator

A Spring Boot application for calculating and recording daily market fees from various sources (D.I, MCP, Govt, Ep, Others).

## Prerequisites

- Java 17+
- Maven 3.6+
- PostgreSQL

## Setup

1. Create a PostgreSQL database named `MARKET_FEE`
2. Configure database connection (optional - defaults work for local development):
   - `DB_URL` - JDBC URL (default: `jdbc:postgresql://localhost:5432/MARKET_FEE`)
   - `DB_USERNAME` - Database username (default: `postgres`)
   - `DB_PASSWORD` - Database password (default: `admin`)

## Running the Application

```bash
mvn spring-boot:run
```

For production:
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```

The application runs on port 8085. Access the form at:
- http://localhost:8085/MarketFeeForm.html

## API

- **POST** `/amc/insert` - Submit market fee data (JSON body)

## Project Structure

- `presentation/` - Controllers, DTOs
- `business/` - Service layer
- `entity/` - JPA entities
- `repository/` - Data access
- `exception/` - Global exception handling
