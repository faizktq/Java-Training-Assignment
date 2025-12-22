import java.util.Scanner;

interface BankingOperation{
    void deposit(double amount);
    void withdraw(double amount) throws InsufficientFundsException;
    double getBalance();
}
interface CustomerService{
    void displayAccountDetails();
    void updateContact(String email);
}
class InsufficientFundsException extends Exception{
    public InsufficientFundsException(String message){
        super(message);
    }
}
class SavingAccount implements BankingOperation, CustomerService{
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private String email;

    public SavingAccount(String accNum, String holder, double initialBalance,String email){
        this.accountNumber = accNum;
        this.accountHolder = holder;
        this.balance = initialBalance;
        this.email = email;
    }
    @Override
    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
            System.out.println("Successfully deposited: "+ amount);
        }
    }
    @Override
    public void withdraw(double amount) throws InsufficientFundsException{
        if(amount>balance){
            throw new InsufficientFundsException("Error: Insufficient Funds. Current Balance: "+ balance);
        }
        balance-=amount;
        System.out.println("Successfully withdrawn: "+amount);
    }
    @Override
    public double getBalance(){
        return balance;
    }
    @Override
    public void displayAccountDetails(){
        System.out.println("\n---- Account Details ----");
        System.out.println("Holder: "+accountHolder);
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Contact: "+ email);
        System.out.println("Balance: "+ balance);
    }
    @Override
    public void updateContact(String email){
        this.email = email;
        System.out.println("Contact email updated to: "+email);
    }
}
public class Bank {
    public static void main(String[] args) {
        SavingAccount myAccount = new SavingAccount("SBIN1000000", "Aman", 10000, "aman@gmail.com");

        myAccount.displayAccountDetails();
        myAccount.deposit(200);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the amount to Withdraw: ");
        double amount = sc.nextDouble();
        try {
            myAccount.withdraw(amount);
        } catch (InsufficientFundsException e) {
            // TODO: handle exception
            System.out.println("Transaction failed: "+e.getMessage());
        }
        myAccount.updateContact("amankumar@email.com");
        myAccount.displayAccountDetails();
        sc.close();
    }
}
