# Midterm Lab Exam — Section A — How Your Work Will Be Graded

**Total marks: 15**  
This matches the task in **`question task.txt`** (library kiosk: `IdUtils`, `Book`, `Student`, and `ExamMain`).

Marks use **generous, lenient partial credit**: graders **do not reduce marks only because code does not compile**. We weight **approach**—**`IdUtils`**, **`Book`**, **`Student`**, **`ExamMain`**, and the borrow/return flow—even when **`javac`** fails. The combined feedback file (**`Midterm-Feedback-Section-A.md`**) gives each student a **mark** and **Feedback** that lists **errors only**; the **mark** is **not** a simple penalty per error line.

Marks are still split by **parts** of the solution. You get credit for **correct behavior** where visible, **clear structure**, and **following the sample steps** in `main` when inferable from your code.

---

## Mark breakdown

| Part | Marks | What we look for |
|------|------:|------------------|
| **IdUtils** | **3** | `isValidId` and `maskId` follow the rules in the exam sheet (null, length, first character, masking pattern). |
| **Book** | **3.5** | Correct fields and constructor; `borrow` and `bringBack` update shelf status in the right way. |
| **Student** | **4.5** | Correct fields and constructor; `takeBook` and `returnBook` match the rules (including when to return `false`). |
| **ExamMain** | **4** | The program runs the scenario: print ID checks for `"12ABCD99"`, two books, one student, then the sequence of take / try second / return / take second with the expected **true/false** results. |

---

## General expectations

- **Partial credit:** If something is only partly right, you can still earn marks for the parts that work.
- **Honest attempts:** If the code does not compile, we may still award marks where the intended logic is clear from reading your code.
- **Output:** You may print values in a simple way (for example `true` / `false` or short labels), as long as the **correct** results are easy to see.

---

*Course: BS (CS/SE) – II · Exam date: 7 April 2026*
