# Midterm Lab Exam — Section E — feedback

Marks use **lenient partial credit**. Graders **do not lower your mark only because the code does not compile**. We prioritize **approach**: the right **classes** (**`TextUtils`**, **`LineItem`**, **`MemoSheet`**, **`ExamMain`**), **`wordCount`** / **`clip`** behaviour, **indexed slots** and **`setLine`** rules, and the **six task steps**—even if syntax or filenames prevent **`javac`** or a full run.

**Feedback format:** each student has a **mark**, then **Feedback** that lists **errors only** (compile-time, runtime, spec mismatches). Each block is limited to **about five short paragraphs** so you can share it as-is. The **mark** reflects **generous** credit for approach, **not** one deduction per bullet.

**Reference** (fully correct demo): **`2`**, **`ABC`**, **`3`**; then **`setLine`** results **`true`**, **`true`**, **`false`**, **`totalWords()`** **`5`**, **`setLine(5, …)`** **`false`**, bad-capacity **`totalWords()`** **`0`**.

---

## Abdul Qadeer Dayo

**Mark: 6 / 15**

**Feedback:**

**`TextUtils` / `LineItem`:** **`wordCount`** hard-codes **`return 2`** instead of counting words; **`clip`** returns only the first character, not a prefix of length **`maxLen`**, and does not match the **`null`** / **`maxLen`** rules. **`wordsInBody`** always **`0`**.

**`MemoSheet`:** **`setLine`** uses **`index > capacity`** (should be **`>=`** or use array length) and never stores items in an array; **`totalWords`** is hard-coded (**`7`**).

**`ExamMain`:** **`Main`** uses **`public static void main()`** without **`String[] args`**, so the JVM does not treat it as a standard entry point; the demo steps are mostly commented out and not executed.

**Does not demonstrate a runnable exam program** as submitted; align method bodies with the sheet and use **`public static void main(String[] args)`** with the six steps printed.

---

## Abdul Shakoor Mahar

**Mark: 5 / 15**

**Feedback:**

**Syntax:** Many typos (**`reutrn`**, **`prntn`**, **`Private`** instead of **`private`**) and invalid escapes (**`"\a"`** in **`String`**) break **`wordCount`**. **`MemoSheet`** uses **`new (5)`** instead of **`new MemoSheet(5)`**.

**Structure:** **`main`** appears outside a class or after broken braces, so the file does not form valid top-level classes end-to-end.

**Spec:** Even after fixes, you would still need **`wordCount`** / **`clip`** / slot storage as in the task sheet.

**Does not compile** (**`Cassdemo.java`**).

---

## Aisha Noor

**Mark: 5 / 15**

**Feedback:**

**Parsing:** **`String[] str=s.space(" "){`** is not valid Java; classes and methods are not nested correctly, so **`clip`**, **`LineItem`**, and **`MemoSheet`** never compile as written.

**Naming:** Use **`setLine`** (capital **`L`**) and **`boolean`**, not arbitrary spellings, to match the spec.

**Intent:** You were aiming for **`TextUtils`**-style helpers and a memo sheet; partial credit reflects that direction.

**Does not compile** (**`aisha.java`**).

---

## Aleesha Irfan

**Mark: 5 / 15**

**Feedback:**

**Loops:** **`for`** headers use **commas** instead of **semicolons** (**`for(int i=0,i<s.length;i++)`**). Tab checks must use **`'\t'`** (character), not **`\t`** bare in source.

**Keywords / types:** **`Private`** and method declarations inside **`TextUtils`** without **`class`** boundaries cause **illegal start of expression** errors.

**Demo:** The **`LineItem`** constructor call uses invalid syntax with extra parentheses and a third argument.

**Does not compile** (**`Aleesha IRFAN.java`**).

---

## anjlee Lund

**Mark: 5 / 15**

**Feedback:**

