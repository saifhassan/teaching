# OOP Spring 2026: Detailed Tutorials by Topic (Lab-Wise)

A single tutorial for each topic: **Topic name**, **Definition**, **Why and when to use**, **How to use** with short working examples.

---

## Lab 1: Introduction to Java Programming

---

### 1. What is Java?

**Definition:** Java is a general-purpose, object-oriented programming language and platform developed by Sun Microsystems (now Oracle). Programs are written in `.java` files, compiled to bytecode by `javac`, and executed by the JVM with the `java` command.

**Why and when to use:** Use Java when you need portable, secure, and maintainable applications (desktop, web, mobile, Android). It is the foundation of this course and must be understood before any Java programming.

**How to use (short working example):**
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```
Compile: `javac HelloWorld.java` → Run: `java HelloWorld`

---

### 2. Features of Java

**Definition:** Key characteristics of Java: Object-Oriented, Platform-Independent (bytecode), Portable, Architecture-Neutral, Secure, Multithreaded. Often summarized as "Write once, run everywhere."

**Why and when to use:** Understanding these features helps you choose Java for cross-platform projects and explains why bytecode runs on any system with a JVM.

**How to use:** No code—conceptual. When designing systems, rely on portability (deploy same bytecode on Windows, Mac, Linux) and object-oriented structure for maintainability.

---

### 3. Java Basics (JDK, JRE, JVM, JIT)

**Definition:**  
- **JDK**: Development kit (compiler `javac`, tools, JRE).  
- **JRE**: Runtime (JVM + libraries) to run applications.  
- **JVM**: Executes bytecode.  
- **JIT**: Just-In-Time compiler inside JVM that compiles hot code for speed.

**Why and when to use:** Use JDK for development; end users need only JRE. Understanding JVM/JIT helps with performance and deployment.

**How to use:** Install JDK, then verify:
```bash
javac -version
java -version
```

---

### 4. Installing JDK and Setting Path

**Definition:** Installing the Java Development Kit and configuring the system `PATH` so that `javac` and `java` are available from the command line.

**Why and when to use:** Required once per machine before writing or running any Java program.

**How to use:** Download JDK (e.g., from Oracle), run installer, then add the `bin` directory to PATH (temporarily in terminal or permanently in system environment variables). Verify with `javac -version` and `java -version`.

---

### 5. Writing HelloWorld in a Text Editor

**Definition:** Creating a minimal Java program in a text editor, saving as `ClassName.java`, compiling with `javac`, and running with `java ClassName`.

**Why and when to use:** First step to confirm the environment works and to learn the edit-compile-run cycle.

**How to use:** Create `HelloWorld.java` with the class and `main` method (as in topic 1). In terminal: `javac HelloWorld.java` then `java HelloWorld`.

---

### 6. Variables and Data Types in Java

**Definition:** Variables are named storage for values. Data types define the kind of data (e.g., `int`, `double`, `boolean`, `char`). Java has local, instance, and static variables; and primitive plus reference (e.g., arrays, String) types.

**Why and when to use:** Use variables to store input, intermediate results, and state. Choose the right type for clarity and correct behavior (e.g., `double` for decimals, `int` for counts).

**How to use (short working example):**
```java
public class VariablesDemo {
    static int classVar = 5;           // static
    int instanceVar = 10;              // instance
    
    public static void main(String[] args) {
        int localVar = 15;             // local
        double price = 19.99;
        boolean flag = true;
        char grade = 'A';
        System.out.println(localVar + " " + price + " " + flag + " " + grade);
    }
}
```

---

### 7. Input & Output

**Definition:** **Output** is displaying data (e.g., `System.out.println`). **Input** is reading data from the user, typically via `Scanner` from `java.util`.

**Why and when to use:** Use output to show results and messages; use `Scanner` when the program must read numbers or text from the user at runtime.

**How to use (short working example):**
```java
import java.util.Scanner;

public class InputOutputDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        System.out.println("Hello " + name + ", you are " + age);
        sc.close();
    }
}
```

---

### 8. Java Variable Type Conversion & Type Casting

**Definition:** **Type conversion (widening):** automatic when assigning a smaller type to a larger (e.g., `int` to `double`). **Type casting (narrowing):** explicit when assigning larger to smaller (e.g., `(int) doubleValue`). Required when the compiler cannot safely convert.

**Why and when to use:** Use when you need to combine different numeric types or when you intentionally truncate (e.g., double to int). Prevents compile errors and controls precision.

**How to use (short working example):**
```java
public class TypeConversionDemo {
    public static void main(String[] args) {
        int a = 10;
        double b = a;           // automatic widening
        System.out.println(b);  // 10.0
        
        double x = 9.78;
        int y = (int) x;        // explicit casting
        System.out.println(y); // 9
    }
}
```

---

### 9. Arrays in Java

**Definition:** An array is a fixed-size container that holds multiple values of the same type. Elements are accessed by index (0 to length-1).

**Why and when to use:** Use when you have a collection of same-type data (e.g., list of scores, names). Enables loops and bulk operations.

**How to use (short working example):**
```java
public class ArrayDemo {
    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 10; arr[1] = 20; arr[2] = 30;
        
