# Lab 11: Abstract Classes and Abstract Methods

## Table of Contents
1. [Introduction](#introduction)
2. [Topic Explanations](#topic-explanations)  
   - [Main purpose of abstract classes and methods](#main-purpose-of-abstract-classes-and-methods)
3. [Progressive Tasks](#progressive-tasks)
4. [Practice Tasks](#practice-tasks)
5. [Submission Guidelines](#submission-guidelines)

---

## Introduction

In Labs 9–10 you used **concrete** superclasses: you could write `new Person()` or `new BankAccount()` when the class was not abstract. Some problems need a **general category** (“any shape,” “any employee paid somehow”) where **you do not know the exact formula** until you pick a **concrete** kind (rectangle, hourly worker). **Abstract classes** and **abstract methods** let you define **what** every subclass must provide (e.g. “every shape has an area”) **without** writing a fake default in the parent.

This lab introduces **`abstract`** classes and **`abstract`** methods in Java. You will **not** instantiate the abstract class directly; you will **`extend`** it and **implement** the abstract methods in **concrete** subclasses.

**Objectives:**
- Declare an **`abstract`** class and explain when it is preferable to a fully concrete superclass.
- Declare **`abstract`** methods (no body in the parent) and **implement** them in concrete subclasses.
- Mix **concrete** methods (with a body) in an abstract class with **abstract** methods.
- Use **`super(...)`** in subclass constructors when the abstract class has fields to initialize.

**Prerequisites:**
- Lab 9 (inheritance, `extends`, overriding, `super()`).
- Lab 10 optional (multi-subclass hierarchies).

---

## Topic Explanations

### Main purpose of abstract classes and methods

**Abstract classes** and **abstract methods** exist so you can:

1. **Define a shared “role”** — A superclass states *what* every kind of object in the family must be able to do (e.g. “every shape has an area,” “every employee has a monthly pay”), **without** pretending that the parent has one universal formula.

2. **Avoid fake defaults** — You no longer need a meaningless implementation in the parent (e.g. `getArea()` returning `0` for every shape) just to satisfy the compiler. The parent **does not implement** that part; each **concrete** subclass supplies the real rule.

3. **Reuse shared code** — The abstract class can still hold **fields**, **constructors**, and **concrete** methods (e.g. getters, `display()` that calls `getArea()`), so subclass code is not duplicated.

4. **Force subclasses to implement** — Any **concrete** subclass **must** provide bodies for all inherited **abstract** methods, or the program will not compile. That **guarantees** that each concrete type fills in the missing behavior.

5. **Prevent creating “incomplete” objects** — You **cannot** `new` an abstract class for a normal object, so you never accidentally create a “shape” that is not actually a rectangle, circle, etc.

Together, the **main purpose** is: **model a general category that is not complete on its own, share what is common, and require each concrete subclass to supply the part that depends on the specific type.**

---

### 1. Abstract class

**What is it?**  
A class marked **`abstract`** may be **incomplete**. You **cannot** write `new AbstractClassName()` if the class is abstract (unless you use an anonymous class, which is outside this lab).

**When to use:**  
When you want to **share code** (fields, concrete methods) among several kinds, but some behavior **depends on the subtype** and should not be guessed in the parent.

**How to declare:**
```java
public abstract class Shape {
    // fields, constructors, concrete methods, abstract methods
}
```

---

### 2. Abstract method

**What is it?**  
A method with **no body** in the abstract class—only a **signature** ending with a semicolon. Subclasses **must** override and implement it (unless the subclass is also abstract).

**How to declare:**
```java
public abstract double getArea();  // no { }
```

**Rules:**
- If a class has **any** `abstract` method, the class itself must be declared **`abstract`**.
- A **concrete** subclass **must** implement **all** inherited abstract methods, or it will not compile.

---

### 3. Concrete methods inside an abstract class

An **abstract class** can still have **normal** methods with bodies (e.g. getters, `display()` that uses abstract `getArea()` indirectly). That **reuses** behavior in one place while forcing subclasses to supply the missing pieces.

---

### 4. Comparison: Lab 9 vs Lab 11

| Idea | Lab 9 (concrete superclass) | Lab 11 (abstract superclass) |
|------|-----------------------------|------------------------------|
| Instantiate parent? | Often yes (`new Shape()` with default area 0) | **No** (`new Shape()` is illegal if `Shape` is abstract) |
| Parent method body | Fully implemented or default | **Abstract** methods: **no** body in parent |
| Subclass job | Override when behavior differs | **Must** implement every abstract method |

---

### 5. Quick reference

| Keyword / idea | Meaning |
|----------------|---------|
| `abstract class` | Class cannot be instantiated (normally). |
| `abstract` method | Subclass must provide implementation (in a concrete class). |
| `extends` | Concrete subclass extends abstract superclass like normal inheritance. |
| `@Override` | Use on methods that implement abstract methods (recommended). |

---

## Progressive Tasks

**Important:** There are **3 progressive tasks**. Each task uses **one abstract superclass** and **one concrete subclass** that `extends` it and **implements** all abstract methods. These scenarios are **different** from Lab 9’s fully concrete `Shape` / `Animal` / `Product` parents—here the parent is **abstract**.

Create a **`Main`** class to test all three tasks.

**Topics covered:**
- Task 1: **`Shape` (abstract)** → **`Rectangle`** (concrete): abstract `getArea()`
- Task 2: **`Employee` (abstract)** → **`HourlyEmployee`** (concrete): abstract `monthlyPay()`
- Task 3: **`Invoice` (abstract)** → **`TaxedInvoice`** (concrete): abstract `amountDue()`

---

### Task 1: Shape and Rectangle (Abstract area)

**Scenario:**  
A drawing app works with **shapes**. Every shape has a **color**, but **area** depends on the **kind** of shape (rectangle, circle, …). The **general** idea “shape” should not invent a fake area; only **concrete** shapes provide a formula. Model **`Shape`** as **abstract** with an **abstract** `getArea()`. Implement **`Rectangle`**.

**Requirements:**

1. **Abstract class `Shape`:**
   - Private attribute: `color` (String).
   - Constructor: `Shape(String color)` — initializes `color`.
   - Getter: `getColor()`.
   - **Abstract method:** `public abstract double getArea();` — no body.
   - **Concrete method:** `display()` that prints the color and the area by calling `getColor()` and `getArea()` (so subclasses do not repeat this logic).

2. **Concrete class `Rectangle` extends `Shape`:**
   - Private attributes: `width` (double), `height` (double).
   - Constructor: `Rectangle(String color, double width, double height)` — first line `super(color);`, then set width and height.
   - **Implement** `getArea()` to return `width * height` (use `@Override`).
   - Add method `getPerimeter()` returning `2 * (width + height)` (not abstract).

3. **In `Main`:**
   - You **cannot** create `new Shape(...)` — comment in your report that this would not compile.
   - Create `Rectangle r = new Rectangle("Red", 4.0, 5.0);`
   - Call `r.display()` and print `r.getArea()` and `r.getPerimeter()` — expect area **20.0**, perimeter **18.0**.

---

### Task 2: Employee and HourlyEmployee (Abstract pay)

**Scenario:**  
HR software tracks **employees**. Every employee has a **name** and **ID**, but **monthly gross pay** is calculated **differently** (salary, hourly, commission). The **generic** “employee” should not invent a pay amount; only **concrete** employment types implement the rule. Model **`Employee`** as **abstract** with **abstract** `monthlyPay()`. Implement **`HourlyEmployee`** (paid by hours × rate).

**Requirements:**

1. **Abstract class `Employee`:**
   - Private attributes: `name` (String), `employeeId` (String).
   - Constructor: `Employee(String name, String employeeId)`.
   - Getters: `getName()`, `getEmployeeId()` (optional but useful).
   - **Abstract method:** `public abstract double monthlyPay();`
   - **Concrete method:** `display()` that prints name and ID.

2. **Concrete class `HourlyEmployee` extends `Employee`:**
   - Private attributes: `hoursWorked` (double), `hourlyRate` (double).
   - Constructor: `HourlyEmployee(String name, String employeeId, double hoursWorked, double hourlyRate)` — first line `super(name, employeeId);`.
   - **Implement** `monthlyPay()` to return `hoursWorked * hourlyRate` (document if you treat this as “this month” pay).

3. **In `Main`:**
   - Create `HourlyEmployee e = new HourlyEmployee("Ali", "E102", 80, 50);`  
   - Print `e.monthlyPay()` (expect **4000.0**) and call `e.display()`.

---

### Task 3: Invoice and TaxedInvoice (Abstract amount due)

**Scenario:**  
Billing uses **invoices**. Every invoice has an **invoice number** and a **base amount**, but the **final amount due** might add **tax** or other rules. The **abstract** invoice type forces each concrete invoice to say how much is **actually due**. Implement **`TaxedInvoice`** that adds a **tax percent** to the base.

**Requirements:**

1. **Abstract class `Invoice`:**
   - Private attributes: `invoiceNumber` (String), `baseAmount` (double).
   - Constructor: `Invoice(String invoiceNumber, double baseAmount)`.
   - Getter for `baseAmount` (e.g. `getBaseAmount()`) so subclasses can use it.
   - **Abstract method:** `public abstract double amountDue();` — final amount to pay for this invoice type.
   - **Concrete method:** `printHeader()` that prints invoice number and base amount.

2. **Concrete class `TaxedInvoice` extends `Invoice`:**
   - Private attribute: `taxPercent` (double) — e.g. `15` means 15%.
   - Constructor: `TaxedInvoice(String invoiceNumber, double baseAmount, double taxPercent)` — first line `super(invoiceNumber, baseAmount);`.
   - **Implement** `amountDue()` to return `getBaseAmount() * (1 + taxPercent / 100)`.

3. **In `Main`:**
   - Create `TaxedInvoice inv = new TaxedInvoice("INV-01", 1000, 15);`  
   - Call `printHeader()` and print `amountDue()` — expect **1150.0** for 15% tax on 1000.

---

## Practice Tasks

These are **optional** and use **different** names from the progressive tasks.

**Easy**
- **`abstract class Animal`** with `abstract void makeSound();` — **`class Cat`** implements with `"Meow"`.
- **`abstract class BankAccount`** with `abstract double monthlyFee();` — **`class SavingsAccount`** implements with a fixed small fee.

**Medium**
- **`abstract class Course`** with `abstract int totalCredits();` — **`LabCourse`** adds lab credits to theory credits.
- **`abstract class Vehicle`** with `abstract double maxRangeKm();` — **`ElectricVehicle`** uses battery kWh and consumption.

**A bit harder**
- **`abstract class DataSource`** with `abstract String readLine();` — two concrete classes **`FileSource`** and **`KeyboardSource`** (simplified: return fixed strings or read from `Scanner` once).
- **`abstract class Shape`** with **`Circle`** implementing `getArea()` using `Math.PI * r * r` (add second concrete class to your project).

---

## Submission Guidelines

1. Complete all **3** progressive tasks (Task 1: `Shape` / `Rectangle`, Task 2: `Employee` / `HourlyEmployee`, Task 3: `Invoice` / `TaxedInvoice`).
2. In your report, **one short paragraph**: why `Shape` / `Employee` / `Invoice` should be **abstract** instead of concrete with default implementations.
3. Ensure all code compiles; **`new` on an abstract class** should appear only in comments showing it is illegal.
4. Use separate `.java` files if required; one `Main` may test all tasks.
5. Submit as per your course instructions (e.g. Word file or zip on eLearning).

---

## Notes

- **`abstract`** class: cannot use `new AbstractClass()` for a normal instance.
- **Concrete** subclass: must **`@Override`** every inherited `abstract` method.
- You can still use **`super(...)`** and **`super.method()`** like in Lab 9.
- **Interfaces** (another way to force behavior) are a separate topic; this lab uses **abstract classes** only.
