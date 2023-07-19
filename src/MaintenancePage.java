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

public class MaintenancePage extends JFrame {

	private JPanel contentPane;
	private JPanel C1;
	private boolean modes = true;
	private static JLabel one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve;
	private static String machineType;
	private JTextField namefield;
	private JTextField qtyfield;
	private JTextField pricefield;
	private JTextField calfield;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MaintenancePage frame = new MaintenancePage("");
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
	public MaintenancePage(String machineType) {
		this.machineType = machineType;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 511);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		int number = 0;

		if (machineType.equals("Regular") && Main.regularVendingMachine != null) {
		    for (String key : Main.regularVendingMachine.getItem().getItemQuantity().keySet()) {
		        Main.regularVendingMachine.getItemNumbers().put(number, key);
		        number++;
		    }
		} else if (machineType.equals("Special") && Main.specialVendingMachine != null) {
		    for (String key : Main.specialVendingMachine.getItem().getItemQuantity().keySet()) {
		        Main.specialVendingMachine.getItemNumbers().put(number, key);
		        number++;
		    }
		}
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(255, 0, 0), 5, true));
		panel_2.setBounds(370, 10, 120, 446);
		contentPane.add(panel_2);
		
				
		JButton btnAdd = new JButton("Add Item");
		btnAdd.setVisible(false);
		btnAdd.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
			    int itemNumber = 0;
			    String nameText = namefield.getText();
			    if (!nameText.isEmpty()) {
			        if (nameText.equals("A1"))
			            itemNumber = 0;
			        else if (nameText.equals("A2"))
			            itemNumber = 1;
			        else if (nameText.equals("A3"))
			            itemNumber = 2;
			        else if (nameText.equals("B1"))
			            itemNumber = 3;
			        else if (nameText.equals("B2"))
			            itemNumber = 4;
			        else if (nameText.equals("B3"))
			            itemNumber = 5;
			        else if (nameText.equals("C1"))
			            itemNumber = 6;
			        else if (nameText.equals("C2"))
			            itemNumber = 7;
			        else if (nameText.equals("C3"))
			            itemNumber = 8;
			        else if (nameText.equals("D1"))
			            itemNumber = 9;
			        else if (nameText.equals("D2"))
			            itemNumber = 10;
			        else if (nameText.equals("D3"))
			            itemNumber = 11;
			    }
		        if (btnAdd.getText().equals("Add Item")) {
		            if (machineType.equals("Regular") && Main.regularVendingMachine != null) {
		                Main.regularVendingMachine.getItem().addItem(namefield.getText(), Integer.parseInt(qtyfield.getText()), Double.parseDouble(pricefield.getText()), Integer.parseInt(calfield.getText()));
		            } else if (machineType.equals("Special") && Main.specialVendingMachine != null) {
		                Main.specialVendingMachine.getItem().addItem(namefield.getText(), Integer.parseInt(qtyfield.getText()), Double.parseDouble(pricefield.getText()), Integer.parseInt(calfield.getText()));
		            }
		        } else if (btnAdd.getText().equals("Restock")) {
				    if (machineType.equals("Regular") && Main.regularVendingMachine != null && Main.regularVendingMachine.getItem() != null) {
				    	Main.regularVendingMachine.getItem().setItemQuantity(Main.regularVendingMachine.getItemNumbers().get(itemNumber),Main.regularVendingMachine.getItem().getItemQuantity().get(Main.regularVendingMachine.getItemNumbers().get(itemNumber)) + 1);
				    } else if (machineType.equals("Special") && Main.specialVendingMachine != null && Main.specialVendingMachine.getItem() != null) {
				    	Main.specialVendingMachine.getItem().setItemQuantity(Main.specialVendingMachine.getItemNumbers().get(itemNumber),Main.specialVendingMachine.getItem().getItemQuantity().get(Main.specialVendingMachine.getItemNumbers().get(itemNumber)) + 1);
				    }	
		        } else if (btnAdd.getText().equals("Change")){
		        	 if (machineType.equals("Regular") && Main.regularVendingMachine != null && Main.regularVendingMachine.getItem() != null) {
					    	Main.regularVendingMachine.getItem().setItemPrice(Main.regularVendingMachine.getItemNumbers().get(itemNumber),Double.parseDouble(pricefield.getText()));
					    } else if (machineType.equals("Special") && Main.specialVendingMachine != null && Main.specialVendingMachine.getItem() != null) {
					    	Main.specialVendingMachine.getItem().setItemPrice(Main.specialVendingMachine.getItemNumbers().get(itemNumber),Double.parseDouble(pricefield.getText()));
					    }	
		        }
		        itemAdder();
		    }
		});

	    
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAdd.setFocusable(false);
		btnAdd.setBounds(245, 379, 101, 18);
				
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		panel.setBounds(10, 10, 361, 446);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel Change = new JLabel("");
		Change.setHorizontalTextPosition(SwingConstants.LEADING);
		Change.setVerticalAlignment(SwingConstants.TOP);
		Change.setHorizontalAlignment(SwingConstants.CENTER);
		Change.setFont(new Font("Tahoma", Font.PLAIN, 10));
		Change.setBounds(10, 311, 100, 125);
		panel_2.add(Change);
		
		JButton b5 = new JButton("5");
		b5.setVisible(false);
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    if (machineType.equals("Regular") && Main.regularVendingMachine != null && Main.regularVendingMachine.getItem() != null) {
			    	Main.regularVendingMachine.getCashBox().replenishChange(5.0, 1);
			    } else if (machineType.equals("Special") && Main.specialVendingMachine != null && Main.specialVendingMachine.getItem() != null) {
			    	Main.specialVendingMachine.getCashBox().replenishChange(5.0, 1);
			    }	
			    if (machineType.equals("Regular") && Main.regularVendingMachine != null && Main.regularVendingMachine.getItem() != null) {
			    	StringBuilder allDenoms = new StringBuilder("<html>Change in Machine<br>");
			    	for (HashMap.Entry<Double, Integer> denom : Main.regularVendingMachine.getCashBox().getDenominations().entrySet()) {
			    	    double denomination = denom.getKey();
			    	    int quantity = denom.getValue();
			    	    allDenoms.append("₱").append(denomination).append(" - Quantity: ").append(quantity).append("<br>");
			    	}
			    	allDenoms.append("</html>");
			    	Change.setText(allDenoms.toString());
			    } else if (machineType.equals("Special") && Main.specialVendingMachine != null && Main.specialVendingMachine.getItem() != null) {
			        for (HashMap.Entry<Double, Integer> denom : Main.specialVendingMachine.getCashBox().getDenominations().entrySet()) {
				    	StringBuilder allDenoms = new StringBuilder("<html>Change in Machine<br>");
				    	for (HashMap.Entry<Double, Integer> denom1 : Main.specialVendingMachine.getCashBox().getDenominations().entrySet()) {
				    	    double denomination = denom1.getKey();
				    	    int quantity = denom1.getValue();
				    	    allDenoms.append("₱").append(denomination).append(" - Quantity: ").append(quantity).append("<br>");
				    	}
				    	allDenoms.append("</html>");
				    	Change.setText(allDenoms.toString());
			        }
			    }	
			}
		});
		b5.setBounds(170, 372, 85, 21);
		panel.add(b5);
		
		JButton b4 = new JButton("10");
		b4.setVisible(false);
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    if (machineType.equals("Regular") && Main.regularVendingMachine != null && Main.regularVendingMachine.getItem() != null) {
			    	Main.regularVendingMachine.getCashBox().replenishChange(10.0, 1);
			    } else if (machineType.equals("Special") && Main.specialVendingMachine != null && Main.specialVendingMachine.getItem() != null) {
			    	Main.specialVendingMachine.getCashBox().replenishChange(10.0, 1);
			    }			
			    if (machineType.equals("Regular") && Main.regularVendingMachine != null && Main.regularVendingMachine.getItem() != null) {
			    	StringBuilder allDenoms = new StringBuilder("<html>Change in Machine<br>");
			    	for (HashMap.Entry<Double, Integer> denom : Main.regularVendingMachine.getCashBox().getDenominations().entrySet()) {
			    	    double denomination = denom.getKey();
			    	    int quantity = denom.getValue();
			    	    allDenoms.append("₱").append(denomination).append(" - Quantity: ").append(quantity).append("<br>");
			    	}
			    	allDenoms.append("</html>");
			    	Change.setText(allDenoms.toString());
			    } else if (machineType.equals("Special") && Main.specialVendingMachine != null && Main.specialVendingMachine.getItem() != null) {
			        for (HashMap.Entry<Double, Integer> denom : Main.specialVendingMachine.getCashBox().getDenominations().entrySet()) {
				    	StringBuilder allDenoms = new StringBuilder("<html>Change in Machine<br>");
				    	for (HashMap.Entry<Double, Integer> denom1 : Main.specialVendingMachine.getCashBox().getDenominations().entrySet()) {
				    	    double denomination = denom1.getKey();
				    	    int quantity = denom1.getValue();
				    	    allDenoms.append("₱").append(denomination).append(" - Quantity: ").append(quantity).append("<br>");
				    	}
				    	allDenoms.append("</html>");
				    	Change.setText(allDenoms.toString());
			        }
			    }	
			}
		});
		b4.setBounds(78, 372, 85, 21);
		panel.add(b4);
		
		JButton b3 = new JButton("20");
		b3.setVisible(false);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    if (machineType.equals("Regular") && Main.regularVendingMachine != null && Main.regularVendingMachine.getItem() != null) {
			    	Main.regularVendingMachine.getCashBox().replenishChange(20.0, 1);
			    } else if (machineType.equals("Special") && Main.specialVendingMachine != null && Main.specialVendingMachine.getItem() != null) {
			    	Main.specialVendingMachine.getCashBox().replenishChange(20.0, 1);
			    }			
			    if (machineType.equals("Regular") && Main.regularVendingMachine != null && Main.regularVendingMachine.getItem() != null) {
			    	StringBuilder allDenoms = new StringBuilder("<html>Change in Machine<br>");
			    	for (HashMap.Entry<Double, Integer> denom : Main.regularVendingMachine.getCashBox().getDenominations().entrySet()) {
			    	    double denomination = denom.getKey();
			    	    int quantity = denom.getValue();
			    	    allDenoms.append("₱").append(denomination).append(" - Quantity: ").append(quantity).append("<br>");
			    	}
			    	allDenoms.append("</html>");
			    	Change.setText(allDenoms.toString());
			    } else if (machineType.equals("Special") && Main.specialVendingMachine != null && Main.specialVendingMachine.getItem() != null) {
			        for (HashMap.Entry<Double, Integer> denom : Main.specialVendingMachine.getCashBox().getDenominations().entrySet()) {
				    	StringBuilder allDenoms = new StringBuilder("<html>Change in Machine<br>");
				    	for (HashMap.Entry<Double, Integer> denom1 : Main.specialVendingMachine.getCashBox().getDenominations().entrySet()) {
				    	    double denomination = denom1.getKey();
				    	    int quantity = denom1.getValue();
				    	    allDenoms.append("₱").append(denomination).append(" - Quantity: ").append(quantity).append("<br>");
				    	}
				    	allDenoms.append("</html>");
				    	Change.setText(allDenoms.toString());
			        }
			    }	
			}
		});
		b3.setBounds(224, 335, 85, 21);
		panel.add(b3);
		
		JButton b2 = new JButton("50");
		b2.setVisible(false);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    if (machineType.equals("Regular") && Main.regularVendingMachine != null && Main.regularVendingMachine.getItem() != null) {
			    	Main.regularVendingMachine.getCashBox().replenishChange(50.0, 1);
			    } else if (machineType.equals("Special") && Main.specialVendingMachine != null && Main.specialVendingMachine.getItem() != null) {
			    	Main.specialVendingMachine.getCashBox().replenishChange(50.0, 1);
			    }		
			    if (machineType.equals("Regular") && Main.regularVendingMachine != null && Main.regularVendingMachine.getItem() != null) {
			    	StringBuilder allDenoms = new StringBuilder("<html>Change in Machine<br>");
			    	for (HashMap.Entry<Double, Integer> denom : Main.regularVendingMachine.getCashBox().getDenominations().entrySet()) {
			    	    double denomination = denom.getKey();
			    	    int quantity = denom.getValue();
			    	    allDenoms.append("₱").append(denomination).append(" - Quantity: ").append(quantity).append("<br>");
			    	}
			    	allDenoms.append("</html>");
			    	Change.setText(allDenoms.toString());
			    } else if (machineType.equals("Special") && Main.specialVendingMachine != null && Main.specialVendingMachine.getItem() != null) {
			        for (HashMap.Entry<Double, Integer> denom : Main.specialVendingMachine.getCashBox().getDenominations().entrySet()) {
				    	StringBuilder allDenoms = new StringBuilder("<html>Change in Machine<br>");
				    	for (HashMap.Entry<Double, Integer> denom1 : Main.specialVendingMachine.getCashBox().getDenominations().entrySet()) {
				    	    double denomination = denom1.getKey();
				    	    int quantity = denom1.getValue();
				    	    allDenoms.append("₱").append(denomination).append(" - Quantity: ").append(quantity).append("<br>");
				    	}
				    	allDenoms.append("</html>");
				    	Change.setText(allDenoms.toString());
			        }
			    }	
			}
		});
		b2.setBounds(129, 335, 85, 21);
		panel.add(b2);
		
		JButton b1 = new JButton("100");
		b1.setVisible(false);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    if (machineType.equals("Regular") && Main.regularVendingMachine != null && Main.regularVendingMachine.getItem() != null) {
			    	Main.regularVendingMachine.getCashBox().replenishChange(100.0, 1);
			    } else if (machineType.equals("Special") && Main.specialVendingMachine != null && Main.specialVendingMachine.getItem() != null) {
			    	Main.specialVendingMachine.getCashBox().replenishChange(100.0, 1);
			    }			
			    if (machineType.equals("Regular") && Main.regularVendingMachine != null && Main.regularVendingMachine.getItem() != null) {
			    	StringBuilder allDenoms = new StringBuilder("<html>Change in Machine<br>");
			    	for (HashMap.Entry<Double, Integer> denom : Main.regularVendingMachine.getCashBox().getDenominations().entrySet()) {
			    	    double denomination = denom.getKey();
			    	    int quantity = denom.getValue();
			    	    allDenoms.append("₱").append(denomination).append(" - Quantity: ").append(quantity).append("<br>");
			    	}
			    	allDenoms.append("</html>");
			    	Change.setText(allDenoms.toString());
			    } else if (machineType.equals("Special") && Main.specialVendingMachine != null && Main.specialVendingMachine.getItem() != null) {
			        for (HashMap.Entry<Double, Integer> denom : Main.specialVendingMachine.getCashBox().getDenominations().entrySet()) {
				    	StringBuilder allDenoms = new StringBuilder("<html>Change in Machine<br>");
				    	for (HashMap.Entry<Double, Integer> denom1 : Main.specialVendingMachine.getCashBox().getDenominations().entrySet()) {
				    	    double denomination = denom1.getKey();
				    	    int quantity = denom1.getValue();
				    	    allDenoms.append("₱").append(denomination).append(" - Quantity: ").append(quantity).append("<br>");
				    	}
				    	allDenoms.append("</html>");
				    	Change.setText(allDenoms.toString());
			        }
			    }	
			}
		});
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
		
		JLabel Finish = new JLabel("");
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
		
		itemAdder();
		
		JButton btnNewButton_1_1_2_1 = new JButton("Return");
		btnNewButton_1_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CreatePage open = new CreatePage("Regular");
				open.setVisible(true);
			}
		});
		btnNewButton_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1_1_2_1.setFocusable(false);
		btnNewButton_1_1_2_1.setBounds(13, 403, 79, 19);
		panel.add(btnNewButton_1_1_2_1);
		
		namefield = new JTextField();
		namefield.setVisible(false);
		namefield.setColumns(10);
		namefield.setBounds(68, 349, 50, 19);
		panel.add(namefield);
		
		JLabel name = new JLabel("Item Name");
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
		
		JLabel qty = new JLabel("Quantity");
		qty.setVisible(false);
		qty.setHorizontalTextPosition(SwingConstants.CENTER);
		qty.setHorizontalAlignment(SwingConstants.CENTER);
		qty.setBounds(184, 335, 50, 13);
		panel.add(qty);
		
		JLabel price = new JLabel("Price");
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
		
		JLabel cal = new JLabel("Calories");
		cal.setVisible(false);
		cal.setHorizontalTextPosition(SwingConstants.CENTER);
		cal.setHorizontalAlignment(SwingConstants.CENTER);
		cal.setBounds(288, 335, 63, 13);
		panel.add(cal);
		
		JButton btnNewButton_1_2 = new JButton("Add items");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    JButton[] buttons = { b1, b2, b3, b4, b5};
			    for (int i = 0; i < 5; i++) {
			        buttons[i].setVisible(false);
			    }
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
		});
		
		JButton btnNewButton_1 = new JButton("Restock");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		
		JButton btnNewButton_1_1_1 = new JButton("<html><center>Change<br>Prices</center></html>");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int itemNumber;
			    JButton[] buttons = { b1, b2, b3, b4, b5};
			    for (int i = 0; i < 5; i++) {
			        buttons[i].setVisible(false);
			    }
			    if (namefield.getText() == "A1")
			    	itemNumber = 0;
			    if (namefield.getText() == "A2")
			    	itemNumber = 1;
			    if (namefield.getText() == "A3")
			    	itemNumber = 2;
			    if (namefield.getText() == "B1")
			    	itemNumber = 3;
			    if (namefield.getText() == "B2")
			    	itemNumber = 4;
			    if (namefield.getText() == "B3")
			    	itemNumber = 5;
			    if (namefield.getText() == "C1")
			    	itemNumber = 6;
			    if (namefield.getText() == "C2")
			    	itemNumber = 7;
			    if (namefield.getText() == "C3")
			    	itemNumber = 8;
			    if (namefield.getText() == "D1")
			    	itemNumber = 9;
			    if (namefield.getText() == "D2")
			    	itemNumber = 10;
			    if (namefield.getText() == "D3")
			    	itemNumber = 11;
			    
			    
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
		});
		
		JButton btnNewButton_1_1 = new JButton("Add Money");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    JButton[] buttons = { b1, b2, b3, b4, b5};
			    for (int i = 0; i < 5; i++) {
			        buttons[i].setVisible(true);
			    }
			    Change.setVisible(true);
			    if (machineType.equals("Regular") && Main.regularVendingMachine != null && Main.regularVendingMachine.getItem() != null) {
			    	StringBuilder allDenoms = new StringBuilder("<html>Change in Machine<br>");
			    	for (HashMap.Entry<Double, Integer> denom : Main.regularVendingMachine.getCashBox().getDenominations().entrySet()) {
			    	    double denomination = denom.getKey();
			    	    int quantity = denom.getValue();
			    	    allDenoms.append("₱").append(denomination).append(" - Quantity: ").append(quantity).append("<br>");
			    	}
			    	allDenoms.append("</html>");
			    	Change.setText(allDenoms.toString());
			    } else if (machineType.equals("Special") && Main.specialVendingMachine != null && Main.specialVendingMachine.getItem() != null) {
			        for (HashMap.Entry<Double, Integer> denom : Main.specialVendingMachine.getCashBox().getDenominations().entrySet()) {
				    	StringBuilder allDenoms = new StringBuilder("<html>Change in Machine<br>");
				    	for (HashMap.Entry<Double, Integer> denom1 : Main.specialVendingMachine.getCashBox().getDenominations().entrySet()) {
				    	    double denomination = denom1.getKey();
				    	    int quantity = denom1.getValue();
				    	    allDenoms.append("₱").append(denomination).append(" - Quantity: ").append(quantity).append("<br>");
				    	}
				    	allDenoms.append("</html>");
				    	Change.setText(allDenoms.toString());
			        }
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
			}
		});
		btnNewButton_1_1.setFocusable(false);
		btnNewButton_1_1.setBounds(10, 163, 100, 41);
		panel_2.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2_1_1 = new JButton("Receipt");
		btnNewButton_1_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Change.setVisible(true);
			    if (machineType.equals("Regular") && Main.regularVendingMachine != null && Main.regularVendingMachine.getItem() != null) {
			    	StringBuilder allDenoms = new StringBuilder("<html>Receipt in Machine<br>");
			    	for (HashMap.Entry<Double, Integer> denom : Main.regularVendingMachine.getCashBox().getDenominations().entrySet()) {
			    	    double denomination = denom.getKey();
			    	    int quantity = denom.getValue();
			    	    allDenoms.append("₱").append(denomination).append(" - Quantity: ").append(quantity).append("<br>");
			    	}
			    	allDenoms.append("</html>");
			    	Change.setText(allDenoms.toString());
			    } else if (machineType.equals("Special") && Main.specialVendingMachine != null && Main.specialVendingMachine.getItem() != null) {
			        for (HashMap.Entry<Double, Integer> denom : Main.specialVendingMachine.getCashBox().getDenominations().entrySet()) {
				    	StringBuilder allDenoms = new StringBuilder("<html>Change in Machine<br>");
				    	for (HashMap.Entry<Double, Integer> denom1 : Main.specialVendingMachine.getCashBox().getDenominations().entrySet()) {
				    	    double denomination = denom1.getKey();
				    	    int quantity = denom1.getValue();
				    	    allDenoms.append("₱").append(denomination).append(" - Quantity: ").append(quantity).append("<br>");
				    	}
				    	allDenoms.append("</html>");
				    	Change.setText(allDenoms.toString());
			        }
			    }
			}
		});
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
			
		calfield = new JTextField();
		calfield.setVisible(false);
		calfield.setColumns(10);
		calfield.setBounds(296, 349, 46, 19);
		panel.add(calfield);
		panel.add(btnAdd);
		this.setLocationRelativeTo(null);
	}
	
	private static void itemAdder() {
	    int index;
	    JLabel[] labels = { one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve };
	    for (index = 0; index < 12; index++) {
	        labels[index].setText("");
	    }

	    index = 0;
	    
	    if (machineType.equals("Regular") && Main.regularVendingMachine != null && Main.regularVendingMachine.getItem() != null) {
	        for (String itemName : Main.regularVendingMachine.getItem().getItemQuantity().keySet()) {
	        	labels[index].setText("<html><center>" + Main.regularVendingMachine.getItem().getItemQuantity().get(itemName)+ "x - " + itemName + " ₱" +  Main.regularVendingMachine.getItem().getItemPrice().get(itemName) + "</center></html>");
	        	
	            index++;
	            if (index >= 12) {
	                break;
	            }
	        }
	    } else if (machineType.equals("Special") && Main.specialVendingMachine != null && Main.specialVendingMachine.getItem() != null) {
	        for (String itemName : Main.specialVendingMachine.getItem().getItemQuantity().keySet()) {
	        	labels[index].setText("<html><center>" + Main.specialVendingMachine.getItem().getItemQuantity().get(itemName)+ "x - " + itemName + " ₱" +  Main.specialVendingMachine.getItem().getItemPrice().get(itemName) + "</center></html>");
	            index++;

	            if (index >= 12) {
	                break;
	            }
	        }
	    }
	}
}