        int[] nums = { 1, 2, 3, 4, 5 };
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
```

---

## Lab 2: Methods in Java

---

### 1. Methods

**Definition:** A method is a block of code that performs a specific task. It has a name, optional parameters, and an optional return type. Static methods can be called without an object (e.g., from `main`).

**Why and when to use:** Use methods to avoid repetition, improve readability, and structure programs. Call them whenever the same logic is needed in multiple places.

**How to use (short working example):**
```java
public class MethodDemo {
    static void greet() {
        System.out.println("Welcome!");
    }
    static int add(int a, int b) {
        return a + b;
    }
    public static void main(String[] args) {
        greet();
        System.out.println(add(5, 3));  // 8
    }
}
```

---

### 2. Types of Methods

**Definition:**  
- No parameters, no return value (`void methodName()`).  
- Parameters, no return value (`void methodName(params)`).  
- No parameters, return value (`returnType methodName()`).  
- Parameters and return value (`returnType methodName(params)`).

**Why and when to use:** Choose based on whether the method needs input (parameters) and/or must produce a result (return value). Most reusable logic uses parameters and return values.

**How to use (short working example):**
```java
public class MethodTypesDemo {
    static void noParamNoReturn() {
        System.out.println("No param, no return");
    }
    static void withParamNoReturn(String name) {
        System.out.println("Hello, " + name);
    }
    static int noParamWithReturn() {
        return 42;
    }
    static int withParamAndReturn(int a, int b) {
        return a + b;
    }
    public static void main(String[] args) {
        noParamNoReturn();
        withParamNoReturn("Ali");
        System.out.println(noParamWithReturn());
        System.out.println(withParamAndReturn(2, 3));
    }
}
```

---

### 3. Methods with Control Statements (If-Else, Ternary, Switch)

**Definition:** Methods can contain `if`/`else`, ternary (`condition ? valueIfTrue : valueIfFalse`), and `switch` to make decisions based on conditions or discrete values.

**Why and when to use:** Use when the method’s behavior depends on input or state (e.g., grading, menu choices). Ternary for simple two-way choices; switch for many fixed options.

**How to use (short working example):**
```java
public class ControlInMethodsDemo {
    static String grade(int score) {
        if (score >= 90) return "A";
        else if (score >= 80) return "B";
        else return "C";
    }
    static String status(int n) {
        return n >= 0 ? "Non-negative" : "Negative";
    }
    static void dayName(int d) {
        switch (d) {
            case 1: System.out.println("Mon"); break;
            case 2: System.out.println("Tue"); break;
            default: System.out.println("Other");
        }
    }
    public static void main(String[] args) {
        System.out.println(grade(85));
        System.out.println(status(5));
        dayName(2);
    }
}
```

---

### 4. Methods with String Basics (Length, Comparison, Case)

**Definition:** Using `String` methods inside your methods: e.g., `length()`, `equals()`, `equalsIgnoreCase()`, `toUpperCase()`, `toLowerCase()`, `charAt()`, `substring()`.

**Why and when to use:** Use when you need to validate, compare, or format text (names, IDs, messages). Prefer `equals` for content comparison, not `==`.

**How to use (short working example):**
```java
public class StringMethodsDemo {
    static void demo(String s) {
        System.out.println("Length: " + s.length());
        System.out.println("Upper: " + s.toUpperCase());
        System.out.println("Equals 'Hi': " + s.equals("Hi"));
        System.out.println("Equals ignore case: " + s.equalsIgnoreCase("hi"));
    }
    public static void main(String[] args) {
        demo("Hi");
    }
}
```

---

### 5. Methods with Arrays (Sum, Find Maximum)

**Definition:** Methods that take arrays as parameters and perform operations such as summing elements or finding the maximum value.

**Why and when to use:** Use when you need reusable logic on collections (e.g., statistics, search). Keeps `main` clean and logic testable.

**How to use (short working example):**
```java
public class ArrayMethodsDemo {
    static int sum(int[] arr) {
        int s = 0;
        for (int x : arr) s += x;
        return s;
    }
    static int max(int[] arr) {
        int m = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > m) m = arr[i];
        return m;
    }
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };
        System.out.println("Sum: " + sum(a));
        System.out.println("Max: " + max(a));
    }
}
```

---

### 6. Methods Using Math Class

**Definition:** Calling static methods of `java.lang.Math` (e.g., `Math.pow`, `Math.abs`, `Math.sqrt`, `Math.max`, `Math.min`) inside your methods.

**Why and when to use:** Use for mathematical operations without rewriting formulas. Standard and efficient.

**How to use (short working example):**
```java
public class MathMethodsDemo {
    static double power(double base, double exp) {
        return Math.pow(base, exp);
    }
    static int absolute(int x) {
        return Math.abs(x);
    }
    public static void main(String[] args) {
        System.out.println(power(2, 3));   // 8.0
        System.out.println(absolute(-7));  // 7
    }
}
```

---

### 7. Command-Line Arguments

**Definition:** Values passed to the program when it is run (e.g., `java MyApp arg1 arg2`). They appear in `String[] args` in `main`.

**Why and when to use:** Use when you want to configure the program at launch (e.g., file names, flags) without interactive input.

**How to use (short working example):**
```java
public class CommandLineDemo {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("Arg " + i + ": " + args[i]);
        }
    }
}
// Run: java CommandLineDemo hello world
```

---

## Lab 3: Objects, Instance Methods & Encapsulation

---

### 1. Transition from Static to Object-Oriented Programming

**Definition:** Static members belong to the class (one copy); non-static (instance) members belong to each object. OOP uses objects that hold data and methods that operate on that data.

**Why and when to use:** Use instance methods when behavior depends on per-object state (e.g., each bank account has its own balance). Use static for shared utility (e.g., `Math.sqrt`).

**How to use (short working example):**
```java
public class StaticVsInstance {
    static int shared = 0;   // one copy for class
    int value;               // each object has its own
    
