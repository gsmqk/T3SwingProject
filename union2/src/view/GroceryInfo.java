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

public class GroceryInfo extends JFrame implements ActionListener {
	
	String name;
	JTextPane groName, storPlace, groQuan, jtpUnit1
	          , jtpPrice, jtpIndate, jtpExdate, memo ;
	JComboBox large, medium, small, place, store, unit1;

	
//	public GroceryInfo() {
//		init();
//	}

		public GroceryInfo(F_DTO fto) {
		F_DTO gFto = fto;
		System.out.println(fto.toString());
		
		setFont(new Font("D2Coding", Font.PLAIN, 14));
		setTitle("식자재 상세 정보");

		
		
		groName = new JTextPane();
		groName.setFont(new Font("D2Coding", Font.PLAIN, 18));
		groName.setText(gFto.getGrocery_name());
		groName.setBounds(47, 29, 324, 40);
		getContentPane().add(groName);
		
		F_Dao fao = new F_Dao();
		Vector<String> large1 = fao.getLarge();
		
		
		large = new JComboBox(large1);
		large.setBounds(47, 104, 150, 41);
		getContentPane().add(large);

		medium = new JComboBox(new String [] {"중분류"});
		medium.setBounds(221, 104, 150, 41);
		getContentPane().add(medium);
		
		small = new JComboBox(new String [] {"소분류"});
		small.setBounds(47, 181, 150, 41);
		getContentPane().add(small);
		
		large.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				String selectedItem = (String) large.getSelectedItem();
				Vector<String> mList1 = new Vector<String>();
				
				if (selectedItem != null) {
					mList1 = fao.getMiddle(selectedItem);
					System.out.println(mList1);
					medium.setModel(new DefaultComboBoxModel<>(mList1));
					medium.setSelectedItem(gFto.getMedium_classific());
				}
			}
		});
		
		medium.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				String selectedItem = (String) medium.getSelectedItem();
				Vector<String> sList1 = new Vector<String>();

				if (selectedItem != null) {
					sList1 = fao.getSmall(selectedItem);
					System.out.println(sList1);
					small.setModel(new DefaultComboBoxModel<>(sList1));
					small.setSelectedItem(gFto.getSmall_classific());
				}

			}
		});
		
		store = new JComboBox(new String [] {"실온", "냉장", "냉동"});
		store.setSelectedItem(gFto.getStorage_place());
		store.setBounds(47, 247, 150, 41);
		getContentPane().add(store);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("구매처");
		lblNewLabel_1_2_1_1.setBounds(221, 166, 78, 15);
		getContentPane().add(lblNewLabel_1_2_1_1);
		
		Vector<String> storename = new Vector<String>();
		storename = fao.getStore();
		
		place = new JComboBox(storename);
		place.setSelectedItem(gFto.getStorage_place());
		place.setBounds(221, 181, 150, 41);
		getContentPane().add(place);
		
		String [] units = {"G", "KG", "ML", "L", "EA"};
		unit1 = new JComboBox(units);
		unit1.setSelectedItem(gFto.getUnit());
		unit1.setBounds(320, 315, 51, 41);
		getContentPane().add(unit1);
		
		groQuan= new JTextPane();
		groQuan.setText(gFto.getQuantity());
		groQuan.setFont(new Font("D2Coding", Font.PLAIN, 18));
		groQuan.setBounds(47, 315, 258, 40);
		getContentPane().add(groQuan);
		
		jtpPrice = new JTextPane();
		jtpPrice.setText(gFto.getPrice());
		jtpPrice.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpPrice.setBounds(47, 380, 300, 40);
		getContentPane().add(jtpPrice);
		
		JLabel jlbWon1 = new JLabel("원");
		jlbWon1.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jlbWon1.setBounds(348, 380, 40, 40);
		getContentPane().add(jlbWon1);
		
		switch (gFto.getUnit().toString()) {
		case "EA" : 
			JTextPane jtpUnit3 = new JTextPane();
			jtpUnit3.setText("개");
			jtpUnit3.setFont(new Font("D2Coding", Font.PLAIN, 18));
			jtpUnit3.setBounds(47, 446, 70, 40);
			getContentPane().add(jtpUnit3);
			break;
		case "KG" : 
		case "G" : 
			JTextPane jtpUnit4 = new JTextPane();
			jtpUnit4.setText("100g");
			jtpUnit4.setFont(new Font("D2Coding", Font.PLAIN, 18));
			jtpUnit4.setBounds(47, 446, 70, 40);
			getContentPane().add(jtpUnit4);
			break;
		case "L" : 
		case "ML" : 
			JTextPane jtpUnit5 = new JTextPane();
			jtpUnit5.setText("100ml");
			jtpUnit5.setFont(new Font("D2Coding", Font.PLAIN, 18));
			jtpUnit5.setBounds(47, 446, 70, 40);
			getContentPane().add(jtpUnit5);
			break;
		}
		
		JLabel jlbPer = new JLabel("당");
		jlbPer.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jlbPer.setBounds(129, 446, 40, 40);
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
			jtpUcost1.setBounds(197, 446, 150, 40);
			getContentPane().add(jtpUcost1);
			break;

		case "ML" :
		case "G" : 
			
			int perPrice2 = (price1 / quan1) * 100;
			String pph2 = String.valueOf(perPrice2);

			JTextPane jtpUcost2 = new JTextPane();
			jtpUcost2.setText(pph2);
			jtpUcost2.setFont(new Font("D2Coding", Font.PLAIN, 18));
			jtpUcost2.setBounds(197, 446, 150, 40);
			getContentPane().add(jtpUcost2);
			break;
			
		case "KG" :
		case "L" :
			
			int perPrice3 = (price1 / (quan1 * 100)) * 100;
			String pph3 = String.valueOf(perPrice3);

			JTextPane jtpUcost3 = new JTextPane();
			jtpUcost3.setText(pph3);
			jtpUcost3.setFont(new Font("D2Coding", Font.PLAIN, 18));
			jtpUcost3.setBounds(197, 446, 150, 40);
			getContentPane().add(jtpUcost3);
			
			break;
		}
		
		JLabel jlbWon2 = new JLabel("원");
		jlbWon2.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jlbWon2.setBounds(348, 446, 40, 40);
		getContentPane().add(jlbWon2);
		
		jtpIndate = new JTextPane();
		jtpIndate.setText(gFto.getInput_date());
		jtpIndate.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpIndate.setBounds(47, 510, 155, 40);
		getContentPane().add(jtpIndate);
		
		jtpExdate = new JTextPane();
		jtpExdate.setText(gFto.getExpire_date());
		jtpExdate.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jtpExdate.setBounds(232, 510, 155, 40);;
		getContentPane().add(jtpExdate);
		
		memo = new JTextPane();
		memo.setText(gFto.getMemo());
		memo.setFont(new Font("D2Coding", Font.PLAIN, 18));
		memo.setBounds(47, 585, 340, 80);
		getContentPane().add(memo);
		
		JButton btnConfirm = new JButton("수정완료");
		btnConfirm.setFont(new Font("D2Coding", Font.PLAIN, 14));
		btnConfirm.setBounds(47, 675, 100, 40);
		getContentPane().add(btnConfirm);
		
		JButton btnOutDis = new JButton("출고/폐기");
		btnOutDis.setFont(new Font("D2Coding", Font.PLAIN, 14));
		btnOutDis.setBounds(167, 675, 100, 40);
		getContentPane().add(btnOutDis);
		
		JButton btnCancel = new JButton("닫기");
		btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 14));
		btnCancel.setBounds(286, 675, 100, 40);
		getContentPane().add(btnCancel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(447, 780);
		setLocation(200, 200);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("식자재 이름");
		lblNewLabel.setBounds(47, 10, 78, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("대분류");
		lblNewLabel_1.setBounds(47, 79, 78, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("중분류");
		lblNewLabel_1_1.setBounds(221, 79, 78, 15);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("소분류");
		lblNewLabel_1_2.setBounds(47, 166, 78, 15);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("보관");
		lblNewLabel_1_2_1.setBounds(47, 232, 78, 15);
		getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("식자재 수량/중량");
		lblNewLabel_1_2_2.setBounds(47, 298, 122, 15);
		getContentPane().add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("식자재 가격");
		lblNewLabel_1_2_3.setBounds(47, 365, 78, 15);
		getContentPane().add(lblNewLabel_1_2_3);
		
		JLabel lblNewLabel_1_2_3_1 = new JLabel("입고일");
		lblNewLabel_1_2_3_1.setBounds(47, 496, 78, 15);
		getContentPane().add(lblNewLabel_1_2_3_1);
		
		JLabel lblNewLabel_1_2_3_1_1 = new JLabel("유통기한");
		lblNewLabel_1_2_3_1_1.setBounds(232, 496, 78, 15);
		getContentPane().add(lblNewLabel_1_2_3_1_1);
		
		JLabel lblNewLabel_1_2_3_1_2 = new JLabel("메모");
		lblNewLabel_1_2_3_1_2.setBounds(47, 570, 78, 15);
		getContentPane().add(lblNewLabel_1_2_3_1_2);
		
		
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		btnConfirm.addActionListener(this);
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
//		groName.setText("");
//		groName.setBounds(47, 29, 324, 40);
//		getContentPane().add(groName);
//		
//		JTextPane groQuan= new JTextPane();
//		groQuan.setText("식자재 수량/중량");
//		groQuan.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		groQuan.setBounds(47, 315, 258, 40);
//		getContentPane().add(groQuan);
//		
//		JTextPane jtpPrice = new JTextPane();
//		jtpPrice.setText("식자재 가격");
//		jtpPrice.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		jtpPrice.setBounds(47, 380, 300, 40);
//		getContentPane().add(jtpPrice);
//		
//		JLabel jlbWon1 = new JLabel("원");
//		jlbWon1.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		jlbWon1.setBounds(348, 380, 40, 40);
//		getContentPane().add(jlbWon1);
//		
//		JTextPane jtpUnit2 = new JTextPane();
//		jtpUnit2.setText("단위");
//		jtpUnit2.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		jtpUnit2.setBounds(47, 446, 70, 40);
//		getContentPane().add(jtpUnit2);
//		
//		JLabel jlbPer = new JLabel("당");
//		jlbPer.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		jlbPer.setBounds(129, 446, 40, 40);
//		getContentPane().add(jlbPer);
//		
//		JTextPane jtpUcost = new JTextPane();
//		jtpUcost.setText("단가");
//		jtpUcost.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		jtpUcost.setBounds(197, 446, 150, 40);
//		getContentPane().add(jtpUcost);
//		
//		JLabel jlbWon2 = new JLabel("원");
//		jlbWon2.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		jlbWon2.setBounds(348, 446, 40, 40);
//		getContentPane().add(jlbWon2);
//		
//		JTextPane jtpEdate = new JTextPane();
//		jtpEdate.setText("유통기한");
//		jtpEdate.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		jtpEdate.setBounds(232, 510, 155, 40);
//		getContentPane().add(jtpEdate);
//		
//		JTextPane jtpIndate = new JTextPane();
//		jtpIndate.setText("입고일");
//		jtpIndate.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		jtpIndate.setBounds(47, 510, 155, 40);
//		getContentPane().add(jtpIndate);
//		
//		JTextPane jtpDdate = new JTextPane();
//		jtpDdate.setText("메모");
//		jtpDdate.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		jtpDdate.setBounds(47, 585, 340, 80);
//		getContentPane().add(jtpDdate);
//		
//		JButton btnConfirm = new JButton("수정완료");
//		btnConfirm.setFont(new Font("D2Coding", Font.PLAIN, 14));
//		btnConfirm.setBounds(47, 675, 100, 40);
//		getContentPane().add(btnConfirm);
//		
//		JButton btnOutDis = new JButton("출고/폐기");
//		btnOutDis.setFont(new Font("D2Coding", Font.PLAIN, 14));
//		btnOutDis.setBounds(167, 675, 100, 40);
//		getContentPane().add(btnOutDis);
//		
//		JButton btnCancel = new JButton("닫기");
//		btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 14));
//		btnCancel.setBounds(286, 675, 100, 40);
//		getContentPane().add(btnCancel);
//		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setSize(447, 780);
//		setLocation(200, 200);
//		getContentPane().setLayout(null);
//		
//		JLabel lblNewLabel = new JLabel("식자재 이름");
//		lblNewLabel.setBounds(47, 10, 78, 15);
//		getContentPane().add(lblNewLabel);
//		
//		JLabel lblNewLabel_1 = new JLabel("대분류");
//		lblNewLabel_1.setBounds(47, 79, 78, 15);
//		getContentPane().add(lblNewLabel_1);
//		
//		JLabel lblNewLabel_1_1 = new JLabel("중분류");
//		lblNewLabel_1_1.setBounds(221, 79, 78, 15);
//		getContentPane().add(lblNewLabel_1_1);
//		
//		JLabel lblNewLabel_1_2 = new JLabel("소분류");
//		lblNewLabel_1_2.setBounds(47, 166, 78, 15);
//		getContentPane().add(lblNewLabel_1_2);
//		
//		JLabel lblNewLabel_1_2_1 = new JLabel("보관");
//		lblNewLabel_1_2_1.setBounds(47, 232, 78, 15);
//		getContentPane().add(lblNewLabel_1_2_1);
//		
//		JLabel lblNewLabel_1_2_2 = new JLabel("식자재 수량/중량");
//		lblNewLabel_1_2_2.setBounds(47, 298, 122, 15);
//		getContentPane().add(lblNewLabel_1_2_2);
//		
//		JLabel lblNewLabel_1_2_3 = new JLabel("식자재 가격");
//		lblNewLabel_1_2_3.setBounds(47, 365, 78, 15);
//		getContentPane().add(lblNewLabel_1_2_3);
//		
//		JLabel lblNewLabel_1_2_3_1 = new JLabel("입고일");
//		lblNewLabel_1_2_3_1.setBounds(47, 496, 78, 15);
//		getContentPane().add(lblNewLabel_1_2_3_1);
//		
//		JLabel lblNewLabel_1_2_3_1_1 = new JLabel("유통기한");
//		lblNewLabel_1_2_3_1_1.setBounds(232, 496, 78, 15);
//		getContentPane().add(lblNewLabel_1_2_3_1_1);
//		
//		JLabel lblNewLabel_1_2_3_1_2 = new JLabel("메모");
//		lblNewLabel_1_2_3_1_2.setBounds(47, 570, 78, 15);
//		getContentPane().add(lblNewLabel_1_2_3_1_2);
//		
//		JComboBox large = new JComboBox();
//		large.setBounds(47, 104, 150, 41);
//		getContentPane().add(large);
//		
//		JComboBox medium = new JComboBox();
//		medium.setBounds(47, 181, 150, 41);
//		getContentPane().add(medium);
//		
//		JComboBox small = new JComboBox();
//		small.setBounds(221, 104, 150, 41);
//		getContentPane().add(small);
//		
//		JComboBox store = new JComboBox();
//		store.setBounds(47, 247, 150, 41);
//		getContentPane().add(store);
//		
//		JLabel lblNewLabel_1_2_1_1 = new JLabel("구매처");
//		lblNewLabel_1_2_1_1.setBounds(221, 166, 78, 15);
//		getContentPane().add(lblNewLabel_1_2_1_1);
//		
//		JComboBox place = new JComboBox();
//		place.setBounds(221, 181, 150, 41);
//		getContentPane().add(place);
//		
//		JComboBox store_1 = new JComboBox();
//		store_1.setBounds(320, 315, 51, 41);
//		getContentPane().add(store_1);
//		
//		setVisible(true);
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		
//	}


//	public static void main(String[] args) {
//		new GroceryInfo();
//
//	}

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
				aftcnt = fao.updateGrocery(fto);
				if(aftcnt > 0)
					msg = "수정되었습니다.";
				else
					msg = "수정되지 않았습니다.";			
				} else {
					msg = "취소하셨습니다.";
				}
				JOptionPane.showMessageDialog(null, 
						msg);
			break;
		case "닫기" : 
			this.dispose();
			break;
		}
		
	}

	private F_DTO getViewData() {
		String fname = groName.getText();
		String large2 = (String) large.getSelectedItem();
		String medium2 = (String) medium.getSelectedItem();
		String small2 = (String) small.getSelectedItem();
		String place2 = (String) place.getSelectedItem();
		String store2 = (String) store.getSelectedItem();
		String quan = groQuan.getText();
		String unit = (String) unit1.getSelectedItem();
		String price = jtpPrice.getText();
		String indate = jtpIndate.getText();
		String exdate = jtpExdate.getText();
		String memo1 = memo.getText();
		
		
		
		F_DTO fto = new F_DTO(fname, large2, medium2, small2, place2, store2,
				             quan, unit, price, indate, exdate, memo1);
		
		return fto;
	}
}
