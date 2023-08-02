import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

/**
 *  CreatePageView
 */
public class CreatePageView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel Name;
	private JTextField p1;
	private JTextField p2;
	private JTextField p3;
	private JTextField p4;
	private JButton p5;
	private JLabel p21;
	private JLabel p22, productName;
	private JLabel p23;
	private JLabel p24;
	private JButton create;
	private JButton add;
	private JButton reset;
	private JButton btnReturn, btnNewButton;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreatePageView frame = new CreatePageView("");
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
	public CreatePageView(String machineType) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		p4 = new JTextField();
		p4.setVisible(false);
		p4.setToolTipText("Fourth Part");
		p4.setColumns(10);
		p4.setBounds(128, 192, 271, 25);
		contentPane.add(p4);
		
		p3 = new JTextField();
		p3.setVisible(false);
		p3.setToolTipText("Third Part");
		p3.setColumns(10);
		p3.setBounds(128, 157, 271, 25);
		contentPane.add(p3);
		
		p2 = new JTextField();
		p2.setVisible(false);
		p2.setColumns(10);
		p2.setBounds(128, 122, 271, 25);
		contentPane.add(p2);
		
		p1 = new JTextField();
		p1.setVisible(false);
		p1.setToolTipText("First Part");
		p1.setColumns(10);
		p1.setBounds(128, 87, 271, 25);
		contentPane.add(p1);
		
		Name = new JLabel("Create a " + machineType + " Vending Machine");
		Name.setHorizontalAlignment(SwingConstants.CENTER);
		Name.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Name.setBounds(10, 10, 416, 90);
		contentPane.add(Name);
		add = new JButton("Add Items to Machine");
		add.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add.setFocusable(false);
		add.setBounds(79, 135, 271, 38);
		contentPane.add(add);
		
		reset = new JButton("Reset Machine");
		reset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		reset.setFocusable(false);
		reset.setBounds(79, 183, 271, 38);
		contentPane.add(reset);
		
		create = new JButton("Create Machine");
		create.setFont(new Font("Tahoma", Font.PLAIN, 20));
		create.setFocusable(false);
		create.setBounds(79, 87, 271, 38);
		contentPane.add(create);
		
		contentPane.add(add);
		
		btnReturn = new JButton("RETURN");
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnReturn.setFocusable(false);
		btnReturn.setBounds(326, 257, 110, 35);
		contentPane.add(btnReturn);
		
		contentPane.add(reset);
		
		p5 = new JButton("Add Recipe");
		p5.setFocusable(false);
		p5.setVisible(false);
		p5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		p5.setBounds(166, 262, 100, 25);
		contentPane.add(p5);
		
		p21 = new JLabel("Cake Base");
		p21.setVisible(false);
		p21.setBounds(42, 93, 76, 13);
		contentPane.add(p21);
		
		p22 = new JLabel("Filling");
		p22.setVisible(false);
		p22.setBounds(42, 128, 76, 13);
		contentPane.add(p22);
		
		p23 = new JLabel("Frosting");
		p23.setVisible(false);
		p23.setBounds(42, 163, 76, 13);
		contentPane.add(p23);
		
		p24 = new JLabel("Topping");
		p24.setVisible(false);
		p24.setBounds(42, 200, 76, 13);
		contentPane.add(p24);
		if (Main.specialVendingMachine == null)
			p5.setEnabled(false);
		btnNewButton = new JButton("Create ");
		btnNewButton.setBounds(326, 221, 110, 35);
		btnNewButton.setVisible(false);
		btnNewButton.setFocusable(false);
		contentPane.add(btnNewButton);
		
		productName = new JLabel("Product Name");
		productName.setBounds(42, 232, 86, 13);
		contentPane.add(productName);
		
		textField = new JTextField();
		textField.setBounds(134, 227, 192, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		productName.setVisible(false);
		textField.setVisible(false);
		this.setLocationRelativeTo(null);
	}

	/**
	 * Gets the product name from the text field.
	 * @return The product name as a String.
	 */
	public String getProductName() {
	    return textField.getText();
	}

	/**
	 * Enables the recipe for the product.
	 */
	public void enableRecipe() {
	    p5.setEnabled(true);
	}

	/**
	 * Sets an ActionListener for the "Create" button.
	 * @param listener The ActionListener to be added to the "Create" button.
	 */
	public void setCreate(ActionListener listener) {
	    btnNewButton.addActionListener(listener);
	}

	/**
	 * Sets an ActionListener for the "Create Machine" button.
	 * @param listener The ActionListener to be added to the "Create Machine" button.
	 */
	public void setCreateMachineBtnListener(ActionListener listener) {
	    create.addActionListener(listener);
	}

	/**
	 * Sets an ActionListener for the "Add Items" button.
	 * @param listener The ActionListener to be added to the "Add Items" button.
	 */
	public void setAddItemsBtnListener(ActionListener listener) {
	    add.addActionListener(listener);
	}

	/**
	 * Sets an ActionListener for the "Reset Machine" button.
	 * @param listener The ActionListener to be added to the "Reset Machine" button.
	 */
	public void setResetMachineBtnListener(ActionListener listener) {
	    reset.addActionListener(listener);
	}

	/**
	 * Sets an ActionListener for the "Return" button.
	 * @param listener The ActionListener to be added to the "Return" button.
	 */
	public void setReturnBtnListener(ActionListener listener) {
	    btnReturn.addActionListener(listener);
	}

	/**
	 * Sets an ActionListener for the button.
	 * @param listener The ActionListener to be added to the "Create Custom Machine" button.
	 */
	public void setCreateCustomMachineBtnListener(ActionListener listener) {
	    p5.addActionListener(listener);
	}

	/**
	 * Gets the text entered in the first part field.
	 * @return The text in the first part field as a String.
	 */
	public String getPart1() {
	    return p1.getText();
	}

	/**
	 * Gets the text entered in the second part field.
	 * @return The text in the second part field as a String.
	 */
	public String getPart2() {
	    return p2.getText();
	}

	/**
	 * Gets the text entered in the third part field.
	 * @return The text in the third part field as a String.
	 */
	public String getPart3() {
	    return p3.getText();
	}

	/**
	 * Gets the text entered in the fourth part field.
	 * @return The text in the fourth part field as a String.
	 */
	public String getPart4() {
	    return p4.getText();
	}

	/**
	 * Shows customization fields on the GUI.
	 */
	public void showCustomizationFields() {
	    Name.setText("Input Customizations");
	    p1.setVisible(true);
	    p2.setVisible(true);
	    p3.setVisible(true);
	    p4.setVisible(true);
	    p5.setVisible(true);
	    p21.setVisible(true);
	    p22.setVisible(true);
	    p23.setVisible(true);
	    p24.setVisible(true);
	    productName.setVisible(true);
	    textField.setVisible(true);
	    btnNewButton.setVisible(true);
	    create.setVisible(false);
	    add.setVisible(false);
	    reset.setVisible(false);
	}

}
