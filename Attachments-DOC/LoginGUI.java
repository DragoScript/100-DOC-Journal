import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginGUI implements ActionListener {
    
    private static JPanel panel;
    private static JFrame frame;
    private static JButton button;
    private static JLabel usernameLabel;
    private static JTextField username;
    private static JLabel passwdLabel;
    private static JPasswordField password;
    private static JLabel successElseFail;

    public static void main(String[] args) {

        panel = new JPanel();
        frame = new JFrame();
        frame.setSize(300, 200);
        frame.setTitle("Java Login GUI DEMO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(10, 20, 80, 25);
        panel.add(usernameLabel);
        username = new JTextField(20);
        username.setBounds(100, 20, 165, 25);
        panel.add(username);

        passwdLabel = new JLabel("Password:");
        passwdLabel.setBounds(10, 50, 80, 25);
        panel.add(passwdLabel);
        password = new JPasswordField(20);
        password.setBounds(100, 50, 165, 25);
        panel.add(password);

        button = new JButton("Login");
        button.setBounds(10, 80, 80, 25);
        button.addActionListener(new LoginGUI());
        panel.add(button);

        successElseFail = new JLabel("");
        successElseFail.setBounds(10, 110, 300, 25);
        panel.add(successElseFail);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String usernameString = username.getText();
        String passwordString = password.getText();

        if (usernameString.equals("root") && passwordString.equals("password123")) {
            successElseFail.setText("Login was successful!");
        }
        else {
            successElseFail.setText("Login failed!");
        }
    }
}