import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateVendingMachine extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateVendingMachine frame = new CreateVendingMachine();
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
	public CreateVendingMachine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreateAVending = new JLabel("CREATE A VENDING MACHINE");
		lblCreateAVending.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCreateAVending.setBounds(10, 0, 416, 90);
		contentPane.add(lblCreateAVending);
		
		JButton btnRegularVendingMachine = new JButton("Regular Vending Machine");
		btnRegularVendingMachine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CreatePage open= new CreatePage("Regular");
				open.setVisible(true);
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
				CreatePage open= new CreatePage("Special");
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