**Keywords:** **`Static`** is not Java’s **`static`**; **`for(int =0;…)`** needs a loop variable name (**`int i`**).

**Classes:** **`memosheet`** / **`lineterm`** are used as if they were constructors without **`class`** headers; **`this.body=body`** sits outside a valid type.

**Spec reminder:** After syntax is fixed, implement **`MemoSheet(int capacity)`**, **`setLine`**, and **`totalWords`** with a **`LineItem[]`** (or equivalent).

**Does not compile** (**`ExamMain.java`**).

---

## Arshad Ali

**Mark: 4 / 15**

**Feedback:**

**Typos / types:** **`retrun`**, **`s=" "`** (assignment in **`if`**), **`s.length`** without **`()`**, and **`clip`** returning **`0`** ( **`int`** ) instead of **`String`** break compilation.

**Wrong names:** Class is **`TextUtills`** but **`main`** calls **`TextUtils`**; **`MemoSheet`** uses **`item.length`** and invalid assignments.

**`main`:** Calls like **`TextUtils.wordCount`** and **`setLine(5,item)`** do not match defined APIs.

**Does not compile** (**`Main1.java`**).

---

## Asma shaikh

**Mark: 7 / 15**

**Feedback:**

**`TextUtils`:** A **`static clip`** method is declared **inside** **`wordCount`**’s **`else`** block—that is **illegal** Java; **`wordCount`** then has **no valid `return`** on that path. The outer **`clip`** calls **`s.length()`** **before** **`s == null`**, so **`null`** can cause **`NullPointerException`**; one branch **`return true`** is a **`boolean`**, not **`String`**.

**`LineItem`:** **`wordsInBody()`** is **empty** (missing **`return`**, e.g. **`TextUtils.wordCount(body)`**).

**`ExamMain`:** **`MS.setLine(0, l1)`** uses **`l1`**, which is **not declared**—should use **`IT`** (the **`LineItem`** built above).

**Submission:** Code is in **`asma.txt`**; it must be **`.java`** file(s) (**`ExamMain.java`** etc.) for **`javac`**.

**Does not compile** as pasted.

---

## Azizullah Abbasi

**Mark: 5 / 15**

**Feedback:**

**Syntax:** **`Private`** with capital **`P`** is invalid—Java keywords are **case-sensitive** (**`private`**).

**Impact:** The **`LineItem`** fields do not parse, so the rest of the file cannot compile.

**Next step:** Fix **`private`**, then complete **`TextUtils.wordCount`**, **`clip`**, **`MemoSheet`** slots, and **`ExamMain`** steps.

**Does not compile** (**`submitted by azizullah.java`**).

---

## Daniyal Rafique

**Mark: 12 / 15**

**Feedback:**

**Critical bug:** **`s.split("s+")`** matches the letter **“s”**, not whitespace. Use **`split("\\s+")`**. With the current code, **`wordCount("  hello   world  ")`** prints **`1`** instead of **`2`**, and **`wordsInBody`** / **`totalWords`** are too low.

**Structure:** **`TextUtils`**, **`LineItem`**, **`MemoSheet`**, and **`ExamMain`** are otherwise wired correctly—**`MemoSheet`** uses a **`LineItem[]`**, **`setLine`** rejects **`null`** and bad indices, and the demo order matches the task.

**After fixing the regex**, re-run; you should see **`2`**, **`5`** for **`totalWords()`**, etc.

**Compiles**; runtime output is wrong until **`split`** is fixed.

---

## Eman ul Mumtaz

**Mark: 6 / 15**

**Feedback:**

**Types / syntax:** **`s.charAt(' ')`**, **`string`** vs **`String`**, **`item = new[capacity]`** (need **`new LineItem[capacity]`**), **`item.length()`** on an array (use **`item.length`**), and **`Exam_main` / `Sheet`** naming break compilation.

**Logic:** **`setLine`** assigns **`item = index`**; **`totalWords`** passes the array to **`wordCount`** instead of summing each line’s **`wordsInBody()`**.