    void setValue(int v) { value = v; }
    int getValue() { return value; }
    
    public static void main(String[] args) {
        StaticVsInstance a = new StaticVsInstance();
        StaticVsInstance b = new StaticVsInstance();
        a.setValue(10);
        b.setValue(20);
        System.out.println(a.getValue() + " " + b.getValue());  // 10 20
    }
}
```

---

### 2. Class and Object Basics

**Definition:** A **class** is a blueprint (attributes + methods). An **object** is an instance of that class created with `new ClassName()`.

**Why and when to use:** Use classes to model entities (e.g., Student, Car); use objects to represent individual items and call methods on them.

**How to use (short working example):**
```java
class Car {
    String brand;
    String color;
}
public class ClassObjectDemo {
    public static void main(String[] args) {
        Car c1 = new Car();
        c1.brand = "Toyota";
        c1.color = "Red";
        System.out.println(c1.brand + " " + c1.color);
    }
}
```

---

### 3. Instance Variables vs Local Variables

**Definition:** **Instance variables** are declared in the class (outside methods) and exist for the lifetime of each object. **Local variables** are declared inside a method or block and exist only during that execution.

**Why and when to use:** Instance variables store object state; local variables store temporary values inside a method.

**How to use (short working example):**
```java
class Rectangle {
    double length, width;   // instance
    
