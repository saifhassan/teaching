# Midterm Lab Exam — Section C — feedback

Marks use **lenient partial credit**. Graders **do not lower your mark only because the code does not compile**. We prioritize **approach**: the right **pieces** (**`ProductSpec`**, **`LineItem`**, **`MiniCart`**, **`Catalog.bySku`**, **`ExamMain`** steps), sensible **formulas** (**qty × unit price**, sum of line totals, **both** lines **≥ 5** for bulk), and **clear intent** when reading your files—even if syntax, filenames, or wiring prevent **`javac`** or a full run.

**Feedback format:** each student has a **mark**, then **Feedback** that lists **errors only** (compile-time, runtime, and spec mismatches)—same style as before, with identifiers in backticks where helpful. There is **no** separate “why this mark” paragraph.

Reference output for a fully correct program (six lines): **`true`**, **`7.5`**, **`8.0`**, **`15.5`**, **`false`**, **`true`**.

---
## Aamir Hullio

**Mark: 12 / 15**

**Feedback:** **`ProductSpec`** uses package-visible fields **`sku`/`price`** instead of **`private final`** + **`getSku()`** / **`getUnitPrice()`**. **`LineItem`** uses **`total()`** instead of **`lineTotal()`**, **`q<0`** instead of **`qty <= 0`** for the zero-total rule, and **`p.price`** instead of **`spec.getUnitPrice()`**. **`MiniCart`** uses **`total()`** / **`bulk()`** instead of **`subtotal()`** / **`qualifiesForBulk()`**. **`qualifiesForBulk`** (as **`bulk()`**) uses **`> 5`** on both lines, so the **second cart** prints **`false`** (needs **≥ 5**, so **`true`**). **`Catalog.bySku`** for **TB/NT** is fine.

---

## Aamir Raza

**Mark: 8 / 15**

**Feedback:** **`Private`** is invalid Java (must be **`private`**). **`LineItem`** field declarations break parsing. **`MiniCart.java`** has an extra **`}`** / illegal start of expression so the class structure is broken. Multiple cascading errors; **no successful `javac`**.

---

## Aarti hasija

**Mark: 9 / 15**

**Feedback:** **`LineItem`** constructor sets **`qty`** but never assigns **`this.spec`**, so **`spec`** stays **`null`** and **`lineTotal()`** would **NPE** at runtime. **`Catalog.bySku`** treats the literal string **`"null"`** instead of **`sku == null`** for unknown SKUs. **`MiniCart(LineItem, LineItem)`** constructor body is **empty**, so **`lineA`** / **`lineB`** are never assigned—**NPE** in **`subTotal()`**. **`ExamMain`** calls **`new MiniCart()`** with **no arguments** (constructor requires **two** **`LineItem`**s)—**compile error**. Second cart demo is unfinished (**`m2`** unused).

---

## Abdul Hayee Memon

**Mark: 7 / 15**

**Feedback:** **`ProductSpec.java`** (or embedded code) calls **`lineTotal()`** as if it lived on **`MiniCart`** (**`sum += lineTotal()`**—wrong target). **`ExamMain`** references **`Catalog.bySku`** but **`Catalog`** is **not in scope** (missing import / wrong file / wrong nesting). **Cannot run** the required six-line demo.

---

## Abdul Rauf

**Mark: 8 / 15**

**Feedback:** **`thislinb = linb`** uses an undefined name **`thislinb`** (typo for **`this.lineB = lineB`** or similar). **`javac`** reports **cannot find symbol** for **`thislinb`**. Rest of submission not verifiable.

---

## Abdullah Haris

**Mark: 9 / 15**

**Feedback:** **`Catalog`** maps **`"TB"`** to **3.0** instead of **2.5**. **`main`** uses quantities **4** and **3**, so output is **`10.0`**, **`12.0`**, **`22.0`**—not **`7.5`**, **`8.0`**, **`15.5`**. **`qualifiesforbulk`** uses **`>`** not **≥** and **second cart / second bulk print** are **missing** from **`main`**. Class is **`main`** in **`main.java`** (run **`java main`**, not **`Main`**). **Naming** (`productspec`, `lineitem`, `minikart`, `bysku`) diverges from the sheet.

---

## Ali Aswad

**Mark: 15 / 15**

**Feedback:** **`Main`** builds **`LineItem`** with **`new ProductSpec("TB",2.5)`** / **`NT`** instead of **`Catalog.bySku("TB")`** / **`"NT"`** for those lines—prices match, but it **sidesteps the catalog** for the demo. **`subTotal()`** vs **`subtotal()`** is fine if consistent. Otherwise **bulk** and **line totals** align with the reference.

---

