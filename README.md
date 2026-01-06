HOTEL RESERVATION SYSTEM

Hotel Reservation System is a Java-based hotel reservation management system developed using Object-Oriented Programming (OOP) principles.
The system works with a console-based interface and supports room reservations, customer management, and extra service handling.

This project was developed as the final project for the Object-Oriented Programming (OOP) course.

PROJECT OVERVIEW

The system simulates real-world hotel operations such as:

Managing different room types

Handling customer records

Creating and managing reservations

Calculating prices with extra services

Storing data using CSV files

The main goal of the project is to demonstrate clean OOP design, modular structure, and file-based data persistence.

OBJECT-ORIENTED PROGRAMMING CONCEPTS

INHERITANCE

Rooms: Abstract base class that defines common room properties

NormalRoom extends Rooms: Represents standard rooms

SuiteRoom extends Rooms: Represents suite rooms

All room types inherit common attributes such as:

roomNumber

normalPrice

isOccupied

POLYMORPHISM

Bookings interface defines the following methods:

calculatePrice()

getRoomDetails()

Rooms abstract class implements the Bookings interface

NormalRoom and SuiteRoom override these methods differently, enabling dynamic behavior based on room type

FEATURES

ROOM MANAGEMENT

8 Standard Rooms: N101 – N108

2 Suite Rooms: S201 – S202

CUSTOMER MANAGEMENT

Add new customers

List existing customers

RESERVATION SYSTEM

Room availability check

Reservation creation and storage

EXTRA SERVICES

Spa

Gym

Valet Parking

Minibar

Extra Bed

Airport Transfer

CSV DATA STORAGE

Customers, rooms, and reservations are stored in CSV files

No database is required

PROJECT STRUCTURE

src/
Main.java - Application entry point
HotelMenu.java - Console menu and user interaction
Customer.java - Customer model
Rooms.java - Abstract base room class
NormalRoom.java - Standard room implementation
SuiteRoom.java - Suite room implementation
RoomManager.java - Room management logic
Reservation.java - Reservation operations
Prices.java - Price constants
ExtraService.java - Extra service model
ExtraServiceRegister.java - Service definitions
CSVManager.java - CSV read/write operations

data/
customers.csv - Customer data
reservations.csv - Reservation records
rooms.csv - Room availability data

TECHNOLOGIES USED

Java

Object-Oriented Programming (OOP)

CSV File Handling

Console-Based User Interface

EDUCATIONAL PURPOSE

This project was developed for academic purposes to demonstrate:

Inheritance

Polymorphism

Abstraction

Encapsulation

Interface usage

File-based data persistence
