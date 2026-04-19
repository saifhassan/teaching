# Lab 13: Polymorphism, `Object` Methods, and Exception Handling

## Table of Contents
1. [Introduction](#introduction)
2. [Topic Explanations](#topic-explanations)
3. [SampleCode](#samplecode) — pre-lab demos (with expected output)
4. [Progressive Tasks](#progressive-tasks)
5. [Practice Tasks](#practice-tasks)
6. [Submission Guidelines](#submission-guidelines)

---

## Introduction

In **Labs 9–12** you used **inheritance**, **abstract** classes, and **interfaces**. The **same method call** can run **different code** depending on the **actual object**—that idea is **polymorphism**. In **Lab 12** you also stored objects in variables whose **declared type** was an **interface** (e.g. `Measurable m = new Rectangle(...)`). This lab makes that pattern explicit and adds two practical tools every Java class shares: methods inherited from **`Object`**, especially **`toString`** and **`equals`**.

Programs also need to handle **mistakes** and **invalid data**: bad user input, impossible operations (e.g. withdrawing more money than the balance). **Exceptions** let a method **signal failure** without returning a fake “error number” for every case. This lab **combines** **polymorphism / `Object` methods** with **exception handling** so you can build classes that are **clear** (readable strings, sensible equality) and **safe** (validation and explicit errors).

**Objectives:**

- Use **supertype references** (`Object`, or your own superclass/interface) and recall **dynamic method dispatch**.
- **`Override`** **`toString()`** and **`equals(Object o)`** with correct signatures and a safe **`instanceof`** (or **`getClass()`**) check.
- Use **`try`**, **`catch`**, and optionally **`finally`** to handle **exceptions**.
- Distinguish **unchecked** exceptions (e.g. **`IllegalArgumentException`**, **`NumberFormatException`**) from **checked** exceptions that require a **`throws`** clause.
- Declare a **custom** exception class and **`throw`** it from a method; **catch** it in **`Main`** (or another caller).

**Prerequisites:**

- Lab 12 (interfaces, `implements`, `@Override`).
- Lab 9 (inheritance and overriding).

---

## Topic Explanations

### 1. Polymorphism (recap)

**What is it?**  
A **reference** (variable) has a **declared type** (e.g. `Measurable`, `Animal`, `Object`). The **object** it points to has an **actual** class (e.g. `Rectangle`, `Dog`). Calling a method on the reference runs the **implementation** belonging to the **actual object**—that is **dynamic dispatch**.

**Why it matters:** You write code that depends on the **declared** type (interface or superclass) and still get **correct** behavior for each **concrete** class.

---

### 2. Every class extends `Object`

In Java, if you write `public class StudentCard { }`, the compiler treats it like **`extends Object`**. So every instance **is an** **`Object`**. Methods like **`toString()`** and **`equals(Object o)`** exist on **every** object unless you **replace** them with your own versions.

---

### 3. Overriding `toString()`

**Default behavior:** `Object`’s `toString()` returns something like `ClassName@hashcode`—not friendly for users.

**What you do:** **`@Override public String toString() { ... }`** and return a short, readable description (name, id, key fields).

**Side effect:** **`System.out.println(obj)`** calls **`String.valueOf(obj)`**, which uses **`obj.toString()`**—so a good `toString()` makes **debugging** and **logs** clearer.

---

### 4. Overriding `equals(Object o)`

**Default behavior:** `Object.equals` behaves like **`==`**—**reference** equality (same object in memory?).

**What you often want:** **Logical** equality—e.g. two **`StudentCard`** objects with the **same student id** are “equal” even if they are **two different** objects.

**Signature (must match exactly):**  
`@Override public boolean equals(Object o)`

**Typical steps (beginner pattern):**

1. If **`o == this`**, return **`true`**.
2. If **`o == null`**, return **`false`**.
3. If **`!(o instanceof StudentCard)`** (replace with your class name), return **`false`**.
4. Cast: **`StudentCard other = (StudentCard) o;`**
5. Compare **fields** (e.g. **`studentId.equals(other.studentId)`** for `String`s).

**Note:** Advanced courses also teach **`hashCode()`** consistency with `equals` (for **hash** collections). For this lab, **`equals` + `toString`** are enough; treat **`hashCode`** as optional reading.

---

### 5. What is an exception?

An **exception** is an **object** (a kind of error report) that **interrupts** normal flow. Code that detects a problem can **`throw`** it; code that can **recover** or **report** uses **`try` / `catch`**.

```java
try {
    // risky code
} catch (SomeException e) {
    // handle: print, return, etc.
} finally {
    // optional: runs after try/catch (cleanup)
}
```

---

### 6. Unchecked vs checked

| Kind | Examples | Must you declare `throws`? |
|------|-----------|----------------------------|
| **Unchecked** | `IllegalArgumentException`, `NumberFormatException`, most `RuntimeException` | No—but you may **document** in comments |
| **Checked** | `IOException`, **`Exception`** subclasses you define as **checked** | **Yes** on the method, or handle inside |

**Custom class:**  
`public class InsufficientFundsException extends Exception { ... }` is usually **checked**—callers must **`catch`** or **`throws`**.

---

### 7. `throw`, `throws`, and validation

- **`throw new IllegalArgumentException("message");`** stops the method and signals invalid input.
- Method signature: **`void withdraw(double amount) throws InsufficientFundsException`** tells the compiler that **callers** must deal with that exception.

---

## SampleCode

These snippets are for **lecture or self-study before** the progressive tasks. Names like **`DemoBook`** / **`PreviewCard`** are **examples only**—your lab submission will use the classes required in each task (`StudentCard`, `AmountParser`, `BankAccount`, etc.).

You can paste samples into one `SampleDemo.java` (with one `main`) or split into small files; add **`package`** if your course uses packages.

**Java file rule:** Only **one** `public` top-level class per `.java` file. To combine samples in one file, use **`public class SampleDemo`** for `main` and omit **`public`** on **`DemoBook`**, **`DemoCard`**, etc. (package-private classes in the same file), **or** put each class in its own file with matching names.

**Order:** **Sample 4** shows **`try`/`catch`** when a standard library call fails—**no `throw`** written by you yet. **Sample 5** adds **`finally`**. **Samples 6–7** add **`throw`** and rethrow; the **progressive tasks** still include a **custom** checked exception (`InsufficientFundsException`) where the course requires it.

---

### Sample 1 — `Object` reference, subclass `toString()`

**Idea:** A variable of type **`Object`** can refer to **any** instance. **`println`** still calls the **actual** class’s **`toString()`** (no AWT or external GUI libraries).

```java
class DemoBook {
    private final String title;

    DemoBook(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "DemoBook[" + title + "]";
    }
}

// In main:
Object ref = new DemoBook("OOP Guide");
System.out.println(ref);
```

**Expected output:**

```text
DemoBook[OOP Guide]
```

---

### Sample 2 — `toString()` only (simple card)

```java
class DemoCard {
    private final String id;

    DemoCard(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DemoCard[id=" + id + "]";
    }
}

// In main:
System.out.println(new DemoCard("A-12"));
```

**Expected output:**

```text
DemoCard[id=A-12]
```

---

### Sample 3 — `equals(Object o)` pattern

```java
class PreviewCard {
    private final String cardId;

    PreviewCard(String cardId) {
        this.cardId = cardId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PreviewCard other = (PreviewCard) o;
        return cardId.equals(other.cardId);
    }
}

// In main:
PreviewCard x = new PreviewCard("X1");
PreviewCard y = new PreviewCard("X1");
PreviewCard z = new PreviewCard("Z9");
System.out.println(x.equals(y));
System.out.println(x.equals(z));
```

**Expected output:**

```text
true
false
```

---

### Sample 4 — `try` / `catch` only (library throws, you catch)

**Idea:** Methods like **`Integer.parseInt(String)`** may **throw** a **`NumberFormatException`** if the string is not a valid integer. You do **not** write `throw` yourself here—you only **`try`** the call and **`catch`** the exception to react (print a message, use a default, etc.).

```java
// In main:
String input = "not_a_number";
try {
    int n = Integer.parseInt(input);
    System.out.println("Parsed: " + n);
} catch (NumberFormatException e) {
    System.out.println("Could not parse an integer from: " + input);
}
```

**Expected output:**

```text
Could not parse an integer from: not_a_number
```

**Optional:** After you understand **`catch`**, print **`e.getMessage()`** in the **`catch`** block to see the JVM’s default detail.

---

### Sample 5 — `finally` (always runs when leaving `try`–`catch`)

**Idea:** The **`finally`** block holds code that should run **whether the `try` succeeded**, **whether a `catch` ran**, or **whether an exception was thrown** (as long as execution stays inside this thread and the JVM does not exit). Use it for **cleanup** (e.g. closing a resource—advanced courses often use **try-with-resources** instead for files).

**When `finally` is executed (typical cases):**

1. After **`try`** completes **normally** (no exception)—then **`finally`**, then code after the whole statement.
2. After an exception is **caught** by **`catch`**—**`catch`** runs, then **`finally`**, then code after.
3. If **`try`** throws something **not** caught here, **`finally`** still runs **before** the exception propagates upward.
4. If **`try`** (or **`catch`**) uses **`return`**, **`finally`** still runs **before** that **`return`** actually completes (important detail for exams).

```java
// In main:
System.out.println("--- case A: parse fails ---");
try {
    Integer.parseInt("bad");
} catch (NumberFormatException e) {
    System.out.println("in catch");
} finally {
    System.out.println("in finally");
}

System.out.println("--- case B: parse succeeds ---");
try {
    int x = Integer.parseInt("7");
    System.out.println("parsed " + x);
} catch (NumberFormatException e) {
    System.out.println("in catch");
} finally {
    System.out.println("in finally");
}
```

**Expected output:**

```text
--- case A: parse fails ---
in catch
in finally
--- case B: parse succeeds ---
parsed 7
in finally
```

*(In case B there is no exception, so **`catch`** is skipped—but **`finally` still runs**.)*

---

### Sample 6 — `IllegalArgumentException` (validation with `throw`)

```java
class AgeRules {
    static void setAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Invalid age: " + age);
        }
    }
}

// In main:
try {
    AgeRules.setAge(-3);
} catch (IllegalArgumentException e) {
    System.out.println(e.getMessage());
}
```

**Expected output:**

```text
Invalid age: -3
```

---

### Sample 7 — `Integer.parseInt` with `try` / `catch` and `throw` (rethrow)

```java
class ParseDemo {
    static int parsePositiveInt(String text) {
        try {
            int n = Integer.parseInt(text.trim());
            if (n <= 0) {
                throw new IllegalArgumentException("must be positive");
            }
            return n;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("not an integer: " + text, ex);
        }
    }
}

// In main:
System.out.println(ParseDemo.parsePositiveInt("  42  "));
try {
    ParseDemo.parsePositiveInt("oops");
} catch (IllegalArgumentException e) {
    System.out.println(e.getMessage());
}
```

**Expected output:**

```text
42
not an integer: oops
```

---

## Progressive Tasks

**Important:** There are **3 progressive tasks**. Each task has a **core** part (minimum to pass) and **problem-solving extensions** (loops, decisions, combined APIs)—complete **both** for full credit if your instructor uses the extended rubric.

Create a **`Main`** class to demonstrate **core + extensions** for each task (clearly **comment** which demo belongs to which task).

**Topics covered:**

- Task 1: **`StudentCard`** — **`toString()`**, **`equals(Object o)`**, polymorphic `println`, plus **search / prefix** logic
- Task 2: **`AmountParser`** — parsing, **`try`/`catch`**, plus **batch** parsing and **error counting**
- Task 3: **`BankAccount`** + **`InsufficientFundsException`** — **checked** exception, **`withdraw`**, plus **`transferTo`** between accounts

---

### Task 1: `StudentCard` — `toString`, `equals`, and roster logic

**Scenario:**  
A campus **ID card** is identified by a **student id** (String, unique) and a **full name**. Printing a card should show something **readable**, not `StudentCard@1a2b3c`. Later, a **roster** (array of cards) must be **searched** and **filtered** by id prefix—typical **problem-solving** on arrays + **`String`** methods.

#### Core requirements

1. **Class `StudentCard`:**
   - Private fields: `studentId` (String), `fullName` (String).
   - Constructor: `StudentCard(String studentId, String fullName)` — if `studentId` is **`null`** or **empty** after **`trim`**, throw **`new IllegalArgumentException(...)`** with a short message.
   - **`@Override public String toString()`** — one line including **student id** and **full name** (e.g. `"StudentCard[id=S123, name=Ali Khan]"`).
   - **`@Override public boolean equals(Object o)`** — **`instanceof`** (or **`getClass()`**) pattern; equality **by `studentId` only** (document that **two** cards with same id but different **`fullName`** are still **equal** under this rule, or state if you require both fields—**one rule only**).

2. **Polymorphism in `Main` (core):**
   - Create two cards with the **same** `studentId` and different names; print **`equals`** result.
   - **`Object ref = new StudentCard(...);`** **`System.out.println(ref);`** — must use **your** `toString()`.

#### Problem-solving extensions (complete all)

3. **Instance method — prefix check:**  
   - **`public boolean studentIdStartsWith(String prefix)`**  
   - Return **`true`** iff **`studentId`** starts with **`prefix`**, treating **`null`** prefix as **not** starting (return **`false`**) or throw **`IllegalArgumentException`**—**document** your choice. Use **`String`** API (e.g. **`startsWith`**) or a careful loop.

4. **Static search — loop + `equals`:**  
   - **`public static StudentCard findByStudentId(StudentCard[] roster, String id)`**  
   - Return the **first** card in **`roster`** whose **`studentId`** **equals** **`id`** (`String.equals`), or **`null`** if none found or if **`roster`** is **`null`** (document: empty array returns **`null`**).

5. **In `Main` (extensions):**  
   - Build a **`StudentCard[]`** of at least **3** entries (include one id **`"S010"`**).  
   - Call **`findByStudentId`** for **`"S010"`** and print the result (or **`null`**).  
   - Pick one card and print **`studentIdStartsWith("S0")`**.

---

### Task 2: `AmountParser` — parsing, batches, and failure counting

**Scenario:**  
A form sends **amounts as text**. You **parse** and **reject** invalid or **negative** values. Real systems also process **many** fields at once: **sum** valid lines, or **count** how many lines fail without stopping the whole program.

#### Core requirements

1. **Class `AmountParser`** (methods may be **`static`**):
   - **`public static double parseNonNegativeAmount(String text)`**
     - **`trim`**; if **empty**, throw **`IllegalArgumentException("empty input")`** (or similar).
     - **`Double.parseDouble`** inside **`try`**; **`catch (NumberFormatException ex)`** → throw **`new IllegalArgumentException("not a number: " + text, ex)`** (cause optional).
     - If parsed value **&lt; 0**, throw **`IllegalArgumentException("negative not allowed")`**.
     - Return the **`double`** if valid.

2. **In `Main` (core):**  
   - **`"120.5"`** → print **120.5**.  
   - **`"abc"`** in **`try`/`catch`** → print **`getMessage()`**.  
   - **`"-5"`** → rejected (catch or message).

#### Problem-solving extensions (complete all)

3. **Strict batch sum:**  
   - **`public static double sumNonNegativeAmounts(String[] lines)`**  
   - **Loop** over **`lines`**. For **each** element, call **`parseNonNegativeAmount`**. If **any** call throws, **rethrow** or wrap in **`IllegalArgumentException`** that includes the **array index** of the bad line (e.g. `"bad amount at index 2: ..."`).  
   - If **`lines`** is **`null`**, throw **`IllegalArgumentException`** or return **0.0**—**document**.

4. **Soft failure count (no throw from helper):**  
   - **`public static int countInvalidAmountLines(String[] lines)`**  
   - Return how many entries **would** fail **`parseNonNegativeAmount`** (catch **inside** the method per line, **do not** abort the whole loop on first failure). Treat **`null`** array as **0** invalid lines (document).

5. **In `Main` (extensions):**  
   - Call **`sumNonNegativeAmounts`** with **`{ "10", "20.5", "30" }`** — print sum **60.5**.  
   - Call **`countInvalidAmountLines`** with **`{ "1", "x", "-2", "3" }`** — expect **2** invalid (`"x"` and `"-2"`).

---

### Task 3: `BankAccount`, `InsufficientFundsException`, and transfers

**Scenario:**  
An account has a **balance**. **Withdraw** uses a **custom checked exception** when funds are insufficient. **Transfers** between accounts are a common **logic** exercise: move money only if the source can **withdraw** it, then **deposit** on the target.

#### Core requirements

1. **Class `InsufficientFundsException`** — **`extends Exception`**, constructor **`super(message)`**.

2. **Class `BankAccount`:**
   - **`BankAccount(double initialBalance)`** — **`initialBalance < 0`** → **`IllegalArgumentException`**.
   - **`deposit(double amount)`** — **`amount <= 0`** → **`IllegalArgumentException`**.
   - **`withdraw(double amount) throws InsufficientFundsException`** — **`amount <= 0`** → **`IllegalArgumentException`**; **`amount > balance`** → **`InsufficientFundsException`**; else subtract.
   - **`getBalance()`**, **`@Override toString()`**.

3. **In `Main` (core):**  
   - **`try`/`catch`** on **failed** withdraw; **successful** withdraw and print balance.

#### Problem-solving extensions (complete all)

4. **Transfer method:**  
   - **`public void transferTo(BankAccount other, double amount) throws InsufficientFundsException`**  
   - **`null`** **`other`** → **`IllegalArgumentException`**.  
   - **`amount <= 0`** → **`IllegalArgumentException`**.  
   - **Otherwise:** perform **`withdraw(amount)`** on **`this`**, then **`deposit(amount)`** on **`other`**. (If **`withdraw`** throws, **no** deposit happens—**do not** partially transfer.)

5. **Comparison helper:**  
   - **`public static BankAccount accountWithHigherBalance(BankAccount x, BankAccount y)`**  
   - Return **`x`** if **`x.getBalance() > y.getBalance()`**, else **`y`** if **`y`** is higher; if **equal**, return **`x`** (document tie-break).

6. **In `Main` (extensions):**  
   - Create **two** accounts; **deposit** different amounts.  
   - **`transferTo`** from richer to poorer so both balances change; **`println`** both **`toString()`** results.  
   - Call **`accountWithHigherBalance`** and print which account has the larger balance.

---

## Practice Tasks

These are **optional** but **strongly recommended** for exam-style **logic** and **problem solving**. They use **different** class names from the progressive tasks.

---

### Practice A — `ISBNBook` and catalog equality

**Scenario:**  
A small shop tracks books by **ISBN** (unique) and **title**. Two book objects with the **same ISBN** are the **same book** for inventory, even if the title string differs slightly.

**Requirements:**

1. Class **`ISBNBook`**: private **`isbn`**, **`title`**; constructor validates **non-empty** trimmed ISBN (**`IllegalArgumentException`**).
2. **`@Override equals(Object o)`** — equality **by ISBN only** (normalize: trim ISBN).
3. **`@Override toString()`**.
4. **`public static ISBNBook findFirstDuplicateByIsbn(ISBNBook[] shelf)`** — return the **second** book that matches an earlier ISBN, or **`null`** if no duplicate exists (**O(n²)** loop is acceptable for beginners).

**Check:** Duplicate ISBNs return **non-null**; unique shelf returns **`null`**.

---

### Practice B — `SafeIntParser` and capped range

**Scenario:**  
Parse integers from text, but only accept values in **[min, max]** inclusive.

**Requirements:**

1. **`public static int parseIntInRange(String text, int min, int max)`** — use **`Integer.parseInt`** in **`try`/`catch`**. On **`NumberFormatException`**, throw **`IllegalArgumentException`** with message **`"not int: " + text`**. After parse, if **&lt; min** or **&gt; max**, throw **`IllegalArgumentException`** with a message that includes **min** and **max**.
2. **`public static int sumRangeBoundedInts(String[] parts, int min, int max)`** — sum results of **`parseIntInRange`** for each part; if **any** part fails, **stop** and **rethrow** the **first** failure (or accumulate errors—**document**).

**Check:** Valid middle values sum correctly; out-of-range and non-numeric inputs fail with clear messages.

---

### Practice C — `TransactionLog` and `InsufficientFundsException`

**Scenario:**  
Reuse **`BankAccount`** and **`InsufficientFundsException`** from the progressive task (or redefine briefly). Simulate a **log** of withdrawal **attempts** as **`double[]`**.

**Requirements:**

1. **`public static String summarizeWithdrawAttempts(BankAccount acc, double[] attempts)`**  
   - **Loop** over **`attempts`**. For each **non-positive** amount, append a line **`"skip: bad amount"`** (or include the value). For each positive amount, **`try`** **`withdraw`**; on **`InsufficientFundsException`**, append **`"fail: "`** + **`getMessage()`**; on success append **`"ok"`** and include **running balance** if you like.  
   - Return one **`String`** (use **`StringBuilder`**).

**Check:** Mixed successes and failures produce a **multi-line** or **clear** summary string.

---

### Practice D — Design reflection

**Scenario:**  
You used **checked** `InsufficientFundsException` for **withdraw**.

**Problem:** In **3–5 sentences**, when is a **checked** exception appropriate, and when would a **`RuntimeException`** (or returning **`boolean success`**) be simpler? Give **one** disadvantage of **overusing** checked exceptions.

**Check:** Answer mentions **caller obligation** (`try`/`catch` or **`throws`**) vs **optional** handling for unchecked.

---

## Submission Guidelines

1. Complete all **3** progressive tasks, including **problem-solving extensions** (`findByStudentId`, `studentIdStartsWith`, `sumNonNegativeAmounts`, `countInvalidAmountLines`, `transferTo`, `accountWithHigherBalance`) unless your instructor assigns **core only**.
2. In your report, **one short paragraph**: why **`equals`** takes **`Object o`**, not **`StudentCard other`**.
3. Ensure all code compiles; show **`@Override`**, **`try`/`catch`**, and **`throws`** where required.
4. Use separate **`.java`** files if required; one **`Main`** may test all tasks; **label** core vs extension demos in comments.
5. **Practice tasks** are optional; complete **at least one** of A–C for extra logic practice if your instructor offers bonus points.
6. Submit as per your course instructions (e.g. Word file or zip on eLearning).

---

## Notes

- **`equals`** symmetry: if **`a.equals(b)`**, then **`b.equals(a)`** should be true—your field rules should stay consistent.
- **Checked exceptions:** either **`catch`** or add **`throws`** to the calling method (all the way up to **`main`** if needed).
- **`NumberFormatException`** is **unchecked**; you usually **catch** it to convert into a **clearer** message or **`IllegalArgumentException`**.
- This lab **replaces** the separate “Lab 13 polymorphism” + “Lab 14 exceptions” split: both topics are introduced here; follow-on labs can go deeper (e.g. **file I/O** with **`IOException`**).
