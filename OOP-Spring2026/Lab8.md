# Lab 8: Association, Aggregation & Composition (Beginner Level)

## Table of Contents
1. [Introduction](#introduction)
2. [Topic Explanations](#topic-explanations)
3. [Progressive Tasks](#progressive-tasks)
4. [Practice Tasks](#practice-tasks)
5. [Submission Guidelines](#submission-guidelines)

---

## Introduction

This lab introduces the **names** for relationships you have already used: when one class **has** another class as an attribute. You will learn the terms **Association**, **Aggregation**, and **Composition**, and when to use each. All three are "has-a" relationships; the difference is how strong the link is and whether the "part" can exist without the "whole."

**Objectives:**
- Understand the **has-a** relationship (one object has another as an attribute)
- Learn **Association**: two classes linked, both can exist independently
- Learn **Aggregation**: whole-part; the part can exist without the whole (e.g., a department has students; students can exist without the department)
- Learn **Composition**: whole-part; the part cannot exist without the whole (e.g., a car has an engine; the engine is created with the car)
- Implement each type in Java with at most a few methods per class (beginner-friendly)

**Prerequisites:**
- Completion of Labs 1-7 (classes, constructors, getters/setters, private attributes)
- Using an object as an attribute of another class (you have done this; now we put names to it)

---

## Topic Explanations

### 1. The "Has-a" Relationship

**What does "has-a" mean?**
When one class **has** another class as an attribute, we say there is a **has-a** relationship. For example: a `Person` **has a** `Car`, a `Department` **has** many `Student`s, a `Car` **has an** `Engine`. This is different from **is-a** (inheritance): here we do not use `extends`; we use a **reference** (variable) of another class inside our class.

**How you already use it:**
- You create a class with an attribute whose type is another class.
- You can set it in the constructor or with a setter, and use it in methods.

**Example:**
```java
public class Person {
    private String name;
    private Car car;   // Person "has-a" Car

    public Person(String name) {
        this.name = name;
        this.car = null;  // may have no car
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }
}

public class Car {
    private String model;
    public Car(String model) { this.model = model; }
    public String getModel() { return model; }
}
```

Here, `Person` has a reference to `Car`. Both `Person` and `Car` can be created and used **independently**. This is a simple form of **Association**.

---

### 2. Association

**What is Association?**
**Association** is a general link between two classes. One class uses or references the other. **Both objects can exist independently**: the "part" is not owned or created by the "whole"; it can be shared or changed.

**When to use:**
- When class A uses class B, but B can exist without A (e.g., Person has a Car; Car can exist without that Person).
- The link can be optional (person may have no car) and can change (person can get a different car).

**Simple idea:**
- Class A has an attribute of type B (or a reference to B).
- B is created **outside** A and passed in (constructor or setter).
- B can be `null` (optional link).

**Example:**
```java
// Car exists on its own
Car c = new Car("Toyota");
// Person exists on its own
Person p = new Person("Ali");
// We link them: Person has a Car (association)
p.setCar(c);
```

**Summary:** Association = has-a, both independent, link can be optional or changed.

---

### 3. Aggregation

**What is Aggregation?**
**Aggregation** is a **whole-part** relationship where the **part can exist without the whole**. The whole "contains" or "has" parts, but the parts are not created by the whole; they are added from outside. Typical example: a **Department** has many **Students**; students exist before joining the department and can leave it.

**When to use:**
- When one object is a "container" of other objects (e.g., Team has Players, Department has Students).
- The parts are created elsewhere and **added** to the whole (e.g., addStudent, addPlayer).
- If the whole is removed, the parts still exist (e.g., if the department closes, students still exist).

**How to use in Java:**
- The "whole" class has an attribute that holds **multiple** parts: a **simple array** (e.g., `Student[] students`) and a **counter** (e.g., `int count`) for how many parts are added.
- Methods like `addStudent(Student s)` add a part to the array (if there is space) and update the counter.
- The parts are created in `Main` or elsewhere and passed in.

**Example:**
```java
public class Department {
    private String name;
    private Student[] students;  // simple array of parts
    private int count;           // how many students added

    public Department(String name, int maxSize) {
        this.name = name;
        this.students = new Student[maxSize];
        this.count = 0;
    }

    public void addStudent(Student s) {
        if (count < students.length) {
            students[count] = s;
            count++;
        }
    }

    public void displayStudents() {
        for (int i = 0; i < count; i++)
            System.out.println(students[i].getName());
    }
}

// In Main: Student objects exist independently; we add them to Department
Student s1 = new Student("Sara");
Department d = new Department("CS", 10);
d.addStudent(s1);   // aggregation: part added to whole
```

**Summary:** Aggregation = whole-part; part can exist without whole; parts are added from outside using a simple array (and a count).

---

### 4. Composition

**What is Composition?**
**Composition** is a **whole-part** relationship where the **part cannot exist without the whole**. The whole **creates** and **owns** the part. If the whole is destroyed, the part has no meaning on its own. Typical example: a **Car** has an **Engine**; the engine is created when the car is created and belongs only to that car.

**When to use:**
- When the "part" has no independent meaning without the "whole" (e.g., Engine of a Car, Room of a House).
- The whole **creates** the part inside its own constructor (or in a method that builds the object).
- The part is not shared with other objects; it is **owned** by one whole.

**How to use in Java:**
- The "whole" class has an attribute of the "part" type.
- The **whole's constructor** creates the part object (e.g., `this.engine = new Engine("V6");`).
- The part is not passed in from outside; it is created inside the whole.

**Example:**
```java
public class Car {
    private String model;
    private Engine engine;   // Car "owns" an Engine

    public Car(String model, String engineType) {
        this.model = model;
        this.engine = new Engine(engineType);  // Engine CREATED inside Car
    }

    public void start() {
        engine.start();   // delegate to part
    }

    public String getEngineInfo() {
        return engine.getType();
    }
}

public class Engine {
    private String type;
    public Engine(String type) { this.type = type; }
    public void start() { System.out.println("Engine started"); }
    public String getType() { return type; }
}
```

**Summary:** Composition = whole-part; part is **created inside** the whole and cannot exist without it.

---

### 5. Quick Comparison

| Type          | Idea                    | Part created where?     | Part can exist without whole? |
|---------------|-------------------------|-------------------------|--------------------------------|
| **Association**  | A uses B; link optional  | Outside, passed in      | Yes                            |
| **Aggregation** | Whole has many parts    | Outside, added to whole  | Yes                            |
| **Composition** | Whole owns part         | Inside whole (constructor) | No                          |

---

## Progressive Tasks

**Important:** There are **3 progressive tasks**. Each task uses **at most 3 methods in total** across the classes involved (excluding constructors) to keep it easy. Together they cover **Association**, **Aggregation**, and **Composition**. Create the classes and a `Main` class to test.

**Topics covered:**
- Task 1: **Association** (Teacher has a Laptop; both independent, link via setter)
- Task 2: **Aggregation** (Team has an array of Players; add players from outside)
- Task 3: **Composition** (Computer has a CPU; CPU created inside Computer)

---

### Task 1: Teacher and Laptop (Association)

**Scenario:**  
A `Teacher` has a name and may **have a** `Laptop`. The laptop can exist without the teacher (e.g., in a store). The teacher can have no laptop or can change laptop. This is **Association**: both objects exist independently; we just link them.

**Requirements (3 methods in total):**

1. **Class `Laptop`:**
   - Attribute: `brand` (String).
   - Constructor: `Laptop(String brand)`.
   - **Method 1:** `getBrand()` - returns the brand name.

2. **Class `Teacher`:**
   - Attributes: `name` (String), `laptop` (Laptop reference, can be `null`).
   - Constructor: `Teacher(String name)` - set `laptop = null`.
   - **Method 2:** `setLaptop(Laptop l)` - sets the teacher's laptop.
   - **Method 3:** `displayInfo()` - prints name and, if `laptop` is not null, prints "Laptop: " + laptop.getBrand(); otherwise prints "No laptop."

3. **In `Main`:**
   - Create a `Laptop` and a `Teacher` **separately**.
   - Call `teacher.setLaptop(laptop)` to link them (association).
   - Call `teacher.displayInfo()`. Then set `teacher.setLaptop(null)` and call `displayInfo()` again to show optional link.

---

### Task 2: Team and Player (Aggregation)

**Scenario:**  
A `Team` has a name and **has many** `Player`s. Players are created elsewhere and **added** to the team (e.g., signed from outside). If the team is dissolved, players still exist. This is **Aggregation**: whole-part, part can exist without whole. Use a **simple array** to store players and a counter for how many are added.

**Requirements (3 methods in total):**

1. **Class `Player`:**
   - Attribute: `name` (String).
   - Constructor: `Player(String name)`.
   - One getter `getName()` if you use it in display (or access via getter from Team's display method).

2. **Class `Team`:**
   - Attributes: `name` (String), `Player[] players` (simple array), `int count` (number of players added).
   - Constructor: `Team(String name, int maxPlayers)` - create the array: `players = new Player[maxPlayers]`, set `count = 0`.
   - **Method 1:** `addPlayer(Player p)` - if `count < players.length`, set `players[count] = p` and increment `count`.
   - **Method 2:** `getTeamName()` - returns the team name.
   - **Method 3:** `displayPlayers()` - loop from `0` to `count` and print each player's name.

3. **In `Main`:**
   - Create several `Player` objects.
   - Create one `Team` with a maximum size (e.g. 10).
   - Add players with `addPlayer(...)` (aggregation: parts added from outside).
   - Call `displayPlayers()` and `getTeamName()`.

---

### Task 3: Computer and CPU (Composition)

**Scenario:**  
A `Computer` has a brand and **has a** `CPU`. The CPU does not exist without the computer; it is **created inside** the Computer constructor. This is **Composition**: whole owns part; part is created by the whole.

**Requirements (3 methods in total):**

1. **Class `CPU`:**
   - Attribute: `model` (String), e.g. "Intel i5".
   - Constructor: `CPU(String model)`.
   - **Method 1:** `getModel()` - returns the CPU model.

2. **Class `Computer`:**
   - Attributes: `brand` (String), `cpu` (CPU).
   - Constructor: `Computer(String brand, String cpuModel)` - inside the constructor, create the CPU: `this.cpu = new CPU(cpuModel);` (composition: part created inside whole).
   - **Method 2:** `getComputerInfo()` - returns a string with brand and CPU model (use cpu.getModel()).
   - **Method 3:** `start()` - prints "Computer started with CPU: " + cpu.getModel() (or similar).

3. **In `Main`:**
   - Create a `Computer` by giving brand and CPU model (e.g. `new Computer("Dell", "Intel i5")`). Do **not** create a `CPU` in Main; the Computer creates it.
   - Call `getComputerInfo()` and `start()` to show that the CPU is inside the computer.

---

## Practice Tasks

These are **optional** and at **different difficulty levels** for extra practice.

**Easy (Association)**
- **Author and Book:** Class `Author` (name). Class `Book` (title, author reference). Author can exist without book; book can have an author. Methods: setAuthor, getAuthor, display (3 total).
- **Customer and Address:** Class `Address` (city). Class `Customer` (name, address reference). Customer may have an address (optional). Methods: setAddress, getAddress, displayInfo (3 total).

**Medium (Aggregation)**
- **Library and Book:** Class `Book` (title). Class `Library` (name, array of Book, count). Add books from outside; display library name and book list (3 methods in Library: addBook, getLibraryName, displayBooks). Use a simple array and a counter.
- **Band and Member:** Class `Member` (name). Class `Band` (name, array of Member, count). Add members from outside; display band name and members (3 methods in Band). Use a simple array and a counter.

**A bit harder (Composition)**
- **House and Room:** Class `Room` (name, area). Class `House` (address). House **creates** its rooms inside constructor or an addRoom that creates a Room. Rooms don't exist without the house. Methods: getAddress, addRoom (creating Room inside), getTotalArea (3 methods).
- **Wallet and Card:** Class `Card` (type, number). Class `Wallet` (owner). Wallet creates its card inside constructor (e.g. one primary card). Methods: getOwner, getCardInfo, open (3 total).

---

## Submission Guidelines

1. Complete all **3** progressive tasks (Task 1: Association, Task 2: Aggregation, Task 3: Composition).
2. Practice tasks are optional but recommended (try at least 1-2).
3. Each task should have separate files (e.g., `Teacher.java`, `Laptop.java`, `Main.java` for Task 1; you may use one `Main` class for all tasks or separate main classes per task).
4. Ensure code compiles and runs without errors.
5. Follow naming: PascalCase for classes, camelCase for methods and variables.
6. Submit as per your course instructions (e.g., one Word file or zipped project on eLearning).

---

## Notes

- **Association:** Both objects exist independently; link via setter or constructor parameter; can be null or changed.
- **Aggregation:** Whole has many parts (use a **simple array** and a **counter**); parts are created outside and **added** to the whole; parts can exist without the whole.
- **Composition:** Whole **creates** the part inside its constructor; part has no meaning without the whole.
- Each progressive task uses **at most 3 methods** (in total across the classes) to keep it beginner-friendly.
- Practice tasks are at **different levels** (easy, medium, a bit harder) for more practice.
- You do **not** use `extends` in this lab; these are "has-a" relationships, not "is-a."
