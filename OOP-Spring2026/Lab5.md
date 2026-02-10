# Lab 5: A Closer Look at Methods and Classes

## Table of Contents
1. [Introduction](#introduction)
2. [Topic Explanations](#topic-explanations)
3. [Progressive Tasks](#progressive-tasks)
4. [Submission Guidelines](#submission-guidelines)

---

## Introduction

This lab provides a deeper understanding of methods and classes in Java. You will learn about method overloading, constructors, object parameters, recursion, access modifiers, static members, final keyword, string manipulation, and variable-length arguments. Each task builds upon the previous one, creating a comprehensive understanding of advanced class and method concepts.

**Objectives:**
- Understand method and constructor overloading
- Learn about object parameters and return types
- Understand argument passing mechanisms
- Implement recursive methods
- Apply access control modifiers
- Work with static members and blocks
- Use the final keyword appropriately
- Manipulate strings effectively
- Use command-line arguments and varargs

---

## Topic Explanations

### 1. Overloading Methods

**What is Method Overloading?**
Method overloading allows multiple methods with the same name but different parameters (different type or number of arguments). The return type alone is not sufficient to distinguish overloaded methods.

**How to use:**
```java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    
    public double add(double a, double b) {
        return a + b;
    }
    
    public int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

**Example:**
```java
Calculator calc = new Calculator();
int result1 = calc.add(5, 3);           // Calls first method
double result2 = calc.add(5.5, 3.2);    // Calls second method
int result3 = calc.add(1, 2, 3);        // Calls third method
```

#### Type Promotion in Overloading
Java automatically promotes smaller types to larger ones when no exact match is found.

**Example:**
```java
public void print(int x) {
    System.out.println("int: " + x);
}

// Calling with byte
byte b = 10;
print(b);  // Automatically promotes byte to int
```

---

### 2. Overloading Constructors

**What is Constructor Overloading?**
A class can have multiple constructors with different parameters, allowing objects to be initialized in different ways.

**How to use:**
```java
public class Student {
    private String name;
    private int age;
    
    // Default constructor
    public Student() {
        name = "Unknown";
        age = 0;
    }
    
    // Parameterized constructor
    public Student(String name) {
        this.name = name;
        this.age = 0;
    }
    
    // Full parameterized constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

**Example:**
```java
Student s1 = new Student();                    // Uses default constructor
Student s2 = new Student("John");             // Uses one-parameter constructor
Student s3 = new Student("John", 20);         // Uses two-parameter constructor
```

---

### 3. Using Object as Parameters

**What are Object Parameters?**
Methods can accept objects as parameters, allowing you to pass complex data structures to methods.

**How to use:**
```java
public class Rectangle {
    private int width;
    private int height;
    
    public boolean isLargerThan(Rectangle other) {
        int thisArea = this.width * this.height;
        int otherArea = other.width * other.height;
        return thisArea > otherArea;
    }
}
```

**Example:**
```java
Rectangle rect1 = new Rectangle(5, 10);
Rectangle rect2 = new Rectangle(3, 8);
boolean result = rect1.isLargerThan(rect2);
```

---

### 4. A Closer Look at Argument Passing

**What is Argument Passing?**
Java uses pass-by-value for all arguments. For primitive types, a copy of the value is passed. For objects, a copy of the reference is passed.

**How to use:**

**Pass by Value (Primitives):**
```java
public void modify(int x) {
    x = 100;  // Changes local copy, not original
}

int num = 10;
modify(num);
System.out.println(num);  // Still prints 10
```

**Pass by Reference (Objects):**
```java
public void modifyArray(int[] arr) {
    arr[0] = 100;  // Modifies the original array
}

int[] numbers = {1, 2, 3};
modifyArray(numbers);
System.out.println(numbers[0]);  // Prints 100
```

**Example:**
```java
// Primitive - value is copied
int a = 5;
changeValue(a);  // a remains 5

// Object - reference is copied, but object is shared
int[] arr = {1, 2, 3};
changeArray(arr);  // arr[0] is modified
```

---

### 5. Returning Objects from Methods

**What is Returning Objects?**
Methods can return objects as their return type, allowing methods to create and return new instances.

**How to use:**
```java
public class StudentFactory {
    public Student createStudent(String name, int age) {
        Student student = new Student(name, age);
        return student;
    }
    
    public Student createDefaultStudent() {
        return new Student();
    }
}
```

**Example:**
```java
StudentFactory factory = new StudentFactory();
Student s1 = factory.createStudent("John", 20);
Student s2 = factory.createDefaultStudent();
```

---

### 6. Recursion

**What is Recursion?**
Recursion is a programming technique where a method calls itself to solve a problem. It requires a base case to terminate the recursion.

**How to use:**
```java
public int factorial(int n) {
    if (n <= 1) {  // Base case
        return 1;
    }
    return n * factorial(n - 1);  // Recursive call
}
```

**Example:**
```java
// Factorial example
public int factorial(int n) {
    if (n == 0 || n == 1) {
        return 1;
    }
    return n * factorial(n - 1);
}

// Fibonacci example
public int fibonacci(int n) {
    if (n <= 1) {
        return n;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
}
```

---

### 7. Access Controls in Java

**What are Access Modifiers?**
Access modifiers control the visibility and accessibility of classes, methods, and variables.

**How to use:**
- **public**: Accessible from anywhere
- **private**: Accessible only within the same class
- **protected**: Accessible within the same package and subclasses
- **default** (no modifier): Accessible within the same package

**Example:**
```java
public class Example {
    public int publicVar;      // Accessible everywhere
    private int privateVar;     // Accessible only in this class
    protected int protectedVar; // Accessible in package and subclasses
    int defaultVar;            // Accessible only in package
}
```

---

### 8. Understanding Static Member Variables

**What are Static Variables?**
Static variables belong to the class, not to any specific instance. There is only one copy shared by all objects of the class.

**How to use:**
```java
public class Counter {
    private static int count = 0;  // Static variable
    
    public Counter() {
        count++;  // Incremented for every object created
    }
    
    public static int getCount() {
        return count;
    }
}
```

**Example:**
```java
Counter c1 = new Counter();
Counter c2 = new Counter();
Counter c3 = new Counter();
System.out.println(Counter.getCount());  // Prints 3
```

---

### 9. Understanding Static Member Methods

**What are Static Methods?**
Static methods belong to the class and can be called without creating an object. They can only access static members and cannot use `this` or `super`.

**How to use:**
```java
public class MathUtils {
    private static int value = 10;
    
    public static int add(int a, int b) {
        return a + b;
    }
    
    public static int getValue() {
        return value;  // Can access static variable
    }
}
```

**Example:**
```java
int result = MathUtils.add(5, 3);  // Called on class name
int val = MathUtils.getValue();
```

---

### 10. Understanding Static Code Block

**What is a Static Block?**
A static block is executed exactly once when the class is first loaded into memory, before any objects are created.

**How to use:**
```java
public class Example {
    static int value;
    
    static {
        value = 100;
        System.out.println("Static block executed");
    }
}
```

**Example:**
```java
public class DatabaseConnection {
    private static String connectionString;
    
    static {
        connectionString = "jdbc:mysql://localhost:3306/mydb";
        System.out.println("Database connection initialized");
    }
}
```

---

### 11. Introducing Keyword Final

**What is the Final Keyword?**
The `final` keyword can be used with variables, methods, and classes to prevent modification or overriding.

**How to use:**

**Final Variables:**
```java
public class Constants {
    public static final double PI = 3.14159;
    public final int MAX_SIZE = 100;
}
```

**Final Methods:**
```java
public class Parent {
    public final void display() {
        System.out.println("Cannot be overridden");
    }
}
```

**Example:**
```java
// Final variable - cannot be reassigned
final int x = 10;
// x = 20;  // Error: cannot assign to final variable

// Final method - cannot be overridden in subclass
public final void importantMethod() {
    // Implementation
}
```

---

### 12. Arrays Revisiting

**What are Arrays?**
Arrays are fixed-size collections of elements of the same type. The length is determined at creation time.

**How to use:**
```java
int[] arr = new int[5];  // Fixed size
int length = arr.length;  // Length property
```

**Example:**
```java
int[] numbers = {1, 2, 3, 4, 5};
System.out.println("Length: " + numbers.length);

// Iterating through array
for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}
```

---

### 13. String Class

**What is the String Class?**
String is a class in `java.lang` package. String objects are immutable. `StringBuffer` and `StringBuilder` are mutable alternatives.

**How to use:**
```java
String str1 = "Hello";
String str2 = new String("World");
String str3 = str1 + " " + str2;  // Concatenation
```

**Example:**
```java
String name = "John";
int length = name.length();              // 4
char ch = name.charAt(0);                // 'J'
boolean equal = name.equals("John");     // true
String upper = name.toUpperCase();       // "JOHN"
```

#### String Methods
- `equals()`: Compares string values
- `length()`: Returns string length
- `charAt(int index)`: Returns character at index
- `substring(int start)`: Returns substring
- `toUpperCase()`: Converts to uppercase
- `toLowerCase()`: Converts to lowercase

#### equals() vs == Operator
- `equals()`: Compares the actual string values
- `==`: Compares object references

**Example:**
```java
String s1 = "Hello";
String s2 = new String("Hello");
String s3 = "Hello";

System.out.println(s1.equals(s2));  // true (same value)
System.out.println(s1 == s2);       // false (different references)
System.out.println(s1 == s3);        // true (same reference due to string pool)
```

---

### 14. Command-Line Arguments

**What are Command-Line Arguments?**
Command-line arguments are passed to the program when it is executed. They are received as an array of strings in the `main` method.

**How to use:**
```java
public class CommandLineExample {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("Argument " + i + ": " + args[i]);
        }
    }
}
```

**Example:**
```bash
# Compile
javac CommandLineExample.java

# Run with arguments
java CommandLineExample arg1 arg2 arg3
# Output:
# Argument 0: arg1
# Argument 1: arg2
# Argument 2: arg3
```

---

### 15. Varargs: Variable Length Arguments

**What are Varargs?**
Varargs (variable-length arguments) allow methods to accept a variable number of arguments. Introduced in JDK 5.

**How to use:**
```java
public void printNumbers(int... numbers) {
    for (int num : numbers) {
        System.out.println(num);
    }
}
```

**Example:**
```java
// Old style (using array)
public void oldMethod(int[] numbers) {
    // Implementation
}

// New style (using varargs)
public void newMethod(int... numbers) {
    for (int num : numbers) {
        System.out.println(num);
    }
}

// Usage
newMethod(1, 2, 3, 4, 5);
newMethod(10, 20);
newMethod();  // No arguments
```

**Important Rules:**
- Varargs must be the last parameter
- Only one varargs parameter per method
- Can cause ambiguity in method overloading

---

## Progressive Tasks

**Important:** Each task builds on the previous one. You will modify the same class by adding new methods and features. Create a `Main` class with a `main` method to test your class.

---

### Task 1: Basic Class with Overloaded Methods and Constructors

Create a `Calculator` class with the following requirements:

**Requirements:**
1. Private attributes: `result` (double)
2. Default constructor that initializes result to 0.0
3. Parameterized constructor that takes a double value
4. Overloaded `add()` methods:
   - `add(int a, int b)` - returns int
   - `add(double a, double b)` - returns double
   - `add(int a, int b, int c)` - returns int
5. Overloaded `multiply()` methods:
   - `multiply(int a, int b)` - returns int
   - `multiply(double a, double b)` - returns double
6. Method `getResult()` that returns the current result
7. Method `reset()` that sets result to 0.0
8. Use `this` keyword appropriately

**Create a Main class to test:**
```java
public class Main {
    public static void main(String[] args) {
        Calculator calc1 = new Calculator();
        Calculator calc2 = new Calculator(10.5);
        
        // Test overloaded methods
        // Display results
    }
}
```

---

### Task 2: Add Object Parameters and Return Types

**Modify your Calculator class from Task 1** by adding the following methods:

**Requirements:**
1. Method `compare(Calculator other)` that returns true if this calculator's result is greater than the other's result
2. Method `addResult(Calculator other)` that adds the other calculator's result to this one and returns a new Calculator object
3. Method `createCopy()` that returns a new Calculator object with the same result value
4. Method `isEqual(Calculator other)` that returns true if both calculators have the same result

**Update your Main class to test object parameters and return types.**

---

### Task 3: Add Recursive Methods

**Modify your Calculator class from Task 2** by adding the following recursive methods:

**Requirements:**
1. Method `factorial(int n)` that calculates factorial recursively
2. Method `power(int base, int exponent)` that calculates base^exponent recursively
3. Method `sumOfDigits(int num)` that calculates sum of digits recursively
4. Method `fibonacci(int n)` that returns the nth Fibonacci number recursively
5. All methods should have proper base cases

**Update your Main class to test recursive methods.**

---

### Task 4: Add Static Members and Access Control

**Modify your Calculator class from Task 3** by adding the following:

**Requirements:**
1. Add a static variable `operationCount` to count total operations performed
2. Add a static method `getOperationCount()` that returns the operation count
3. Add a static block that initializes operationCount to 0 and prints a message
4. Modify all calculation methods to increment `operationCount`
5. Add a private method `validateInput(double value)` that checks if value is valid (not NaN, not Infinity)
6. Use this validation in your methods
7. Add a protected method `getInternalState()` that returns a String representation of internal state
8. Demonstrate different access modifiers (public, private, protected)

**Update your Main class to test static members and access control.**

---

### Task 5: Add Final Members and String Operations

**Modify your Calculator class from Task 4** by adding the following:

**Requirements:**
1. Add a final static variable `MAX_RESULT` with value 1000000.0
2. Add a final instance variable `calculatorId` (String) that is set in constructor
3. Add a method `validateResult()` that checks if result exceeds MAX_RESULT
4. Add method `getHistory()` that returns a String array of operation history
5. Add method `formatResult()` that returns a formatted String of the result
6. Add method `parseAndCalculate(String expression)` that parses simple expressions like "5+3" and calculates
7. Use String methods: `equals()`, `length()`, `charAt()`, `substring()`, `indexOf()`

**Update your Main class to test final members and string operations.**

---

### Task 6: Complete Integration and Report Generation

**Modify your Calculator class from Task 5** by adding the following:

**Requirements:**
1. Add method `completeCalculatorReport()` that:
   - Uses all previous methods
   - Returns a comprehensive formatted String report
   - Includes result, operation count, history, and all relevant information
2. Add method `getStatistics()` that returns a String with:
   - Total operations performed
   - Current result
   - Result validation status
   - Calculator ID
3. Add method `displayFullReport()` that prints a formatted report to console
4. Ensure all methods from previous tasks are integrated and working together

**Update your Main class to demonstrate everything:**
```java
public class Main {
    public static void main(String[] args) {
        // Create calculator
        // Test all methods
        // Show complete report
        // Display statistics
        // Test command-line arguments if provided
    }
}
```

---

### Task 7: Add Varargs and Command-Line Arguments

**Modify your Calculator class from Task 6** by adding the following:

**Requirements:**
1. Add method `addMultiple(int... numbers)` that adds multiple integers using varargs
2. Add method `multiplyMultiple(double... numbers)` that multiplies multiple doubles using varargs
3. Add method `findMax(int... numbers)` that finds maximum using varargs
4. Add method `findMin(int... numbers)` that finds minimum using varargs
5. Add static method `processCommandLine(String[] args)` that:
   - Accepts command-line arguments
   - Parses numbers from arguments
   - Performs calculations based on arguments
   - Displays results

**Update your Main class:**
```java
public class Main {
    public static void main(String[] args) {
        // If command-line arguments provided, use them
        if (args.length > 0) {
            Calculator.processCommandLine(args);
        } else {
            // Otherwise, run normal tests
            // Demonstrate varargs methods
        }
    }
}
```

---

## Submission Guidelines

1. Complete all progressive tasks (Task 1-7)
2. Ensure all code compiles without errors
3. Include comments explaining complex logic, especially recursive methods
4. Test all methods with different inputs
5. Test command-line arguments with various inputs
6. Submit one word file on elearning portal as discussed format

---

## Notes

- **Important Structure:**
  - Create ONE class (e.g., `Calculator`) with all methods, constructors, getters, setters, and attributes
  - Create a separate `Main` class with a `main` method to test your class
  - Each task MODIFIES the same class by adding new methods - do not create new classes
- Each task builds upon the previous one, so make sure Task 1 works correctly before moving to Task 2
- When adding new methods in later tasks, keep all previous methods from earlier tasks
- For recursion, always ensure you have a proper base case to avoid infinite recursion
- Static members belong to the class, not instances
- Final variables cannot be reassigned after initialization
- Varargs must be the last parameter and there can be only one per method
- Use meaningful variable and method names
- Follow Java naming conventions (camelCase for methods/variables, PascalCase for classes)
- Test your code with different inputs to ensure it works correctly
- Pay attention to access modifiers and their visibility
- In the Main class, create objects of your class and call methods to demonstrate functionality
