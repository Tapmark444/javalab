class MenuItem { 
    final String name; 
    double price; 
    public MenuItem(String name, double price) { 
        this.name = name; 
        this.price = price;    } 
    public final void displayDetails() { 
        System.out.println("Name: " + name + "\nPrice: $" + price);    } 
} 
class FoodItem extends MenuItem { 
    boolean isVegetarian; 
    public FoodItem(String name, double price, boolean isVegetarian) { 
        super(name, price); 
        this.isVegetarian = isVegetarian;    } 
    public void displayFoodDetails() { 
        super.displayDetails(); 
        System.out.println("Vegetarian: " + (isVegetarian ? "Yes" : "No")); 
    } 
} 
class DrinkItem extends MenuItem { 
    boolean isAlcoholic; 
    public DrinkItem(String name, double price, boolean isAlcoholic) { 
        super(name, price); 
        this.isAlcoholic = isAlcoholic;    } 
    public void displayDrinkDetails() { 
        super.displayDetails(); 
        System.out.println("Alcoholic: " + (isAlcoholic ? "Yes" : "No"));    } 
} 
public class RestaurantOrderingSystem { 
    public static void main(String[] args) { 
        MenuItem[] menu = { 
            new FoodItem("Vegetable Burger", 5.99, true), 
            new FoodItem("Chicken Sandwich", 6.99, false), 
            new DrinkItem("Coke", 1.50, false), 
            new DrinkItem("Beer", 3.00, true)        }; 
        for (MenuItem item : menu) { 
            if (item instanceof FoodItem) { 
                ((FoodItem) item).displayFoodDetails(); 
            } else if (item instanceof DrinkItem) { 
                ((DrinkItem) item).displayDrinkDetails(); 
            } 
            System.out.println(); 
        } 
    } 
}