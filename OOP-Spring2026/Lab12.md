# Lab 12: Interfaces

## Table of Contents
1. [Introduction](#introduction)
2. [Topic Explanations](#topic-explanations)  
   - [Main purpose of interfaces](#main-purpose-of-interfaces)
3. [Progressive Tasks](#progressive-tasks)
4. [Practice Tasks](#practice-tasks)
5. [Submission Guidelines](#submission-guidelines)

---

## Introduction

In **Lab 11** you used **`abstract` classes**: a superclass can hold **fields** and **concrete** methods, and it can mark some methods **`abstract`** so subclasses fill them in. An **interface** is another way to say: *“these types must support the same **operations**,”* but the interface itself is **not** a class you extend for shared state—it is a **contract** of **method signatures** (and optionally **constants**) that **implementing** classes must satisfy.

This lab introduces the **`interface`** keyword and **`implements`**. You will **not** put instance fields in the interface (except **`public static final`** constants). Concrete classes **`implement`** one or more interfaces and **provide** the method bodies.

**Objectives:**
- Declare an **`interface`** with abstract method signatures (implicitly `public`).
- Make a **concrete** class **`implements`** an interface and **`@Override`** those methods.
- Explain when an **interface** fits better than an **abstract** class (and vice versa) for a small design.
- Optionally use a class that **`implements`** **more than one** interface.

**Prerequisites:**
- Lab 11 (abstract classes and methods, `extends`, `@Override`).
- Lab 9 (inheritance and polymorphism).

---

## Topic Explanations

### Main purpose of interfaces

**Interfaces** exist so you can:

1. **Define a shared contract** — Different, unrelated classes can expose the **same** operations (e.g. “anything **payable** knows `amountDue()`”) **without** sharing a single superclass tree.

2. **Support multiple “roles”** — A class may **`extend`** **one** superclass but **`implement`** **several** interfaces (e.g. `extends Person implements Payable, Printable`). Abstract classes alone do not give multiple inheritance of **implementation**; interfaces give multiple **capability** types.

3. **Keep coupling flexible** — Code that depends on **`Payable`** can call `amountDue()` on **any** implementing class, without caring whether it is a `Bill`, `Subscription`, or `LoanPayment`.

4. **No instance state in the interface (classic model)** — The interface lists **what** must be done, not **how** (except `default`/`static` methods in later Java—optional in this lab). **Fields** live in the **implementing** classes.

5. **Polymorphism through the interface type** — You can declare `Payable p = new UtilityBill(...);` and call `p.amountDue()`—same idea as “program to the supertype,” but the super**type** here is the **interface**.

Together, the **main purpose** is: **define a named set of behaviors that unrelated classes can implement, enable multiple roles per class, and write code that depends on the contract—not on concrete class names.**

---

### 1. Interface declaration

**What is it?**  
A type declared with **`interface`**. It lists **method signatures** (and may list **named constants**). You **cannot** do `new InterfaceName()` to get a normal object (unless using lambdas/anonymous classes—outside this lab).

**How to declare:**
```java
public interface Payable {
    double amountDue();  // implicitly public abstract
}
```

**Rules (classic interface):**
- Methods without a body are **`public abstract`** implicitly (you usually omit `abstract` for brevity).
- Variables in an interface are **`public static final`** implicitly.

---

### 2. Implementing an interface

**What is it?**  
A **concrete** class uses **`implements`** to promise it provides every method the interface requires.

**How to declare:**
```java
public class Invoice implements Payable {
    @Override
    public double amountDue() {
        return 100.0;
    }
}
```

If the class **does not** implement every abstract method, it must be declared **`abstract`** itself.

---

### 3. Multiple interfaces

A class may list several interfaces:

```java
public class Report implements Printable, Storable {
    // must implement all methods from both interfaces
}
```

Use this when one object plays **more than one role** in your design.

---

### 4. Interface vs abstract class (when to use which)

| Idea | Abstract class (Lab 11) | Interface (Lab 12) |
|------|-------------------------|----------------------|
| Inheritance | Subclass **`extends`** **one** superclass | Class **`implements`** **one or more** interfaces |
| Fields / shared code | Yes: instance fields, constructors, concrete methods | Classic interface: **no** instance fields; **constants** only |
| “Is-a” vs “can-do” | Often **is-a** kind of X | Often **can-do** Y (capability) |
| Multiple | Single superclass | Multiple interfaces |

**Rule of thumb:** Shared **state** and **template** behavior in a family of types → often an **abstract** class. Shared **behavior names** across **unrelated** types → often an **interface**.

---

### 5. Quick reference

| Keyword / idea | Meaning |
|----------------|---------|
| `interface` | Declares a contract (method signatures + constants). |
| `implements` | Concrete class supplies bodies for all required methods. |
| `@Override` | Use on methods that fulfill interface methods (recommended). |
| `public` on implementing method | Must match interface (interface methods are public). |

---

## Progressive Tasks

**Important:** There are **3 progressive tasks**. Each task defines **one interface** and **one concrete class** that **`implements`** it. These scenarios use **interfaces** instead of **abstract** superclasses (compare mentally with Lab 11).

Create a **`Main`** class to test all three tasks.

**Topics covered:**
- Task 1: **`Measurable`** → **`Rectangle`** implements `area()`
- Task 2: **`Payable`** → **`HourlyService`** implements `amountDue()`
- Task 3: **`Describable`** → **`Product`** implements `describe()`

---

### Task 1: Measurable and Rectangle (Interface for “has an area”)

**Scenario:**  
A toolkit treats many objects as **measurable** (they can report an **area**). A **rectangle** is one concrete kind. Model **`Measurable`** as an **interface** with one operation **`area()`**. Implement **`Rectangle`** as a **class** that **`implements`** **`Measurable`**.

**Requirements:**

1. **Interface `Measurable`:**
   - Method: `double area();` — no body in the interface.

2. **Concrete class `Rectangle` implements `Measurable`:**
   - Private attributes: `width` (double), `height` (double).
   - Constructor: `Rectangle(double width, double height)`.
   - **`@Override`** `public double area()` to return `width * height`.
   - Add `double perimeter()` returning `2 * (width + height)` (not part of the interface).

3. **In `Main`:**
   - Declare a reference of type **`Measurable`** pointing to a **`Rectangle`**: e.g. `Measurable m = new Rectangle(4.0, 5.0);`
   - Print `m.area()` (expect **20.0**).  
   - Comment in your report: you **cannot** call `m.perimeter()` through **`Measurable m`** unless you cast—explain why.

---

### Task 2: Payable and HourlyService (Interface for “amount due”)

**Scenario:**  
Accounting software processes anything **payable**—each object must report **how much is due now**. An **hourly service** bill charges **hours × rate**. Model **`Payable`** with **`amountDue()`**. Implement **`HourlyService`**.

**Requirements:**

1. **Interface `Payable`:**
   - Method: `double amountDue();`

2. **Concrete class `HourlyService` implements `Payable`:**
   - Private attributes: `hours` (double), `ratePerHour` (double).
   - Constructor: `HourlyService(double hours, double ratePerHour)`.
   - **`@Override`** `public double amountDue()` to return `hours * ratePerHour`.

3. **In `Main`:**
   - Create `Payable p = new HourlyService(10, 50);`
   - Print `p.amountDue()` (expect **500.0**).

---

### Task 3: Describable and Product (Interface for “text description”)

**Scenario:**  
A catalog UI can show a **short description** for any **describable** item. A **product** has a **name** and **SKU**. Model **`Describable`** with **`describe()`**. Implement **`Product`**.

**Requirements:**

1. **Interface `Describable`:**
   - Method: `String describe();`

2. **Concrete class `Product` implements `Describable`:**
   - Private attributes: `name` (String), `sku` (String).
   - Constructor: `Product(String name, String sku)`.
   - **`@Override`** `public String describe()` to return something like `"Product: " + name + " (" + sku + ")"` (exact format is flexible but must include name and sku).

3. **In `Main`:**
   - Create `Describable d = new Product("Mouse", "SKU-001");`
   - Print `d.describe()`.

---

## Practice Tasks

These are **optional** and use **different** names from the progressive tasks.

**Easy**
- **`interface Loud`** with `void makeNoise();` — **`Alarm`** implements with a `println`.
- **`interface Identifiable`** with `String getId();` — **`StudentCard`** implements.

**Medium**
- **`interface ComparableArea`** with `double area();` — **`Circle`** implements using `Math.PI * radius * radius`.
- A single class **`SmartPhone`** that **`implements`** **`Callable`** and `Textable` (two small interfaces with one method each).

**A bit harder**
- **`interface DataStore`** with `boolean save(String key, String value);` and `String load(String key);` — **`MemoryStore`** uses two parallel arrays or a `HashMap` (if allowed).
- Refactor one **Lab 11** abstract method into an **interface** + **concrete** class (short write-up: what you gained or lost).

---

## Submission Guidelines

1. Complete all **3** progressive tasks (`Measurable`/`Rectangle`, `Payable`/`HourlyService`, `Describable`/`Product`).
2. In your report, **one short paragraph**: when you would choose an **interface** instead of an **abstract** class for a new feature.
3. Ensure all code compiles; show **`implements`** and **`@Override`** clearly.
4. Use separate `.java` files if required; one `Main` may test all tasks.
5. Submit as per your course instructions (e.g. Word file or zip on eLearning).

---

## Notes

- Interface methods are **`public`**; implementing methods must be **`public`** too.
- A class **`extends`** at most **one** class but may **`implement`** **many** interfaces.
- **`interface`** types are excellent for **variables** and **method parameters** (`void printArea(Measurable m)`).
- **`default`** methods in interfaces (Java 8+) are optional advanced reading—not required for this lab’s core tasks.
- **Abstract class vs interface:** Lab 11 and Lab 12 **complement** each other; real programs often use **both**.
