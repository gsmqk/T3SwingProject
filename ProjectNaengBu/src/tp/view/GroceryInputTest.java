package tp.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GroceryInputTest extends JFrame {
	private JTextField textField, textField_1, textField_2, textField_3;
	
	public GroceryInputTest() {
		init();
	}
	private void init() {

	
		setFont(new Font("D2Coding", Font.PLAIN, 14));
		setTitle("신규 식자재 입력");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("카테고리");
		lblNewLabel.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblNewLabel.setBounds(12, 10, 64, 24);
		getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("대분류");
		comboBox.setBounds(12, 44, 100, 40);
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("중분류");
		comboBox_1.setBounds(122, 44, 100, 40);
		getContentPane().add(comboBox_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setToolTipText("보관장소");
		comboBox_1_1.setBounds(232, 44, 100, 40);
		getContentPane().add(comboBox_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("세부정보");
		lblNewLabel_1.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(12, 99, 64, 24);
		getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setToolTipText("단위");
		comboBox_1_1_1.setBounds(282, 184, 50, 40);
		getContentPane().add(comboBox_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("원");
		lblNewLabel_2.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(284, 234, 40, 40);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("이름");
		lblNewLabel_2_1.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(12, 133, 50, 40);
		getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("수량");
		lblNewLabel_2_1_1.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(12, 183, 50, 40);
		getContentPane().add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("가격");
		lblNewLabel_2_1_2.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblNewLabel_2_1_2.setBounds(12, 233, 50, 40);
		getContentPane().add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("구매처");
		lblNewLabel_2_1_3.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblNewLabel_2_1_3.setBounds(12, 283, 64, 40);
		getContentPane().add(lblNewLabel_2_1_3);
		
		textField = new JTextField();
		textField.setBounds(82, 133, 250, 40);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(82, 184, 190, 40);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(82, 234, 190, 40);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(82, 284, 250, 40);
		getContentPane().add(textField_3);
		
		JLabel lblNewLabel_2_1_3_1 = new JLabel("입고일");
		lblNewLabel_2_1_3_1.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblNewLabel_2_1_3_1.setBounds(12, 333, 64, 40);
		getContentPane().add(lblNewLabel_2_1_3_1);
		
		JLabel lblNewLabel_2_1_3_2 = new JLabel("소비기한");
		lblNewLabel_2_1_3_2.setFont(new Font("D2Coding", Font.PLAIN, 16));
		lblNewLabel_2_1_3_2.setBounds(12, 383, 64, 40);
		getContentPane().add(lblNewLabel_2_1_3_2);
		
		JButton btnNewButton = new JButton("입력");
		btnNewButton.setFont(new Font("D2Coding", Font.PLAIN, 18));
		btnNewButton.setBounds(69, 458, 90, 40);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.setFont(new Font("D2Coding", Font.PLAIN, 18));
		btnNewButton_1.setBounds(182, 458, 90, 40);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(82, 334, 250, 40);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("New button");
		btnNewButton_2_1.setBounds(82, 384, 250, 40);
		getContentPane().add(btnNewButton_2_1);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(360, 600);
		setLocation(200, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GroceryInputTest();

	}
}
