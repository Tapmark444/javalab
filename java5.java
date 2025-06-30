class Vehicle { 
    final String make, model; 
    int year; 
    public Vehicle(String make, String model, int year) { 
        this.make = make; 
        this.model = model; 
        this.year = year; 
    } 
    public void displayDetails() { 
        System.out.println("Make: " + make + ", Model: " + model + ", Year: " + year); 
    } 
    public void displayDetails(boolean detailed) { 
        displayDetails(); 
        if (detailed) System.out.println("Additional Vehicle Information."); 
    } 
    public static void showType() { 
        System.out.println("Vehicle");    } 
} 
class Car extends Vehicle { 
    int numberOfDoors; 
    public Car(String make, String model, int year, int numberOfDoors) { 
        super(make, model, year); 
        this.numberOfDoors = numberOfDoors; 
    } 
    public void displayDetails() { 
        super.displayDetails(); 
        System.out.println("Number of Doors: " + numberOfDoors); 
    } 
    public void displayDetails(String format) { 
        System.out.println(String.format(format, make, model, year, numberOfDoors)); 
    } 
    public static void showType() { 
        System.out.println("Car");    } 
} 
class Truck extends Vehicle { 
    double loadCapacity; 
    public Truck(String make, String model, int year, double loadCapacity) { 
        super(make, model, year); 
        this.loadCapacity = loadCapacity; 
    } 
    public void displayDetails() { 
        super.displayDetails(); 
        System.out.println("Load Capacity: " + loadCapacity + " tons"); 
    } 
 
    public void displayDetails(String format) { 
        System.out.println(String.format(format, make, model, year, loadCapacity)); 
    } 
    public static void showType() { 
        System.out.println("Truck");    } 
} 
public class VehicleManagementSystem { 
    public static void main(String[] args) { 
        Vehicle[] vehicles = { 
            new Car("Toyota", "Camry", 2022, 4), 
            new Truck("Ford", "F-150", 2020, 3.5) 
        }; 
        for (Vehicle vehicle : vehicles) { 
            vehicle.displayDetails(); 
            System.out.println(); 
            vehicle.displayDetails(true); 
            System.out.println(); 
        } 
        Vehicle.showType(); 
        Car.showType(); 
        Truck.showType(); 
        ((Car) vehicles[0]).displayDetails("Make: %s, Model: %s, Year: %d, Doors: %d"); 
        ((Truck) vehicles[1]).displayDetails("Make: %s, Model: %s, Year: %d, Load Capacity: %.2f tons");  } 
}