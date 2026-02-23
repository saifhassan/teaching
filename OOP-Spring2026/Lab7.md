# Lab 7: Comprehensive Integration - All Topics Review

## Table of Contents
1. [Introduction](#introduction)
2. [Topic Explanations](#topic-explanations)
3. [Progressive Tasks](#progressive-tasks)
4. [Practice Tasks](#practice-tasks)
5. [Submission Guidelines](#submission-guidelines)

---

## Introduction

This lab serves as a comprehensive review and integration of all topics covered in Labs 1-6. You will apply your knowledge of Java fundamentals, methods, objects, classes, arrays, strings, control structures, and advanced OOP concepts to solve complex, real-world problems. Each task integrates multiple concepts from previous labs, ensuring you have a solid understanding of all covered topics.

**Objectives:**
- Integrate all concepts from Labs 1-6
- Apply Java fundamentals in complex scenarios
- Design and implement comprehensive solutions
- Use methods, objects, and classes effectively
- Work with arrays (1D, 2D, uneven), strings, and control structures
- Apply encapsulation, method overloading, static members, and advanced features
- Solve real-world problems using OOP principles

**Prerequisites:**
- Completion of Labs 1-6
- Understanding of all topics covered in previous labs
- Familiarity with Java syntax and best practices

---

## Topic Explanations

This lab integrates all topics from previous labs. Review the following key concepts that will be used throughout the tasks:

### Integrated Concepts Review

**From Lab 1:**
- Variables, data types, type conversion and casting
- Input/output operations
- Arrays (declaration, initialization, manipulation)

**From Lab 2:**
- Static methods with different signatures
- Control statements (if/else, switch, ternary)
- String methods (length, equals, toUpperCase, toLowerCase)
- Array operations in methods
- Math class methods
- Command-line arguments

**From Lab 3:**
- Objects and instance methods
- Constructors (default and parameterized)
- Encapsulation (private attributes)
- Getters and setters
- This keyword

**From Lab 4:**
- Logical and relational operators
- Enhanced for loops (for-each)
- Break and continue statements
- Method overloading
- Type conversion and promotion
- Multi-dimensional arrays
- Uneven/jagged arrays

**From Lab 5:**
- Method and constructor overloading
- Object parameters and return types
- Argument passing mechanisms
- Access modifiers (public, private, protected)
- Static variables and methods
- Final keyword
- String class operations
- Varargs (variable-length arguments)

**From Lab 6:**
- String arrays as attributes
- 2D arrays for complex data
- Circular buffer pattern
- Object arrays
- Method overloading with arrays
- Static utility methods
- Finding elements in arrays
- Calculating statistics

---

## Progressive Tasks

**Important Topic Distribution:**
- **ALL topics from Labs 1-6 are covered across Tasks 1, 2, and 3 combined**
- Each task integrates multiple concepts but focuses on different aspects
- Task 1 emphasizes: Variables, Arrays (1D, 2D), Methods, Strings, Control Structures, Type Conversion
- Task 2 emphasizes: Objects, Encapsulation, Method Overloading, Static Members, Advanced Arrays
- Task 3 emphasizes: Complete OOP Integration, Advanced Features, Varargs, Circular Buffers, Statistics
- Together, all three tasks ensure comprehensive coverage of every topic from Labs 1-6

**Structure:**
- Each task should have a separate class and a Main class for testing
- Create comprehensive classes with proper structure, validation, and error handling
- Each task is designed to take approximately 1 hour

---

### Task 1: Student Grade Calculator - Labs 1 & 2 Focus

**Topics Covered:** Lab 1 (Variables, Data Types, Arrays, Type Conversion) & Lab 2 (Methods, Control Structures, Strings)

**Scenario:**
Create a simple student grade calculator that manages student grades using basic Java concepts.

**Requirements:**
Create a `StudentGradeCalculator` class with the following:

1. **Attributes:**
   - `studentNames` (String array of size 10)
   - `studentGrades` (double array of size 10) - stores average grade
   - `subjectNames` (String array) - subject names
   - `grades` (2D array: [studentIndex][subjectIndex]) - stores grades per subject

2. **Constructors:**
   - Parameterized constructor (subjectNames array)

3. **Required Methods:**
   
   **Lab 1 Topics - Variables & Arrays:**
   - `addStudent(String name)` - Adds student name to array
   - `addGrade(int studentIndex, int subjectIndex, double grade)` - Adds grade to 2D array
   - `getAllGrades(int studentIndex)` - Returns array of all grades for a student
   - `calculateAverage(int studentIndex)` - Returns average grade (double)
   
   **Lab 1 Topics - Type Conversion:**
   - `convertToPercentage(double grade)` - Converts grade (0-4.0) to percentage (0-100)
   - `getGradeAsString(int studentIndex)` - Returns grade as String
   
   **Lab 2 Topics - Methods & Control Structures:**
   - `getLetterGrade(int studentIndex)` - Returns 'A', 'B', 'C', 'D', or 'F' using switch statement
   - `isPassing(int studentIndex)` - Returns true if average >= 60 (use ternary operator)
   - `getGradeStatus(int studentIndex)` - Returns "Excellent", "Good", "Average", or "Fail" using if/else
   
   **Lab 2 Topics - String Operations:**
   - `getStudentInitials(int studentIndex)` - Returns initials (e.g., "John Doe" → "JD")
   - `searchStudent(String searchName)` - Returns student index or -1 (case-insensitive search)
   - `formatStudentInfo(int studentIndex)` - Returns formatted String: "Name: X, Grade: Y"
   
   **Lab 2 Topics - Array Operations in Methods:**
   - `findTopStudent()` - Returns index of student with highest average
   - `getPassingStudents()` - Returns array of passing student indices
   - `calculateClassAverage()` - Returns average of all students

**Test Scenario:**
```java
// In Main class:
// 1. Create calculator with subjects: "Math", "Science", "English"
// 2. Add 3 students
// 3. Add grades for each student
// 4. Calculate averages and display results
```

**Time Estimate: 45-60 minutes**

---

### Task 2: Product Inventory System - Labs 3 & 4 Focus

**Topics Covered:** Lab 3 (Objects, Classes, Encapsulation, Constructors, Getters/Setters) & Lab 4 (Method Overloading, 2D Arrays, Enhanced For Loops)

**Scenario:**
Create a product inventory system using object-oriented programming concepts with encapsulation and method overloading.

**Requirements:**
Create a `ProductInventory` class with the following:

1. **Private Attributes (Lab 3 - Encapsulation):**
   - `productNames` (String array of size 15)
   - `productPrices` (double array of size 15)
   - `productStock` (int array of size 15)
   - `productCategories` (String array of size 15)
   - `inventoryName` (String)

2. **Constructors (Lab 3):**
   - Default constructor - initializes inventoryName to "Default Inventory"
   - Parameterized constructor (inventoryName)

3. **Required Methods:**
   
   **Lab 3 Topics - Getters and Setters:**
   - `setInventoryName(String name)` - Setter with validation (length >= 3)
   - `getInventoryName()` - Getter
   - `setProductPrice(int productIndex, double price)` - Setter with validation (price > 0)
   - `getProductPrice(int productIndex)` - Getter
   
   **Lab 3 Topics - Object Operations:**
   - `addProduct(String name, double price, String category, int stock)` - Adds product to arrays
   - `updateProduct(int productIndex, String name, double price, int stock)` - Updates product info
   - `removeProduct(int productIndex)` - Removes product (sets to null/0)
   
   **Lab 4 Topics - Method Overloading:**
   - `addStock(int productIndex, int quantity)` - Adds stock (single product)
   - `addStock(int[] productIndices, int[] quantities)` - Overloaded: adds stock to multiple products
   - `applyDiscount(int productIndex, double percentage)` - Applies discount to single product
   - `applyDiscount(String category, double percentage)` - Overloaded: applies discount to all products in category
   
   **Lab 4 Topics - 2D Arrays:**
   - `getInventoryTable()` - Returns 2D array [productIndex][name, price, stock]
   - `getCategoryTable()` - Returns 2D array [category][total products, total value]
   - `updateMonthlyStock(int[][] stockData)` - Updates stock from 2D array [product][month]
   
   **Lab 4 Topics - Enhanced For Loops:**
   - `getAllProductNames()` - Returns array using enhanced for loop
   - `calculateTotalValue()` - Calculates total inventory value using enhanced for loop
   - `findLowStockProducts(int threshold)` - Returns array of low stock products using enhanced for loop
   
   **Lab 4 Topics - Break and Continue:**
   - `findFirstExpensiveProduct(double minPrice)` - Uses break when first product found
   - `countValidProducts()` - Uses continue to skip invalid products (price <= 0)

**Test Scenario:**
```java
// In Main class:
// 1. Create ProductInventory
// 2. Add 4-5 products
// 3. Test getters and setters
// 4. Test method overloading
// 5. Test 2D array operations
```

**Time Estimate: 45-60 minutes**

---

### Task 3: Library Management System - Labs 5 & 6 Focus

**Topics Covered:** Lab 5 (Static Members, Final Keyword, Varargs, Access Modifiers) & Lab 6 (Circular Buffers, Problem-Solving, Advanced Arrays)

**Scenario:**
Create a library management system using advanced OOP features like static members, varargs, and circular buffers.

**Requirements:**
Create a `LibrarySystem` class with the following:

1. **Private Attributes:**
   - `libraryName` (String)
   - `bookTitles` (String array of size 15)
   - `bookIds` (String array of size 15)
   - `isAvailable` (boolean array of size 15)
   - `borrowerNames` (String array of size 15)
   - `transactionHistory` (String array of size 10) - circular buffer (Lab 6)
   - `bookCount` (int) - static variable (Lab 5)
   - `MAX_BOOKS` (int) - final static variable = 15 (Lab 5)

2. **Constructors:**
   - Parameterized constructor (libraryName)

3. **Required Methods:**
   
   **Lab 5 Topics - Static Members:**
   - `addBook(String title, String bookId)` - Adds book, increments static bookCount
   - `getBookCount()` - Static method returning total books
   - `getLibraryStatistics()` - Returns String with statistics using static variable
   
   **Lab 5 Topics - Final Keyword:**
   - `validateBookLimit()` - Returns true if bookCount < MAX_BOOKS (uses final variable)
   - `getMaxCapacity()` - Returns MAX_BOOKS value
   
   **Lab 5 Topics - Varargs:**
   - `addMultipleBooks(String... bookTitles)` - Adds multiple books using varargs
   - `borrowBooks(int... bookIndices)` - Borrows multiple books using varargs
   - `returnBooks(int... bookIndices)` - Returns multiple books using varargs
   
   **Lab 5 Topics - Access Modifiers:**
   - `validateBookId(String id)` - Private method (validates ID format)
   - `getInternalBookInfo(int bookIndex)` - Protected method (returns internal book data)
   - `setLibraryName(String name)` - Public setter with validation
   
   **Lab 6 Topics - Circular Buffer:**
   - `recordTransaction(String transaction)` - Records transaction in circular buffer
   - `getTransactionHistory()` - Returns array of recent transactions (last 10)
   - `getRecentTransactions(int count)` - Returns last N transactions
   
   **Lab 6 Topics - Problem-Solving Methods:**
   - `borrowBook(int bookIndex, String borrowerName)` - Borrows book, records transaction
   - `returnBook(int bookIndex)` - Returns book, records transaction
   - `findAvailableBooks()` - Returns array of available book indices
   - `findBorrowedBooks()` - Returns array of borrowed book indices
   - `searchBooks(String searchTerm)` - Returns array of matching book indices
   
   **Lab 6 Topics - Advanced Array Operations:**
   - `getAllBookTitles()` - Returns array of all book titles
   - `getBorrowerStatistics()` - Returns 2D array [borrower][book count, book titles]
   - `calculateBorrowRate()` - Returns percentage of books borrowed
   
   **Integration Method:**
   - `generateLibraryReport()` - Returns comprehensive String report using all methods

**Test Scenario:**
```java
// In Main class:
// 1. Create LibrarySystem
// 2. Add books (using varargs)
// 3. Borrow and return books
// 4. Test static methods
// 5. View transaction history
// 6. Generate report
```

**Time Estimate: 45-60 minutes**

---

## Practice Tasks

**💡 OPTIONAL but Highly Recommended:** Practice tasks are optional, but if you complete them, you'll be well-prepared for exams! 😊

Complete 1-2 of the following practice tasks to reinforce your understanding:

### Practice Task 1: Library Management System with Advanced Features

**Requirements:**
Create a `LibrarySystem` class that integrates:
- Book management with categories and genres
- Member management with membership levels
- Borrowing system with due dates and fines
- Search functionality (by title, author, category)
- Statistics and reporting
- Use all concepts: arrays (1D, 2D), strings, methods, objects, static members, method overloading

**Key Methods to Implement:**
- `addBook(String title, String author, String category, String isbn)`
- `borrowBook(int memberIndex, int bookIndex, String dueDate)`
- `returnBook(int bookIndex, String returnDate)` - Calculate fine if overdue
- `searchBooks(String searchTerm)` - Search by title or author
- `getCategoryStatistics()` - Returns statistics by category
- `getMemberBorrowingHistory(int memberIndex)` - Returns array of borrowed books
- `calculateTotalFines()` - Returns total fines collected
- `generateLibraryReport()` - Comprehensive report

### Practice Task 2: Restaurant Management System

**Requirements:**
Create a `RestaurantSystem` class that manages:
- Menu items with categories and prices
- Orders and order processing
- Table management
- Staff management
- Sales tracking and analytics
- Customer feedback system

**Key Methods to Implement:**
- `addMenuItem(String name, String category, double price, String description)`
- `createOrder(int tableNumber, int[] itemIndices, int[] quantities)`
- `processOrder(int orderIndex)` - Updates inventory, calculates total
- `getMenuByCategory(String category)` - Returns array of menu item indices
- `calculateDailyRevenue(String date)` - Returns revenue for specific date
- `getPopularItems(int count)` - Returns top N most ordered items
- `manageTable(int tableNumber, String status)` - Status: "Available", "Occupied", "Reserved"
- `generateSalesReport()` - Comprehensive sales analysis

### Practice Task 3: School Management System

**Requirements:**
Create a `SchoolSystem` class that handles:
- Student enrollment and management
- Teacher assignment
- Class scheduling
- Grade management across multiple subjects
- Attendance tracking
- Parent-teacher communication records

**Key Methods to Implement:**
- `enrollStudent(String name, String id, int gradeLevel)`
- `assignTeacher(int classIndex, int teacherIndex)`
- `recordAttendance(int studentIndex, String date, boolean present)`
- `calculateAttendanceRate(int studentIndex)` - Returns percentage
- `getClassRoster(int classIndex)` - Returns array of student indices
- `generateReportCard(int studentIndex)` - Returns formatted report card
- `getTeacherSchedule(int teacherIndex)` - Returns array of classes taught
- `getSchoolStatistics()` - Comprehensive statistics

---

## Submission Guidelines

1. **✅ MANDATORY: Complete all three progressive tasks (Task 1, 2, 3)**
   - Task 1: Student Grade Calculator (Labs 1-2)
   - Task 2: Product Inventory System (Labs 3-4)
   - Task 3: Library Management System (Labs 5-6)
   - Each task should take approximately 45-60 minutes
2. **💡 OPTIONAL: Complete 1-2 practice tasks** (highly recommended for exam preparation!)
3. Ensure all code compiles without errors
4. Include comprehensive comments explaining:
   - Complex logic
   - Integration of concepts
   - Method purposes and parameters
5. Test all methods with various inputs including edge cases
6. Handle validation and error cases appropriately
7. Use proper Java naming conventions
8. Follow encapsulation principles (private attributes, public methods)
9. Submit one word file on elearning portal as discussed format

---

## Notes

### Important Structure:
- Create separate classes for each task (UniversitySystem, ECommercePlatform, HospitalSystem)
- Create a `Main` class with a `main` method to test each class
- Each task integrates multiple concepts from Labs 1-6
- Use proper access modifiers (private attributes, public methods)
- Apply method overloading where appropriate
- Use static members for class-level data
- Implement proper validation in all methods

### Best Practices:
- Use meaningful variable and method names
- Follow Java naming conventions (camelCase for methods/variables, PascalCase for classes)
- Validate all inputs
- Handle edge cases (null checks, empty arrays, boundary conditions)
- Use appropriate data structures
- Write reusable methods
- Document complex logic
- Test thoroughly with various scenarios

### Testing Guidelines:
- Test with normal inputs
- Test with edge cases (empty arrays, null values, boundary values)
- Test with invalid inputs (negative numbers, invalid formats)
- Test method overloading with different parameter types
- Test static vs instance methods
- Test array operations with various sizes
- Test string operations with different formats
- Verify encapsulation (cannot access private members directly)

---

## Problem-Solving Tips

1. **Plan First**: Break down each task into smaller parts
2. **Start Simple**: Implement basic structure first, then add advanced features
3. **Test Incrementally**: Test each method as you implement it
4. **Reuse Code**: Look for opportunities to reuse methods
5. **Validate Inputs**: Always validate inputs before processing
6. **Handle Errors**: Consider what happens with invalid inputs
7. **Document**: Comment complex logic for future reference
8. **Refactor**: Improve code organization as you go

---

## Additional Resources

- Review previous lab materials for specific concept details
- Java API documentation for String, Math, and Array operations
- Practice with smaller examples before tackling full tasks
- Test each concept individually before integrating

---

## Outcome

After completing this lab, students will have:
- Comprehensive understanding of all topics from Labs 1-6
- Ability to integrate multiple concepts in complex scenarios
- Experience designing and implementing complete systems
- Strong foundation in object-oriented programming
- Skills to solve real-world problems using Java
