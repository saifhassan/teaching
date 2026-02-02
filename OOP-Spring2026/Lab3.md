# Lab 3: Objects, Instance Methods & Encapsulation

## Table of Contents
1. [Introduction](#introduction)
2. [Topic Explanations](#topic-explanations)
3. [Progressive Tasks](#progressive-tasks)
4. [Submission Guidelines](#submission-guidelines)

---

## Introduction

This lab introduces object-oriented programming concepts in Java. You will learn the difference between static and non-static members, create classes with instance variables, work with objects, use constructors, and implement basic encapsulation using private access modifiers, getters, and setters.

**Objectives:**
- Understand the difference between static and non-static members
- Define classes with instance variables
- Create and use objects in Java
- Call non-static methods using objects
- Understand reference variables and object aliasing
- Use constructors to initialize objects
- Apply basic encapsulation using private
- Implement getters and setters
- Use the this keyword correctly

**Prerequisite:**
Students should have completed Lab 2 and must be familiar with static methods, control statements, arrays, and basic Java syntax.

---

## Topic Explanations

### 1. Transition from Static to Object-Oriented Programming

**What is the difference?**
Static methods belong to the class, whereas non-static methods belong to objects. Object-oriented programming focuses on methods operating on object data.

**How to use:**

**Static Method:**
```java
static int add(int a, int b) {
    return a + b;
}
```

**Non-static Method:**
```java
int add(int a, int b) {
    return a + b;
}
```

**Example:**
```java
// Static - called using class name
Math.add(5, 3);

// Non-static - called using object
Calculator calc = new Calculator();
calc.add(5, 3);
```

---

### 2. Class and Object Basics

**What are Classes and Objects?**
A class is a blueprint, and an object is an instance created from that class.

**How to use:**
```java
class Student {
    String name;
    int age;
}

Student s1 = new Student();
```

**Example:**
```java
class Car {
    String brand;
    String color;
}

// Creating objects
Car car1 = new Car();
car1.brand = "Toyota";
car1.color = "Red";

Car car2 = new Car();
car2.brand = "Honda";
car2.color = "Blue";
```

---

### 3. Instance Variables vs Local Variables

**What is the difference?**
Instance variables belong to objects, while local variables exist only within methods.

**How to use:**
```java
class Student {
    String name;        // Instance variable
    int age;            // Instance variable
    
    void show() {
        int x = 10;     // Local variable
    }
}
```

**Example:**
```java
class Rectangle {
    double length;      // Instance variable
    double width;       // Instance variable
    
    void calculateArea() {
        double area;    // Local variable
        area = length * width;
        System.out.println("Area: " + area);
    }
}
```

---

### 4. Object Creation and Method Calling

**What is Object Creation?**
Non-static members are accessed using objects and the dot operator.

**How to use:**
```java
Student s1 = new Student();
s1.name = "Ali";
s1.age = 20;
s1.display();
```

**Example:**
```java
class BankAccount {
    String accountNumber;
    double balance;
    
    void deposit(double amount) {
        balance += amount;
    }
    
    void display() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

// Usage
BankAccount acc = new BankAccount();
acc.accountNumber = "ACC001";
acc.balance = 1000.0;
acc.deposit(500.0);
acc.display();
```

---

### 5. Reference Variables and Object Aliasing

**What is Object Aliasing?**
Multiple references can point to the same object.

**How to use:**
```java
Student s1 = new Student();
Student s2 = s1;  // s2 points to same object as s1
s1.name = "Ali";
System.out.println(s2.name);  // Prints "Ali"
```

**Example:**
```java
class Box {
    int value;
}

Box box1 = new Box();
box1.value = 10;

Box box2 = box1;  // Both reference same object
box2.value = 20;

System.out.println(box1.value);  // Prints 20
System.out.println(box2.value);  // Prints 20
```

---

### 6. Constructors

**What is a Constructor?**
Constructors initialize objects and are called automatically when an object is created.

**How to use:**
```java
class Student {
    String name;
    int age;
    
    Student(String n, int a) {
        name = n;
        age = a;
    }
}
```

**Example:**
```java
class Person {
    String name;
    int age;
    
    // Default constructor
    Person() {
        name = "Unknown";
        age = 0;
    }
    
    // Parameterized constructor
    Person(String n, int a) {
        name = n;
        age = a;
    }
}

// Creating objects
Person p1 = new Person();              // Uses default constructor
Person p2 = new Person("John", 25);    // Uses parameterized constructor
```

---

### 7. Encapsulation

**What is Encapsulation?**
Encapsulation hides data using `private` and provides controlled access.

**How to use:**
```java
class Student {
    private int age;  // Private - cannot be accessed directly
}
```

**Example:**
```java
class BankAccount {
    private double balance;  // Hidden from direct access
    
    // Controlled access through methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}
```

---

### 8. Getters and Setters

**What are Getters and Setters?**
Getters and setters access private data safely.

**How to use:**
```java
class Student {
    private int age;
    
    void setAge(int a) {
        age = a;
    }
    
    int getAge() {
        return age;
    }
}
```

**Example:**
```java
class Employee {
    private String name;
    private double salary;
    
    // Setter with validation
    public void setSalary(double sal) {
        if (sal > 0) {
            salary = sal;
        }
    }
    
    // Getter
    public double getSalary() {
        return salary;
    }
    
    public void setName(String n) {
        name = n;
    }
    
    public String getName() {
        return name;
    }
}
```

---

### 9. This Keyword

**What is the 'this' keyword?**
`this` refers to the current object and resolves naming conflicts.

**How to use:**
```java
class Student {
    private int age;
    
    void setAge(int age) {
        this.age = age;  // 'this.age' refers to instance variable
    }
}
```

**Example:**
```java
class Rectangle {
    private int width;
    private int height;
    
    Rectangle(int width, int height) {
        this.width = width;    // Instance variable
        this.height = height;  // Instance variable
    }
    
    void setDimensions(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
```

---

## Progressive Tasks

**Instructions:**
- All methods must be non-static (except main)
- Use private data members wherever applicable
- Access data using constructors, getters, and setters
- Do not write logic directly inside main

---

### Task 1: Student Profile Management

**Requirements:**
Create a class named `Student` with the following private fields:
- `id` (int)
- `name` (String)
- `age` (int)
- `cgpa` (double)

**Requirements:**
1. Create setters and getters for all fields
2. Validate age (15–60) and cgpa (0.0–4.0)
3. If invalid data is provided, do not update the value and display a message
4. Create an instance method `display()` to print complete student information

**In main:**
- Create two Student objects
- Set values using setters and display both objects

---

### Task 2: Bank Account System

**Requirements:**
Create a class named `BankAccount` with the following private fields:
- `accountNumber` (String)
- `accountHolder` (String)
- `balance` (double)

**Requirements:**
1. Use a parameterized constructor to initialize all fields
2. Create methods `deposit(amount)` and `withdraw(amount)`
3. Deposit amount must be greater than 0
4. Withdrawal amount must be greater than 0 and less than or equal to balance
5. Create a method `getBalance()` that returns current balance
6. Create a method `printStatement()` to display account details

**In main:**
- Create one account object
- Perform multiple deposits and withdrawals
- Display account details after each operation

---

### Task 3: Car Showroom Inventory

**Requirements:**
Create a class named `Car` with the following private fields:
- `brand` (String)
- `model` (String)
- `year` (int)
- `price` (double)

**Requirements:**
1. Create a parameterized constructor using the `this` keyword
2. Create a `display()` method to print car details
3. Create a getter for price only

**In main:**
- Create three Car objects
- Display all car details
- Identify and display the most expensive car

---

### Task 4: Reference and Object Aliasing Demonstration

**Requirements:**
Create a class named `Box` with the following fields:
- `length` (double)
- `width` (double)

**Requirements:**
1. Create an instance method `area()` that returns the area
2. In main:
   - Create one Box object and assign values
   - Create another reference pointing to the same object
   - Modify dimensions using the second reference
   - Print area using both references

**Observation:**
- Both references should reflect the same updated area

---

### Task 5: Employee Salary Calculator

**Requirements:**
Create a class named `Employee` with the following private fields:
- `employeeId` (int)
- `name` (String)
- `basicSalary` (double)

**Requirements:**
1. Create setters and getters with validation (basicSalary ≥ 30000)
2. Create methods:
   - `hra()` → returns 20% of basic salary
   - `tax()` → returns 5% of basic salary
   - `netSalary()` → returns basic + hra − tax
   - `printSlip()` → prints formatted salary slip

**In main:**
- Create two Employee objects
- Display salary slips for both employees

---

## Submission Guidelines

1. Complete all progressive tasks (Task 1-5)
2. Ensure all code compiles without errors
3. Include comments explaining complex logic
4. Test all methods with different inputs
5. Submit one word file on elearning portal as discussed format

---

## Notes

- **Important Structure:**
  - All methods must be non-static (except main)
  - Use private data members wherever applicable
  - Access data using constructors, getters, and setters
  - Do not write logic directly inside main
- Use `this` keyword to distinguish between instance variables and parameters
- Always validate input in setters
- Private members can only be accessed within the same class
- Multiple references can point to the same object (aliasing)
- Constructors are called automatically when objects are created
- Use meaningful names for classes, methods, and variables
- Follow proper encapsulation principles

---

## Key Concepts Summary

1. **Static vs Non-static:** Static belongs to class, non-static belongs to objects
2. **Classes and Objects:** Class is blueprint, object is instance
3. **Instance Variables:** Belong to objects, exist throughout object's lifetime
4. **Local Variables:** Exist only within method scope
5. **Constructors:** Initialize objects, called automatically
6. **Encapsulation:** Hide data using private, provide controlled access
7. **Getters and Setters:** Access private data safely
8. **This Keyword:** Refers to current object, resolves naming conflicts
9. **Object Aliasing:** Multiple references to same object
