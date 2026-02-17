# Lab 6: Problem Solving with Methods - Solutions

This file contains complete solutions for all progressive tasks in Lab 6.

---

## Task 1: Library Management System

```java
public class Library {
    private String bookTitle;
    private String bookId;
    private boolean isAvailable;
    private String borrowerName;
    private int daysBorrowed;
    
    // Default constructor
    public Library() {
        this.bookTitle = "Unknown";
        this.bookId = "0000";
        this.isAvailable = true;
        this.borrowerName = "";
        this.daysBorrowed = 0;
    }
    
    // Parameterized constructor
    public Library(String bookTitle, String bookId) {
        this.bookTitle = bookTitle;
        this.bookId = bookId;
        this.isAvailable = true;
        this.borrowerName = "";
        this.daysBorrowed = 0;
    }
    
    // Borrow book
    public void borrowBook(String borrowerName) {
        if (!isAvailable) {
            System.out.println("Book is already borrowed by " + this.borrowerName);
            return;
        }
        this.isAvailable = false;
        this.borrowerName = borrowerName;
        this.daysBorrowed = 0;
        System.out.println("Book borrowed successfully to " + borrowerName);
    }
    
    // Return book
    public void returnBook() {
        if (isAvailable) {
            System.out.println("Book is already available");
            return;
        }
        this.isAvailable = true;
        this.borrowerName = "";
        this.daysBorrowed = 0;
        System.out.println("Book returned successfully");
    }
    
    // Calculate fine
    public double calculateFine() {
        if (daysBorrowed > 14) {
            return (daysBorrowed - 14) * 0.50;
        }
        return 0.0;
    }
    
    // Extend borrow period
    public void extendBorrowPeriod(int additionalDays) {
        if (additionalDays <= 0) {
            System.out.println("Additional days must be positive");
            return;
        }
        if (isAvailable) {
            System.out.println("Book is not currently borrowed");
            return;
        }
        this.daysBorrowed += additionalDays;
        System.out.println("Borrow period extended by " + additionalDays + " days");
    }
    
    // Get book information
    public String getBookInfo() {
        String info = "Book ID: " + bookId + "\n";
        info += "Title: " + bookTitle + "\n";
        info += "Available: " + (isAvailable ? "Yes" : "No") + "\n";
        if (!isAvailable) {
            info += "Borrower: " + borrowerName + "\n";
            info += "Days Borrowed: " + daysBorrowed + "\n";
            info += "Fine: $" + calculateFine() + "\n";
        }
        return info;
    }
    
    // Check if overdue
    public boolean isOverdue() {
        return daysBorrowed > 14;
    }
    
    // Getters
    public String getBookTitle() {
        return bookTitle;
    }
    
    public String getBookId() {
        return bookId;
    }
    
    public boolean getIsAvailable() {
        return isAvailable;
    }
    
    public String getBorrowerName() {
        return borrowerName;
    }
    
    public int getDaysBorrowed() {
        return daysBorrowed;
    }
}

// Main class for testing
public class Main {
    public static void main(String[] args) {
        Library book = new Library("Java Programming", "B001");
        
        // Borrow book
        book.borrowBook("John");
        
        // Extend borrow period
        book.extendBorrowPeriod(10);
        book.extendBorrowPeriod(5);  // Total 15 days
        
        // Check if overdue
        System.out.println("Is Overdue: " + book.isOverdue());
        
        // Calculate fine
        System.out.println("Fine: $" + book.calculateFine());
        
        // Get book info
        System.out.println(book.getBookInfo());
        
        // Return book
        book.returnBook();
    }
}
```

---

## Task 2: Temperature Monitoring System

