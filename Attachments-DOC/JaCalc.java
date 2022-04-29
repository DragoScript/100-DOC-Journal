import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JaCalc implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JTextField output;
    private JButton[] numBtn = new JButton[10];
    private JButton[] funcBtn = new JButton[8];
    private JButton decBtn;
    private JButton addBtn;
    private JButton subBtn;
    private JButton timeBtn;
    private JButton divBtn;
    private JButton eqlBtn;
    private JButton delBtn;
    private JButton clrBtn;
    private double num1 = 0;
    private double num2 = 0;
    private double total = 0;
    private String option;
    private Font calcFont = new Font("Arial", Font.BOLD, 30);

    public static void main(String[] args){
        new JaCalc();
    }

    public JaCalc() {
        frame = new JFrame("JaCalc");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setSize(300, 450);
        frame.setLayout(null);

        // Output TextField
        output = new JTextField();
        output.setBounds(30, 25, 240, 50);
        output.setFont(calcFont);
        output.setEditable(false);
        output.setBackground(Color.BLUE);
		output.setForeground(Color.WHITE);
        frame.add(output);

        // Function Buttons
        decBtn = new JButton(".");
        addBtn = new JButton("+");
        subBtn = new JButton("-");
        timeBtn = new JButton("x");
        divBtn = new JButton("/");
        eqlBtn = new JButton("=");
        delBtn = new JButton("Del");
        clrBtn = new JButton("Clear");

        funcBtn[0] = decBtn;
        funcBtn[1] = addBtn;
        funcBtn[2] = subBtn;
        funcBtn[3] = timeBtn;
        funcBtn[4] = divBtn;
        funcBtn[5] = eqlBtn;
        funcBtn[6] = delBtn;
        funcBtn[7] = clrBtn;

        for (int i=0; i < 8; i++){
            funcBtn[i].addActionListener(this);
            funcBtn[i].setFont(calcFont);
            funcBtn[i].setFocusable(false);
            funcBtn[i].setBackground(Color.BLUE);
			funcBtn[i].setForeground(Color.WHITE);
        }

        delBtn.setBounds(30, 350, 110,50);
        clrBtn.setBounds(160, 350, 110, 50);

        frame.add(delBtn);
        frame.add(clrBtn);


        // Number Buttons
        for (int i=0; i < 10; i++){
            numBtn[i] = new JButton(String.valueOf(i));
            numBtn[i].addActionListener(this);
            numBtn[i].setFont(calcFont);
            numBtn[i].setFocusable(false);
            numBtn[i].setBackground(Color.BLUE);
			numBtn[i].setForeground(Color.WHITE);
        }

        // Layout for Buttons
        panel = new JPanel();
        panel.setBounds(30, 100, 240, 240);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.BLACK);
        frame.add(panel);

        panel.add(numBtn[9]);
        panel.add(numBtn[8]);
        panel.add(numBtn[7]);
        panel.add(addBtn);
        panel.add(numBtn[6]);
        panel.add(numBtn[5]);
        panel.add(numBtn[4]);
        panel.add(subBtn);
        panel.add(numBtn[3]);
        panel.add(numBtn[2]);
        panel.add(numBtn[1]);
        panel.add(timeBtn);
        panel.add(decBtn);
        panel.add(numBtn[0]);
        panel.add(eqlBtn);
        panel.add(divBtn);
        


        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Allows for buttons to be displayed on output textfield
        for (int i = 0; i <= 9; i++){
            if (e.getSource() == numBtn[i]){
                output.setText(output.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == decBtn) {
            output.setText(output.getText().concat("."));
        }

        if (e.getSource() == addBtn) {
            num1 = Double.parseDouble(output.getText());
            option = "+";
            output.setText("");
        }

        if (e.getSource() == subBtn) {
            num1 = Double.parseDouble(output.getText());
            option = "-";
            output.setText("");
        }

        if (e.getSource() == timeBtn){
            num1 = Double.parseDouble(output.getText());
            option = "x";
            output.setText("");
        }

        if (e.getSource() == divBtn){
            num1 = Double.parseDouble(output.getText());
            option = "/";
            output.setText("");
        }

        if (e.getSource() == eqlBtn){
            num2 = Double.parseDouble(output.getText());
            switch (option) {
                case "+":            
                    total = num1 + num2;
                    break;

                case "-":
                    total = num1 - num2;
                    break;

                case "x":
                    total = num1 * num2;
                    break;

                case "/":
                    total = num1 / num2;
                    break;

                default:
                    total = 0;
                    break;    
            }
            output.setText(String.valueOf(total));
        }
        
        // Deletes a number one char at a time
        if (e.getSource() == delBtn){
            String string = output.getText();
            output.setText("");
            for (int i=0; i < string.length() -1; i++){
                output.setText(output.getText()+string.charAt(i));
            }
        }

        if (e.getSource() == clrBtn){
            output.setText("");
        }
    }
}