**Intent:** You sketched all four roles; credit reflects partial structure.

**Does not compile** (**`Exam_Main.java`**).

---

## Faheem Rasool

**Mark: 14 / 15**

**Feedback:**

**Syntax:** **`if (s.isEmpty()) {return 0};`** has an extra **`;`** before **`}`**, which is invalid.

**Risk:** For **`null`**, **`isEmpty()`** cannot run—guard **`s == null`** first, then trim / empty check, per spec.

**File:** Ensure **`ExamMain`** (or your **`main`**) implements all **six** steps when the file compiles.

**Does not compile** as submitted (**`LABEXAM MID.java`**).

---

## Farman Ali Narejo

**Mark: 14 / 15**

**Feedback:**

**Filename:** **`public class ExamMain`** must live in **`ExamMain.java`**. As **`OOP_Java_LabExam.java`**, **`javac`** reports the public-class / filename mismatch.

**`wordCount`:** Your character loop only treats **space**, not tabs/newlines—acceptable for the printed demo if strings use spaces only; for full spec compliance, use **`trim`** + **`split("\\s+")`** or **`Character.isWhitespace`**.

**Demo strings:** You used **`"Hello World"`** / **`"abcdef"`** instead of the sheet’s exact literals—outputs still match the expected **counts** / **clip** for those choices.

**Compiles** if renamed to **`ExamMain.java`**; logic is largely correct.

---

## farah channa

**Mark: 5 / 15**

**Feedback:**

**Loops / tokens:** Same pattern as other submissions—**`for`** with **commas**, invalid **`\t`**, **`Private`**, and demo lines pasted **outside** **`main`** as bare statements.

**Structure:** **`TextUtils`**, **`LineItem`**, **`MemoSheet`** need clear **`class { … }`** blocks with **`static`** methods only inside **`TextUtils`**.

**Does not compile** (**`ExamMain.java`**).

---

## Fatima memon

**Mark: 7 / 15**

**Feedback:**

**Calls:** **`MemoSheet ms=MemoSheet(3,arr)`** should be **`new MemoSheet(3)`**; compare **`String`** with **`.equals`**, not **`==`**.

**API:** Use **`substring`**, not **`subString`**; **`MemoSheet`** needs a **`LineItem[]`** field, not undefined **`lineItem`** / **`indexed`**.

**Intent:** Multiple ideas (**`clip`**, slots) appear; partial credit for structure.

**Does not compile** (**`ExamMain.java`**).

---

## Ghulam Zainab

**Mark: 7 / 15**

**Feedback:**

**Types:** **`string`** must be **`String`**; **`s.length`** on a **`String`** is **`s.length()`**; **`clip`** must compare lengths numerically, not **`maxLen > s`**.

**`MemoSheet`:** Constructor should be **`MemoSheet(int)`** only; **`setLine`** should compare **`index`** to **`lineItem.length`**, not to a **`LineItem`**.

**`totalWords`:** Sum instance **`wordsInBody()`** on stored items, not **`LineItem.wordsInBody()`** statically.

**Does not compile** (**`ExamMain.java`**).

---

## Haseebullah Mahar

**Mark: 15 / 15**

**Feedback:**

**`TextUtils`:** **`trim`**, **`split("\\s+")`** for **`wordCount`**; **`clip`** handles **`null`**, **`maxLen ≤ 0`**, and substring correctly.

**`LineItem` / `MemoSheet`:** Fields, getters, **`wordsInBody`** via **`TextUtils`**; array for capacity **`≤ 0`** → length **`0`**; **`setLine`** and **`totalWords`** match the spec.

**`ExamMain`:** All **six** steps print the expected **2**, **`ABC`**, **3**, **`true`/`true`/`false`**, **5**, **`false`**, **0**.

**Compiles and runs**; full credit.

---

## Hira Ghoto

