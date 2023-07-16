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
import javax.swing.SwingConstants;

public class CreatePage extends JFrame {

	private JPanel contentPane;
	private JLabel lblCreateAVending_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreatePage frame = new CreatePage("");
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
	public CreatePage(String machineType) {
		Main main = new Main();// Declare the variable outside the if-else blocks
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreateAVending = new JLabel("Create a Vending Machine");
		lblCreateAVending_1 = new JLabel("Create a " + machineType + " Vending Machine");
		lblCreateAVending_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAVending_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCreateAVending_1.setBounds(10, 10, 416, 90);
		contentPane.add(lblCreateAVending_1);
		
		JButton btnCreateMachine = new JButton("Create Machine");
		btnCreateMachine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        if (machineType.equals("Regular")) {
		        	main.regularVendingMachine.getItem().addItem("Chicken", 1, 1, 1);
		        	main.regularVendingMachine.displayStock();
		           	main.regularVendingMachine = new RegularVendingMachine(); 
		           	main.regularVendingMachine.displayStock();
		        } else if (machineType.equals("Special")) {
		        	main.specialVendingMachine = new SpecialVendingMachine(); 
		        }
		        
			}
		});


		btnCreateMachine.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCreateMachine.setFocusable(false);
		btnCreateMachine.setBounds(79, 87, 271, 61);
		contentPane.add(btnCreateMachine);
		
		JButton btnAddItemsTo = new JButton("Add Items to Machine");
		btnAddItemsTo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddItemsTo.setFocusable(false);
		btnAddItemsTo.setBounds(79, 168, 271, 61);
		contentPane.add(btnAddItemsTo);
		
		JButton btnReturn = new JButton("RETURN");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CreateVendingMachine open = new CreateVendingMachine();
				open.setVisible(true);
			}
		});
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReturn.setFocusable(false);
		btnReturn.setBounds(301, 239, 125, 38);
		contentPane.add(btnReturn);
		this.setLocationRelativeTo(null);
	}

}