    void area() {
        double a = length * width;  // local
        System.out.println("Area: " + a);
    }
}
```

---

### 4. Object Creation and Method Calling

**Definition:** Create objects with `new ClassName()`. Call instance methods with `objectReference.methodName(args)`.

**Why and when to use:** Use whenever you need to work with multiple entities or need stateful behavior tied to each instance.

**How to use (short working example):**
```java
class Student {
    String name;
    void display() { System.out.println("Student: " + name); }
}
public class ObjectMethodDemo {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "Ali";
        s.display();
    }
}
```

---

### 5. Reference Variables and Object Aliasing

**Definition:** A reference variable holds the address of an object. Two references can point to the same object (aliasing); then changes via one reference are visible via the other.

**Why and when to use:** Be aware when passing objects or assigning references—you are sharing the same object. Copy explicitly if you need an independent copy.

**How to use (short working example):**
```java
class Box { int x; }
public class ReferenceDemo {
    public static void main(String[] args) {
        Box a = new Box();
        a.x = 5;
        Box b = a;   // b points to same object
        b.x = 10;
        System.out.println(a.x);  // 10
    }
}
```

---

### 6. Constructors

**Definition:** A constructor is a special method with the same name as the class, no return type, used to initialize new objects. Default constructor has no parameters; parameterized constructors take arguments.

**Why and when to use:** Use to ensure objects start in a valid state. Parameterized constructors for required data (e.g., name, id).

**How to use (short working example):**
```java
class Person {
    String name;
    int age;
    Person() { name = "Unknown"; age = 0; }
    Person(String n, int a) { name = n; age = a; }
}
public class ConstructorDemo {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person("Ali", 20);
        System.out.println(p2.name + " " + p2.age);
    }
}
```

---

### 7. Encapsulation

**Definition:** Encapsulation is hiding internal state and exposing only through controlled operations. In Java this is done with `private` fields and public methods (e.g., getters/setters or domain methods).

**Why and when to use:** Use to protect invariants (e.g., balance cannot be set arbitrarily), allow validation in setters, and change internal representation later without breaking callers.

**How to use (short working example):**
```java
class Account {
    private double balance;
    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }
    public double getBalance() { return balance; }
}
```

---

### 8. Getters and Setters

**Definition:** **Getters** (e.g., `getX()`) return the value of a private field. **Setters** (e.g., `setX(value)`) set the value, often with validation.

**Why and when to use:** Use to read/write private attributes from outside the class while keeping control (validation, side effects) inside the class.

**How to use (short working example):**
```java
class Student {
    private String name;
    private int age;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) {
        if (age >= 0 && age <= 150) this.age = age;
    }
}
```

---

### 9. This Keyword

**Definition:** `this` refers to the current object. Used to distinguish instance variables from parameters/local variables with the same name, and to pass or return the current object.

**Why and when to use:** Use in setters and constructors when parameter names match field names (e.g., `this.name = name`). Improves clarity and avoids bugs.

**How to use (short working example):**
```java
class Student {
    private String name;
    public void setName(String name) {
        this.name = name;  // this.name = field, name = parameter
    }
    public String getName() {
        return this.name;
    }
}
```

---

## Lab 4: Java Fundamentals – Operators, Control Flow, Classes, Arrays

---

### 1. Logical and Relational Operators

**Definition:** **Relational:** `==`, `!=`, `>`, `<`, `>=`, `<=` (compare two values, result is `boolean`). **Logical:** `&&` (AND), `||` (OR), `!` (NOT) combine or negate boolean expressions.

**Why and when to use:** Use in conditions for `if`, loops, and method logic. Essential for validation and branching.

**How to use (short working example):**
```java
int a = 5, b = 10;
boolean r1 = a < b;              // true
boolean r2 = (a > 0) && (b > 0); // true
boolean r3 = (a == b) || (a < b); // true
```

---

### 2. Basic Data Types

**Definition:** Java primitives: `byte`, `short`, `int`, `long`, `float`, `double`, `char`, `boolean`. Plus reference types (e.g., `String`, arrays).

**Why and when to use:** Choose the right type for range and precision (e.g., `int` for counts, `double` for decimals, `boolean` for flags).

**How to use (short working example):**
```java
int id = 1001;
double price = 19.99;
char grade = 'A';
boolean pass = true;
```

---

### 3. String Handling

**Definition:** `String` is a reference type with methods for length, comparison, case conversion, substring, concatenation, etc. Strings are immutable.

**Why and when to use:** Use for any text: names, messages, parsing. Use `equals()` for value comparison; use methods for validation and formatting.

**How to use (short working example):**
```java
String s = "Hello";
int len = s.length();
String sub = s.substring(1, 4);  // "ell"
String upper = s.toUpperCase();
boolean eq = s.equals("Hello");
```

---

### 4. Break and Continue Statements

**Definition:** **break** exits the innermost loop or switch immediately. **continue** skips the rest of the current iteration and continues the loop.

**Why and when to use:** Use `break` to stop when a condition is met (e.g., found item). Use `continue` to skip certain iterations (e.g., skip invalid entries).

**How to use (short working example):**
```java
for (int i = 0; i < 10; i++) {
    if (i == 5) break;      // stop at 5
    if (i % 2 == 0) continue; // skip even
    System.out.println(i);  // 1, 3
}
```

---

### 5. For-Each Loop (Enhanced For Loop)

**Definition:** Syntax `for (Type item : arrayOrIterable) { }` iterates over each element without an index variable.

**Why and when to use:** Use when you need to process every element and do not need the index. Cleaner and less error-prone than index-based loop.

**How to use (short working example):**
```java
int[] arr = { 10, 20, 30 };
for (int x : arr) {
    System.out.println(x);
}
```

---

### 6. If/Else/Switch Statements

**Definition:** **if/else:** branch on boolean conditions. **switch:** branch on a single value (int, String, enum, etc.) with `case` and optional `default`.

**Why and when to use:** Use if/else for ranges or complex conditions; use switch for many discrete values (menus, status codes).

**How to use (short working example):**
```java
int score = 85;
if (score >= 90) System.out.println("A");
else if (score >= 80) System.out.println("B");
else System.out.println("C");

