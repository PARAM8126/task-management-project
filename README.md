# Task Management System
**1. Overview:** This project is created to perform CURD operations(Create, Update, Retrieve, Delete) on tasks.
1.1  ER diagram : ![Screenshot 2025-06-06 195614](https://github.com/user-attachments/assets/6d408b32-0fba-4cf9-ad11-6d39a76456da)

**2. Explanation of DB Design -**

2.1. ER Diagram: Entity Relationship Diagram explains the relationship between user and tasks.
2.2. Data Dictionary: It represents the metadata information about the tables.
2.3. Documentation of Indexes is used to h
2.4. Code first approach has been used. 

**3. Structure of the application** - Standard MVC server side page rendering has been used. 

3.1. Frontend Structure - web page frontend has been used( HTML, Bootstrap5, JavaScripts

3.2. Build and install - 
3.2.1. Environment details along with list of dependencies: Dev environment has dependency to have JVM install in the machine.
3.2.2. Instructions:

**4. How to compile or build a project -**  Install Required Tools
Make sure these tools are installed:

:Java JDK 17+ : Download JDK or install via terminal (choco install openjdk on Windows with Chocolatey)
: Maven : Download Maven
Or use built-in Maven in Spring Tool Suite (STS) or IntelliJ IDEA
:MySQL Server : Download from MySQL and create your DB schema (like taskdb)
: IDE: Use Spring Tool Suite, IntelliJ, or VS Code (with Java extensions)

4.2 :  Clone  Project from GitHub
        git clone https://github.com/PARAM8126/task-management-project.git
        cd task-management-project
4.3. Configure application.properties
Open src/main/resources/application.properties and set your local DB  credentials:
.. Also make sure MySQL server is running and database taskdb is created.

4.4  Build the Project : 
                   If using terminal, run: 
                   : mvn clean install
                   If using STS or IntelliJ:
                Right-click project > Maven > Update Project
                 Then run as Spring Boot App


**5. How to run or install the project** - Steps are as follow:
  :  Run the Frontend : 

5.1. User needs to open index. html page available at below path:
src/main/resources/templates/index.html
 and Make sure it points to backend at http://localhost:8081/api/...
 
5.1.1. Create task: User can create task using these columns:  Title, User_id, description, due date, status, Remarks, created By, update by.
5.1.2 Update task: User can update task using these columns:  Title, description, due date, status, Remarks, created By, update by.
5.1.3 Retrieve task: User can find any task using Task_id.
5.1.3 Delete task: User can delete any task using Task_id.