```java
public class TemperatureMonitor {
    private String roomName;
    private double currentTemperature;
    private double minTemperature;
    private double maxTemperature;
    private double[] temperatureHistory;
    private int historyCount;
    
    // Constructor
    public TemperatureMonitor(String roomName, double minTemp, double maxTemp) {
        this.roomName = roomName;
        this.minTemperature = minTemp;
        this.maxTemperature = maxTemp;
        this.currentTemperature = (minTemp + maxTemp) / 2;
        this.temperatureHistory = new double[10];
        this.historyCount = 0;
    }
    
    // Record single temperature
    public void recordTemperature(double temp) {
        if (!isValidTemperature(temp)) {
            System.out.println("Invalid temperature: " + temp);
            return;
        }
        
        // Circular buffer
        int index = historyCount % temperatureHistory.length;
        temperatureHistory[index] = temp;
        historyCount++;
        currentTemperature = temp;
    }
    
    // Record multiple temperatures (overloaded)
    public void recordTemperature(double[] temps) {
        for (double temp : temps) {
            recordTemperature(temp);
        }
    }
    
    // Validate temperature
    private boolean isValidTemperature(double temp) {
        return temp >= -50 && temp <= 60;
    }
    
    // Check if temperature is normal
    public boolean isTemperatureNormal() {
        return currentTemperature >= minTemperature && currentTemperature <= maxTemperature;
    }
    
    // Get temperature status
    public String getTemperatureStatus() {
        if (currentTemperature < minTemperature) {
            return "Too Cold";
        } else if (currentTemperature > maxTemperature) {
            return "Too Hot";
        } else {
            return "Normal";
        }
    }
    
    // Get average temperature
    public double getAverageTemperature() {
        if (historyCount == 0) return 0.0;
        
        int size = Math.min(historyCount, temperatureHistory.length);
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += temperatureHistory[i];
        }
        return sum / size;
    }
    
    // Get maximum recorded temperature
    public double getMaxRecordedTemperature() {
        if (historyCount == 0) return Double.MIN_VALUE;
        
        int size = Math.min(historyCount, temperatureHistory.length);
        double max = temperatureHistory[0];
        for (int i = 1; i < size; i++) {
            if (temperatureHistory[i] > max) {
                max = temperatureHistory[i];
            }
        }
        return max;
    }
    
    // Get minimum recorded temperature
    public double getMinRecordedTemperature() {
        if (historyCount == 0) return Double.MAX_VALUE;
        
        int size = Math.min(historyCount, temperatureHistory.length);
        double min = temperatureHistory[0];
        for (int i = 1; i < size; i++) {
            if (temperatureHistory[i] < min) {
                min = temperatureHistory[i];
            }
        }
        return min;
    }
    
    // Get temperature alerts
    public String[] getTemperatureAlerts() {
        int size = Math.min(historyCount, temperatureHistory.length);
        String[] alerts = new String[size];
        int alertCount = 0;
        
        for (int i = 0; i < size; i++) {
            double temp = temperatureHistory[i];
            if (temp < minTemperature || temp > maxTemperature) {
                alerts[alertCount] = "Alert: Temperature " + temp + "°C is outside normal range";
                alertCount++;
            }
        }
        
        // Return array with actual size
        String[] result = new String[alertCount];
        for (int i = 0; i < alertCount; i++) {
            result[i] = alerts[i];
        }
        return result;
    }
    
    // Update temperature
    public void updateTemperature(double newTemp) {
        recordTemperature(newTemp);
    }
    
    // Getters
    public String getRoomName() {
        return roomName;
    }
    
    public double getCurrentTemperature() {
        return currentTemperature;
    }
}

// Main class for testing
public class Main {
    public static void main(String[] args) {
        TemperatureMonitor monitor = new TemperatureMonitor("Office Room", 18, 25);
        
        // Record temperatures
        monitor.recordTemperature(20.0);
        monitor.recordTemperature(22.5);
        monitor.recordTemperature(16.0);  // Too cold
        monitor.recordTemperature(26.0);  // Too hot
        monitor.recordTemperature(21.0);
        
        // Check status
        System.out.println("Status: " + monitor.getTemperatureStatus());
        System.out.println("Is Normal: " + monitor.isTemperatureNormal());
        
        // Get statistics
        System.out.println("Average: " + monitor.getAverageTemperature());
        System.out.println("Max: " + monitor.getMaxRecordedTemperature());
        System.out.println("Min: " + monitor.getMinRecordedTemperature());
        
        // Get alerts
        String[] alerts = monitor.getTemperatureAlerts();
        for (String alert : alerts) {
            System.out.println(alert);
        }
    }
}
```

---

## Task 3: Student Grade Management System

