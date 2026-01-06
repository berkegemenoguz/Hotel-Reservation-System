# 🏨 Hotel Reservation System

**Hotel Reservation System** is a Java-based hotel reservation management system developed using **Object-Oriented Programming (OOP)** principles.

The system operates through a **console-based interface** and supports:
- Room reservations
- Customer management
- Extra service handling

This project was developed as the **final project** for the **Object-Oriented Programming (OOP)** course.

---

## 📌 Project Overview

The system simulates real-world hotel operations such as:

- Managing different room types
- Handling customer records
- Creating and managing reservations
- Calculating prices with extra services
- Storing data using CSV files

The main goal of the project is to demonstrate:
- Clean OOP design
- Modular structure
- File-based data persistence

---

## 🧠 Object-Oriented Programming Concepts

### 🔹 Inheritance

- **Rooms**: Abstract base class that defines common room properties
- **NormalRoom extends Rooms**: Represents standard rooms
- **SuiteRoom extends Rooms**: Represents suite rooms

Common inherited attributes:
- `roomNumber`
- `normalPrice`
- `isOccupied`

---

### 🔹 Polymorphism

- **Bookings** interface defines:
    - `calculatePrice()`
    - `getRoomDetails()`

- **Rooms** abstract class implements **Bookings**
- **NormalRoom** and **SuiteRoom** override these methods differently, enabling dynamic behavior based on room type

---

## ✨ Features

### 🛏 Room Management
- 8 Standard Rooms: **N101 – N108**
- 2 Suite Rooms: **S201 – S202**

### 👤 Customer Management
- Add new customers
- List existing customers

### 📅 Reservation System
- Room availability check
- Reservation creation and storage

### ➕ Extra Services
- Spa
- Gym
- Valet Parking
- Minibar
- Extra Bed
- Airport Transfer

### 📁 CSV Data Storage
- Customers, rooms, and reservations are stored in CSV files
- No database is required

---

## 📂 Project Structure

```text
src/
├── Main.java                 # Application entry point
├── HotelMenu.java            # Console menu and user interaction
├── Customer.java             # Customer model
├── Rooms.java                # Abstract base room class
├── NormalRoom.java           # Standard room implementation
├── SuiteRoom.java            # Suite room implementation
├── RoomManager.java          # Room management logic
├── Reservation.java          # Reservation operations
├── Prices.java               # Price constants
├── ExtraService.java         # Extra service model
├── ExtraServiceRegister.java # Service definitions
├── CSVManager.java           # CSV read/write operations

data/
├── customers.csv             # Customer data
├── reservations.csv          # Reservation records
├── rooms.csv                 # Room availability data

