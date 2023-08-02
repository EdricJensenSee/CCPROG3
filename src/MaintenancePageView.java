import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * MaintenancePageView GUI.
 */
public class MaintenancePageView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel C1;
	private JLabel one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve;
	private JTextField namefield;
	private JTextField qtyfield;
	private JTextField pricefield;
	private JTextField calfield;
	private JLabel Change, Finish, Receipt, name, cal, qty, price;
	private JButton btnAdd, b5, b4, b3, b2, b1, btnNewButton_1_1_2_1, btnNewButton_1_2, btnNewButton_1, btnNewButton_1_1_1, btnNewButton_1_1, btnNewButton_1_2_1_1, btnCustomize;
	private static int CurNum = 0;
	private static boolean customize = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MaintenancePageView frame = new MaintenancePageView("");
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
	public MaintenancePageView(String machineType) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 511);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(255, 0, 0), 5, true));
		panel_2.setBounds(370, 10, 120, 446);
		contentPane.add(panel_2);
		
				
		btnAdd = new JButton("Add Item");
		btnAdd.setVisible(false);	
	    
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAdd.setFocusable(false);
		btnAdd.setBounds(245, 379, 101, 18);
				
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		panel.setBounds(10, 10, 361, 446);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Change = new JLabel("");
		Change.setHorizontalTextPosition(SwingConstants.LEADING);
		Change.setVerticalAlignment(SwingConstants.TOP);
		Change.setHorizontalAlignment(SwingConstants.CENTER);
		Change.setFont(new Font("Tahoma", Font.PLAIN, 10));
		Change.setBounds(10, 311, 100, 125);
		panel_2.add(Change);
		
		b5 = new JButton("5");
		b5.setVisible(false);		
		Receipt = new JLabel("");
		Receipt.setVerticalAlignment(SwingConstants.TOP);
		Receipt.setHorizontalTextPosition(SwingConstants.LEADING);
		Receipt.setHorizontalAlignment(SwingConstants.LEFT);
		Receipt.setFont(new Font("Tahoma", Font.PLAIN, 10));
		Receipt.setBounds(98, 333, 253, 103);
		panel.add(Receipt);
		b5.setBounds(170, 372, 85, 21);
		panel.add(b5);
		
		b4 = new JButton("10");
		b4.setVisible(false);
		b4.setBounds(78, 372, 85, 21);
		panel.add(b4);
		
		b3 = new JButton("20");
		b3.setVisible(false);
		b3.setBounds(224, 335, 85, 21);
		panel.add(b3);
		
		b2 = new JButton("50");
		b2.setVisible(false);
		b2.setBounds(129, 335, 85, 21);
		panel.add(b2);
		
		b1 = new JButton("100");
		b1.setVisible(false);
		b1.setBounds(34, 335, 85, 21);
		panel.add(b1);
		
		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setOpaque(true);
		lblNewLabel_3_2.setBackground(Color.BLACK);
		lblNewLabel_3_2.setBounds(13, 217, 338, 13);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setOpaque(true);
		lblNewLabel_3_1.setBackground(Color.BLACK);
		lblNewLabel_3_1.setBounds(13, 145, 338, 13);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_3 = new JLabel("");
		lblNewLabel_3_3.setOpaque(true);
		lblNewLabel_3_3.setBackground(Color.BLACK);
		lblNewLabel_3_3.setBounds(13, 287, 338, 13);
		panel.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(13, 74, 338, 13);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setOpaque(true);
		
		Finish = new JLabel("");
		Finish.setHorizontalAlignment(SwingConstants.CENTER);
		Finish.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Finish.setBounds(13, 12, 326, 18);
		panel.add(Finish);
		
		JPanel A1 = new JPanel();
		A1.setBackground(Color.LIGHT_GRAY);
		A1.setBorder(null);
		A1.setBounds(13, 40, 106, 71);
		panel.add(A1);
		A1.setLayout(null);
		
		one = new JLabel("New label");
		one.setHorizontalAlignment(SwingConstants.CENTER);
		one.setHorizontalTextPosition(SwingConstants.CENTER);
		one.setBounds(0, 0, 106, 33);
		A1.add(one);
		
		JLabel lblNewLabel_7_1 = new JLabel("A1");
		lblNewLabel_7_1.setForeground(Color.WHITE);
		lblNewLabel_7_1.setOpaque(true);
		lblNewLabel_7_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1.setBounds(25, 48, 57, 23);
		A1.add(lblNewLabel_7_1);
		
		JPanel A2 = new JPanel();
		A2.setBackground(Color.LIGHT_GRAY);
		A2.setLayout(null);
		A2.setBorder(null);
		A2.setBounds(129, 40, 106, 71);
		panel.add(A2);
		
		two = new JLabel("New label");
		two.setHorizontalAlignment(SwingConstants.CENTER);
		two.setHorizontalTextPosition(SwingConstants.CENTER);
		two.setBounds(0, 0, 106, 33);
		A2.add(two);
		
		JLabel lblNewLabel_7_1_1 = new JLabel("A2");
		lblNewLabel_7_1_1.setOpaque(true);
		lblNewLabel_7_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1_1.setForeground(Color.WHITE);
		lblNewLabel_7_1_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_7_1_1.setBounds(25, 48, 57, 23);
		A2.add(lblNewLabel_7_1_1);
		
		JPanel A3 = new JPanel();
		A3.setBackground(Color.LIGHT_GRAY);
		A3.setLayout(null);
		A3.setBorder(null);
		A3.setBounds(245, 40, 106, 71);
		panel.add(A3);
		
		three = new JLabel("New label");
		three.setHorizontalAlignment(SwingConstants.CENTER);
		three.setHorizontalTextPosition(SwingConstants.CENTER);
		three.setBounds(0, 0, 106, 35);
		A3.add(three);
		
		JLabel lblNewLabel_7_1_2 = new JLabel("A3");
		lblNewLabel_7_1_2.setOpaque(true);
		lblNewLabel_7_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1_2.setForeground(Color.WHITE);
		lblNewLabel_7_1_2.setBackground(Color.DARK_GRAY);
		lblNewLabel_7_1_2.setBounds(25, 48, 57, 23);
		A3.add(lblNewLabel_7_1_2);
		
		JPanel B1 = new JPanel();
		B1.setBackground(Color.LIGHT_GRAY);
		B1.setLayout(null);
		B1.setBorder(null);
		B1.setBounds(13, 112, 106, 71);
		panel.add(B1);
		
		four = new JLabel("New label");
		four.setHorizontalAlignment(SwingConstants.CENTER);
		four.setHorizontalTextPosition(SwingConstants.CENTER);
		four.setBounds(0, 0, 106, 33);
		B1.add(four);
		
		JLabel lblNewLabel_7_1_3 = new JLabel("B1");
		lblNewLabel_7_1_3.setOpaque(true);
		lblNewLabel_7_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1_3.setForeground(Color.WHITE);
		lblNewLabel_7_1_3.setBackground(Color.DARK_GRAY);
		lblNewLabel_7_1_3.setBounds(26, 48, 57, 23);
		B1.add(lblNewLabel_7_1_3);
		
		JPanel B2 = new JPanel();
		B2.setBackground(Color.LIGHT_GRAY);
		B2.setLayout(null);
		B2.setBorder(null);
		B2.setBounds(129, 112, 106, 71);
		panel.add(B2);
		
		five = new JLabel("New label");
		five.setHorizontalAlignment(SwingConstants.CENTER);
		five.setHorizontalTextPosition(SwingConstants.CENTER);
		five.setBounds(0, 0, 106, 33);
		B2.add(five);
		
		JLabel lblNewLabel_7_1_4 = new JLabel("B2");
		lblNewLabel_7_1_4.setOpaque(true);
		lblNewLabel_7_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1_4.setForeground(Color.WHITE);
		lblNewLabel_7_1_4.setBackground(Color.DARK_GRAY);
		lblNewLabel_7_1_4.setBounds(25, 48, 57, 23);
		B2.add(lblNewLabel_7_1_4);
		
		JPanel B3 = new JPanel();
		B3.setBackground(Color.LIGHT_GRAY);
		B3.setLayout(null);
		B3.setBorder(null);
		B3.setBounds(245, 112, 106, 71);
		panel.add(B3);
		
		six = new JLabel("New label");
		six.setHorizontalAlignment(SwingConstants.CENTER);
		six.setHorizontalTextPosition(SwingConstants.CENTER);
		six.setBounds(0, 0, 106, 32);
		B3.add(six);
		
		JLabel lblNewLabel_7_1_5 = new JLabel("B3");
		lblNewLabel_7_1_5.setOpaque(true);
		lblNewLabel_7_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1_5.setForeground(Color.WHITE);
		lblNewLabel_7_1_5.setBackground(Color.DARK_GRAY);
		lblNewLabel_7_1_5.setBounds(25, 48, 57, 23);
		B3.add(lblNewLabel_7_1_5);
		
		C1 = new JPanel();
		C1.setBackground(Color.LIGHT_GRAY);
		C1.setLayout(null);
		C1.setBorder(null);
		C1.setBounds(13, 183, 106, 71);
		panel.add(C1);
		
		seven = new JLabel("C1");
		seven.setHorizontalTextPosition(SwingConstants.CENTER);
		seven.setHorizontalAlignment(SwingConstants.CENTER);
		seven.setBounds(0, 0, 106, 33);
		C1.add(seven);
		
		JLabel lblNewLabel_7_1_8 = new JLabel("C1");
		lblNewLabel_7_1_8.setOpaque(true);
		lblNewLabel_7_1_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1_8.setForeground(Color.WHITE);
		lblNewLabel_7_1_8.setBackground(Color.DARK_GRAY);
		lblNewLabel_7_1_8.setBounds(25, 48, 57, 23);
		C1.add(lblNewLabel_7_1_8);
		
		JPanel D1 = new JPanel();
		D1.setBackground(Color.LIGHT_GRAY);
		D1.setLayout(null);
		D1.setBorder(null);
		D1.setBounds(13, 254, 106, 71);
		panel.add(D1);
		
		ten = new JLabel("New label");
		ten.setHorizontalAlignment(SwingConstants.CENTER);
		ten.setHorizontalTextPosition(SwingConstants.CENTER);
		ten.setBounds(0, 0, 106, 33);
		D1.add(ten);
		
		JLabel lblNewLabel_7_1_9 = new JLabel("D1");
		lblNewLabel_7_1_9.setOpaque(true);
		lblNewLabel_7_1_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1_9.setForeground(Color.WHITE);
		lblNewLabel_7_1_9.setBackground(Color.DARK_GRAY);
		lblNewLabel_7_1_9.setBounds(25, 48, 57, 23);
		D1.add(lblNewLabel_7_1_9);
		
		JPanel C2 = new JPanel();
		C2.setBackground(Color.LIGHT_GRAY);
		C2.setLayout(null);
		C2.setBorder(null);
		C2.setBounds(129, 183, 106, 71);
		panel.add(C2);
		
		eight = new JLabel("New label");
		eight.setHorizontalAlignment(SwingConstants.CENTER);
		eight.setHorizontalTextPosition(SwingConstants.CENTER);
		eight.setBounds(0, 0, 106, 35);
		C2.add(eight);
		
		JLabel lblNewLabel_7_1_7 = new JLabel("C2");
		lblNewLabel_7_1_7.setOpaque(true);
		lblNewLabel_7_1_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1_7.setForeground(Color.WHITE);
		lblNewLabel_7_1_7.setBackground(Color.DARK_GRAY);
		lblNewLabel_7_1_7.setBounds(25, 48, 57, 23);
		C2.add(lblNewLabel_7_1_7);
		
		JPanel C3 = new JPanel();
		C3.setBackground(Color.LIGHT_GRAY);
		C3.setLayout(null);
		C3.setBorder(null);
		C3.setBounds(245, 183, 106, 71);
		panel.add(C3);
		
		nine = new JLabel("New label");
		nine.setHorizontalAlignment(SwingConstants.CENTER);
		nine.setHorizontalTextPosition(SwingConstants.CENTER);
		nine.setBounds(0, 0, 106, 33);
		C3.add(nine);
		
		JLabel lblNewLabel_7_1_6 = new JLabel("C3");
		lblNewLabel_7_1_6.setOpaque(true);
		lblNewLabel_7_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1_6.setForeground(Color.WHITE);
		lblNewLabel_7_1_6.setBackground(Color.DARK_GRAY);
		lblNewLabel_7_1_6.setBounds(25, 48, 57, 23);
		C3.add(lblNewLabel_7_1_6);
		
		JPanel D2 = new JPanel();
		D2.setBackground(Color.LIGHT_GRAY);
		D2.setLayout(null);
		D2.setBorder(null);
		D2.setBounds(129, 254, 106, 71);
		panel.add(D2);
		
		eleven = new JLabel("New label");
		eleven.setHorizontalAlignment(SwingConstants.CENTER);
		eleven.setHorizontalTextPosition(SwingConstants.CENTER);
		eleven.setBounds(0, 0, 106, 33);
		D2.add(eleven);
		
		JLabel lblNewLabel_7_1_10 = new JLabel("D2");
		lblNewLabel_7_1_10.setOpaque(true);
		lblNewLabel_7_1_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1_10.setForeground(Color.WHITE);
		lblNewLabel_7_1_10.setBackground(Color.DARK_GRAY);
		lblNewLabel_7_1_10.setBounds(25, 48, 57, 23);
		D2.add(lblNewLabel_7_1_10);
		
		JPanel D3 = new JPanel();
		D3.setBackground(Color.LIGHT_GRAY);
		D3.setLayout(null);
		D3.setBorder(null);
		D3.setBounds(245, 254, 106, 71);
		panel.add(D3);
		
		JLabel lblNewLabel_7_1_11 = new JLabel("D3");
		lblNewLabel_7_1_11.setOpaque(true);
		lblNewLabel_7_1_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1_11.setForeground(Color.WHITE);
		lblNewLabel_7_1_11.setBackground(Color.DARK_GRAY);
		lblNewLabel_7_1_11.setBounds(25, 48, 57, 23);
		D3.add(lblNewLabel_7_1_11);
		
		twelve = new JLabel("asasa");
		twelve.setHorizontalTextPosition(SwingConstants.CENTER);
		twelve.setHorizontalAlignment(SwingConstants.CENTER);
		twelve.setBounds(0, 0, 106, 33);
		D3.add(twelve);
		
		btnNewButton_1_1_2_1 = new JButton("Return");
		btnNewButton_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1_1_2_1.setFocusable(false);
		btnNewButton_1_1_2_1.setBounds(13, 403, 79, 19);
		panel.add(btnNewButton_1_1_2_1);
		
		namefield = new JTextField();
		namefield.setVisible(false);
		namefield.setColumns(10);
		namefield.setBounds(68, 349, 50, 19);
		panel.add(namefield);
		
		name = new JLabel("Item Name");
		name.setVisible(false);
		name.setHorizontalTextPosition(SwingConstants.CENTER);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setBounds(14, 335, 160, 13);
		panel.add(name);
		
		qtyfield = new JTextField();
		qtyfield.setVisible(false);
		qtyfield.setColumns(10);
		qtyfield.setBounds(184, 349, 50, 19);
		panel.add(qtyfield);
		
		qty = new JLabel("Quantity");
		qty.setVisible(false);
		qty.setHorizontalTextPosition(SwingConstants.CENTER);
		qty.setHorizontalAlignment(SwingConstants.CENTER);
		qty.setBounds(184, 335, 50, 13);
		panel.add(qty);
		
		price = new JLabel("Price");
		price.setVisible(false);
		price.setHorizontalTextPosition(SwingConstants.CENTER);
		price.setHorizontalAlignment(SwingConstants.CENTER);
		price.setBounds(240, 335, 46, 13);
		panel.add(price);
		
		pricefield = new JTextField();
		pricefield.setVisible(false);
		pricefield.setColumns(10);
		pricefield.setBounds(240, 349, 46, 19);
		panel.add(pricefield);
		
		cal = new JLabel("Calories");
		cal.setVisible(false);
		cal.setHorizontalTextPosition(SwingConstants.CENTER);
		cal.setHorizontalAlignment(SwingConstants.CENTER);
		cal.setBounds(288, 335, 63, 13);
		panel.add(cal);
		
		btnNewButton_1_2 = new JButton("Add items");
		btnNewButton_1 = new JButton("Restock");
		btnNewButton_1_1_1 = new JButton("<html><center>Change<br>Prices</center></html>");		
		btnNewButton_1_1 = new JButton("Replenish");
		btnNewButton_1_1.setFocusable(false);
		btnNewButton_1_1.setBounds(10, 163, 100, 41);
		panel_2.add(btnNewButton_1_1);
		
		btnNewButton_1_2_1_1 = new JButton("Receipt");
		btnNewButton_1_2_1_1.setFocusable(false);
		btnNewButton_1_2_1_1.setBounds(10, 265, 100, 41);
		panel_2.add(btnNewButton_1_2_1_1);
		
		btnNewButton_1_1_1.setFocusable(false);
		btnNewButton_1_1_1.setBounds(10, 214, 100, 41);
		panel_2.add(btnNewButton_1_1_1);

		
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBounds(10, 60, 100, 41);
		panel_2.add(btnNewButton_1);
		
		btnNewButton_1_2.setFocusable(false);
		btnNewButton_1_2.setBounds(10, 111, 100, 41);
		panel_2.add(btnNewButton_1_2);
		itemAdder(machineType);
		btnCustomize = new JButton("Customize");
		btnCustomize.setBounds(10, 417, 100, 19);
		panel_2.add(btnCustomize);
		btnCustomize.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCustomize.setFocusable(false);
			
		calfield = new JTextField();
		calfield.setVisible(false);
		calfield.setColumns(10);
		calfield.setBounds(296, 349, 46, 19);
		panel.add(calfield);
		panel.add(btnAdd);
		if (machineType.equals("Special"))
			btnCustomize.setVisible(true);
		else if (machineType.equals("Regular"))
			btnCustomize.setVisible(false);

		this.setLocationRelativeTo(null);
	}
	
	/**
	 * Sets the text of the "Receipt" component to the given newText.
	 *
	 * @param newText The text to set in the "Receipt" component.
	 */
	public void setReceiptText(String newText) {
	    // Sets the text of the "Receipt" component to the provided newText.
	    Receipt.setText(newText);
	}

	/**
	 * Sets the text of the "Finish" component to the given newText.
	 *
	 * @param newText The text to set in the "Finish" component.
	 */
	public void setFinish(String newText) {
	    // Sets the text of the "Finish" component to the provided newText.
	    Finish.setText(newText);
	}

	/**
	 * Returns the text of the "btnCustomize" button.
	 *
	 * @return The text of the "btnCustomize" button.
	 */
	public String getbtnCustomize() {
	    // Returns the current text of the "btnCustomize" button.
	    return btnCustomize.getText();
	}

	/**
	 * Sets the text of the "btnCustomize" button to the given newText.
	 *
	 * @param newText The text to set in the "btnCustomize" button.
	 */
	public void setbtnCustomize(String newText) {
	    // Sets the text of the "btnCustomize" button to the provided newText.
	    btnCustomize.setText(newText);
	}

	/**
	 * Sets the text of the "Change" component to the given newText.
	 *
	 * @param newText The text to set in the "Change" component.
	 */
	public void setChange(String newText) {
	    // Sets the text of the "Change" component to the provided newText.
	    Change.setText(newText);
	}

	/**
	 * Returns the text entered in the "namefield" component.
	 *
	 * @return The text entered in the "namefield" component.
	 */
	public String getName() {
	    // Returns the current text entered in the "namefield" component.
	    return namefield.getText();
	}

	/**
	 * Returns the text entered in the "qtyfield" component.
	 *
	 * @return The text entered in the "qtyfield" component.
	 */
	public String getQuantity() {
	    // Returns the current text entered in the "qtyfield" component.
	    return qtyfield.getText();
	}

	/**
	 * Returns the text entered in the "pricefield" component.
	 *
	 * @return The text entered in the "pricefield" component.
	 */
	public String getPrice() {
	    // Returns the current text entered in the "pricefield" component.
	    return pricefield.getText();
	}

	/**
	 * Returns the text entered in the "calfield" component.
	 *
	 * @return The text entered in the "calfield" component.
	 */
	public String getCalories() {
	    // Returns the current text entered in the "calfield" component.
	    return calfield.getText();
	}

	/**
	 * Returns the current number (CurNum).
	 *
	 * @return The current number (CurNum).
	 */
	public int getCurrentNumber() {
	    // Returns the current value of CurNum.
	    return CurNum;
	}

	/**
	 * Returns the customize state.
	 *
	 * @return The customize state.
	 */
	public boolean getCustomize() {
	    // Returns the current value of the customize state.
	    return customize;
	}

	/**
	 * Sets the customize state to the given newCustomize value.
	 *
	 * @param newCustomize The new customize state to set.
	 */
	public void setCustomize(boolean newCustomize) {
	    // Sets the customize state to the provided newCustomize value.
	    customize = newCustomize;
	}

	/**
	 * Increments the current number (CurNum) by one.
	 */
	public void incrementCur() {
	    // Increments the value of CurNum by one.
	    CurNum++;
	}

	/**
	 * Resets the current number (CurNum) to zero.
	 */
	public void resetCur() {
	    // Resets the value of CurNum to zero.
	    CurNum = 0;
	}

	/**
	 * Adds an ActionListener to the "btnAdd" button.
	 *
	 * @param listener The ActionListener to be added to the "btnAdd" button.
	 */
	public void addItem(ActionListener listener) {
	    // Adds the provided ActionListener to the "btnAdd" button.
	    btnAdd.addActionListener(listener);
	}

	/**
	 * Returns the text of the "btnAdd" button.
	 *
	 * @return The text of the "btnAdd" button.
	 */
	public String getbtnAddText() {
	    // Returns the current text of the "btnAdd" button.
	    return btnAdd.getText();
	}

	/**
	 * Adds an ActionListener to the "b5" button.
	 *
	 * @param listener The ActionListener to be added to the "b5" button.
	 */
	public void add5(ActionListener listener) {
	    // Adds the provided ActionListener to the "b5" button.
	    b5.addActionListener(listener);
	}

	/**
	 * Adds an ActionListener to the "b4" button.
	 *
	 * @param listener The ActionListener to be added to the "b4" button.
	 */
	public void add10(ActionListener listener) {
	    // Adds the provided ActionListener to the "b4" button.
	    b4.addActionListener(listener);
	}

	/**
	 * Adds an ActionListener to the "b3" button.
	 *
	 * @param listener The ActionListener to be added to the "b3" button.
	 */
	public void add20(ActionListener listener) {
	    // Adds the provided ActionListener to the "b3" button.
	    b3.addActionListener(listener);
	}

	/**
	 * Adds an ActionListener to the "b2" button.
	 *
	 * @param listener The ActionListener to be added to the "b2" button.
	 */
	public void add50(ActionListener listener) {
	    // Adds the provided ActionListener to the "b2" button.
	    b2.addActionListener(listener);
	}

	/**
	 * Adds an ActionListener to the "b1" button.
	 *
	 * @param listener The ActionListener to be added to the "b1" button.
	 */
	public void add100(ActionListener listener) {
	    // Adds the provided ActionListener to the "b1" button.
	    b1.addActionListener(listener);
	}

	/**
	 * Adds an ActionListener to the "btnNewButton_1_1_2_1" button.
	 *
	 * @param listener The ActionListener to be added to the "btnNewButton_1_1_2_1" button.
	 */
	public void returner(ActionListener listener) {
	    // Adds the provided ActionListener to the "btnNewButton_1_1_2_1" button.
	    btnNewButton_1_1_2_1.addActionListener(listener);
	}
        
	/**
	 * Adjusts the view to show the components for adding items.
	 */
    public void addItemsView() {
	    JButton[] buttons = { b1, b2, b3, b4, b5};
	    for (int i = 0; i < 5; i++) {
	        buttons[i].setVisible(false);
	    }
	    Receipt.setVisible(false);
	    Change.setVisible(false);
		name.setText("Item Name");
		namefield.setBounds(13, 349, 161, 19);
		name.setVisible(true);
		namefield.setVisible(true);
		cal.setVisible(true);
		calfield.setVisible(true);
		qty.setBounds(184, 335, 50, 13);
		qty.setVisible(true);
		qtyfield.setBounds(184, 349, 50, 19);
		qtyfield.setVisible(true);
		price.setBounds(240, 335, 46, 13);
		price.setText("Price");
		price.setVisible(true);
		pricefield.setBounds(240, 349, 46, 19);
		pricefield.setVisible(true);
		btnAdd.setText("Add Item");
		btnAdd.setBounds(245, 379, 101, 18);
		btnAdd.setVisible(true);
    }
    
    /**
     * Adjusts the view to show the components for restocking items.
     */
    public void restockView() {
		Receipt.setVisible(false);
	    JButton[] buttons = { b1, b2, b3, b4, b5};
	    for (int i = 0; i < 5; i++) {
	        buttons[i].setVisible(false);
	    }			 
	    Change.setVisible(false);
		name.setText("Item Code");
		namefield.setBounds(68, 349, 50, 19);
		name.setVisible(true);
		namefield.setVisible(true);
		cal.setVisible(false);
		calfield.setVisible(false);
		qty.setVisible(false);
		qtyfield.setVisible(false);
		price.setVisible(false);
		pricefield.setVisible(false);
		btnAdd.setText("Restock");
		btnAdd.setBounds(130, 349, 70, 18);
		btnAdd.setVisible(true);
    }
    
    /**
     * Adjusts the view to show the components for changing prices.
     */
    public void changePriceView() {
    	JButton[] buttons = { b1, b2, b3, b4, b5};
	    for (int i = 0; i < 5; i++) {
	        buttons[i].setVisible(false);
	    }
	    Receipt.setVisible(false);
	    Change.setVisible(false);
		name.setText("Item Code");
		namefield.setBounds(68, 349, 50, 19);
		name.setVisible(true);
		namefield.setVisible(true);
		cal.setVisible(false);
		calfield.setVisible(false);
		qty.setVisible(false);
		qtyfield.setVisible(false);
		price.setText("New Price");
		price.setBounds(130, 335, 70, 13);
		price.setVisible(true);
		pricefield.setBounds(130, 349, 70, 19);
		pricefield.setVisible(true);
		btnAdd.setText("Change");
		btnAdd.setBounds(210, 349, 70, 18);
		btnAdd.setVisible(true);
    }
    
    /**
     * Adjusts the view to show the components for replenishing denominations.
     */
    public void replenishView() {
		Change.setBounds(10, 311, 100, 125);
	    JButton[] buttons = { b1, b2, b3, b4, b5};
	    for (int i = 0; i < 5; i++) {
	        buttons[i].setVisible(true);
	    }
	    Receipt.setVisible(false);
	    Change.setVisible(true);
		name.setVisible(false);
		namefield.setVisible(false);
		cal.setVisible(false);
		calfield.setVisible(false);
		qty.setVisible(false);
		qtyfield.setVisible(false);
		price.setVisible(false);
		pricefield.setVisible(false);
		btnAdd.setVisible(false);
    }
    
    /**
     * Adjusts the view to show the components for showing the receipt.
     */
    public void receiptView() {
    	Receipt.setVisible(true);
        JButton[] buttons = { b1, b2, b3, b4, b5 };
        for (int i = 0; i < 5; i++) {
            buttons[i].setVisible(false);
        }
        name.setVisible(false);
        namefield.setVisible(false);
        cal.setVisible(false);
        calfield.setVisible(false);
        qty.setVisible(false);
        qtyfield.setVisible(false);
        price.setVisible(false);
        pricefield.setVisible(false);
        btnAdd.setVisible(false);
        Change.setVisible(false);
    }
    
    /**
     * Button to add item.
     */
    public void addItems(ActionListener listener) {
    	btnNewButton_1_2.addActionListener(listener);
    }
    
    /**
     * Button to restock.
     */
    public void restock(ActionListener listener) {
    	btnNewButton_1.addActionListener(listener);
    }
    
    /**
     * Button to change price of an item.
     */
    public void changePrice(ActionListener listener) {
    	btnNewButton_1_1_1.addActionListener(listener);
    }
    
    /**
     * Button to replenish denominations
     */
    public void replenishChange(ActionListener listener) {
    	btnNewButton_1_1.addActionListener(listener);
    }
    
    /**
     * Button to show receipt.
     */
    public void receipt(ActionListener listener) {
    	btnNewButton_1_2_1_1.addActionListener(listener);
    }
    
    /**
     * Button to show next part.
     */
    public void customize(ActionListener listener) {
    	btnCustomize.addActionListener(listener);
    }
    
    /**
     * Updates the item display based on the selected machine type.
     * @param machineType The type of the vending machine ("Regular" or "Special").
     */
    public void itemAdder(String machineType) {
    		int index = 0;
    	    JLabel[] labels = { one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve };
    	    for (index = 0; index < 12; index++) {
    	        labels[index].setText("");
    	    }
    	    index = 0;
    	    if (machineType.equals("Regular") && Main.regularVendingMachine != null && !Main.regularVendingMachine.getItemSlots().isEmpty()) {
    	        for (Item item : Main.regularVendingMachine.getItemSlots()) {
    		            labels[index].setText("<html><center>" + item.getQuantity() + "x - " + item.getItemName() + " ₱" + item.getPrice() + "</center></html>");
    		            index++;
    		            if (index >= 12) {
    		                break;
    		            }	
    	        	
    	        }
    	    } else if (machineType.equals("Special") && Main.specialVendingMachine != null && Main.specialVendingMachine.getItemSellableSlots() != null && !customize) {
    	        for (Item item : Main.specialVendingMachine.getItemSellableSlots()) {
    		            labels[index].setText("<html><center>" + item.getQuantity() + "x - " + item.getItemName() + " ₱" + item.getPrice() + "</center></html>");
    		            index++;
    		            if (index >= 12) {
    		                break;
    		            }
    	        }
    	    } else if (machineType.equals("Special") && Main.specialVendingMachine != null && Main.specialVendingMachine.getItemCustomSlots() != null && customize) {
    	        ArrayList<String> partsList;
    	        if (CurNum == 0) {
    	            partsList = Main.specialVendingMachine.getFirstPart();
    	        } else if (CurNum == 1) {
    	            partsList = Main.specialVendingMachine.getSecondPart();
    	        } else if (CurNum == 2) {
    	            partsList = Main.specialVendingMachine.getThirdPart();
    	        } else if (CurNum == 3) {
    	            partsList = Main.specialVendingMachine.getFourthPart();
    	        } else { 	
    	            return;
    	        }
    	        ArrayList<String> itemsToRemove = new ArrayList<>();
    	        index = 0;
    	        for (String item : partsList) {
    	            Item itemCustom = Main.specialVendingMachine.getItemCustomByName(item);
    	            
    	            if (itemCustom != null) {
    	                labels[index].setText("<html><center>" + itemCustom.getQuantity() + "x - " + itemCustom.getItemName() + " ₱" + itemCustom.getPrice() + "</center></html>");
    	            } else {
    	                itemsToRemove.add(item);
    	            }
    	            index++;
    	            if (index >= 12) {
    	                break;
    	            }
    	        }
    	        if (itemsToRemove.size() != 0) {
    	        	partsList.removeAll(itemsToRemove);
    	    	    for (index = 0; index < 12; index++) {
    	    	        labels[index].setText("");
    	    	    }
    		        index = 0;
    		        for (String item : partsList) {
    		            Item itemCustom = Main.specialVendingMachine.getItemCustomByName(item);
    		            
    		            if (itemCustom != null) {
    		                labels[index].setText("<html><center>" + itemCustom.getQuantity() + "x - " + itemCustom.getItemName() + " ₱" + itemCustom.getPrice() + "</center></html>");
    		            } else {
    		                itemsToRemove.add(item);
    		            }
    		            index++;
    		            if (index >= 12) {
    		                break;
    		            }
    		        }
    	        } 
    	    }
        
    }
}
