# <h1 align ="center"> Recipe Management System<h1/>

A Spring Boot-based application for managing and searching recipes. The application supports CRUD operations on recipes, including name, ingredients, and instructions. Additionally, it allows users to comment on recipes and search for recipes based on name and ingredients.
<p align ="center">
<a href="Java url"> 
  <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg"/>
</a>
<a href="Maven url"> 
  <img alt="Maven" src="https://img.shields.io/badge/maven-4.0.0-brightgreen.svg"/>
</a>
<a href="Spring Boot url"> 
  <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.1.5-brightgreen.svg"/>
</a>
<a href="Spring Boot url"> 
  <img alt="License: MIT" src="https://img.shields.io/badge/License-MIT-yellow.svg"/>
</a>

## Features

- **CRUD Operations**: Users can Create, Read, Update, and Delete recipes.
- **Commenting**: Users can comment on recipes.
- **Search Functionality**: Users can search for recipes based on name and ingredients.

## Project Structure

- `src/main/java`: Contains the Java source code.
  - `controllers`: Includes API endpoints for different user roles (e.g., Admin and User).
  - `services`: Implements the business logic.
  - `repositories`: Contains database interaction using Spring Data JPA.
  - `models`: Defines entity classes (e.g., Recipe, Comment, User).
- `src/main/resources`: Contains application properties, such as `application.properties` or `application.yml`.

## Setup and Configuration

1. **Database Configuration**:
   - Configure your MySQL database settings in `application.properties` file.

2. **Dependencies**:
   - Make sure you have the required dependencies for Spring Boot, Spring Data JPA, and MySQL connector.

3. **Running the Application**:
   - Run the application in your IDE or using Maven: `mvn spring-boot:run`.
   - Access the APIs using a tool like Postman or via the Swagger UI.

## API Endpoints

### Admin Controller

- `/recipes`: POST method to add a new recipe.
- `/updateRecipe`: PUT method to update an existing recipe.
- `/users`:GET method to get all users.
- `/admin/recipes`:GET method to get all recipes.
- `/deleterecipes/id/{id}`:DELETE method to delete recipes using recipes id.

### User Controller

- `/api/searchRecipes/ingredients`: GET method to search recipes based on ingredients.
- `/api/searchRecipesByName`: GET method to search recipes by name.
- `/user/register`:POST method for registering users who came first time on our application.
- `/user/Login`:POST method for logging in for already existing users.
- `/user/signout`:DELETE method for signing out for already log in users.

### Comment Controller
 - `comment`:POST method for commenting on the recipes by the users.
 - `comments`:GET method for getting all the comments.
 - `comment/delete/id/{id}`:DELETE method for deleting the specific comment by id.

## Usage

- Use the provided API endpoints to interact with the system:
  - Create, update, delete recipes.
  - Search for recipes by name or ingredients.
  - Add comments to recipes.

  ## project summary
  In summary ,this project is a recipe management system that allows two types of users the admin and the
  user,to perform CRUD operations on recipes.The project uses the MVC architecture to make the code modular and redable.
  It utilizes various technologies such as Spring Boot,Java,and MYsql database to provide an efficient Recipe Management System.

## Contributors

- [gulshanshukla](https://github.com/gulshanshukla)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
