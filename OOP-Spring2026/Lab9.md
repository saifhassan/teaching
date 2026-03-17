# Lab 9: Inheritance (Is-a Relationship)

## Table of Contents
1. [Introduction](#introduction)
2. [Topic Explanations](#topic-explanations)
3. [Progressive Tasks](#progressive-tasks)
4. [Practice Tasks](#practice-tasks)
5. [Submission Guidelines](#submission-guidelines)

---

## Introduction

This lab introduces **inheritance** in Java: the **is-a** relationship. When one class is a *kind of* another (e.g. a Student **is a** Person), we use the keyword **`extends`** so the subclass gets the superclass’s fields and methods, and we can add or override behavior. You will use **`super()`** in constructors and **`super.method()`** when overriding methods.

**Objectives:**
- Understand the **is-a** relationship and when to use inheritance (vs has-a from Lab 8)
- Create a subclass with **`extends`** and call **`super()`** in constructors
- **Override** methods in the subclass and use **`super.method()`** to call the superclass version
- Build small hierarchies (Person → Student, Vehicle → Car, Employee → Manager)

**Prerequisites:**
- Completion of Labs 1–8 (classes, constructors, getters/setters, encapsulation, has-a relationships)
- Watch the **Lab 9 video lecture** before the lab and try Task 1 on your own; bring your questions.

---

## Topic Explanations

### 1. Is-a vs Has-a

**What is is-a?**  
When we say “A **is a** B,” we mean A is a *kind of* B. For example: a **Student is a** Person, a **Car is a** Vehicle. In Java we model this with **inheritance**: the subclass **extends** the superclass.

**Difference from Lab 8:**
- **Has-a** (Lab 8): One class *has* another as an attribute (e.g. Teacher *has a* Laptop). We use a **reference** (variable of another class). No `extends`.
- **Is-a** (this lab): One class *is a kind of* another (e.g. Student *is a* Person). We use **`extends`**; the subclass inherits from the superclass.

**Example idea:**
```
    Person
       |
    Student   →  Student extends Person  ("Student is a Person")
```

---

### 2. extends and What Is Inherited

**What does extends do?**  
The subclass gets the superclass’s **public** and **protected** members (and package-private if in the same package). It does **not** get private fields directly, but it can use public/protected getters and setters. The subclass can add its **own** fields and methods.

**How to use:**
```java
public class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
    public String getName() { return name; }
    public int getAge() { return age; }
}

public class Student extends Person {
    private int studentId;
    private double gpa;
    // Student has name, age (from Person) + studentId, gpa (its own)
}
```

**Summary:** Subclass **extends** superclass; it inherits non-private members and can add new fields and methods.

---

### 3. super() in Constructors

**Why super()?**  
When you create a `Student`, the `Person` part must be initialized first. So the **first line** of the subclass constructor must call a superclass constructor using **`super(...)`**.

**Rules:**
- The first statement in a subclass constructor must be either `super(...)` or `this(...)` (another constructor of the same class).
- If you don’t write `super(...)`, Java tries to insert `super();` (no arguments). Then the superclass must have a no-argument constructor, or you get a compile error.
- **Best practice:** Always write `super(...)` explicitly with the right parameters.

**How to use:**
```java
public class Student extends Person {
    private int studentId;
    private double gpa;

    public Student(String name, int age, int studentId, double gpa) {
        super(name, age);   // MUST be first – calls Person(name, age)
        this.studentId = studentId;
        this.gpa = gpa;
    }
}
```

**Summary:** First line of subclass constructor = `super(...)`; then initialize your own fields.

---

### 4. Method Overriding and super.method()

**What is overriding?**  
When the subclass defines a method with the **same name and same parameter list** as the superclass, the subclass version **overrides** the superclass version. When you call that method on a subclass object, the subclass version runs.

**When to use:**  
To give **specialized behavior** (e.g. `Student`’s `display()` shows name, age, and also studentId and gpa).

**Using super.method():**  
Inside the overridden method you can call the superclass version with **`super.methodName()`** and then add more behavior.

**How to use:**
```java
public class Student extends Person {
    // ... fields and constructor ...

    @Override
    public void display() {
        super.display();   // call Person's display first
        System.out.println("Student ID: " + studentId + ", GPA: " + gpa);
    }
}
```

**Optional:** The **`@Override`** annotation tells the compiler you intend to override a method; if the signature doesn’t match any superclass method, you get an error (helps avoid typos).

**Summary:** Override = same name and parameters in subclass. Use `super.method()` to reuse the superclass behavior, then add more.

---

### 5. Quick Comparison

| Concept        | Meaning |
|----------------|---------|
| **extends**    | Subclass inherits from superclass (is-a). |
| **super(...)** | First line in subclass constructor; calls superclass constructor. |
| **super.method()** | Inside overridden method; calls superclass version of the method. |
| **Override**   | Subclass method same name and parameters as superclass; replaces behavior for subclass objects. |

---

## Progressive Tasks

**Important:** There are **3 progressive tasks**. Each uses **inheritance**: one superclass and one subclass with `extends`, `super()`, and at least one overridden method. These tasks are **different from the video/slides** (Person–Student, Vehicle–Car) and are **a bit more challenging**: you will override more than one method in some tasks and use simple calculations. Create the classes and a `Main` class to test.

**Topics covered:**
- Task 1: **Shape → Rectangle** (override `getArea()` and `display()`; add `getPerimeter()`)
- Task 2: **Animal → Dog** (override `makeSound()`; add `displayInfo()` using superclass getter)
- Task 3: **Product → DiscountedProduct** (override `getPrice()` with calculation; override `getProductInfo()`)

---

### Task 1: Shape and Rectangle (Inheritance)

**Scenario:**  
A **Rectangle is a** Shape. Every shape has a color; a rectangle also has width and height. The superclass provides a default `getArea()` (returns 0); the subclass overrides it to compute actual area and adds a perimeter method.

**Requirements:**

1. **Class `Shape`:**
   - Private attribute: `color` (String).
   - Parameterized constructor: `Shape(String color)`.
   - Getter: `getColor()`.
   - Method `getArea()` that returns `0.0` (double) — default for a generic shape.
   - Method `display()` that prints only the color (e.g. `"Color: Red"`).

2. **Class `Rectangle` (extends Shape):**
   - Private attributes: `width` (double), `height` (double).
   - Parameterized constructor: `Rectangle(String color, double width, double height)`.
   - **First line of constructor:** `super(color);`
   - **Override** `getArea()` to return `width * height`.
   - Add method `getPerimeter()` that returns `2 * (width + height)` (do not override; Shape has no perimeter).
   - **Override** `display()`: call `super.display();` then print area and perimeter (use `getArea()` and `getPerimeter()`).

3. **In `Main`:**
   - Create a `Rectangle` (e.g. color `"Blue"`, width 5.0, height 3.0).
   - Call `display()` and show color, area, and perimeter.
   - Print `getArea()` and `getPerimeter()` separately to confirm values (15.0 and 16.0).

---

### Task 2: Animal and Dog (Inheritance)

**Scenario:**  
A **Dog is an** Animal. Animals have a name and can make a sound; the superclass has a default sound. A dog has a breed and makes a specific sound (e.g. "Bark"). You will override the sound and add a method that shows both name and breed.

**Requirements:**

1. **Class `Animal`:**
   - Private attribute: `name` (String).
   - Parameterized constructor: `Animal(String name)`.
   - Getter: `getName()`.
   - Method `makeSound()` that prints a generic message (e.g. `"Makes a sound"`).

2. **Class `Dog` (extends Animal):**
   - Private attribute: `breed` (String).
   - Parameterized constructor: `Dog(String name, String breed)`.
   - **First line of constructor:** `super(name);`
   - **Override** `makeSound()` to print `"Bark"` (or `"Woof"`).
   - Getter: `getBreed()`.
   - Method `displayInfo()` that prints the dog’s name (using `getName()`) and breed. Do **not** override a method from Animal for this — add it only in Dog.

3. **In `Main`:**
   - Create a `Dog` (e.g. name `"Max"`, breed `"Labrador"`).
   - Call `makeSound()` — output should be "Bark", not the generic message.
   - Call `displayInfo()` and show name and breed.

---

### Task 3: Product and DiscountedProduct (Inheritance)

**Scenario:**  
A **DiscountedProduct is a** Product that has a discount percentage. The superclass has name and price; the subclass overrides `getPrice()` to return the price after discount and overrides the info method to show both original price and discounted price.

**Requirements:**

1. **Class `Product`:**
   - Private attributes: `productName` (String), `price` (double).
   - Parameterized constructor: `Product(String productName, double price)`.
   - Getter: `getPrice()` returns the price.
   - Getter: `getProductName()` (so subclass can use it if needed).
   - Method `getProductInfo()` that prints product name and price (e.g. `"Product: Laptop, Price: 50000"`).

2. **Class `DiscountedProduct` (extends Product):**
   - Private attribute: `discountPercent` (double) — e.g. 10 means 10% off.
   - Parameterized constructor: `DiscountedProduct(String productName, double price, double discountPercent)`.
   - **First line of constructor:** `super(productName, price);`
   - **Override** `getPrice()` to return the price after discount. Formula: original price × (100 − discountPercent) / 100. Inside the overridden method, use `super.getPrice()` to get the original price, then compute and return the discounted value.
   - **Override** `getProductInfo()`: call `super.getProductInfo();` then print discount percentage and the final price (call `getPrice()`).

3. **In `Main`:**
   - Create a `DiscountedProduct` (e.g. name `"Mouse"`, price 2000, discount 15).
   - Call `getProductInfo()` — should show name, original price, discount %, and final price.
   - Print `getPrice()` and verify it returns 1700 (2000 after 15% off).

---

## Practice Tasks

These are **optional** for extra practice. They use different scenarios from the progressive tasks above.

**Easy**
- **Person → Student:** Class `Person` (name, age). Class `Student` extends Person (studentId, gpa). Constructor with `super(name, age)`. Override `display()` to show name, age, studentId, gpa.
- **Vehicle → Car:** Class `Vehicle` (brand, speed). Class `Car` extends Vehicle (numDoors). Override `showInfo()` and use `super.showInfo()`.

**Medium**
- **Book → EBook:** Class `Book` (title, author). Class `EBook` extends Book (fileSizeInMB). Override a method that returns a string description to include file size.
- **Employee → Manager:** Class `Employee` (name, salary). Class `Manager` extends Employee (bonus). Override `getTotalPay()` to return salary + bonus; override `displayInfo()` to show bonus and total pay.

**A bit harder**
- **Person → Student → GraduateStudent:** Three-level hierarchy. GraduateStudent extends Student, adds thesisTitle. Both Student and GraduateStudent override display() and call super.display() before adding their own info.

---

## Submission Guidelines

1. Complete all **3** progressive tasks (Task 1: Shape/Rectangle, Task 2: Animal/Dog, Task 3: Product/DiscountedProduct).
2. Practice tasks are optional but recommended (try at least 1).
3. Use separate files per class if your environment requires it (e.g. `Person.java`, `Student.java`, `Main.java`); or one file with multiple classes if allowed. One `Main` class can test all three tasks.
4. Ensure code compiles and runs without errors.
5. Follow naming: PascalCase for classes, camelCase for methods and variables.
6. Submit as per your course instructions (e.g. one Word file or zipped project on eLearning).

---

## Notes

- **Inheritance** = is-a; use **`extends`**.
- **First line** of subclass constructor must be **`super(...)`** (or `this(...)`).
- **Overriding** = same method name and parameters in subclass; use **`super.method()`** to call the superclass version.
- **@Override** is optional but helps catch mistakes.
- This lab uses **is-a** (inheritance); Lab 8 used **has-a** (association, aggregation, composition). Do not mix them in the same task: e.g. Student *extends* Person (is-a); Student does not *have a* Person as an attribute.
