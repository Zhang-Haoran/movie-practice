# Project Introduction

## Movie-practice

Movie-practice is a backend server for learning purpose which was powered by Spring Boot

# Key Features

- Actors CRUD
- Director CRUD
- Movie CRUD
- Movie revenue CRUD

# Dependency

- Spring Boot Web
- Spring Boot JPA
- Lombok
- h2database
- Mapstruct
- Flyway
- PostgreSQL

# Prerequisites

Java 11 environment

# Setup

 - git clone git@github.com:Zhang-Haoran/movie-practice.git
 - open with intellji 
 - modify PostgreSQL database username and password to yours in src\main\resources\application.properties 
 - run the application
 - access through http://localhost:8080

# Coding Standard

- CamelCase

# Test

- Junit

# API
* /actors
    * GET http://localhost:8080/actors
    * POST http://localhost:8080/actors
    * GET http://localhost:8080/actors?firstname=Ziyi&lastname=Zhang
    * PUT http://localhost:8080/actors?id=2
    * DELETE http://localhost:8080/actors?id=148
* /directors
    * GET http://localhost:8080/directors
    * GET http://localhost:8080/directors?firstname=Kinji&lastname=Fukasaku
    * POST http://localhost:8080/directors
    * PUT http://localhost:8080/directors?id=38
    * DELETE http://localhost:8080/directors?id=32
* /movies
    * GET http://localhost:8080/movies
    * POST http://localhost:8080/movies
    * PUT http://localhost:8080/movies?id=1
    * DELETE http://localhost:8080/movies?id=58
* /movie-revenues
    * GET http://localhost:8080/movie-revenues
    * POST http://localhost:8080/movie-revenues
    * PUT http://localhost:8080/movie-revenues?id=53
    * DELETE http://localhost:8080/movie-revenues?id=53