## Arslanali Shaikh

**Mark: 8 / 15**

**Feedback:** **`subtotal()`** / **`qualifiesForBulk`** use **`lineA`** and **`LineB`** but **`lineA`** is not a field (or **`LineB`** vs **`lineB`** casing breaks). **`LineTotal()`** capitalization vs **`lineTotal()`**. **No runnable demo.**

---

## Asad Ali

**Mark: 7 / 15**

**Feedback:** **`public class ExamMain`** must be in **`ExamMain.java`**, not **`OOP LAB EXAm.java`**. **`Catalog`** (or return path) has **`incompatible types: String cannot be converted to double`** around **`new ProductSpec("TB", 2.5)`**—**`bySku`** signature / return type misdeclared. **Cannot run.**

---

## Atiqa Nadeem

**Mark: 10 / 15**

**Feedback:** Entry class is **`exam`** (run **`java exam`**). Uses **`Line`** instead of **`LineItem`**. **`System.out.println(p)`** prints **`null`** (reference type) instead of **`System.out.println(p == null)`** → **`true`**. **`qualifiesForBulk`** only checks **`lineA.getqty() >= 5`** and ignores **`lineB`** (needs **both ≥ 5**). Output has **seven** values (**`… false 35.0 true`**): the **`35.0`** is the **second cart’s subtotal**, but the exam asked for **six lines** in a fixed order (**first** subtotal **15.5**, then **false**, then **second cart bulk true**—not an extra middle subtotal in place of the second bulk step).

---

## Faisal kareem Farman Ali

**Mark: 5 / 15**

**Feedback:** **`productSpec(...)`** without **`class`** / return type (invalid method declaration). **Missing semicolons** after assignments. **`int getQty()(`** malformed. **Multiple parse errors** from top of **`ExamMain.java`**. **Rubric:** **0–1** parts at best from intent.

---

## Faryal Channa

**Mark: 8 / 15**

**Feedback:** **`if(sku.equals"TB")`** must be **`sku.equals("TB")`**—missing **`(`** and **`"`** placement. **Cascade of parse errors** after that line.

---

## Hadia Jawed

**Mark: 9 / 15**

**Feedback:** **`Catalog.bysku`**: for **`"TB"`** / **`"NT"`** you create **`ProductSpec`** locals but never **`return`** them, then fall through to **`return null`**—so **`Catalog.bysku("TB")`** and **`("NT")`** are **`null`**. **`LineItem.lineTotal`** then **NPE**s on **`spec.getUnitPrice()`**. **`main`** uses **`new LineItem(p3, 3)`** for the NT line—should be **qty 2** for the reference **8.0**. **`main`** stops after first cart—no second **`MiniCart`** with quantities **6** and **5**. First line prints **`True`** string from an **`if`**—not the required raw **`println(p == null)`** pattern alone.

---

## Husnain Hyder

**Mark: 8 / 15**

**Feedback:** **`public class ExamMain`** must be in **`ExamMain.java`**, not **`Exam.Main.java`**. **`return Sku`** should be **`return sku`** (field name / case). **`MiniCart`** return line references **`lineA`** / **`lineB`** incorrectly. **No runnable program.**

---

## Jawad Abbasi

**Mark: 7 / 15**

**Feedback:** **`return0 .0`** is not **`return 0.0;`** (space/tokenization). **Fixing one line** may expose further issues; **demo not runnable.**

---

## Kamran Gul

**Mark: 15 / 15**

**Feedback:** First line prints **`True`** with capital **T**; numerically **`7.5`**, **`8.0`**, **`15.5`**, **`false`**, **`true`** match. Otherwise aligns with the spec.

---

## Kirshna Rai

**Mark: 7 / 15**

**Feedback:** **`Final`** must be **`final`**. **Identifiers and `;`** errors on **`private Final String sku`** and following lines. **Little or no verifiable working code.**

---

## Maryam Shaikh

**Mark: 7 / 15**

**Feedback:** **`Assigmnet.java`**: **`else if(sku.equals("TB")`** missing closing **`)`**; **`System.out.println(p);`** lines mangled (**`<identifier> expected`**). **EOF** / **`)`** issues. **Cannot run.**

---

## Masroor Ahmed

**Mark: 12 / 15**

**Feedback:** **`public class ExamMain`** must be in **`ExamMain.java`**, not **`lab-023-25-0163.java`**. Java requires **filename = public class name**. **No class file** for grader to run.

---

## Mehak Sajjad

**Mark: 6 / 15**

**Feedback:** **`ProductSpec (String sku, double unitPrice){`** without **`class ProductSpec`** wrapper (invalid). **`private ProductSpec = spec;`** invalid field syntax. **Reached end of file while parsing**—unclosed braces. **No demo.**

