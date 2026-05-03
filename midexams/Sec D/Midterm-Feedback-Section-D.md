# Midterm Lab Exam — Section D — feedback

Marks use **lenient partial credit**. Graders **do not lower your mark only because the code does not compile**. We prioritize **approach**: the right **classes** (**`Point`**, **`Box`**, **`HitTester`**), **`distanceTo`** (Euclidean / **`-1.0`** for **`null`**), inclusive **`contains`**, **`where`** string patterns, and **`ExamMain`** steps—even if syntax or wiring prevents **`javac`** or a full run.

**Feedback format:** each student has a **mark**, then **Feedback** that lists **errors only** (compile-time, runtime, spec mismatches)—same detail as before. The **mark** reflects **generous** credit for that approach, **not** a deduction per error line.

---

## Abdul Qadeer

**Mark: 9 / 15**

**Feedback:** Method is named **`distanceToP`** but **`main`** calls **`distanceTo`**, and the **`if (other != null)`** branch has an empty **`return`**. **`legft`** typo in **`Box`** constructor; **`p.getY`** missing **`()`**; **`contains`** uses strict **`<`** so boundary points fail (spec: **inclusive**). **`if(area.contains(p)`** missing **`)`**; strings are **`zoneName + "inside"`** instead of **`"inside " + zoneName`**. **`ExamMain`** uses **`where(p3)`** / **`distanceTo(p3)`** without **`ht.`** / **`p3.`**, **`point`** wrong case, and never calls **`distanceTo(null)`**.

---

## Abdul Wasio

**Mark: 7 / 15**

**Feedback:** **`distanceTo`** uses **`other.getX`** / **`getY`** without **`()`** (and **`this.geY`** typo), so it does not compile. **`Box.contains`** repeats the same **`getX`/`getY`** mistake. **`zoneName`** should be **`private`**; **`where`** overwrites **`zoneName`** and returns only **`"Inside"`** / **`"outside"`**, not **`"inside " + zoneName`**. **`ExamMain`** passes **`"inside "`** as the zone label instead of **`"Panel"`**.

---

## Anand kumar

**Mark: 7 / 15**

**Feedback:** Typos **`ths.y`**, **`reurn`**; invalid **`if(other==null;)`**; **`sqrt`** not **`Math.sqrt`**; **`contains`** compares with **`==`** and stray **`lef+width`** expressions. **`where`** missing space before **`zoneName`** on outside. **`Point 2`** invalid name; **`new HitTester("Panel")`** missing **`Box`**; **`distnace`**, **`:"+`**, broken **`println`**. Does not compile.

---

## Ayesha Imran

**Mark: 7 / 15**

**Feedback:** **`distanceTo`** uses **`Maths.sqrt`** (wrong class) and treats **`(0,0)`** as null-like; **`Box`** constructor missing closing **`}`** before **`contains`**. **`HitTester`** assigns **`this.name`** but field is **`zoneName`**; **`(if area != 0.0)`** is invalid syntax. **`where`** uses **`"Inside"`** + **`zoneName`** without required leading space pattern. **`main`** incomplete (no **`HitTester`** demo). Does not compile.

---

## Bharat Kumar

**Mark: 9 / 15**

