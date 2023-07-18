import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestVendingMachine extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestVendingMachine frame = new TestVendingMachine();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestVendingMachine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreateAVending = new JLabel("TEST A VENDING MACHINE");
		lblCreateAVending.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCreateAVending.setBounds(20, 0, 416, 90);
		contentPane.add(lblCreateAVending);
		
		JButton btnRegularVendingMachine = new JButton("Regular Vending Machine");
		btnRegularVendingMachine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Main.regularVendingMachine == null) {
                    String message = "The vending machine hasn't been created!";
                    JOptionPane.showMessageDialog(null, message, "Machine Not Created", JOptionPane.WARNING_MESSAGE);
                } else {
                	dispose();
                	TestPage open= new TestPage("Regular");
                	open.setVisible(true);
                }
			}
		});
		btnRegularVendingMachine.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegularVendingMachine.setFocusable(false);
		btnRegularVendingMachine.setBounds(20, 73, 393, 61);
		contentPane.add(btnRegularVendingMachine);
		
		JButton btnSpecialVendingMachine = new JButton("Special Vending Machine");
		btnSpecialVendingMachine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TestPage open= new TestPage("Special");
				open.setVisible(true);
			}
		});
		btnSpecialVendingMachine.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSpecialVendingMachine.setFocusable(false);
		btnSpecialVendingMachine.setBounds(20, 154, 393, 61);
		contentPane.add(btnSpecialVendingMachine);
		
		JButton btnReturn = new JButton("RETURN");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MAINPAGE open = new MAINPAGE();
				open.setVisible(true);
			}
		});
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReturn.setFocusable(false);
		btnReturn.setBounds(301, 225, 125, 38);
		contentPane.add(btnReturn);
		this.setLocationRelativeTo(null);
		}

}
