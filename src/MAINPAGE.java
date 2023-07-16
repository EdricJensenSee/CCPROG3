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

public class MAINPAGE extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MAINPAGE frame = new MAINPAGE();
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
	public MAINPAGE() {
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
		
		JButton btnNewButton = new JButton("Create a Vending Machine");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CreateVendingMachine open = new CreateVendingMachine();
				open.setVisible(true);
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(30, 85, 393, 61);
		contentPane.add(btnNewButton);
		
		JButton btnTestAVending = new JButton("Test a Vending Machine");
		btnTestAVending.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TestVendingMachine open = new TestVendingMachine();
				open.setVisible(true);
			}
		});
		btnTestAVending.setFocusable(false);
		btnTestAVending.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTestAVending.setBounds(30, 158, 393, 61);
		contentPane.add(btnTestAVending);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setFocusable(false);
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExit.setBounds(341, 229, 100, 38);
		contentPane.add(btnExit);
		this.setLocationRelativeTo(null);
	}
}
