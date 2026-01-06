import java.util.*;

public class BankApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<Integer, BankAccount> accounts =
                BankFileHandler.loadAccounts();

        while (true) {
            System.out.println("\n--- BANK MENU ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Balance Enquiry");
            System.out.println("5. Display Account");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Holder Name: ");
                    String name = sc.nextLine();

                    System.out.print("Initial Balance: ");
                    double bal = sc.nextDouble();

                    System.out.println("1. Savings  2. Current");
                    int type = sc.nextInt();

                    BankAccount acc;
                    if (type == 1)
                        acc = new SavingsAccount(accNo, name, bal);
                    else
                        acc = new CurrentAccount(accNo, name, bal);

                    accounts.put(accNo, acc);
                    BankFileHandler.saveAccounts(accounts);
                    System.out.println("Account Created");
                    break;

                case 2:
                    System.out.print("Account Number: ");
                    accNo = sc.nextInt();

                    BankAccount account = accounts.get(accNo);

                    if (account == null) {
                        System.out.println("Account not found");
                        break;
                    }

                    System.out.print("Enter amount to deposit: ");
                    double amount = sc.nextDouble();
                    sc.nextLine(); // buffer clear

                    System.out.print("Do you want to add a note? (yes/no): ");
                    String choiceNote = sc.nextLine();

                    if (choiceNote.equalsIgnoreCase("yes")) {
                        System.out.print("Enter note: ");
                        String note = sc.nextLine();
                        account.deposit(amount, note);   // overloaded method
                    } else {
                        account.deposit(amount);         // normal deposit
                    }

                    BankFileHandler.saveAccounts(accounts);
                    System.out.println("Deposit successful");
                    break;

                case 3:
                    System.out.print("Account Number: ");
                    accNo = sc.nextInt();
                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();

                    accounts.get(accNo).withdraw(amt);
                    BankFileHandler.saveAccounts(accounts);
                    break;

                case 4:
                    System.out.print("Account Number: ");
                    accNo = sc.nextInt();
                    System.out.println("Balance: " +
                            accounts.get(accNo).getBalance());
                    break;

                case 5:
                    System.out.print("Account Number: ");
                    accNo = sc.nextInt();
                    accounts.get(accNo).displayDetails();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    System.exit(0);
            }
        }
    }
}