```java
public class GradeManager {
    private String studentName;
    private String studentId;
    private double[][] subjectGrades;
    private String[] subjectNames;
    private int[] gradeCounts;  // Track number of grades per subject
    
    // Constructor
    public GradeManager(String studentName, String studentId, String[] subjectNames) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.subjectNames = subjectNames;
        this.subjectGrades = new double[subjectNames.length][10];  // Max 10 grades per subject
        this.gradeCounts = new int[subjectNames.length];
    }
    
    // Find subject index
    private int findSubjectIndex(String subjectName) {
        for (int i = 0; i < subjectNames.length; i++) {
            if (subjectNames[i].equals(subjectName)) {
                return i;
            }
        }
        return -1;  // Subject not found
    }
    
    // Add single grade
    public void addGrade(String subjectName, double grade) {
        if (grade < 0 || grade > 100) {
            System.out.println("Invalid grade. Must be between 0 and 100");
            return;
        }
        
        int subjectIndex = findSubjectIndex(subjectName);
        if (subjectIndex == -1) {
            System.out.println("Subject not found: " + subjectName);
            return;
        }
        
        if (gradeCounts[subjectIndex] < subjectGrades[subjectIndex].length) {
            subjectGrades[subjectIndex][gradeCounts[subjectIndex]] = grade;
            gradeCounts[subjectIndex]++;
        } else {
            System.out.println("Maximum grades reached for " + subjectName);
        }
    }
    
    // Add multiple grades (overloaded)
    public void addGrade(String subjectName, double[] grades) {
        for (double grade : grades) {
            addGrade(subjectName, grade);
        }
    }
    
    // Get subject average
    public double getSubjectAverage(String subjectName) {
        int subjectIndex = findSubjectIndex(subjectName);
        if (subjectIndex == -1 || gradeCounts[subjectIndex] == 0) {
            return 0.0;
        }
        
        double sum = 0;
        for (int i = 0; i < gradeCounts[subjectIndex]; i++) {
            sum += subjectGrades[subjectIndex][i];
        }
        return sum / gradeCounts[subjectIndex];
    }
    
    // Get overall average
    public double getOverallAverage() {
        double totalSum = 0;
        int totalCount = 0;
        
        for (int i = 0; i < subjectNames.length; i++) {
            for (int j = 0; j < gradeCounts[i]; j++) {
                totalSum += subjectGrades[i][j];
                totalCount++;
            }
        }
        
        return totalCount > 0 ? totalSum / totalCount : 0.0;
    }
    
    // Get letter grade
    public char getLetterGrade(double average) {
        if (average >= 90) return 'A';
        if (average >= 80) return 'B';
        if (average >= 70) return 'C';
        if (average >= 60) return 'D';
        return 'F';
    }
    
    // Get best subject
    public String getBestSubject() {
        double maxAvg = -1;
        int bestIndex = -1;
        
        for (int i = 0; i < subjectNames.length; i++) {
            if (gradeCounts[i] > 0) {
                double avg = getSubjectAverage(subjectNames[i]);
                if (avg > maxAvg) {
                    maxAvg = avg;
                    bestIndex = i;
                }
            }
        }
        
        return bestIndex != -1 ? subjectNames[bestIndex] : "No grades recorded";
    }
    
    // Get worst subject
    public String getWorstSubject() {
        double minAvg = 101;
        int worstIndex = -1;
        
        for (int i = 0; i < subjectNames.length; i++) {
            if (gradeCounts[i] > 0) {
                double avg = getSubjectAverage(subjectNames[i]);
                if (avg < minAvg) {
                    minAvg = avg;
                    worstIndex = i;
                }
            }
        }
        
        return worstIndex != -1 ? subjectNames[worstIndex] : "No grades recorded";
    }
    
    // Check if passing
    public boolean isPassing() {
        return getOverallAverage() >= 60;
    }
    
    // Get grade report
    public String getGradeReport() {
        StringBuilder report = new StringBuilder();
        report.append("=== Grade Report ===\n");
        report.append("Student: ").append(studentName).append("\n");
        report.append("ID: ").append(studentId).append("\n\n");
        
        for (int i = 0; i < subjectNames.length; i++) {
            report.append("Subject: ").append(subjectNames[i]).append("\n");
            if (gradeCounts[i] > 0) {
                double avg = getSubjectAverage(subjectNames[i]);
                report.append("  Average: ").append(avg).append("\n");
                report.append("  Letter Grade: ").append(getLetterGrade(avg)).append("\n");
            } else {
                report.append("  No grades recorded\n");
            }
            report.append("\n");
        }
        
        report.append("Overall Average: ").append(getOverallAverage()).append("\n");
        report.append("Overall Grade: ").append(getLetterGrade(getOverallAverage())).append("\n");
        report.append("Status: ").append(isPassing() ? "Passing" : "Failing").append("\n");
        report.append("Best Subject: ").append(getBestSubject()).append("\n");
        report.append("Worst Subject: ").append(getWorstSubject()).append("\n");
        
        return report.toString();
    }
    
    // Get subject count
    public int getSubjectCount() {
        return subjectNames.length;
    }
    
    // Get total grades count
    public int getTotalGradesCount() {
        int total = 0;
        for (int count : gradeCounts) {
            total += count;
        }
        return total;
    }
}

// Main class for testing
public class Main {
    public static void main(String[] args) {
        String[] subjects = {"Math", "Science", "English"};
        GradeManager manager = new GradeManager("John Doe", "S001", subjects);
        
        // Add grades
        manager.addGrade("Math", 85.0);
        manager.addGrade("Math", 90.0);
        manager.addGrade("Math", 88.0);
        
        manager.addGrade("Science", 78.0);
        manager.addGrade("Science", 82.0);
        
        manager.addGrade("English", 92.0);
        manager.addGrade("English", 95.0);
        manager.addGrade("English", 90.0);
        
        // Get averages
        System.out.println("Math Average: " + manager.getSubjectAverage("Math"));
        System.out.println("Overall Average: " + manager.getOverallAverage());
        
        // Get report
        System.out.println(manager.getGradeReport());
    }
}
```

---

## Task 4: Inventory Management System