int day = 2;
switch (day) {
    case 1: System.out.println("Mon"); break;
    case 2: System.out.println("Tue"); break;
    default: System.out.println("Other");
}
```

---

### 7. Constructors (Lab 4)

**Definition:** Same as Lab 3—special method that initializes the object. Default and parameterized constructors.

**Why and when to use:** To set initial state when object is created. Use parameterized constructor when you have required data.

**How to use:** See Lab 3 Topic 6 example; same idea in any class with `public ClassName(...) { }`.

---

### 8. Methods (Lab 4)

**Definition:** Blocks of code that perform a task; can be instance or static, with or without parameters and return value.

**Why and when to use:** To structure behavior and reuse logic. Instance methods when they use object state; static when they don’t.

**How to use:** See Lab 2 and Lab 3 examples; in Lab 4 you combine them with classes and control flow.

---

### 9. Method Overloading (Lab 4)

**Definition:** Multiple methods in the same class with the same name but different parameter lists (number or types). Return type alone does not distinguish overloads.

**Why and when to use:** Use when you want the same logical operation with different inputs (e.g., `add(int,int)` and `add(double,double)`).

**How to use (short working example):**
```java
class Calc {
    int add(int a, int b) { return a + b; }
    int add(int a, int b, int c) { return a + b + c; }
    double add(double a, double b) { return a + b; }
}
```

---

### 10. Objects (Lab 4)

**Definition:** Instances of a class; hold state (attributes) and behavior (methods). Created with `new`.

**Why and when to use:** Use to model real-world or conceptual entities and to organize data and behavior together.

**How to use:** Define a class, then `ClassName ref = new ClassName(); ref.method();` — see Lab 3 examples.

---

### 11. Private Attributes

**Definition:** Class fields declared with `private` are accessible only inside the same class. External code must use public methods to access them.

**Why and when to use:** Use for encapsulation—hide implementation and enforce validation through methods.

**How to use (short working example):**
```java
class BankAccount {
    private double balance;
    public void deposit(double amt) { balance += amt; }
    public double getBalance() { return balance; }
}
```

---

### 12. Getter and Setter Methods (Lab 4)

**Definition:** Same as Lab 3—public methods to read (get) and write (set) private attributes, often with validation in setters.

**Why and when to use:** To expose private data in a controlled way. Use when you need external read/write access with validation.

**How to use:** See Lab 3 Topic 8; in Lab 4 you use them together with other class features.

---

### 13. Class and Main Class – Calling Methods from Other Classes

**Definition:** One class (e.g., `Main`) contains `public static void main(String[] args)` and creates objects of other classes, calling their methods. Regular classes contain the domain logic.

**Why and when to use:** Use to separate entry point from reusable logic. Main drives the flow; other classes encapsulate behavior.

**How to use (short working example):**
```java
// Student.java
class Student {
    private String name;
    public void setName(String n) { name = n; }
    public void display() { System.out.println(name); }
}
// Main.java
public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("Ali");
        s.display();
    }
}
```

---

### 14. This Keyword (Basic) (Lab 4)

**Definition:** Same as Lab 3—`this` refers to the current object. Used to disambiguate instance variable from parameter.

**Why and when to use:** In constructors and setters when parameter name equals field name.

**How to use:** `this.fieldName = parameterName;` — see Lab 3 Topic 9.

---

### 15. Type Conversion and Casting (Lab 4)

**Definition:** Widening (automatic) and narrowing (explicit cast). Same idea as Lab 1 Topic 8, applied in expressions and assignments.

**Why and when to use:** When mixing types in arithmetic or assigning to a smaller type.

**How to use (short working example):**
```java
double d = 9.99;
int i = (int) d;  // 9
long L = 100;
int k = (int) L;
```

---

### 16. Automatic Type Promotion in Expressions

**Definition:** In expressions, smaller numeric types are promoted to larger (e.g., `byte`/`short` to `int`, `int` to `double` when mixed with double).

**Why and when to use:** Explains why `byte + byte` is `int` and why overloaded method resolution can choose a larger type.

**How to use (short working example):**
```java
byte b = 10;
int i = b + 1;   // b promoted to int
double d = 5 + 2.0;  // 5 promoted to double, result 7.0
```

---

### 17. Arrays (One Dimension and Multi Dimension)

**Definition:** 1D: `type[] name = new type[size];` or `{ ... };`. 2D: `type[][] name = new type[rows][cols];` or `{ { ... }, { ... } };`. Elements accessed by index(es).

**Why and when to use:** 1D for lists; 2D for grids/tables (e.g., rows = students, columns = subjects).

**How to use (short working example):**
```java
int[] one = { 1, 2, 3 };
int[][] two = { { 1, 2 }, { 3, 4 } };
System.out.println(two[1][0]);  // 3
```

---

### 18. Uneven (Jagged) Multidimensional Arrays

**Definition:** A 2D array where each row can have a different length (e.g., `int[][] jagged = new int[3][]` then `jagged[0] = new int[2]; jagged[1] = new int[5];`).

**Why and when to use:** Use when rows naturally have different lengths (e.g., different number of grades per student).

**How to use (short working example):**
```java
int[][] jagged = new int[2][];
jagged[0] = new int[] { 1, 2 };
jagged[1] = new int[] { 3, 4, 5 };
System.out.println(jagged[1].length);  // 3
```

---

### 19. Ternary Operator

**Definition:** `condition ? valueIfTrue : valueIfFalse` — expression that chooses one of two values based on a boolean.

**Why and when to use:** Use for simple two-way choices instead of a short if-else when you need a value (e.g., in assignment or return).

**How to use (short working example):**
```java
int age = 18;
String status = age >= 18 ? "Adult" : "Minor";
int max = (a > b) ? a : b;
```

---

### 20. Returning Array from Method

**Definition:** Method return type can be an array, e.g., `int[] methodName() { ... return array; }`.

**Why and when to use:** Use when the method computes or collects a sequence of values to return (e.g., get all grades, get filtered list).

**How to use (short working example):**
```java
static int[] getEvens(int[] arr) {
    int count = 0;
    for (int x : arr) if (x % 2 == 0) count++;
    int[] out = new int[count];
    int j = 0;
    for (int x : arr) if (x % 2 == 0) out[j++] = x;
    return out;
}
```

---

### 21. Passing Array as Parameter

**Definition:** Method can accept an array: `void method(int[] arr) { }`. In Java, arrays are reference types—the method receives a copy of the reference, so it can modify the same array.

**Why and when to use:** Use when the method must process or modify a collection (e.g., sort, filter, compute stats).

**How to use (short working example):**
```java
static void doubleValues(int[] arr) {
    for (int i = 0; i < arr.length; i++) arr[i] *= 2;
}
int[] a = { 1, 2, 3 };
doubleValues(a);
// a is now { 2, 4, 6 }
```

---

## Lab 5: A Closer Look at Methods and Classes

---

### 1. Overloading Methods

**Definition:** Same as Lab 4—multiple methods with the same name, different parameter lists. Can differ by number or types of parameters.

**Why and when to use:** To provide the same operation for different input types or counts (e.g., add two ints vs two doubles vs three ints).

**How to use (short working example):**
```java
public class Calc {
    public int add(int a, int b) { return a + b; }
    public double add(double a, double b) { return a + b; }
    public int add(int a, int b, int c) { return a + b + c; }
}
```

---

### 2. Overloading Constructors

**Definition:** Multiple constructors in one class with different parameter lists. Enables different ways to initialize an object (default, partial, full).

**Why and when to use:** When objects can be created with no args, or with different sets of initial data.

**How to use (short working example):**
```java
class Student {
    String name; int age;
    Student() { name = "Unknown"; age = 0; }
    Student(String n) { name = n; age = 0; }
    Student(String n, int a) { name = n; age = a; }
}
```

---

### 3. Using Object as Parameters

**Definition:** Methods can take reference types (objects) as parameters. The method receives a copy of the reference, so it can read or modify the object’s state.

**Why and when to use:** Use when behavior involves two or more objects (e.g., compare, transfer, combine).

**How to use (short working example):**
```java
class Rectangle {
    int w, h;
    Rectangle(int w, int h) { this.w = w; this.h = h; }
    boolean isLargerThan(Rectangle other) {
        return (w * h) > (other.w * other.h);
    }
}
```

---

### 4. A Closer Look at Argument Passing

**Definition:** Java is pass-by-value: primitives are copied; for references, the reference is copied but the object is shared. So a method can change the object’s state but cannot make the caller’s variable point to a different object.

**Why and when to use:** Understanding this avoids bugs when modifying arrays or objects inside methods and when expecting a reference to change.

**How to use (short working example):**
```java
static void changePrimitive(int x) { x = 100; }
static void changeArray(int[] arr) { arr[0] = 100; }
// int a = 5; changePrimitive(a);  -> a is still 5
// int[] b = {1,2}; changeArray(b); -> b[0] is 100
```

---

### 5. Returning Objects from Methods

**Definition:** Method return type can be a class type. The method can create a new object or return an existing one.

**Why and when to use:** Use for factories, builders, or methods that compute a result object (e.g., parse string into Date, create a copy).

**How to use (short working example):**
```java
class Student {
    String name;
    Student(String n) { name = n; }
}
static Student create(String n) {
    return new Student(n);
}
```

---

### 6. Access Controls in Java

**Definition:** **public:** visible everywhere. **private:** only same class. **protected:** same package and subclasses. **default (no modifier):** same package only.

**Why and when to use:** Use `private` for implementation details; `public` for API; `protected` when subclasses need access.

**How to use (short working example):**
```java
public class Demo {
    public int a;
    private int b;
    protected int c;
    int d;  // package-private
}
```

---

### 7. Understanding Static Member Variables

**Definition:** A static variable has one copy per class, shared by all instances. Declared with `static`. Often used for constants, counters, or shared configuration.

**Why and when to use:** Use when the value is conceptually “for the class” not “per object” (e.g., object count, default settings).

**How to use (short working example):**
```java
class Counter {
    static int count = 0;
    Counter() { count++; }
    static int getCount() { return count; }
}
// After new Counter(); new Counter(); Counter.getCount() is 2
```

---

### 8. Understanding Static Member Methods

**Definition:** Static methods belong to the class, called as `ClassName.methodName()`. They cannot use `this` and cannot access instance fields directly (only static fields).

**Why and when to use:** Use for utility methods that do not depend on instance state (e.g., `Math.sqrt`, factory methods, helpers).

**How to use (short working example):**
```java
class Utils {
    static int add(int a, int b) { return a + b; }
}
int sum = Utils.add(3, 5);
```

---

### 9. Introducing Keyword Final

**Definition:** **final** variable: cannot be reassigned. **final** method: cannot be overridden. **final** class: cannot be extended.

**Why and when to use:** Use final for constants, for methods that must not be overridden, and for immutable or security-sensitive classes.

**How to use (short working example):**
```java
final double PI = 3.14159;
final int MAX = 100;
// PI = 3.14;  // compile error
```

---

### 10. Arrays Revisiting (Lab 5)

**Definition:** Same concept as before—fixed-size, same-type collection. `.length` is a field. Can be passed and returned from methods.

**Why and when to use:** When you need a fixed-size sequence. Revisit when combining with objects and static methods.

**How to use:** Declare, create, index, loop—see Lab 1 and Lab 4. Use with static utility methods that take `int[]` or `MyClass[]`.

---

### 11. String Class (Lab 5)

**Definition:** `String` is in `java.lang`, immutable. Common methods: `length()`, `charAt()`, `substring()`, `equals()`, `toUpperCase()`, `toLowerCase()`, `trim()`, `split()`. Use `equals()` for value comparison, not `==`.

**Why and when to use:** Whenever you work with text. Prefer `equals` to compare content.

**How to use (short working example):**
```java
String s = "  Hello ";
int len = s.length();
String t = s.trim();
boolean same = s.equals("  Hello ");
char c = s.charAt(1);
```

---

### 12. Command-Line Arguments (Lab 5)

**Definition:** Same as Lab 2—arguments passed to `main` as `String[] args` when running `java Main arg1 arg2`.

**Why and when to use:** For configuration at startup without interactive input.

**How to use:** In `main`, loop over `args` or use `args[0]`, `args[1]`, etc. (check length to avoid exceptions).

---

### 13. Varargs: Variable Length Arguments

**Definition:** Syntax `Type... name` in method parameter list. The method receives the arguments as an array of that type. Caller can pass any number of arguments (including zero).

**Why and when to use:** Use when the number of arguments varies (e.g., `printf`, logging, “add multiple items”). Cleaner than passing an array manually.

**How to use (short working example):**
```java
static int sum(int... nums) {
    int s = 0;
    for (int n : nums) s += n;
    return s;
}
int a = sum(1, 2, 3);      // 6
int b = sum(1, 2, 3, 4);    // 10
```

---

## Lab 6: Problem Solving with Methods – Scenario-Based Tasks

---

### 1. String Arrays as Attributes

**Definition:** A class can have an attribute of type `String[]` to store multiple related strings (e.g., subject names, categories).

**Why and when to use:** Use when one object logically has a list of strings (e.g., a student’s subjects, a product’s tags).

**How to use (short working example):**
```java
class Student {
    private String[] subjectNames;
    public Student(String[] subjects) { subjectNames = subjects; }
    public void displaySubjects() {
        for (String s : subjectNames) System.out.println(s);
    }
}
String[] subj = {"Math", "Science"};
Student s = new Student(subj);
s.displaySubjects();
```

---

### 2. Two-Dimensional Arrays (2D Arrays)

**Definition:** An array of arrays. Type `type[][]`. Good for grids/tables (e.g., rows = subjects, columns = grades).

**Why and when to use:** Use for tabular data: multiple rows, each with multiple values (e.g., grades per subject per student).

**How to use (short working example):**
```java
double[][] grades = {
    { 85, 90, 88 },
    { 78, 82, 80 }
};
double sum = 0;
for (int i = 0; i < grades.length; i++)
    for (int j = 0; j < grades[i].length; j++)
        sum += grades[i][j];
