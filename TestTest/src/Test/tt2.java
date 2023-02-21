package Test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class tt2 {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tt2 window = new tt2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public tt2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("로그인창");
		frame.setBounds(100, 100, 350, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 334, 561);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(51, 203, 84, 32);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(105, 205, 180, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setBounds(51, 256, 84, 32);
		panel.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(105, 258, 180, 30);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("로그인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(51, 324, 236, 50);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("회원가입");
		btnNewButton_1.setBounds(51, 403, 234, 50);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("부탁해");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 37));
		lblNewLabel_2.setBounds(109, 91, 118, 75);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("냉장고를");
		lblNewLabel_2_1.setFont(new Font("굴림", Font.PLAIN, 37));
		lblNewLabel_2_1.setBounds(94, 44, 150, 75);
		panel.add(lblNewLabel_2_1);
	}
}