```java
public class Inventory {
    private String productName;
    private String productId;
    private int quantity;
    private double unitPrice;
    private String category;
    private int reorderLevel;
    
    // Constructor
    public Inventory(String productName, String productId, double unitPrice, String category, int reorderLevel) {
        this.productName = productName;
        this.productId = productId;
        this.unitPrice = unitPrice;
        this.category = category;
        this.reorderLevel = reorderLevel;
        this.quantity = 0;
    }
    
    // Add stock
    public void addStock(int amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive");
            return;
        }
        this.quantity += amount;
        System.out.println("Added " + amount + " units. New quantity: " + quantity);
    }
    
    // Remove stock
    public void removeStock(int amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive");
            return;
        }
        if (amount > quantity) {
            System.out.println("Insufficient stock. Available: " + quantity);
            return;
        }
        this.quantity -= amount;
        System.out.println("Removed " + amount + " units. New quantity: " + quantity);
    }
    
    // Get total value
    public double getTotalValue() {
        return quantity * unitPrice;
    }
    
    // Check if needs reorder
    public boolean needsReorder() {
        return quantity <= reorderLevel;
    }
    
    // Apply discount
    public void applyDiscount(double percentage) {
        if (percentage < 0 || percentage > 100) {
            System.out.println("Discount percentage must be between 0 and 100");
            return;
        }
        unitPrice = unitPrice * (1 - percentage / 100);
        System.out.println("Discount applied. New price: $" + unitPrice);
    }
    
    // Update price
    public void updatePrice(double newPrice) {
        if (newPrice < 0) {
            System.out.println("Price cannot be negative");
            return;
        }
        this.unitPrice = newPrice;
    }
    
    // Get stock status
    public String getStockStatus() {
        if (quantity == 0) {
            return "Out of Stock";
        } else if (needsReorder()) {
            return "Low Stock";
        } else {
            return "In Stock";
        }
    }
    
    // Calculate bulk price
    public double calculateBulkPrice(int quantity) {
        if (quantity < 0) {
            return 0.0;
        }
        double price = unitPrice * quantity;
        if (quantity >= 10) {
            price = price * 0.90;  // 10% discount
        }
        return price;
    }
    
    // Get inventory info
    public String getInventoryInfo() {
        StringBuilder info = new StringBuilder();
        info.append("=== Inventory Information ===\n");
        info.append("Product ID: ").append(productId).append("\n");
        info.append("Product Name: ").append(productName).append("\n");
        info.append("Category: ").append(category).append("\n");
        info.append("Unit Price: $").append(unitPrice).append("\n");
        info.append("Quantity: ").append(quantity).append("\n");
        info.append("Total Value: $").append(getTotalValue()).append("\n");
        info.append("Reorder Level: ").append(reorderLevel).append("\n");
        info.append("Stock Status: ").append(getStockStatus()).append("\n");
        info.append("Needs Reorder: ").append(needsReorder() ? "Yes" : "No").append("\n");
        return info.toString();
    }
    
    // Compare value
    public int compareValue(Inventory other) {
        double thisValue = this.getTotalValue();
        double otherValue = other.getTotalValue();
        
        if (thisValue > otherValue) {
            return 1;
        } else if (thisValue < otherValue) {
            return -1;
        } else {
            return 0;
        }
    }
    
    // Static method to get total inventory value
    public static double getTotalInventoryValue(Inventory[] products) {
        double total = 0;
        for (Inventory product : products) {
            if (product != null) {
                total += product.getTotalValue();
            }
        }
        return total;
    }
    
    // Getters
    public String getProductName() {
        return productName;
    }
    
    public String getProductId() {
        return productId;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public double getUnitPrice() {
        return unitPrice;
    }
}

// Main class for testing
public class Main {
    public static void main(String[] args) {
        Inventory item1 = new Inventory("Laptop", "P001", 999.99, "Electronics", 5);
        Inventory item2 = new Inventory("Mouse", "P002", 25.50, "Electronics", 10);
        
        item1.addStock(20);
        item2.addStock(15);
        
        item1.removeStock(5);
        
        System.out.println(item1.getInventoryInfo());
        System.out.println(item2.getInventoryInfo());
        
        item1.applyDiscount(10);
        
        System.out.println("Bulk price for 15 units: $" + item1.calculateBulkPrice(15));
        
        int comparison = item1.compareValue(item2);
        System.out.println("Comparison result: " + comparison);
        
        Inventory[] products = {item1, item2};
        System.out.println("Total inventory value: $" + Inventory.getTotalInventoryValue(products));
    }
}
```

---

## Task 5: Banking Transaction System

