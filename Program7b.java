import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class FilterNames {
public static void main(String[] args) {
List<String> names = Arrays.asList("Alice", "Bob", "Anna", "Charlie", "Andrew",
"David", "Amanda");
// Using lambda expression to filter names that start with 'A'
List<String> filteredNames = names.stream()
.filter(name -> name.startsWith("A"))
.collect(Collectors.toList());
// Print the filtered names
System.out.println("Names starting with 'A': " + filteredNames);
}
}