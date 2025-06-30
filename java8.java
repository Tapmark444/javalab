File 1: Account.java (In banking package) 
package banking; 
public interface Account { 
    void deposit(double amount); 
    void withdraw(double amount) throws Exception; 
    double checkBalance();} 
File 2: BankAccount.java (In banking package) 
package banking; 
public class BankAccount implements Account { 
    String accountNumber, accountHolder; 
    double balance; 
    public BankAccount(String accountNumber, String accountHolder, double balance) { 
        this.accountNumber = accountNumber; 
        this.accountHolder = accountHolder; 
        this.balance = balance;    } 
   public void deposit(double amount) { 
        balance += amount;    } 
    public void withdraw(double amount) throws Exception { 
        if (amount > balance) throw new InsufficientFundsException("Insufficient funds"); 
        balance -= amount;    } 
    public double checkBalance() { 
        return balance;    } 
} 
File 3: SavingsAccount.java (In banking package) 
package banking; 
public class SavingsAccount extends BankAccount { 
    double interestRate; 
    public SavingsAccount(String accountNumber, String accountHolder, double balance, double 
interestRate) { 
        super(accountNumber, accountHolder, balance); 
        this.interestRate = interestRate; 
    } 
    public double calculateInterest(int timePeriod) { 
        return balance * interestRate * timePeriod;    } 
    public void withdraw(double amount) throws Exception { 
        if (amount > balance) throw new InsufficientFundsException("Insufficient funds in Savings 
Account"); 
        super.withdraw(amount);    } 
} 
File 4: CurrentAccount.java (In banking package) 
package banking; 
public class CurrentAccount extends BankAccount { 
    double overdraftLimit; 
    public CurrentAccount(String accountNumber, String accountHolder, double balance, double 
overdraftLimit) { 
        super(accountNumber, accountHolder, balance); 
        this.overdraftLimit = overdraftLimit;    } 
    public void withdraw(double amount) throws Exception { 
        if (amount > (balance + overdraftLimit)) 
            throw new OverdraftLimitExceededException("Overdraft limit exceeded"); 
        super.withdraw(amount);    } 
} 
File 5: InsufficientFundsException.java (In banking package) 
package banking; 
public class InsufficientFundsException extends Exception { 
    public InsufficientFundsException(String message) { 
        super(message);    } 
} 
File 6: OverdraftLimitExceededException.java (In banking package) 
package banking; 
public class OverdraftLimitExceededException extends Exception { 
    public OverdraftLimitExceededException(String message) { 
        super(message);    } 
} 
File 7: BankingApp.java (In application package) 
package application; 
import banking.*; 
public class BankingApp { 
    public static void main(String[] args) { 
        BankAccount savingsAccount = new SavingsAccount("SA123", "Alice", 1000, 0.05); 
        BankAccount currentAccount = new CurrentAccount("CA456", "Bob", 500, 200); 
        try { 
            savingsAccount.deposit(200); 
            System.out.println("Savings Balance: $" + savingsAccount.checkBalance()); 
            ((SavingsAccount) savingsAccount).calculateInterest(1); 
            System.out.println("Interest: $" + ((SavingsAccount) savingsAccount).calculateInterest(1)); 
            savingsAccount.withdraw(1500);  // Will throw InsufficientFundsException 
        } catch (Exception e) { 
            System.out.println("Error: " + e.getMessage());        } 
        try { 
            currentAccount.deposit(100); 
            System.out.println("Current Balance: $" + currentAccount.checkBalance()); 
            currentAccount.withdraw(700);  // Will throw OverdraftLimitExceededException 
        } catch (Exception e) { 
            System.out.println("Error: " + e.getMessage()); 
        } 
    } 
}