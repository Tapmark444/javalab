class Flight {
    String flightNumber, airline;
    double basePrice;
    public Flight() { this("Unknown", "Unknown", 0.0); }
    public Flight(String flightNumber, String airline, double basePrice) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.basePrice = basePrice;
    }
    public void displayDetails() {
        System.out.println("Flight Number: " + flightNumber + "\nAirline: " + airline + "\nBase Price: $" + basePrice);
    }
}

class DomesticFlight extends Flight {
    double domesticTaxRate;
    public DomesticFlight(String flightNumber, String airline, double basePrice, double domesticTaxRate) {
        super(flightNumber, airline, basePrice);
        this.domesticTaxRate = domesticTaxRate;
    }
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Domestic Tax Rate: " + domesticTaxRate + "%\nTotal Price: $" + calculatePrice());
    }
    public double calculatePrice() {
        return basePrice + (basePrice * domesticTaxRate / 100);
    }
}

class InternationalFlight extends Flight {
    double internationalTaxRate, customsFee;
    public InternationalFlight(String flightNumber, String airline, double basePrice, double internationalTaxRate, double customsFee) {
        super(flightNumber, airline, basePrice);
        this.internationalTaxRate = internationalTaxRate;
        this.customsFee = customsFee;
    }
    public void displayDetails() {
        super.displayDetails();
        System.out.println("International Tax Rate: " + internationalTaxRate + "%\nCustoms Fee: $" + customsFee + "\nTotal Price: $" + calculatePrice());
    }
    public double calculatePrice() {
        return basePrice + (basePrice * internationalTaxRate / 100) + customsFee;
    }
}

public class FlightBookingSystem {
    public static void main(String[] args) {
        Flight domestic = new DomesticFlight("DF123", "AirX", 200.0, 10.0);
        Flight international = new InternationalFlight("IF456", "SkyJet", 500.0, 15.0, 50.0);
        domestic.displayDetails();
        System.out.println();
        international.displayDetails();
    }
}
