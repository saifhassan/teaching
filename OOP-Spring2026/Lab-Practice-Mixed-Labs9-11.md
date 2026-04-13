# Mixed Practice: Labs 9–11 Topics

## Table of Contents
1. [Introduction](#introduction)
2. [How to use this sheet](#how-to-use-this-sheet)
3. [Practice Task 1 — Inheritance (one parent, one child)](#practice-task-1--inheritance-one-parent-one-child)
4. [Practice Task 2 — One parent, two children](#practice-task-2--one-parent-two-children)
5. [Practice Task 3 — Abstract class and concrete subclass](#practice-task-3--abstract-class-and-concrete-subclass)
6. [Practice Task 4 — Inheritance with business rules](#practice-task-4--inheritance-with-business-rules)
7. [Practice Task 5 — Three-level hierarchy](#practice-task-5--three-level-hierarchy)
8. [Practice Task 6 — Abstract + two concrete kinds](#practice-task-6--abstract--two-concrete-kinds)
9. [Submission (if assigned)](#submission-if-assigned)

---

## Introduction

These tasks **review and mix** material from:

- **Lab 9:** `extends`, `super()`, **method overriding**, `super.method()`, `@Override` (one superclass, **one** subclass).
- **Lab 10:** One superclass with **two** subclasses, **or** a **chain** of three levels (`A → B → C`).
- **Lab 11:** **`abstract`** classes, **`abstract`** methods, concrete subclasses that **implement** every abstract method.

Each task below is **independent** (different class names from the official labs) but uses the **same level of detail** as the progressive tasks in Labs 9–11: scenario, numbered requirements, and what **`Main`** should demonstrate.

**Suggested pace:** complete **at least five** tasks of your choice; Task 6 is optional stretch (abstract + two subclasses).

---

## How to use this sheet

| Tag | Meaning |
|-----|---------|
| **L9** | Lab 9 style — two classes, inheritance, overrides. |
| **L10** | Lab 10 style — triangle (one parent, two children) **or** three-level chain. |
| **L11** | Lab 11 style — abstract superclass, concrete subclass(es). |

Use **one `Main` class** per task (or one `Main` with clearly separated sections and comments) so output is easy to grade.

---

## Practice Task 1 — Inheritance (one parent, one child)

**Topics:** **L9** (concrete superclass, single subclass).

**Scenario:**  
A library catalogs **items**. Every item has a **title** and a **catalog id**. A **borrowable book** is an item that also has a **loan period in days**. The superclass provides a default “availability” message; the subclass **overrides** it to reflect borrowing rules and adds a method to compute the **due day offset** from a given start day (simple integer math).

**Requirements:**

1. **Class `LibraryItem`:**
   - Private fields: `title` (String), `catalogId` (String).
   - Constructor: `LibraryItem(String title, String catalogId)`.
   - Getters: `getTitle()`, `getCatalogId()`.
   - Method `availabilityNote()` that returns a `String`, e.g. `"See front desk for details."` (default for generic items).
   - Method `summaryLine()` that prints one line: catalog id and title (e.g. `"[B-12] Intro to Java"`).

2. **Class `BorrowableBook` extends `LibraryItem`:**
   - Private field: `loanDays` (int) — number of days the book may be borrowed.
   - Constructor: `BorrowableBook(String title, String catalogId, int loanDays)` — first line **`super(title, catalogId);`**, then assign `loanDays`.
   - Getter: `getLoanDays()`.
   - **Override** `availabilityNote()` to return a string that **includes** loan days, e.g. `"Borrow up to " + loanDays + " days."` Use **`@Override`**.
   - Method `dueDayNumber(int startDay)` returning `startDay + loanDays` (assume `startDay` is a day-of-month or simple counter; document in a comment).

3. **In `Main`:**
   - Create `BorrowableBook b = new BorrowableBook("OOP Guide", "B-99", 14);`
   - Call `summaryLine()`, print `availabilityNote()`, print `dueDayNumber(5)` — expect **19** for start day 5 and loan 14.

---

## Practice Task 2 — One parent, two children

**Topics:** **L10** (one superclass, two subclasses, same method name, different behavior).

**Scenario:**  
A gym sells **memberships**. Every membership has a **member name** and a **plan code**. The gym charges **different monthly fees** for **students** vs **professionals**, but both are still **memberships**. The superclass defines a default **monthly fee** and a **`display()`** method; each subclass **overrides** `monthlyFee()`.

**Requirements:**

1. **Class `Membership`:**
   - Private fields: `memberName` (String), `planCode` (String).
   - Constructor: `Membership(String memberName, String planCode)`.
   - Method `display()` that prints member name and plan code.
   - Method `monthlyFee()` returning **double** — default e.g. **1500.0** (generic “walk-in” monthly fee; document).

2. **Class `StudentMembership` extends `Membership`:**
   - Constructor: `StudentMembership(String memberName, String planCode)` with **`super(memberName, planCode);`** first.
   - **Override** `monthlyFee()` to return a **lower** fee than the parent default (e.g. **600.0**). Use **`@Override`**.

3. **Class `ProfessionalMembership` extends `Membership`:**
   - Constructor: `ProfessionalMembership(String memberName, String planCode)` with **`super(...)`** first.
   - **Override** `monthlyFee()` to return a **higher** fee than student and **≥** parent default (e.g. **2500.0**).

4. **In `Main`:**
   - Use the **same** `memberName` and `planCode` for all three objects (e.g. `"Sara"`, `"GYM-1"`).
   - Create one `Membership`, one `StudentMembership`, one `ProfessionalMembership`.
   - For each, call `display()` and print `monthlyFee()`. Show **student < default ≤ professional** (adjust numbers so the ordering is clear).

---

## Practice Task 3 — Abstract class and concrete subclass

**Topics:** **L11** (abstract method, cannot instantiate parent).

**Scenario:**  
A budgeting app tracks **expenses**. Every expense has a **label** and a **budget limit** for the month. The **exact amount spent so far** depends on the **kind** of expense (e.g. **subscription** with a fixed monthly charge). The **general** “expense” should not invent a fake “spent so far”; only **concrete** types implement the rule. Model **`Expense`** as **abstract** with **`abstract double spentSoFar();`**. Implement **`SubscriptionExpense`**.

**Requirements:**

1. **Abstract class `Expense`:**
   - Private fields: `label` (String), `monthlyBudget` (double).
   - Constructor: `Expense(String label, double monthlyBudget)`.
   - Getters: `getLabel()`, `getMonthlyBudget()`.
   - **Abstract method:** `public abstract double spentSoFar();`
   - **Concrete method:** `void printStatus()` that prints label, budget, and **remaining** as `monthlyBudget - spentSoFar()` (if negative, you may print negative or clamp to 0 — document your choice).

2. **Concrete class `SubscriptionExpense` extends `Expense`:**
   - Private field: `monthlyCharge` (double) — what the subscription charges each month.
   - Constructor: `SubscriptionExpense(String label, double monthlyBudget, double monthlyCharge)` — **`super(label, monthlyBudget);`** first.
   - **Implement** `spentSoFar()` to return **`monthlyCharge`** (assume full charge counts as “spent” this month). Use **`@Override`**.

3. **In `Main`:**
   - Add a **comment** that `new Expense(...)` would **not compile** if `Expense` is abstract.
   - Create `SubscriptionExpense s = new SubscriptionExpense("Music", 500, 299);`
   - Call `printStatus()` — spent should show **299**, remaining **201** (if you use simple subtraction without clamping).

---

## Practice Task 4 — Inheritance with business rules

**Topics:** **L9** (single subclass, **`super.method()`** in override).

**Scenario:**  
An online store lists **products**. Each product has a **name** and **base price**. A **seasonal product** applies a **seasonal discount percent** on top of the base price for **`displayPrice()`** output, but **`getBasePrice()`** in the parent should still expose the undiscounted base. The subclass **overrides** a **`priceForCustomer()`** method: it uses **`super`** to reuse parent logic where needed and applies the discount.

**Requirements:**

1. **Class `StoreProduct`:**
   - Private fields: `name` (String), `basePrice` (double).
   - Constructor: `StoreProduct(String name, double basePrice)`.
   - `double getBasePrice()` returns `basePrice`.
   - `String getName()` returns `name`.
   - `double priceForCustomer()` returns **`getBasePrice()`** (no discount in the parent).

2. **Class `SeasonalProduct` extends `StoreProduct`:**
   - Private field: `discountPercent` (double) — e.g. **20** means 20% off.
   - Constructor: `SeasonalProduct(String name, double basePrice, double discountPercent)` — **`super(name, basePrice);`** first.
   - **Override** `priceForCustomer()` to return `super.priceForCustomer() * (100 - discountPercent) / 100` (or equivalent). Use **`@Override`**.
   - Method `void printTag()` that prints product **name**, **base** price (`getBasePrice()`), and **customer** price (`priceForCustomer()`).

3. **In `Main`:**
   - Create `SeasonalProduct p = new SeasonalProduct("Jacket", 5000, 25);`
   - Call `printTag()` — customer price should be **3750.0**.

---

## Practice Task 5 — Three-level hierarchy

**Topics:** **L10** (chain `A → B → C`), **`super()`** and **`super.method()`** at each level.

**Scenario:**  
A simple user system: every **user** has a **username**. A **verified user** adds an **email** and can **display** verification status. A **premium user** is a **verified user** who also has **extra storage GB**; monthly **quota** for uploads is computed differently at each level (generic → verified → premium).

**Requirements:**

1. **Class `User`:**
   - Private field: `username` (String).
   - Constructor: `User(String username)`.
   - Getter: `getUsername()`.
   - `void display()` prints username.
   - `int monthlyUploadQuotaMb()` returns a base quota, e.g. **500** (MB).

2. **Class `VerifiedUser` extends `User`:**
   - Private field: `email` (String).
   - Constructor: `VerifiedUser(String username, String email)` — **`super(username);`** first.
   - **Override** `display()` — call **`super.display();`**, then print email.
   - **Override** `monthlyUploadQuotaMb()` to return **2000** (higher than base).

3. **Class `PremiumUser` extends `VerifiedUser`:**
   - Private field: `extraStorageGb` (int).
   - Constructor: `PremiumUser(String username, String email, int extraStorageGb)` — **`super(username, email);`** first.
   - **Override** `display()` — call **`super.display();`**, then print extra storage.
   - **Override** `monthlyUploadQuotaMb()` to return **`super.monthlyUploadQuotaMb() + extraStorageGb * 500`** (example: each extra GB adds 500 MB to quota — document).

4. **In `Main`:**
   - Create one `User`, one `VerifiedUser`, one `PremiumUser` (e.g. premium with `extraStorageGb = 2`).
   - Call `display()` on each and print `monthlyUploadQuotaMb()` — show **increasing** quota along the chain.

---

## Practice Task 6 — Abstract + two concrete kinds

**Topics:** **L11** + **L10** pattern (abstract parent, **two** concrete subclasses).

**Scenario:**  
Notifications in an app must **render text** for the lock screen, but **email notifications** and **SMS notifications** format differently. Declare **`abstract class Notification`** with **`abstract String render();`**. Implement **`EmailNotification`** (includes subject line) and **`SmsNotification`** (truncates body length).

**Requirements:**

1. **Abstract class `Notification`:**
   - Private fields: `id` (String), `body` (String).
   - Constructor: `Notification(String id, String body)`.
   - Getters: `getId()`, `getBody()`.
   - **Abstract:** `public abstract String render();`
   - **Concrete:** `void preview()` prints `render()` to the console.

2. **Class `EmailNotification` extends `Notification`:**
   - Private field: `subject` (String).
   - Constructor: `EmailNotification(String id, String body, String subject)` — **`super(id, body);`**
   - **Implement** `render()` to return a single string including **subject** and **body**, e.g. `"Subject: ... | Body: ..."`.

3. **Class `SmsNotification` extends `Notification`:**
   - Private field: `maxLen` (int) — maximum characters for SMS.
   - Constructor: `SmsNotification(String id, String body, int maxLen)` — **`super(id, body);`**
   - **Implement** `render()` to return **`getBody()`** truncated to **`maxLen`** characters (if shorter, return full body; use `String` methods or manual logic — document).

4. **In `Main`:**
   - Create one `EmailNotification` and one `SmsNotification` with a long body; show that SMS output is **truncated**.
   - **Comment:** `new Notification(...)` is illegal if the class is abstract.

---

## Submission (if assigned)

1. Complete **at least five** practice tasks above (your choice), each compiling and with a small **`Main`** demo.
2. In a short note or report section, for **one** abstract task (Task 3 or 6), explain in **2–3 sentences** why the superclass is **abstract** instead of a concrete class with default `spentSoFar()` / `render()`.
3. Submit per course instructions (zip of `.java` files or pasted code in Word/PDF).

---

## Notes

- **Lab 9–10** tasks use **concrete** superclasses unless stated otherwise; **Lab 11** tasks use **`abstract`** where the handout says so.
- Prefer **`@Override`** on every overridden or implemented abstract method.
- **First line** of every subclass constructor: **`super(...)`** with the correct arguments.