```java
public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String accountType;
    private String[] transactionHistory;
    private int transactionCount;
    
    // Constructor
    public BankAccount(String accountNumber, String accountHolderName, double initialBalance, String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.accountType = accountType;
        this.transactionHistory = new String[20];
        this.transactionCount = 0;
        
        if (initialBalance > 0) {
            addTransaction("Initial deposit: $" + initialBalance);
        }
    }
    
    // Add transaction to history (circular buffer)
    private void addTransaction(String transaction) {
        int index = transactionCount % transactionHistory.length;
        transactionHistory[index] = transaction;
        transactionCount++;
    }
    
    // Deposit (single version)
    public void deposit(double amount) {
        deposit(amount, "Deposit");
    }
    
    // Deposit (overloaded with description)
    public void deposit(double amount, String description) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive");
            return;
        }
        balance += amount;
        addTransaction(description + ": +$" + amount + " | Balance: $" + balance);
        System.out.println("Deposited $" + amount + ". New balance: $" + balance);
    }
    
    // Withdraw
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive");
            return;
        }
        
        if (!canWithdraw(amount)) {
            System.out.println("Withdrawal not possible");
            return;
        }
        
        balance -= amount;
        
        // Check for low balance fee (Checking accounts)
        if (accountType.equals("Checking") && balance < 100 && balance > 0) {
            balance -= 5;
            addTransaction("Withdrawal: -$" + amount + " | Low balance fee: -$5 | Balance: $" + balance);
        } else {
            addTransaction("Withdrawal: -$" + amount + " | Balance: $" + balance);
        }
        
        System.out.println("Withdrew $" + amount + ". New balance: $" + balance);
    }
    
    // Transfer
    public void transfer(BankAccount recipient, double amount) {
        if (amount <= 0) {
            System.out.println("Transfer amount must be positive");
            return;
        }
        
        if (!canWithdraw(amount)) {
            System.out.println("Transfer not possible - insufficient funds");
            return;
        }
        
        this.balance -= amount;
        recipient.balance += amount;
        
        addTransaction("Transfer to " + recipient.accountNumber + ": -$" + amount + " | Balance: $" + balance);
        recipient.addTransaction("Transfer from " + this.accountNumber + ": +$" + amount + " | Balance: $" + recipient.balance);
        
        System.out.println("Transferred $" + amount + " to " + recipient.accountHolderName);
    }
    
    // Calculate interest
    public double calculateInterest() {
        if (accountType.equals("Savings")) {
            return balance * 0.02;  // 2%
        } else {
            return balance * 0.005;  // 0.5%
        }
    }
    
    // Apply interest
    public void applyInterest() {
        double interest = calculateInterest();
        balance += interest;
        addTransaction("Interest: +$" + interest + " | Balance: $" + balance);
        System.out.println("Interest applied: $" + interest);
    }
    
    // Get balance
    public double getBalance() {
        return balance;
    }
    
    // Get transaction history
    public String[] getTransactionHistory() {
        int size = Math.min(transactionCount, transactionHistory.length);
        String[] history = new String[size];
        
        int start = transactionCount > transactionHistory.length ? transactionCount % transactionHistory.length : 0;
        for (int i = 0; i < size; i++) {
            history[i] = transactionHistory[(start + i) % transactionHistory.length];
        }
        return history;
    }
    
    // Get account summary
    public String getAccountSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("=== Account Summary ===\n");
        summary.append("Account Number: ").append(accountNumber).append("\n");
        summary.append("Account Holder: ").append(accountHolderName).append("\n");
        summary.append("Account Type: ").append(accountType).append("\n");
        summary.append("Balance: $").append(balance).append("\n");
        summary.append("Low Balance: ").append(isLowBalance() ? "Yes" : "No").append("\n");
        return summary.toString();
    }
    
    // Check if low balance
    public boolean isLowBalance() {
        return balance < 100;
    }
    
    // Check if can withdraw
    public boolean canWithdraw(double amount) {
        if (accountType.equals("Savings")) {
            return (balance - amount) >= 500;  // Minimum balance 500
        } else {
            return (balance - amount) >= 0;  // Can go to 0
        }
    }
    
    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolderName() {
        return accountHolderName;
    }
    
    public String getAccountType() {
        return accountType;
    }
}

// Main class for testing
public class Main {
    public static void main(String[] args) {
        BankAccount savings = new BankAccount("ACC001", "John Doe", 1000, "Savings");
        BankAccount checking = new BankAccount("ACC002", "Jane Smith", 500, "Checking");
        
        savings.deposit(200);
        savings.withdraw(300);
        
        checking.deposit(50, "Salary");
        checking.withdraw(100);
        
        savings.transfer(checking, 100);
        
        savings.applyInterest();
        checking.applyInterest();
        
        System.out.println(savings.getAccountSummary());
        System.out.println(checking.getAccountSummary());
        
        String[] history = savings.getTransactionHistory();
        for (String transaction : history) {
            System.out.println(transaction);
        }
    }
}
```

---

## Task 6: Fitness Tracker System

