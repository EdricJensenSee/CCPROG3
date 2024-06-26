import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;

/**
 * TestPageView
 */
public class TestPageView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnRegularVendingMachine;
	private JButton btnSpecialVendingMachine;
	private JButton btnReturn;
	public TestPageView() {
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
	
	/**
	 * Sets an ActionListener for the "btnRegularVendingMachine" button.
	 * @param listener The ActionListener to be added to the "btnRegularVendingMachine" button.
	 */
	public void setTestRegularBtnListener(ActionListener listener) {
	    btnRegularVendingMachine.addActionListener(listener);
	}

	/**
	 * Sets an ActionListener for the "btnSpecialVendingMachine" button.
	 * @param listener The ActionListener to be added to the "btnSpecialVendingMachine" button.
	 */
	public void setTestSpecialBtnListener(ActionListener listener) {
	    btnSpecialVendingMachine.addActionListener(listener);
	}

	/**
	 * Sets an ActionListener for the "btnReturn" button.
	 * @param listener The ActionListener to be added to the "btnReturn" button.
	 */
	public void setTestReturnBtnListener(ActionListener listener) {
	    btnReturn.addActionListener(listener);
	}
}
