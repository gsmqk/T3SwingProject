package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import model.F_DTO;
import model.F_Dao;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class GroceryInfo extends JFrame implements ActionListener {
	
	JTextPane groName, storPlace, groQuan, jtpUnit1
	          , jtpPrice, jtpIndate, jtpExdate, memo,
	          majorCla, moderCla, minorCla, jtpstore;
	MainTable01 mt01;
	JTextArea memoTa;
	Grocery_Edit gEdit = null;
	GroceryDisOut gdo = null; 
	String id;
	
//	public GroceryInfo() {
//		init();
//	}

	public GroceryInfo(F_DTO fto) {
		
		F_DTO gFto = fto;
		
		setFont(new Font("D2Coding", Font.PLAIN, 14));
		setTitle("식자재 상세 정보");

		id = fto.getUser_id();
		
		groName = new JTextPane();
		groName.setFont(new Font("D2Coding", Font.PLAIN, 18));
		groName.setText(gFto.getGrocery_name());
		groName.setEditable(false);
		groName.setBounds(25, 30, 307, 40);
		getContentPane().add(groName);
		
		
		majorCla = new JTextPane();
		majorCla.setText(gFto.getLarge_classific());
		majorCla.setFont(new Font("D2Coding", Font.PLAIN, 18));
		majorCla.setEditable(false);
		majorCla.setBounds(25, 100, 142, 40);
		getContentPane().add(majorCla);
		
		moderCla = new JTextPane();
		moderCla.setText(gFto.getMedium_classific());
		moderCla.setFont(new Font("D2Coding", Font.PLAIN, 18));
		moderCla.setEditable(false);
		moderCla.setBounds(190, 100, 142, 40);
		getContentPane().add(moderCla);
		
		minorCla = new JTextPane();
		minorCla.setText(gFto.getSmall_classific());
		minorCla.setFont(new Font("D2Coding", Font.PLAIN, 18));
		minorCla.setEditable(false);
		minorCla.setBounds(25, 155, 142, 40);
		getContentPane().add(minorCla);
		
		storPlace = new JTextPane();
		storPlace.setText(gFto.getStorage_place());
		storPlace.setFont(new Font("D2Coding", Font.PLAIN, 18));
		storPlace.setEditable(false);
		storPlace.setBounds(190, 155, 142, 40);
		getContentPane().add(storPlace);
		
		groQuan = new JTextPane();
		groQuan.setText(gFto.getQuantity());
		groQuan.setFont(new Font("D2Coding", Font.PLAIN, 18));
		groQuan.setEditable(false);
		groQuan.setBounds(23, 265, 227, 40);
		getContentPane().add(groQuan);
		
		jtpUnit1 = new JTextPane();
		jtpUnit1.setText(gFto.getUnit());
		jtpUnit1.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpUnit1.setEditable(false);
		jtpUnit1.setBounds(262, 265, 70, 40);
		getContentPane().add(jtpUnit1);
		
		jtpPrice = new JTextPane();
		jtpPrice.setText(gFto.getPrice());
		jtpPrice.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpPrice.setEditable(false);
		jtpPrice.setBounds(22, 320, 270, 40);
		getContentPane().add(jtpPrice);
		
		JLabel jlbWon1 = new JLabel("원");
		jlbWon1.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jlbWon1.setBounds(292, 320, 40, 40);
		getContentPane().add(jlbWon1);
		
		System.out.println(gFto);
		
		switch (gFto.getUnit().toString()) {
		case "EA" : 
			JTextPane jtpUnit3 = new JTextPane();
			jtpUnit3.setText("개");
			jtpUnit3.setFont(new Font("D2Coding", Font.PLAIN, 18));
			jtpUnit3.setEditable(false);
			jtpUnit3.setBounds(23, 375, 63, 40);
			getContentPane().add(jtpUnit3);
			break;
		case "KG" : 
		case "G" : 
			JTextPane jtpUnit4 = new JTextPane();
			jtpUnit4.setText("100g");
			jtpUnit4.setFont(new Font("D2Coding", Font.PLAIN, 18));
			jtpUnit4.setEditable(false);
			jtpUnit4.setBounds(23, 375, 63, 40);
			getContentPane().add(jtpUnit4);
			break;
		case "L" : 
		case "ML" : 
			JTextPane jtpUnit5 = new JTextPane();
			jtpUnit5.setText("100ml");
			jtpUnit5.setFont(new Font("D2Coding", Font.PLAIN, 18));
			jtpUnit5.setEditable(false);
			jtpUnit5.setBounds(23, 375, 63, 40);
			getContentPane().add(jtpUnit5);
			break;
		}
		
		
		JLabel jlbPer = new JLabel("당");
		jlbPer.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jlbPer.setBounds(98, 375, 40, 40);
		getContentPane().add(jlbPer);
		
		
		int price1 = Integer.parseInt(gFto.getPrice());
		int quan1 = Integer.parseInt(gFto.getQuantity());

		switch (gFto.getUnit()) {
		case "EA" : 

			System.out.println(price1);
			System.out.println(quan1);
			
			int perPrice1 = (price1 / quan1);
			String pph1 = String.valueOf(perPrice1);

			JTextPane jtpUcost1 = new JTextPane();
			jtpUcost1.setText(pph1);
			jtpUcost1.setFont(new Font("D2Coding", Font.PLAIN, 18));
			jtpUcost1.setEditable(false);
			jtpUcost1.setBounds(150, 375, 142, 40);
			getContentPane().add(jtpUcost1);
			break;

		case "ML" :
		case "G" : 
			
			System.out.println(price1);
			System.out.println(quan1);
			
			int perPrice2 = (price1 / quan1) * 100;
			String pph2 = String.valueOf(perPrice2);

			JTextPane jtpUcost2 = new JTextPane();
			jtpUcost2.setText(pph2);
			jtpUcost2.setFont(new Font("D2Coding", Font.PLAIN, 18));
			jtpUcost2.setEditable(false);
			jtpUcost2.setBounds(150, 375, 142, 40);
			getContentPane().add(jtpUcost2);
			break;
			
		case "KG" :
		case "L" :
			
			System.out.println(price1);
			System.out.println(quan1);
			
			int perPrice3 = (price1 / (quan1 * 100)) * 100;
			String pph3 = String.valueOf(perPrice3);

			JTextPane jtpUcost3 = new JTextPane();
			jtpUcost3.setText(pph3);
			jtpUcost3.setFont(new Font("D2Coding", Font.PLAIN, 18));
			jtpUcost3.setEditable(false);
			jtpUcost3.setBounds(150, 375, 142, 40);
			getContentPane().add(jtpUcost3);
			
			break;
		}
		
		JLabel jlbWon2 = new JLabel("원");
		jlbWon2.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jlbWon2.setBounds(292, 375, 40, 40);
		getContentPane().add(jlbWon2);
		
		JLabel jtpPdate = new JLabel();
		jtpPdate.setText("입고일");
		jtpPdate.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpPdate.setBounds(12, 430, 111, 40);
		getContentPane().add(jtpPdate);
		
		jtpIndate = new JTextPane();
		jtpIndate.setText(gFto.getInput_date());
		jtpIndate.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpIndate.setEditable(false);
		jtpIndate.setBounds(130, 430, 202, 40);
		getContentPane().add(jtpIndate);
		
		jtpExdate = new JTextPane();
		jtpExdate.setText(gFto.getExpire_date());
		jtpExdate.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpExdate.setEditable(false);
		jtpExdate.setBounds(130, 485, 202, 40);
		getContentPane().add(jtpExdate);
		
		JLabel jtpDdate = new JLabel();
		jtpDdate.setText("소비기한");
		jtpDdate.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpDdate.setBounds(12, 485, 112, 40);
		getContentPane().add(jtpDdate);
		
		JButton btnConfirm = new JButton("수정하기");
		btnConfirm.setFont(new Font("D2Coding", Font.PLAIN, 14));
		btnConfirm.setBounds(12, 680, 100, 40);
		getContentPane().add(btnConfirm);
		
		JButton btnOutDis = new JButton("출고/폐기");
		btnOutDis.setFont(new Font("D2Coding", Font.PLAIN, 14));
		btnOutDis.setBounds(122, 680, 100, 40);
		getContentPane().add(btnOutDis);
		
		JButton btnCancel = new JButton("닫기");
		btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 14));
		btnCancel.setBounds(232, 680, 100, 40);
		getContentPane().add(btnCancel);
		
		memoTa = new JTextArea();
		memoTa.setText(gFto.getMemo());
		memoTa.setEditable(false);
		memoTa.setBounds(12, 571, 320, 89);
		getContentPane().add(memoTa);
		
		JLabel jtpDdate_1 = new JLabel();
		jtpDdate_1.setHorizontalAlignment(SwingConstants.CENTER);
		jtpDdate_1.setText("메모");
		jtpDdate_1.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpDdate_1.setBounds(122, 535, 100, 40);
		getContentPane().add(jtpDdate_1);
		
		jtpstore = new JTextPane();
		jtpstore.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpstore.setText(gFto.getStore_name());
		jtpstore.setEditable(false);
		jtpstore.setBounds(25, 210, 142, 40);
		getContentPane().add(jtpstore);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(370, 765);
		setLocation(200, 200);
		getContentPane().setLayout(null);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		btnConfirm.addActionListener(this);
		btnOutDis.addActionListener(this);
		btnCancel.addActionListener(this);
		
	}

