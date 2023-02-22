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
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;

public class tt {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tt window = new tt();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public tt() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("회원가입");
		frame.setBounds(100, 100, 350, 485);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 334, 561);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("필수입력학목");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setBounds(51, 35, 107, 32);
		panel.add(lblNewLabel);
		
		textField = new JTextField("아이디");
		textField.setForeground(new Color(192, 192, 192));
		textField.setBounds(51, 64, 174, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1_1 = new JButton("회원가입");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setBounds(57, 367, 100, 50);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("입력취소");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_1.setBounds(186, 367, 100, 50);
		panel.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_2 = new JButton("중복확인");
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_2.setBounds(233, 63, 83, 30);

		JLabel lblNewLabel_1 = new JLabel("선택입력학목");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1.setBounds(51, 228, 107, 32);
		
		textField_1 = new JTextField("비밀번호");
		textField_1.setForeground(Color.LIGHT_GRAY);
		textField_1.setColumns(10);
		textField_1.setBounds(51, 104, 174, 30);
		
		textField_2 = new JTextField("비밀번호확인");
		textField_2.setForeground(Color.LIGHT_GRAY);
		textField_2.setColumns(10);
		textField_2.setBounds(51, 144, 174, 30);
		
		
		textField_3 = new JTextField("이름");
		textField_3.setForeground(Color.LIGHT_GRAY);
		textField_3.setColumns(10);
		textField_3.setBounds(51, 260, 174, 30);
		
		textField_4 = new JTextField("이메일");
		textField_4.setForeground(Color.LIGHT_GRAY);
		textField_4.setColumns(10);
		textField_4.setBounds(51, 301, 174, 30);
		
		panel.add(btnNewButton_1_1_2);
		panel.add(lblNewLabel_1);
		panel.add(textField_1);
		panel.add(textField_2);
		panel.add(textField_3);
		panel.add(textField_4);
	}
}
