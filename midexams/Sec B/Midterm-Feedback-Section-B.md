# Midterm Lab Exam — Section B — feedback

Marks use **lenient partial credit**. Graders **do not lower your mark only because the code does not compile**. We prioritize **approach**: the right **classes** (**`ArrayStats`**, **`QuizRecord`**, **`StudyPair`**, **`ExamMain`**), **`ArrayStats`** null/empty rules, **defensive copy** for marks, **`winnerByPasses`** tie-breaking, and the **six demo steps**—even if syntax or wiring prevents **`javac`** or a full run.

**Feedback format:** each student has a **mark**, then **Feedback** that lists **errors only** (compile-time, runtime, spec mismatches). Each block is limited to **about five short paragraphs** so you can share it as-is. The **mark** reflects **generous** credit for approach, **not** one deduction per bullet.

Reference expectations for a fully correct solution: **`5.0`**, **`2`** (step 1); **`-1.0`**, **`-1.0`**, **`-1`** (step 2); **`10.0`** after mutating **`raw[0]`** (step 3); **`Ali`**, **`T2`**, **`Tie`** (steps 4–6).

---

## Abdul Basit

**Mark: 6 / 15**

**Feedback:**

**`ArrayStats`:** The **`for`** loop uses **`for(int = 0; …)`**—you need a variable name such as **`int i`**. **`sum`** never checks **`data == null`** (spec: return **`0`**). **`mean`** skips **`null`** / empty handling and divides **`int`**s, so the mean is not a proper **`double`**. **`countAtLeast`** treats empty as **`-1`**, uses **`data[i]`** outside a loop, and never handles **`null`** the way the sheet specifies.

**`QuizRecord`:** Using fixed **`new int[10]`** is not the required **`private int[] marks`** plus a **defensive copy** of the constructor argument. **`getId`**, **`quizMean`**, **`bestMarks`**, and **`passingCount`** are **`static`** but use **`this`**—instance methods should not be **`static`**. **`bestMarks`** is missing return type **`int`**; **`quizMean`** should **`return`** a **`double`**, not only **`println`**. **`passingCount`** should count marks **≥** **`minScore`**, not the opposite comparison.

**`StudyPair` / `ExamMain`:** **`new QuizRecord()`** has no constructor; **`winnerByPasses`** is empty. **`ExamMain`** mixes non-**`static`** fields with **`static main`**; **`StudyPair("Ali")`** must pass **two** **`QuizRecord`** references; **`mean(array[0])`** passes a single **`int`** instead of an **`int[]`**.

**Does not compile** (e.g. **`basitslab.java`** loop and method headers); fix the errors above so **`javac`** succeeds, then align behaviour with the task sheet.

---

## Abdul sami Bugti

**Mark: 7 / 15**

**Feedback:**

**Structure:** **`ArrayStats`**-style methods appear inside **`main.java`**, but **`int []static int sum`** is not valid Java—methods need a proper **`class ArrayStats { … }`** wrapper and a valid header like **`static int sum(int[] data)`**.

**Loops / syntax:** The **`for`** loop uses a **comma** where a **semicolon** belongs (**`i<data.length,i++`**). **`static double mean`** is nested incorrectly so the compiler reports **illegal start of expression**.

**Spec (for when it compiles):** You will still need **`sum(null)==0`**, **`mean(null)`** / empty **→ -1.0**, and **`countAtLeast(null, …)==-1`** as in the exam.

**Does not compile** until class structure and **`for`** syntax are fixed.

---

## Abeer Fatima

**Mark: 7 / 15**

**Feedback:**

**File layout:** **`StudyPair`** (fields, constructor, methods) is pasted **after** **`ExamMain`** closes in a way that leaves **`StudyPair{`** outside any **`class`**—the compiler reports **`class, interface, or enum expected`**.

**Fix:** Put **`class StudyPair { … }`** in its own file **`StudyPair.java`**, or keep all classes in one file but ensure each **`class`** has matching **`{` … `}`** and that only one **`public`** class matches the filename.

**Does not compile** until **`StudyPair`** is a well-formed top-level class.

---

## Adil Ali

**Mark: 10 / 15**

**Feedback:**

**What runs:** **`ArrayStats.mean(new int[]{4,5,6})`** prints **`5.0`** and **`countAtLeast`** prints **`2`** as required. **`mean(null)`** correctly yields **`-1.0`**.

