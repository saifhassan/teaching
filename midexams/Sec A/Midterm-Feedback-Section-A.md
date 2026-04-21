# Midterm Lab Exam — Section A — feedback

Marks use **lenient partial credit**. Graders **do not lower your mark only because the code does not compile**. We prioritize **approach**: the right **classes** (**`IdUtils`**, **`Book`**, **`Student`**, **`ExamMain`**), **`isValidId`** / **`maskId`** rules, **borrow / bringBack / takeBook / returnBook`** logic, and the **printed demo steps**—even if syntax or wiring prevents **`javac`** or a full run.

**Feedback format:** each student has a **mark**, then **Feedback** that lists **errors only** (compile-time, runtime, spec mismatches)—same detail as before. The **mark** reflects **generous** credit for that approach, **not** a deduction per error line.

---

## Abdulah Dareshani

**Mark: 9 / 15**

**Feedback:** The solution doesn’t compile: e.g. `onShelf true` (missing `=`) in `bringBack`, a stray `'` after `studentId`, `this.bookBorrowed` vs field `borrowed`, `if (!borrowed)` on an object, and an empty `maskId` body. There is no `IdUtils` class; ID helpers are inside `Student` and are wrong/incomplete (`charAt(0)` before a null check, `firstChar.isDigit()` is invalid for `char`, `maskId` unfinished). `takeBook` never assigns `borrowed = b`, checks `borrow()` before `b == null`, and `Main` doesn’t run the exam steps (no `IdUtils` calls for `"12ABCD99"`, wrong `returnBook(b)`, missing proper print sequence).

---

## Abu Bakar Mangrio

**Mark: 7 / 15**

**Feedback:** The solution doesn’t compile: `maskId` uses `retrun` instead of `return`, and it calls `id.length()` before checking `id == null`, which can throw on a null id. `isValidId` only checks null and length (it never checks that the first character is a digit). `maskId`’s non-null branch returns an empty string instead of first two + `***` + last two. In `Book.borrow`, `if (onShelf = true)` uses assignment, not comparison, so the shelf logic is wrong. There is no `Student` class and no `ExamMain` / `main` with the required steps.

---

## Ali Hassnain

**Mark: 7 / 15**

**Feedback:** Wrong or invalid Java throughout (`string` vs `String`, `bokk`, `id!null`, `idUtil` inside `Book`, unfinished `student` / `main`). `borrow` always returns `true` without fixing returns; `maskId` uses wrong substring range. No working `Student.takeBook`/`returnBook` or exam flow.

---

## Asad Alee

**Mark: 7 / 15**

**Feedback:** The file doesn’t compile: `borrow` has no return value; `bringBack` is fine in intent but paired with a broken `borrow`. `Student` mixes `IdUtils`-style methods in the wrong class, uses `first` vs `firstch`, wrong `takeBook` (`boolean b` shadows parameter, assigns `borrowed` never), garbled `returnBook`, and `Main` has `==`/`s`/`idUtils` errors. No separate `IdUtils` class.

---

## Ateeqa Kalhoro

**Mark: 7 / 15**

**Feedback:** Heavy syntax errors: missing `boolean` on `isValidId`, `else false` without `return`, empty `maskId` else, `private title String`, `Constructor` keyword, missing `;` after `onShelf = true`, `this, studentId`, wrong `takeBook` condition (`b.borrow()` used incorrectly), `Bookborrowed` vs `borrowed`, `main` missing semicolon and wrong `println` calls. Does not compile.

---

## Awais Ahmad

**Mark: 5 / 15**

**Feedback:** Not valid Java (bad import, nested broken classes, invented syntax). No usable `IdUtils`, `Book`, `Student`, or `main` matching the task.

---

## Ayan Qamar

**Mark: 7 / 15**

**Feedback:** `Book.borrow` and `bringBack` logic is inverted or invalid (`return onShelf = true` in void). `Student` uses `BookBorrowed` as `String`, wrong `isValidId` on student, constructor references undefined `b`, `takeBook`/`returnBook` use undefined `borrowed`/`b`/`b.borrowed`. No `IdUtils`; `main` missing prints for ID utilities and wrong method calls.

---

## Baqir Ali

**Mark: 5 / 15**

**Feedback:** Skeleton only: typos (`prntln`, `Sysrem`), invalid `maskId`/`Book`/`Student`/`main` fragments, placeholder text instead of code. Does not compile or implement the exam.

---

## Bareera Muneer

**Mark: 7 / 15**

**Feedback:** `maskId` line is incomplete (`if(id==null||)`); `isValidId` compares to `"null"` string instead of real null. `Book`/`Student`/`ExamMain` have broken braces, `Private`/`private` typos, wrong types, and invalid `main`. Does not compile.

