# DevHub Java SDK

![Java](https://img.shields.io/badge/Java-17+-blue)
![License](https://img.shields.io/badge/License-MIT-green)
![Status](https://img.shields.io/badge/Status-Active-success)

Official Java SDK for DevHub API.

A fluent, developer-friendly Java client for accessing DevHub API services. Maintained by the DevHub project.

[Website](https://devhub-api.com) • [API Documentation](https://devhub-api.com/swagger-ui/index.html)

## Why DevHub?

Instead of implementing and maintaining utility libraries in every project, DevHub API provides:

- Data conversion services
- Data sanitization and validation
- UUID and password generation
- CSS and JavaScript minification

allowing developers to focus on business logic while relying on a centralized and secure platform.

## Features 
- Fluent API design 
- Automatic JWT authentication
- Automatic token refresh
- Request ID generation
- Type-safe request builders
- Consistent exception handling
- Java 17 compatible

## 30-Second Example
```java
	DevHubClient client = DevHubClient.builder()
		.withBasePath("https://devhub-api.com")
		.withCredentials(username, password)
		.build();
		
	UUIDResponse response = client.tools()
		.uuid()
		.v4()
		.generate();
		
	System.out.println(response.getUuid());
```

## Quick Start

1. Create a free account on https://devhub-api.com
2. Generate your API credentials
3. Build and install the SDK locally
4. Configure the client with your credentials
5. Start calling DevHub APIs

DevHub API provides a structured set of developer-oriented services designed to simplify common backend tasks and accelerate application development.

The platform is organized into functional domains, each delivering reliable and production-ready utilities.

### Document & Data Processing
- Markdown → HTML conversion
- Markdown → PDF rendering (custom themes supported)
- CSV → JSON conversion
- JSON → XML conversion
- and many more services.

Designed for automation pipelines, CMS integrations and content-driven applications.

### Utilities
- UUID generation
- Random password generation
- Minify CSS
- Minify JS

Lightweight, fast and suitable for system-level integration.

### Security & Data Protection
- Data sanitization
- Data validation

Designed to enforce data integrity, prevent common security threats, and ensure safe handling of user input across applications.

### Platform Features
- JWT Authentication (Bearer Token)
- Per-endpoint rate limiting
- Consistent validation and predictable error handling
- Secure-by-default design

The API surface will expand progressively while maintaining backward compatibility.

## Requirements

Building the API client library requires:

1. Java 17+
2. Maven/Gradle

## Installation

The SDK is currently distributed through this repository. 

Clone the project and install it into your local Maven repository:

```bash
mvn clean install
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

- `target/devhub-api-sdk-1.0.0.jar`
- `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

	String username = "your_username";
	String password = "your_password";
	
	DevHubClient client = DevHubClient.builder()
				.withBasePath("https://devhub-api.com")
				.withCredentials(username, password)
				.withAutoRequestId()
				.build();
	   
	ConvertModule convert = client.convertData();
	ProtectDataModule protection = client.protectData();
	
	//COnvert JSON -> CSV
	String jsonString =
		"[{\"username\":\"alice\",\"age\":28,\"premium\":true},\r\n" +
		"{\"username\":\"bob\",\"age\":31,\"premium\":false}]";

	String csvString = client.convert().data()
				.jsonToCsv(jsonString)
				.delimiter(Delimiter.SEMICOLON)
				.quoteChar(QuoteChar.DOUBLE_QUOTE)
				.quoteMode(QuoteMode.ALL)
				.execute();
				
	//Sanitize html
	String html = "<p>html example text</p><script>alert(1)</script>";
	SanitizationResult htmlSanitized = protection.sanitize(html)
			.html()
			.mode(SanitizationHtmlMode.STRICT)
			.execute();
	
	//Validate text detecting potential sql injection
	String firstTextWithSqlInjection = "SELECT * FROM users WHERE username = '\" + user_input + \"' AND password = '\" + pass_input + \"';";
	ValidateResponse firstTextValidation = protection.validate(firstTextWithSqlInjection)
			.noSqlInjection()
			.execute();

```

More examples:
https://devhub-api.com/java-sdk-docs

## API Reference

Full API documentation:

https://devhub-api.com/swagger-ui/index.html

## Authentication

DevHub API uses JWT Bearer authentication.

The SDK automatically handles token acquisition and refresh.

## Author
Giuseppe Cocchiara

Founder of DevHub API

- Website: https://devhub-api.com
- Email: info@devhub-api.com