**Feedback:** Runs, but **`contains`** uses **`>`** for **`left`**/**`top`**, so points **on** the left/top edges are **outside** (should be **inclusive**). **`where`** returns **`"Outside" + zoneName`** with **no space** before **`Panel`**; **`"Inside "`** has wrong capital **I**. **`distanceTo(null)`** returns **`-1`** (int) not **`-1.0`**; **`main`** adds extra text instead of raw values only.

---

## Dilawar Mahar

**Mark: 7 / 15**

**Feedback:** Uses non-Java types **`other`**, **`^`** for power, **`distaneto`**; **`]`** before **`this.height`**; **`HitTester`** line is not a class body; **`println`** has **`);)`** extra paren. **`distanceTo`** not **`distanceTo`** on **`point`**. Does not compile.

---

## Faqeer Bilal Ahmed

**Mark: 7 / 15**

**Feedback:** **`distanceTo`** uses **`sqrt` of sum of deltas**, not **`sqrt(dx²+dy²)`**. **`Box.contains`** written as one invalid line: **`p.getX`** without **`()`**, missing **`y`** range, no method braces. **`Box`** default constructor hard-codes box; no **`HitTester`**, no **`ExamMain`** task. **`Point`** has a **`main`** inside it (wrong structure). Does not compile.

---

## Fiza Naz Arbani

**Mark: 7 / 15**

**Feedback:** **`distanceTo`** assigns **`distance = other`** (undefined), no return in non-null branch. **`contains`** second line uses **`p.getX()`** vs **`top`** and broken **`<=`**. Class **`HiTester`** not **`HitTester`**; **`where`** adds **`-`** not required. **`new Box()`** missing arguments. Does not compile.

---

## Hasaan Ahmed

**Mark: 8 / 15**

**Feedback:** Method is **`distance`** not **`distanceTo`**; formula uses **`pow(this.x - other.y, 2)`** for the second term (wrong). **`where`** uses commas: **`"Inside, "`** not **`"inside "`**. Program runs but API and strings do not match the sheet.

---

## Haseeba .

**Mark: 7 / 15**

**Feedback:** **`distancePoint`** not **`distanceTo`**; **`distance = other`** invalid; **`point`** vs **`Point`**; **`this.area != null`** not a valid constructor line; **`Static`** typo; **`P0int`** typo; **`distanceTop`** wrong. **`where`** uses **`-`** extras. Does not compile.

---

## Hira Tabasum

**Mark: 7 / 15**

**Feedback:** Invalid **`private int x, int y`** on one line; **`public class point`** vs **`Point`**; **`point other = g`** duplicates parameter; **`g == null()`** invalid. **`Box`** / **`contains`** fragments outside class; **`sqrt.pointp`** nonsense. **`main`** assigns private fields from outside. Does not compile.

---

## Kishor Kumar

**Mark: 7 / 15**

**Feedback:** **`distanceTo`** may not return in all paths; null check after using **`other`** would NPE if fixed order. **`contains`** uses **`widht`** typo and strict **`>`** for **`left`/`top`**. Types **`point`** vs **`Point`**. **`main`** uses **`b`** undefined instead of **`f`** for **`HitTester`**. Does not compile.

---

## Laraib Mughal

**Mark: 7 / 15**

**Feedback:** **`Point.distanceTo`** is not **`public`** and uses **`other.x`** / **`other.y`** instead of **`getX()`** / **`getY()`**. **`Box.contains`** starts with **`if (p != null) return false;`**, so the inclusive bounds check is **unreachable** ( **`javac`**: unreachable code) and the **`p == null`** path has **no `return`**. **`HitTester`** field **`ZoneName`** and method **`Where`** should match **`zoneName`** / **`where`**; return strings must be **`"inside " + zoneName`** and **`"outside " + zoneName`**, not **`"inside"+`** / **`"outside"+`**. **`ExamMain`** has **`System.out.println`** and **`new`** at **class body** level—there is **no `public static void main(String[] args)`**. **`new HitTester("panle" + box)`** is one **`String`** argument (**`"panle"`** typo, **`box.toString()`**), not **`new HitTester("Panel", box)`**. Demo stops after **`where`** for **`(15,18)`**: missing **`Point (5,18)`** + **`where`**, and **`println`** of **`distanceTo(null)`** from **`(15,18)`** (**`-1.0`**). Does not compile (**`Laraib Mughal/ExamMain.java`**).

---

## Maqsood Lutuf

**Mark: 14 / 15**

**Feedback:** **`Point`**, **`Box`**, **`HitTester`**, and **`main`** logic match the exam (distance, inclusive **`contains`**, **`"inside "` / `"outside "`**, **`distanceTo(null)`**). **`public class ExamMain`** must live in **`ExamMain.java`** (or remove **`public`**) — otherwise **`javac`** fails on filename.

---

## Muhammad Bilal Soomro

**Mark: 7 / 15**

**Feedback:** Broken **`import`**, **`sqrt`** not **`Math.sqrt`**, incomplete parentheses. **`contains`** returns **`true`** for any non-null point first line; **`y`** test uses **`left`/`width`** wrongly. Duplicate **`where`** and English text pasted as code (em dash). **`ExamMain`** calls **`p3.where()`** — **`Point`** has no **`where`**. Does not compile.

---

## Muhammad Moiz Shaikh

**Mark: 7 / 15**

**Feedback:** **`distanceTo`** uses **`sqrt(dx + dy)`** not Euclidean. **`contains`** uses **`p == null &&`** with **`getX()`** (wrong / NPE). **`where`** omits space before **`Panel`**. **`main`** uses **`"panel"`** and stops before printing **`where`** lines. Does not compile.

---

## Muhammad Okasha

**Mark: 7 / 15**

**Feedback:** **`Private`** wrong case; **`private int x, int y`** invalid on one line; **`if(other=null)`** should **`==`**; **`(math.sqrt...)^2`** invalid Java. **`getX`/`getY`** without **`()`** in **`contains`**. **`where`** returns **`"Exactly"+zoneName`**. **`main`** prints **`distanceTo(p1)`** instead of **`distanceTo(null)`**. Does not compile.

---

## Muhammad Shoaib

**Mark: 7 / 15**

**Feedback:** **`getX`/`getY`** declared **`void`** but **`return`** int; **`distanceTo`** missing **`double`** return type; **`this.point`** garbage lines. **`contains`** has broken **`if`** parentheses and wrong null logic. **`HitTester`** constructor missing **`area`** assignment. **`where`** strings are not the required pattern. **`new HitTester()`** missing arguments. Does not compile.

---

## Mujtaba Mujtaba

**Mark: 7 / 15**

**Feedback:** **`getX`/`getY`** missing return types; **`if(other = null)`** assignment; **`sqrt`** not **`Math.sqrt`**; **`this.left = int left`** invalid. **`contains`** uses **`getY`** without **`p.`**; **`where`** empty. **`main`** duplicated **`public static`**, **`Point(15,18)`** without **`new`**, **`HitTester`**, **`p2`** undefined. Does not compile.

---

## Muneeb Ur Rahman

**Mark: 7 / 15**

**Feedback:** Class **`point`** vs **`Point`**; **`this,y=y`**; **`-1,0`** invalid; **`cdsother`**; **`Math.squared`**; **`publlic`**; **`Top`** vs **`top`**; **`contains`** returns **`false`** when **`p != null`** (inverted). **`HitTester`** assigns **`Zonename`** to itself; **`contain`** vs **`contains`**; **`Where`** vs **`where`**. **`ExamMain`** **`ditanceTo`**, missing **`;`**, **`"panel"+ box`** concatenation wrong. Does not compile.

---

## Muqadas Rahoojo

**Mark: 7 / 15**

**Feedback:** **`Math.other`** does not exist; distance uses **`getY()`** where **`getX()`** needed in one term. **`contains`** uses **`||`** / **`)`** logic wrong. **`where`** uses **`"Inclusive"`** + wrong **`ZoneName`** field casing. **`println(ht.where(p))`** — **`p`** undefined (**`p3`**/**`p4`**). **`distanceTo(p3)`** should be **`distanceTo(null)`**. Does not compile.

