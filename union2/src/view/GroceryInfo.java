package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import model.F_DTO;
import model.F_Dao;

public class GroceryInfo extends JFrame {
	
	String name;

	
	public GroceryInfo() {
		init();
	}

	public GroceryInfo(F_DTO fto) {
		F_DTO gFto = fto;
		
		setFont(new Font("D2Coding", Font.PLAIN, 14));
		setTitle("식자재 상세 정보");

		
		
		JTextPane groName = new JTextPane();
		groName.setFont(new Font("D2Coding", Font.PLAIN, 18));
		groName.setText(gFto.getGrocery_name());
		groName.setBounds(12, 30, 320, 40);
		getContentPane().add(groName);
		
		
		JTextPane majorCla = new JTextPane();
		majorCla.setText(gFto.getLarge_classific());
		majorCla.setFont(new Font("D2Coding", Font.PLAIN, 18));
		majorCla.setBounds(12, 80, 155, 40);
		getContentPane().add(majorCla);
		
		JTextPane moderCla = new JTextPane();
		moderCla.setText(gFto.getMedium_classific());
		moderCla.setFont(new Font("D2Coding", Font.PLAIN, 18));
		moderCla.setBounds(177, 80, 155, 40);
		getContentPane().add(moderCla);
		
		JTextPane minorCla = new JTextPane();
		minorCla.setText(gFto.getSmall_classific());
		minorCla.setFont(new Font("D2Coding", Font.PLAIN, 18));
		minorCla.setBounds(12, 130, 155, 40);
		getContentPane().add(minorCla);
		
		JTextPane storPlace = new JTextPane();
		storPlace.setText(gFto.getStorage_place());
		storPlace.setFont(new Font("D2Coding", Font.PLAIN, 18));
		storPlace.setBounds(177, 130, 155, 40);
		getContentPane().add(storPlace);
		
		JTextPane groQuan= new JTextPane();
		groQuan.setText(gFto.getQuantity());
		groQuan.setFont(new Font("D2Coding", Font.PLAIN, 18));
		groQuan.setBounds(12, 180, 240, 40);
		getContentPane().add(groQuan);
		
		JTextPane jtpUnit1 = new JTextPane();
		jtpUnit1.setText(gFto.getUnit());
		jtpUnit1.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpUnit1.setBounds(262, 180, 70, 40);
		getContentPane().add(jtpUnit1);
		
		JTextPane jtpPrice = new JTextPane();
		jtpPrice.setText(gFto.getPrice());
		jtpPrice.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpPrice.setBounds(12, 230, 260, 40);
		getContentPane().add(jtpPrice);
		
		JLabel jlbWon1 = new JLabel("원");
		jlbWon1.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jlbWon1.setBounds(292, 230, 40, 40);
		getContentPane().add(jlbWon1);
		
		switch (gFto.getUnit().toString()) {
		case "KG" : 
			JTextPane jtpUnit2 = new JTextPane();
			jtpUnit2.setText("1" + gFto.getUnit());
			jtpUnit2.setFont(new Font("D2Coding", Font.PLAIN, 18));
			jtpUnit2.setBounds(12, 280, 70, 40);
			getContentPane().add(jtpUnit2);
			break;
		case "G" : 
			JTextPane jtpUnit3 = new JTextPane();
			jtpUnit3.setText("100" + gFto.getUnit());
			jtpUnit3.setFont(new Font("D2Coding", Font.PLAIN, 18));
			jtpUnit3.setBounds(12, 280, 70, 40);
			getContentPane().add(jtpUnit3);
			break;
		case "L" : 
			JTextPane jtpUnit4 = new JTextPane();
			jtpUnit4.setText("1" + gFto.getUnit());
			jtpUnit4.setFont(new Font("D2Coding", Font.PLAIN, 18));
			jtpUnit4.setBounds(12, 280, 70, 40);
			getContentPane().add(jtpUnit4);
			break;
		case "ml" : 
			JTextPane jtpUnit5 = new JTextPane();
			jtpUnit5.setText("100" + gFto.getUnit());
			jtpUnit5.setFont(new Font("D2Coding", Font.PLAIN, 18));
			jtpUnit5.setBounds(12, 280, 70, 40);
			getContentPane().add(jtpUnit5);
			break;
		}
		
//		JTextPane jtpUnit2 = new JTextPane();
//		jtpUnit2.setText("100" + gFto.getUnit());
//		jtpUnit2.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		jtpUnit2.setBounds(12, 280, 70, 40);
//		getContentPane().add(jtpUnit2);
		
		JLabel jlbPer = new JLabel("당");
		jlbPer.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jlbPer.setBounds(83, 280, 40, 40);
		getContentPane().add(jlbPer);
		
//		String quan1 = gFto.getQuantity();
//		String price1 = gFto.getPrice();
		
		int price1 = Integer.parseInt(gFto.getPrice());
		int quan1 = Integer.parseInt(gFto.getQuantity());
		
		int totPrice1 = price1 * quan1;
//		int perPrice1 = 
		
		JTextPane jtpUcost = new JTextPane();
		jtpUcost.setText(gFto.getPrice());
		jtpUcost.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpUcost.setBounds(122, 280, 150, 40);
		getContentPane().add(jtpUcost);
		
		JLabel jlbWon2 = new JLabel("원");
		jlbWon2.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jlbWon2.setBounds(292, 280, 40, 40);
		getContentPane().add(jlbWon2);
		
		JTextPane jtpPdate = new JTextPane();
		jtpPdate.setText("제조년월일");
		jtpPdate.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpPdate.setBounds(12, 340, 155, 40);
		getContentPane().add(jtpPdate);
		
		JTextPane jtpEdate = new JTextPane();
		jtpEdate.setText(gFto.getExpire_date());
		jtpEdate.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpEdate.setBounds(177, 340, 155, 40);
		getContentPane().add(jtpEdate);
		
		JTextPane jtpIndate = new JTextPane();
		jtpIndate.setText(gFto.getInput_date());
		jtpIndate.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpIndate.setBounds(12, 390, 155, 40);
		getContentPane().add(jtpIndate);
		
		JTextPane jtpDdate = new JTextPane();
		jtpDdate.setText(gFto.getDue_date());
		jtpDdate.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpDdate.setBounds(177, 390, 155, 40);
		getContentPane().add(jtpDdate);
		
		JButton btnConfirm = new JButton("수정완료");
		btnConfirm.setFont(new Font("D2Coding", Font.PLAIN, 14));
		btnConfirm.setBounds(12, 453, 100, 40);
		getContentPane().add(btnConfirm);
		
		JButton btnOutDis = new JButton("출고/폐기");
		btnOutDis.setFont(new Font("D2Coding", Font.PLAIN, 14));
		btnOutDis.setBounds(122, 453, 100, 40);
		getContentPane().add(btnOutDis);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 14));
		btnCancel.setBounds(232, 453, 100, 40);
		getContentPane().add(btnCancel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(360, 560);
		setLocation(200, 200);
		getContentPane().setLayout(null);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}

	private void init() {
		setFont(new Font("D2Coding", Font.PLAIN, 14));
		setTitle("식자재 상세 정보");

		
		
		JTextPane groName = new JTextPane();
		groName.setFont(new Font("D2Coding", Font.PLAIN, 18));
		groName.setText("");
		groName.setBounds(12, 30, 320, 40);
		getContentPane().add(groName);
		
		
		JTextPane majorCla = new JTextPane();
		majorCla.setText("대분류");
		majorCla.setFont(new Font("D2Coding", Font.PLAIN, 18));
		majorCla.setBounds(12, 80, 155, 40);
		getContentPane().add(majorCla);
		
		JTextPane moderCla = new JTextPane();
		moderCla.setText("중분류");
		moderCla.setFont(new Font("D2Coding", Font.PLAIN, 18));
		moderCla.setBounds(177, 80, 155, 40);
		getContentPane().add(moderCla);
		
		JTextPane minorCla = new JTextPane();
		minorCla.setText("소분류");
		minorCla.setFont(new Font("D2Coding", Font.PLAIN, 18));
		minorCla.setBounds(12, 130, 155, 40);
		getContentPane().add(minorCla);
		
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
		
		JTextPane jtpPrice = new JTextPane();
		jtpPrice.setText("식자재 가격");
		jtpPrice.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpPrice.setBounds(12, 230, 260, 40);
		getContentPane().add(jtpPrice);
		
		JLabel jlbWon1 = new JLabel("원");
		jlbWon1.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jlbWon1.setBounds(292, 230, 40, 40);
		getContentPane().add(jlbWon1);
		
		JTextPane jtpUnit2 = new JTextPane();
		jtpUnit2.setText("단위");
		jtpUnit2.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpUnit2.setBounds(12, 280, 70, 40);
		getContentPane().add(jtpUnit2);
		
		JLabel jlbPer = new JLabel("당");
		jlbPer.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jlbPer.setBounds(83, 280, 40, 40);
		getContentPane().add(jlbPer);
		
		JTextPane jtpUcost = new JTextPane();
		jtpUcost.setText("단가");
		jtpUcost.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpUcost.setBounds(122, 280, 150, 40);
		getContentPane().add(jtpUcost);
		
		JLabel jlbWon2 = new JLabel("원");
		jlbWon2.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jlbWon2.setBounds(292, 280, 40, 40);
		getContentPane().add(jlbWon2);
		
		JTextPane jtpPdate = new JTextPane();
		jtpPdate.setText("제조년월일");
		jtpPdate.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpPdate.setBounds(12, 340, 155, 40);
		getContentPane().add(jtpPdate);
		
		JTextPane jtpEdate = new JTextPane();
		jtpEdate.setText("유통기한");
		jtpEdate.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpEdate.setBounds(177, 340, 155, 40);
		getContentPane().add(jtpEdate);
		
		JTextPane jtpIndate = new JTextPane();
		jtpIndate.setText("입고일");
		jtpIndate.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpIndate.setBounds(12, 390, 155, 40);
		getContentPane().add(jtpIndate);
		
		JTextPane jtpDdate = new JTextPane();
		jtpDdate.setText("만기일");
		jtpDdate.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpDdate.setBounds(177, 390, 155, 40);
		getContentPane().add(jtpDdate);
		
		JButton btnConfirm = new JButton("수정완료");
		btnConfirm.setFont(new Font("D2Coding", Font.PLAIN, 14));
		btnConfirm.setBounds(12, 453, 100, 40);
		getContentPane().add(btnConfirm);
		
		JButton btnOutDis = new JButton("출고/폐기");
		btnOutDis.setFont(new Font("D2Coding", Font.PLAIN, 14));
		btnOutDis.setBounds(122, 453, 100, 40);
		getContentPane().add(btnOutDis);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 14));
		btnCancel.setBounds(232, 453, 100, 40);
		getContentPane().add(btnCancel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(360, 560);
		setLocation(200, 200);
		getContentPane().setLayout(null);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}


	public static void main(String[] args) {
		new GroceryInfo();

	}

}
