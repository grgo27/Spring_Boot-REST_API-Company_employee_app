This is a simple Dockerized REST API company/employee application with PostgreSQL as the database.
It includes all basic CRUD operations, as well as adding and removing employee from company.
Exception handling has also been implemented.

The primary emphasis of this simple project/exercise was to establish a one-to-many relationship between a company and its employees. 
Additionally, the project aimed to explore the details of handling and understanding the complexities involved in these relationships within a database system.

Before running the application in Docker, ensure that you have packaged it and skipped the tests using the command: mvnw clean package -DskipTests.

Additionally, it's crucial to note that users must adjust all passwords in the docker-compose file according to their specific setup.