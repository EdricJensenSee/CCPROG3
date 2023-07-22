import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class CreatePage extends JFrame {

	private JPanel contentPane;
	private JLabel Name;
	private JTextField p1;
	private JTextField p2;
	private JTextField p3;
	private JTextField p4;
	private JButton p5;
	private JLabel p21;
	private JLabel p22;
	private JLabel p23;
	private JLabel p24;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreatePage frame = new CreatePage("");
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
	public CreatePage(String machineType) {
		Main main = new Main();// Declare the variable outside the if-else blocks
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
		p4.setBounds(79, 194, 271, 25);
		contentPane.add(p4);
		
		p3 = new JTextField();
		p3.setVisible(false);
		p3.setToolTipText("Third Part");
		p3.setColumns(10);
		p3.setBounds(79, 157, 271, 25);
		contentPane.add(p3);
		
		p2 = new JTextField();
		p2.setVisible(false);
		p2.setColumns(10);
		p2.setBounds(79, 122, 271, 25);
		contentPane.add(p2);
		
		p1 = new JTextField();
		p1.setVisible(false);
		p1.setToolTipText("First Part");
		p1.setColumns(10);
		p1.setBounds(79, 87, 271, 25);
		contentPane.add(p1);
		
		Name = new JLabel("Create a " + machineType + " Vending Machine");
		Name.setHorizontalAlignment(SwingConstants.CENTER);
		Name.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Name.setBounds(10, 10, 416, 90);
		contentPane.add(Name);
		JButton add = new JButton("Add Items to Machine");
		add.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (machineType != null) {
		            if ((machineType.equals("Regular") && Main.regularVendingMachine != null) || (machineType.equals("Special") && Main.specialVendingMachine != null)) {
		                dispose();
		                AddItem open = new AddItem(machineType);
		                open.setVisible(true);
		            } else {
		                JOptionPane.showMessageDialog(null, machineType + " Vending Machine Has Not Been Created", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Machine Has Not Been Created", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});

		add.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add.setFocusable(false);
		add.setBounds(79, 135, 271, 38);
		JButton reset = new JButton("Reset Machine");
		reset.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if ((machineType.equals("Regular") && Main.regularVendingMachine != null) || (machineType.equals("Special") && Main.specialVendingMachine != null)) {
		            if (machineType.equals("Regular")) {
		                Main.regularVendingMachine = new RegularVendingMachine();
		            } else if (machineType.equals("Special")) {
		                Main.specialVendingMachine = new SpecialVendingMachine();
		            }
		            JOptionPane.showMessageDialog(null, machineType + " Vending Machine reset", "Reset Confirmation", JOptionPane.INFORMATION_MESSAGE);
		        } else {
		            JOptionPane.showMessageDialog(null, "Machine Has Not Been Created", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});

		reset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		reset.setFocusable(false);
		reset.setBounds(79, 183, 271, 38);
		JButton create = new JButton("Create Machine");
		create.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (machineType.equals("Regular")) {
		            Main.regularVendingMachine = new RegularVendingMachine();
		        } else if (machineType.equals("Special")) {
		        	Main.specialVendingMachine.getParts().clear();
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
		        	create.setVisible(false);
		        	add.setVisible(false);
		        	reset.setVisible(false);
		            Main.specialVendingMachine = new SpecialVendingMachine();
		        }

		        String message = machineType + "Vending machine created successfully!";
		        JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
		    }
		});
		
		create.setFont(new Font("Tahoma", Font.PLAIN, 20));
		create.setFocusable(false);
		create.setBounds(79, 87, 271, 38);
		contentPane.add(create);
		
		
		contentPane.add(add);
		
		JButton btnReturn = new JButton("RETURN");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CreateVendingMachine open = new CreateVendingMachine();
				open.setVisible(true);
			}
		});
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReturn.setFocusable(false);
		btnReturn.setBounds(301, 239, 125, 38);
		contentPane.add(btnReturn);
		
		contentPane.add(reset);
		
		p5 = new JButton("Create");
		p5.setFocusable(false);
		p5.setVisible(false);
		p5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    if (Main.specialVendingMachine.getParts().size() < 4) {
				Main.specialVendingMachine.getParts().add(p1.getText());
				Main.specialVendingMachine.getParts().add(p2.getText());
				Main.specialVendingMachine.getParts().add(p3.getText());
				Main.specialVendingMachine.getParts().add(p4.getText());
				System.out.print(Main.specialVendingMachine.getParts());
			    }
			}
		});
		p5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		p5.setBounds(150, 230, 141, 47);
		contentPane.add(p5);
		
		p21 = new JLabel("Part 1");
		p21.setVisible(false);
		p21.setBounds(24, 93, 45, 13);
		contentPane.add(p21);
		
		p22 = new JLabel("Part 2");
		p22.setVisible(false);
		p22.setBounds(24, 128, 45, 13);
		contentPane.add(p22);
		
		p23 = new JLabel("Part 3");
		p23.setVisible(false);
		p23.setBounds(24, 163, 45, 13);
		contentPane.add(p23);
		
		p24 = new JLabel("Part 4");
		p24.setVisible(false);
		p24.setBounds(24, 200, 45, 13);
		contentPane.add(p24);
		this.setLocationRelativeTo(null);
	}
}