**Crash:** The program then calls **`countAtLeast`** with **`data == null`** but the method uses **`data.length`** (or similar) **before** checking **`null`**, causing **`NullPointerException`**. Per spec, **`countAtLeast(null, cutoff)`** must return **`-1`** without touching the array.

**Missing output:** Because of the crash, step 2 never prints **`mean(new int[0])`** and **`countAtLeast(null, 0)`**, and later demo steps do not run.

**Fix:** Guard **`countAtLeast`** with **`if (data == null) return -1;`** first, then handle empty length and the loop.

---

## Ahmed Chandio

**Mark: 14 / 15**

**Feedback:**

**Strong parts:** **`QuizRecord`** encapsulation, **`StudyPair.winnerByPasses`**, and the **`Ali` / `T2` / `Tie`** results match the intended logic; **`quizMean()`** after mutating **`raw`** shows **`10.0`**, so the defensive copy idea works.

**`ExamMain` typos vs task:** Step 1 should call **`countAtLeast(new int[]{10,5,12,5}, 10)`** (expect **`2`**). Your **`ExamMain`** uses a **different** array and cutoff (**`{10,5,2,5}`** with **`5`**), so the second line prints **`3`** instead of **`2`**. Step 2 should call **`countAtLeast(null, 0)`**; yours uses **`countAtLeast(null, 6)`** (wrong cutoff).

**Why mark is still high:** Core classes follow the sheet; deductions are mainly for **wrong literals** in **`main`**, not missing **`winnerByPasses`** logic.

---

## Ali Raza

**Mark: 7 / 15**

**Feedback:**

**Nesting:** **`return "Tie"`** and **`Class MainExam{`** appear where the compiler expects a class body to continue—**`illegal start of type`** means a **`}`** or method is missing earlier, often after **`StudyPair`** or **`winnerByPasses`**.

**Likely intent:** You attempted **`StudyPair`** and **`ExamMain`** together; the file **`Main.java`** needs every **`class`** closed before starting another or moving **`main`** into **`ExamMain`**.

**Does not compile**; re-open **`Main.java`** from the first error line and fix brace matching, then re-run **`javac`**.

---

## Amaima Nabi

**Mark: 7 / 15**

**Feedback:**

**Syntax:** **`int arr[i]`** is not a valid declaration (**`i`** is not a constant for array size). **`data.lenght`** is a typo for **`length`**. An **`else`** appears without a matching **`if`** block.

**Spec reminder:** **`ArrayStats`** methods belong in **`class ArrayStats`** with **`static`** methods exactly as named on the sheet.

**Does not compile**; fix declarations and spelling, then add **`null`** / empty handling for **`mean`** and **`countAtLeast`**.

---

## Asad Rahman

**Mark: 11 / 15**

**Feedback:**

**What works:** **`Main.java`** compiles and prints **`5.0`**, **`2`**, **`-1.0`**, **`-1.0`**, **`-1`** for the first two task bullets (steps 1–2).

**Missing:** There is no print for **step 3** ( **`QuizRecord("Z", raw)`**, mutate **`raw[0]`**, then **`quizMean()`** → **`10.0`**). There are no **`StudyPair`** demos for **Ali/Sara**, **T1/T2**, or **P/Q**, so **`Ali`**, **`T2`**, and **`Tie`** never appear.

**To improve:** Append the remaining **`println`** calls using your existing **`QuizRecord`** / **`StudyPair`** classes so the full six-step scenario runs.

---

## Asma Abro

**Mark: 7 / 15**

**Feedback:**

**File start:** Non-Java text at the top of **`Mainnn.java`** must be removed or turned into **`//` comments**—otherwise **`class, interface, or enum expected`**.

**Types / keywords:** **`dounle`** should be **`double`**; **`if(int x>= cutoff)`** is invalid (**`if`** cannot declare **`int x`** like that). **`'.class' expected`** often means a stray token in **`ArrayStats`**.

**Does not compile**; start from a clean **`public class …`** and rebuild **`sum`**, **`mean`**, **`countAtLeast`** with correct syntax.

---

## Binish Fatima

**Mark: 7 / 15**

**Feedback:**

**Null / arrays:** **`if(data[]==null)`** is invalid—use **`if (data == null)`**. Arrays use **`data.length`**, not **`data.length()`** (unless you intentionally use a different type).