---

## Muqaddas Laghari

**Mark: 7 / 15**

**Feedback:** **`root`** undefined; **`return double(area)`** invalid; **`distanceTo`** uses **`other`** before null check (NPE risk). **`contains`** uses **`||`** where **`&&`** is needed for inside rectangle. **`where`** strings are **`"inside"` + `" "`** (ok) but **HitTester** closing brace duplicates **`}`** breaking structure. **`main`** prints **`distanceTo(p3)`** not **`null`**. Mostly does not compile / wrong logic.

---

## Muzamil Hussain

**Mark: 7 / 15**

**Feedback:** Invalid fields **`private int x,int y`**; **`int ss *=`** / **`mm *=`** illegal; **`other`** used as number. **`Box`** **`contains`** always returns true; **`getx`**/**`gety`** use **`p`** undefined outside method. **`HitTester`** empty constructor; **`cc`** calls **`contains()`** with no args; **`return "0"`** missing **`;`**. **`point`** vs **`Point`** in **`main`**. Does not compile.

---

## Nadia Hassan

**Mark: 8 / 15**

**Feedback:** **`distanceTo`** is **`static`** but uses **`x1`/`x2`** undefined; **`sqrt`** not **`Math.sqrt`**. **`contains`** returns **`true`** for any non-null **`p`** first; **`y`** bounds wrong. **`where`** is **`static`** but uses **`area`**. **`new HitTester`** missing **`(...)`**. **`HitTester.where(15,18)`** wrong call. Does not compile.

---

## Naiha Mirani

**Mark: 7 / 15**

**Feedback:** **`distanceTo`** non-null branch empty; **`ths`**/**`heght`** typos; **`f(`** typo for **`if`**. **`Box`** class not closed before **`HitTester`**. **`new HitTester`** without parentheses; **`Box`** constructor given **5** ints once. **`Sysytem`**, **`Main`** capital. Does not compile.

