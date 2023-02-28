package view;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GroceryDisOut extends JFrame {

	private JTextField output_quantity, discard_quantity;
	String id;
	
	public GroceryDisOut() {
			
		init();
	}


	private void init() {
		
		
		setTitle("식자재 출고/폐기");
		setFont(new Font("D2Coding", Font.PLAIN, 14));
		getContentPane().setLayout(null);
		

		//상품명부터 재고량+단위까지는 DB의 자료를 출력하는 TEXTPANE
		JTextPane grocery_name = new JTextPane();
		grocery_name.setText("상품명");
		grocery_name.setFont(new Font("D2Coding", Font.PLAIN, 16));
		grocery_name.setBounds(20, 20, 300, 40);
		getContentPane().add(grocery_name);

		JTextPane large_classific = new JTextPane();
		large_classific.setText("대분류");
		large_classific.setFont(new Font("D2Coding", Font.PLAIN, 16));
		large_classific.setBounds(20, 70, 145, 40);
		getContentPane().add(large_classific);

		JTextPane medium_classific = new JTextPane();
		medium_classific.setText("중분류");
		medium_classific.setFont(new Font("D2Coding", Font.PLAIN, 16));
		medium_classific.setBounds(175, 70, 145, 40);
		getContentPane().add(medium_classific);

		JTextPane small_classific = new JTextPane();
		small_classific.setText("소분류");
		small_classific.setFont(new Font("D2Coding", Font.PLAIN, 16));
		small_classific.setBounds(20, 120, 145, 40);
		getContentPane().add(small_classific);

		JTextPane storage_place = new JTextPane();
		storage_place.setText("보관장소");
		storage_place.setFont(new Font("D2Coding", Font.PLAIN, 16));
		storage_place.setBounds(175, 120, 145, 40);
		getContentPane().add(storage_place);

		JTextPane quantity = new JTextPane();
		quantity.setText("재고량");
		quantity.setFont(new Font("D2Coding", Font.PLAIN, 16));
		quantity.setBounds(20, 170, 230, 40);
		getContentPane().add(quantity);

		JTextPane unit = new JTextPane();
		unit.setText("단위");
		unit.setFont(new Font("D2Coding", Font.PLAIN, 16));
		unit.setBounds(260, 170, 60, 40);
		getContentPane().add(unit);


		//입력하는 부분
		output_quantity = new JTextField();
		output_quantity.setText("출고량 입력");
		output_quantity.setFont(new Font("D2Coding", Font.PLAIN, 16));
		output_quantity.setColumns(10);
		output_quantity.setBounds(20, 240, 200, 40);
		getContentPane().add(output_quantity);

		discard_quantity = new JTextField();
		discard_quantity.setText("폐기량 입력");
		discard_quantity.setFont(new Font("D2Coding", Font.PLAIN, 16));
		discard_quantity.setColumns(10);
		discard_quantity.setBounds(20, 290, 200, 40);
		getContentPane().add(discard_quantity);

		JButton btnOutput = new JButton("출고");
		btnOutput.setFont(new Font("D2Coding", Font.PLAIN, 16));
		btnOutput.setBounds(230, 240, 90, 40);
		getContentPane().add(btnOutput);

		JButton btnDiscard = new JButton("폐기");
		btnDiscard.setFont(new Font("D2Coding", Font.PLAIN, 16));
		btnDiscard.setBounds(230, 290, 90, 40);
		getContentPane().add(btnDiscard);
		
		
		setSize(360, 390);
		setLocation(200, 200);
		setVisible(true);

	}

	public static void main(String[] args) {
		new GroceryDisOut();

	}
}