**Mark: 7 / 15**

**Feedback:**

**Inside `MemoSheet`:** **`array = array LineItem[0]`** is invalid; methods like **`boolean setLine(...)`** must be **inside** the class with braces, not floating after broken statements.

**Parsing:** The compiler stops mid-class, so **`ExamMain`** never completes.

**Direction:** You started **`TextUtils`** and a slot-based sheet—partial credit.

**Does not compile** (**`ExamMain.java`**).

---

## Jiveeka Duseja

**Mark: 7 / 15**

**Feedback:**

**Braces:** **`}class end`** suggests a missing **`{`** or an extra **`}`** so **`MemoSheet` / `ExamMain`** do not close properly.

**Fix:** One **`public`** class per file (or non-public classes in one file), matching **`{` … `}`** throughout.

**Does not compile** (**`ExamMain.java`**).

---

## Kareena Kumari

**Mark: 6 / 15**

**Feedback:**

**Step 5:** **`setLine(5, some non-null LineItem)`** in the PDF means a **real `LineItem` object**—English words are not Java identifiers. Use e.g. **`new LineItem("Y","test")`**.

**Rest of file:** If similar issues appear elsewhere, treat the task as code, not prose.

**Does not compile** until **`setLine`** calls are valid Java.

---

## Kashaf Batool

**Mark: 8 / 15**

**Feedback:**

**Fields:** **`memo.line = 0`** treats line numbers as **`int`**s; the sheet should store **`LineItem`** references via **`setLine(0, …)`**, **`setLine(1, …)`**, not **`line2` / `line3`** fields.

**Types:** **`int`** cannot be assigned to **`LineItem[]`**.

**Intent:** **`TextUtils`** / **`MemoSheet`** naming shows you understood the scenario; partial credit.

**Does not compile** (**`ExamMain.java`**).

---

## Kuldeep Dharmani

**Mark: 4 / 15**

**Feedback:**

**Illegal name:** **`class TextUtils.java`** is not a valid class name ( **`.`** not allowed).

**Methods:** **`Static string`** should be **`static String`**; **`getlabel`** / **`getbody`** need return types and **`class LineItem`**.

**Does not compile** (**`ExamMain.java`**).

---

## Luksh Arija

**Mark: 6 / 15**

**Feedback:**

**Arrays:** **`new LineItem[]`** needs a size; **`new LineItem`** is incomplete.

**Demo:** Replace **`setLine(5, some non-null LineItem)`** with a real **`new LineItem(...)`** call.

**Control flow:** **`else` without `if`** at the top of **`wordCount`** needs restructuring.

**Does not compile** (**`main.java`**).

---

## MUBASHIR MUNEER MANGI

**Mark: 4 / 15**

**Feedback:**

**Syntax:** **`TextUtils.clips`**, **`{`** after method calls, **`or`** instead of **`||`**, **`return empty String`**, **`if.null`**, and missing **`;`** lines make the file unparsable.

**Concept:** You attempted **`wordCount`**, **`clip`**, and a capacity-based structure—minimal partial credit.

**Does not compile** (**`ExamMain.java`**).

---

## Muhammad Subaiyal Sadain

**Mark: 15 / 15**

**Feedback:**

**APIs:** **`wordCount`** ( **`null`**, trim, **`split("\\s+")`** ), **`clip`**, **`LineItem`**, **`MemoSheet`** with **`LineItem[]`**, **`setLine`**, **`totalWords`** all match the exam.

**`ExamMain`:** Steps print **2**, **`ABC`**, **3**, **`false`** for **`null`**, **5**, **`false`**, **0**—correct booleans and totals.

**Compiles and runs**; full credit.

---

## Muhammad Uzair Khan

**Mark: 4 / 15**

**Feedback:**

**Structure:** **`setLine`** / loops appear **outside** any **`class`** ( **`class, interface, or enum expected`** ).

