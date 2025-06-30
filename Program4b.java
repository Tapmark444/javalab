// Functional interface
interface StringProcessor {
String process(String input);
}
public class BlockLambdaExample {
public static void main(String[] args) {
// Block lambda implementation
StringProcessor processor = (input) -> {
String reversed = new StringBuilder(input).reverse().toString();
return reversed.toUpperCase();
};
// Array of strings
String[] strings = { "hello", "java", "lambda", "world" };
// Process each string and print the result
for (String str : strings) {
System.out.println("Original: " + str + " | Processed: " + processor.process(str));
}
}
}