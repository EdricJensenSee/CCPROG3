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

public class REGULARMACHINE extends JFrame {

	private JPanel contentPane;
	private JPanel seventh;

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
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(27, 373, 72, 35);
		panel_1_1.setForeground(Color.DARK_GRAY);
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_1_1.setBackground(Color.DARK_GRAY);
		panel_2.add(panel_1_1);
		
		JButton btnNewButton = new JButton("A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(10, 38, 45, 35);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("1");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(65, 38, 45, 35);
		panel_2.add(btnNewButton_1);
		
		JButton btnB = new JButton("B");
		btnB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnB.setBounds(10, 83, 45, 35);
		panel_2.add(btnB);
		
		JButton btnC = new JButton("C");
		btnC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnC.setBounds(10, 128, 45, 35);
		panel_2.add(btnC);
		
		JButton btnD = new JButton("D");
		btnD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnD.setBounds(10, 173, 45, 35);
		panel_2.add(btnD);
		
		JButton btnNewButton_1_1 = new JButton("2");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1.setBounds(65, 83, 45, 35);
		panel_2.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("3");
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1_1.setBounds(65, 128, 45, 35);
		panel_2.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_2 = new JButton("4");
		btnNewButton_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1_2.setBounds(65, 173, 45, 35);
		panel_2.add(btnNewButton_1_1_2);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCode.setBounds(38, 218, 72, 18);
		panel_2.add(lblCode);
		
		JLabel lblNewLabel_12 = new JLabel("A2");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_12.setOpaque(true);
		lblNewLabel_12.setForeground(Color.WHITE);
		lblNewLabel_12.setBackground(Color.DARK_GRAY);
		lblNewLabel_12.setBounds(27, 243, 70, 35);
		panel_2.add(lblNewLabel_12);
		
		JLabel lblNewLabel_12_1 = new JLabel("200");
		lblNewLabel_12_1.setOpaque(true);
		lblNewLabel_12_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12_1.setForeground(Color.WHITE);
		lblNewLabel_12_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_12_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_12_1.setBounds(27, 310, 70, 35);
		panel_2.add(lblNewLabel_12_1);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrice.setBounds(38, 285, 72, 18);
		panel_2.add(lblPrice);
		
		JLabel lblChange = new JLabel("Change");
		lblChange.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChange.setBounds(30, 350, 72, 18);
		panel_2.add(lblChange);
		
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
		
		JButton btnNewButton_6_1 = new JButton("New button");
		btnNewButton_6_1.setBounds(0, 28, 103, 33);
		first.add(btnNewButton_6_1);
		
		JPanel second = new JPanel();
		second.setLayout(null);
		second.setBorder(null);
		second.setBounds(129, 40, 106, 71);
		panel.add(second);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(25, 10, 57, 13);
		second.add(lblNewLabel_1);
		
		JButton btnNewButton_6_1_1 = new JButton("New button");
		btnNewButton_6_1_1.setBounds(0, 28, 103, 33);
		second.add(btnNewButton_6_1_1);
		
		JPanel third = new JPanel();
		third.setLayout(null);
		third.setBorder(null);
		third.setBounds(245, 40, 106, 71);
		panel.add(third);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(25, 10, 57, 13);
		third.add(lblNewLabel_2);
		
		JButton btnNewButton_6_1_2 = new JButton("New button");
		btnNewButton_6_1_2.setBounds(0, 28, 103, 33);
		third.add(btnNewButton_6_1_2);
		
		JPanel fourth = new JPanel();
		fourth.setLayout(null);
		fourth.setBorder(null);
		fourth.setBounds(13, 110, 106, 71);
		panel.add(fourth);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(25, 10, 57, 13);
		fourth.add(lblNewLabel_3);
		
		JButton btnNewButton_6_1_3 = new JButton("New button");
		btnNewButton_6_1_3.setBounds(0, 28, 103, 33);
		fourth.add(btnNewButton_6_1_3);
		
		JPanel fifth = new JPanel();
		fifth.setLayout(null);
		fifth.setBorder(null);
		fifth.setBounds(129, 110, 106, 71);
		panel.add(fifth);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(25, 10, 57, 13);
		fifth.add(lblNewLabel_4);
		
		JButton btnNewButton_6_1_4 = new JButton("New button");
		btnNewButton_6_1_4.setBounds(0, 28, 103, 33);
		fifth.add(btnNewButton_6_1_4);
		
		JPanel sixth = new JPanel();
		sixth.setLayout(null);
		sixth.setBorder(null);
		sixth.setBounds(245, 110, 106, 71);
		panel.add(sixth);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(25, 10, 57, 13);
		sixth.add(lblNewLabel_5);
		
		JButton btnNewButton_6_1_5 = new JButton("New button");
		btnNewButton_6_1_5.setBounds(0, 28, 103, 33);
		sixth.add(btnNewButton_6_1_5);
		
		seventh = new JPanel();
		seventh.setLayout(null);
		seventh.setBorder(null);
		seventh.setBounds(13, 182, 106, 71);
		panel.add(seventh);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(25, 10, 57, 13);
		seventh.add(lblNewLabel_6);
		
		JButton btnNewButton_6_1_6 = new JButton("New button");
		btnNewButton_6_1_6.setBounds(0, 28, 103, 33);
		seventh.add(btnNewButton_6_1_6);
		
		JPanel eight = new JPanel();
		eight.setLayout(null);
		eight.setBorder(null);
		eight.setBounds(129, 182, 106, 71);
		panel.add(eight);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(25, 10, 57, 13);
		eight.add(lblNewLabel_7);
		
		JButton btnNewButton_6_1_7 = new JButton("New button");
		btnNewButton_6_1_7.setBounds(0, 28, 103, 33);
		eight.add(btnNewButton_6_1_7);
		
		JPanel ninth = new JPanel();
		ninth.setLayout(null);
		ninth.setBorder(null);
		ninth.setBounds(245, 182, 106, 71);
		panel.add(ninth);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(25, 10, 57, 13);
		ninth.add(lblNewLabel_8);
		
		JButton btnNewButton_6_1_8 = new JButton("New button");
		btnNewButton_6_1_8.setBounds(0, 28, 103, 33);
		ninth.add(btnNewButton_6_1_8);
		
		JPanel tenth = new JPanel();
		tenth.setLayout(null);
		tenth.setBorder(null);
		tenth.setBounds(13, 252, 106, 71);
		panel.add(tenth);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(25, 10, 57, 13);
		tenth.add(lblNewLabel_9);
		
		JButton btnNewButton_6_1_9 = new JButton("New button");
		btnNewButton_6_1_9.setBounds(0, 28, 103, 33);
		tenth.add(btnNewButton_6_1_9);
		
		JPanel eleventh = new JPanel();
		eleventh.setLayout(null);
		eleventh.setBorder(null);
		eleventh.setBounds(129, 252, 106, 71);
		panel.add(eleventh);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setBounds(25, 10, 57, 13);
		eleventh.add(lblNewLabel_10);
		
		JButton btnNewButton_6_1_10 = new JButton("New button");
		btnNewButton_6_1_10.setBounds(0, 28, 103, 33);
		eleventh.add(btnNewButton_6_1_10);
		
		JPanel twelfth = new JPanel();
		twelfth.setLayout(null);
		twelfth.setBorder(null);
		twelfth.setBounds(245, 252, 106, 71);
		panel.add(twelfth);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setBounds(25, 10, 57, 13);
		twelfth.add(lblNewLabel_11);
		
		JButton btnNewButton_6_1_11 = new JButton("New button");
		btnNewButton_6_1_11.setBounds(0, 28, 103, 33);
		twelfth.add(btnNewButton_6_1_11);
		
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
