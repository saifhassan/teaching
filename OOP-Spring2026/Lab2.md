# Lab 2: Methods in Java

## Table of Contents
1. [Introduction](#introduction)
2. [Topic Explanations](#topic-explanations)
3. [Progressive Tasks](#progressive-tasks)
4. [Submission Guidelines](#submission-guidelines)

---

## Introduction

This lab focuses on understanding methods in Java. You will learn to define and call different types of methods, use methods with parameters and return values, apply control statements inside methods, and work with Strings and Arrays through methods. All methods in this lab are static, allowing them to be called directly from the main method without creating objects.

**Objectives:**
- Understand the purpose and importance of methods in Java
- Define and call different types of methods
- Use methods with parameters and return values
- Apply control statements including if-else, switch, and ternary inside methods
- Write methods that work with Strings and Arrays
- Use built-in Math class functions through methods
- Understand and use command-line arguments
- Organize logic into reusable and readable code

---

## Topic Explanations

### 1. Methods

**What are Methods?**
A method is a block of code that performs a specific task. Methods help reduce code repetition, improve readability, and make programs modular and manageable. In this lab, all methods are declared static so they can be called directly from the main method without creating objects.

**How to use:**
```java
static returnType methodName(parameters) {
    // method body
}
```

**Example:**
```java
static void greet() {
    System.out.println("Welcome to Java Methods Lab");
}
```

---

### 2. Types of Methods

#### 2.1 Method with No Parameters and No Return Value

**What is this type?**
This type of method is used when a task only performs an action such as displaying a message and does not need input or output.

**How to use:**
```java
static void greet() {
    System.out.println("Welcome to Java Methods Lab");
}
```

**Example:**
```java
public class MethodExample {
    static void displayMessage() {
        System.out.println("Hello from method!");
    }
    
    public static void main(String[] args) {
        displayMessage();
    }
}
```

---

#### 2.2 Method with Parameters and No Return Value

**What is this type?**
These methods accept input values as parameters and perform operations without returning a result.

**How to use:**
```java
static void printSquare(int num) {
    System.out.println("Square is: " + (num * num));
}
```

**Example:**
```java
static void printInfo(String name, int age) {
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
}
```

---

#### 2.3 Method with Return Value and No Parameters

**What is this type?**
This type of method performs a calculation and returns a value without taking any input parameters.

**How to use:**
```java
static int getFixedNumber() {
    return 10;
}
```

**Example:**
```java
static double getPi() {
    return 3.14159;
}
```

---

#### 2.4 Method with Parameters and Return Value

**What is this type?**
This is the most commonly used method type. It takes input, processes it, and returns a result.

**How to use:**
```java
static int add(int a, int b) {
    return a + b;
}
```

**Example:**
```java
static int multiply(int x, int y) {
    return x * y;
}
```

---

### 3. Methods with Control Statements

#### 3.1 If–Else Inside a Method

**What is If-Else in Methods?**
If–else statements allow decision-making inside methods based on conditions.

**How to use:**
```java
static String checkResult(int marks) {
    if (marks >= 40)
        return "Pass";
    else
        return "Fail";
}
```

**Example:**
```java
static String getGrade(int score) {
    if (score >= 90) {
        return "A";
    } else if (score >= 80) {
        return "B";
    } else if (score >= 70) {
        return "C";
    } else {
        return "F";
    }
}
```

---

#### 3.2 Ternary Operator in Methods

**What is Ternary Operator?**
The ternary operator is a short form of if–else used for simple conditional expressions.

**How to use:**
```java
static int findMax(int a, int b) {
    return (a > b) ? a : b;
}
```

**Example:**
```java
static String checkEven(int num) {
    return (num % 2 == 0) ? "Even" : "Odd";
}
```

---

#### 3.3 Switch Statement in Methods

**What is Switch in Methods?**
The switch statement is used when multiple conditions are based on a single variable value.

**How to use:**
```java
static String dayName(int day) {
    switch (day) {
        case 1: return "Monday";
        case 2: return "Tuesday";
        case 3: return "Wednesday";
        case 4: return "Thursday";
        case 5: return "Friday";
        default: return "Invalid Day";
    }
}
```

**Example:**
```java
static String getMonthName(int month) {
    switch (month) {
        case 1: return "January";
        case 2: return "February";
        case 3: return "March";
        default: return "Invalid Month";
    }
}
```

---

### 4. Methods with String Basics

#### 4.1 String Length

**What is String Length?**
The `length()` method returns the number of characters present in a string.

**How to use:**
```java
static int getLength(String text) {
    return text.length();
}
```

**Example:**
```java
static boolean isValidPassword(String password) {
    return password.length() >= 8;
}
```

---

#### 4.2 String Comparison

**What is String Comparison?**
Strings should be compared using `equals()` instead of `==` to compare actual content.

**How to use:**
```java
static boolean checkName(String name) {
    return name.equals("Ali");
}
```

**Example:**
```java
static boolean isMatch(String str1, String str2) {
    return str1.equals(str2);
}
```

---

#### 4.3 String Case Conversion

**What is String Case Conversion?**
Methods to convert strings to uppercase or lowercase.

**How to use:**
```java
static String convertToUpper(String word) {
    return word.toUpperCase();
}

static String convertToLower(String word) {
    return word.toLowerCase();
}
```

**Example:**
```java
static String formatName(String name) {
    return name.toUpperCase();
}
```

---

### 5. Methods with Arrays

#### 5.1 Sum of Array Elements

**What is Array Sum?**
Arrays can be passed to methods to perform calculations on multiple values.

**How to use:**
```java
static int sumArray(int[] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
        sum += arr[i];
    }
    return sum;
}
```

**Example:**
```java
static double averageArray(int[] arr) {
    int sum = sumArray(arr);
    return (double) sum / arr.length;
}
```

---

#### 5.2 Find Maximum Element in Array

**What is Finding Maximum?**
A method to find the largest value in an array.

**How to use:**
```java
static int findMax(int[] arr) {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] > max)
            max = arr[i];
    }
    return max;
}
```

**Example:**
```java
static int findMin(int[] arr) {
    int min = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] < min)
            min = arr[i];
    }
    return min;
}
```

---

### 6. Methods Using Math Class

**What is Math Class?**
The Math class provides built-in static methods for common mathematical operations. These methods can be used directly without creating objects.

**How to use:**

#### 6.1 Power Function
```java
static int calculatePower(int a, int b) {
    return (int) Math.pow(a, b);
}
```

#### 6.2 Absolute Value
```java
static int getAbsolute(int x) {
    return Math.abs(x);
}
```

**Example:**
```java
static double squareRoot(double num) {
    return Math.sqrt(num);
}

static int roundNumber(double num) {
    return (int) Math.round(num);
}
```

---

### 7. Command-Line Arguments

**What are Command-Line Arguments?**
Command-line arguments allow data to be passed to the program at the time of execution. They are received as an array of strings in the main method.

**How to use:**
```java
class CommandLineExample {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println("Sum: " + (a + b));
    }
}
```

**Example:**
```bash
# Compile
javac CommandLineExample.java

# Run with arguments
java CommandLineExample 10 20
# Output: Sum: 30
```

---

### 8. Complete Example Program

**Example:**
```java
class MethodLab2 {
    static int square(int x) {
        return x * x;
    }
    
    static boolean isPositive(int x) {
        return x > 0;
    }
    
    static String checkDay(int d) {
        return dayName(d);
    }
    
    static String dayName(int day) {
        switch (day) {
            case 1: return "Monday";
            case 2: return "Tuesday";
            default: return "Invalid";
        }
    }
    
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Square: " + square(n));
        System.out.println("Is Positive: " + isPositive(n));
        System.out.println("Day: " + checkDay(1));
    }
}
```

---

## Progressive Tasks

**Instructions:**
- Solve all tasks using methods only
- `main()` should only call methods and print results
- All methods must be static
- Focus on logic and clean implementation

---

### Task 0: Syntax Errors

**Requirements:**
Find the error in each broken code snippet, analyze it, and fix it.

| Broken Code | Find the Error | Fix It |
|-------------|---------------|--------|
| `static int add(int a int b){ return a+b; }` | | |
| `static void show(){ System.out.println("Hi") }` | | |
| `static int square(int x){ System.out.println(x*x); }` | | |
| `switch(x){ case 1: System.out.println("One") break; }` | | |
| `int[] arr = new int[5]` | | |
| `public static void main(String args){ }` | | |
| `static int max(int[] arr){ return arr.length }` | | |

---

### Task 1: Smart Number Analyzer

**Requirements:**
- **Method Type:** Return: String, Parameters: int n
- **Return:**
  - "Positive Even" if number is positive and even
  - "Positive Odd" if positive and odd
  - "Negative" if number is negative
  - "Zero" if number is 0

---

### Task 2: Conditional Calculator

**Requirements:**
- **Method Type:** Return: int, Parameters: int a, int b
- **Rules:**
  - If a > b, return a − b
  - If a < b, return b − a
  - If equal, return 0

---

### Task 3: Array Balance Checker

**Requirements:**
- **Method Type:** Return: boolean, Parameters: int[] arr
- Return true if sum of even elements equals sum of odd elements

---

### Task 4: Switch-Driven Grading System

**Requirements:**
- **Method Type:** Return: String, Parameters: int marks
- Use switch on (marks / 10):
  - 10 → Distinction
  - 9 → Excellent
  - 8 → Very Good
  - Others → Fail
- Note: marks are in range (0-100)

---

### Task 5: String Pattern Validator

**Requirements:**
- **Method Type:** Return: boolean, Parameters: String s
- Return true if:
  - Length ≥ 6
  - First character uppercase
  - Last character is a digit

---

### Task 6: Array Peak Finder

**Requirements:**
- **Method Type:** Return: int, Parameters: int[] arr
- Return index of the largest element
- If multiple max values exist, return first index

---

### Task 7: Math-Based Decision Maker

**Requirements:**
- **Method Type:** Return: String, Parameters: int a, int b
- Return "Perfect Square Difference" if |a − b| is a perfect square
- Otherwise return "Not Perfect Square"

---

### Task 8: Command-Line Validator

**Requirements:**
- **Method Type:** Return: void, Parameters: String[] args
- Accept 3 numbers via command-line and print:
  - Largest number
  - Smallest number
  - Difference between them

---

### Task 9: Array Trend Detector

**Requirements:**
- **Method Type:** Return: String, Parameters: int[] arr
- Return:
  - "Increasing" if strictly increasing order in numbers
  - "Decreasing" if strictly decreasing order in numbers
  - "Mixed" otherwise

---

### Task 10: Mini Decision Engine

**Requirements:**
- **Method Type:** Return: String, Parameters: int n
- Return:
  - "Prime Even" if n = 2
  - "Prime Odd" if prime and odd
  - "Composite" if not prime
  - "Invalid" if n ≤ 1

---

### Task 11: Debugging Practice

**Requirements:**
Find the error in each broken code snippet, analyze it, and fix it.

| Broken Code | Find the Error | Fix It |
|-------------|---------------|--------|
| `int[] a = new int[5]; a[5] = 10;` | | |
| `int sum; for(int i=0;i<arr.length;i++) sum+=arr[i];` | | |
| `static int max(int[] arr){ int m=0; ... }` | | |
| `switch(x){ case 1: System.out.println("One"); case 2: ... }` | | |
| `Integer.parseInt(args[0]);` | | |
| `static void calc(int a,int b){ return a+b; }` | | |
| `return arr[arr.length];` | | |
| `static String day(int d){ switch(d){ case 1: return "Mon"; case 2: return "Tue"; default: "Invalid"; } }` | | |
| `static int add(int a,int b){ System.out.println(a+b); }` | | |

---

## Submission Guidelines

1. Complete all progressive tasks (Task 0-11)
2. Ensure all code compiles without errors
3. Include comments explaining complex logic
4. Test all methods with different inputs
5. Submit one word file on elearning portal as discussed format

---

## Notes

- **Important Structure:**
  - All methods must be static
  - Write logic inside methods, not directly in main
  - Use meaningful method names
  - Follow proper indentation and formatting
- Use `equals()` for string comparison, not `==`
- Always check array bounds to avoid ArrayIndexOutOfBoundsException
- Initialize variables before use
- Use break statements in switch cases to prevent fall-through
- Test command-line arguments with proper number of arguments
- Pay attention to return types and ensure all code paths return a value

---

## Lab Guidelines

- All methods must be static
- Write logic inside methods, not directly in main
- Use meaningful method names
- Follow proper indentation and formatting

---

## Outcome

After completing this lab, students will be able to design modular Java programs using methods and apply control logic, strings, arrays, math operations, and command-line arguments effectively.
