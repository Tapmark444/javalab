class WeatherStation { 
    String location, stationId; 
    public WeatherStation(String location, String stationId) { 
        this.location = location; 
        this.stationId = stationId;    } 
    public void displayData() { 
        System.out.println("Location: " + location + "\nStation ID: " + stationId); 
        String name = location + " Weather Station"; 
        System.out.println(name + "\n" + name.substring(0, 7) + "\n" + name.toUpperCase());    } 
} 
class TemperatureStation extends WeatherStation { 
    double temperature; 
    public TemperatureStation(String location, String stationId, double temperature) { 
        super(location, stationId); 
        this.temperature = temperature;    } 
    public void displayData() { 
        super.displayData(); 
        System.out.println("Temperature: " + temperature); 
        StringBuffer sb = new StringBuffer(stationId).append(" - TempStation"); 
        System.out.println(sb.toString() + "\n" + sb.reverse());    } 
} 
class RainfallStation extends WeatherStation { 
    double rainfall; 
    public RainfallStation(String location, String stationId, double rainfall) { 
        super(location, stationId); 
        this.rainfall = rainfall;    } 
    public void displayData() { 
        super.displayData(); 
        System.out.println("Rainfall: " + rainfall); 
        StringBuffer sb = new StringBuffer("Rain-").append(stationId).replace(5, 9, "Rainfall"); 
        System.out.println(sb);    } 
} 
public class WeatherMonitoringSystem { 
    public static void main(String[] args) { 
        WeatherStation[] stations = { 
            new TemperatureStation("New York", "NY001", 23.5), 
            new RainfallStation("Seattle", "SEA001", 120.5) 
        }; 
 
        for (WeatherStation station : stations) { 
            station.displayData(); 
            System.out.println();        } 
    } 
} 
