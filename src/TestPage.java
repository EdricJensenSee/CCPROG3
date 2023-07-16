import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestPage frame = new TestPage("");
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
	public TestPage(String machineType) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreateAVending_1 = new JLabel("Test a " + machineType + " Vending Machine");
		lblCreateAVending_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAVending_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCreateAVending_1.setBounds(10, 0, 416, 90);
		contentPane.add(lblCreateAVending_1);
		
		JButton btnReturn = new JButton("RETURN");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TestVendingMachine open = new TestVendingMachine();
				open.setVisible(true);
			}
		});
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReturn.setFocusable(false);
		btnReturn.setBounds(301, 215, 125, 38);
		contentPane.add(btnReturn);
		
		JButton btnFeatureTest = new JButton("Feature Test");
		btnFeatureTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				REGULARMACHINE open = new REGULARMACHINE();
				open.setVisible(true);
			}
		});
		btnFeatureTest.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFeatureTest.setFocusable(false);
		btnFeatureTest.setBounds(82, 72, 271, 61);
		contentPane.add(btnFeatureTest);
		
		JButton btnMaintance = new JButton("Maintance");
		btnMaintance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MaintenancePage open = new MaintenancePage(machineType);
				open.setVisible(true);
			}
		});
		btnMaintance.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMaintance.setFocusable(false);
		btnMaintance.setBounds(82, 143, 271, 61);
		contentPane.add(btnMaintance);
		this.setLocationRelativeTo(null);
	}

}