**Syntax:** **`line2.setLine()`**, stray **`Lin`**, and broken **`for`** loops prevent compilation.

**Does not compile** (**`Main.java`**).

---

## Muhammad yousif Dahani

**Mark: 4 / 15**

**Feedback:**

**Literals:** **`''`** cannot be empty—use **`Character.isWhitespace`** or **`split`**. **`LineItem[] arr=;`** is incomplete.

**Placement:** Demo **`TextUtils.wordCount(...)`** lines cannot sit inside **`TextUtils`** as raw statements without **`main`**.

**Does not compile** (**`TextUtils.java`** only).

---

## MuhammadArham Shaikh

**Mark: 11 / 15**

**Feedback:**

**`wordsInBody`:** **`return TextUtils.wordCount(body) + 2`** cheats the expected **3**; remove the **`+ 2`** and fix **`wordCount`** to count words ( **`split`** or state machine ), not spaces **`− 1`**.

**`clip`:** Use **`maxLen <= 0`**, not only **`< 0`**, so **`clip(s, 0)`** returns **`""`**.

**`setLine`:** Use **`index < 0 || index >= indexedSlots.length`**, not **`index > indexedSlots.length`**, so index **`0`** works and **`5`** fails on a sheet of **3**.

**`ExamMain`:** You skip printing **`setLine(2, null)`**’s **`false`**; add **`println`** for each step for full demo marks.

**Compiles**; output partly matches by accident (**`wordsInBody`** hack).

---

## Mushahid Hussain Chandio

**Mark: 6 / 15**

**Feedback:**

**Spec names:** The exam requires **`TextUtils.wordCount`** and **`ExamMain.java`** with **`main`**. You implemented **`countWord`** and **`class Main`** with a custom demo (greetings, not the **six** steps).

**Logic:** **`LineItem.wordsInBody`** duplicates counting instead of delegating to **`TextUtils`**—allowed by the sheet (“same definition”), but your **`TextUtils`** helpers are then unused for **`LineItem`**.

**Compiles**, but **does not follow the required filenames, method names, or task steps**.

---

## Muzzamil Hussain

**Mark: 12 / 15**

**Feedback:**

**Filename:** Public **`ExamMain`** must be in **`ExamMain.java`**, not **`EXam mid.java`**.

**Types:** You used **`ExamMain`** instances where the task says **`LineItem`**—behaviour can match, but the exam expected a separate **`LineItem`** type.

**Demo:** You do not **`println`** the **`boolean`** results for **`setLine`** on slots **0**, **1**, and **`null`** at **2**; add those for full **`ExamMain`** marks.

**If renamed and steps printed**, the numeric outputs (**2**, **`ABC`**, **3**, **5**, **0**) match.

---

## Nauman Ali Soomro

**Mark: 8 / 15**

**Feedback:**

**`wordCount`:** Compare **`char`** to **`' ' `**, not **`" "`**; return the **local count variable**, not the string **`"wordCount"`**. **`clip`** must return a **`String`** substring, not **`charAt(0)`**.

**`LineItem`:** Call **`TextUtils.wordCount(body)`**—there is no instance **`wordCount(body)`**.

**`MemoSheet`:** Use **`lineItem.length`**, not **`lineItem.length()`**; **`setLine`** needs **`new LineItem(...)`**, not **`LineItem(...)`** as if it were a static method on **`ExamMain`**.

**Does not compile** (**`ExamMain.java`**).

---

## nandni Daimbra

**Mark: 6 / 15**

**Feedback:**

**Structure:** **`clip`** / classes are not nested correctly (**`illegal start of expression`**). **`Private`** is invalid.

**Syntax:** **`for`** with **`){)`**, mismatched **`println`** parentheses, **`new LineItem(LineItem(...))`** duplicate constructor.

**Does not compile** (**`Nandni daimbra.java`**).

---

## Naveed Akbar

**Mark: 15 / 15**

**Feedback:**