**Class structure:** **`static double mean`** and **`countAtLeast`** must sit **inside** **`class ArrayStats { … }`**, not floating between half-finished **`if`** blocks.

**Does not compile**; fix **`if`** syntax and wrap methods in a single class body.

---

## Faizan Mustafa

**Mark: 5 / 15**

**Feedback:**

**Submission:** The folder contains **no** **`.java`** sources—only an archive (e.g. **`.zip`**). Graders cannot run **`javac`** on an empty tree.

**What to do:** Unzip, submit all **`.java`** files (**`ArrayStats.java`**, **`QuizRecord.java`**, **`StudyPair.java`**, **`ExamMain.java`**) or a single file with those classes, as required by the LMS.

**Mark:** Small credit for attempting submission; resubmit with sources for a full grade.

---

## Fatima Raza

**Mark: 7 / 15**

**Feedback:**

**`countAtLeast`:** **`count++`** needs a terminating **`;`** inside the loop body.

**Keywords / constructor:** **`Private`** must be **`private`**. **`public QuizRecord((String id, int[] marks)`** has an extra **`(`**—constructor should be **`QuizRecord(String id, int[] marks)`**.

**Does not compile** until these syntax issues are fixed; then verify **defensive copy** and **`StudyPair.winnerByPasses`** against the sheet.

---

## Fatima Sardar Ali

**Mark: 7 / 15**

**Feedback:**

**Class name:** **`class Array stats`** is invalid—identifiers cannot contain a space; use **`ArrayStats`**.

**Method placement:** **`static double mean`** appears where the compiler no longer expects a method (**`class, interface, or enum expected`**)—usually because the **`ArrayStats`** **`{`** was never closed or **`stats`** broke parsing.

**Does not compile**; use one **`class ArrayStats {`** … **`}`** and put **`sum`**, **`mean`**, **`countAtLeast`** inside it.

---

## Gaitry Guralmal

**Mark: 7 / 15**

**Feedback:**

**Public class / file:** **`public class StudyPair`** in **`ExamMain.java`** must live in **`StudyPair.java`** (or drop **`public`**). Java requires the filename to match the **`public`** class.

**API:** **`ArrayStats.mean()`** is called with **no** **`int[]`** argument—the method must take **`(int[] data)`** as on the sheet.

**Return types:** **`return bestMarks`** must match the declared return type of **`winnerByPasses`** (**`String`**, not **`int`**).

**Does not compile** until filenames, **`mean`** calls, and return paths are fixed.

---

## Hasnain Ali

**Mark: 7 / 15**

**Feedback:**

**Incomplete expression:** **`if(max[i] > )`** is missing the right-hand side (e.g. compare to **`max`** or **`marks[i]`** for **`bestMark`**).

