# Lab 6: Problem Solving with Methods - Scenario-Based Tasks

## Table of Contents
1. [Introduction](#introduction)
2. [Key Concepts and Examples](#key-concepts-and-examples)
3. [Progressive Tasks](#progressive-tasks)
4. [Submission Guidelines](#submission-guidelines)

---

## Introduction

This lab focuses on problem-solving using methods through real-world scenarios. You will apply your knowledge of methods, classes, and object-oriented programming to solve practical problems. Each task presents a scenario that requires you to design and implement methods to solve specific problems.

**Objectives:**
- Apply method design principles to solve real-world problems
- Design methods for specific scenarios
- Implement solutions using appropriate method types
- Use method overloading where appropriate
- Handle edge cases and validation
- Create well-structured, reusable code

**Prerequisites:**
- Understanding of methods (static and non-static)
- Knowledge of method overloading
- Understanding of access modifiers
- Familiarity with control structures (if/else, loops)
- Understanding of arrays and strings

---

## Key Concepts and Examples

This section provides examples of key concepts you'll use in the lab tasks. Review these before starting the tasks.

### 1. String Arrays as Attributes

**What are String Arrays as Attributes?**
String arrays can be used as class attributes to store multiple related string values.

**How to use:**
```java
public class Student {
    private String[] subjectNames;  // Array of subject names
    
    public Student(String[] subjects) {
        this.subjectNames = subjects;
    }
    
    public void displaySubjects() {
        for (String subject : subjectNames) {
            System.out.println(subject);
        }
    }
}
```

**Example:**
```java
String[] subjects = {"Math", "Science", "English"};
Student student = new Student(subjects);
student.displaySubjects();
```

---

### 2. Two-Dimensional Arrays (2D Arrays)

**What are 2D Arrays?**
Two-dimensional arrays are arrays of arrays, useful for storing tabular data like grades for multiple subjects.

**How to use:**
```java
// Declaration
double[][] grades = new double[3][5];  // 3 subjects, 5 grades each

// Or initialize directly
double[][] grades = {
    {85.0, 90.0, 88.0, 92.0, 87.0},  // Math grades
    {78.0, 82.0, 80.0, 85.0, 79.0},  // Science grades
    {92.0, 95.0, 90.0, 93.0, 91.0}   // English grades
};
```

**Example:**
```java
public class GradeManager {
    private String[] subjectNames = {"Math", "Science", "English"};
    private double[][] subjectGrades = new double[3][10];  // 3 subjects, max 10 grades each
    
    public void addGrade(int subjectIndex, double grade) {
        // Find first empty slot in the subject's grade array
        for (int i = 0; i < subjectGrades[subjectIndex].length; i++) {
            if (subjectGrades[subjectIndex][i] == 0.0) {
                subjectGrades[subjectIndex][i] = grade;
                break;
            }
        }
    }
    
    public double getSubjectAverage(int subjectIndex) {
        double sum = 0;
        int count = 0;
        for (int i = 0; i < subjectGrades[subjectIndex].length; i++) {
            if (subjectGrades[subjectIndex][i] != 0.0) {
                sum += subjectGrades[subjectIndex][i];
                count++;
            }
        }
        return count > 0 ? sum / count : 0.0;
    }
}
```

---

### 3. Circular Buffer Pattern

**What is a Circular Buffer?**
A circular buffer is used to store a fixed number of items, overwriting the oldest when full. Useful for transaction history or temperature logs.

**How to use:**
```java
public class History {
    private String[] history = new String[10];
    private int count = 0;
    
    public void addRecord(String record) {
        int index = count % history.length;  // Circular index
        history[index] = record;
        count++;
    }
    
    public String[] getHistory() {
        // Return array with actual records
        int size = Math.min(count, history.length);
        String[] result = new String[size];
        int start = count > history.length ? count % history.length : 0;
        
        for (int i = 0; i < size; i++) {
            result[i] = history[(start + i) % history.length];
        }
        return result;
    }
}
```

**Example:**
```java
History history = new History();
for (int i = 1; i <= 15; i++) {
    history.addRecord("Transaction " + i);
}
// Only last 10 transactions are kept
```

---

### 4. Object Arrays

**What are Object Arrays?**
Arrays can store objects, allowing you to manage multiple instances of a class.

**How to use:**
```java
public class LibraryManager {
    private Library[] libraries = new Library[10];
    private int count = 0;
    
    public void addLibrary(Library lib) {
        if (count < libraries.length) {
            libraries[count] = lib;
            count++;
        }
    }
    
    public Library[] getLibraries() {
        Library[] result = new Library[count];
        for (int i = 0; i < count; i++) {
            result[i] = libraries[i];
        }
        return result;
    }
}
```

**Example:**
```java
LibraryManager manager = new LibraryManager();
manager.addLibrary(new Library("Book1", "B001"));
manager.addLibrary(new Library("Book2", "B002"));
Library[] allLibraries = manager.getLibraries();
```

---

### 5. Method Overloading with Arrays

**What is Method Overloading with Arrays?**
You can create multiple versions of a method - one that takes a single value and another that takes an array.

**How to use:**
```java
public class TemperatureMonitor {
    public void recordTemperature(double temp) {
        // Record single temperature
    }
    
    public void recordTemperature(double[] temps) {
        // Record multiple temperatures
        for (double temp : temps) {
            recordTemperature(temp);
        }
    }
}
```

**Example:**
```java
TemperatureMonitor monitor = new TemperatureMonitor();
monitor.recordTemperature(25.5);  // Single value
monitor.recordTemperature(new double[]{20.0, 22.0, 24.0});  // Array
```

---

### 6. Static Methods for Utility Operations

**What are Static Utility Methods?**
Static methods can operate on arrays of objects without needing an instance.

**How to use:**
```java
public class Inventory {
    private double unitPrice;
    private int quantity;
    
    public static double getTotalValue(Inventory[] products) {
        double total = 0;
        for (Inventory product : products) {
            if (product != null) {
                total += product.getTotalValue();
            }
        }
        return total;
    }
    
    public double getTotalValue() {
        return unitPrice * quantity;
    }
}
```

**Example:**
```java
Inventory[] products = {
    new Inventory("Item1", 10.0, 5),
    new Inventory("Item2", 20.0, 3),
    new Inventory("Item3", 15.0, 4)
};
double total = Inventory.getTotalValue(products);
```

---

### 7. Finding Elements in Arrays

**What is Finding Elements?**
Searching through arrays to find specific items based on conditions.

**How to use:**
```java
public class BookManager {
    private Library[] books = new Library[100];
    private int count = 0;
    
    public Library[] findOverdueBooks() {
        Library[] overdue = new Library[count];
        int overdueCount = 0;
        
        for (int i = 0; i < count; i++) {
            if (books[i].isOverdue()) {
                overdue[overdueCount] = books[i];
                overdueCount++;
            }
        }
        
        // Return array with actual size
        Library[] result = new Library[overdueCount];
        for (int i = 0; i < overdueCount; i++) {
            result[i] = overdue[i];
        }
        return result;
    }
}
```

**Example:**
```java
BookManager manager = new BookManager();
// Add books...
Library[] overdue = manager.findOverdueBooks();
for (Library book : overdue) {
    System.out.println(book.getBookInfo());
}
```

---

### 8. Working with String Arrays

**What are String Arrays?**
String arrays store multiple strings and are useful for names, categories, etc.

**How to use:**
```java
public class Product {
    private String[] categories = {"Electronics", "Clothing", "Food", "Books"};
    
    public boolean isValidCategory(String category) {
        for (String cat : categories) {
            if (cat.equals(category)) {
                return true;
            }
        }
        return false;
    }
    
    public String[] getCategories() {
        return categories.clone();  // Return copy to prevent modification
    }
}
```

**Example:**
```java
Product product = new Product();
if (product.isValidCategory("Electronics")) {
    System.out.println("Valid category");
}
String[] allCategories = product.getCategories();
```

---

### 9. Calculating Statistics from Arrays

**What are Array Statistics?**
Calculating averages, maximums, minimums, and other statistics from array data.

**How to use:**
```java
public class Statistics {
    public static double calculateAverage(double[] values) {
        if (values.length == 0) return 0.0;
        
        double sum = 0;
        for (double value : values) {
            sum += value;
        }
        return sum / values.length;
    }
    
    public static double findMaximum(double[] values) {
        if (values.length == 0) return Double.MIN_VALUE;
        
        double max = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }
        return max;
    }
    
    public static int findIndex(double[] values, double target) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == target) {
                return i;
            }
        }
        return -1;  // Not found
    }
}
```

**Example:**
```java
double[] temperatures = {20.5, 22.0, 18.5, 25.0, 21.0};
double avg = Statistics.calculateAverage(temperatures);
double max = Statistics.findMaximum(temperatures);
int index = Statistics.findIndex(temperatures, 25.0);
```

---

### 10. Varargs in Methods

**What are Varargs?**
Variable-length arguments allow methods to accept any number of arguments of the same type.

**How to use:**
```java
public class Calculator {
    public void addMultipleLibraries(Library... libraries) {
        for (Library lib : libraries) {
            // Process each library
            System.out.println("Added: " + lib.getBookTitle());
        }
    }
    
    public double calculateTotal(double... values) {
        double sum = 0;
        for (double value : values) {
            sum += value;
        }
        return sum;
    }
}
```

**Example:**
```java
Calculator calc = new Calculator();
calc.addMultipleLibraries(
    new Library("Book1", "B001"),
    new Library("Book2", "B002"),
    new Library("Book3", "B003")
);

double total = calc.calculateTotal(10.5, 20.0, 15.5, 30.0);
```

---

## Progressive Tasks

**Important:** Each task presents a scenario. You need to create a class with methods to solve the problem. Create a `Main` class with a `main` method to test your solutions. Each task builds upon concepts from previous labs.

---

### Task 1: Library Management System

**Scenario:**
You are developing a library management system. The system needs to track books, manage borrowing, and calculate fines.

**Requirements:**
Create a `Library` class with the following:

1. Private attributes:
   - `bookTitle` (String)
   - `bookId` (String)
   - `isAvailable` (boolean)
   - `borrowerName` (String)
   - `daysBorrowed` (int)

2. Constructors:
   - Default constructor
   - Parameterized constructor (bookTitle, bookId)

3. Methods:
   - `borrowBook(String borrowerName)` - Sets the book as borrowed, records borrower name, and sets daysBorrowed to 0
   - `returnBook()` - Marks book as available and clears borrower information
   - `calculateFine()` - Returns fine amount: $0.50 per day if daysBorrowed > 14, otherwise $0
   - `extendBorrowPeriod(int additionalDays)` - Adds days to daysBorrowed
   - `getBookInfo()` - Returns a formatted String with all book information
   - `isOverdue()` - Returns true if daysBorrowed > 14

4. Validation:
   - Cannot borrow if book is already borrowed
   - Cannot return if book is already available
   - Days must be positive

**Test Scenario:**
```java
// In Main class, test:
// 1. Create a book
// 2. Borrow it to "John"
// 3. Extend borrow period by 10 days
// 4. Check if overdue
// 5. Calculate fine
// 6. Return the book
```

---

### Task 2: Temperature Monitoring System

**Scenario:**
You are building a temperature monitoring system for a building. The system needs to track temperatures, detect anomalies, and provide statistics.

**Requirements:**
Create a `TemperatureMonitor` class with the following:

1. Private attributes:
   - `roomName` (String)
   - `currentTemperature` (double)
   - `minTemperature` (double)
   - `maxTemperature` (double)
   - `temperatureHistory` (double array of size 10)

2. Constructors:
   - Parameterized constructor (roomName, minTemp, maxTemp)

3. Methods:
   - `recordTemperature(double temp)` - Records temperature in history array (circular buffer)
   - `isTemperatureNormal()` - Returns true if currentTemperature is between min and max
   - `getTemperatureStatus()` - Returns "Normal", "Too Hot", or "Too Cold" based on current temperature
   - `getAverageTemperature()` - Returns average of all recorded temperatures
   - `getMaxRecordedTemperature()` - Returns maximum temperature from history
   - `getMinRecordedTemperature()` - Returns minimum temperature from history
   - `getTemperatureAlerts()` - Returns String array with all temperatures outside normal range
   - `updateTemperature(double newTemp)` - Updates currentTemperature and records it

4. Additional requirements:
   - Use method overloading: `recordTemperature(double temp)` and `recordTemperature(double[] temps)` (array version)
   - Validate that temperatures are reasonable (between -50 and 60 degrees Celsius)

**Test Scenario:**
```java
// In Main class, test:
// 1. Create monitor for "Office Room" (min: 18, max: 25)
// 2. Record several temperatures
// 3. Check status
// 4. Get statistics (average, min, max)
// 5. Get alerts for abnormal temperatures
```

---

### Task 3: Student Grade Management System

**Scenario:**
You need to create a system to manage student grades for multiple subjects. The system should calculate averages, determine letter grades, and identify top performers.

**Requirements:**
Create a `GradeManager` class with the following:

1. Private attributes:
   - `studentName` (String)
   - `studentId` (String)
   - `subjectGrades` (2D array: [subject][grades])
   - `subjectNames` (String array)

2. Constructors:
   - Parameterized constructor (studentName, studentId, subjectNames array)

3. Methods:
   - `addGrade(String subjectName, double grade)` - Adds a grade for a specific subject
   - `getSubjectAverage(String subjectName)` - Returns average grade for a subject
   - `getOverallAverage()` - Returns average of all grades across all subjects
   - `getLetterGrade(double average)` - Returns 'A', 'B', 'C', 'D', or 'F' based on average
   - `getBestSubject()` - Returns subject name with highest average
   - `getWorstSubject()` - Returns subject name with lowest average
   - `isPassing()` - Returns true if overall average >= 60
   - `getGradeReport()` - Returns formatted String with complete grade report
   - `getSubjectCount()` - Returns number of subjects
   - `getTotalGradesCount()` - Returns total number of grades recorded

4. Additional requirements:
   - Validate grades are between 0 and 100
   - Handle cases where subject has no grades
   - Use method overloading: `addGrade(String subject, double grade)` and `addGrade(String subject, double[] grades)`

**Test Scenario:**
```java
// In Main class, test:
// 1. Create grade manager for student with subjects: Math, Science, English
// 2. Add multiple grades for each subject
// 3. Calculate averages for each subject
// 4. Determine overall performance
// 5. Generate complete grade report
// 6. Identify best and worst subjects
```

---

### Task 4: Inventory Management System

**Scenario:**
You are developing an inventory management system for a store. The system needs to track products, manage stock levels, calculate values, and generate reports.

**Requirements:**
Create an `Inventory` class with the following:

1. Private attributes:
   - `productName` (String)
   - `productId` (String)
   - `quantity` (int)
   - `unitPrice` (double)
   - `category` (String)
   - `reorderLevel` (int)

2. Constructors:
   - Parameterized constructor (productName, productId, unitPrice, category, reorderLevel)

3. Methods:
   - `addStock(int amount)` - Adds stock quantity
   - `removeStock(int amount)` - Removes stock quantity (cannot go below 0)
   - `getTotalValue()` - Returns total inventory value (quantity * unitPrice)
   - `needsReorder()` - Returns true if quantity <= reorderLevel
   - `applyDiscount(double percentage)` - Applies discount to unitPrice
   - `updatePrice(double newPrice)` - Updates unit price
   - `getStockStatus()` - Returns "In Stock", "Low Stock", or "Out of Stock"
   - `calculateBulkPrice(int quantity)` - Returns price for bulk purchase (apply 10% discount if quantity >= 10)
   - `getInventoryInfo()` - Returns formatted String with all product information
   - `compareValue(Inventory other)` - Returns 1 if this product has higher value, -1 if lower, 0 if equal

4. Additional requirements:
   - Validate that quantity, price, and discount are non-negative
   - Discount percentage should be between 0 and 100
   - Use static method: `getTotalInventoryValue(Inventory[] products)` - Returns total value of all products

**Test Scenario:**
```java
// In Main class, test:
// 1. Create multiple inventory items
// 2. Add and remove stock
// 3. Check reorder status
// 4. Apply discounts
// 5. Calculate values
// 6. Compare products
// 7. Use static method to get total inventory value
```

---

### Task 5: Banking Transaction System

**Scenario:**
You need to create a banking system that handles accounts, transactions, and provides various banking operations.

**Requirements:**
Create a `BankAccount` class with the following:

1. Private attributes:
   - `accountNumber` (String)
   - `accountHolderName` (String)
   - `balance` (double)
   - `accountType` (String) - "Savings" or "Checking"
   - `transactionHistory` (String array of size 20)
   - `transactionCount` (int)

2. Constructors:
   - Parameterized constructor (accountNumber, accountHolderName, initialBalance, accountType)

3. Methods:
   - `deposit(double amount)` - Deposits money and records transaction
   - `withdraw(double amount)` - Withdraws money if sufficient balance, records transaction
   - `transfer(BankAccount recipient, double amount)` - Transfers money to another account
   - `calculateInterest()` - Returns interest: 2% for Savings, 0.5% for Checking
   - `applyInterest()` - Adds interest to balance
   - `getBalance()` - Returns current balance
   - `getTransactionHistory()` - Returns array of recent transactions
   - `getAccountSummary()` - Returns formatted String with account details
   - `isLowBalance()` - Returns true if balance < 100
   - `canWithdraw(double amount)` - Returns true if withdrawal is possible

4. Additional requirements:
   - Validate amounts are positive
   - Savings account: minimum balance of 500 required
   - Checking account: can go to 0, but charge $5 fee if balance < 100
   - Record all transactions in history (circular buffer)
   - Use method overloading: `deposit(double amount)` and `deposit(double amount, String description)`

**Test Scenario:**
```java
// In Main class, test:
// 1. Create savings and checking accounts
// 2. Perform deposits and withdrawals
// 3. Transfer money between accounts
// 4. Calculate and apply interest
// 5. Check low balance warnings
// 6. View transaction history
// 7. Generate account summaries
```

---

### Task 6: Fitness Tracker System

**Scenario:**
You are building a fitness tracker application that monitors workouts, calculates calories, and tracks progress.

**Requirements:**
Create a `FitnessTracker` class with the following:

1. Private attributes:
   - `userName` (String)
   - `dailySteps` (int)
   - `dailyCaloriesBurned` (double)
   - `workoutMinutes` (int)
   - `weeklySteps` (int array of size 7)
   - `goalSteps` (int)
   - `goalCalories` (double)

2. Constructors:
   - Parameterized constructor (userName, goalSteps, goalCalories)

3. Methods:
   - `addSteps(int steps)` - Adds steps to daily total
   - `recordWorkout(int minutes, String workoutType)` - Records workout and calculates calories
   - `calculateCaloriesBurned(int minutes, String workoutType)` - Returns calories based on type:
     - "Running": 10 calories/minute
     - "Walking": 5 calories/minute
     - "Cycling": 8 calories/minute
     - "Swimming": 12 calories/minute
     - Default: 6 calories/minute
   - `getDailyProgress()` - Returns percentage of daily goals achieved
   - `updateWeeklySteps(int dayIndex, int steps)` - Updates weekly steps array
   - `getWeeklyAverage()` - Returns average steps per day for the week
   - `getBestDay()` - Returns day index with highest steps
   - `isGoalAchieved()` - Returns true if both step and calorie goals are met
   - `resetDailyStats()` - Resets daily steps, calories, and workout minutes to 0
   - `getFitnessReport()` - Returns comprehensive fitness report as String

4. Additional requirements:
   - Validate that steps, minutes, and calories are non-negative
   - Day index must be between 0-6
   - Use method overloading: `recordWorkout(int minutes, String type)` and `recordWorkout(int minutes)`
   - Use static method: `compareProgress(FitnessTracker user1, FitnessTracker user2)` - Compares two users' progress

**Test Scenario:**
```java
// In Main class, test:
// 1. Create fitness tracker with goals
// 2. Add steps throughout the day
// 3. Record different types of workouts
// 4. Calculate calories burned
// 5. Track weekly progress
// 6. Check if goals are achieved
// 7. Generate fitness report
// 8. Compare progress between two users
```

---

### Task 7: Complete Integration - Multi-System Application

**Scenario:**
You need to integrate multiple systems from previous tasks into a comprehensive application management system.

**Requirements:**
Create a `SystemManager` class that integrates and manages:

1. Private attributes:
   - `libraries` (Library array)
   - `temperatureMonitors` (TemperatureMonitor array)
   - `gradeManagers` (GradeManager array)
   - `inventories` (Inventory array)
   - `bankAccounts` (BankAccount array)
   - `fitnessTrackers` (FitnessTracker array)

2. Constructors:
   - Default constructor that initializes all arrays with size 5

3. Methods:
   - `addLibrary(Library lib)` - Adds library to array
   - `addTemperatureMonitor(TemperatureMonitor monitor)` - Adds monitor to array
   - `addGradeManager(GradeManager manager)` - Adds grade manager to array
   - `addInventory(Inventory inv)` - Adds inventory to array
   - `addBankAccount(BankAccount account)` - Adds account to array
   - `addFitnessTracker(FitnessTracker tracker)` - Adds tracker to array
   - `getSystemStatistics()` - Returns String with statistics from all systems:
     - Total books borrowed
     - Average temperature across all monitors
     - Total students passing
     - Total inventory value
     - Total bank balance
     - Total steps across all trackers
   - `generateCompleteReport()` - Returns comprehensive report from all systems
   - `findOverdueBooks()` - Returns array of overdue books
   - `findLowStockItems()` - Returns array of items needing reorder
   - `findTopStudents()` - Returns array of students with highest averages
   - `getSystemHealth()` - Returns String indicating health status of all systems

4. Additional requirements:
   - Use varargs: `addMultipleLibraries(Library... libraries)` - Adds multiple libraries at once
   - Use command-line arguments in Main to initialize systems
   - All methods should handle empty arrays gracefully
   - Use method overloading where appropriate

**Test Scenario:**
```java
// In Main class, test:
// 1. Create SystemManager
// 2. Add items to each system
// 3. Perform operations on each system
// 4. Generate system statistics
// 5. Find specific items (overdue books, low stock, etc.)
// 6. Generate complete integrated report
// 7. Test with command-line arguments
```

---

## Submission Guidelines

1. Complete all progressive tasks (Task 1-7)
2. Ensure all code compiles without errors
3. Include comments explaining your problem-solving approach
4. Test all methods with different scenarios and edge cases
5. Handle validation and error cases appropriately
6. Submit one word file on elearning portal as discussed format

---

## Notes

- **Important Structure:**
  - Create separate classes for each task (Library, TemperatureMonitor, GradeManager, etc.)
  - Create a `Main` class with a `main` method to test each class
  - Each task is independent but builds on method concepts
- Focus on problem-solving and method design
- Think about edge cases and validate inputs
- Use appropriate access modifiers (private attributes, public methods)
- Apply method overloading where it makes sense
- Use static methods for utility functions
- Make methods reusable and well-organized
- Test with various scenarios including edge cases
- Consider real-world constraints (negative values, empty arrays, null checks)
- Use meaningful method and variable names
- Follow Java naming conventions
- Document complex logic with comments

---

## Problem-Solving Tips

1. **Understand the Scenario:** Read the scenario carefully and identify what needs to be solved
2. **Identify Required Data:** Determine what attributes are needed to store information
3. **Design Methods:** Think about what operations are needed and design methods accordingly
4. **Consider Edge Cases:** What happens with invalid input, empty data, or boundary conditions?
5. **Test Thoroughly:** Create test cases that cover normal operations, edge cases, and error conditions
6. **Refactor if Needed:** If you find better ways to organize code, refactor it

---

## Evaluation Criteria

- Correctness: Does the solution solve the problem correctly?
- Code Quality: Is the code well-organized and readable?
- Method Design: Are methods appropriately designed and reusable?
- Validation: Are inputs properly validated?
- Edge Cases: Are edge cases handled appropriately?
- Testing: Are methods tested with various scenarios?