---

## Mehjabeen Shaikh

**Mark: 8 / 15**

**Feedback:** **`p.Catalog()`** treats **`Catalog`** as instance method on **`ProductSpec`**. **`Catalog.bySku("TB", 3)`** passes **two** arguments—spec requires **`bySku(String)`** only. **`Catalog.bySku`** method missing **`return`** in a branch (**missing return statement**). **Multiple errors.**

---

## Mudasar Hussain Memon

**Mark: 7 / 15**

**Feedback:** **`public String getSku{`** missing **`()`** and body **`{ return … }`**. Same for **`getUnitPrice`**. **`this.productspec spec = productspec spec`** is not a valid declaration. **Cannot compile or run.**

---

## Muhammad Ali Hyder

**Mark: 8 / 15**

**Feedback:** **`MiniCart(l1,l2)`** missing **`new`** (interpreted as method call on **`ExamMain`**). **`MiniCart.subtotal()`** / **`qualifiesForBulk()`** called **statically**—methods are **instance** methods. **`qualifiesForBulk()`** without object. **No working cart demo.**

---

## Muhammad Hasnain

**Mark: 15 / 15**

**Feedback:** Possible minor naming/casing differences vs sheet; **functionally correct** on catalog, line totals, subtotal, bulk, second cart.

---

## Muhammad Mujeeb Narejo

**Mark: 10 / 15**

**Feedback:** **`public class void main(String[] args)`** is illegal (**`void`** cannot follow **`class`**). **EOF while parsing**—file/class structure broken. **No entry point.**

---

## Muhammad Safdar

**Mark: 7 / 15**

**Feedback:** **`classs Catalog`** typo (**`class`**). **`ProductSpec getSku(){`** appears **without proper class wrapper** / **extra braces** (**`class, interface, or enum expected`**). **Multiple files** fail together. **No run.**

---

## Muhammad Sajan

**Mark: 10 / 15**

**Feedback:** **Reached end of file while parsing** near line **96**—unclosed block, unfinished **`main`**, or truncated file. **Cannot execute.**

---

## Muhammad Zeeshan

**Mark: 8 / 15**

**Feedback:** **`static ProductSpec_bySku(String sku)`** invalid (**missing return type `ProductSpec`**, illegal name). **`else if(sku.equals("TB"){`** missing **`)`**. **`return new ProductSpec("TB", 2.5)`** missing **`;`**. **`LineItem.java`** also reports errors. **No demo.**

---

## Nitesh Kumar

**Mark: 8 / 15**

**Feedback:** **`doublue`** is not a type (should be **`double`**). **`LineItem m1 = LineItem(...)`** missing **`new`**. **`getqty()`** vs **`getQty()`** casing if used. **No successful build.**

---

## Om Parkash

**Mark: 15 / 15**

**Feedback:** **`subTotal()`** vs **`subtotal()`**—acceptable if consistent. **Otherwise full credit.**

---

## Owais Ali

**Mark: 8 / 15**

**Feedback:** **`p.Catalog.bySku`**—**`Catalog`** is not a field on **`ProductSpec`**. **`new LineItem("TB",3)`** passes **`String`**—constructor needs **`(ProductSpec, int)`**. **`l.Catalog.bySku`** same mistake. **OOP wiring** incorrect throughout.

---

## Rajveer Oad

**Mark: 7 / 15**

**Feedback:** **`Private`** typo. **`ProductSpec("TB", 2.5){`** appears without **`new`** / **`class`** context (**invalid method declaration** / **illegal start of type**). **Multiple errors.**

---

## Rehan Memon

**Mark: 12 / 15**

**Feedback:** **`CheckoutDemo`** instead of **`ExamMain`**; **`Store`**, **`CartItem`**, **`SmallCart`**, **`checkBulk()`** instead of **`Catalog`**, **`LineItem`**, **`MiniCart`**, **`qualifiesForBulk()`**. **`ProductSpec`** fields not **`private final`** with getters. **`checkBulk`** uses **`> 5`** for **both** lines → last line **`false`** (should **`true`** at qty **6** and **5**). **`CartItem.getTotal`** uses **`if(amount < 0)`** instead of **`<= 0`**.

---

## Rubab Bhutto

**Mark: 6 / 15**

**Feedback:** **`public double(double unitPrice)`** invalid getter/constructor syntax. **`public subtotal()`** missing return type **`double`**. **`else false;`** not a valid statement alone. **Illegal start of type** later. **No runnable code.**

---

## Sarmad Ali

**Mark: 7 / 15**

