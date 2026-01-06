import java.io.Serializable;

abstract class BankAccount implements Serializable {
    private int accountNumber;
    private String holderName;
    protected double balance;

    public BankAccount(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Encapsulation (Getters)
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // Method Overloading
    public void deposit(double amount) {
        balance += amount;
    }

    public void deposit(double amount, String note) {
        balance += amount;
        System.out.println("Note: " + note);
    }

    // Abstract method
    public abstract void withdraw(double amount);

    public void displayDetails() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
}
