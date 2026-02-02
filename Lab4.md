# Lab 4: Java Fundamentals - Operators, Control Flow, Classes, and Arrays

## Table of Contents
1. [Introduction](#introduction)
2. [Topic Explanations](#topic-explanations)
3. [Progressive Tasks](#progressive-tasks)
4. [Practice Tasks](#practice-tasks)

---

## Introduction

This lab covers fundamental Java concepts including operators, control flow structures, object-oriented programming basics, and array manipulation. Each task builds upon the previous one, creating a comprehensive understanding of Java programming fundamentals.

---

## Topic Explanations

### 1. Logical and Relational Operators

**What are Logical and Relational Operators?**
- **Relational Operators**: Compare two values and return a boolean result (`true` or `false`)
  - `==` (equal to)
  - `!=` (not equal to)
  - `>` (greater than)
  - `<` (less than)
  - `>=` (greater than or equal to)
  - `<=` (less than or equal to)

- **Logical Operators**: Combine or modify boolean expressions
  - `&&` (AND) - returns true if both conditions are true
  - `||` (OR) - returns true if at least one condition is true
  - `!` (NOT) - reverses the boolean value

**How to use:**
```java
int a = 5, b = 10;
boolean result1 = a < b;        // true
boolean result2 = a == b;       // false
boolean result3 = (a < b) && (a > 0);  // true
boolean result4 = (a > b) || (a < 0);  // false
```

**Example:**
```java
int age = 20;
if (age >= 18 && age <= 65) {
    System.out.println("Working age");
}
```

---

### 2. Basic Data Types

**What are Basic Data Types?**
Java has primitive data types that store simple values:
- `byte` (8-bit integer)
- `short` (16-bit integer)
- `int` (32-bit integer)
- `long` (64-bit integer)
- `float` (32-bit floating point)
- `double` (64-bit floating point)
- `char` (16-bit Unicode character)
- `boolean` (true or false)

**How to use:**
```java
int number = 42;
double price = 19.99;
char grade = 'A';
boolean isActive = true;
```

**Example:**
```java
int studentId = 12345;
double gpa = 3.75;
char letterGrade = 'B';
boolean isGraduated = false;
```

---

### 3. String Handling

**What is String Handling?**
Strings in Java are objects (not primitives) that represent sequences of characters. The `String` class provides many methods for manipulating strings.

**How to use:**
```java
String str = "Hello";
int length = str.length();                    // 5
String upper = str.toUpperCase();             // "HELLO"
String lower = str.toLowerCase();             // "hello"
boolean contains = str.contains("ell");       // true
String substring = str.substring(1, 4);       // "ell"
String concat = str.concat(" World");         // "Hello World"
boolean equals = str.equals("Hello");         // true
```

**Example:**
```java
String name = "John Doe";
System.out.println("Length: " + name.length());
System.out.println("First name: " + name.substring(0, 4));
System.out.println("Uppercase: " + name.toUpperCase());
```

---

### 4. Break and Continue Statements

**What are Break and Continue?**
- **break**: Exits the loop immediately
- **continue**: Skips the current iteration and continues with the next iteration

**How to use:**
```java
// break example
for (int i = 0; i < 10; i++) {
    if (i == 5) {
        break;  // exits loop when i is 5
    }
    System.out.println(i);
}

// continue example
for (int i = 0; i < 10; i++) {
    if (i % 2 == 0) {
        continue;  // skips even numbers
    }
    System.out.println(i);
}
```

**Example:**
```java
// Find first number divisible by 7
for (int i = 1; i <= 100; i++) {
    if (i % 7 == 0) {
        System.out.println("Found: " + i);
        break;
    }
}
```

---

### 5. For-Each Loop (Enhanced For Loop)

**What is For-Each Loop?**
A simplified loop syntax for iterating through arrays and collections without using index variables.

**How to use:**
```java
int[] numbers = {1, 2, 3, 4, 5};
for (int num : numbers) {
    System.out.println(num);
}
```

**Example:**
```java
String[] names = {"Alice", "Bob", "Charlie"};
for (String name : names) {
    System.out.println("Hello, " + name);
}
```

---

### 6. If/Else/Switch Statements

**What are If/Else/Switch?**
Control flow structures that allow conditional execution of code:
- **if/else**: Executes code based on boolean conditions
- **switch**: Executes code based on matching a value

**How to use:**
```java
// if/else
int score = 85;
if (score >= 90) {
    System.out.println("Grade: A");
} else if (score >= 80) {
    System.out.println("Grade: B");
} else {
    System.out.println("Grade: C");
}

// switch
int day = 3;
switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    default:
        System.out.println("Other day");
}
```

**Example:**
```java
char operation = '+';
int a = 10, b = 5;
switch (operation) {
    case '+':
        System.out.println(a + b);
        break;
    case '-':
        System.out.println(a - b);
        break;
    case '*':
        System.out.println(a * b);
        break;
    default:
        System.out.println("Invalid operation");
}
```

---

### 7. Constructors

**What is a Constructor?**
A special method that is called when an object is created. It initializes the object's state.

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
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

**Example:**
```java
Student s1 = new Student();              // Uses default constructor
Student s2 = new Student("John", 20);    // Uses parameterized constructor
```

---

### 8. Methods

**What are Methods?**
Blocks of code that perform specific tasks. Methods can take parameters and return values.

**How to use:**
```java
public class Calculator {
    // Method with parameters and return value
    public int add(int a, int b) {
        return a + b;
    }
    
    // Method without return value (void)
    public void displayMessage(String msg) {
        System.out.println(msg);
    }
}
```

**Example:**
```java
Calculator calc = new Calculator();
int result = calc.add(5, 3);  // result = 8
calc.displayMessage("Calculation complete");
```

---

### 9. Method Overloading

**What is Method Overloading?**
Defining multiple methods with the same name but different parameters (different number or types).

**How to use:**
```java
public class MathUtils {
    public int add(int a, int b) {
        return a + b;
    }
    
    public int add(int a, int b, int c) {
        return a + b + c;
    }
    
    public double add(double a, double b) {
        return a + b;
    }
}
```

**Example:**
```java
MathUtils utils = new MathUtils();
int sum1 = utils.add(2, 3);           // Calls first method
int sum2 = utils.add(2, 3, 4);        // Calls second method
double sum3 = utils.add(2.5, 3.5);    // Calls third method
```

---

### 10. Objects

**What are Objects?**
Instances of classes that contain data (attributes) and behavior (methods).

**How to use:**
```java
// Class definition
public class Car {
    String brand;
    String color;
    
    public void start() {
        System.out.println("Car started");
    }
}

// Creating and using objects
Car myCar = new Car();
myCar.brand = "Toyota";
myCar.color = "Red";
myCar.start();
```

**Example:**
```java
Car car1 = new Car();
car1.brand = "Honda";
Car car2 = new Car();
car2.brand = "Ford";
```

---

### 11. Private Attributes

**What are Private Attributes?**
Class attributes marked with `private` keyword that can only be accessed within the same class, not from outside.

**How to use:**
```java
public class BankAccount {
    private double balance;  // Private attribute
    
    public void deposit(double amount) {
        balance += amount;  // Can access within class
    }
}
```

**Example:**
```java
BankAccount account = new BankAccount();
// account.balance = 1000;  // ERROR: Cannot access private attribute
account.deposit(1000);  // Must use public method
```

---

### 12. Getter and Setter Methods

**What are Getters and Setters?**
Public methods used to access (get) and modify (set) private attributes.

**How to use:**
```java
public class Person {
    private String name;
    private int age;
    
    // Getter methods
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    // Setter methods
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
}
```

**Example:**
```java
Person person = new Person();
person.setName("Alice");
person.setAge(25);
System.out.println(person.getName());  // "Alice"
System.out.println(person.getAge());   // 25
```

---

### 13. Class and Main Class - Calling Methods from Other Classes

**What is the difference?**
- **Regular Class**: Contains attributes and methods for a specific purpose
- **Main Class**: Contains the `main` method, which is the entry point of the program. It can create objects of other classes and call their methods.

**How to use:**
```java
// Student.java - Regular class
public class Student {
    private String name;
    
    public void displayInfo() {
        System.out.println("Student: " + name);
    }
}

// Main.java - Main class
public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.displayInfo();  // Calling method from Student class
    }
}
```

**Example:**
```java
// Calculator.java
public class Calculator {
    public int multiply(int a, int b) {
        return a * b;
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int result = calc.multiply(5, 4);
        System.out.println("Result: " + result);
    }
}
```

---

### 14. This Keyword (Basic)

**What is the 'this' keyword?**
A reference to the current object. It's used to distinguish between instance variables and parameters with the same name.

**How to use:**
```java
public class Student {
    private String name;
    
    public void setName(String name) {
        this.name = name;  // 'this.name' refers to instance variable
    }
    
    public String getName() {
        return this.name;  // Optional but clear
    }
}
```

**Example:**
```java
public class Rectangle {
    private int width;
    private int height;
    
    public Rectangle(int width, int height) {
        this.width = width;    // Instance variable
        this.height = height;  // Instance variable
    }
}
```

---

### 15. Type Conversion and Casting

**What is Type Conversion and Casting?**
- **Automatic Conversion (Widening)**: Converting smaller types to larger types (e.g., int to double)
- **Explicit Casting (Narrowing)**: Converting larger types to smaller types using cast operator

**How to use:**
```java
// Automatic conversion
int num = 10;
double decimal = num;  // Automatically converts int to double

// Explicit casting
double price = 19.99;
int roundedPrice = (int) price;  // Casts double to int (19)

// Char to int
char letter = 'A';
int ascii = (int) letter;  // 65
```

**Example:**
```java
int a = 10;
double b = a;           // Automatic: 10.0
double c = 15.7;
int d = (int) c;        // Explicit: 15
```

---

### 16. Automatic Type Promotion in Expressions

**What is Automatic Type Promotion?**
Java automatically promotes smaller data types to larger ones in expressions to prevent data loss.

**How to use:**
```java
byte b = 10;
int i = 20;
long result = b + i;  // byte and int promoted to long

int x = 5;
double y = 2.5;
double result2 = x + y;  // int promoted to double
```

**Example:**
```java
byte a = 5;
short b = 10;
int c = 15;
long result = a + b + c;  // All promoted to long
```

---

### 17. Arrays (One Dimension and Multi Dimension)

**What are Arrays?**
Containers that hold multiple values of the same type. Arrays can be one-dimensional or multi-dimensional.

**How to use:**
```java
// One-dimensional array
int[] numbers = new int[5];
numbers[0] = 10;
numbers[1] = 20;

// Or initialize directly
int[] arr = {1, 2, 3, 4, 5};

// Two-dimensional array
int[][] matrix = new int[3][4];
matrix[0][0] = 1;
matrix[0][1] = 2;

// Or initialize directly
int[][] grid = {{1, 2, 3}, {4, 5, 6}};
```

**Example:**
```java
// 1D Array
int[] scores = {85, 90, 78, 92, 88};
System.out.println(scores[0]);  // 85

// 2D Array
int[][] table = {{1, 2}, {3, 4}, {5, 6}};
System.out.println(table[1][0]);  // 3
```

---

### 18. Uneven Multidimensional Arrays

**What are Uneven Multidimensional Arrays?**
Multi-dimensional arrays where each row can have a different number of columns.

**How to use:**
```java
int[][] uneven = new int[3][];
uneven[0] = new int[2];  // First row has 2 columns
uneven[1] = new int[4];  // Second row has 4 columns
uneven[2] = new int[3];  // Third row has 3 columns

// Or initialize directly
int[][] jagged = {
    {1, 2},
    {3, 4, 5, 6},
    {7, 8, 9}
};
```

**Example:**
```java
String[][] names = {
    {"Alice", "Bob"},
    {"Charlie", "David", "Eve"},
    {"Frank"}
};

for (int i = 0; i < names.length; i++) {
    for (int j = 0; j < names[i].length; j++) {
        System.out.print(names[i][j] + " ");
    }
    System.out.println();
}
```

---

### 19. Ternary Operator

**What is the Ternary Operator?**
A shorthand for if-else statements: `condition ? value_if_true : value_if_false`

**How to use:**
```java
int a = 10, b = 20;
int max = (a > b) ? a : b;  // If a > b, max = a, else max = b

String result = (score >= 60) ? "Pass" : "Fail";
```

**Example:**
```java
int age = 20;
String status = (age >= 18) ? "Adult" : "Minor";
System.out.println(status);  // "Adult"
```

---

### 20. Returning Array from Method

**What is Returning Array from Method?**
Methods can return arrays as their return type.

**How to use:**
```java
public class ArrayUtils {
    public int[] createArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i * 2;
        }
        return arr;
    }
}
```

**Example:**
```java
public int[] getEvenNumbers(int limit) {
    int[] evens = new int[limit / 2];
    int index = 0;
    for (int i = 2; i <= limit; i += 2) {
        evens[index++] = i;
    }
    return evens;
}
```

---

### 21. Passing Array as Parameter

**What is Passing Array as Parameter?**
Arrays can be passed to methods as parameters, and modifications to array elements affect the original array.

**How to use:**
```java
public class ArrayOperations {
    public void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    
    public void modifyArray(int[] arr) {
        arr[0] = 999;  // Modifies original array
    }
}
```

**Example:**
```java
public void doubleValues(int[] numbers) {
    for (int i = 0; i < numbers.length; i++) {
        numbers[i] *= 2;  // Modifies original array
    }
}

// Usage
int[] arr = {1, 2, 3, 4, 5};
doubleValues(arr);
// arr is now {2, 4, 6, 8, 10}
```

---

## Progressive Tasks

**Important:** Each task builds on the previous one. You will modify the same `Student` class by adding new methods and features. Create a `Main` class with a `main` method to test your `Student` class.

---

### Task 1: Student Class - Basic Structure

Create a `Student` class with the following requirements:

**Requirements:**
1. Private attributes: `name` (String), `studentId` (int), `gpa` (double)
2. Default constructor that initializes name to "Unknown", studentId to 0, gpa to 0.0
3. Parameterized constructor that takes name, studentId, and gpa
4. Getter methods: `getName()`, `getStudentId()`, `getGpa()`
5. Setter methods: `setName(String name)`, `setStudentId(int studentId)`, `setGpa(double gpa)`
6. A method `displayInfo()` that prints all student information
7. Use `this` keyword appropriately in constructors and setters

**Create a Main class to test:**
```java
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("John Doe", 12345, 3.75);
        
        s1.displayInfo();
        s2.displayInfo();
        
        s1.setName("Jane Smith");
        s1.setStudentId(12346);
        s1.setGpa(3.90);
        s1.displayInfo();
    }
}
```

**Expected Output:**
```
Student Information:
Name: Unknown
Student ID: 0
GPA: 0.0

Student Information:
Name: John Doe
Student ID: 12345
GPA: 3.75

Student Information:
Name: Jane Smith
Student ID: 12346
GPA: 3.90
```

---

### Task 2: Add Control Flow Methods

**Modify your Student class from Task 1** by adding the following methods:

**Requirements:**
1. Method `calculateGrade()` that returns a char based on GPA using if/else:
   - 'A' if gpa >= 3.7
   - 'B' if gpa >= 3.0
   - 'C' if gpa >= 2.0
   - 'D' if gpa >= 1.0
   - 'F' otherwise
2. Method `getGradeLetter()` that returns the grade letter using switch statement
3. Method `isHonorStudent()` that returns true if GPA >= 3.5 (use ternary operator)
4. Method `updateGPA(double newGPA)` that updates the GPA and validates it's between 0.0 and 4.0 using if/else
5. Method `getStatus()` that returns "Excellent", "Good", "Average", or "Needs Improvement" based on GPA using if/else

**Update your Main class:**
```java
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("John Doe", 12345, 3.75);
        Student s2 = new Student("Jane Smith", 12346, 2.50);
        
        System.out.println("Grade: " + s1.calculateGrade());
        System.out.println("Is Honor Student: " + s1.isHonorStudent());
        System.out.println("Status: " + s1.getStatus());
        
        s2.updateGPA(3.90);
        s2.displayInfo();
    }
}
```

**Expected Output:**
```
Grade: B
Is Honor Student: true
Status: Good
Student Information:
Name: Jane Smith
Student ID: 12346
GPA: 3.90
```

---

### Task 3: Add String Handling and Array Methods

**Modify your Student class from Task 2** by adding the following methods:

**Requirements:**
1. Method `formatName()` that returns the name in "Last, First" format (assume name is "First Last")
   - Use string methods: `substring()`, `indexOf()`, `toUpperCase()`, `toLowerCase()`
2. Method `getInitials()` that returns the initials of the name (e.g., "John Doe" → "JD")
3. Method `validateName()` that returns true if name contains only letters and spaces
4. Method `getStudentInfoArray()` that returns a String array with [name, studentId as String, gpa as String]
   - Use type conversion to convert int and double to String
5. Method `displayFormattedInfo()` that displays information using formatted strings

**Update your Main class:**
```java
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("John Doe", 12345, 3.75);
        
        System.out.println("Formatted Name: " + s1.formatName());
        System.out.println("Initials: " + s1.getInitials());
        System.out.println("Valid Name: " + s1.validateName());
        
        String[] info = s1.getStudentInfoArray();
        for (String data : info) {
            System.out.println(data);
        }
        
        s1.displayFormattedInfo();
    }
}
```

**Expected Output:**
```
Formatted Name: DOE, JOHN
Initials: JD
Valid Name: true
John Doe
12345
3.75
=== Formatted Student Info ===
Name: John Doe | ID: 12345 | GPA: 3.75
```

---

### Task 4: Add Array Processing Methods

**Modify your Student class from Task 3** by adding the following methods that work with arrays:

**Requirements:**
1. Method `processGPAs(double[] gpas)` that takes an array of GPAs and:
   - Uses for-each loop to find the highest GPA
   - Uses break when a GPA > 4.0 is found (invalid)
   - Uses continue to skip GPAs < 1.0
   - Returns the highest valid GPA
2. Method `calculateAverage(double[] grades)` that calculates and returns the average of an array
3. Method `findGradeInArray(char[] grades, char target)` that searches for a grade in an array:
   - Uses break when found
   - Returns true if found, false otherwise
4. Method `getGradeArray(int count)` that returns an array of grade characters (A, B, C, D, F) based on count
   - Use switch or if/else to assign grades
5. Method `modifyArray(int[] numbers)` that doubles all values in the array (pass array as parameter)

**Update your Main class:**
```java
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("John Doe", 12345, 3.75);
        
        double[] gpas = {3.5, 2.8, 4.0, 3.9, 0.5};
        double highest = s1.processGPAs(gpas);
        System.out.println("Highest GPA: " + highest);
        
        double[] grades = {85.0, 90.0, 78.0, 92.0};
        double avg = s1.calculateAverage(grades);
        System.out.println("Average: " + avg);
        
        char[] gradeList = {'A', 'B', 'C', 'A', 'B'};
        boolean found = s1.findGradeInArray(gradeList, 'A');
        System.out.println("Grade A found: " + found);
        
        int[] nums = {1, 2, 3, 4, 5};
        s1.modifyArray(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
```

**Expected Output:**
```
Highest GPA: 4.0
Average: 86.25
Grade A found: true
2 4 6 8 10
```

---

### Task 5: Add Method Overloading and Multi-dimensional Arrays

**Modify your Student class from Task 4** by adding the following methods:

**Requirements:**
1. **Method Overloading**: Create multiple versions of `calculateTotal()`:
   - `calculateTotal(int a, int b)` - returns int
   - `calculateTotal(double a, double b)` - returns double
   - `calculateTotal(int a, int b, int c)` - returns int
2. Method `process2DArray(int[][] matrix)` that:
   - Takes a 2D array and finds the maximum value
   - Returns the maximum value
   - Uses nested loops
3. Method `getStudentGrades2D()` that returns a 2D array representing grades for multiple assignments:
   - Returns a 3x4 array (3 students, 4 assignments) with sample data
4. Method `displayGradeTable(int[][] grades)` that displays grades in table format
5. Method `calculateRowAverage(int[][] grades, int row)` that returns average of a specific row
6. Method `calculateColumnAverage(int[][] grades, int col)` that returns average of a specific column

**Update your Main class:**
```java
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("John Doe", 12345, 3.75);
        
        // Method overloading
        System.out.println("Sum (int): " + s1.calculateTotal(5, 3));
        System.out.println("Sum (double): " + s1.calculateTotal(5.5, 3.2));
        System.out.println("Sum (3 ints): " + s1.calculateTotal(5, 3, 2));
        
        // 2D Array
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int max = s1.process2DArray(matrix);
        System.out.println("Max value: " + max);
        
        int[][] grades = s1.getStudentGrades2D();
        s1.displayGradeTable(grades);
        
        double rowAvg = s1.calculateRowAverage(grades, 0);
        System.out.println("Row 0 average: " + rowAvg);
    }
}
```

**Expected Output:**
```
Sum (int): 8
Sum (double): 8.7
Sum (3 ints): 10
Max value: 9
Grade Table:
Student 0: 85 90 88 92
Student 1: 78 82 80 85
Student 2: 92 95 90 93
Row 0 average: 88.75
```

---

### Task 6: Add Uneven Arrays, Type Conversion, and Complete Integration

**Modify your Student class from Task 5** by adding the following final methods:

**Requirements:**
1. Method `createUnevenArray()` that returns an uneven 2D array (jagged array):
   - First row: 2 elements
   - Second row: 4 elements
   - Third row: 3 elements
   - Initialize with sample data
2. Method `displayUnevenArray(int[][] arr)` that displays the uneven array
3. Method `convertTypes()` that demonstrates type conversion:
   - Convert int to double (automatic)
   - Convert double to int (explicit casting)
   - Convert char to int (explicit casting)
   - Return a String array with conversion results
4. Method `demonstrateTypePromotion()` that shows automatic type promotion:
   - Add byte + short + int, store in long
   - Add int + float, store in double
   - Return results as a String
5. Method `completeStudentReport()` that creates a comprehensive report:
   - Uses all previous methods
   - Returns a formatted String with all student information
   - Uses string handling, arrays, and all control structures

**Update your Main class to demonstrate everything:**
```java
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("John Doe", 12345, 3.75);
        Student s2 = new Student("Jane Smith", 12346, 3.90);
        
        // Display complete information
        System.out.println("=== Student 1 ===");
        System.out.println(s1.completeStudentReport());
        
        System.out.println("\n=== Student 2 ===");
        System.out.println(s2.completeStudentReport());
        
        // Demonstrate uneven arrays
        int[][] uneven = s1.createUnevenArray();
        s1.displayUnevenArray(uneven);
        
        // Demonstrate type conversion
        String[] conversions = s1.convertTypes();
        for (String conv : conversions) {
            System.out.println(conv);
        }
        
        // Demonstrate type promotion
        String promotion = s1.demonstrateTypePromotion();
        System.out.println(promotion);
        
        // Array operations
        double[] gpas = {3.5, 3.8, 2.9, 3.95};
        double highest = s1.processGPAs(gpas);
        System.out.println("Highest GPA from array: " + highest);
        
        // Method overloading demonstration
        System.out.println("Overloaded methods:");
        System.out.println(s1.calculateTotal(10, 20));
        System.out.println(s1.calculateTotal(10.5, 20.5));
        System.out.println(s1.calculateTotal(10, 20, 30));
    }
}
```

**Expected Output:**
```
=== Student 1 ===
[Complete formatted report with all information]

=== Student 2 ===
[Complete formatted report with all information]

Uneven Array:
Row 0: 1 2
Row 1: 3 4 5 6
Row 2: 7 8 9

[Type conversion results]
[Type promotion results]
Highest GPA from array: 3.95
Overloaded methods:
30
31.0
60
```

---

## Practice Tasks

**Note:** For each practice task, create one class with all methods and a separate Main class with a main method to test it.

### Practice Task 1: Calculator Class
Create a `Calculator` class with:
- Private attributes: `num1` (double), `num2` (double)
- Default constructor and parameterized constructor
- Getter and setter methods
- Overloaded methods: 
  - `add(int a, int b)` returns int
  - `add(double a, double b)` returns double
  - `add(int a, int b, int c)` returns int
- Similar overloading for `subtract()`, `multiply()`, `divide()`
- Method `getCalculationHistory()` that returns an array of Strings with calculation results
- Method `performOperation(char op)` that uses switch statement to perform operations
- Create a Main class to test all methods

### Practice Task 2: Temperature Converter
Create a `TemperatureConverter` class:
- Private attribute: `temperature` (double)
- Constructors and getters/setters
- Method `celsiusToFahrenheit(double celsius)` returns double
- Method `fahrenheitToCelsius(double fahrenheit)` returns double
- Method `convertArray(double[] temps, String type)` that converts an array of temperatures
- Method `getTemperatureStatus(double temp)` that uses ternary operator: returns "Hot" if > 25°C, else "Cold"
- Method `convertWithType(double temp, char type)` that uses switch statement:
  - 'C' converts to Fahrenheit
  - 'F' converts to Celsius
- Create a Main class to test all methods

### Practice Task 3: String Analyzer
Create a `StringAnalyzer` class:
- Private attribute: `text` (String)
- Constructors and getters/setters
- Method `getCharacterFrequency(String str)` that returns an int array with frequency of each character
- Method `getVowels(String str)` that returns a char array of all vowels found
- Method `reverseString(String str)` that returns reversed string
- Method `countWords(String str)` that returns number of words
- Method `findSubstring(String str, String sub)` that uses break when substring is found
- Use for-each loop where appropriate
- Use continue to skip spaces when counting characters
- Create a Main class to test all methods

### Practice Task 4: Matrix Operations
Create a `Matrix` class:
- Private attribute: `matrix` (2D int array)
- Constructor that takes 2D array to initialize
- Method `addMatrices(int[][] m1, int[][] m2)` that returns new matrix (sum of two matrices)
- Method `multiplyByScalar(int scalar)` that multiplies the matrix by a number
- Method `findMaximum()` that returns maximum value in matrix
- Method `createTriangularMatrix(int size)` that returns an uneven 2D array (triangular shape)
- Method `displayMatrix(int[][] m)` that displays matrix in formatted way
- Method `getRowSum(int row)` that returns sum of a specific row
- Method `getColumnSum(int col)` that returns sum of a specific column
- Create a Main class to test all methods

### Practice Task 5: Bank Account System
Create a `BankAccount` class:
- Private attributes: `accountNumber` (int), `balance` (double), `accountType` (String)
- Default constructor and parameterized constructor
- Getter and setter methods
- Method `deposit(double amount)` that adds to balance (use logical operators to validate amount > 0)
- Method `withdraw(double amount)` that subtracts from balance (validate amount > 0 and <= balance)
- Method `convertToUSD(double rate)` that converts balance using type casting
- Method `getAccountInfoArray()` that returns String array with account information
- Method `isAccountValid()` that returns true if accountNumber > 0 and balance >= 0 (use logical operators)
- Method `getAccountStatus()` that uses ternary operator: "Active" if balance > 0, else "Inactive"
- Create a Main class to test all methods

### Practice Task 6: Number Processor
Create a `NumberProcessor` class:
- Private attribute: `numbers` (int array)
- Constructor that takes an array
- Method `getStatistics()` that returns a double array with:
  - [0] = average
  - [1] = maximum
  - [2] = minimum
  - [3] = sum
- Method `filterEvenNumbers()` that returns array of even numbers (use continue to skip odds)
- Method `findNumber(int target)` that uses break when number is found, returns index or -1
- Method `sortArray()` that sorts the array (simple bubble sort)
- Method `convertToDoubleArray()` that returns double array (demonstrates type conversion)
- Method `createMultiplicationTable(int n)` that returns 2D array (n x n multiplication table)
- Method `displayTable(int[][] table)` that displays table using string formatting
- Use all operators, control structures, and array operations learned
- Create a Main class to test all methods

---

## Submission Guidelines

1. Complete all progressive tasks (Task 1-6)
2. Complete at least 3 practice tasks
3. Ensure all code compiles without errors
4. Include comments explaining complex logic
5. Test all methods with different inputs
6. Submit one word file on elearning portal as discussed format

---

## Notes

- **Important Structure**: 
  - Create ONE class (e.g., `Student`) with all methods, constructors, getters, setters, and attributes
  - Create a separate `Main` class with a `main` method to test your class
  - Each task MODIFIES the same class by adding new methods - do not create new classes
- Each task builds upon the previous one, so make sure Task 1 works correctly before moving to Task 2
- When adding new methods in later tasks, keep all previous methods from earlier tasks
- Use meaningful variable and method names
- Follow Java naming conventions (camelCase for methods/variables, PascalCase for classes)
- Test your code with different inputs to ensure it works correctly
- Pay attention to array bounds to avoid ArrayIndexOutOfBoundsException
- In the Main class, create objects of your class and call methods to demonstrate functionality