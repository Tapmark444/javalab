Shopping/app.java: 
package shopping; 
import java.util.ArrayList; 
interface Product { 
    double getPrice(); 
    String getDetails(); 
    void printDetails(); } 
abstract class Item implements Product { 
    protected String id, name; 
    protected double price; 
    Item(String id, String name, double price) { 
        this.id = id; 
        this.name = name; 
        this.price = price;    } 
    public double getPrice() {       return price;    } 
    public void printDetails() {        System.out.println(getDetails());    } 
} 
class Electronics extends Item { 
    private String brand; 
    private int warranty; 
    Electronics(String id, String name, double price, String brand, int warranty) { 
        super(id, name, price); 
        this.brand = brand; 
        this.warranty = warranty;    } 
    public String getDetails() { 
        return "Electronics: " + name + " (Brand: " + brand + ", Warranty: " + warranty + " yrs, Price: $" + 
price + ")"; 
    } 
} 
class Clothing extends Item { 
    private String size; 
    private String material; 
    Clothing(String id, String name, double price, String size, String material) { 
        super(id, name, price); 
        this.size = size; 
        this.material = material; 
    } 
    public String getDetails() { 
        return "Clothing: " + name + " (Size: " + size + ", Material: " + material + ", Price: $" + price + ")"; } 
} 
class ProductNotAvailableException extends Exception { 
    public ProductNotAvailableException(String message) { 
        super(message);    } 
} 
class InvalidProductException extends Exception { 
    public InvalidProductException(String message) { 
        super(message);    } 
} 
class Cart { 
    private ArrayList<Product> items = new ArrayList<>(); 
    public void add(Product p) throws ProductNotAvailableException, InvalidProductException { 
        if (p == null) { 
            throw new InvalidProductException("Invalid product!");        } 
        if (isProductOutOfStock(p)) { 
            throw new ProductNotAvailableException("Product is not available.");        } 
        items.add(p);    } 
    public boolean isProductOutOfStock(Product p) { 
        // Example logic to check availability (placeholder) 
        return false; // Assume all products are in stock for simplicity    } 
 
    public void display() { 
        if (items.isEmpty()) { 
            System.out.println("Cart is empty."); 
        } else { 
            items.forEach(p -> p.printDetails()); 
            System.out.println("Total: $" + items.stream().mapToDouble(Product::getPrice).sum()); 
        } 
    } 
} 
application/OnlineShoppingApp.java 
package application; 
import shopping.*; 
public class OnlineShoppingApp { 
    public static void main(String[] args) { 
        try { 
            Cart cart = new Cart();             
            Product laptop = new Electronics("E1001", "Laptop", 1200, "Dell", 2); 
            Product tshirt = new Clothing("C2001", "T-Shirt", 25, "M", "Cotton");             
            cart.add(laptop); 
            cart.add(tshirt);             
            System.out.println("\nShopping Cart:"); 
            cart.display(); 
        } catch (ProductNotAvailableException | InvalidProductException e) { 
            System.out.println("Error: " + e.getMessage()); 
        } 
    } 
} 
