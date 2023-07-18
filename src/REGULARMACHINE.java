import java.awt.BorderLayout;
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
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class REGULARMACHINE extends JFrame {

	private JPanel contentPane;
	private JPanel C1;
	private JLabel code;
	private boolean modes = true;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					REGULARMACHINE frame = new REGULARMACHINE();
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
	public REGULARMACHINE() {
		Main main = new Main();
		JLabel Insert;

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
		
		JLabel Insert_1 = new JLabel("");
		final int[] currentIndex = {0};
		Insert_1.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        CollectChange.setText("+" + String.valueOf(CashBox.getDenominationsSpent().get(currentIndex[0])));
		        currentIndex[0]++;
		        int size = CashBox.getDenominationsSpent().size();
		        if (currentIndex[0] >= 0 && currentIndex[0] < size) {
		            Insert_1.setText(String.valueOf(CashBox.getDenominationsSpent().get(currentIndex[0])));
		        } else {
		            currentIndex[0] = -1; 
		            Insert_1.setText("");
		            CashBox.getDenominationsSpent().clear();
		            }

		        Timer timer = new Timer(2000, new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                CollectChange.setText("");
		            }
		        });
		        timer.setRepeats(false); 
		        timer.start();
		    }
		});

		Insert_1.setOpaque(true);
		Insert_1.setHorizontalAlignment(SwingConstants.CENTER);
		Insert_1.setForeground(Color.WHITE);
		Insert_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Insert_1.setBackground(Color.DARK_GRAY);
		Change.add(Insert_1);
		
		JButton btnNewButton = new JButton("A");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (code.getText().equals("") || code.getText().equals("") || code.getText().equals("")) 
					code.setText(code.getText() + "A");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(10, 44, 45, 35);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("1");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (code.getText().equals("A") || code.getText().equals("B") || code.getText().equals("C") || code.getText().equals("D")) 
					code.setText(code.getText() + "1");
			}
		});
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(65, 59, 45, 35);
		panel_2.add(btnNewButton_1);
		
		JButton btnB = new JButton("B");
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (code.getText().equals("") || code.getText().equals("") || code.getText().equals("")) 
					code.setText(code.getText() + "B");
			}
		});
		btnB.setFocusable(false);
		btnB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnB.setBounds(10, 85, 45, 35);
		panel_2.add(btnB);
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (code.getText().equals("") || code.getText().equals("") || code.getText().equals("")) 
					code.setText(code.getText() + "C");
			}
		});
		btnC.setFocusable(false);
		btnC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnC.setBounds(10, 126, 45, 35);
		panel_2.add(btnC);
		
		JButton btnNewButton_1_1 = new JButton("2");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (code.getText().equals("A") || code.getText().equals("B") || code.getText().equals("C") || code.getText().equals("D")) 
					code.setText(code.getText() + "2");
			}
		});
		btnNewButton_1_1.setFocusable(false);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1.setBounds(65, 104, 45, 35);
		panel_2.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("3");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (code.getText().equals("A") || code.getText().equals("B") || code.getText().equals("C") || code.getText().equals("D")) 
					code.setText(code.getText() + "3");
			}
		});
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
		
		JLabel priceCode = new JLabel("");
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
		int number = 0;
		 for (String key : Main.regularVendingMachine.getItem().getItemQuantity().keySet()) {
	            Main.regularVendingMachine.getItemNumbers().put(number, key);
	            number++;
	        }
	
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (code.getText().equals("A1")) {
					if (Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(0)) != null) 
						priceCode.setText(String.valueOf(Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(0))));
				} else if (code.getText().equals("A2")) {
					if (Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(1)) != null) 
					priceCode.setText(String.valueOf(Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(1))));
				} else if (code.getText().equals("A3")) {
					if (Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(2)) != null) 
					priceCode.setText(String.valueOf(Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(2))));
				} else if (code.getText().equals("B1")) {
					if (Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(3)) != null) 
					priceCode.setText(String.valueOf(Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(3))));
				} else if (code.getText().equals("B2")) {
					if (Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(4)) != null) 
					priceCode.setText(String.valueOf(Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(4))));
				} else if (code.getText().equals("B3")) {
					if (Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(5)) != null) 
					priceCode.setText(String.valueOf(Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(5))));
				} else if (code.getText().equals("C1")) {
					if (Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(6)) != null) 
					priceCode.setText(String.valueOf(Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(6))));
				} else if (code.getText().equals("C2")) {
					if (Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(7)) != null) 
					priceCode.setText(String.valueOf(Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(7))));
				} else if (code.getText().equals("C3")) {
					if (Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(8)) != null) 
					priceCode.setText(String.valueOf(Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(8))));
				} else if (code.getText().equals("D1")) {
					if (Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(9)) != null) 
					priceCode.setText(String.valueOf(Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(9))));
				} else if (code.getText().equals("D2")) {
					if (Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(10)) != null) 
					priceCode.setText(String.valueOf(Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(10))));
				} else if (code.getText().equals("D3")) {
					if (Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(11)) != null) 
					priceCode.setText(String.valueOf(Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(11))));
				}	
			}
		});
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEnter.setFocusable(false);
		btnEnter.setBounds(10, 212, 100, 28);
		panel_2.add(btnEnter);
		
		JLabel lblNewLabel = new JLabel("<html><center>Code Buttons</center></html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(0, 8, 120, 39);
		panel_2.add(lblNewLabel);
		
		JButton btnC_1 = new JButton("D");
		btnC_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (code.getText().equals("") || code.getText().equals("") || code.getText().equals("")) 
					code.setText(code.getText() + "D");
			}
		});
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
		
		JLabel Finish = new JLabel("");
		Finish.setHorizontalAlignment(SwingConstants.CENTER);
		Finish.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Finish.setBounds(13, 12, 326, 18);
		panel.add(Finish);
		
		JLabel Output = new JLabel("");
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
		
		JLabel one = new JLabel("New label");
		one.setHorizontalAlignment(SwingConstants.CENTER);
		one.setHorizontalTextPosition(SwingConstants.CENTER);
		one.setBounds(0, 10, 106, 13);
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
		
		JLabel two = new JLabel("New label");
		two.setHorizontalAlignment(SwingConstants.CENTER);
		two.setHorizontalTextPosition(SwingConstants.CENTER);
		two.setBounds(0, 10, 106, 13);
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
		
		JLabel three = new JLabel("New label");
		three.setHorizontalAlignment(SwingConstants.CENTER);
		three.setHorizontalTextPosition(SwingConstants.CENTER);
		three.setBounds(0, 10, 106, 13);
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
		
		JLabel four = new JLabel("New label");
		four.setHorizontalAlignment(SwingConstants.CENTER);
		four.setHorizontalTextPosition(SwingConstants.CENTER);
		four.setBounds(0, 10, 106, 13);
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
		
		JLabel five = new JLabel("New label");
		five.setHorizontalAlignment(SwingConstants.CENTER);
		five.setHorizontalTextPosition(SwingConstants.CENTER);
		five.setBounds(0, 10, 106, 13);
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
		
		JLabel six = new JLabel("New label");
		six.setHorizontalAlignment(SwingConstants.CENTER);
		six.setHorizontalTextPosition(SwingConstants.CENTER);
		six.setBounds(0, 10, 106, 13);
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
		
		JLabel seven = new JLabel("C1");
		seven.setHorizontalTextPosition(SwingConstants.CENTER);
		seven.setHorizontalAlignment(SwingConstants.CENTER);
		seven.setBounds(0, 10, 106, 13);
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
		
		JLabel ten = new JLabel("New label");
		ten.setHorizontalAlignment(SwingConstants.CENTER);
		ten.setHorizontalTextPosition(SwingConstants.CENTER);
		ten.setBounds(0, 10, 106, 13);
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
		
		JLabel eight = new JLabel("New label");
		eight.setHorizontalAlignment(SwingConstants.CENTER);
		eight.setHorizontalTextPosition(SwingConstants.CENTER);
		eight.setBounds(0, 10, 106, 13);
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
		
		JLabel nine = new JLabel("New label");
		nine.setHorizontalAlignment(SwingConstants.CENTER);
		nine.setHorizontalTextPosition(SwingConstants.CENTER);
		nine.setBounds(0, 10, 106, 13);
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
		
		JLabel eleven = new JLabel("New label");
		eleven.setHorizontalAlignment(SwingConstants.CENTER);
		eleven.setHorizontalTextPosition(SwingConstants.CENTER);
		eleven.setBounds(0, 10, 106, 13);
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
		
		JLabel twelve = new JLabel("asasa");
		twelve.setHorizontalTextPosition(SwingConstants.CENTER);
		twelve.setHorizontalAlignment(SwingConstants.CENTER);
		twelve.setBounds(0, 10, 106, 13);
		D3.add(twelve);
		int index;
		JLabel[] labels = { one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve };
		for (index = 0; index < 12; index++) {
			labels[index].setText("");
		}
		
		index = 0;
	    for (String itemName : main.regularVendingMachine.getItem().getItemQuantity().keySet()) {
	        labels[index].setText(itemName);
	        index++;
	    }
		
		Insert = new JLabel("");
		Insert.setOpaque(true);
		Insert.setHorizontalAlignment(SwingConstants.CENTER);
		Insert.setForeground(Color.WHITE);
		Insert.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Insert.setBackground(Color.DARK_GRAY);
		Insert.setBounds(184, 460, 70, 35);
		contentPane.add(Insert);
		
		
		JButton btnNewButton_1_1_2_1 = new JButton("Return");
		btnNewButton_1_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TestPage open = new TestPage("Regular");
				open.setVisible(true);
			}
		});
		btnNewButton_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1_1_2_1.setFocusable(false);
		btnNewButton_1_1_2_1.setBounds(10, 420, 79, 19);
		panel.add(btnNewButton_1_1_2_1);
		

		
		JButton btnNewButton_2 = new JButton("100");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (modes==true)
				Main.regularVendingMachine.getCashBox().addTotalAmount(100);
				else if (modes==false)
				Main.regularVendingMachine.getCashBox().deductTotalAmount(100);;
				Insert.setText(Integer.toString((int) Main.regularVendingMachine.getCashBox().getAmountPaid()));
			}
		});
		btnNewButton_2.setBounds(17, 500, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("50");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (modes==true)
				Main.regularVendingMachine.getCashBox().addTotalAmount(50);
				else if (modes==false)
				Main.regularVendingMachine.getCashBox().deductTotalAmount(50);;
				Insert.setText(Integer.toString((int) Main.regularVendingMachine.getCashBox().getAmountPaid()));
				
			}
		});
		btnNewButton_2_1.setBounds(114, 500, 85, 21);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("20");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (modes==true)
				Main.regularVendingMachine.getCashBox().addTotalAmount(20);
				else if (modes==false)
				Main.regularVendingMachine.getCashBox().deductTotalAmount(20);;
				Insert.setText(Integer.toString((int) Main.regularVendingMachine.getCashBox().getAmountPaid()));
			}
		});
		btnNewButton_2_2.setBounds(212, 500, 85, 21);
		contentPane.add(btnNewButton_2_2);
		
		JButton btnNewButton_2_3 = new JButton("10");	
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (modes==true)
				Main.regularVendingMachine.getCashBox().addTotalAmount(10);
				else if (modes==false)
				Main.regularVendingMachine.getCashBox().deductTotalAmount(10);;
				Insert.setText(Integer.toString((int) Main.regularVendingMachine.getCashBox().getAmountPaid()));
			}
		});
		btnNewButton_2_3.setBounds(307, 500, 85, 21);
		contentPane.add(btnNewButton_2_3);
		
		JButton btnNewButton_2_4 = new JButton("5");
		btnNewButton_2_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (modes == true)
				Main.regularVendingMachine.getCashBox().addTotalAmount(5);
				else if (modes == false)
				Main.regularVendingMachine.getCashBox().deductTotalAmount(5);;
				Insert.setText(Integer.toString((int) Main.regularVendingMachine.getCashBox().getAmountPaid()));
			}
		});
		btnNewButton_2_4.setBounds(402, 500, 85, 21);
		contentPane.add(btnNewButton_2_4);
		
		JLabel lblAmountInserted = new JLabel("Amount Inserted:");
		lblAmountInserted.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAmountInserted.setBounds(20, 470, 165, 18);
		contentPane.add(lblAmountInserted);
		
		JButton btnNewButton_3_1_1 = new JButton("Clear");
		btnNewButton_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.regularVendingMachine.getCashBox().resetAmountPaid();
				Insert.setText(Integer.toString((int) Main.regularVendingMachine.getCashBox().getAmountPaid()));
			}
		});
		btnNewButton_3_1_1.setFocusable(false);
		btnNewButton_3_1_1.setBounds(402, 474, 85, 21);
		contentPane.add(btnNewButton_3_1_1);
		
		JButton btnC_1_1 = new JButton("BUY");
		btnC_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (Double.parseDouble(Insert.getText()) < Double.parseDouble(priceCode.getText())) {
					Finish.setText("Insufficient Payment");
				}
				
				if (code.getText().equals("A1")) {
					if (Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(0)) != null) 
						if(Main.regularVendingMachine.cashbox.receivePayment(Main.regularVendingMachine.getItem(), Main.regularVendingMachine.getItemNumbers().get(0), Double.parseDouble(Insert.getText())) == true)
							Output.setText(Main.regularVendingMachine.getItemNumbers().get(0));
				} else if (code.getText().equals("A2")) {
					if (Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(1)) != null) 
						if(Main.regularVendingMachine.cashbox.receivePayment(Main.regularVendingMachine.getItem(), Main.regularVendingMachine.getItemNumbers().get(1), Double.parseDouble(Insert.getText())) == true)
							Output.setText(Main.regularVendingMachine.getItemNumbers().get(1));
				} else if (code.getText().equals("A3")) {
					if (Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(2)) != null) 
						if(Main.regularVendingMachine.cashbox.receivePayment(Main.regularVendingMachine.getItem(), Main.regularVendingMachine.getItemNumbers().get(2), Double.parseDouble(Insert.getText())) == true)
							Output.setText(Main.regularVendingMachine.getItemNumbers().get(2));
				} else if (code.getText().equals("B1")) {
					if (Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(3)) != null) 				
						if(Main.regularVendingMachine.cashbox.receivePayment(Main.regularVendingMachine.getItem(), Main.regularVendingMachine.getItemNumbers().get(3), Double.parseDouble(Insert.getText())) == true)
							Output.setText(Main.regularVendingMachine.getItemNumbers().get(3));
				} else if (code.getText().equals("B2")) {
					if (Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(4)) != null) 
						if(Main.regularVendingMachine.cashbox.receivePayment(Main.regularVendingMachine.getItem(), Main.regularVendingMachine.getItemNumbers().get(4), Double.parseDouble(Insert.getText())) == true)
							Output.setText(Main.regularVendingMachine.getItemNumbers().get(4));
				} else if (code.getText().equals("B3")) {
					if (Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(5)) != null) 
						if(Main.regularVendingMachine.cashbox.receivePayment(Main.regularVendingMachine.getItem(), Main.regularVendingMachine.getItemNumbers().get(5), Double.parseDouble(Insert.getText())) == true)
							Output.setText(Main.regularVendingMachine.getItemNumbers().get(5));
				} else if (code.getText().equals("C1")) {
					if (Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(6)) != null) 				
						if(Main.regularVendingMachine.cashbox.receivePayment(Main.regularVendingMachine.getItem(), Main.regularVendingMachine.getItemNumbers().get(6), Double.parseDouble(Insert.getText())) == true)
							Output.setText(Main.regularVendingMachine.getItemNumbers().get(6));
				} else if (code.getText().equals("C2")) {
					if (Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(7)) != null) 
						if(Main.regularVendingMachine.cashbox.receivePayment(Main.regularVendingMachine.getItem(), Main.regularVendingMachine.getItemNumbers().get(7), Double.parseDouble(Insert.getText())) == true)
							Output.setText(Main.regularVendingMachine.getItemNumbers().get(7));
				} else if (code.getText().equals("C3")) {
					if (Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(8)) != null) 			
						if(Main.regularVendingMachine.cashbox.receivePayment(Main.regularVendingMachine.getItem(), Main.regularVendingMachine.getItemNumbers().get(8), Double.parseDouble(Insert.getText())) == true)
							Output.setText(Main.regularVendingMachine.getItemNumbers().get(8));
				} else if (code.getText().equals("D1")) {
					if (Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(9)) != null) 
						if(Main.regularVendingMachine.cashbox.receivePayment(Main.regularVendingMachine.getItem(), Main.regularVendingMachine.getItemNumbers().get(9), Double.parseDouble(Insert.getText())) == true)
							Output.setText(Main.regularVendingMachine.getItemNumbers().get(9));
				} else if (code.getText().equals("D2")) {
					if (Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(10)) != null) 		
						if(Main.regularVendingMachine.cashbox.receivePayment(Main.regularVendingMachine.getItem(), Main.regularVendingMachine.getItemNumbers().get(10), Double.parseDouble(Insert.getText())) == true)
							Output.setText(Main.regularVendingMachine.getItemNumbers().get(10));
				} else if (code.getText().equals("D3")) {
					if (Main.regularVendingMachine.getItem().getItemPrice().get(Main.regularVendingMachine.getItemNumbers().get(11)) != null) 
						if(Main.regularVendingMachine.cashbox.receivePayment(Main.regularVendingMachine.getItem(), Main.regularVendingMachine.getItemNumbers().get(11), Double.parseDouble(Insert.getText())) == true)
							Output.setText(Main.regularVendingMachine.getItemNumbers().get(11));
				}	
				Main.regularVendingMachine.getCashBox();
				
				if (CashBox.getDenominationsSpent().size() > 0) {
				    Insert_1.setText(String.valueOf(CashBox.getDenominationsSpent().get(0)));
				} else {
					Finish.setText("Insufficient Change in Machine.");
				}
				if (Double.parseDouble(Insert.getText()) < Double.parseDouble(priceCode.getText())) {
				    Finish.setText("Insufficient Payment");

				    Timer timer = new Timer(2000, new ActionListener() {
				        public void actionPerformed(ActionEvent e) {
				            Finish.setText("");
				        }
				    });
				    timer.setRepeats(false);
				    timer.start();
				} else {
				    Insert.setText("");
				    Main.regularVendingMachine.getCashBox().resetAmountPaid();
				}
			}
		});
		btnC_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnC_1_1.setFocusable(false);
		btnC_1_1.setBounds(264, 460, 70, 35);
		contentPane.add(btnC_1_1);		
		
		JLabel Insert_2 = new JLabel("");
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
		
		this.setLocationRelativeTo(null);
	}
}