**Implementation:** **`wordCount`**, **`clip`**, **`LineItem`**, **`MemoSheet`** align with the HTML spec; **`setLine`** guards **`null`** and index range; **`totalWords`** sums **`wordsInBody()`**.

**`ExamMain`:** Prints **2**, **`ABC`**, **3**, **`false`**, **5**, **`false`**, **0** in the right order.

**Compiles and runs**; full credit.

---

## Nihaal .

**Mark: 6 / 15**

**Feedback:**

**`wordCount`:** Leading **`else`** without **`if`**; **`for(int =0;…)`** needs **`int i`**.

**`MemoSheet`:** **`f(capacity<0)`** is not valid Java (**`if`**).

**`main`:** **`satic`** → **`static`**.

**Does not compile** (**`ExamMain.java`**).

---

## Nimra Iftkhar

**Mark: 7 / 15**

**Feedback:**

**Structure:** **`static String clip`** appears **outside** **`class TextUtils`** (after a closing **`}`**), so **`clip`** is not a method of **`TextUtils`**.

**`clip` body:** **`s.substring(0, maxLen){`** has an extra **`{`**—should end with **`;`** after **`substring`**.

**Does not compile** (**`ExamMain.java`**).

---

## Sadaqat Ali

**Mark: 5 / 15**

**Feedback:**

**Filename:** **`public class TextUtils`** must be **`TextUtils.java`**, or remove **`public`** from all but one class in a single file.

**Logic:** **`clip`** condition **`maxLen > 0`** returns **`s`** almost always; **`MemoSheet.setLine`** always **`false`**; **`totalWords`** always **`0`**.

**`wordCount`:** Counts spaces, not words; no **`null`** guard.

**Does not compile** as-is; **`LabMidExam`** also omits correct **`ExamMain`** demo.

---

## Sahil Kumar

**Mark: 7 / 15**

**Feedback:**

**Syntax:** **`count++`** needs **`;`** in the **`if`** body.

**Demo:** **`setLine t3 = new setLine(5, some non-null LineItem)`** is not Java—use **`boolean b = m.setLine(5, new LineItem("Y","test"));`** (or similar).

**Does not compile** (**`ExamMain.java`**).

---

## Sakshi Talreja

**Mark: 15 / 15**

**Feedback:**

**`TextUtils` / `LineItem` / `MemoSheet`:** **`split("\\s+")`**, **`clip`** rules, array slots, **`setLine`**, **`totalWords`** all correct.

**`ExamMain`:** Prints **2**, **`ABC`**, **3**, **`true`**, **`true`**, **`false`**, **5**, **`false`**, **0** ( **`MemoSheet(-1)`** for unusable capacity is fine).

**Compiles and runs**; full credit.

---

## Sandeep Kumar

**Mark: 13 / 15**

**Feedback:**

**Missing step:** The task’s **first** step is **`TextUtils.wordCount("  hello   world  ")`** → **2**. Your **`main`** never prints **`wordCount`**—only **`clip`** appears after the banner.

**Order:** You otherwise perform **`clip`**, **`LineItem`**, **`MemoSheet`** lines, **`null`** **`setLine`**, out-of-range **`setLine`**, and zero-capacity **`totalWords`**.

**Compiles and runs**; deduct mainly on **`ExamMain`** completeness.

---

## Sidra Naich

**Mark: 7 / 15**

**Feedback:**

**`clip`:** **`s.substring(0, maxLen){`** has a stray **`{`**.

**`MemoSheet`:** **`item = new [capacity]`** should be **`new LineItem[capacity]`**.

**Structure:** **`static String clip`** may sit outside **`TextUtils`** depending on brace placement—keep all **`TextUtils`** methods inside one **`class TextUtils { … }`**.

**Does not compile** (**`ExamMain.java`**).

---

## Umme Roman Ali

**Mark: 4 / 15**

**Feedback:**