---

## Erum Naz Soomro

**Mark: 7 / 15**

**Feedback:** Multiple compile errors: empty `if ()` in `isValidId`, bad `maskId` substring, missing `;` after `onShelf = false`, `b = null` instead of `==`, `borrowed` vs `bookBorrowed`, wrong `returnBook` test (`onShelf`), constructors called with no args. Structure attempted but not runnable.

---

## Falaq Aftab Qazi

**Mark: 8 / 15**

**Feedback:** `Book.borrow` is backwards (`onShelf == false` returns `true`). `Student.takeBook` never sets `borrowed`. `isValidId`/`maskId` are on `Student` but use wrong variable (`first` vs `fisrt`); `maskId` concatenates chars to a string incorrectly. `main` uses `static String id` inside `main` (invalid) and omits the required take/return print sequence.

---

## Fizza Batool

**Mark: 7 / 15**

**Feedback:** Invented types (`Sring`, `CharacterAt`), `onShelf`/`oneShelf` mix-ups, `borrow` inverted, nested `main` inside `Student`, missing braces, `!book` on wrong type. Does not compile.

---

## Ghulam Mustafa Solangi

**Mark: 7 / 15**

**Feedback:** `IdUtils` placed inside `Main` with invalid syntax (`id.length`, `CharAt`, assignments in conditions); `Book`/`Student` fragments mixed and incomplete. File truncates mid-class. Does not compile.

---

## Kirpa Sachdev

**Mark: 7 / 15**

**Feedback:** `fir` typo breaks `isValidId`; `maskId` misuses `ch` and never returns the required pattern. `Bookborrowed` is a `boolean` but assigned a `Book`; `returnBook` calls `borrowed` on wrong type. `main` treats static methods as instance fields. Does not compile.

---

## Mahesh kumar

**Mark: 7 / 15**

**Feedback:** Duplicate `Book b1`, `isValid`/`maskId` incomplete or wrong (`ch=='0'&& ch=='9'` impossible), `borrow` inverted, `Student`/`takeBook` unfinished. Does not compile.

---

## Majid Ali

**Mark: 5 / 15**

**Feedback:** Class name `Idutils`, invalid `Boolean static`, garbled `maskID`, `string`/`onShelf` errors, `takeBook`/`returnBook` not implemented to spec, `ExamMain`/`main` broken. Does not compile.

---

## Mazhar Ali

**Mark: 7 / 15**

**Feedback:** Submission is a zip with `Main.java` that has invalid `IdUtils` (`charAt(0) = 0`), duplicate `maskId`, `takeBook` logic wrong (`borrowed==null` condition inverted), `book` vs `borrowed`, `barrow` typo, empty `main`, stray `ture`. Does not compile.

---

## Mehak Duseja

**Mark: 7 / 15**

**Feedback:** `Book` nests static ID methods incorrectly; `borrow`/`setBringBack` structure broken; `Student`/`Main` nested wrongly; `void borrowed.bringBack()` invalid; unquoted strings in `main`. Does not compile.

---

## Muhammad Baqa

**Mark: 7 / 15**

**Feedback:** `isValidId` tests letters instead of a **digit**; `maskId` commented out. `Book` is mostly fine. `Student` has no `takeBook`/`returnBook`. `ExamMain` duplicates `b1` and has no scenario prints. Does not meet the task as a whole.

---

## Muhammad Bux

**Mark: 14 / 15**

**Feedback:** The `.txt` file contains **two full copies** of the same classes pasted back-to-back (`ExamMain` / `IdUtils` / `Book` / `Student` repeated), so it **does not compile as one file**. A single copy would match the exam; remove the duplicate block and save as `.java`.

---

## Muhammad Tarique

**Mark: 8 / 15**

**Feedback:** Compares strings to `"null"` instead of real null; `maskId` substring end index wrong (`length+1`). `takeBook` uses `borrow() = b` (invalid) and wrong field names; `returnBook` uses `b`/`borrowed` inconsistently; `takebook` vs `takeBook` in `main`. Does not compile.

---

## Nasreen Khatoon

**Mark: 7 / 15**

**Feedback:** Invalid syntax (`id >= 6`, `Sttring`, `instance class`, unclosed strings, `borrowed = b,`), broken `main`. Does not compile.

---

## Noorani Ejaz

**Mark: 7 / 15**

**Feedback:** Nested classes and methods invalid; typos (`priavte`, `this.id` without context), unfinished `ExamMain`. Does not compile.

---

## Prem Perkash

**Mark: 9 / 15**

