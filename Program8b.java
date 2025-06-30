import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CalculatorApp extends JFrame implements ActionListener {
private JTextField textField;
private double num1, num2, result;
private char operator;
public CalculatorApp() {
setTitle("Swing Calculator");
setSize(400, 500);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setLayout(new BorderLayout());
// Text field for input/output
textField = new JTextField();
textField.setFont(new Font("Arial", Font.BOLD, 24));
textField.setHorizontalAlignment(JTextField.RIGHT);
textField.setEditable(false);
add(textField, BorderLayout.NORTH);
// Button panel
JPanel panel = new JPanel(new GridLayout(4, 4, 5, 5));
String[] buttons = {
"7", "8", "9", "/",
"4", "5", "6", "*",
"1", "2", "3", "-",
"C", "0", "=", "+"
};
for (String text : buttons) {
JButton button = new JButton(text);
button.setFont(new Font("Arial", Font.BOLD, 20));
button.addActionListener(this);
panel.add(button);
}
add(panel, BorderLayout.CENTER);
setVisible(true);
}
@Override
public void actionPerformed(ActionEvent e) {
String command = e.getActionCommand();
if (command.matches("[0-9]")) { // Append number
textField.setText(textField.getText() + command);
} else if (command.matches("[+\\-*/]")) { // Store operator and first number
num1 = Double.parseDouble(textField.getText());
operator = command.charAt(0);
textField.setText("");
} else if (command.equals("=")) { // Perform calculation
try {
num2 = Double.parseDouble(textField.getText());
switch (operator) {
case '+': result = num1 + num2; break;
case '-': result = num1 - num2; break;
case '*': result = num1 * num2; break;
case '/':
if (num2 == 0) throw new ArithmeticException("Cannot divide by zero");
result = num1 / num2;
break;
}
textField.setText(String.valueOf(result));
} catch (Exception ex) {
textField.setText("Error");
}
} else if (command.equals("C")) { // Clear input
textField.setText("");
num1 = num2 = result = 0;
}
}
public static void main(String[] args) {
SwingUtilities.invokeLater(CalculatorApp::new);
}
}