# Lab 1: Introduction to Java Programming

## Table of Contents
1. [Introduction](#introduction)
2. [Topic Explanations](#topic-explanations)
3. [Progressive Tasks](#progressive-tasks)
4. [Post Lab Questions](#post-lab-questions)

---

## Introduction

This lab introduces students to Java programming fundamentals. You will learn about Java's history, features, installation, basic syntax, variables, data types, input/output operations, and type conversion. This lab provides the foundation for all subsequent Java programming work.

**Course:** CSC-150 – Object Oriented Programming  
**Semester:** II (Spring 2026)  
**Modified by:** Saif Hassan

---

## Topic Explanations

### 1. What is JAVA?

**What is Java?**
Java was developed by Sun Microsystems in 1995. It is a programming language as well as a platform. Java is among the most popular programming languages, mainly because of how versatile and compatible it is. Java is a general-purpose programming language used for software development, mobile applications, web servers, and client-side web applications. It is the native language of the Android operating system.

**How to use:**
Java programs are written in `.java` files, compiled into bytecode using `javac`, and executed using the `java` command.

**Example:**
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

#### Versions of Java
There are many Java versions that have been released:
- JDK Alpha and Beta (1995)
- JAVA 1.0 (23rd Jan, 1996)
- JAVA 1.1 (19th Feb, 1997)
- JAVA 1.2 (8th Dec, 1998)
- JAVA 1.3 (8th May, 2000)
- JAVA 1.4 (6th Feb, 2002)
- JAVA 5.0 (30th Sep, 2004)
- JAVA 6 (11th Dec, 2006)
- JAVA 7 (28th July, 2011)
- JAVA 8 (18th March, 2014)
- JAVA 9 (21st Sep, 2017)
- JAVA 10 (20th March, 2018)
- JAVA 11 (25th Sep 2018)
- JAVA 12 (19th March 2019)
- JAVA 13 (17th Sep 2019)
- JAVA 14 (17th March 2020)
- JAVA 15 (15th Sep, 2020)
- JAVA 16 (16th March, 2021)

#### Platform
Any hardware or software environment in which a program runs is known as a platform. Since Java has a runtime environment (JRE) and API, it is called a platform.

#### Java Platforms
According to Oracle, there are four platforms of the Java programming language:
- Java Platform, Standard Edition (Java SE)
- Java Platform, Enterprise Edition (Java EE)
- Java Platform, Micro Edition (Java ME)
- JavaFX/OpenJFX

---

### 2. Features of JAVA

**What are the Features of Java?**
The following are Java's main features:

**How to use:**
These features make Java suitable for various types of applications from desktop to web to mobile.

**Example:**
- **Object Oriented** − In Java, everything is an object, creating objects that contain data and methods.
- **Architecture-neutral** − Java compiler generates an architecture-neutral object file format called bytecode, which makes the compiled code executable on many machines with the presence of Java runtime system.
- **Platform Independent** − When Java is compiled, it is not compiled into platform-specific machine code, rather into byte code. This byte code is distributed over the web and interpreted by the Virtual Machine (JVM) on whichever platform it is being run on.
- **Portable** − Bytecode can be run by any system in which Java is installed. This is because when Java is installed, Java Virtual Machine is also installed that is specific to that system. It is this machine's responsibility to convert the bytecode into the final instructions of that particular machine.

**"Write once, run everywhere"**

---

### 3. JAVA Basics

**What are JDK, JRE, JVM, and JIT?**
These are fundamental components of the Java platform.

**How to use:**
- **JDK (Java Development Kit)**: Used for developing Java applications
- **JRE (Java Runtime Environment)**: Required to run Java applications
- **JVM (Java Virtual Machine)**: Executes Java bytecode
- **JIT (Just-In-Time Compiler)**: Speeds up execution

**Example:**

**JDK**
- It stands for Java Development Kit, is a software development environment used for developing Java applications and applets.
- It compiles and executes new and already built applications.
- It is a collection of development tools as well as Java Runtime Environment (JRE), an interpreter/loader (Java), a compiler (javac), an archiver (jar), a documentation generator (Javadoc) and other tools needed in Java development.

**JRE**
- It stands for Java Runtime Environment. The Java Runtime Environment provides the minimum requirements for executing a Java application.
- It consists of the Java Virtual Machine (JVM), interpreter, JIT, core classes, and supporting files.

**JVM**
- It stands for Java Virtual Machine (JVM)
- It is responsible for executing bytecode where interpreter provides machine code for the current machine and has JIT as well.

**JIT**
- It stands for Just-In-Time Compiler, is the part of the Java Virtual Machine (JVM) that is used to speed up the execution time.
- JIT interprets parts of the bytecode that have similar functionality at the same time, and hence reduces the amount of time needed for full interpretation.

---

### 4. Installing JDK and Setting Path

**What is JDK Installation?**
To develop Java applications on our computers, we require a JDK.

**How to use:**
1. Download JDK from: https://download.oracle.com/java/17/latest/jdk-17_windows-x64_bin.exe
2. Install the JDK
3. Set the path which can be:
   - Temporary through command line
   - Permanent path using properties of 'This PC', go to advanced system settings and then Environment variables

**Example:**
After installation, verify by running:
```bash
javac -version
java -version
```

---

### 5. Writing HelloWorld.java in Text Editor

**What is a HelloWorld Program?**
A simple program that displays "Hello, World!" to verify your Java installation.

**How to use:**
Follow the below given steps:
1. Run notepad and enter the code below
2. Save this file with Class name and end it with ".java" extension
3. Go to search bar in taskbar, write cmd and Open Command Prompt
4. Write the following commands:
   - `cd desktop` // for going to desktop
   - `javac HelloWorld.java`
   - `java HelloWorld`

**Example:**
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

The Java programming language compiler (javac) takes your source file and translates the code into instructions known as bytecodes. "java ClassName" will enable Java virtual machine to run your application/code.

---

### 6. Variables and Data Types in JAVA

**What are Variables and Data Types?**
Variables are containers that store data values. Data types classify the different values to be stored in the variable.

**How to use:**
In Java, there are three types of variables:
- **Local Variables**: Declared inside the body of a method
- **Instance Variables**: Defined without the 'static' keyword, outside a method within a class
- **Class/Static Variables**: Declared with the keyword 'static', outside the method within a class

**Example:**
```java
class Variab {
    int InsVarExam = 29;        // instance variable
    static int IsStatVar = 15;   // static variable
    
    void method() {
        int IsLocalVar = 90;     // local variable
    }
}
```

#### Data Types in Java
In Java, there are two types of data types:
- **Primitive Data Types**: Predefined and available within the Java language
- **Non-primitive Data Types**: Arrays, strings, classes, etc.

**Primitive Data Types:**
There are 8 primitive types: byte, short, int, long, char, float, double, and boolean

- **Integer data types:**
  - `byte` (1 byte)
  - `short` (2 bytes)
  - `int` (4 bytes)
  - `long` (8 bytes)

- **Floating Data Type:**
  - `float` (4 bytes)
  - `double` (8 bytes)

- **Textual Data Type:**
  - `char` (2 bytes)

- **Logical:**
  - `boolean` (1 bit) (true/false)

---

### 7. Input & Output

**What is Input & Output in Java?**
Input allows programs to receive data from users, while output displays information to users.

**How to use:**

**Output in Java:**
```java
System.out.println("Hello World");
```

**Input in Java:**
```java
// import library
import java.util.Scanner;

// Creating scanner object
Scanner ip = new Scanner(System.in); // system.in represents that the input is given via keyboard

// Taking input from user
int ipFrmUser = ip.nextInt();        // Integer Input
double ipDbUser = ip.nextDouble();   // Double Input
```

**Example:**
```java
import java.util.Scanner;

public class InputExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        System.out.println("You entered: " + num);
    }
}
```

---

### 8. Java Variable Type Conversion & Type Casting

**What is Type Conversion and Type Casting?**
A variable of one type can receive the value of another type. There are 2 cases:

**How to use:**

**Case 1: Type Conversion (Automatic)**
Variable of smaller capacity is assigned to another variable of bigger capacity. This process is automatic and non-explicit, known as **type conversion**.

**Case 2: Type Casting (Explicit)**
Variable of larger capacity is assigned to another variable of smaller capacity. In such cases, you have to explicitly specify the type cast operator. This process is known as **type casting**. If you do not specify a type cast operator, the compiler gives an error.

**Example:**
```java
class Demo {
    public static void main(String args[]) {
        byte x;
        int a = 270;
        double b = 128.128;
        
        System.out.println("int converted to byte");
        x = (byte) a;
        System.out.println("a and x " + a + " " + x);
        
        System.out.println("double converted to int");
        a = (int) b;
        System.out.println("b and a " + b + " " + a);
        
        System.out.println("\ndouble converted to byte");
        x = (byte) b;
        System.out.println("b and x " + b + " " + x);
    }
}
```

**Output:**
```
int converted to byte
a and x 270 14
double converted to int
b and a 128.128 128
double converted to byte
b and x 128.128 -128
```

---

### 9. Arrays in Java

**What are Arrays?**
Arrays are containers that hold multiple values of the same type.

**How to use:**
```java
int[] arr = new int[5];  // Array declaration
arr[0] = 10;             // Assigning values
```

**Example:**
```java
import java.util.Scanner;

class ArrayExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5]; // Array declaration
        
        System.out.println("Enter 5 integers: ");
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.println("You entered: ");
        for (int i = 0; i < 5; i++) {
            System.out.println(arr[i]);
        }
    }
}
```

**Output:**
```
Enter 5 integers: 10 20 30 40 50
You entered: 10 20 30 40 50
```

---

## Progressive Tasks

### Exercise 1: JAVA Environment Installation & Error Messages

**Requirements:**
Set up a Java development environment. In the main() method of your program, try to compile the following invalid Java code snippets. Record the error messages you receive. What do you think each error message indicates?

1. `System.out.printn("Hello World")`
2. `System.out.printn(Hello World)`
3. `System.out.println"Hello World";`
4. `println("Hello World);`

To generate one final error message, remove one of the brackets from the end of your program. Now what message do you receive?

**Expected Output:**
Document the error messages and your analysis of what each indicates.

---

### Exercise 2: Mathematical Expressions

**Requirements:**
Write Java code to identify if the given input by the user is even or odd.

---

### Exercise 3: Type Casting

**Requirements:**
Perform division using two double variables and store the result in an int variable and print the results.

---

### Exercise 4: Operators

**Requirements:**
Find the largest among three numbers using if..else as well as operators statement.

**Test Cases:**
- Enter value a: 30
- Enter value b: 10
- Enter value c: 70

---

### Exercise 5: If/Else and Array

**Requirements:**
Create an array of 5 integers, input array elements and perform following tasks:
1. Find and print the largest number
2. Input a number to search and print whether the number is found or not
3. Count how many even numbers are in it
4. Print elements in reverse order

---

### Exercise 6: Debugging Practice

**Requirements:**
Run the code, find/name the error, write in your own words (1-2 lines max) in the 2nd column and solve it in the 3rd column with minimal changes.

| Code | Error/Analysis | Fix |
|------|----------------|-----|
| `int[] arr = new int[5];`<br>`for (int i = 0; i <= 5; i++) {`<br>`    arr[i] = i * 10;`<br>`}` | | |
| `int[] arr;`<br>`arr[0] = 10;` | | |
| `class InputTest {`<br>`    public static void main(String[] args) {`<br>`        Scanner sc = new Scanner(System.in);`<br>`        int x = sc.nextInt();`<br>`    }`<br>`}` | | |
| `for (int i = 0; i < 5; i--) {`<br>`    System.out.println(i);`<br>`}` | | |
| `int[] arr = new int[3];`<br>`System.out.println(arr[0]);` | | |
| `int x = 5;`<br>`if (x = 5) {`<br>`    System.out.println("Equal");`<br>`}` | | |
| `Scanner sc = new Scanner(System.in);`<br>`int n = sc.nextInt();`<br>`int[] arr = new int[n];`<br>`arr[n] = 10;` | | |

---

## Post Lab Questions

**Questions to Ponder:**
1. Can you cast string into int?
2. Why JAVA when there are other OOP languages?

---

## Submission Guidelines

1. Complete all lab tasks (Exercise 1-6)
2. Ensure all code compiles without errors
3. Include comments explaining your code
4. Test all programs with different inputs
5. Submit one word file on elearning portal as discussed format

---

## Notes

- Make sure JDK is properly installed and path is set
- Always save Java files with `.java` extension
- Class name must match the filename
- Use proper indentation and formatting
- Test your code with different inputs
- Pay attention to array bounds to avoid ArrayIndexOutOfBoundsException
- Understand the difference between `=` (assignment) and `==` (comparison)