**Feedback:** **`class LineItem(ProductSpec spec,int qty){`** is not Java (constructors belong **inside** a **`class LineItem { … }`**). **EOF / extra **`}`** at end. **Cannot run.**

---

## Sarmad Khuhro

**Mark: 7 / 15**

**Feedback:** **`ProductSpect(String sku, double unitPrice){`** missing **`class`** keyword / class name. **EOF while parsing**—file structure incomplete. **No compile.**

---

## Shahar Bano Laghari

**Mark: 8 / 15**

**Feedback:** **`LineItem lineTotal(lineItem line)`**—**`lineItem`** type undefined / wrong casing. **`lineA.lineTotal(lineA)`**—**`lineTotal()`** takes **no** parameters. **Subtotal logic** wrong at signature level.

---

## Shahzaib khattak

**Mark: 11 / 15**

**Feedback:** **`if (sku==null) {return null`** missing **`}`** / **`;`**. **`If`** capitalized—Java is case-sensitive. **`If sku.equals`** missing **`(`** around condition. **Basic syntax** failures.

---

## Shahzeen Bahram

**Mark: 7 / 15**

**Feedback:** **`this.qty=qty`** missing **`;`**. **`MiniCart(...)`** line missing **`class MiniCart`**. **`if sku.eqauls("TB")`** missing **`(`** and typo **`eqauls`**. **Multiple fundamental errors.**

---

## Sharjeel Ahmed

**Mark: 8 / 15**

**Feedback:** **`if (sku is null)`** is not valid Java (use **`sku == null`** or **`Objects.isNull`**). **Parser errors** cascade. **`Catalog.bySku`** cannot be demonstrated.

---

## Shoaib Ahmed

**Mark: 8 / 15**

**Feedback:** **`new MiniCart(13, l4)`**—first argument **`int`** where **`LineItem`** is required (e.g. a second **`LineItem`** with **`Catalog.bySku("TB")`** and qty **6**). **Type mismatch** stops **`javac`.**

---

## Subhan Ali Dino

**Mark: 8 / 15**

**Feedback:** **`lineTotal() = this.lineA + this.lineB`**—cannot assign to **`lineTotal()`**; **`MiniCart`** should sum **`lineA.lineTotal() + lineB.lineTotal()`**. **`LineItem + LineItem`** invalid for **`+`**. **Wrong model of behavior.**

---

## Tofeeque Ahmed

**Mark: 6 / 15**

**Feedback:** **`exam.java`** **EOF while parsing** at closing **`}`**—missing opening brace earlier or extra **`}`**. **Incomplete submission** from compiler’s view.

---

## Yasir ali

**Mark: 6 / 15**

**Feedback:** **`thiis.unitprice;`** typo **`thiis`**. **`this.spec!=null;`** and **`this.lineA!=null;`** are not used inside **`if`** / assignment—**not a statement** in isolation. **Multiple “not a statement”** errors.

---

## Zara bibi

**Mark: 10 / 15**

**Feedback:** Prints **labels** (**`p==null`**, **`Line item Total :`**) instead of **raw six values**; first line should be boolean **`true`**, not the string **`p==null`**. **`qualifiesforBulk`** uses **bitwise **`&`** on quantities** (**`6 & 5`** → **4**) instead of **logical **`&&`** with **≥ 5** on each line—so second bulk stays **`false`**. **`Subtotal new : 35.0`** is an **extra** styled line; reference expects **`true`** for second bulk after **`15.5`** / **`false`**.

---

## Zohaib Ahmad

**Mark: 7 / 15**

**Feedback:** **`return true`** missing **`;`**. **`System.out.println(p==null)`** breaks because earlier syntax errors confuse the parser (**`<identifier> expected`**). **Whole **`main`** block** unreliable until earlier methods fixed.

---

## awais ghani

**Mark: 12 / 15**

**Feedback:** **`public class ExamMain`** in **`mawais.java`**—must rename file to **`ExamMain.java`** or remove **`public`**. **1 error** stops **`javac`.**

---

## muhammad naeem

**Mark: 8 / 15**

**Feedback:** **`Private ProductSpec spec`**—invalid keyword. **`Private LineItem lineA`**—same. **Multiple parse errors** on **`Test.java`.**

---

## nighat kurio

**Mark: 8 / 15**

**Feedback:** **`return unitPrice`** where **`String`** expected (**incompatible types: double cannot be converted to String**). **`qty * spec.getUnitPrice()`**—**`getUnitPrice()`** returns **`String`** in this code—**cannot multiply**. **`return true;`** in wrong place (**unexpected return value**). **Core types** wrong for **`LineItem`**.

---

*BS (CS/SE/AI)–II · Section C · 8 April 2026 · 45 min*

