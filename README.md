# Car Rental Management System
## Project Overview
A robust object-oriented programming (OOP) implementation of a car rental management system designed to streamline vehicle rental processes through efficient software design.

## Key Features
Object-Oriented Design: Leverages OOP principles for modular and maintainable code
Comprehensive Car Management: Handles vehicle inventory, types, and rental tracking
Dynamic Pricing: Calculates rental costs based on vehicle characteristics and rental duration
User-Friendly Interface: Console-based interaction for seamless system operations

## System Architecture
Core Classes

1. Vehicle Class
   * Base class for all rental vehicles
   * Attributes: model, year, daily rate, availability status
   * Supports inheritance for different vehicle types

2. Car Class (Inherits from Vehicle)
   * Specialized vehicle type with additional attributes
   * Supports car-specific rental logic

3. Customer Class
   * Manages customer information
   * Tracks rental history and current rentals

4. RentalSystem Class
   * Central management class
   * Coordinates vehicle inventory, customer interactions, and rental processes


## Key Functionalities

* Vehicle registration and management
* Customer registration
* Rental booking and return processes
* Automated pricing calculation
* Availability tracking
* Rental history maintenance

## Implementation Highlights

* Encapsulation: Private member variables with controlled access
* Inheritance: Flexible vehicle type management
* Polymorphism: Adaptable rental and pricing methods
* Error Handling: Robust input validation and exception management

