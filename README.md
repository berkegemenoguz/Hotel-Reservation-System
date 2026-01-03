🏨 Hotel Reservation System

A Java-based hotel reservation management system developed using Object-Oriented Programming (OOP) principles.
The system operates via a console-based interface and supports room reservations, customer management, and extra service handling.

This project was developed as the final project for the Object-Oriented Programming (OOP) course.

📌 Project Overview

The Hotel Reservation System is designed to simulate real-world hotel operations, including:

Managing different room types

Handling customer data

Creating and tracking reservations

Calculating prices dynamically with extra services

Persisting data using CSV files

The project emphasizes clean OOP design, modularity, and data persistence.

🎯 Object-Oriented Programming Concepts

🔹 Inheritance

Rooms → Abstract base class defining common room properties

NormalRoom extends Rooms → Standard room implementation

SuiteRoom extends Rooms → Suite room implementation

All subclasses inherit shared attributes such as:

roomNumber

normalPrice

isOccupied

🔹 Polymorphism

Bookings interface defines:

calculatePrice()

getRoomDetails()

Rooms abstract class implements the Bookings interface

NormalRoom and SuiteRoom override these methods differently, allowing dynamic behavior based on room type

✨ Features

Room Management

8 Standard Rooms: N101 – N108

2 Suite Rooms: S201 – S202

Customer Management

Add new customers

List existing customers

Reservation System

Room availability checks

Reservation creation and storage

Extra Services

Spa

Gym

Valet Parking

Minibar

Extra Bed

Airport Transfer

CSV-Based Data Storage

Persistent data handling without a database

Easy file-based management

📁 Project Structure
src/
├─ Main.java                    # Application entry point
├─ HotelMenu.java               # Console menu and user interaction
├─ Customer.java                # Customer model
├─ Rooms.java                   # Abstract base room class
├─ NormalRoom.java              # Standard room implementation
├─ SuiteRoom.java               # Suite room implementation
├─ RoomManager.java             # Room management logic
├─ Reservation.java             # Reservation operations
├─ Prices.java                  # Price constants
├─ ExtraService.java            # Extra service model
├─ ExtraServiceRegister.java    # Service definitions
├─ CSVManager.java              # CSV read/write operations

data/
├─ customers.csv                # Customer data
├─ reservations.csv             # Reservation records
├─ rooms.csv                    # Room availability data

🛠 Technologies Used

Java

Object-Oriented Programming (OOP)

CSV File Handling

Console-Based UI

🚀 How to Run

Clone the repository:

git clone https://github.com/your-username/hotel-reservation-system.git


Open the project in any Java IDE (IntelliJ IDEA, Eclipse, VS Code)

Run Main.java

Follow the console menu instructions

📚 Educational Purpose

This project was developed for academic purposes to demonstrate:

OOP principles (Inheritance, Polymorphism, Abstraction, Encapsulation)

Interface usage

File-based data persistence

Modular Java application design
