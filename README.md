Selenium Automation Framework

This repository contains a Selenium Automation Framework designed to run both inside Docker containers and locally on Chrome. It provides a flexible and scalable solution for automating web testing across different environments.

1)Docker Integration:

🐳 Parallel Execution Inside Docker Containers with various browsers
🔄 Simplified setup and scalability with Docker Compose.

2)Local Browser Execution:

🌟 Optimized for running automation scripts directly in Chrome, Firefox and Edge

3)Custom Libraries for Test Data:

🔍 Implemented owner libraries to efficiently read and manage test data.
⚙️ Supports various data formats and sources for versatile test scenarios.


Prerequisites
Before you get started, ensure you have the following installed on your machine:

1. Docker
2. Java 
3. AN IDE (IntelliJ)
4. Google Chrome (for local execution)
5. Maven


Getting Started
Clone the Repository: git clone https://github.com/DhayanidhiKB/SeleniumWithDocker.git
cd your-repo

To Run the Tests Locally:
In pom.xml file: <selenium.grid.enabled>false</selenium.grid.enabled>
Set this attribute to False and Run the testng.xml


Docker Setup:
Start the Docker container and run the tests:
docker-compose up

Make Sure you set the selenium Grid by checking the URL: http://localhost:4444/

To Run the Tests inside the Docker Container:
In pom.xml file: <selenium.grid.enabled>true</selenium.grid.enabled>
Set this attribute to True and Run the testng.xml



