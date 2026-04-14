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

These are **optional** and use **different** names from the progressive tasks. Each practice uses **one interface with at least three methods** and **two concrete classes** that **`implement`** it. You will combine **arrays**, **`String` handling**, **`if`/`else`**, and **`for` loops**—still **one story per practice**, not a large project.

**If you are new to interfaces:** Read each **scenario** first (what would happen in real life). Then read **why each method exists**—the interface is a **to-do list** of behaviors the program agrees on. Finally, use the **hints** to plan your code **inside** `CarParking`, `BikeParking`, etc. The **interface** only declares **names and parameters**; **numbers** (rates, limits, zone lists) stay in **private fields** in each class.

**Tip:** Put **only** behavior names in the interface; keep **rates, thresholds, and allowed zones** as **private** fields in each class so you can change policy without changing the interface.

---

### Practice 1 — Parking kiosk (fees + loyalty + receipt text)

#### Scenario (beginner-friendly)

Imagine drivers leaving a parking garage. The computer does **not** care whether the vehicle is a **car** or a **motorbike** when it calls “print the bill”—it only cares that the object knows **how to compute money** and **how to format one line of text** for the printer. Cars might pay a **higher** formula (e.g. base fee + hourly rate); bikes might pay **only** a smaller hourly rate. Separately, the system may look at **past visit amounts** stored in an **array** (`double[]`) to decide a small **loyalty credit** (reward for frequent parkers). Your job is to express all of that through **one** type, **`Parkable`**, so the kiosk code never needs **`if (x instanceof CarParking)`**.

#### What you are practicing

- **Polymorphism:** Methods like `void printBill(Parkable p, ...)` work for **any** implementer.
- **Arrays and loops:** Summing or scanning `pastCharges`.
- **Strings:** Building a single-line receipt.

#### Problem to solve

Kiosk helpers must take **`Parkable`** only—**no** long `instanceof` chains on concrete types.

#### Interface `Parkable` — at least three methods

Declare an interface named **`Parkable`** with **at least** the three methods below (same signatures; you may add **constants** in the interface if you wish, but **not** instance fields).

##### 1) `double feeForHours(double hours)`

- **Purpose in the story:** Answers: “For **this** visit, how much does the driver owe **before** loyalty, given the **length of stay** in hours?” That is the **core parking charge** for that vehicle category.
- **Design hints:**  
  - If `hours <= 0`, return **`0.0`** (no stay, no fee).  
  - For partial hours, your class may use **`Math.ceil(hours)`** or another rule—**document** it in a comment.  
  - **Car** and **bike** should use **different** formulas (e.g. car: base + per hour; bike: per hour only). Store **constants** (rates) as **`private static final`** fields in each class.

##### 2) `double loyaltyCredit(double[] pastCharges)`

- **Purpose in the story:** Answers: “Given **previous** parking bills as a list of amounts, does this customer get a **credit** toward today?” The mall does **not** store loyalty inside the interface—it only says “pass an array of past charges and get back a **credit number**.”
- **Design hints:**  
  - Use a **`for`** loop over `pastCharges`. If the array is **`null`**, you can return **`0`** (document that choice).  
  - Ignore or treat **negative** entries as **0** (bad data)—say so in a comment.  
  - **Sum** the valid amounts. If the sum is **below** a **threshold**, credit is **`0`**. If at or above the threshold, compute a credit (e.g. a **percent** of the sum) and **cap** it at a maximum—**car** and **bike** should use **different** thresholds and/or caps so results differ for the same array.

##### 3) `String buildReceipt(String vehicleId, double hours)`

- **Purpose in the story:** Answers: “Print **one line** the gate can show: who parked, for how long, and what the **fee for this stay** is.” (You may include **loyalty** on the same line or not—if you split, document it; the lab only **requires** that **`vehicleId`**, **`hours`**, and the **fee** appear in a sensible way.)
- **Design hints:**  
  - Use **`+`** or **`StringBuilder`** to concatenate.  
  - Include a clear **prefix** so staff can see vehicle type at a glance, e.g. **`"CAR|"`** vs **`"BIKE|"`**, then **`vehicleId`**, **`hours`**, and **`feeForHours(hours)`**.  
  - Do **not** put car-only logic in the bike class’s receipt format—keep each class responsible for **its** format.

#### Classes

- **`CarParking`** and **`BikeParking`** both **`implements Parkable`**.

#### How you know it’s right

Same **`hours`** and same **`pastCharges`** produce **different** fees, credits, and receipt **strings** for car vs bike; methods you write for the kiosk only use the type **`Parkable`**, not concrete class names.

---

### Practice 2 — Library late fees (total + line items + annual cap)

#### Scenario (beginner-friendly)