**Feedback:** `IdUtils.isValidId` omits the **first character digit** check. `maskId` uses `substring(0,1)` (only one character) plus `***`, not first **two** + last **two**. `Student` has no `takeBook` / `returnBook`. `ExamMain` only prints ID checks, not the full six-step scenario.

---

## Qadir Bakhsh

**Mark: 15 / 15**

**Feedback:** `IdUtils.isValidId` should check **`id != null` before** `id.length()` for null ids. `maskId` uses `charAt(0)+charAt(1)` (numeric addition instead of `"12"`) and reverses the last two characters, so masked output is wrong (e.g. `99***99` instead of `12***99`). `Book` and `Student` behaviour and the `ExamMain` sequence are otherwise essentially correct.

---

## Qadir Bux Solangi

**Mark: 7 / 15**

**Feedback:** Syntax errors (`this studentId`), `id.equals(null)` wrong, `string`/`substr` not Java, no `borrow`/`bringBack`, incomplete `Book`. Does not compile.

---

## Sajjad Ali

**Mark: 5 / 15**

**Feedback:** Not coherent Java (misspelled keywords, random fragments, broken `main`). No working implementation.

---

## Sheeraz Ahmed

**Mark: 15 / 15**

**Feedback:** `IdUtils`, `Book`, and `Student` match the spec; `LibraryKiosk` runs the correct prints and sequence (equivalent to `ExamMain`). No issues worth a deduction.

---

## Siraj Ahmed

**Mark: 7 / 15**

**Feedback:** `borrow` logic is inverted (`onShelf == false` returns `true`). `takeBook` uses `Borrowed.equals(null)` (wrong; use `Borrowed == null`) and never checks “already holding a book”. No `IdUtils`, no `main`, no exam steps.

---

## Sitara Channar

**Mark: 7 / 15**

**Feedback:** Invalid comparisons (`id!="Null"`, `id>=6`), bad `charAt` usage, `retrun` typos, `borrowed` vs `Booborrowed`, `returnBook` logic wrong. `main` empty. Does not compile.

---

## Tasaduq Hussain

**Mark: 6 / 15**

**Feedback:** File is not valid Java (syntax, nested `main`, undefined identifiers). Does not compile.

---

## Unzah Ayaz

**Mark: 5 / 15**

**Feedback:** `c.isDigit()` invalid on `char`; `maskId` wrong / uses literals `"first"`/`"last"`; `Book` class not closed before `Student`; `takeBook` uses `bookBorrowed` (undefined) and assignment in condition; `returnBook` calls `borrowed.onShelf()` which doesn’t exist; `main` uses unquoted `12ABCD99` and wrong calls. Does not compile.

---

## Uzair Khan Aghani

**Mark: 4 / 15**

**Feedback:** Submitted fragment only (`class Book(` …); not a complete program. No runnable exam solution.

---

## Yashfa Mustafa

**Mark: 8 / 15**

**Feedback:** `isValidId` compares `charAt` to `0`/`9` incorrectly (should use `Character.isDigit`). `takeBook` calls `b.borrowed()` which does not exist; missing check for already borrowed. `borrow`’s `else` wrongly flips `onShelf`. Does not compile.

---

## Zafran Khan

**Mark: 15 / 15**

**Feedback:** Logic for `IdUtils`, `Book`, and `Student` matches the task and `main` prints the right sequence, but the file is **missing a closing `}`** for class `ExameMain`, so it does not compile until that brace is added. Class name typo `ExameMain` vs `ExamMain` is minor.

---

## Zuhair Ahmed

**Mark: 5 / 15**

**Feedback:** Not valid Java (`string`, `!==`, `length` without `()`, nested classes without braces, unfinished `exammain`). Does not compile.

---

## Liaqat Ali

**Mark: 8 / 15**

**Feedback:** `isValidId` / `maskId` are **static inside `Book`** instead of `IdUtils`; `isValidId` has no digit check. `takeBook` doesn’t handle “already has a book”. `returnBook` uses `name==null && studentId==null` instead of checking `borrowed`. `ExamMain` only runs part of the scenario.

---

## Muhammad Hamza

**Mark: 4 / 15**

**Feedback:** Severe syntax errors (`Static`, `Private`, string returns for booleans, unfinished classes). Does not compile.

---

## Sahiba Raees

**Mark: 5 / 15**

**Feedback:** Invalid pseudo-code (`characterAt`, `lenght`, unquoted `****`, wrong `borrow` logic, `!book`, broken `main`). Does not compile.

---

## Vijay Karan

**Mark: 1 / 15**

**Feedback:** Submission is a `.labexam` binary, not readable/reviewable Java source here; a small courtesy mark only for an attempt that could not be marked on code.

---

*End of Section A list.*
