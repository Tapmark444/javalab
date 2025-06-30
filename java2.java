import java.util.*; 
interface RentalService { 
    boolean checkAvailability(); 
    void rent(); 
    void returnCar(); 
    double calculateRentalCost(int days, double distance);  
 } 
class Car implements RentalService { 
    String make, model; 
    double dailyRate; 
    boolean isAvailable; 
    Car(String make, String model, double dailyRate) { 
        this.make = make; 
        this.model = model; 
        this.dailyRate = dailyRate; 
        this.isAvailable = true; 
    } 
    public boolean checkAvailability() { return isAvailable; } 
    public void rent() { if (isAvailable) { isAvailable = false; System.out.println("Car rented."); } } 
    public void returnCar() { isAvailable = true; System.out.println("Car returned."); } 
    public double calculateRentalCost(int days, double distance) { return days * dailyRate + distance * 
0.2; } 
    public Car compareRates(Car other) { return this.dailyRate < other.dailyRate ? this : other; } 
} 
class CarRentalService { 
    List<Car> cars = new ArrayList<>(); 
    void addCar(Car car) { cars.add(car); } 
    Car findCar(String make, String model) { 
        for (Car c : cars) if (c.make.equals(make) && c.model.equals(model)) return c; 
        return null; 
    } 
    void displayAvailableCars() { cars.stream().filter(Car::checkAvailability).forEach(c -> 
System.out.println(c.make + " " + c.model)); } 
} 
public class CarRentalApp { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        CarRentalService service = new CarRentalService(); 
        service.addCar(new Car("Toyota", "Corolla", 30)); 
        service.addCar(new Car("Honda", "Civic", 40)); 
        while (true) { 
            System.out.println("\n1. Check Availability\n2. Rent Car\n3. Return Car\n4. Compare 
Rates\n5. Rental Cost\n6. Exit"); 
            int choice = sc.nextInt(); sc.nextLine(); 
 
            switch (choice) { 
                case 1: service.displayAvailableCars(); break; 
                case 2: { 
                    System.out.print("Enter make and model: "); 
                    Car rentCar = service.findCar(sc.next(), sc.next()); 
                    if (rentCar != null) rentCar.rent(); 
                    break; 
                } 
                case 3: { 
                    System.out.print("Enter make and model: "); 
                    Car returnCar = service.findCar(sc.next(), sc.next()); 
                    if (returnCar != null) returnCar.returnCar(); 
                    break; 
                } 
                case 4: { 
                    System.out.print("Enter two cars to compare: "); 
                    Car car1 = service.findCar(sc.next(), sc.next()); 
                    Car car2 = service.findCar(sc.next(), sc.next()); 
                    if (car1 != null && car2 != null) System.out.println("Cheaper: " + (car1.compareRates(car2) 
== car1 ? car1.make + " " + car1.model : car2.make + " " + car2.model)); 
                    break; 
                } 
                case 5: { 
                    System.out.print("Enter make and model: "); 
                    Car rentalCar = service.findCar(sc.next(), sc.next()); 
                    if (rentalCar != null) { 
                        System.out.print("Enter days and distance: "); 
                        System.out.println("Cost: $" + rentalCar.calculateRentalCost(sc.nextInt(), 
sc.nextDouble())); 
                    } 
                    break; 
                } 
                case 6: return; 
            } 
        } 
    } 
} 
