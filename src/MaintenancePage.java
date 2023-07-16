import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import java.awt.event.ActionEvent;

public class MaintenancePage extends JFrame {

	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 536);
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
		
		JButton btnNewButton = new JButton("Collect Money");
		btnNewButton.setBounds(10, 415, 100, 21);
		panel_2.add(btnNewButton);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setForeground(Color.DARK_GRAY);
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_1_1.setBackground(Color.DARK_GRAY);
		panel_1_1.setBounds(10, 319, 100, 93);
		panel_2.add(panel_1_1);
		
		JButton btnNewButton_1 = new JButton("Restock");
		btnNewButton_1.setBounds(10, 60, 100, 41);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Add Money");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setBounds(10, 111, 100, 41);
		panel_2.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Add items");
		btnNewButton_1_2.setBounds(10, 162, 100, 41);
		panel_2.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_2_1 = new JButton("Change Prices");
		btnNewButton_1_2_1.setBounds(10, 214, 100, 41);
		panel_2.add(btnNewButton_1_2_1);
		
		JButton btnNewButton_1_2_1_1 = new JButton("Receipt List");
		btnNewButton_1_2_1_1.setBounds(10, 268, 100, 41);
		panel_2.add(btnNewButton_1_2_1_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		panel.setBounds(10, 10, 361, 446);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setForeground(Color.DARK_GRAY);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_1.setBounds(76, 346, 217, 71);
		panel.add(panel_1);
		
		JPanel first = new JPanel();
		first.setBorder(null);
		first.setBounds(13, 40, 106, 71);
		panel.add(first);
		first.setLayout(null);
		
		JLabel firstItem = new JLabel("New label");
		firstItem.setBounds(25, 10, 57, 13);
		first.add(firstItem);
		
		JLabel lblNewLabel_7_1 = new JLabel("New label");
		lblNewLabel_7_1.setBounds(25, 33, 57, 13);
		first.add(lblNewLabel_7_1);
		
		JPanel second = new JPanel();
		second.setLayout(null);
		second.setBorder(null);
		second.setBounds(129, 40, 106, 71);
		panel.add(second);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(25, 10, 57, 13);
		second.add(lblNewLabel_1);
		
		JLabel lblNewLabel_7_2 = new JLabel("New label");
		lblNewLabel_7_2.setBounds(25, 33, 57, 13);
		second.add(lblNewLabel_7_2);
		
		JPanel third = new JPanel();
		third.setLayout(null);
		third.setBorder(null);
		third.setBounds(245, 40, 106, 71);
		panel.add(third);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(25, 10, 57, 13);
		third.add(lblNewLabel_2);
		
		JLabel lblNewLabel_7_3 = new JLabel("New label");
		lblNewLabel_7_3.setBounds(25, 33, 57, 13);
		third.add(lblNewLabel_7_3);
		
		JPanel first_1 = new JPanel();
		first_1.setLayout(null);
		first_1.setBorder(null);
		first_1.setBounds(13, 112, 106, 71);
		panel.add(first_1);
		
		JLabel firstItem_1 = new JLabel("New label");
		firstItem_1.setBounds(25, 10, 57, 13);
		first_1.add(firstItem_1);
		
		JLabel lblNewLabel_7_1_1 = new JLabel("New label");
		lblNewLabel_7_1_1.setBounds(25, 33, 57, 13);
		first_1.add(lblNewLabel_7_1_1);
		
		JPanel first_2 = new JPanel();
		first_2.setLayout(null);
		first_2.setBorder(null);
		first_2.setBounds(129, 112, 106, 71);
		panel.add(first_2);
		
		JLabel firstItem_2 = new JLabel("New label");
		firstItem_2.setBounds(25, 10, 57, 13);
		first_2.add(firstItem_2);
		
		JLabel lblNewLabel_7_1_2 = new JLabel("New label");
		lblNewLabel_7_1_2.setBounds(25, 33, 57, 13);
		first_2.add(lblNewLabel_7_1_2);
		
		JPanel first_3 = new JPanel();
		first_3.setLayout(null);
		first_3.setBorder(null);
		first_3.setBounds(245, 112, 106, 71);
		panel.add(first_3);
		
		JLabel firstItem_3 = new JLabel("New label");
		firstItem_3.setBounds(25, 10, 57, 13);
		first_3.add(firstItem_3);
		
		JLabel lblNewLabel_7_1_3 = new JLabel("New label");
		lblNewLabel_7_1_3.setBounds(25, 33, 57, 13);
		first_3.add(lblNewLabel_7_1_3);
		
		JPanel first_4 = new JPanel();
		first_4.setLayout(null);
		first_4.setBorder(null);
		first_4.setBounds(13, 183, 106, 71);
		panel.add(first_4);
		
		JLabel firstItem_4 = new JLabel("New label");
		firstItem_4.setBounds(25, 10, 57, 13);
		first_4.add(firstItem_4);
		
		JLabel lblNewLabel_7_1_4 = new JLabel("New label");
		lblNewLabel_7_1_4.setBounds(25, 33, 57, 13);
		first_4.add(lblNewLabel_7_1_4);
		
		JPanel first_5 = new JPanel();
		first_5.setLayout(null);
		first_5.setBorder(null);
		first_5.setBounds(13, 254, 106, 71);
		panel.add(first_5);
		
		JLabel firstItem_5 = new JLabel("New label");
		firstItem_5.setBounds(25, 10, 57, 13);
		first_5.add(firstItem_5);
		
		JLabel lblNewLabel_7_1_5 = new JLabel("New label");
		lblNewLabel_7_1_5.setBounds(25, 33, 57, 13);
		first_5.add(lblNewLabel_7_1_5);
		
		JPanel first_6 = new JPanel();
		first_6.setLayout(null);
		first_6.setBorder(null);
		first_6.setBounds(129, 183, 106, 71);
		panel.add(first_6);
		
		JLabel firstItem_6 = new JLabel("New label");
		firstItem_6.setBounds(25, 10, 57, 13);
		first_6.add(firstItem_6);
		
		JLabel lblNewLabel_7_1_6 = new JLabel("New label");
		lblNewLabel_7_1_6.setBounds(25, 33, 57, 13);
		first_6.add(lblNewLabel_7_1_6);
		
		JPanel first_7 = new JPanel();
		first_7.setLayout(null);
		first_7.setBorder(null);
		first_7.setBounds(245, 183, 106, 71);
		panel.add(first_7);
		
		JLabel firstItem_7 = new JLabel("New label");
		firstItem_7.setBounds(25, 10, 57, 13);
		first_7.add(firstItem_7);
		
		JLabel lblNewLabel_7_1_7 = new JLabel("New label");
		lblNewLabel_7_1_7.setBounds(25, 33, 57, 13);
		first_7.add(lblNewLabel_7_1_7);
		
		JPanel first_8 = new JPanel();
		first_8.setLayout(null);
		first_8.setBorder(null);
		first_8.setBounds(129, 254, 106, 71);
		panel.add(first_8);
		
		JLabel firstItem_8 = new JLabel("New label");
		firstItem_8.setBounds(25, 10, 57, 13);
		first_8.add(firstItem_8);
		
		JLabel lblNewLabel_7_1_8 = new JLabel("New label");
		lblNewLabel_7_1_8.setBounds(25, 33, 57, 13);
		first_8.add(lblNewLabel_7_1_8);
		
		JPanel first_9 = new JPanel();
		first_9.setLayout(null);
		first_9.setBorder(null);
		first_9.setBounds(245, 254, 106, 71);
		panel.add(first_9);
		
		JLabel firstItem_9 = new JLabel("New label");
		firstItem_9.setBounds(25, 10, 57, 13);
		first_9.add(firstItem_9);
		
		JLabel lblNewLabel_7_1_9 = new JLabel("New label");
		lblNewLabel_7_1_9.setBounds(25, 33, 57, 13);
		first_9.add(lblNewLabel_7_1_9);
		
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
		btnNewButton_2.setBounds(10, 466, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("50");
		btnNewButton_2_1.setBounds(107, 466, 85, 21);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("20");
		btnNewButton_2_2.setBounds(205, 466, 85, 21);
		contentPane.add(btnNewButton_2_2);
		
		JButton btnNewButton_2_3 = new JButton("10");
		btnNewButton_2_3.setBounds(300, 466, 85, 21);
		contentPane.add(btnNewButton_2_3);
		
		JButton btnNewButton_2_4 = new JButton("5");
		btnNewButton_2_4.setBounds(395, 466, 85, 21);
		contentPane.add(btnNewButton_2_4);
		
		this.setLocationRelativeTo(null);
	}
}
