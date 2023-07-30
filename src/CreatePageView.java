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

public class CreatePageView extends JFrame {

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
	private JButton create;
	private JButton add;
	private JButton reset;
	private JButton btnReturn;

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
		Main main = new Main();
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
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReturn.setFocusable(false);
		btnReturn.setBounds(301, 239, 125, 38);
		contentPane.add(btnReturn);
		
		contentPane.add(reset);
		
		p5 = new JButton("Create");
		p5.setFocusable(false);
		p5.setVisible(false);
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

	public void setCreateMachineBtnListener(ActionListener listener) {
		create.addActionListener(listener);
	}

	public void setAddItemsBtnListener(ActionListener listener) {
		add.addActionListener(listener);
	}

	public void setResetMachineBtnListener(ActionListener listener) {
		reset.addActionListener(listener);
	}

	public void setReturnBtnListener(ActionListener listener) {
		btnReturn.addActionListener(listener);
	}

	public void setCreateCustomMachineBtnListener(ActionListener listener) {
		p5.addActionListener(listener);
	}

	public String getPart1() {
		return p1.getText();
	}

	public String getPart2() {
		return p2.getText();
	}

	public String getPart3() {
		return p3.getText();
	}

	public String getPart4() {
		return p4.getText();
	}

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
		create.setVisible(false);
		add.setVisible(false);
		reset.setVisible(false);
	}
}
