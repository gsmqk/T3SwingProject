package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import model.F_DTO;
import model.F_Dao;

public class GroceryInfo extends JFrame implements ActionListener {
	
	String name;
	JTextPane groName, majorCla, moderCla, minorCla, storPlace, groQuan, jtpUnit1
	          , jtpPrice, jtpIndate, jtpExdate ;

	
	public GroceryInfo() {
		init();
	}

	public GroceryInfo(F_DTO fto) {
		F_DTO gFto = fto;
		
		setFont(new Font("D2Coding", Font.PLAIN, 14));
		setTitle("식자재 상세 정보");

		groName = new JTextPane();
		groName.setFont(new Font("D2Coding", Font.PLAIN, 18));
		groName.setText(gFto.getGrocery_name());
		groName.setBounds(47, 29, 340, 40);
		getContentPane().add(groName);
		
		
		majorCla = new JTextPane();
		majorCla.setText(gFto.getLarge_classific());
		majorCla.setFont(new Font("D2Coding", Font.PLAIN, 18));
		majorCla.setBounds(47, 97, 155, 40);
		getContentPane().add(majorCla);
		
		moderCla = new JTextPane();
		moderCla.setText(gFto.getMedium_classific());
		moderCla.setFont(new Font("D2Coding", Font.PLAIN, 18));
		moderCla.setBounds(232, 97, 155, 40);
		getContentPane().add(moderCla);
		
		minorCla = new JTextPane();
		minorCla.setText(gFto.getSmall_classific());
		minorCla.setFont(new Font("D2Coding", Font.PLAIN, 18));
		minorCla.setBounds(47, 162, 155, 40);
		getContentPane().add(minorCla);
		
		storPlace = new JTextPane();
		storPlace.setText(gFto.getStorage_place());
		storPlace.setFont(new Font("D2Coding", Font.PLAIN, 18));
		storPlace.setBounds(232, 162, 155, 40);
		getContentPane().add(storPlace);
		
		groQuan= new JTextPane();
		groQuan.setText(gFto.getQuantity());
		groQuan.setFont(new Font("D2Coding", Font.PLAIN, 18));
		groQuan.setBounds(47, 227, 240, 40);
		getContentPane().add(groQuan);
		
		jtpUnit1 = new JTextPane();
		jtpUnit1.setText(gFto.getUnit());
		jtpUnit1.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpUnit1.setBounds(317, 227, 70, 40);
		getContentPane().add(jtpUnit1);
		
		jtpPrice = new JTextPane();
		jtpPrice.setText(gFto.getPrice());
		jtpPrice.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpPrice.setBounds(47, 290, 300, 40);
		getContentPane().add(jtpPrice);
		
		JLabel jlbWon1 = new JLabel("원");
		jlbWon1.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jlbWon1.setBounds(359, 290, 40, 40);
		getContentPane().add(jlbWon1);
		
		switch (gFto.getUnit().toString()) {
		case "EA" : 
			JTextPane jtpUnit3 = new JTextPane();
			jtpUnit3.setText("개");
			jtpUnit3.setFont(new Font("D2Coding", Font.PLAIN, 18));
			jtpUnit3.setBounds(47, 340, 70, 40);
			getContentPane().add(jtpUnit3);
			break;
		case "KG" : 
		case "G" : 
			JTextPane jtpUnit4 = new JTextPane();
			jtpUnit4.setText("100g");
			jtpUnit4.setFont(new Font("D2Coding", Font.PLAIN, 18));
			jtpUnit4.setBounds(47, 340, 70, 40);
			getContentPane().add(jtpUnit4);
			break;
		case "L" : 
		case "ML" : 
			JTextPane jtpUnit5 = new JTextPane();
			jtpUnit5.setText("100ml");
			jtpUnit5.setFont(new Font("D2Coding", Font.PLAIN, 18));
			jtpUnit5.setBounds(47, 340, 70, 40);
			getContentPane().add(jtpUnit5);
			break;
		}
		
		JLabel jlbPer = new JLabel("당");
		jlbPer.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jlbPer.setBounds(129, 340, 40, 40);
		getContentPane().add(jlbPer);
		
		int price1 = Integer.parseInt(gFto.getPrice());
		int quan1 = Integer.parseInt(gFto.getQuantity());

		switch (gFto.getUnit()) {
		case "EA" : 

			int perPrice1 = (price1 / quan1);
			String pph1 = String.valueOf(perPrice1);

			JTextPane jtpUcost1 = new JTextPane();
			jtpUcost1.setText(pph1);
			jtpUcost1.setFont(new Font("D2Coding", Font.PLAIN, 18));
			jtpUcost1.setBounds(198, 340, 150, 40);
			getContentPane().add(jtpUcost1);
			break;

		case "ML" :
		case "G" : 
			
			int perPrice2 = (price1 / quan1) * 100;
			String pph2 = String.valueOf(perPrice2);

			JTextPane jtpUcost2 = new JTextPane();
			jtpUcost2.setText(pph2);
			jtpUcost2.setFont(new Font("D2Coding", Font.PLAIN, 18));
			jtpUcost2.setBounds(198, 340, 150, 40);
			getContentPane().add(jtpUcost2);
			break;
			
		case "KG" :
		case "L" :
			
			int perPrice3 = (price1 / (quan1 * 100)) * 100;
			String pph3 = String.valueOf(perPrice3);

			JTextPane jtpUcost3 = new JTextPane();
			jtpUcost3.setText(pph3);
			jtpUcost3.setFont(new Font("D2Coding", Font.PLAIN, 18));
			jtpUcost3.setBounds(198, 340, 150, 40);
			getContentPane().add(jtpUcost3);
			
			break;
		}
		
		JLabel jlbWon2 = new JLabel("원");
		jlbWon2.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jlbWon2.setBounds(359, 340, 40, 40);
		getContentPane().add(jlbWon2);
		
		jtpIndate = new JTextPane();
		jtpIndate.setText(gFto.getInput_date());
		jtpIndate.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpIndate.setBounds(232, 403, 155, 40);
		getContentPane().add(jtpIndate);
		
		jtpExdate = new JTextPane();
		jtpExdate.setText(gFto.getExpire_date());
		jtpExdate.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpExdate.setBounds(47, 403, 155, 40);
		getContentPane().add(jtpExdate);
		
		JTextPane jtpDdate = new JTextPane();
		jtpDdate.setText("");
		jtpDdate.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpDdate.setBounds(47, 465, 340, 80);
		getContentPane().add(jtpDdate);
		
		JButton btnConfirm = new JButton("수정완료");
		btnConfirm.setFont(new Font("D2Coding", Font.PLAIN, 14));
		btnConfirm.setBounds(47, 554, 100, 40);
		getContentPane().add(btnConfirm);
		
		JButton btnOutDis = new JButton("출고/폐기");
		btnOutDis.setFont(new Font("D2Coding", Font.PLAIN, 14));
		btnOutDis.setBounds(167, 554, 100, 40);
		getContentPane().add(btnOutDis);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 14));
		btnCancel.setBounds(286, 554, 100, 40);
		getContentPane().add(btnCancel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(445, 655);
		setLocation(200, 200);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("식자재 이름");
		lblNewLabel.setBounds(47, 10, 78, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("대분류");
		lblNewLabel_1.setBounds(47, 79, 78, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("중분류");
		lblNewLabel_1_1.setBounds(232, 79, 78, 15);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("소분류");
		lblNewLabel_1_2.setBounds(47, 147, 78, 15);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("소분류");
		lblNewLabel_1_2_1.setBounds(232, 147, 78, 15);
		getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("식자재 수량/중량");
		lblNewLabel_1_2_2.setBounds(47, 212, 122, 15);
		getContentPane().add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("식자재 가격");
		lblNewLabel_1_2_3.setBounds(47, 274, 78, 15);
		getContentPane().add(lblNewLabel_1_2_3);
		
		JLabel lblNewLabel_1_2_3_1 = new JLabel("입고일");
		lblNewLabel_1_2_3_1.setBounds(47, 388, 78, 15);
		getContentPane().add(lblNewLabel_1_2_3_1);
		
		JLabel lblNewLabel_1_2_3_1_1 = new JLabel("유통기한");
		lblNewLabel_1_2_3_1_1.setBounds(232, 388, 78, 15);
		getContentPane().add(lblNewLabel_1_2_3_1_1);
		
		JLabel lblNewLabel_1_2_3_1_2 = new JLabel("메모");
		lblNewLabel_1_2_3_1_2.setBounds(47, 449, 78, 15);
		getContentPane().add(lblNewLabel_1_2_3_1_2);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		btnConfirm.addActionListener(this);
		btnCancel.addActionListener(this);
		
	}

	private void init() {
		setFont(new Font("D2Coding", Font.PLAIN, 14));
		setTitle("식자재 상세 정보");

		
		
		groName = new JTextPane();
		groName.setFont(new Font("D2Coding", Font.PLAIN, 18));
		groName.setText("");
		groName.setBounds(47, 29, 340, 40);
		getContentPane().add(groName);
		
		
		JTextPane majorCla = new JTextPane();
		majorCla.setText("대분류");
		majorCla.setFont(new Font("D2Coding", Font.PLAIN, 18));
		majorCla.setBounds(47, 97, 155, 40);
		getContentPane().add(majorCla);
		
		JTextPane moderCla = new JTextPane();
		moderCla.setText("중분류");
		moderCla.setFont(new Font("D2Coding", Font.PLAIN, 18));
		moderCla.setBounds(232, 97, 155, 40);
		getContentPane().add(moderCla);
		
		JTextPane minorCla = new JTextPane();
		minorCla.setText("소분류");
		minorCla.setFont(new Font("D2Coding", Font.PLAIN, 18));
		minorCla.setBounds(47, 162, 155, 40);
		getContentPane().add(minorCla);
		
		JTextPane storPlace = new JTextPane();
		storPlace.setText("보관장소");
		storPlace.setFont(new Font("D2Coding", Font.PLAIN, 18));
		storPlace.setBounds(232, 162, 155, 40);
		getContentPane().add(storPlace);
		
		JTextPane groQuan= new JTextPane();
		groQuan.setText("식자재 수량/중량");
		groQuan.setFont(new Font("D2Coding", Font.PLAIN, 18));
		groQuan.setBounds(47, 227, 240, 40);
		getContentPane().add(groQuan);
		
		JTextPane jtpUnit1 = new JTextPane();
		jtpUnit1.setText("단위");
		jtpUnit1.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpUnit1.setBounds(317, 227, 70, 40);
		getContentPane().add(jtpUnit1);
		
		JTextPane jtpPrice = new JTextPane();
		jtpPrice.setText("식자재 가격");
		jtpPrice.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpPrice.setBounds(47, 290, 300, 40);
		getContentPane().add(jtpPrice);
		
		JLabel jlbWon1 = new JLabel("원");
		jlbWon1.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jlbWon1.setBounds(359, 290, 40, 40);
		getContentPane().add(jlbWon1);
		
		JTextPane jtpUnit2 = new JTextPane();
		jtpUnit2.setText("단위");
		jtpUnit2.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpUnit2.setBounds(47, 340, 70, 40);
		getContentPane().add(jtpUnit2);
		
		JLabel jlbPer = new JLabel("당");
		jlbPer.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jlbPer.setBounds(129, 340, 40, 40);
		getContentPane().add(jlbPer);
		
		JTextPane jtpUcost = new JTextPane();
		jtpUcost.setText("단가");
		jtpUcost.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpUcost.setBounds(198, 340, 150, 40);
		getContentPane().add(jtpUcost);
		
		JLabel jlbWon2 = new JLabel("원");
		jlbWon2.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jlbWon2.setBounds(359, 340, 40, 40);
		getContentPane().add(jlbWon2);
		
		JTextPane jtpEdate = new JTextPane();
		jtpEdate.setText("유통기한");
		jtpEdate.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpEdate.setBounds(232, 403, 155, 40);
		getContentPane().add(jtpEdate);
		
		JTextPane jtpIndate = new JTextPane();
		jtpIndate.setText("입고일");
		jtpIndate.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpIndate.setBounds(47, 403, 155, 40);
		getContentPane().add(jtpIndate);
		
		JTextPane jtpDdate = new JTextPane();
		jtpDdate.setText("메모");
		jtpDdate.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpDdate.setBounds(47, 465, 340, 80);
		getContentPane().add(jtpDdate);
		
		JButton btnConfirm = new JButton("수정완료");
		btnConfirm.setFont(new Font("D2Coding", Font.PLAIN, 14));
		btnConfirm.setBounds(47, 554, 100, 40);
		getContentPane().add(btnConfirm);
		
		JButton btnOutDis = new JButton("출고/폐기");
		btnOutDis.setFont(new Font("D2Coding", Font.PLAIN, 14));
		btnOutDis.setBounds(167, 554, 100, 40);
		getContentPane().add(btnOutDis);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 14));
		btnCancel.setBounds(286, 554, 100, 40);
		getContentPane().add(btnCancel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(445, 655);
		setLocation(200, 200);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("식자재 이름");
		lblNewLabel.setBounds(47, 10, 78, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("대분류");
		lblNewLabel_1.setBounds(47, 79, 78, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("중분류");
		lblNewLabel_1_1.setBounds(232, 79, 78, 15);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("소분류");
		lblNewLabel_1_2.setBounds(47, 147, 78, 15);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("소분류");
		lblNewLabel_1_2_1.setBounds(232, 147, 78, 15);
		getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("식자재 수량/중량");
		lblNewLabel_1_2_2.setBounds(47, 212, 122, 15);
		getContentPane().add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("식자재 가격");
		lblNewLabel_1_2_3.setBounds(47, 274, 78, 15);
		getContentPane().add(lblNewLabel_1_2_3);
		
		JLabel lblNewLabel_1_2_3_1 = new JLabel("입고일");
		lblNewLabel_1_2_3_1.setBounds(47, 388, 78, 15);
		getContentPane().add(lblNewLabel_1_2_3_1);
		
		JLabel lblNewLabel_1_2_3_1_1 = new JLabel("유통기한");
		lblNewLabel_1_2_3_1_1.setBounds(232, 388, 78, 15);
		getContentPane().add(lblNewLabel_1_2_3_1_1);
		
		JLabel lblNewLabel_1_2_3_1_2 = new JLabel("메모");
		lblNewLabel_1_2_3_1_2.setBounds(47, 449, 78, 15);
		getContentPane().add(lblNewLabel_1_2_3_1_2);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}


	public static void main(String[] args) {
		new GroceryInfo();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "수정완료" :
			
			F_Dao fao = new F_Dao();
			
			int choice = JOptionPane.showConfirmDialog(null, "수정하시겠습니까?",
					"수정확인",
					JOptionPane.OK_CANCEL_OPTION);
			int aftcnt = 0;
			
			String msg = "";
			if(choice == 0) {
				F_DTO fto = getViewData();
			}
			break;
		case "취소" : 
			this.dispose();
			break;
		}
		
	}

	private F_DTO getViewData() {
		String fname = groName.getText();
		String large = majorCla.getText();
		String medium = moderCla.getText();
		String small = minorCla.getText();
		String place = storPlace.getText();
		String quan = groQuan.getText();
		String unit = jtpUnit1.getText();
		String price = jtpPrice.getText();
//		String indate = .getText();
		
		return null;
	}
}
