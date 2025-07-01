// ATM class with synchronized deposit and withdraw methods
class ATM {
private double balance;
public ATM(double initialBalance) {
this.balance = initialBalance;
}
// Synchronized withdraw method
public synchronized void withdraw(double amount, String customerName) {
if (amount > balance) {
System.out.println(customerName + " attempted to withdraw $" + amount + " but insufficient balance!");
} else {
balance -= amount;
System.out.println(customerName + " withdrew $" + amount + ". New balance:$" + balance);
}
}
// Synchronized deposit method
public synchronized void deposit(double amount, String customerName) {
balance += amount;
System.out.println(customerName + " deposited $" + amount + ". New balance: $"
+ balance);
}
// Get balance
public synchronized double getBalance() {
return balance;
}
}
// Customer class that extends Thread
class Customer extends Thread {
private ATM atm;
private String name;
public Customer(ATM atm, String name) {
this.atm = atm;
this.name = name;
}
@Override
public void run() {
atm.deposit(500, name);
atm.withdraw(200, name);
System.out.println(name + " checked balance: $" + atm.getBalance());
}
}
// Main class to run the program
public class ATMSynchronization {
public static void main(String[] args) {
ATM atm = new ATM(1000); // Initialize ATM with $1000
// Create customer threads
Customer c1 = new Customer(atm, "Alice");
Customer c2 = new Customer(atm, "Bob");
// Start threads
c1.start();
c2.start();
// Use join() to ensure main thread waits for customers to finish
try {
c1.join();
c2.join();
} catch (InterruptedException e) {
System.out.println("Thread interrupted!");
}
System.out.println("All transactions completed. Final ATM balance: $" +atm.getBalance());
}
}
