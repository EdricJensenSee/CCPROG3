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

public class CreateVendingMachineView extends JFrame {

	private JPanel contentPane;
	private JButton btnRegularVendingMachine;
	private JButton btnSpecialVendingMachine;
	private JButton btnReturn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateVendingMachineView frame = new CreateVendingMachineView();
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
	public CreateVendingMachineView() {
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
		
		btnRegularVendingMachine = new JButton("Regular Vending Machine");
		btnRegularVendingMachine.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegularVendingMachine.setFocusable(false);
		btnRegularVendingMachine.setBounds(20, 73, 393, 61);
		contentPane.add(btnRegularVendingMachine);
		
		btnSpecialVendingMachine = new JButton("Special Vending Machine");
		btnSpecialVendingMachine.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSpecialVendingMachine.setFocusable(false);
		btnSpecialVendingMachine.setBounds(20, 154, 393, 61);
		contentPane.add(btnSpecialVendingMachine);
		
		btnReturn = new JButton("RETURN");
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReturn.setFocusable(false);
		btnReturn.setBounds(301, 225, 125, 38);
		contentPane.add(btnReturn);
		this.setLocationRelativeTo(null);
	}
	
    public void setAddBtnListener(ActionListener listener) {
        btnRegularVendingMachine.addActionListener(listener);
    }

    public void setViewBtnListener(ActionListener listener) {
        btnSpecialVendingMachine.addActionListener(listener);
    }
    
    public void btnReturner(ActionListener listener) {
    	btnReturn.addActionListener(listener);
    }


}
