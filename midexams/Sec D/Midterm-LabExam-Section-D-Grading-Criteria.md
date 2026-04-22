# Midterm Lab Exam — Section D — How Your Work Will Be Graded

**Total marks: 15**  
This matches the task in **`Midterm-LabExam-Section-D.html`** (2D hit test: `Point`, `Box`, `HitTester`, `ExamMain`).

Marks use **generous, lenient partial credit**: graders **do not reduce marks only because code does not compile**. We weight **approach**—the right **classes**, **distanceTo** / **`contains`** / **`where`** ideas, and **ExamMain** intent—even when **`javac`** fails or output is wrong. The combined feedback file (**`Midterm-Feedback-Section-D.md`**) gives each student a **mark** and **Feedback** that lists **errors only**; the **mark** is **not** a simple penalty per error line.

Marks are still split by **parts** of the solution (**Point**, **Box**, **HitTester**, **ExamMain**). You get credit for **correct behaviour** where visible, **clear structure**, and **following the demo steps** when inferable from your code.

---

## Mark breakdown

| Part | Marks | What we look for |
|------|------:|------------------|
| **Point** | **4** | Private `x`, `y`; constructor; `getX` / `getY`; `distanceTo` = Euclidean distance, or **`-1.0`** if the other point is **`null`**. |
| **Box** | **4** | Stores `left`, `top`, `width`, `height`; **`contains`** is **`true`** only if the point is not `null` and its **x** and **y** lie **inside the rectangle inclusive** (edges count). |
| **HitTester** | **3** | Stores `zoneName` and `Box`; **`where`** returns the exact pattern **`"inside "`** + name or **`"outside "`** + name, using `area.contains(p)`. |
| **ExamMain** | **4** | Runs the **task steps in order**: distance `(0,0)`–`(3,4)`; box `10,10,20,15`; hit tester `"Panel"`; `where` for `(15,18)` and `(5,18)`; **`distanceTo(null)`** from `(15,18)` → **`-1.0`**. |

---

## General expectations

- **Partial credit:** If something is only partly right, you can still earn marks for the parts that work.
- **Honest attempts:** If the code does not compile, we may still award marks where the intended logic is clear from reading your code.
- **Output:** Normal `double` printing for distance is fine (e.g. `5.0`).

---

*BS (CS/SE/AI)–II · Section D · 8 April 2026 · 45 min*
