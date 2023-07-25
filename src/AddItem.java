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
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class AddItem extends JFrame {

	private JPanel contentPane;
	private JPanel C1;
	private boolean modes = true;
	private static JLabel one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve;
	private JTextField Name;
	private JTextField Qty;
	private JTextField Calories;
	private static String machineType;
	private static int CurNum = 0;
	private static boolean customize = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddItem frame = new AddItem("");
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
	public AddItem(String machineType) {
		this.machineType = machineType;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 397, 579);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		int number = 0;
		
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
		eleven.setBounds(0, 0, 106, 31);
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
		
		itemAdder();
		
		JButton btnNewButton_1_1_2_1 = new JButton("Return");
		btnNewButton_1_1_2_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        dispose();
		        CreatePage open;
		        if (machineType.equals("Regular"))
		            open = new CreatePage("Regular");
		        else if (machineType.equals("Special"))
		            open = new CreatePage("Special");	
		        else
		            open = new CreatePage(""); 
		        open.setVisible(true);
		    }
		});

		btnNewButton_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1_1_2_1.setFocusable(false);
		btnNewButton_1_1_2_1.setBounds(10, 420, 79, 19);
		panel.add(btnNewButton_1_1_2_1);
		JButton btnCustomize = new JButton("Customize");
		btnCustomize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (customize == true)
					CurNum++;
				if (btnCustomize.getText().equals("Customize")) {
				    btnCustomize.setText("Next");
				    customize = true;
				} 
				if (CurNum == 3)
					btnCustomize.setText("Return");
				    if (CurNum >= 0 && CurNum < Main.specialVendingMachine.getParts().size()) {
				        String set = Main.specialVendingMachine.getParts().get(CurNum);
				        Finish.setText("Part: " + set);  
				    } else if (CurNum == Main.specialVendingMachine.getParts().size()) {
				        CurNum = 0;
				        Finish.setText("");
				        btnCustomize.setText("Customize"); 
				        customize = false;
				    } 
				itemAdder();
				}});
		
		btnCustomize.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCustomize.setFocusable(false);
		btnCustomize.setBounds(234, 420, 117, 19);
		panel.add(btnCustomize);
		if (machineType.equals("Special"))
			btnCustomize.setVisible(true);
		else
			btnCustomize.setVisible(false);
		
		Name = new JTextField();
		Name.setBounds(26, 480, 160, 19);
		contentPane.add(Name);
		Name.setColumns(10);
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setHorizontalTextPosition(SwingConstants.CENTER);
		lblItemName.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemName.setBounds(26, 466, 160, 13);
		contentPane.add(lblItemName);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setHorizontalTextPosition(SwingConstants.CENTER);
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setBounds(196, 466, 50, 13);
		contentPane.add(lblQuantity);
		
		JTextField Price = new JTextField();
		Price.setColumns(10);
		Price.setBounds(252, 480, 46, 19);
		contentPane.add(Price);
		
		JButton btnAdd = new JButton("Add Item");
		btnAdd.setBounds(128, 504, 161, 28);
		contentPane.add(btnAdd);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.setFocusable(false);
	    btnAdd.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            if (machineType.equals("Regular") && Main.regularVendingMachine != null) {
	                Main.regularVendingMachine.addItem(Name.getText(), Integer.parseInt(Qty.getText()), Double.parseDouble(Price.getText()), Integer.parseInt(Calories.getText()));
	            } else if (machineType.equals("Special") && Main.specialVendingMachine != null && customize == false) {
	                Main.specialVendingMachine.addSellableItem(Name.getText(), Integer.parseInt(Qty.getText()), Double.parseDouble(Price.getText()), Integer.parseInt(Calories.getText()));
	            } else if (machineType.equals("Special") && Main.specialVendingMachine != null && customize == true) {
	            	if (CurNum == 0) {
	            		Main.specialVendingMachine.addFirstPart(Name.getText(), Integer.parseInt(Qty.getText()), Double.parseDouble(Price.getText()), Integer.parseInt(Calories.getText()));
	            	} else if (CurNum == 1) {
	            		Main.specialVendingMachine.addSecondPart(Name.getText(), Integer.parseInt(Qty.getText()), Double.parseDouble(Price.getText()), Integer.parseInt(Calories.getText()));
	            	} else if (CurNum == 2) {
	            		Main.specialVendingMachine.addThirdPart(Name.getText(), Integer.parseInt(Qty.getText()), Double.parseDouble(Price.getText()), Integer.parseInt(Calories.getText()));
	            	} else if (CurNum == 3) {
	            		Main.specialVendingMachine.addFourthPart(Name.getText(), Integer.parseInt(Qty.getText()), Double.parseDouble(Price.getText()), Integer.parseInt(Calories.getText()));
	            	}
	            }
	            itemAdder();
	        }
	    });
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setBounds(252, 466, 46, 13);
		contentPane.add(lblPrice);
		
		Qty = new JTextField();
		Qty.setColumns(10);
		Qty.setBounds(196, 480, 50, 19);
		contentPane.add(Qty);
		
		Calories = new JTextField();
		Calories.setColumns(10);
		Calories.setBounds(308, 480, 46, 19);
		contentPane.add(Calories);
		
		JLabel lblCalories = new JLabel("Calories");
		lblCalories.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCalories.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalories.setBounds(300, 466, 63, 13);
		contentPane.add(lblCalories);
		
		this.setLocationRelativeTo(null);
	}
	
	private static void itemAdder() {
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
	    } else if (machineType.equals("Special") && Main.specialVendingMachine != null && Main.specialVendingMachine.getItemSellable() != null && !customize) {
	        for (Item item : Main.specialVendingMachine.getItemSellable()) {
	            labels[index].setText("<html><center>" + item.getQuantity() + "x - " + item.getItemName() + " ₱" + item.getPrice() + "</center></html>");
	            index++;
	            if (index >= 12) {
	                break;
	            }
	        }
	    } else if (machineType.equals("Special") && Main.specialVendingMachine != null && Main.specialVendingMachine.getItemCustom() != null && customize) {
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

	        for (String item : partsList) {
	            labels[index].setText("<html><center>" + Main.specialVendingMachine.getItemCustomByName(item).getQuantity() + "x - " + Main.specialVendingMachine.getItemCustomByName(item).getItemName() + " ₱" + Main.specialVendingMachine.getItemCustomByName(item).getPrice() + "</center></html>");
	            index++;
	            if (index >= 12) {
	                break;
	            }
	        }
	    }
	}
}
