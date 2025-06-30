class Book {
private final String title;
private boolean available = true;
public Book(String title) { this.title = title; }
public synchronized boolean borrow(String user) {
if (!available) return false;
available = false;
System.out.println(user + " borrowed " + title);
return true;
}
public synchronized void returnBook(String user) {
available = true;
System.out.println(user + " returned " + title);
}
}
class User implements Runnable {
private final String name;
private final Book book;
public User(String name, Book book) {
this.name = name;
this.book = book;
}
public void run() {
if (book.borrow(name)) {
try { Thread.sleep((int) (Math.random() * 3000) + 1000); } catch
(InterruptedException ignored) {}
book.returnBook(name);
} else {
System.out.println(name + " couldn't borrow " + book);
}
}
}
public class LibrarySystem {
public static void main(String[] args) throws InterruptedException {
Book book = new Book("Effective Java");
Thread[] users = { new Thread(new User("Alice", book)), new Thread(new
User("Bob", book)), new Thread(new User("Charlie", book)) };
for (Thread user : users) user.start();
for (Thread user : users) user.join();
System.out.println("All users have completed borrowing and returning.");
}
}
