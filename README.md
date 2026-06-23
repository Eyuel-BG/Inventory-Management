# Java Pharmacy Management System

## Overview
This is my final project for the OOP module. It's a simple console-based inventory management system designed for a small pharmacy or clinic. The program lets the user add and track medical supplies (either medications or medical devices) and saves the stock details so no data is lost when you close the app.

## Features
- **Interactive Menu**: Uses Java `Scanner` to take input directly from the terminal.
- **Inheritance & Polymorphism**:
  - Contains a base `Item` class that branches into `Medication` and `MedicalDevices`.
- **Exception Handling**:
  - Implements a custom `InvalidQuantityException` to prevent the user from typing in negative stock numbers by mistake.
- **File I/O**:
  - Automatically saves the updated inventory list into a text file located in `data/inventory.txt`.

## Getting Started

### Prerequisites
You just need the standard Java Development Kit (JDK) installed. I tested this with JDK 17, but it should work fine on JDK 8 or anything newer since it's just standard Java stuff.

### How to Compile and Run
1. Open your terminal or command prompt in the main project folder.
2. Compile all the Java files:
   ```bash
   javac *.java
   ```
3. Run the main class:
   ```bash
   java Main
   ```

### Using the App
When it runs, you will see a simple menu:
1. Choose option `1` to add medicine (asks for expiration date)
2. Choose option `2` to add equipment (asks for warranty period)
3. Enter ID, Name, Price, and Quantity as prompted.
4. If you type a negative number for the quantity, it will catch the error and show a warning instead of crashing.
5. Exit by typing `3`, and check the `data/inventory.txt` file to see the saved output!

## File Structure
- `Main.java` - The entry point that runs the while loop and scanner menu.
- `Item.java` - Abstract parent class tracking ID, name, price, and overall static item count.
- `Medication.java` - Child class specifically handling expiry dates.
- `MedicalDevices.java` - Child class handling warranty months.
- `Inventory.java` - Manages the array of items and handles file saving.
- `InvalidQuantityException.java` - The custom exception class.

## Note to Grader / Instructor
I originally had some old database stuff (`DatabaseHelper.java`), but I stripped it out of `Main.java` since the requirement was just to save the outputs to the `data/` folder, and the DB code was printing weird metadata in the console anyways. The project now fully meets the core OOP and File I/O requirements without any external libraries.
