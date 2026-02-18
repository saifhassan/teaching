# LaTeX and Overleaf Tutorial - 1 Hour Session

## Table of Contents
1. [Introduction](#introduction)
2. [Getting Started with Overleaf](#getting-started-with-overleaf)
3. [Basic LaTeX Structure](#basic-latex-structure)
4. [Text Formatting](#text-formatting)
5. [Document Structure](#document-structure)
6. [Lists and Environments](#lists-and-environments)
7. [Mathematics](#mathematics)
8. [Tables](#tables)
9. [Figures and Images](#figures-and-images)
10. [References and Citations](#references-and-citations)
11. [Practice Exercises](#practice-exercises)

---

## Introduction

### What is LaTeX?

**LaTeX** (pronounced "LAY-tek" or "LAH-tek") is a document preparation system for high-quality typesetting. It is especially useful for:
- Academic papers and research documents
- Books and reports
- Mathematical and scientific documents
- Theses and dissertations
- Professional presentations

**Why use LaTeX?**
- Professional-looking documents
- Excellent math typesetting
- Automatic numbering and cross-referencing
- Consistent formatting
- Free and open-source

### What is Overleaf?

**Overleaf** is an online LaTeX editor that:
- Works in your web browser (no installation needed)
- Provides real-time collaboration
- Has built-in templates
- Compiles documents automatically
- Stores your projects in the cloud

**Website:** https://www.overleaf.com

---

## Getting Started with Overleaf

### Step 1: Create an Account

1. Go to https://www.overleaf.com
2. Click "Sign Up" (free account)
3. Sign up with email or Google account
4. Verify your email if required

### Step 2: Create a New Project

1. Click "New Project"
2. Choose "Blank Project"
3. Give it a name (e.g., "My First Document")
4. Click "Create"

### Step 3: Understanding the Interface

**Left Panel:** File browser
**Center Panel:** LaTeX source code editor
**Right Panel:** Compiled PDF preview
**Top Bar:** Compile button, download, share options

### Step 4: Your First Document

Replace the default content with:

```latex
\documentclass{article}

\begin{document}
Hello, World! This is my first LaTeX document.
\end{document}
```

Click "Recompile" and see your PDF appear!

---

## Basic LaTeX Structure

### Document Class

Every LaTeX document starts with a document class:

```latex
\documentclass{article}     % For articles
\documentclass{report}       % For reports
\documentclass{book}         % For books
\documentclass{letter}       % For letters
```

**Common options:**
```latex
\documentclass[12pt,a4paper]{article}  % 12pt font, A4 paper
\documentclass[11pt,letterpaper]{article}  % 11pt font, letter size
```

### Document Environment

All content goes between `\begin{document}` and `\end{document}`:

```latex
\documentclass{article}

\begin{document}
Your content goes here.
\end{document}
```

### Preamble

The area between `\documentclass` and `\begin{document}` is called the **preamble**. Here you add:
- Packages
- Custom commands
- Document settings

```latex
\documentclass{article}
\usepackage{graphicx}  % Package for images
\usepackage{amsmath}   % Package for math

\title{My Document}
\author{Your Name}
\date{\today}

\begin{document}
\maketitle
Content here.
\end{document}
```

---

## Text Formatting

### Basic Text Commands

```latex
\textbf{Bold text}
\textit{Italic text}
\underline{Underlined text}
\texttt{Typewriter/monospace text}
\emph{Emphasized text}
```

**Example:**
```latex
This is \textbf{bold} and this is \textit{italic}.
\emph{This is emphasized}.
```

### Font Sizes

```latex
\tiny Tiny text
\scriptsize Script size
\footnotesize Footnote size
\small Small text
\normalsize Normal text (default)
\large Large text
\Large Larger text
\LARGE Even larger
\huge Huge text
\Huge Largest
```

### Text Alignment

```latex
\begin{flushleft}
Left-aligned text
\end{flushleft}

\begin{center}
Centered text
\end{center}

\begin{flushright}
Right-aligned text
\end{flushright}
```

### Line Breaks and Paragraphs

```latex
This is a paragraph. It continues until a blank line.

This is a new paragraph.

This line ends here.\\
This is a new line (forced line break).

This is a paragraph with a \newline line break.
```

---

## Document Structure

### Sections

```latex
\section{Introduction}
Content of introduction section.

\subsection{Subsection Title}
Content of subsection.

\subsubsection{Subsubsection Title}
Content of subsubsection.

\paragraph{Paragraph Title}
Content of paragraph.

\subparagraph{Subparagraph Title}
Content of subparagraph.
```

### Table of Contents

```latex
\tableofcontents  % Generates table of contents automatically
```

### Abstract

```latex
\begin{abstract}
This is the abstract of your document. It provides a brief summary.
\end{abstract}
```

### Complete Example:

```latex
\documentclass{article}
\title{My Research Paper}
\author{John Doe}
\date{\today}

\begin{document}
\maketitle

\begin{abstract}
This paper discusses important topics.
\end{abstract}

\tableofcontents
\newpage

\section{Introduction}
This is the introduction.

\subsection{Background}
Background information here.

\section{Methodology}
Methodology section.

\section{Results}
Results section.

\section{Conclusion}
Conclusion section.

\end{document}
```

---

## Lists and Environments

### Bullet Lists (Itemize)

```latex
\begin{itemize}
    \item First item
    \item Second item
    \item Third item
        \begin{itemize}
            \item Nested item 1
            \item Nested item 2
        \end{itemize}
\end{itemize}
```

### Numbered Lists (Enumerate)

```latex
\begin{enumerate}
    \item First numbered item
    \item Second numbered item
    \item Third numbered item
        \begin{enumerate}
            \item Nested numbered item
        \end{enumerate}
\end{enumerate}
```

### Description Lists

```latex
\begin{description}
    \item[Term 1] Description of term 1
    \item[Term 2] Description of term 2
    \item[Term 3] Description of term 3
\end{description}
```

### Verbatim (Code Blocks)

```latex
\begin{verbatim}
This text will appear exactly as typed,
including special characters: $ % & # { }
\end{verbatim}
```

For inline code:
```latex
Use \texttt{code} for inline code.
```

---

## Mathematics

### Inline Math

Math within text uses single dollar signs:

```latex
The quadratic formula is $x = \frac{-b \pm \sqrt{b^2-4ac}}{2a}$.
```

### Display Math

Math on its own line uses double dollar signs:

```latex
The quadratic formula is:
$$x = \frac{-b \pm \sqrt{b^2-4ac}}{2a}$$
```

Or use `\[` and `\]`:
```latex
\[
x = \frac{-b \pm \sqrt{b^2-4ac}}{2a}
\]
```

### Math Environments

**Equation (numbered):**
```latex
\begin{equation}
E = mc^2
\end{equation}
```

**Equation* (unnumbered):**
```latex
\begin{equation*}
E = mc^2
\end{equation*}
```

**Align (multiple equations):**
```latex
\begin{align}
x + y &= 10 \\
2x - y &= 5
\end{align}
```

### Common Math Symbols

```latex
Greek letters: $\alpha, \beta, \gamma, \Delta, \pi, \theta, \Omega$

Operators: $\sum, \prod, \int, \oint, \lim$

Relations: $\leq, \geq, \neq, \approx, \equiv$

Arrows: $\rightarrow, \leftarrow, \Rightarrow, \Leftrightarrow$

Set operations: $\in, \subset, \cup, \cap, \emptyset$

Fractions: $\frac{numerator}{denominator}$

Roots: $\sqrt{x}, \sqrt[n]{x}$

Superscripts/Subscripts: $x^2, x_i, x^{n+1}, x_{i,j}$

Functions: $\sin, \cos, \tan, \log, \ln, \exp$
```

### Example:

```latex
The Pythagorean theorem states:
\[
a^2 + b^2 = c^2
\]

Where $a$ and $b$ are the legs, and $c$ is the hypotenuse.

The derivative of $f(x) = x^2$ is:
\begin{equation}
f'(x) = \lim_{h \to 0} \frac{(x+h)^2 - x^2}{h} = 2x
\end{equation}
```

---

## Tables

### Basic Table

```latex
\begin{tabular}{|c|c|c|}
\hline
Header 1 & Header 2 & Header 3 \\
\hline
Row 1, Col 1 & Row 1, Col 2 & Row 1, Col 3 \\
Row 2, Col 1 & Row 2, Col 2 & Row 2, Col 3 \\
\hline
\end{tabular}
```

**Column alignment:**
- `l` - left aligned
- `c` - center aligned
- `r` - right aligned
- `|` - vertical line

### Table with Caption and Label

```latex
\begin{table}[h]
\centering
\begin{tabular}{|l|c|r|}
\hline
Name & Age & Score \\
\hline
Alice & 25 & 95 \\
Bob & 30 & 87 \\
Charlie & 28 & 92 \\
\hline
\end{tabular}
\caption{Student Information}
\label{tab:students}
\end{table}
```

Reference the table: `See Table~\ref{tab:students}`

### Multirow and Multicolumn

```latex
\usepackage{multirow}

\begin{tabular}{|c|c|c|}
\hline
\multirow{2}{*}{Combined} & Col 1 & Col 2 \\
\cline{2-3}
& Col 3 & Col 4 \\
\hline
\multicolumn{3}{|c|}{Wide Cell} \\
\hline
\end{tabular}
```

---

## Figures and Images

### Including Images

First, add the package in the preamble:
```latex
\usepackage{graphicx}
```

Then include the image:
```latex
\begin{figure}[h]
\centering
\includegraphics[width=0.5\textwidth]{image.png}
\caption{Description of the image}
\label{fig:myimage}
\end{figure}
```

**Image placement options:**
- `h` - here (try to place here)
- `t` - top of page
- `b` - bottom of page
- `p` - on a separate page
- `!` - override LaTeX's placement rules

**Image sizing:**
```latex
\includegraphics[width=5cm]{image.png}
\includegraphics[width=0.8\textwidth]{image.png}
\includegraphics[height=3cm]{image.png}
\includegraphics[scale=0.5]{image.png}
```

### Multiple Images

```latex
\begin{figure}[h]
\centering
\begin{subfigure}{0.45\textwidth}
    \includegraphics[width=\textwidth]{image1.png}
    \caption{First image}
\end{subfigure}
\hfill
\begin{subfigure}{0.45\textwidth}
    \includegraphics[width=\textwidth]{image2.png}
    \caption{Second image}
\end{subfigure}
\caption{Two images side by side}
\end{figure}
```

(Requires `\usepackage{subcaption}`)

---

## References and Citations

### Bibliography Setup

Create a `.bib` file (e.g., `references.bib`):

```bibtex
@article{author2023,
    title={Article Title},
    author={Author, A. and Author, B.},
    journal={Journal Name},
    year={2023},
    volume={10},
    pages={100--120}
}

@book{book2023,
    title={Book Title},
    author={Author, C.},
    publisher={Publisher Name},
    year={2023}
}
```

### Using Citations

In your document:
```latex
\documentclass{article}
\usepackage[backend=biber,style=ieee]{biblatex}
\addbibresource{references.bib}

\begin{document}
This is a citation \cite{author2023}.

Another citation \cite{book2023}.

\printbibliography
\end{document}
```

### Cross-References

**Label and reference sections:**
```latex
\section{Introduction}
\label{sec:intro}

See Section~\ref{sec:intro} for details.
```

**Label and reference equations:**
```latex
\begin{equation}
\label{eq:pythagorean}
a^2 + b^2 = c^2
\end{equation}

As shown in Equation~\ref{eq:pythagorean}, ...
```

**Label and reference figures:**
```latex
\begin{figure}
...
\label{fig:diagram}
\end{figure}

See Figure~\ref{fig:diagram}.
```

---

## Useful Packages

### Essential Packages

```latex
\usepackage{graphicx}      % For images
\usepackage{amsmath}       % Advanced math
\usepackage{amsfonts}      % Math fonts
\usepackage{amssymb}       % Math symbols
\usepackage{geometry}      % Page margins
\usepackage{hyperref}      % Hyperlinks
\usepackage{listings}      % Code listings
\usepackage{booktabs}      % Better tables
\usepackage{multirow}      % Multirow in tables
\usepackage{multicol}      % Multiple columns
```

### Geometry Package

```latex
\usepackage[margin=1in]{geometry}
\usepackage[a4paper,left=2cm,right=2cm,top=2cm,bottom=2cm]{geometry}
```

### Hyperref Package

```latex
\usepackage{hyperref}
\hypersetup{
    colorlinks=true,
    linkcolor=blue,
    urlcolor=cyan,
    citecolor=green
}
```

---

## Common Commands and Environments

### Quotes

```latex
\begin{quote}
This is a quoted text block.
\end{quote}

\begin{quotation}
This is a longer quotation with proper indentation.
\end{quotation}
```

### Verbatim for Code

```latex
\begin{verbatim}
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
\end{verbatim}
```

### Colors

```latex
\usepackage{xcolor}

\textcolor{red}{Red text}
\textcolor{blue}{Blue text}
\colorbox{yellow}{Highlighted text}
```

### Footnotes

```latex
This is text with a footnote\footnote{This is the footnote text}.
```

### URLs

```latex
\usepackage{url}
\url{https://www.overleaf.com}
```

---

## Practice Exercises

### Exercise 1: Basic Document

Create a document with:
- Title, author, date
- Abstract
- Table of contents
- At least 3 sections with subsections
- Some formatted text (bold, italic)

### Exercise 2: Lists and Formatting

Create a document with:
- A bullet list
- A numbered list
- A description list
- Mixed formatting (bold, italic, underline)

### Exercise 3: Mathematics

Create a document with:
- At least 5 different mathematical expressions
- Inline and display math
- Greek letters and special symbols
- A numbered equation

### Exercise 4: Tables

Create a document with:
- A table with at least 4 rows and 4 columns
- Table caption and label
- Reference to the table in text

### Exercise 5: Complete Document

Create a complete document with:
- Title page
- Abstract
- Table of contents
- Multiple sections
- At least one figure (or placeholder)
- At least one table
- Mathematical equations
- References/citations
- Proper formatting throughout

---

## Tips and Best Practices

### 1. Compile Frequently
- Click "Recompile" often to catch errors early
- Overleaf shows errors in red

### 2. Use Comments
```latex
% This is a comment
% Comments are useful for notes and explanations
```

### 3. Organize Your Code
- Use blank lines to separate sections
- Indent nested environments
- Add comments for clarity

### 4. Common Errors and Solutions

**Error: Missing $**
- Problem: Math mode not properly closed
- Solution: Check all `$` signs are paired

**Error: Undefined control sequence**
- Problem: Missing package or typo in command
- Solution: Check package is loaded, check spelling

**Error: Overfull/Underfull hbox**
- Problem: Text doesn't fit on line
- Solution: Usually safe to ignore, or adjust text

### 5. Useful Overleaf Features

- **History:** View previous versions
- **Word Count:** See document statistics
- **Download:** Get PDF or source files
- **Share:** Collaborate with others
- **Templates:** Use pre-made templates

---

## Quick Reference Card

### Document Structure
```latex
\documentclass{article}
\usepackage{...}
\title{...}
\author{...}
\begin{document}
\maketitle
\tableofcontents
\section{...}
\subsection{...}
\end{document}
```

### Text Formatting
- `\textbf{}` - Bold
- `\textit{}` - Italic
- `\underline{}` - Underline
- `\texttt{}` - Monospace

### Math
- `$...$` - Inline math
- `$$...$$` - Display math
- `\frac{a}{b}` - Fraction
- `\sqrt{x}` - Square root
- `x^2` - Superscript
- `x_i` - Subscript

### Lists
- `\begin{itemize}...\end{itemize}` - Bullet list
- `\begin{enumerate}...\end{enumerate}` - Numbered list

### Tables
```latex
\begin{tabular}{l|c|r}
...
\end{tabular}
```

### Figures
```latex
\begin{figure}[h]
\includegraphics[width=...]{file}
\caption{...}
\label{...}
\end{figure}
```

---

## Resources

### Official Documentation
- LaTeX Project: https://www.latex-project.org
- Overleaf Learn: https://www.overleaf.com/learn
- LaTeX Wikibook: https://en.wikibooks.org/wiki/LaTeX

### Useful Links
- Overleaf Templates: https://www.overleaf.com/latex/templates
- Detexify: http://detexify.kirelabs.org (Draw symbol to find LaTeX command)
- LaTeX Symbols: https://www.overleaf.com/learn/latex/List_of_Greek_letters_and_math_symbols

### Practice
- Try recreating documents you've written in Word
- Start with simple documents and add complexity
- Use templates as starting points
- Practice math notation
- Experiment with different packages

---

## Conclusion

This tutorial covered the basics of LaTeX and Overleaf. With practice, you'll be able to create professional documents efficiently. Remember:

1. **Start simple** - Begin with basic documents
2. **Use templates** - Overleaf has many templates
3. **Learn incrementally** - Add new features as needed
4. **Practice regularly** - The more you use it, the easier it gets
5. **Use resources** - There's extensive documentation available

Happy typesetting!