//	private void init() {
//		setFont(new Font("D2Coding", Font.PLAIN, 14));
//		setTitle("식자재 상세 정보");
//
//		
//		
//		groName = new JTextPane();
//		groName.setFont(new Font("D2Coding", Font.PLAIN, 18));
////		groName.setText(gFto.getGrocery_name());
//		groName.setBounds(25, 30, 307, 40);
//		getContentPane().add(groName);
//		
//		
//		majorCla = new JTextPane();
////		majorCla.setText(gFto.getLarge_classific());
//		majorCla.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		majorCla.setBounds(25, 100, 142, 40);
//		getContentPane().add(majorCla);
//		
//		moderCla = new JTextPane();
////		moderCla.setText(gFto.getMedium_classific());
//		moderCla.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		moderCla.setBounds(190, 100, 142, 40);
//		getContentPane().add(moderCla);
//		
//		minorCla = new JTextPane();
////		minorCla.setText(gFto.getSmall_classific());
//		minorCla.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		minorCla.setBounds(25, 155, 142, 40);
//		getContentPane().add(minorCla);
//		
//		storPlace = new JTextPane();
////		storPlace.setText(gFto.getStorage_place());
//		storPlace.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		storPlace.setBounds(190, 155, 142, 40);
//		getContentPane().add(storPlace);
//		
//		groQuan = new JTextPane();
////		groQuan.setText(gFto.getQuantity());
//		groQuan.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		groQuan.setBounds(23, 265, 227, 40);
//		getContentPane().add(groQuan);
//		
//		jtpUnit1 = new JTextPane();
////		jtpUnit1.setText(gFto.getUnit());
//		jtpUnit1.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		jtpUnit1.setBounds(262, 265, 70, 40);
//		getContentPane().add(jtpUnit1);
//		
//		jtpPrice = new JTextPane();
////		jtpPrice.setText(gFto.getPrice());
//		jtpPrice.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		jtpPrice.setBounds(22, 320, 270, 40);
//		getContentPane().add(jtpPrice);
//		
//		JLabel jlbWon1 = new JLabel("원");
//		jlbWon1.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		jlbWon1.setBounds(292, 320, 40, 40);
//		getContentPane().add(jlbWon1);
//		
////		System.out.println(gFto);
//		
//		JTextPane jtpUnit3 = new JTextPane();
//		jtpUnit3.setText("개");
//		jtpUnit3.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		jtpUnit3.setBounds(23, 375, 63, 40);
//		getContentPane().add(jtpUnit3);
//		
////		switch (gFto.getUnit().toString()) {
////		case "EA" : 
////			JTextPane jtpUnit3 = new JTextPane();
////			jtpUnit3.setText("개");
////			jtpUnit3.setFont(new Font("D2Coding", Font.PLAIN, 18));
////			jtpUnit3.setBounds(14, 280, 57, 40);
////			getContentPane().add(jtpUnit3);
////			break;
////		case "KG" : 
////		case "G" : 
////			JTextPane jtpUnit4 = new JTextPane();
////			jtpUnit4.setText("100g");
////			jtpUnit4.setFont(new Font("D2Coding", Font.PLAIN, 18));
////			jtpUnit4.setBounds(14, 280, 57, 40);
////			getContentPane().add(jtpUnit4);
////			break;
////		case "L" : 
////		case "ML" : 
////			JTextPane jtpUnit5 = new JTextPane();
////			jtpUnit5.setText("100ml");
////			jtpUnit5.setFont(new Font("D2Coding", Font.PLAIN, 18));
////			jtpUnit5.setBounds(14, 280, 57, 40);
////			getContentPane().add(jtpUnit5);
////			break;
////		}
//		
//		
//		JLabel jlbPer = new JLabel("당");
//		jlbPer.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		jlbPer.setBounds(98, 375, 40, 40);
//		getContentPane().add(jlbPer);
//		
//		
//		JTextPane jtpUcost1 = new JTextPane();
////		jtpUcost1.setText(pph);
//		jtpUcost1.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		jtpUcost1.setBounds(150, 375, 142, 40);
//		getContentPane().add(jtpUcost1);
//		
////		int price1 = Integer.parseInt(gFto.getPrice());
////		int quan1 = Integer.parseInt(gFto.getQuantity());
////
////		switch (gFto.getUnit()) {
////		case "EA" : 
////
////			int perPrice1 = (price1 / quan1);
////			String pph1 = String.valueOf(perPrice1);
////
////			JTextPane jtpUcost1 = new JTextPane();
////			jtpUcost1.setText(pph1);
////			jtpUcost1.setFont(new Font("D2Coding", Font.PLAIN, 18));
////			jtpUcost1.setBounds(130, 280, 142, 40);
////			getContentPane().add(jtpUcost1);
////			break;
////
////		case "ML" :
////		case "G" : 
////			
////			int perPrice2 = (price1 / quan1) * 100;
////			String pph2 = String.valueOf(perPrice2);
////
////			JTextPane jtpUcost2 = new JTextPane();
////			jtpUcost2.setText(pph2);
////			jtpUcost2.setFont(new Font("D2Coding", Font.PLAIN, 18));
////			jtpUcost2.setBounds(130, 280, 142, 40);
////			getContentPane().add(jtpUcost2);
////			break;
////			
////		case "KG" :
////		case "L" :
////			
////			int perPrice3 = (price1 / (quan1 * 100)) * 100;
////			String pph3 = String.valueOf(perPrice3);
////
////			JTextPane jtpUcost3 = new JTextPane();
////			jtpUcost3.setText(pph3);
////			jtpUcost3.setFont(new Font("D2Coding", Font.PLAIN, 18));
////			jtpUcost3.setBounds(130, 280, 142, 40);
////			getContentPane().add(jtpUcost3);
////			
////			break;
////		}
//		
//		JLabel jlbWon2 = new JLabel("원");
//		jlbWon2.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		jlbWon2.setBounds(292, 375, 40, 40);
//		getContentPane().add(jlbWon2);
//		
//		JLabel jtpPdate = new JLabel();
//		jtpPdate.setHorizontalAlignment(SwingConstants.CENTER);
//		jtpPdate.setText("입고일");
//		jtpPdate.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		jtpPdate.setBounds(12, 430, 111, 40);
//		getContentPane().add(jtpPdate);
//		
//		jtpIndate = new JTextPane();
////		jtpIndate.setText(gFto.getInput_date());
//		jtpIndate.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		jtpIndate.setBounds(130, 430, 202, 40);
//		getContentPane().add(jtpIndate);
//		
//		jtpExdate = new JTextPane();
////		jtpExdate.setText(gFto.getExpire_date());
//		jtpExdate.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		jtpExdate.setBounds(130, 485, 202, 40);
//		getContentPane().add(jtpExdate);
//		
//		JLabel jtpDdate = new JLabel();
//		jtpDdate.setHorizontalAlignment(SwingConstants.CENTER);
//		jtpDdate.setText("소비기한");
//		jtpDdate.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		jtpDdate.setBounds(12, 485, 112, 40);
//		getContentPane().add(jtpDdate);
//		
//		JButton btnConfirm = new JButton("수정하기");
//		btnConfirm.setFont(new Font("D2Coding", Font.PLAIN, 14));
//		btnConfirm.setBounds(12, 680, 100, 40);
//		getContentPane().add(btnConfirm);
//		
//		JButton btnOutDis = new JButton("출고/폐기");
//		btnOutDis.setFont(new Font("D2Coding", Font.PLAIN, 14));
//		btnOutDis.setBounds(122, 680, 100, 40);
//		getContentPane().add(btnOutDis);
//		
//		JButton btnCancel = new JButton("취소");
//		btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 14));
//		btnCancel.setBounds(232, 680, 100, 40);
//		getContentPane().add(btnCancel);
//		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setSize(370, 770);
//		setLocation(200, 200);
//		getContentPane().setLayout(null);
//		
//		JTextArea memoTa = new JTextArea();
//		memoTa.setBounds(12, 571, 320, 89);
//		getContentPane().add(memoTa);
//		
//		JLabel jtpDdate_1 = new JLabel();
//		jtpDdate_1.setHorizontalAlignment(SwingConstants.CENTER);
//		jtpDdate_1.setText("메모");
//		jtpDdate_1.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		jtpDdate_1.setBounds(122, 535, 100, 40);
//		getContentPane().add(jtpDdate_1);
//		
//		jtpstore = new JTextPane();
//		jtpstore.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		jtpstore.setBounds(25, 210, 142, 40);
//		getContentPane().add(jtpstore);
//		
//		setVisible(true);
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		
//	}
//
//
//	public static void main(String[] args) {
//		new GroceryInfo();
//
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "수정하기" :
			
			F_DTO fto = getViewData();
			System.out.println("edit" + fto);
			if(gEdit != null)
				gEdit.dispose();
			
			gEdit = new Grocery_Edit(fto);
			
			this.dispose();
			
			
			// 여기 추가해야함 진호
			break;
		case "출고/폐기" :
			
			F_DTO fto1 = getViewData();
			System.out.println("폐기" + fto1);
			if(gdo != null)
				gdo.dispose();
			
			gdo = new GroceryDisOut(fto1);
			
			this.dispose();
			
			break;
		case "닫기" : 
			this.dispose();
			break;
		}
		
	}

	private F_DTO getViewData() {
		String fname = this.groName.getText();
		String large = this.majorCla.getText();
		String middle = this.moderCla.getText();
		String small = this.minorCla.getText();
		String place = this.storPlace.getText();
		String quan = this.groQuan.getText();
		String unit = this.jtpUnit1.getText();
		String price = this.jtpPrice.getText();
		String indate = this.jtpIndate.getText();
		String exdate = this.jtpExdate.getText();
		String memo1 = this.memoTa.getText();
		String uid = this.id;
		String store = this.jtpstore.getText();
		
		F_DTO fto = new F_DTO(fname, large, middle, small, place, quan, unit,
	              price, indate, exdate, memo1, uid, store);
		
		return fto;
	}
}