**EOF errors:** **Reached end of file while parsing`** usually means a missing **`}`** for **`QuizRecord`**, **`StudyPair`**, or **`ExamMain`**.

**Does not compile**; complete the **`if`** and balance braces.

---

## Hussain Ahmed Baloch

**Mark: 7 / 15**

**Feedback:**

**Syntax:** **`countAtLeast(marks[] , minScore)`** is invalid—pass **`marks`** (the array variable), not **`marks[]`**, unless you index a specific element (**`marks[i]`**).

**Context:** This appears inside **`QuizRecord.passingCount`** or similar—ensure you call **`ArrayStats.countAtLeast(this.marks, minScore)`** per task.

**Does not compile**; fix the actual parameter list.

---

## Ifra Ishtiaque

**Mark: 7 / 15**

**Feedback:**

**Typos:** **`cLass`** → **`class`**. **`QuizRecord`** must be a full class with **`private`** fields and a constructor, not random statements after a broken brace.

**Constructor body:** **`this.marks.length >= 1;`** is an expression statement, not a substitute for copying the array into **`this.marks`**.

**Does not compile**; rebuild **`QuizRecord`** with **`this.marks = Arrays.copyOf(marks, marks.length);`** (or a manual loop) as required.

---

## Ifrah Akhtar

**Mark: 7 / 15**

**Feedback:**

**Enhanced for-loop:** **`for(int sum: data[])`** is invalid—use **`for (int x : data)`** if you iterate elements, or index with **`for (int i = 0; i < data.length; i++)`**.

**Parameter list:** **`countAtLeast(int[] data. int cutoff)`** must use a **comma**, not a **period**, between parameters.

**Does not compile**; fix **`for`** syntax and method signatures, then implement **`null`** checks.

---

## Inshrah Shah

**Mark: 7 / 15**

**Feedback:**

**Filename:** Avoid spaces in **`Mainn (1).java`**; use **`Mainn.java`** or **`ExamMain.java`** consistently.

**Operators / methods:** **`> =`** must be **`>=`** (one token). Getters need **`String getId()`** with **`()`**, not **`String getid`** with a missing **`(`**.

**Does not compile**; align names with the task (**`getId`**, **`quizMean`**, **`bestMark`**) and fix method headers.

---

## Kalsoom Naz

**Mark: 7 / 15**

**Feedback:**

**Class body:** **`static double mean`** cannot appear before **`class ArrayStats`** is properly opened—**`illegal start of expression`** means a stray **`}`** or missing **`class`** keyword.

**Single-line `if`:** `if(marks[i] < minScore){minScore = marks[i]}` needs a **`;`** after the inner assignment and proper braces if you meant **`bestMark`**.

**Does not compile**; nest all **`ArrayStats`** methods inside **`class ArrayStats`**.

---

## Karan Kumar

**Mark: 7 / 15**

**Feedback:**

**Keywords:** Java keywords are lowercase—**`CLASS`** → **`class`**. **`privat`** → **`private`**.

**Placement:** **`countAtleast`** and **`passingCount`** for **`QuizRecord`** must be **inside** **`class QuizRecord`**, not between unrelated classes.

**Does not compile**; fix spelling and move instance methods into the correct class.

---

## Kashish Kumari

**Mark: 7 / 15**

**Feedback:**

**`sum` method:** **`public static int sum(int[] data)`** must be followed by **`{`** before the **`for`** loop—**`>` expected** often means the parser thinks the header never ended.

**Single file:** If everything is in **`ExamMain.java`**, keep **`class ArrayStats`**, **`QuizRecord`**, **`StudyPair`** as separate **`class`** blocks in order, each fully braced.

**Does not compile**; add braces and separate classes clearly.

---

## Khadija Khalid

**Mark: 7 / 15**

**Feedback:**

**Null check:** Use **`if (data == null)`**, not **`if (data[] == null)`**—arrays are referenced by name, **`data`**, not **`data[]`**.

**`length`:** **`data.length`** is a field, not **`data.length()`**; **`length() = 0`** is assignment, not comparison—use **`data.length == 0`**.

**Does not compile**; fix **`ArrayStats`** conditionals, then retest **`mean`** and **`countAtLeast`** for **`null`** and empty arrays.

---

## Maha Nazeer

**Mark: 7 / 15**

**Feedback:**

**Invalid syntax:** **`data[].length`** should be **`data == null`**, **`data.length`**, etc.—**`data[]`** is not valid in conditions.

**Return type:** **`return "-1.0"`** returns a **`String`**; **`mean`** must **`return -1.0;`** as a **`double`**.

**Does not compile**; align **`mean`** with **`ArrayStats`** on the sheet.

---

## Malhar Ali

**Mark: 7 / 15**

**Feedback:**

**`if` / `else`:** **`else` without `if`** means a previous **`if`** was closed too early or an **`if`** line is incomplete.

**Constructor:** **`Studypair`** is a typo for **`StudyPair`**; constructors need **`class StudyPair`** and **`StudyPair(QuizRecord a, QuizRecord b)`**.

**`main`:** **`public static` repeated**—there should be only one **`public static void main`** in **`ExamMain`**.

**Does not compile**; fix control flow and duplicate **`main`**.

---

## Maria Soomro

**Mark: 7 / 15**

**Feedback:**

**Operators:** **`sum+ = i`** should be **`sum += i`** (no space inside **`+=`**).

**Classes:** **`QuizRecord(String id, int[] marks){`** must appear **inside** **`class QuizRecord`**, not at file level after stray code.

**Stray token:** **`StudyPair{`** without **`class`** starts a block the parser rejects.

**Does not compile**; wrap each class properly and fix **`sum`**.

---

## Mohammad Hassaan Sahito

**Mark: 7 / 15**

**Feedback:**

**Behaviour:** **`main.java`** compiles, but running **`java Main`** produces **no output**—either **`main`** is empty or all **`println`** calls are commented out.

**Task:** The exam requires **nine** visible lines of results (steps 1–6). Empty output cannot demonstrate **`ArrayStats`**, **`QuizRecord`**, or **`StudyPair`**.

**Fix:** Add the **`ExamMain`** steps from the HTML in order and re-run.

---

## Muhammad Aslam

**Mark: 7 / 15**

**Feedback:**

**Keyword:** **`CLASS`** must be **`class`** (Java is case-sensitive).

**`for` loop:** **`for(int i=0; i< data.length, i++)`** uses a **comma** before **`i++`**—must be a **semicolon**: **`for (int i = 0; i < data.length; i++)`**.

**Does not compile**; fix **`for`** syntax, then implement **`ArrayStats`** per spec.

---

## Muhammad Ehsan

**Mark: 7 / 15**

**Feedback:**

**Typo:** **`ArratStats`** in **`println`** should be **`ArrayStats`**—the compiler treats **`ArratStats`** as an unknown identifier.

**Cascade:** One typo in **`System.out.println`** can produce many **`<identifier> expected`** errors on the next lines.

**Does not compile**; spell **`ArrayStats`** consistently everywhere.

---

## Muhammad Usaid Rehman

**Mark: 7 / 15**

**Feedback:**

**Method call:** **`winnerByPasses(int 8)`** is invalid—use **`winnerByPasses(8)`** (literal **`8`**, not **`int 8`**).

**For-each:** **`for(int a: marks[])`** is wrong—use **`for (int a : marks)`** to iterate **`marks`**, or index with **`marks[i]`**.

**Does not compile**; fix calls and loops, then verify **`winnerByPasses`** tie logic.

---

## Naeem Ahmed

**Mark: 7 / 15**

**Feedback:**

**Fields:** **`this.QuizRecord first`** is invalid—declare **`private QuizRecord first;`** in the class body, then in the constructor **`this.first = a;`**.

**Types:** **`QuizRecord`** is a type name, not a field prefix on **`this`**.

**Does not compile**; use normal field declarations for **`StudyPair`**.

---

## Nanjo Mal

**Mark: 7 / 15**

**Feedback:**

**Syntax near EOF:** **`public ExamMain{`** looks like a constructor or garbled class header—**`ExamMain`** should be **`class ExamMain`** with **`public static void main`**.

**Incomplete file:** **Reached end of file while parsing`** suggests missing **`}`** for **`StudyPair`** or **`QuizRecord`**.

**Does not compile**; finish **`ExamMain`** and close all classes.

---

## Prem Vishal

**Mark: 15 / 15**

**Feedback:**

**`ArrayStats`:** **`sum`**, **`mean`**, and **`countAtLeast`** handle **`null`**, empty arrays, and cutoffs as specified.

**`QuizRecord`:** Defensive copy keeps **`quizMean()`** at **`10.0`** after **`raw[0]`** is changed.

**`StudyPair`:** **`winnerByPasses`** returns **`Ali`**, **`T2`**, and **`Tie`** correctly for the three scenarios.

**`ExamMain`:** Printed sequence matches the reference (**`5.0`**, **`2`**, **`-1.0`**, **`-1.0`**, **`-1`**, **`10.0`**, **`Ali`**, **`T2`**, **`Tie`**). No issues found in the graded run.

---

## Rabia Shaikh

**Mark: 7 / 15**

**Feedback:**

**Typos:** **`Statc`** → **`static`**, **`pubic`** → **`public`**.

**Sum:** **`sum+data[i]`** must update **`sum`**, e.g. **`sum = sum + data[i];`** or **`sum += data[i];`**.

**Does not compile**; fix spelling and assignment, then add **`null`** handling for **`mean`** / **`countAtLeast`**.

---

## Sanam Nawaz

**Mark: 7 / 15**

**Feedback:**

**`for` loop:** **`for(int i=0 i<data.length; i++)`** is missing **`;`** after **`i=0`**.

**Keyword:** **`Private`** → **`private`** for fields (e.g. in **`StudyPair`** if mixed into **`ArrayStats.java`**—prefer separate files per class).

**Calls:** **`System.out.println()`** with no argument may be legal but does nothing—ensure each demo line prints the required value.

**Does not compile** until **`for`** and **`Private`** are fixed.

---

## Sidra Abbasi

**Mark: 7 / 15**

**Feedback:**

**Method header:** **`double quizMean{`** must be **`double quizMean()`** with parentheses.

**`println`:** **`ArrayStats.mean(new int[] { 4, 5, 6 };`** has **`;`** inside where **`)`** should close the array—use **`}));`** or **`})`** correctly.

**Does not compile**; fix method syntax and **`println`** argument parentheses.

---

## Urva Khan

**Mark: 12 / 15**

**Feedback:**

**Encapsulation:** Step 3 prints **`5.0`** instead of **`10.0`**, so the stored marks still behave like **`[0,10]`** after **`raw[0]=0`**—the defensive copy is missing or **`quizMean`** uses the wrong array.

**String:** Last line prints **`tie`**; the spec requires the exact string **`Tie`**.

**Rest:** Earlier lines (**`5.0`**, **`2`**, null/empty handling) and **`winnerByPasses`** outcomes (**`Ali`**, **`T2`**) are close; fix **`QuizRecord`** copy and the **`Tie`** spelling/casing.

---

## Warda Shamim

**Mark: 7 / 15**

**Feedback:**

**`for`:** **`for(d:data)`** is invalid—use **`for (int d : data)`** or a classic index loop.

**Nesting:** **`static double mean`** cannot appear inside another method’s **`for`**—**`static`** methods belong directly under **`class ArrayStats`**.

**Braces:** **`return -1.0}`** suggests a missing **`;`** before **`}`** or an extra **`}`**.

**Does not compile**; restructure **`ArrayStats`** with proper method boundaries.

---

## Zain Khan

**Mark: 7 / 15**

**Feedback:**

**Run:** **`my.java`** compiles, but **`main`** prints nothing—no **`System.out.println`** for the exam steps or **`main`** is empty.

**Task:** Without output, **`ArrayStats`**, **`QuizRecord`**, and **`StudyPair`** cannot be verified.

**Fix:** Implement **`public static void main`** in **`ExamMain`** (or **`my.java`**) with the six-step **`println`** sequence from the sheet.

---

## anam mairaj

**Mark: 7 / 15**

**Feedback:**

**Invalid return:** **`return mean[double]`** is not valid Java—**`mean`** is a method call, not an array named **`mean[double]`**.

**Calls:** **`ArrayStats.`** with nothing after the dot is incomplete—use **`ArrayStats.mean(marks)`** (or pass the right **`int[]`**).

**Does not compile**; fix **`quizMean`** / **`mean`** to call **`ArrayStats`** correctly with a **`double`** return.

---

## eman gul

**Mark: 7 / 15**

**Feedback:**

**`if`:** **`if{(`** is not valid—conditions must be **`if (condition)`** with parentheses around a boolean expression, e.g. **`if (data == null)`**.

**Structure:** Put **`sum`**, **`mean`**, **`countAtLeast`** inside **`class ArrayStats`** with proper **`{ }`**.

**Does not compile**; fix **`if`** syntax first, then the rest of the class.

---

## jahanzaib .

**Mark: 9 / 15**

**Feedback:**

**Wrong values:** For an **empty** array, **`mean`** must return **`-1.0`**, not **`0.0`** (your run shows **`0.0`** for those lines).

**Incomplete demo:** Output stops after the first block—**`Ali`**, **`T2`**, and **`Tie`** never print, so steps 4–6 are missing.

**Partial credit:** Steps 1–2 partly run; fix **`mean`** for **`new int[0]`** and add **`StudyPair`** prints to match the task.

---

## m@rw@  kari-m (Marwa Karim).

**Mark: 7 / 15**

**Feedback:**

**Stray `return`:** A **`return`** appears outside any method—usually means a missing **`}`** for **`class ArrayStats`**.

**Parameters:** **`cutof`** needs a type, e.g. **`int cutoff`**.

**Copy:** **`this.marks[]=marks`** is invalid—use **`this.marks = Arrays.copyOf(marks, marks.length);`** or a **`for`**-loop copy.

**Does not compile**; fix class structure, then **defensive copy** in **`QuizRecord`**.

---

## nabia naz

**Mark: 7 / 15**

**Feedback:**

**Placement:** **`static`** methods for **`mean`** appear outside **`class ArrayStats`**—**`class, interface, or enum expected`**.

**Spelling:** **`bull`** should be **`null`** in **`if (data == null)`**.

**Does not compile**; wrap **`ArrayStats`** fully and spell **`null`** correctly.

---

*End of Section B list.*



in class on 21st april
------------------------
naeem, jahanzaib, nanjo, muhammad aslam, fatima raza, anam, inshra, sidra