```java
public class FitnessTracker {
    private String userName;
    private int dailySteps;
    private double dailyCaloriesBurned;
    private int workoutMinutes;
    private int[] weeklySteps;
    private int goalSteps;
    private double goalCalories;
    
    // Constructor
    public FitnessTracker(String userName, int goalSteps, double goalCalories) {
        this.userName = userName;
        this.goalSteps = goalSteps;
        this.goalCalories = goalCalories;
        this.dailySteps = 0;
        this.dailyCaloriesBurned = 0.0;
        this.workoutMinutes = 0;
        this.weeklySteps = new int[7];
    }
    
    // Add steps
    public void addSteps(int steps) {
        if (steps < 0) {
            System.out.println("Steps cannot be negative");
            return;
        }
        this.dailySteps += steps;
    }
    
    // Record workout with type
    public void recordWorkout(int minutes, String workoutType) {
        if (minutes < 0) {
            System.out.println("Minutes cannot be negative");
            return;
        }
        this.workoutMinutes += minutes;
        double calories = calculateCaloriesBurned(minutes, workoutType);
        this.dailyCaloriesBurned += calories;
    }
    
    // Record workout without type (overloaded)
    public void recordWorkout(int minutes) {
        recordWorkout(minutes, "General");
    }
    
    // Calculate calories burned
    public double calculateCaloriesBurned(int minutes, String workoutType) {
        double caloriesPerMinute = 6;  // Default
        
        switch (workoutType.toLowerCase()) {
            case "running":
                caloriesPerMinute = 10;
                break;
            case "walking":
                caloriesPerMinute = 5;
                break;
            case "cycling":
                caloriesPerMinute = 8;
                break;
            case "swimming":
                caloriesPerMinute = 12;
                break;
        }
        
        return minutes * caloriesPerMinute;
    }
    
    // Get daily progress
    public double getDailyProgress() {
        double stepProgress = (double) dailySteps / goalSteps * 100;
        double calorieProgress = dailyCaloriesBurned / goalCalories * 100;
        return (stepProgress + calorieProgress) / 2;  // Average progress
    }
    
    // Update weekly steps
    public void updateWeeklySteps(int dayIndex, int steps) {
        if (dayIndex < 0 || dayIndex >= 7) {
            System.out.println("Day index must be between 0 and 6");
            return;
        }
        if (steps < 0) {
            System.out.println("Steps cannot be negative");
            return;
        }
        weeklySteps[dayIndex] = steps;
    }
    
    // Get weekly average
    public double getWeeklyAverage() {
        int sum = 0;
        int count = 0;
        for (int steps : weeklySteps) {
            if (steps > 0) {
                sum += steps;
                count++;
            }
        }
        return count > 0 ? (double) sum / count : 0.0;
    }
    
    // Get best day
    public int getBestDay() {
        int maxSteps = weeklySteps[0];
        int bestDay = 0;
        for (int i = 1; i < weeklySteps.length; i++) {
            if (weeklySteps[i] > maxSteps) {
                maxSteps = weeklySteps[i];
                bestDay = i;
            }
        }
        return bestDay;
    }
    
    // Check if goal achieved
    public boolean isGoalAchieved() {
        return dailySteps >= goalSteps && dailyCaloriesBurned >= goalCalories;
    }
    
    // Reset daily stats
    public void resetDailyStats() {
        this.dailySteps = 0;
        this.dailyCaloriesBurned = 0.0;
        this.workoutMinutes = 0;
    }
    
    // Get fitness report
    public String getFitnessReport() {
        StringBuilder report = new StringBuilder();
        report.append("=== Fitness Report ===\n");
        report.append("User: ").append(userName).append("\n");
        report.append("Daily Steps: ").append(dailySteps).append(" / ").append(goalSteps).append("\n");
        report.append("Daily Calories: ").append(dailyCaloriesBurned).append(" / ").append(goalCalories).append("\n");
        report.append("Workout Minutes: ").append(workoutMinutes).append("\n");
        report.append("Daily Progress: ").append(String.format("%.2f", getDailyProgress())).append("%\n");
        report.append("Goal Achieved: ").append(isGoalAchieved() ? "Yes" : "No").append("\n");
        report.append("Weekly Average Steps: ").append(String.format("%.2f", getWeeklyAverage())).append("\n");
        report.append("Best Day: Day ").append(getBestDay()).append("\n");
        return report.toString();
    }
    
    // Static method to compare progress
    public static String compareProgress(FitnessTracker user1, FitnessTracker user2) {
        double progress1 = user1.getDailyProgress();
        double progress2 = user2.getDailyProgress();
        
        if (progress1 > progress2) {
            return user1.userName + " has better progress (" + String.format("%.2f", progress1) + "%)";
        } else if (progress2 > progress1) {
            return user2.userName + " has better progress (" + String.format("%.2f", progress2) + "%)";
        } else {
            return "Both users have equal progress";
        }
    }
    
    // Getters
    public String getUserName() {
        return userName;
    }
    
    public int getDailySteps() {
        return dailySteps;
    }
    
    public double getDailyCaloriesBurned() {
        return dailyCaloriesBurned;
    }
}

// Main class for testing
public class Main {
    public static void main(String[] args) {
        FitnessTracker tracker = new FitnessTracker("John", 10000, 500);
        
        tracker.addSteps(5000);
        tracker.recordWorkout(30, "Running");
        tracker.recordWorkout(20, "Walking");
        
        tracker.updateWeeklySteps(0, 8000);
        tracker.updateWeeklySteps(1, 12000);
        tracker.updateWeeklySteps(2, 10000);
        
        System.out.println(tracker.getFitnessReport());
        
        FitnessTracker tracker2 = new FitnessTracker("Jane", 8000, 400);
        tracker2.addSteps(9000);
        tracker2.recordWorkout(45, "Cycling");
        
        System.out.println(FitnessTracker.compareProgress(tracker, tracker2));
    }
}
```

---

## Task 7: Complete Integration - Multi-System Application

