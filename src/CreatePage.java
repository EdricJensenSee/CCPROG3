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
		
		lblCreateAVending_1 = new JLabel("Create a " + machineType + " Vending Machine");
		lblCreateAVending_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAVending_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCreateAVending_1.setBounds(10, 10, 416, 90);
		contentPane.add(lblCreateAVending_1);
		
		JButton btnCreateMachine = new JButton("Create Machine");
		btnCreateMachine.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (machineType.equals("Regular")) {
		            Main.regularVendingMachine = new RegularVendingMachine();
		        } else if (machineType.equals("Special")) {
		            Main.specialVendingMachine = new SpecialVendingMachine();
		        }

		        String message = machineType + "Vending machine created successfully!";
		        JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
		    }
		});
		
		btnCreateMachine.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCreateMachine.setFocusable(false);
		btnCreateMachine.setBounds(79, 87, 271, 38);
		contentPane.add(btnCreateMachine);
		
		JButton btnAddItemsTo = new JButton("Add Items to Machine");
		btnAddItemsTo.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (machineType != null) {
		            if ((machineType.equals("Regular") && Main.regularVendingMachine != null) || (machineType.equals("Special") && Main.specialVendingMachine != null)) {
		                dispose();
		                AddItem open = new AddItem(machineType);
		                open.setVisible(true);
		            } else {
		                JOptionPane.showMessageDialog(null, "The " + machineType + " Machine Has Not Been Created", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Machine Has Not Been Created", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});

		btnAddItemsTo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddItemsTo.setFocusable(false);
		btnAddItemsTo.setBounds(79, 135, 271, 38);
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
		
		JButton btnResetMachine = new JButton("Reset Machine");
		btnResetMachine.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (machineType.equals("Regular")) {
		            Main.regularVendingMachine = new RegularVendingMachine();
		        } else if (machineType.equals("Special")) {
		            Main.specialVendingMachine = new SpecialVendingMachine();
		        }
		        JOptionPane.showMessageDialog(null, machineType + " Machine reset", "Reset Confirmation", JOptionPane.INFORMATION_MESSAGE);
		    }
		});

		btnResetMachine.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnResetMachine.setFocusable(false);
		btnResetMachine.setBounds(79, 183, 271, 38);
		contentPane.add(btnResetMachine);
		this.setLocationRelativeTo(null);
	}

}
