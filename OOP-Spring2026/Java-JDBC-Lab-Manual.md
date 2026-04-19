# Java JDBC Lab Manual (Single Session + Working Demo)

**Course:** Object-Oriented Programming / Java  
**Format:** One manual—lecture notes, setup, and runnable demo together (no separate “Lab 14/15” file required).  
**Goal:** Connect a Java program to a **relational database** using **JDBC**, run **SQL**, and handle **`SQLException`** safely.

---

## Table of Contents

1. [What You Will Learn](#what-you-will-learn)
2. [Concepts (Short)](#concepts-short)
3. [Choose Your Database (SQLite vs MySQL)](#choose-your-database-sqlite-vs-mysql)
4. [Setup: SQLite + JDBC (Recommended for Class Demo)](#setup-sqlite--jdbc-recommended-for-class-demo)
5. [Create the Database and Table](#create-the-database-and-table)
6. [Complete Working Demo (Java Code)](#complete-working-demo-java-code)
7. [Run the Demo](#run-the-demo)
8. [Best Practices](#best-practices)
9. [Optional Exercises](#optional-exercises)
10. [Troubleshooting](#troubleshooting)

---

## What You Will Learn

- What **JDBC** is and **why** we use **`java.sql`** (not raw files for structured data).
- **Driver**, **Connection**, **Statement** / **PreparedStatement**, **ResultSet**.
- **try-with-resources** so connections and statements **close** even when errors occur.
- A **minimal** but **real** program: **INSERT** and **SELECT** rows from a table.

---

## Concepts (Short)

| Piece | Role |
|--------|------|
| **JDBC driver** | A library that speaks your DB’s protocol. You add it to the **classpath** (`.jar`) or **Maven/Gradle**. |
| **`DriverManager.getConnection(url, user, password)`** | Opens a **Connection** to the database. |
| **`Connection`** | Session to the DB; use **try-with-resources** to auto-close. |
| **`Statement` / `PreparedStatement`** | Send SQL. Prefer **`PreparedStatement`** for user input (avoids **SQL injection**). |
| **`ResultSet`** | Rows returned by **`SELECT`**; use **`next()`** to walk rows and **`getXxx(column)`** to read cells. |
| **`SQLException`** | Checked exception—**must** **`catch`** or **`throws`**. |

**Flow:** load driver (often automatic for JDBC 4+) → **getConnection** → **createStatement** → **executeQuery** / **executeUpdate** → **close** (or **try-with-resources**).

---

## Choose Your Database (SQLite vs MySQL)

| | **SQLite (this manual’s default)** | **MySQL / MariaDB** |
|---|-------------------------------------|----------------------|
| **Server** | **None**—one file `*.db` on disk | Server must be **installed and running** |
| **Good for** | Classroom demos, homework | Production-like courses |

Students can follow the **SQLite** path on a laptop without installing a database server.

---

## Setup: SQLite + JDBC (Recommended for Class Demo)

### Step 1 — Java JDK

Ensure **`javac`** and **`java`** work (JDK 17+ recommended).

### Step 2 — Download the SQLite JDBC driver (one JAR)

1. Open the official **Xerial SQLite JDBC** releases page:  
   `https://github.com/xerial/sqlite-jdbc/releases`  
2. Download a **`sqlite-jdbc-3.xx.x.jar`** file (any recent **3.x** is fine).

3. Put the JAR in a folder **next to** your `.java` files, e.g.:

```text
jdbc-demo/
  sqlite-jdbc-3.45.0.0.jar   ← version may differ
  StudentDbDemo.java
```

*(Or use Maven/Gradle: dependency `org.xerial:sqlite-jdbc`—see your IDE’s “Add dependency” wizard.)*

---

## Create the Database and Table

You **do not** have to install SQLite separately—the JDBC driver creates the database file when Java connects.

**Table for the demo:** `students`

| Column | Type | Notes |
|--------|------|--------|
| `id` | `INTEGER PRIMARY KEY` | Auto-increment if you use `AUTOINCREMENT` (SQLite) |
| `name` | `TEXT` | Student name |
| `gpa` | `REAL` | Grade point average |

The Java **demo below** creates the table with **`CREATE TABLE IF NOT EXISTS`** so you can run it many times.

---

## Complete Working Demo (Java Code)

The same source is available in the repo as **`jdbc-demo/StudentDbDemo.java`** (copy it next to your downloaded **`.jar`**).

Save as **`StudentDbDemo.java`**. It:

1. Connects to **`jdbc:sqlite:students.db`** (creates **`students.db`** in the current working directory).
2. Creates table **`students`** if missing.
3. **INSERT**s two sample rows (using **`PreparedStatement`**).
4. **SELECT**s all rows and prints them.

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Minimal JDBC demo: SQLite + students table.
 * Run from folder that contains sqlite-jdbc-*.jar (see compile/run commands below).
 */
public class StudentDbDemo {

    // SQLite file will appear as students.db in the current directory
    private static final String DB_URL = "jdbc:sqlite:students.db";

    public static void main(String[] args) {
        try {
            demo();
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void demo() throws SQLException {
        // try-with-resources closes Connection automatically
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            createTableIfNeeded(conn);
            insertSampleRows(conn);
            printAllStudents(conn);
        }
    }

    private static void createTableIfNeeded(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS students ("
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " name TEXT NOT NULL,"
                + " gpa REAL NOT NULL)";
        try (Statement st = conn.createStatement()) {
            st.executeUpdate(sql);
        }
        System.out.println("Table 'students' is ready.");
    }

    private static void insertSampleRows(Connection conn) throws SQLException {
        String sql = "INSERT INTO students (name, gpa) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            // Row 1
            ps.setString(1, "Aisha Khan");
            ps.setDouble(2, 3.7);
            ps.executeUpdate();

            // Row 2
            ps.setString(1, "Omar Farid");
            ps.setDouble(2, 3.2);
            ps.executeUpdate();
        }
        System.out.println("Inserted sample rows.");
    }

    private static void printAllStudents(Connection conn) throws SQLException {
        String sql = "SELECT id, name, gpa FROM students ORDER BY id";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            System.out.println("--- All students ---");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double gpa = rs.getDouble("gpa");
                System.out.println(id + " | " + name + " | " + gpa);
            }
        }
    }
}
```

The sample uses **Java 8+** compatible string concatenation (no text blocks).

---

## Run the Demo

**Linux / macOS** (colon `:` separator):

```bash
cd jdbc-demo
javac -cp ".:sqlite-jdbc-3.45.0.0.jar" StudentDbDemo.java
java -cp ".:sqlite-jdbc-3.45.0.0.jar" StudentDbDemo
```

**Windows** (semicolon `;` separator):

```bat
cd jdbc-demo
javac -cp ".;sqlite-jdbc-3.45.0.0.jar" StudentDbDemo.java
java -cp ".;sqlite-jdbc-3.45.0.0.jar" StudentDbDemo
```

Replace **`3.45.0.0.jar`** with your actual JAR name.

**Expected output (similar to):**

```text
Table 'students' is ready.
Inserted sample rows.
--- All students ---
1 | Aisha Khan | 3.7
2 | Omar Farid | 3.2
```

Running again **adds** two more rows each time (IDs increase). For a **fresh** file, delete **`students.db`** in the folder and run again.

---

## Best Practices

1. **Always close resources** — Use **try-with-resources** on **`Connection`**, **`Statement`**, **`PreparedStatement`**, **`ResultSet`**.
2. **Use `PreparedStatement`** for any SQL that includes **variables** (especially **user input**).
3. **Handle `SQLException`** — Log or show a message; in larger apps, use a **logging** framework.
4. **Do not** put passwords in source code for real servers—use **environment variables** or config files (not required for local SQLite).

---

## Optional Exercises

1. **Delete** a student by **`id`** using **`DELETE FROM students WHERE id = ?`**.
2. **Update** a student’s **`gpa`** with **`UPDATE students SET gpa = ? WHERE id = ?`**.
3. **Prompt** for name and GPA with **`Scanner`**, then **INSERT** one row (still use **`PreparedStatement`**).
4. **MySQL variant:** Change URL to **`jdbc:mysql://localhost:3306/yourdb`**, add user/password, load MySQL Connector/J JAR—same JDBC code pattern.

---

## Troubleshooting

| Problem | What to check |
|--------|----------------|
| **`java.lang.ClassNotFoundException: org.sqlite.JDBC`** | **`-cp`** must include **`sqlite-jdbc-....jar`** for **both** `javac` and `java`. |
| **`SQLException: no such table`** | Run **`CREATE TABLE`** first or fix table name. |
| **Empty `SELECT`** | Wrong `students.db` path—run **`java`** from the folder where the DB file was created. |
| **`students.db` not found** | SQLite creates it on first connection in the **current working directory**. |

---

## Appendix — MySQL connection string (reference only)

```java
// String url = "jdbc:mysql://localhost:3306/course_db?useSSL=false&serverTimezone=UTC";
// try (Connection conn = DriverManager.getConnection(url, "user", "password")) { ... }
```

Requires **MySQL JDBC driver** (Connector/J) on the classpath and a **running** MySQL server with a **database** and **user** created.

---

## Document history

- **Spring 2026** — Single manual for classroom distribution and self-study.
