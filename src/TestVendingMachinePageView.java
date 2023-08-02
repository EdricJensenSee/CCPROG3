import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;

/**
 * TestVendingMachinePageView GUI
 */
public class TestVendingMachinePageView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnReturn;
	private JButton btnFeatureTest;
	private JButton btnMaintance;
	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	        	try {

	        		TestVendingMachinePageView frame = new TestVendingMachinePageView("");
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
	public TestVendingMachinePageView(String machineType) {
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
		
		btnReturn = new JButton("RETURN");
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReturn.setFocusable(false);
		btnReturn.setBounds(301, 215, 125, 38);
		contentPane.add(btnReturn);
		
		btnFeatureTest = new JButton("Feature Test");
		btnFeatureTest.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFeatureTest.setFocusable(false);
		btnFeatureTest.setBounds(82, 72, 271, 61);
		contentPane.add(btnFeatureTest);
		
		btnMaintance = new JButton("Maintenance");
		btnMaintance.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMaintance.setFocusable(false);
		btnMaintance.setBounds(82, 143, 271, 61);
		contentPane.add(btnMaintance);
		this.setLocationRelativeTo(null);
	}
	
	/**
	 * Sets an ActionListener for the "btnReturn" button.
	 * @param listener The ActionListener to be added to the "btnReturn" button.
	 */
	public void setReturnfromTest(ActionListener listener) {
	    btnReturn.addActionListener(listener);
	}

	/**
	 * Sets an ActionListener for the "btnFeatureTest" button.
	 * @param listener The ActionListener to be added to the "btnFeatureTest" button.
	 * @param machineType The machine type to associate with the "btnFeatureTest" button action.
	 */
	public void btnFeatureTest(ActionListener listener) {
	    btnFeatureTest.addActionListener(listener);
	}

	/**
	 * Sets an ActionListener for the "btnMaintance" button.
	 * @param listener The ActionListener to be added to the "btnMaintance" button.
	 * @param machineType The machine type to associate with the "btnMaintance" button action.
	 */
	public void setbtnMaintance(ActionListener listener) {
	    btnMaintance.addActionListener(listener);

	}

}
