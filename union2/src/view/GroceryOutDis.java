package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class GroceryOutDis extends JFrame {
	
	private JTextField textField;
	
	public GroceryOutDis() {
		init();
		
	}
	

	private void init() {
		
		setFont(new Font("D2Coding", Font.PLAIN, 14));
		setTitle("선택 식자재 출고/폐기");
		
		JTextPane groName = new JTextPane();
		groName.setFont(new Font("D2Coding", Font.PLAIN, 18));
		groName.setText("식자재 이름");
		groName.setBounds(12, 30, 320, 40);
		getContentPane().add(groName);
		
		
		JTextPane large_classific = new JTextPane();
		large_classific.setText("대분류");
		large_classific.setFont(new Font("D2Coding", Font.PLAIN, 18));
		large_classific.setBounds(12, 80, 155, 40);
		getContentPane().add(large_classific);
		
		JTextPane medium_classific = new JTextPane();
		medium_classific.setText("중분류");
		medium_classific.setFont(new Font("D2Coding", Font.PLAIN, 18));
		medium_classific.setBounds(177, 80, 155, 40);
		getContentPane().add(medium_classific);
		
		JTextPane small_classific = new JTextPane();
		small_classific.setText("소분류");
		small_classific.setFont(new Font("D2Coding", Font.PLAIN, 18));
		small_classific.setBounds(12, 130, 155, 40);
		getContentPane().add(small_classific);
		
		JTextPane storPlace = new JTextPane();
		storPlace.setText("보관장소");
		storPlace.setFont(new Font("D2Coding", Font.PLAIN, 18));
		storPlace.setBounds(177, 130, 155, 40);
		getContentPane().add(storPlace);
		
		JTextPane groQuan= new JTextPane();
		groQuan.setText("식자재 수량/중량");
		groQuan.setFont(new Font("D2Coding", Font.PLAIN, 18));
		groQuan.setBounds(12, 180, 240, 40);
		getContentPane().add(groQuan);
		
		JTextPane jtpUnit1 = new JTextPane();
		jtpUnit1.setText("단위");
		jtpUnit1.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpUnit1.setBounds(262, 180, 70, 40);
		getContentPane().add(jtpUnit1);
		
		textField = new JTextField();
		textField.setText("출고 수량/중량 입력");
		textField.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textField.setBounds(12, 230, 240, 40);
		textField.setColumns(10);
		getContentPane().add(textField);
		
		JTextPane jtpUnit2 = new JTextPane();
		jtpUnit2.setText("단위");
		jtpUnit2.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpUnit2.setBounds(262, 230, 70, 40);
		getContentPane().add(jtpUnit2);
		
		JButton btnConfirm = new JButton("폐기");
		btnConfirm.setFont(new Font("D2Coding", Font.PLAIN, 14));
		btnConfirm.setBounds(12, 299, 100, 40);
		getContentPane().add(btnConfirm);
		
		JButton btnOutDis = new JButton("출고");
		btnOutDis.setFont(new Font("D2Coding", Font.PLAIN, 14));
		btnOutDis.setBounds(122, 299, 100, 40);
		getContentPane().add(btnOutDis);

		JButton btnCancel = new JButton("취소");
		btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 14));
		btnCancel.setBounds(232, 299, 100, 40);
		getContentPane().add(btnCancel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(360, 400);
		setLocation(200, 200);
		getContentPane().setLayout(null);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new GroceryOutDis();

	}
}