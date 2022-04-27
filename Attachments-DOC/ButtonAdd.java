import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonAdd implements ActionListener {

    private JPanel panel;
    private JFrame frame;
    private JTextField output;
    private JButton[] numBtn = new JButton[3];
    private JButton[] funcBtn = new JButton[2];
    private JButton addBtn;
    private JButton eqlBtn;
    private JButton clrBtn;
    private int num1 = 0;
    private int num2 = 0;
    private int total = 0;
    private Font font = new Font("Arial", Font.BOLD, 30); // Changes the default font to be more readable.


    public ButtonAdd() {

        frame = new JFrame("ButtonAdd");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 420);
        frame.setLayout(null);

        output = new JTextField();
        output.setBounds(50,25,200,50);
        output.setFont(font);
        output.setEditable(false);
        frame.add(output);

        addBtn = new JButton("+");
        eqlBtn = new JButton("=");
        clrBtn = new JButton("Clear");

        funcBtn[0] = addBtn;
        funcBtn[1] = eqlBtn;

        for (int i =0; i<2; i++) {
            funcBtn[i].addActionListener(this);
            funcBtn[i].setFont(font);
            funcBtn[i].setFocusable(false); // Removes annoying textbox outline in buttons
        }

        for (int i =0; i<3; i++) {
            numBtn[i] = new JButton(String.valueOf(i));
            numBtn[i].addActionListener(this);
            numBtn[i].setFont(font);
            numBtn[i].setFocusable(false);
        }

        clrBtn.setBounds(50, 325, 200,50);
        clrBtn.addActionListener(this);
        clrBtn.setFont(font);
        clrBtn.setFocusable(false);
        frame.add(clrBtn);

        panel = new JPanel();
        panel.setBounds(50, 100, 200, 200);
        panel.setLayout(new GridLayout(2, 2, 4, 4));

        panel.add(numBtn[1]);
        panel.add(numBtn[2]);
        panel.add(funcBtn[0]);
        panel.add(funcBtn[1]);
        frame.add(panel);

        // Makes the window visible. These lines of code should always be at the bottom of the ButtonAdd class.
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    public static void main(String[] args){
        new ButtonAdd();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i <= 2; i++){
            if (e.getSource() == numBtn[i]){
                output.setText(output.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == addBtn){
            num1 = Integer.parseInt(output.getText());
            output.setText("");
        }

        if (e.getSource() == eqlBtn){
            num2 = Integer.parseInt(output.getText());
            total = num1 + num2;
            output.setText(String.valueOf(total));
            num1=total;
        }

        if (e.getSource() == clrBtn){
            num1 = 0;
            num2 = 0;
            output.setText("");
        }
    }
}