**Comments:** **`\\`** at line start is not a Java comment—use **`//`** or **`/* */`**.

**Syntax:** **`Static`**, **`for`** with commas, **`Memosheet`** vs **`MemoSheet`**, **`TextUtil`**, **`(Memo1.MemoSheet(3))`**, and **`some non-null LineItem`** prose prevent compilation.

**Does not compile** (**`MainExam.java`**).

---

## Ubaidullah Chachar

**Mark: 5 / 15**

**Feedback:**

**`TextUtils`:** **`s.equals(null)`** is wrong; use **`s == null`**. **`s.charAt(i) == "  "`** compares **`char`** to **`String`**. **`textUtils`** vs **`TextUtils`** casing; instance **`count`** with **`static`** methods is inconsistent.

**`MemoSheet`:** **`indexSlots.length()`**, undefined **`i`**, **`s`**, **`wordCount`** in **`totalWords`**.

**Incomplete:** **`LineItem m3 = new LineItem()`** missing **`;`** and constructor args.

**Does not compile** (**`ExamMain.java`**).

---

## Wafa Hussain Kalhoro

**Mark: 5 / 15**

**Feedback:**

**`clip`:** **`maxlen`** vs **`maxLen`** case mismatch; return **`""`**, not **`null`**, per spec.

**`LineItem` / `MemoSheet`:** **`s`** and **`count`** are undefined in **`wordsInBody`**; **`lineItem[]`** / **`new lineItem(...)`** are invalid Java types.

**End of file:** Missing **`}`** and **`return false`** / **`;`** in **`setLine`**.

**Does not compile** (**`TextUtils.java`**).

---

## Waroon Kumar

**Mark: 6 / 15**

**Feedback:**

**Syntax:** Leading **`else`** without **`if`**; **`count ++`** needs **`;`**; **`subtring`** → **`substring`**; **`publiuc`** → **`public`**.

**Demo:** Replace English **`some non-null LineItem`** with **`new LineItem(...)`**.

**Does not compile** (**`Waroon  Kumar OOP LAb Exam..java`**).

---

## Zeeshan Ahmed Kalwar

**Mark: 7 / 15**

**Feedback:**

**Arrays:** **`LineItem[] = new LineItem[max.Integer]`** needs a variable name and **`Math.min`** or **`length`**, not **`max.Integer`**.

**`setLine`:** **`setLine (5, );`** is incomplete—pass a **`LineItem`**.

**Brace matching:** File ends with incomplete **`}`** nesting.

**Does not compile** (**`ExamMain.java`**).

---

## Zulqarnain Mahar

**Mark: 6 / 15**

**Feedback:**

**One file:** Multiple **`public`** classes (**`TextUtils`**, **`LineItem`**, **`MemoSheet`**, **`ExamMain`**) require separate files or only one **`public`** top-level class.

**`MemoSheet.setLine`:** **`if (s == null || index > s.length(); )`** is invalid syntax (**`s`** is wrong here; use slot array **`.length`**).

**Does not compile** (**`ExamMain.java`**).

---

## metai sanandan

**Mark: 6 / 15**

**Feedback:**

**Syntax:** **`count++`** needs **`;`**; **`return for(...)`** is invalid; **`piblic`** typo; **`LineItem l1 new`** missing **`=`**.

**Structure:** **`ExamMain`** closing braces hit **EOF** early.

**Does not compile** (**`ExamMain.java`**).

---

## shiv kirtan

**Mark: 5 / 15**

**Feedback:**

**Arrays:** **`new String[]`** needs a size expression.

**Constructor:** **`MemoSheet(int capacity<0)`** is not valid parameter syntax—use **`if (capacity <= 0)`** inside **`MemoSheet(int capacity)`**.

**Parsing:** Stray **`else`** suggests **`wordCount`** / class structure is broken.

**Does not compile** (**`ExamMain.java`**).

---

*End of Section E combined feedback.*