---

## Neelofar Memon

**Mark: 7 / 15**

**Feedback:** **`gety`** after **`getx`** missing braces; **`dy`** undefined in **`distanceTo`**; **`math`** lowercase; **`lleft`** typo; **`private box`** constructor. **`where`** / **`exammain`** sit outside **`hittester`**; **`string`** lowercase; **`tester= new tester=`** typo. Does not compile.

---

## Nisar Ahmed

**Mark: 15 / 15**

**Feedback:** Output matches the task (**`5.0`**, **`inside Panel`**, **`outside Panel`**, **`-1.0`**). **`Box`** fields are package-private, not **`private`**. **`main`** class name **`MidExam`** instead of **`ExamMain`** (minor).

---

## Sania Ilyas

**Mark: 7 / 15**

**Feedback:** **`distanceTo`** uses **`x1`/`x2`** undefined; **`^`** not Java power. **`!==`** invalid; **`contains`** uses **`||`** / missing **`()`** on **`getX`**. **`new HitTester(b1)`** missing **`"Panel"`** and **`point`** vs **`Point`**. **`main`** prints wrong distance pair. Does not compile.

---

## Sarmad Habib

**Mark: 10 / 15**

**Feedback:** Runs, but **`contains`** uses **`<`** / **`>`** strictly, excluding **boundary** points (spec: **inclusive**). **`where`** prints **`"Inside "`** / **`"Outside "`** with **capital** letters, not **`"inside "`** / **`"outside "`**. **`getX`/`getY`** are package-private, not **`public`**.

---

## Shahnila .

**Mark: 7 / 15**

**Feedback:** **`distanceTo`** uses **`sqr1 - sqr2`** under sqrt — should be **sum** of squares. **`contains`** uses **`||`** for x-range (wrong; need **and**). **`where`** casing **`"Inside "`** / **`"Outside "`** vs spec. **`public class Main`** in **`Main.java`** is OK; last line **`p4.distanceTo(p3)`** should be **`p3.distanceTo(null)`**. Compiles but logic/strings wrong.

---

## Shahzaib Khan

**Mark: 7 / 15**

**Feedback:** **`pubic`**, garbled **`for`** / **`int ss *=`**, **`point`** vs **`Point`**. **`Box`** **`area()`** invalid. **`private zoneName`** missing type. **`HitTester`** sets **`area=0.0`**. **`new HitTester`** missing args; **`tester`** undefined in **`main`**; **`println()`** empty. Does not compile.

