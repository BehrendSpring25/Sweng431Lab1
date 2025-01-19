import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Lab1 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel panel1, panel2, buttonPanel;
    private JTextField text1, text2;
    private JLabel label1, label2;
    private JButton button1;

    public Lab1() {
        setTitle("GUI");
        setSize(400, 300);

        //name panel
        panel1 = new JPanel();
        label1 = new JLabel("Name");
        text1 = new JTextField(15);
        panel1.add(label1);
        panel1.add(text1);
        //throw error if name is invalid, catch and change background color
        text1.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                try {
                    Utility.checkName(text1.getText());
                    text1.setBackground(Color.WHITE);
                } catch (IllegalArgumentException ex) {
                    text1.setBackground(Color.PINK);
                }
            }
        });

        //age panel
        panel2 = new JPanel();
        label2 = new JLabel("Age");
        text2 = new JTextField(5);
        panel2.add(label2);
        panel2.add(text2);
        //throw error if age is invalid, catch and change background color
        text2.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                try {
                    Utility.checkAge(text2.getText());
                    text2.setBackground(Color.WHITE);
                } catch (IllegalArgumentException ex) {
                    text2.setBackground(Color.PINK);
                }
            }
        });

        //button panel
        buttonPanel = new JPanel();
        button1 = new JButton("Submit");

        //action listener for the button
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = text1.getText();
                String ageStr = text2.getText();
                try {
                    //validate name and age with utility class
                    Utility.checkName(name);
                    Utility.checkAge(ageStr);
                    JOptionPane.showMessageDialog(Lab1.this, "Validation Successful!");
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(Lab1.this, ex.getMessage(), "Validation Error", JOptionPane.ERROR_MESSAGE);
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
}