When someone returns a **book** or **DVD** late, the desk software must compute **money**. Books often have **grace days** (first few late days are free); DVDs might start charging **immediately**. The **total** fine is not enough for staff—they also want a **list of lines** explaining **which** late days were charged (for receipts and disputes). Finally, the library may limit how much **new** fine can be added if the patron **already** paid a lot of fines **this year**. All of this should go through **one** interface type so the desk code stays simple.

#### What you are practicing

- **Total vs breakdown:** One number for billing, many **strings** for explanation.
- **Business rules:** Grace periods, per-day rates, and **annual caps** ( **`if`/`else`** ).
- **Arrays of strings:** Building `String[]` with a loop.

#### Problem to solve

Model **late return** so the same desk method can work with **`BookLoan`** or **`DvdLoan`** without special-casing types.

#### Interface `LateFeeRule` — at least three methods

##### 1) `double fineForDaysLate(int daysLate)`

- **Purpose in the story:** The **full** fine for this return, in currency, if we **ignore** the yearly cap for a moment (the cap is applied in another method).  
- **Design hints:**  
  - If `daysLate <= 0`, return **`0`**.  
  - **Book:** subtract **grace days** first; only **remaining** days × **per-day rate**.  
  - **DVD:** often **no** grace—each late day × rate.  
  - Keep **grace**, **rates**, and **caps** as **private constants** in each class.

##### 2) `String[] fineBreakdownLines(int daysLate)`

- **Purpose in the story:** A **receipt-style** list: one **string per chargeable day** (or one line per segment you define), so staff can print “Day 4: …, Day 5: …”. If **nothing** is chargeable (e.g. book returned within grace), return an **empty** array: **`new String[0]`**.
- **Design hints:**  
  - First figure out **how many** chargeable days you have (may differ from `daysLate` when grace exists).  
  - Allocate **`new String[count]`** and fill it in a **`for`** loop.  
  - Each string should be **human-readable** (include **day index** or **sequence** and **amount**).

##### 3) `double applyAnnualCap(double rawFine, double alreadyFinedThisYear)`

- **Purpose in the story:** The law or policy says: “This year, the patron has **already** been fined **`alreadyFinedThisYear`**. We still want to add **`rawFine`** for this item, but **not** above a **yearly maximum** for this **media type**.” So this method returns the **actual** fine chunk we are allowed to add **now** (possibly less than `rawFine`).
- **Design hints:**  
  - Compute **room** left: `annualCap - alreadyFinedThisYear` (your class picks **`annualCap`**; books vs DVDs may differ).  
  - If **room ≤ 0**, return **`0`**.  
  - Otherwise return **`Math.min(rawFine, room)`** (or equivalent logic).  
  - This is pure **policy** math—**no** loops required unless you prefer to structure it that way.

#### Classes

- **`BookLoan`** and **`DvdLoan`** both **`implements LateFeeRule`** with **different** grace, rates, and annual caps.

#### How you know it’s right

Same **`daysLate`** → **different** totals and **different** breakdown **lengths**; a large **`alreadyFinedThisYear`** **cuts** the result of **`applyAnnualCap`**.

---

### Practice 3 — Sensor batch (safe range + scan array + worst case)

#### Scenario (beginner-friendly)

Sensors measure **temperature** (°C) or **humidity** (%). Each device type has a **normal range** (e.g. room temperature 18–25 °C; humidity 30–60%). The **dashboard** sends **many** readings at once in a **`double[]`**. The program should report: (1) **how many** values are **out of range**, and (2) a **short message** about the **worst** reading—the one **farthest** outside the safe band—so operators know what to fix first.

#### What you are practicing

- **Encapsulation:** Min/max stored **privately** in each probe class.
- **Batch processing:** Loops over arrays.
- **Decision logic:** Safe vs unsafe; “worst” means **largest distance** outside `[min, max]`.

#### Problem to solve

Share one **`SafetyCheck`** type so the same dashboard code can talk to **temperature** or **humidity** probes without duplicating range logic in `Main`.

#### Interface `SafetyCheck` — at least three methods

##### 1) `boolean isSafe(double reading)`

- **Purpose in the story:** Quick check: “Is **this single** reading OK for **this** probe’s rules?”
- **Design hints:**  
  - Return **`true`** only if **`min <= reading <= max`** (inclusive).  
  - **`min`** and **`max`** are **fields** in the implementing class (set in the constructor), **not** in the interface.

##### 2) `int unsafeCount(double[] batch)`

- **Purpose in the story:** “Out of this **batch**, how many readings are **bad**?” Used for red badges / alarms in the UI.
- **Design hints:**  
  - If **`batch` is `null`** or **length 0**, return **`0`** (document).  
  - Loop with index or **for-each**; call **`isSafe`** or repeat the comparison—either is fine if consistent.  
  - **Count** only **unsafe** values.