```

---

### 3. Circular Buffer Pattern

**Definition:** A fixed-size buffer where the oldest entry is overwritten when full. Index is computed as `index % size` (and optionally track count/start for correct ordering).

**Why and when to use:** Use for a fixed-size “recent items” list (e.g., last N transactions, last N temperatures).

**How to use (short working example):**
```java
class RecentHistory {
    private String[] buf = new String[5];
    private int count = 0;
    public void add(String s) {
        buf[count % buf.length] = s;
        count++;
    }
    public void show() {
        int n = Math.min(count, buf.length);
        for (int i = 0; i < n; i++)
            System.out.println(buf[(count - n + i) % buf.length]);
    }
}
```

---

### 4. Object Arrays

**Definition:** An array whose element type is a class (e.g., `Student[]`, `Library[]`). Each element is a reference (possibly null).

**Why and when to use:** Use when you need to manage multiple objects of the same type (e.g., list of books, list of accounts).

**How to use (short working example):**
```java
class Book { String title; Book(String t) { title = t; } }
Book[] shelf = new Book[10];
shelf[0] = new Book("Java");
shelf[1] = new Book("Python");
for (Book b : shelf)
    if (b != null) System.out.println(b.title);
```

---

### 5. Method Overloading with Arrays

**Definition:** Overload a method so one version takes a single value and another takes an array of that type (e.g., `recordTemp(double)` and `recordTemp(double[])`).

**Why and when to use:** Use when callers might have either one value or many; the array version can delegate to the single-value version in a loop.

**How to use (short working example):**
```java
void recordTemp(double t) { /* store t */ }
void recordTemp(double[] temps) {
    for (double t : temps) recordTemp(t);
}
```

---

### 6. Static Methods for Utility Operations

**Definition:** Static methods that operate on arrays of objects (or primitives) and do not need instance state (e.g., total value of `Inventory[]`, average of temperatures).

**Why and when to use:** Use for “aggregate” or “utility” operations that belong to the class, not to a single instance.

**How to use (short working example):**
```java
class Item {
    double price; int qty;
    double getTotal() { return price * qty; }
    static double totalValue(Item[] items) {
        double sum = 0;
        for (Item i : items)
            if (i != null) sum += i.getTotal();
        return sum;
    }
}
```

---

### 7. Finding Elements in Arrays

**Definition:** Iterate over an array (or array of objects) and collect elements that match a condition (e.g., overdue books, failing grades). Often return a new array or list of matches.

**Why and when to use:** Use when you need to filter or search (e.g., “all overdue”, “all below threshold”).

**How to use (short working example):**
```java
// Find all positive numbers
static int[] positives(int[] arr) {
    int count = 0;
    for (int x : arr) if (x > 0) count++;
    int[] out = new int[count];
    int j = 0;
    for (int x : arr) if (x > 0) out[j++] = x;
    return out;
}
```

---

### 8. Working with String Arrays

**Definition:** Using `String[]` for names, categories, options—with methods like search, validation (e.g., “is this category valid?”), and returning a copy (e.g., `getCategories().clone()`).

**Why and when to use:** Use when the domain has a fixed or configurable set of strings (e.g., allowed categories, subject names).

**How to use (short working example):**
```java
String[] categories = {"A", "B", "C"};
boolean isValid(String cat) {
    for (String c : categories) if (c.equals(cat)) return true;
    return false;
}
String[] getCategories() { return categories.clone(); }
```

---

### 9. Calculating Statistics from Arrays

**Definition:** Compute aggregate values: average, min, max, sum, index of max/min, count, etc., over numeric arrays (or over object arrays using a numeric field).

**Why and when to use:** Use for reporting and decision-making (e.g., average grade, highest temperature, total value).

**How to use (short working example):**
```java
static double avg(double[] a) {
    if (a.length == 0) return 0;
    double s = 0;
    for (double x : a) s += x;
    return s / a.length;
}
static double max(double[] a) {
    double m = a[0];
    for (int i = 1; i < a.length; i++) if (a[i] > m) m = a[i];
    return m;
}
```

---

### 10. Varargs in Methods (Lab 6)

**Definition:** Same as Lab 5—method with `Type... name` to accept zero or more arguments. Useful in scenario tasks to “add multiple items at once” (e.g., `addLibraries(Library... libs)`).

**Why and when to use:** When the API should allow a variable number of arguments for convenience (e.g., add multiple books in one call).

**How to use (short working example):**
```java
void addLibraries(Library... libs) {
    for (Library lib : libs) { /* add lib */ }
}
// addLibraries(book1, book2, book3);
```

---

## Lab 7: Comprehensive Integration

Lab 7 does not introduce new standalone topics; it **reviews and integrates** all concepts from Labs 1–6. Use the tutorials above for each topic and apply them together in the Lab 7 tasks (e.g., variables, arrays, methods, objects, encapsulation, overloading, static methods, 2D arrays, circular buffer, statistics, varargs).

---

*End of Tutorials by Topic*
