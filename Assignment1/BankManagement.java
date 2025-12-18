import java.util.Scanner;

// Custom Exception for Insufficient Balance
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    private double balance;

    // Constructor to initialize account
    public BankAccount(String name, String accNum, double initialBalance) {
        this.accountHolderName = name;
        this.accountNumber = accNum;
        this.balance = initialBalance;
    }

    // Deposit Method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
            System.out.println("New Balance: $" + balance);
        } else {
            System.out.println("Error: Deposit amount must be positive.");
        }
    }

    // Withdraw Method (Throws Exception)
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Transaction Failed: Insufficient funds. Available Balance: $" + balance);
        } else if (amount <= 0) {
            System.out.println("Error: Withdrawal amount must be positive.");
        } else {
            balance -= amount;
            System.out.println("Successfully withdrawn: $" + amount);
            System.out.println("Remaining Balance: $" + balance);
        }
    }

    // Check Balance Method
    public void checkBalance() {
        System.out.println("Current Balance: $" + balance);
    }

    // Display Account Details
    public void displayDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Holder Name:   " + accountHolderName);
        System.out.println("Account No:    " + accountNumber);
        System.out.println("Total Balance: $" + balance);
    }
}

public class BankManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = null;

        System.out.println("--- Welcome to Java Bank ---");
        
        // Account Creation Step
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double bal = sc.nextDouble();

        account = new BankAccount(name, accNum, bal);
        System.out.println("Account Created Successfully!");

        while (true) {
            System.out.println("\n--- BANK MENU ---");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depAmt = sc.nextDouble();
                    account.deposit(depAmt);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withAmt = sc.nextDouble();
                    try {
                        account.withdraw(withAmt);
                    } catch (InsufficientFundsException e) {
                        // Handling the custom exception
                        System.out.println("Exception Caught: " + e.getMessage());
                    }
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    account.displayDetails();
                    break;

                case 5:
                    System.out.println("Thank you for banking with us!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}