##### 3) `String worstCaseSummary(double[] batch)`

- **Purpose in the story:** If everything is fine, say **`"OK"`**. If not, identify the **single worst** reading (largest **distance** outside the band: too cold/dry vs too hot/humid) and return a **short string** that includes the **numeric value** and whether it was **below min** or **above max**.
- **Design hints:**  
  - For each value, compute **distance outside** the band: **`0`** if safe, else distance to the nearest bound.  
  - Track which value has the **maximum** distance (tie-break: your rule—e.g. first wins—**document**).  
  - If **max distance is 0** (all safe), return **`"OK"`**.  
  - Otherwise return something like **`"worst=17.0 BELOW_MIN"`** (exact wording up to you).

#### Classes

- **`TemperatureProbe`** and **`HumidityProbe`** both **`implements SafetyCheck`** with **different** numeric ranges.

#### How you know it’s right

The **same number** (e.g. **22**) can be **safe** for temperature but **unsafe** for humidity; **`unsafeCount`** and **`worstCaseSummary`** change when ranges differ.

---

### Practice 4 — Facility access (id + QR + zone list)

#### Scenario (beginner-friendly)

People wear **badges** at a building. Security shows a **short ID** at the desk. Turnstiles read a **QR string** (machine-friendly). Some doors ask: “Does this person have access to **these** zones?” The request comes as a **list of zone codes** (`String[]`), e.g. **`"A"`**, **`"LAB"`**. **Staff** badges might allow **many** zones; **visitor** badges might allow **only** the lobby. The program should **count** how many of the **requested** zones are **actually allowed** for **this** badge—using **`String.equals`** to compare names, never **`==`**.

#### What you are practicing

- **Multiple behaviors on one object:** ID, QR payload, permission check.
- **Arrays of strings:** Allowed zones stored **privately**; request list passed in.
- **Correct string comparison:** **`a.equals(b)`** for **`String`** content.

#### Problem to solve

Two badge types share **`FacilityBadge`** so gate software can treat them the same where possible.

#### Interface `FacilityBadge` — at least three methods

##### 1) `String displayId()`

- **Purpose in the story:** What a human reads at the security desk (e.g. employee number or visitor number).
- **Design hints:**  
  - Return a **`String`** stored in a **private field**, set in the **constructor**.

##### 2) `String turnstilePayload()`

- **Purpose in the story:** What the **QR encoder** puts on the badge—often a **compact** string (prefix + id + role flag). Turnstiles only need this, not the full object.
- **Design hints:**  
  - Build from **`displayId()`** and fixed text, e.g. **`"QR:" + displayId() + ":STAFF"`** vs **`"...:VIS"`** so staff and visitor payloads **differ**.

##### 3) `int countGrantedAccess(String[] zonesRequested)`

- **Purpose in the story:** The visitor selects or the system sends **several** zone codes they want to enter. Return **how many** of those codes are **on the allowed list** for this badge (duplicates in the request: either count each occurrence or count unique—**pick one** and **document**).
- **Design hints:**  
  - If **`zonesRequested` is `null`** or **length 0**, return **`0`**.  
  - For each **non-null** entry in `zonesRequested`, check whether it **matches** any entry in a **private `String[] allowedZones`** using **nested loops** or a helper method **`boolean isAllowed(String z)`**.  
  - Use **`zone.equals(allowed[i])`**, not **`==`**.

#### Classes

- **`StaffBadge`** and **`VisitorBadge`** both **`implements FacilityBadge`** with **different** **`allowedZones`** arrays.

#### How you know it’s right

Same **`zonesRequested`** array yields **different** **counts** for staff vs visitor; **`turnstilePayload()`** differs per role.

---

### Practice 5 — Design reflection (no new code required)

#### Scenario (beginner-friendly)

In **Lab 11** you might use an **`abstract`** class **`Shape`** with **`getArea()`** and **shared fields** (like color). In **this lab’s progressive Task 1**, **`Measurable`** is an **interface** with **`area()`** and **`Rectangle`** **implements** it. Both ideas solve “something has an area,” but they fit **different** designs.

#### Problem to solve

In **3–5 sentences**, explain:

- When you would keep **`Measurable`** as an **interface** for types that are **not** all in one family (e.g. a rectangle, a piece of land, a floor tile), and  
- When you would prefer an **`abstract`** **`Shape`** **class** for many kinds of **shapes** that **share** fields or helper code.

Name **one** advantage of **interfaces** (e.g. **multiple roles**, unrelated classes) and **one** advantage of **abstract classes** (e.g. **shared state**, **constructors**).

#### How you know it’s right

Your answer mentions **shared state / constructors** vs **unrelated classes**, and **multiple** **`implements`** where relevant.

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
