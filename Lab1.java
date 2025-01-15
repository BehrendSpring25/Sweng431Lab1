import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class Lab1 extends JFrame {
    private static final long serialVersionUID = 1L;
    private static JPanel panel1, panel2, buttonPanel;
    private static JTextField text1, text2;
    private static JLabel label1, label2;
    private static JButton button1;
    public Lab1() {
        setTitle("GUI");
        setSize(400, 300);

        panel1 = new JPanel();
        label1 = new JLabel("Name");
        text1 = new JTextField(10);
        panel1.add(label1);
        panel1.add(text1);

        panel2 = new JPanel();
        label2 = new JLabel("Age");
        text2 = new JTextField(10);
        panel2.add(label2);
        panel2.add(text2);

        buttonPanel = new JPanel();
        button1 = new JButton("Submit");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (text1.getText().length() > 15) {
                    JOptionPane.showMessageDialog(Lab1.this, "Phone number cannot be longer than 15 digits!");
                } else if (text1.getText().length() == 0) {
                    JOptionPane.showMessageDialog(Lab1.this, "Phone number cannot be empty!");
                }
            }
        });

        buttonPanel.add(button1);
        add(panel1, BorderLayout.NORTH);
        add(panel2, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Lab1 frame = new Lab1();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
    public void show(JPanel cards, String one) {
    }
}
