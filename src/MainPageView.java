import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPageView extends JFrame {
    private JPanel contentPane;
    private JButton createBtn;
    private JButton testBtn;
    private JButton exitBtn;

    public MainPageView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 465, 315);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("BAKERY VENDING MACHINE");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel.setBounds(35, 10, 388, 90);
        contentPane.add(lblNewLabel);

        createBtn = new JButton("Create a Vending Machine");
        createBtn.setFocusable(false);
        createBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
        createBtn.setBounds(30, 85, 393, 61);
        contentPane.add(createBtn);

        testBtn = new JButton("Test a Vending Machine");
        testBtn.setFocusable(false);
        testBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
        testBtn.setBounds(30, 158, 393, 61);
        contentPane.add(testBtn);

        exitBtn = new JButton("EXIT");
        exitBtn.setFocusable(false);
        exitBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
        exitBtn.setBounds(341, 229, 100, 38);
        contentPane.add(exitBtn);

        this.setLocationRelativeTo(null);
    }

    public void setCreateBtnListener(ActionListener listener) {
        createBtn.addActionListener(listener);
    }

    public void setTestBtnListener(ActionListener listener) {
        testBtn.addActionListener(listener);
    }

    public void setExitBtnListener(ActionListener listener) {
        exitBtn.addActionListener(listener);
    }
}
