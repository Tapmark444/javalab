import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class SimpleGUI extends JFrame {
private JLabel label;
private JButton button;
private Random random = new Random();
public SimpleGUI() {
setTitle("Simple GUI");
setSize(300, 200);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new FlowLayout());
label = new JLabel("Click the button!");
button = new JButton("Click Me");
3 2,3,5/3
button.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
label.setText("Button Clicked!");
getContentPane().setBackground(new Color(random.nextInt(256),
random.nextInt(256), random.nextInt(256)));
}
});
add(label);
add(button);
setVisible(true);
}
public static void main(String[] args) {
new SimpleGUI();
}
}