---

## Sumair Muhmammad

**Mark: 7 / 15**

**Feedback:** **`Point`** class missing closing **`}`** before **`Box`**. **`distanceTo`** returns only dx; **`contains`** uses **`getx`**, **`left.width`**, **`>= top + height`** wrong. **`where`** missing **`}`** after **`else`**. **`point`**/**`Hittester`**/**`system`** case errors. Does not compile.

---

## Syed Mubashir

**Mark: 7 / 15**

**Feedback:** **`distanceTo`** null branch backwards (**`-1.0`** in wrong branch); **`math`** lowercase; **`x.x`**. **`class Box()`** invalid; getters without types/returns nested inside **`Box`**. **`top=height`** in **`contains`**; **`esle`** typo. **`Main`** wrong signature; **`HitTester =`** invalid. Does not compile.

---

## TAIBA FATIMA

**Mark: 7 / 15**

**Feedback:** Getters take **`(int x)`** shadowing; **`distanceTo`** missing **`else`** attach; **`sqrt`**, **`x1`/`x2`** undefined. **`contains`** compares **X** to **`top`**; **`!null`**; **`area = !null`**. **`Labexam`**; **`p2`**/`**p3`** case typos; **`p3.where`**, **`HitTester()`** on **`Point`**. Does not compile.

---

## Varsha karera

**Mark: 7 / 15**

**Feedback:** **`x1`/`x2`** undefined; **`contains`** inequalities reversed (**`<=left` **and** `>=left+width`** together impossible). **`where`** **`static`** with **`area`**; **`equals(zoneName)`** wrong. **`zonename`** typo; **`system`** lower case; **`main`** not **`static`**, code at class level. Does not compile.

---

## Wadhoo Mal

**Mark: 7 / 15**

**Feedback:** **`math`** should **`Math`**; distance formula uses **`other.y-other.x`** (nonsense). **`public class Box`** in **`023-25-0118.java`** — filename must match or drop **`public`**. **`contains`** uses **`right`** but field is **`width`**; **`contains`** missing **`return false`**. **`where`** returns **`"Inside"`** without zone name. **`main`** wrong distance (p3–p4) vs spec. Does not compile.

---

## Waqas ur Rehman

**Mark: 7 / 15**

**Feedback:** Missing **`;`** after **`this.zoneName = zoneName`**. **`contains`** strict inequalities; **`where`** returns **`zoneName + " outside"`** and wrong pattern. **`main`** duplicate **`Point p1`**, no **`distanceTo(null)`**. Does not compile.

---

## Yasir Hussain

**Mark: 8 / 15**

**Feedback:** **`where`** returns **`"inside"`** / **`"outside "`** **without** **`zoneName`**. **`HitTester = hTest =`** invalid assignment; **`p3`** used before declaration; **`distanceTo(p3)`** bare. **`Point`/`Box`** logic otherwise close. Does not compile as written.

---

## Zubida Fraz

**Mark: 7 / 15**

**Feedback:** **`distanceto`**, **`if(other= null)`**, **`sqr`**, incomplete line **`- (this.x- this.y)`**. **`!p null`**, **`getx`**, **`right`** vs **`width`**, chained comparisons invalid. **`where`** missing **`else`** attach; **`stativ`**, **`ptint`**, **`point`**/**`Point`**, **`Box`** constructor missing comma. Does not compile.

---

## shahariyar haider

**Mark: 9 / 15**

**Feedback:** **`public class ExamMain`** must be in **`ExamMain.java`** (or remove **`public`**). **`distanceTO`** name vs **`distanceTo`**. **`contains`** uses **`p == null &&`** with **`getX()`** (wrong); **X** uses **`top+width`** instead of **`left+width`**. **`where`** mixes **`"Inside "`** and **`"outside "`** casing vs spec.

---

*End of Section D list.*
