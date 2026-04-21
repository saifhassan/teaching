# Midterm Lab Exam — Section B — How Your Work Will Be Graded

**Total marks: 15**  
This matches the task in **`Midterm-LabExam-Section-B.html`** (quiz comparison: **`ArrayStats`**, **`QuizRecord`**, **`StudyPair`**, **`ExamMain`**).

Marks use **generous, lenient partial credit**: graders **do not reduce marks only because code does not compile**. We weight **approach**—the right **classes** and **methods**, **`ArrayStats`** rules for **`null`** / empty arrays, **defensive copy** in **`QuizRecord`**, **`winnerByPasses`** tie-breaking, and **`ExamMain`** demo steps—even when **`javac`** fails. The combined feedback file (**`Midterm-Feedback-Section-B.md`**) lists **all Section B submissions** with a **mark** and **Feedback** (**errors only**); the **mark** is **not** a simple penalty per error line.

---

## Mark breakdown

| Part | Marks | What we look for |
|------|------:|------------------|
| **ArrayStats** | **3** | **`sum(int[] data)`** — **`null`** → **`0`**; else sum of elements. **`mean(int[] data)`** — **`null`** or length **`0`** → **`-1.0`**; else arithmetic mean as **`double`**. **`countAtLeast(int[] data, int cutoff)`** — **`null`** → **`-1`**; empty array → **`0`**; else count of elements **≥** **`cutoff`**. |
| **QuizRecord** | **5** | Private **`id`**, **`int[] marks`**; constructor stores a **defensive copy** of the marks array. **`getId()`**, **`quizMean()`** (via **`ArrayStats.mean`** on stored marks), **`bestMark()`**, **`passingCount(int minScore)`** (via **`ArrayStats.countAtLeast`** or equivalent logic on stored marks). |
| **StudyPair** | **3** | Private **`QuizRecord first`**, **`second`**; constructor **`StudyPair(QuizRecord a, QuizRecord b)`**. **`winnerByPasses(int minScore)`** — higher **passing count** wins (return that **`id`**); if tied, **strictly higher** **mean** wins; if tied on both, return exactly **`Tie`**. |
| **ExamMain** | **4** | **Six task steps in order**: (1) **`mean({4,5,6})`** and **`countAtLeast({10,5,12,5}, 10)`**; (2) **`mean(null)`**, **`mean(new int[0])`**, **`countAtLeast(null, 0)`**; (3) encapsulation check **`raw[0]=0`** then **`r.quizMean()`** → **`10.0`**; (4) Ali vs Sara, **`winnerByPasses(8)`** → **`Ali`**; (5) T1 vs T2, **`winnerByPasses(8)`** → **`T2`**; (6) P vs Q, **`winnerByPasses(9)`** → **`Tie`**. |

---

## General expectations

- **Partial credit:** Wrong method *names* but correct maths may still earn part marks; wrong **null** handling or **no defensive copy** costs more.
- **Honest attempts:** Non-compiling code may still receive marks where the intended structure (**classes**, **signatures**) is clear from reading the files.
- **Printing:** Normal **`double`** output is fine (e.g. **`5.0`**).

---

*BS (CS/SE/AI)–II · Section B · 9 April 2026 · 45 min*