```java
public class SystemManager {
    private Library[] libraries;
    private TemperatureMonitor[] temperatureMonitors;
    private GradeManager[] gradeManagers;
    private Inventory[] inventories;
    private BankAccount[] bankAccounts;
    private FitnessTracker[] fitnessTrackers;
    
    private int libraryCount;
    private int monitorCount;
    private int gradeManagerCount;
    private int inventoryCount;
    private int bankAccountCount;
    private int fitnessTrackerCount;
    
    // Constructor
    public SystemManager() {
        libraries = new Library[5];
        temperatureMonitors = new TemperatureMonitor[5];
        gradeManagers = new GradeManager[5];
        inventories = new Inventory[5];
        bankAccounts = new BankAccount[5];
        fitnessTrackers = new FitnessTracker[5];
        
        libraryCount = 0;
        monitorCount = 0;
        gradeManagerCount = 0;
        inventoryCount = 0;
        bankAccountCount = 0;
        fitnessTrackerCount = 0;
    }
    
    // Add library
    public void addLibrary(Library lib) {
        if (libraryCount < libraries.length) {
            libraries[libraryCount] = lib;
            libraryCount++;
        }
    }
    
    // Add multiple libraries (varargs)
    public void addMultipleLibraries(Library... libraries) {
        for (Library lib : libraries) {
            addLibrary(lib);
        }
    }
    
    // Add temperature monitor
    public void addTemperatureMonitor(TemperatureMonitor monitor) {
        if (monitorCount < temperatureMonitors.length) {
            temperatureMonitors[monitorCount] = monitor;
            monitorCount++;
        }
    }
    
    // Add grade manager
    public void addGradeManager(GradeManager manager) {
        if (gradeManagerCount < gradeManagers.length) {
            gradeManagers[gradeManagerCount] = manager;
            gradeManagerCount++;
        }
    }
    
    // Add inventory
    public void addInventory(Inventory inv) {
        if (inventoryCount < inventories.length) {
            inventories[inventoryCount] = inv;
            inventoryCount++;
        }
    }
    
    // Add bank account
    public void addBankAccount(BankAccount account) {
        if (bankAccountCount < bankAccounts.length) {
            bankAccounts[bankAccountCount] = account;
            bankAccountCount++;
        }
    }
    
    // Add fitness tracker
    public void addFitnessTracker(FitnessTracker tracker) {
        if (fitnessTrackerCount < fitnessTrackers.length) {
            fitnessTrackers[fitnessTrackerCount] = tracker;
            fitnessTrackerCount++;
        }
    }
    
    // Get system statistics
    public String getSystemStatistics() {
        StringBuilder stats = new StringBuilder();
        stats.append("=== System Statistics ===\n\n");
        
        // Books borrowed
        int booksBorrowed = 0;
        for (int i = 0; i < libraryCount; i++) {
            if (libraries[i] != null && !libraries[i].getIsAvailable()) {
                booksBorrowed++;
            }
        }
        stats.append("Total Books Borrowed: ").append(booksBorrowed).append("\n");
        
        // Average temperature
        if (monitorCount > 0) {
            double totalTemp = 0;
            int count = 0;
            for (int i = 0; i < monitorCount; i++) {
                if (temperatureMonitors[i] != null) {
                    totalTemp += temperatureMonitors[i].getAverageTemperature();
                    count++;
                }
            }
            stats.append("Average Temperature: ").append(count > 0 ? totalTemp / count : 0).append("°C\n");
        }
        
        // Students passing
        int passingStudents = 0;
        for (int i = 0; i < gradeManagerCount; i++) {
            if (gradeManagers[i] != null && gradeManagers[i].isPassing()) {
                passingStudents++;
            }
        }
        stats.append("Students Passing: ").append(passingStudents).append("\n");
        
        // Total inventory value
        double totalInventoryValue = 0;
        for (int i = 0; i < inventoryCount; i++) {
            if (inventories[i] != null) {
                totalInventoryValue += inventories[i].getTotalValue();
            }
        }
        stats.append("Total Inventory Value: $").append(totalInventoryValue).append("\n");
        
        // Total bank balance
        double totalBalance = 0;
        for (int i = 0; i < bankAccountCount; i++) {
            if (bankAccounts[i] != null) {
                totalBalance += bankAccounts[i].getBalance();
            }
        }
        stats.append("Total Bank Balance: $").append(totalBalance).append("\n");
        
        // Total steps
        int totalSteps = 0;
        for (int i = 0; i < fitnessTrackerCount; i++) {
            if (fitnessTrackers[i] != null) {
                totalSteps += fitnessTrackers[i].getDailySteps();
            }
        }
        stats.append("Total Steps: ").append(totalSteps).append("\n");
        
        return stats.toString();
    }
    
    // Generate complete report
    public String generateCompleteReport() {
        StringBuilder report = new StringBuilder();
        report.append("=== COMPLETE SYSTEM REPORT ===\n\n");
        
        report.append("LIBRARIES:\n");
        for (int i = 0; i < libraryCount; i++) {
            if (libraries[i] != null) {
                report.append(libraries[i].getBookInfo()).append("\n");
            }
        }
        
        report.append("\nTEMPERATURE MONITORS:\n");
        for (int i = 0; i < monitorCount; i++) {
            if (temperatureMonitors[i] != null) {
                report.append("Room: ").append(temperatureMonitors[i].getRoomName())
                       .append(" | Temp: ").append(temperatureMonitors[i].getCurrentTemperature())
                       .append("°C | Status: ").append(temperatureMonitors[i].getTemperatureStatus()).append("\n");
            }
        }
        
        report.append("\nGRADE MANAGERS:\n");
        for (int i = 0; i < gradeManagerCount; i++) {
            if (gradeManagers[i] != null) {
                report.append(gradeManagers[i].getGradeReport()).append("\n");
            }
        }
        
        report.append("\nINVENTORIES:\n");
        for (int i = 0; i < inventoryCount; i++) {
            if (inventories[i] != null) {
                report.append(inventories[i].getInventoryInfo()).append("\n");
            }
        }
        
        report.append("\nBANK ACCOUNTS:\n");
        for (int i = 0; i < bankAccountCount; i++) {
            if (bankAccounts[i] != null) {
                report.append(bankAccounts[i].getAccountSummary()).append("\n");
            }
        }
        
        report.append("\nFITNESS TRACKERS:\n");
        for (int i = 0; i < fitnessTrackerCount; i++) {
            if (fitnessTrackers[i] != null) {
                report.append(fitnessTrackers[i].getFitnessReport()).append("\n");
            }
        }
        
        return report.toString();
    }
    
    // Find overdue books
    public Library[] findOverdueBooks() {
        Library[] overdue = new Library[libraryCount];
        int count = 0;
        
        for (int i = 0; i < libraryCount; i++) {
            if (libraries[i] != null && libraries[i].isOverdue()) {
                overdue[count] = libraries[i];
                count++;
            }
        }
        
        Library[] result = new Library[count];
        for (int i = 0; i < count; i++) {
            result[i] = overdue[i];
        }
        return result;
    }
    
    // Find low stock items
    public Inventory[] findLowStockItems() {
        Inventory[] lowStock = new Inventory[inventoryCount];
        int count = 0;
        
        for (int i = 0; i < inventoryCount; i++) {
            if (inventories[i] != null && inventories[i].needsReorder()) {
                lowStock[count] = inventories[i];
                count++;
            }
        }
        
        Inventory[] result = new Inventory[count];
        for (int i = 0; i < count; i++) {
            result[i] = lowStock[i];
        }
        return result;
    }
    
    // Find top students
    public GradeManager[] findTopStudents() {
        if (gradeManagerCount == 0) {
            return new GradeManager[0];
        }
        
        // Find maximum average
        double maxAvg = -1;
        for (int i = 0; i < gradeManagerCount; i++) {
            if (gradeManagers[i] != null) {
                double avg = gradeManagers[i].getOverallAverage();
                if (avg > maxAvg) {
                    maxAvg = avg;
                }
            }
        }
        
        // Collect all students with max average
        GradeManager[] topStudents = new GradeManager[gradeManagerCount];
        int count = 0;
        for (int i = 0; i < gradeManagerCount; i++) {
            if (gradeManagers[i] != null && gradeManagers[i].getOverallAverage() == maxAvg) {
                topStudents[count] = gradeManagers[i];
                count++;
            }
        }
        
        GradeManager[] result = new GradeManager[count];
        for (int i = 0; i < count; i++) {
            result[i] = topStudents[i];
        }
        return result;
    }
    
    // Get system health
    public String getSystemHealth() {
        StringBuilder health = new StringBuilder();
        health.append("=== System Health Status ===\n");
        
        int overdueCount = findOverdueBooks().length;
        int lowStockCount = findLowStockItems().length;
        
        health.append("Libraries: ").append(libraryCount).append(" active");
        if (overdueCount > 0) {
            health.append(" | ").append(overdueCount).append(" overdue books");
        }
        health.append("\n");
        
        health.append("Temperature Monitors: ").append(monitorCount).append(" active\n");
        
        health.append("Grade Managers: ").append(gradeManagerCount).append(" active\n");
        
        health.append("Inventories: ").append(inventoryCount).append(" active");
        if (lowStockCount > 0) {
            health.append(" | ").append(lowStockCount).append(" items need reorder");
        }
        health.append("\n");
        
        health.append("Bank Accounts: ").append(bankAccountCount).append(" active\n");
        health.append("Fitness Trackers: ").append(fitnessTrackerCount).append(" active\n");
        
        return health.toString();
    }
}

// Main class for testing
public class Main {
    public static void main(String[] args) {
        SystemManager manager = new SystemManager();
        
        // Add libraries
        Library lib1 = new Library("Book1", "B001");
        Library lib2 = new Library("Book2", "B002");
        lib1.borrowBook("John");
        lib1.extendBorrowPeriod(20);  // Make it overdue
        manager.addMultipleLibraries(lib1, lib2);
        
        // Add temperature monitors
        TemperatureMonitor monitor = new TemperatureMonitor("Room1", 18, 25);
        monitor.recordTemperature(20.0);
        manager.addTemperatureMonitor(monitor);
        
        // Add grade managers
        String[] subjects = {"Math", "Science"};
        GradeManager gm = new GradeManager("Student1", "S001", subjects);
        gm.addGrade("Math", 90.0);
        gm.addGrade("Science", 85.0);
        manager.addGradeManager(gm);
        
        // Add inventories
        Inventory inv = new Inventory("Product1", "P001", 10.0, "Category1", 5);
        inv.addStock(3);  // Below reorder level
        manager.addInventory(inv);
        
        // Add bank accounts
        BankAccount account = new BankAccount("ACC001", "John", 1000, "Savings");
        manager.addBankAccount(account);
        
        // Add fitness trackers
        FitnessTracker tracker = new FitnessTracker("User1", 10000, 500);
        tracker.addSteps(8000);
        manager.addFitnessTracker(tracker);
        
        // Get statistics
        System.out.println(manager.getSystemStatistics());
        
        // Find overdue books
        Library[] overdue = manager.findOverdueBooks();
        System.out.println("Overdue books: " + overdue.length);
        
        // Find low stock items
        Inventory[] lowStock = manager.findLowStockItems();
        System.out.println("Low stock items: " + lowStock.length);
        
        // Get system health
        System.out.println(manager.getSystemHealth());
        
        // Generate complete report
        System.out.println(manager.generateCompleteReport());
    }
}
```

---

## Notes on Solutions

1. **All solutions include:**
   - Complete class implementations
   - Proper validation
   - Error handling
   - Main class for testing

2. **Key Features:**
   - Private attributes with public getters where needed
   - Proper use of constructors
   - Method overloading where specified
   - Static methods for utility operations
   - Circular buffer implementation for history
   - Array management and searching
   - String formatting for reports

3. **Testing:**
   - Each solution includes a Main class with test scenarios
   - Tests cover normal operations and edge cases
   - Demonstrates all required functionality

These solutions can be used as reference or for grading purposes.
