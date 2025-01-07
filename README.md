# Java MVVM Project Demo

This is a demo project showcasing the Model-View-ViewModel (MVVM) architecture in Java. The project demonstrates how to structure a Java application using the MVVM design pattern, with separation of concerns between the UI (View), the data (Model), and the logic (ViewModel).

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
- [Technologies Used](#technologies-used)
- [Error Handling](#error-handling)
- [Screenshot](#screenshot)

## Overview

The Java MVVM demo project helps developers understand the MVVM architecture and its benefits, such as improved testability, scalability, and maintainability. It provides a simple yet effective structure that can be extended for more complex applications.

## Features

- **Separation of concerns**: Clear division between UI, data, and logic.
- **ViewModel binding**: ViewModel binds to the View, allowing easy data and UI updates.
- **Observable data**: ViewModel manages observable data that automatically updates the View.
- **Scalable architecture**: Easily extendable for larger applications.

## Project Structure

Here’s a brief overview of the project structure:



## Technologies Used

- **Java**: Core programming language.
- **MVVM**: Model-View-ViewModel architecture pattern.
- **Gradle**: Build automation tool.

## Error Handling

The project demonstrates error handling using a generic approach. This approach involves using the `ResponseData`, `ResponseDataOfArray`, and `Status` classes to manage error responses and handle various types of responses, both single and multiple.

### Key Components for Error Handling:

- **ResponseData**: This class is used to handle single response data. It standardizes the structure of the response data, which includes status, message, and data.
- **ResponseDataOfArray**: This class handles multiple response data in the form of arrays. It ensures that the array data is handled efficiently and that errors are properly captured.
- **Status**: This is a class that defines various status codes and messages to categorize the response. It helps in understanding whether the request was successful or encountered an error.

These components work together to ensure that error responses from the server or API are captured and managed in a consistent way. With this, you can handle both individual response data and multiple responses across your project.

Here’s an illustration showing the error handling structure:

![Error Handling in Java MVVM](https://github.com/akashficus/java_mvvm_demo/blob/master/img.png)

## Screenshot

Here is a screenshot of the demo project:
![MVVM Demo Screenshot](https://github.com/akashficus/java_mvvm_demo/blob/master/Screenshot_20250107_183109.png)

