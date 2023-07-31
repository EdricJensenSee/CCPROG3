import java.awt.BorderLayout;
import java.util.ArrayList;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class CustomizeItemView extends JFrame {
	private JPanel contentPane, Change, panel_3;
	private JPanel A1, A2, A3, B1, B2, B3, C1, C2, C3, D1, D2, D3;
	private JLabel code, firstPart, secondPart, thirdPart, fourthPart;
	private JLabel Insert_1, lblChange;
	private JLabel priceCode;
	private JLabel Output;
	private JLabel Insert_2;
	private JLabel Insert;
	private JLabel Finish;
	private JLabel one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve;
	private int curNum = 0;
	private int[] currentIndex = {0};
	private JButton a, b, c, d, sone, stwo, sthree, sfour, addRecipe, customize, btnEnter, btnNewButton_1_1_2_1, btnNewButton_3_1_1, btnNewButton_2_3, btnNewButton_2_4, btnNewButton_2_2, btnNewButton_2_1, btnNewButton_2, btnC_1_1;
	private ArrayList<String> recipe = new ArrayList<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	            	CustomizeItemView frame = new CustomizeItemView();
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
	public CustomizeItemView() {	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 507);
		
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
		
		Change = new JPanel();
		Change.setBounds(27, 401, 72, 35);
		Change.setForeground(Color.DARK_GRAY);
		Change.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		Change.setBackground(Color.DARK_GRAY);
		panel_2.add(Change);
		
		JLabel CollectChange = new JLabel("");
		CollectChange.setHorizontalAlignment(SwingConstants.CENTER);
		CollectChange.setBounds(340, 475, 49, 18);
		CollectChange.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		Output = new JLabel("");
		Output.setOpaque(true);
		Output.setHorizontalAlignment(SwingConstants.CENTER);
		Output.setForeground(Color.WHITE);
		Output.setFont(new Font("Tahoma", Font.PLAIN, 10));
		Output.setBackground(Color.DARK_GRAY);
		Output.setBounds(10, 8, 197, 53);
		Insert_2 = new JLabel("");
		Insert_2.setBounds(333, 21, 52, 21);
		Insert_1 = new JLabel("");

		Insert_1.setOpaque(true);
		Insert_1.setHorizontalAlignment(SwingConstants.CENTER);
		Insert_1.setForeground(Color.WHITE);
		Insert_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Insert_1.setBackground(Color.DARK_GRAY);
		Change.add(Insert_1);
		
		a = new JButton("A");
		a.setFocusable(false);
		a.setFont(new Font("Tahoma", Font.PLAIN, 15));
		a.setBounds(10, 44, 45, 35);
		panel_2.add(a);
		
		sone = new JButton("1");
		sone.setFocusable(false);
		sone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sone.setBounds(65, 44, 45, 35);
		panel_2.add(sone);
		
		b = new JButton("B");
		b.setFocusable(false);
		b.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b.setBounds(10, 85, 45, 35);
		panel_2.add(b);
		
		c = new JButton("C");
		c.setFocusable(false);
		c.setFont(new Font("Tahoma", Font.PLAIN, 15));
		c.setBounds(10, 126, 45, 35);
		panel_2.add(c);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.GRAY);
		panel_3.setBounds(11, 460, 476, 71);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setVisible(false);
		setBounds(100, 100, 510, 507);
		Insert = new JLabel("");
		Insert.setOpaque(true);
		Insert.setHorizontalAlignment(SwingConstants.CENTER);
		Insert.setForeground(Color.WHITE);
		Insert.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Insert.setBackground(Color.DARK_GRAY);
		Insert.setBounds(177, 5, 70, 35);
		stwo = new JButton("2");
		stwo.setFocusable(false);
		stwo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stwo.setBounds(65, 85, 45, 35);
		panel_2.add(stwo);
		
		sthree = new JButton("3");
		sthree.setFocusable(false);
		sthree.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sthree.setBounds(65, 126, 45, 35);
		panel_2.add(sthree);
		
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
		
		lblChange = new JLabel("Change");
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
		
		d = new JButton("D");
		d.setFont(new Font("Tahoma", Font.PLAIN, 15));
		d.setFocusable(false);
		d.setBounds(10, 168, 45, 35);
		panel_2.add(d);
		
		Finish = new JLabel("Choose " + Main.specialVendingMachine.getParts().get(0));
		Finish.setToolTipText("");
		Finish.setHorizontalAlignment(SwingConstants.CENTER);
		Finish.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Finish.setBounds(13, 12, 326, 31);
		sfour = new JButton("C");
		addRecipe = new JButton("Add Item");
		addRecipe.setBounds(10, 383, 103, 39);
		panel_2.add(addRecipe);
		

		addRecipe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		addRecipe.setFocusable(false);
		
		sfour.setFont(new Font("Tahoma", Font.ITALIC, 15));
		sfour.setFocusable(false);
		sfour.setBounds(65, 168, 45, 35);
		panel_2.add(sfour);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		panel.setBounds(10, 10, 361, 446);
		contentPane.add(panel);
		panel.setLayout(null);
		
		customize = new JButton("Buy Individual Products"); 
		customize.setVisible(true);
		customize.setFont(new Font("Tahoma", Font.PLAIN, 12));
		customize.setFocusable(false);
		customize.setBounds(189, 420, 162, 19);
		panel.add(customize);
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
		
		A1 = new JPanel();
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
		
		A2 = new JPanel();
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
		
		A3 = new JPanel();
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
		
		B1 = new JPanel();
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
		
		B2 = new JPanel();
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
		
		B3 = new JPanel();
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
		
		D1 = new JPanel();
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
		
		C2 = new JPanel();
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
		
		C3 = new JPanel();
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
		
		D2 = new JPanel();
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
		
		D3 = new JPanel();
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
		btnNewButton_1_1_2_1.setBounds(10, 420, 79, 19);
		panel.add(btnNewButton_1_1_2_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.DARK_GRAY);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(71, 339, 217, 71);
		panel.add(panel_1);
		panel_1.add(Output);
		
		firstPart = new JLabel("");
		firstPart.setHorizontalAlignment(SwingConstants.CENTER);
		firstPart.setFont(new Font("Tahoma", Font.PLAIN, 20));
		firstPart.setBounds(13, 40, 338, 32);
		panel.add(firstPart);
		
		secondPart = new JLabel("");
		secondPart.setHorizontalAlignment(SwingConstants.CENTER);
		secondPart.setFont(new Font("Tahoma", Font.PLAIN, 20));
		secondPart.setBounds(13, 112, 338, 32);
		panel.add(secondPart);
		
		thirdPart = new JLabel("");
		thirdPart.setHorizontalAlignment(SwingConstants.CENTER);
		thirdPart.setFont(new Font("Tahoma", Font.PLAIN, 20));
		thirdPart.setBounds(13, 183, 338, 32);
		panel.add(thirdPart);
		
		fourthPart = new JLabel("");
		fourthPart.setHorizontalAlignment(SwingConstants.CENTER);
		fourthPart.setFont(new Font("Tahoma", Font.PLAIN, 20));
		fourthPart.setBounds(13, 256, 338, 32);
		panel.add(fourthPart);
		
		panel_3.add(Insert_2);
		Insert_2.setOpaque(true);
		Insert_2.setHorizontalAlignment(SwingConstants.CENTER);
		Insert_2.setForeground(Color.WHITE);
		Insert_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Insert_2.setBackground(Color.DARK_GRAY);
		
		panel_3.add(Insert);
		
		btnNewButton_3_1_1 = new JButton("Clear");
		btnNewButton_3_1_1.setFocusable(false);
		btnNewButton_3_1_1.setBounds(395, 21, 85, 21);
		panel_3.add(btnNewButton_3_1_1);
		
		btnNewButton_2_4 = new JButton("5");
		btnNewButton_2_4.setBounds(395, 45, 85, 21);
		panel_3.add(btnNewButton_2_4);
		
		btnNewButton_2_3 = new JButton("10");
		btnNewButton_2_3.setBounds(300, 45, 85, 21);
		panel_3.add(btnNewButton_2_3);
		panel_3.add(CollectChange);
		btnNewButton_2_2 = new JButton("20");
		btnNewButton_2_2.setBounds(205, 45, 85, 21);
		panel_3.add(btnNewButton_2_2);
		
		btnNewButton_2_1 = new JButton("50");
		btnNewButton_2_1.setBounds(107, 45, 85, 21);
		panel_3.add(btnNewButton_2_1);
		
		btnNewButton_2 = new JButton("100");
		btnNewButton_2.setBounds(10, 45, 85, 21);
		panel_3.add(btnNewButton_2);
		
		JLabel lblAmountInserted = new JLabel("Amount Inserted:");
		lblAmountInserted.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAmountInserted.setBounds(13, 15, 165, 18);
		panel_3.add(lblAmountInserted);
		
		btnC_1_1 = new JButton("BUY");
		btnC_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnC_1_1.setFocusable(false);
		btnC_1_1.setBounds(257, 5, 70, 35);
		panel_3.add(btnC_1_1);
		
		JLabel lblWallet = new JLabel("Wallet");
		lblWallet.setHorizontalAlignment(SwingConstants.CENTER);
		lblWallet.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWallet.setBounds(336, 0, 49, 18);
		panel_3.add(lblWallet);
	
		itemAdder("Special");
		lblChange.setVisible(false);
		Change.setVisible(false);
		this.setLocationRelativeTo(null);
	}
	
	public void setFirstPart(String newText) {
		firstPart.setText(newText);
	}
	
	public void setSecondPart(String newText) {
		secondPart.setText(newText);
	}
	
	public void setThirdPart(String newText) {
		thirdPart.setText(newText);
	}
	
	public void setFourthPart(String newText) {
		fourthPart.setText(newText);
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
	
	public void setCollect(String newText) {
		Insert_2.setText(newText);
	}
	
	public void claimProduct(MouseListener listener) {
		Output.addMouseListener(listener);
	}
	
	public int getCurrentNumber() {
		return curNum;
	}
	
	public void addCurrentNumber() {
		curNum++;
	}
	
	public void setCurrentNumber(int newNum) {
		curNum = newNum;
	}
	
	public int[] getCurrentIndex() {
	    return currentIndex;
	}
	
    public void btnReturner(ActionListener listener) {
    	btnNewButton_1_1_2_1.addActionListener(listener);
    }
    
	public void changeCollect(MouseListener listener) {
		Insert_1.addMouseListener(listener);
	}
	
	public void A(ActionListener listener) {
		a.addActionListener(listener);
	}
	
	public void B(ActionListener listener) {
		b.addActionListener(listener);
	}
	
	public void C(ActionListener listener) {
		c.addActionListener(listener);
	}
	
	public void D(ActionListener listener) {
		d.addActionListener(listener);
	}
	
	public void number1(ActionListener listener) {
		sone.addActionListener(listener);
	}
	
	public void number2(ActionListener listener) {
		stwo.addActionListener(listener);
	}
	
	public void number3(ActionListener listener) {
		sthree.addActionListener(listener);
	}
	
	public void hidePanels() {
		A1.setVisible(false);
		A2.setVisible(false);
		A3.setVisible(false);
		B1.setVisible(false);
		B2.setVisible(false);
		B3.setVisible(false);
		C1.setVisible(false);
		C2.setVisible(false);
		C3.setVisible(false);
		D1.setVisible(false);
		D2.setVisible(false);
		D3.setVisible(false);	
		btnC_1_1.setEnabled(false);
	}

	public void addRecipe(ActionListener listener) {
		addRecipe.addActionListener(listener);
	}
	
	public ArrayList<String> getRecipe() {
		return recipe;
	}


	public void setRecipe(ArrayList<String> recipe) {
		this.recipe = recipe;
	}

	
	public void hideButtons() {
		btnEnter.setEnabled(false);
		a.setEnabled(false);
		b.setEnabled(false);
		c.setEnabled(false);
		d.setEnabled(false);
		sone.setEnabled(false);
		stwo.setEnabled(false);
		sthree.setEnabled(false);
		sfour.setEnabled(false);
        addRecipe.setVisible(false);
        lblChange.setVisible(true);
        Change.setVisible(true);
        panel_3.setVisible(true);
        setBounds(100, 100, 510, 568);
        setLocationRelativeTo(null);
	}
	
	public void indiv(ActionListener listener) {
		customize.addActionListener(listener);
	}

	public void btnEnter(ActionListener listener) {
		btnEnter.addActionListener(listener);
	} 
	
	public void clear(ActionListener listener) {
		btnNewButton_3_1_1.addActionListener(listener);
	}
	
	public void returner(ActionListener listener) {
		btnNewButton_1_1_2_1.addActionListener(listener);
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

	public void cancel(ActionListener listener) {
		sfour.addActionListener(listener);
	}
	
	public void printProcess(ActionListener listener) {
		btnC_1_1.addActionListener(listener);
	}
	
	public void itemAdder(String machineType) {
	    int index = 0;
	    JLabel[] labels = { one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve };
	    for (index = 0; index < 12; index++) {
	        labels[index].setText("");
	    }

	    index = 0;
	        ArrayList<String> partsList;
	        if (curNum == 0 && !Main.specialVendingMachine.getParts().isEmpty()) {
	            partsList = Main.specialVendingMachine.getFirstPart();
	        } else if (curNum == 1) {
	            partsList = Main.specialVendingMachine.getSecondPart();
	        } else if (curNum == 2) {
	            partsList = Main.specialVendingMachine.getThirdPart();
	        } else if (curNum == 3) {
	            partsList = Main.specialVendingMachine.getFourthPart();
	        } else {
	            return;
	        }

	        for (String item : partsList) {
	            labels[index].setText("<html><center>" + Main.specialVendingMachine.getItemCustomByName(item).getQuantity() + "x - " + Main.specialVendingMachine.getItemCustomByName(item).getItemName() + " ₱" + Main.specialVendingMachine.getItemCustomByName(item).getPrice() + "</center></html>");
	            index++;
	            if (index >= 12) {
	                break;
	            }
	        }
	    }
	
}