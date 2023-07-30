import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class VendingMachineView extends JFrame {

	private JPanel contentPane;
	private JPanel C1;
	private JLabel code;
	private static JLabel Insert_1;
	private JLabel priceCode;
	private JLabel Output;
	private static JLabel Insert_2;
	private JLabel Insert;
	private JLabel Finish;
	private JButton btnEnter, btnNewButton_3_1_1_1, btnC_1_1, btnNewButton_3_1_1, btnNewButton_2_4, btnNewButton_2_3, btnNewButton_2_2, btnNewButton_2_1, btnNewButton_2, customize, btnNewButton_1_1_2_1, btnNewButton, btnNewButton_1,btnB,btnC,btnNewButton_1_1,btnNewButton_1_1_1,btnC_1;
	private static JLabel one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve;
	private static String machineType;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	            	VendingMachineView frame = new VendingMachineView("");
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
	public VendingMachineView(String machineType) {
		this.machineType = machineType;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 568);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(255, 0, 0), 5, true));
		panel_2.setBounds(367, 10, 120, 446);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel Change = new JPanel();
		Change.setBounds(27, 401, 72, 35);
		Change.setForeground(Color.DARK_GRAY);
		Change.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		Change.setBackground(Color.DARK_GRAY);
		panel_2.add(Change);
		
		JLabel CollectChange = new JLabel("");
		CollectChange.setHorizontalAlignment(SwingConstants.CENTER);
		CollectChange.setBounds(340, 475, 49, 18);
		contentPane.add(CollectChange);
		CollectChange.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		Insert_1 = new JLabel("");	
		Insert_1.setOpaque(true);
		Insert_1.setHorizontalAlignment(SwingConstants.CENTER);
		Insert_1.setForeground(Color.WHITE);
		Insert_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Insert_1.setBackground(Color.DARK_GRAY);
		Change.add(Insert_1);
		
		btnNewButton = new JButton("A");
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(10, 44, 45, 35);
		panel_2.add(btnNewButton);
		
		btnNewButton_1 = new JButton("1");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(65, 59, 45, 35);
		panel_2.add(btnNewButton_1);
		
		btnB = new JButton("B");
		btnB.setFocusable(false);
		btnB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnB.setBounds(10, 85, 45, 35);
		panel_2.add(btnB);
		
		btnC = new JButton("C");
		btnC.setFocusable(false);
		btnC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnC.setBounds(10, 126, 45, 35);
		panel_2.add(btnC);
		
		btnNewButton_1_1 = new JButton("2");
		btnNewButton_1_1.setFocusable(false);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1.setBounds(65, 104, 45, 35);
		panel_2.add(btnNewButton_1_1);
		
		btnNewButton_1_1_1 = new JButton("3");
		btnNewButton_1_1_1.setFocusable(false);
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1_1.setBounds(65, 149, 45, 35);
		panel_2.add(btnNewButton_1_1_1);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCode.setBounds(38, 246, 72, 18);
		panel_2.add(lblCode);
		
		code = new JLabel("");
		code.setHorizontalAlignment(SwingConstants.CENTER);
		code.setFont(new Font("Tahoma", Font.PLAIN, 18));
		code.setOpaque(true);
		code.setForeground(Color.WHITE);
		code.setBackground(Color.DARK_GRAY);
		code.setBounds(27, 271, 70, 35);
		panel_2.add(code);
		
		priceCode = new JLabel("");
		priceCode.setOpaque(true);
		priceCode.setHorizontalAlignment(SwingConstants.CENTER);
		priceCode.setForeground(Color.WHITE);
		priceCode.setFont(new Font("Tahoma", Font.PLAIN, 18));
		priceCode.setBackground(Color.DARK_GRAY);
		priceCode.setBounds(27, 338, 70, 35);
		panel_2.add(priceCode);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrice.setBounds(38, 313, 72, 18);
		panel_2.add(lblPrice);
		
		JLabel lblChange = new JLabel("Change");
		lblChange.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChange.setBounds(30, 378, 72, 18);
		panel_2.add(lblChange);

	    btnEnter = new JButton("Enter");
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEnter.setFocusable(false);
		btnEnter.setBounds(10, 212, 100, 28);
		panel_2.add(btnEnter);
		
		JLabel lblNewLabel = new JLabel("<html><center>Code Buttons</center></html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(0, 8, 120, 39);
		panel_2.add(lblNewLabel);
		
		btnC_1 = new JButton("D");
		btnC_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnC_1.setFocusable(false);
		btnC_1.setBounds(10, 168, 45, 35);
		panel_2.add(btnC_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		panel.setBounds(10, 10, 361, 446);
		contentPane.add(panel);
		panel.setLayout(null);

		Finish = new JLabel("");
		Finish.setHorizontalAlignment(SwingConstants.CENTER);
		Finish.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Finish.setBounds(13, 12, 326, 18);
		panel.add(Finish);
		
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setForeground(Color.DARK_GRAY);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_1.setBounds(76, 346, 217, 71);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		Output = new JLabel("");
		Output.setBounds(10, 8, 197, 53);
		Output.setOpaque(true);
		Output.setHorizontalAlignment(SwingConstants.CENTER);
		Output.setForeground(Color.WHITE);
		Output.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Output.setBackground(Color.DARK_GRAY);
		panel_1.add(Output);
		
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
		three.setBounds(0, 0, 106, 33);
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
		six.setBounds(0, 0, 106, 33);
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
		eight.setBounds(0, 0, 106, 33);
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
		
		Insert = new JLabel("");
		Insert.setOpaque(true);
		Insert.setHorizontalAlignment(SwingConstants.CENTER);
		Insert.setForeground(Color.WHITE);
		Insert.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Insert.setBackground(Color.DARK_GRAY);
		Insert.setBounds(184, 460, 70, 35);
		contentPane.add(Insert);
		
		btnNewButton_1_1_2_1 = new JButton("Return");
		btnNewButton_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1_1_2_1.setFocusable(false);
		btnNewButton_1_1_2_1.setBounds(10, 420, 79, 19);
		panel.add(btnNewButton_1_1_2_1);
		
		customize = new JButton("Customize Cake"); 
		if (machineType.equals("Special"))
			customize.setVisible(true);
		else if (machineType.equals("Regular"))
			customize.setVisible(false);
		customize.setFont(new Font("Tahoma", Font.PLAIN, 12));
		customize.setFocusable(false);
		customize.setBounds(189, 420, 162, 19);
		panel.add(customize);
		
		btnNewButton_2 = new JButton("100");
		btnNewButton_2.setBounds(17, 500, 85, 21);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_2_1 = new JButton("50");
		btnNewButton_2_1.setBounds(114, 500, 85, 21);
		contentPane.add(btnNewButton_2_1);
		
		btnNewButton_2_2 = new JButton("20");
		btnNewButton_2_2.setBounds(212, 500, 85, 21);
		contentPane.add(btnNewButton_2_2);
		
		btnNewButton_2_3 = new JButton("10");	
		btnNewButton_2_3.setBounds(307, 500, 85, 21);
		contentPane.add(btnNewButton_2_3);
		
		btnNewButton_2_4 = new JButton("5");
		btnNewButton_2_4.setBounds(402, 500, 85, 21);
		contentPane.add(btnNewButton_2_4);
		JLabel lblAmountInserted = new JLabel("Amount Inserted:");
		lblAmountInserted.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAmountInserted.setBounds(20, 470, 165, 18);
		contentPane.add(lblAmountInserted);
		
		btnNewButton_3_1_1 = new JButton("Clear");
		btnNewButton_3_1_1.setFocusable(false);
		btnNewButton_3_1_1.setBounds(402, 476, 85, 21);
		contentPane.add(btnNewButton_3_1_1);
		
		btnC_1_1 = new JButton("BUY");
		
		btnC_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnC_1_1.setFocusable(false);
		btnC_1_1.setBounds(264, 460, 70, 35);
		contentPane.add(btnC_1_1);		
		
		Insert_2 = new JLabel("");
		Insert_2.setOpaque(true);
		Insert_2.setHorizontalAlignment(SwingConstants.CENTER);
		Insert_2.setForeground(Color.WHITE);
		Insert_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Insert_2.setBackground(Color.DARK_GRAY);
		Insert_2.setBounds(340, 474, 52, 21);
		contentPane.add(Insert_2);
		JLabel lblWallet = new JLabel("Wallet");
		lblWallet.setHorizontalAlignment(SwingConstants.CENTER);
		lblWallet.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWallet.setBounds(343, 455, 49, 18);
		contentPane.add(lblWallet);
		btnNewButton_3_1_1_1 = new JButton("Cancel");
		itemAdder();
		btnNewButton_3_1_1_1.setFocusable(false);
		btnNewButton_3_1_1_1.setBounds(402, 457, 85, 18);
		contentPane.add(btnNewButton_3_1_1_1);
		this.setLocationRelativeTo(null);
		setWallet("10");
	}
	
	public String getWallet() {
		return Insert_1.getText();
	}
	
	public void setWallet(String newText) {
		Insert_1.setText(newText);
	}
	public String getOutput() {
		return Output.getText();
	}
	
	public void setOutput(String newText) {
		Output.setText(newText);
	}
	public String getCode() {
		return String.valueOf(code.getText());
	}
	
	public void setCode(String newText) {
		code.setText(newText);
	}
	
	public String getPriceCode() {
		return priceCode.getText();
	}
	
	public void setPriceCode(String newText) {
		priceCode.setText(newText);
	}
	
	public String getInsert() {
		return Insert.getText();
	}
	
	public void setInsert(String newText) {
		Insert.setText(newText);
	}
	
	public String getFinish() {
		return Finish.getText();
	}
	
	public void setFinish(String newText) {
		Finish.setText(newText);
	}
	
	private static void changeCollect() {
		final int[] currentIndex = {0};
		Insert_1.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        int size = Main.specialVendingMachine.getCashBox().getDenominationsSpent().size();
		        if (currentIndex[0] == size) {
		            currentIndex[0] = -1;
		            Insert_1.setText("");
		            Main.specialVendingMachine.getCashBox().getDenominationsSpent().clear();
		        } else if (currentIndex[0] >= 0 && currentIndex[0] < size) {
		        	Insert_2.setText("+" + String.valueOf(Main.specialVendingMachine.getCashBox().getDenominationsSpent().get(currentIndex[0])));
		            currentIndex[0]++;
		            if (currentIndex[0] < size) {
		                Insert_1.setText(String.valueOf(Main.specialVendingMachine.getCashBox().getDenominationsSpent().get(currentIndex[0])));
		            }

		            Timer timer = new Timer(2000, new ActionListener() {
		                public void actionPerformed(ActionEvent e) {
		                    Insert_2.setText("");
		                }
		            });
		            timer.setRepeats(false);
		            timer.start();
		        }
		    }
		});
	}
	
	public void A(ActionListener listener) {
		btnNewButton.addActionListener(listener);
	}
	
	public void B(ActionListener listener) {
		btnB.addActionListener(listener);
	}
	
	public void C(ActionListener listener) {
		btnC.addActionListener(listener);
	}
	
	public void D(ActionListener listener) {
		btnC_1.addActionListener(listener);
	}
	
	public void number1(ActionListener listener) {
		btnNewButton_1.addActionListener(listener);
	}
	
	public void number2(ActionListener listener) {
		btnNewButton_1_1.addActionListener(listener);
	}
	
	public void number3(ActionListener listener) {
		btnNewButton_1_1_1.addActionListener(listener);
	}
	
	public void cancel(ActionListener listener) {
		btnNewButton_3_1_1_1.addActionListener(listener);
	}
	
	public void add100(ActionListener listener) {
		btnNewButton_2.addActionListener(listener);
	}
	
	public void add50(ActionListener listener) {
		btnNewButton_2_1.addActionListener(listener);
	}
	
	public void add20(ActionListener listener) {
		btnNewButton_2_2.addActionListener(listener);
	}
	
	public void add10(ActionListener listener) {
		btnNewButton_2_3.addActionListener(listener);
	}
	
	public void add5(ActionListener listener) {
		btnNewButton_2_4.addActionListener(listener);
	}

	public void clear(ActionListener listener) {
		btnNewButton_3_1_1.addActionListener(listener);
	}
	
	public void enterItem(ActionListener listener) {
		btnEnter.addActionListener(listener);
	}
	
	public void buy(ActionListener listener) {
		btnC_1_1.addActionListener(listener);
	}

	public void claimProduct() {
		Output.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
                Finish.setText((Output.getText()).toUpperCase() + " CLAIMED!");
                Output.setText("");
                Timer timer = new Timer(2000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Finish.setText("");
                    }
                });
                timer.setRepeats(false);
                timer.start();
			}
		});
	}
	
    public void btnReturner(ActionListener listener) {
    	btnNewButton_1_1_2_1.addActionListener(listener);
    }
	public void customize() {
		customize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.specialVendingMachine.getCashBox().resetAmountPaid();

			}
		});
	}
	public void itemAdder() {
	    int index;
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
	    } else if (machineType.equals("Special") && Main.specialVendingMachine != null && Main.specialVendingMachine.getItemSellable() != null) {
	        for (Item item : Main.specialVendingMachine.getItemSellable()) {
	            labels[index].setText("<html><center>" + item.getQuantity() + "x - " + item.getItemName() + " ₱" + item.getPrice() + "</center></html>");
	            index++;
	            if (index >= 12) {
	                break;
	            }
	        }
	    }
	}
}
