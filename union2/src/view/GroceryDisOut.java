package view;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import model.F_DTO;
import model.F_Dao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.ImageIcon;

public class GroceryDisOut extends JFrame implements ActionListener {

	private JTextField output_quantity, discard_quantity;
	String id, store, state, price, currQuan;
	JTextField expire_memo;
	
	JTextPane expireUnit, outputUnit, grocery_name, large_classific,
	          medium_classific, small_classific, storage_place, quantity,
	          unit;
	
	public GroceryDisOut() {
		getContentPane().setBackground(new Color(255, 255, 255));
			
		init();
	}

	public GroceryDisOut(F_DTO fto1) {

		F_DTO fto = fto1;
		init(fto1);
		
	}

	private void init(F_DTO fto1) {
		
		id = fto1.getUser_id();
		store = fto1.getStore_name();
		price = fto1.getPrice();
		currQuan = fto1.getQuantity();
		
		setTitle("식자재 출고/폐기");
		setFont(new Font("D2Coding", Font.PLAIN, 14));
		getContentPane().setLayout(null);
		

		//상품명부터 재고량+단위까지는 DB의 자료를 출력하는 TEXTPANE
		grocery_name = new JTextPane();
		grocery_name.setText(fto1.getGrocery_name());
		grocery_name.setBackground(new Color(250, 250, 250));
		grocery_name.setFont(new Font("D2Coding", Font.PLAIN, 16));
		grocery_name.setEditable(false);
		grocery_name.setBounds(20, 20, 300, 40);
		getContentPane().add(grocery_name);

		large_classific = new JTextPane();
		large_classific.setText(fto1.getLarge_classific());
		large_classific.setBackground(new Color(250, 250, 250));
		large_classific.setFont(new Font("D2Coding", Font.PLAIN, 16));
		large_classific.setEditable(false);
		large_classific.setBounds(20, 70, 145, 40);
		getContentPane().add(large_classific);

		medium_classific = new JTextPane();
		medium_classific.setText(fto1.getMedium_classific());
		medium_classific.setBackground(new Color(250, 250, 250));
		medium_classific.setFont(new Font("D2Coding", Font.PLAIN, 16));
		medium_classific.setEditable(false);
		medium_classific.setBounds(175, 70, 145, 40);
		getContentPane().add(medium_classific);

		small_classific = new JTextPane();
		small_classific.setText(fto1.getSmall_classific());
		small_classific.setBackground(new Color(250, 250, 250));
		small_classific.setFont(new Font("D2Coding", Font.PLAIN, 16));
		small_classific.setEditable(false);
		small_classific.setBounds(20, 120, 145, 40);
		getContentPane().add(small_classific);

		storage_place = new JTextPane();
		storage_place.setText(fto1.getStorage_place());
		storage_place.setBackground(new Color(250, 250, 250));
		storage_place.setFont(new Font("D2Coding", Font.PLAIN, 16));
		storage_place.setEditable(false);
		storage_place.setBounds(175, 120, 145, 40);
		getContentPane().add(storage_place);

		quantity = new JTextPane();
		quantity.setText(fto1.getQuantity());
		quantity.setBackground(new Color(250, 250, 250));
		quantity.setFont(new Font("D2Coding", Font.PLAIN, 16));
		quantity.setEditable(false);
		quantity.setBounds(20, 170, 230, 40);
		getContentPane().add(quantity);

		unit = new JTextPane();
		unit.setText(fto1.getUnit());
		unit.setFont(new Font("D2Coding", Font.PLAIN, 16));
		unit.setEditable(false);
		unit.setBounds(260, 170, 60, 40);
		getContentPane().add(unit);


		//입력하는 부분
		output_quantity = new JTextField();
		output_quantity.setFont(new Font("D2Coding", Font.PLAIN, 16));
		output_quantity.setColumns(10);
		output_quantity.setBounds(20, 363, 145, 40);
		getContentPane().add(output_quantity);

		discard_quantity = new JTextField();
		discard_quantity.setFont(new Font("D2Coding", Font.PLAIN, 16));
		discard_quantity.setColumns(10);
		discard_quantity.setBounds(20, 431, 145, 40);
		getContentPane().add(discard_quantity);

		JButton btnOutput = new JButton("");
		btnOutput.setIcon(new ImageIcon(GroceryDisOut.class.getResource("/image/storageList/37.png")));
		btnOutput.setSelectedIcon(new ImageIcon(GroceryDisOut.class.getResource("/image/storageList/37.png")));
		btnOutput.setBackground(new Color(73, 153, 221));
		btnOutput.setFont(new Font("D2Coding", Font.PLAIN, 16));
		btnOutput.setBounds(230, 362, 90, 40);
		getContentPane().add(btnOutput);

		JButton btnDiscard = new JButton("");
		btnDiscard.setBackground(new Color(73, 153, 221));
		btnDiscard.setFont(new Font("D2Coding", Font.PLAIN, 16));
		btnDiscard.setSelectedIcon(new ImageIcon(GroceryDisOut.class.getResource("/image/storageList/38.png")));
		btnDiscard.setIcon(new ImageIcon(GroceryDisOut.class.getResource("/image/storageList/38.png")));
		btnDiscard.setBounds(230, 430, 90, 40);
		getContentPane().add(btnDiscard);
		
		JLabel expireLbl = new JLabel("폐기사유 * 폐기시 작성해주세요 !");
		expireLbl.setBounds(20, 230, 200, 15);
		getContentPane().add(expireLbl);
		
		expire_memo = new JTextField();
		expire_memo.setColumns(10);
		expire_memo.setBounds(20, 245, 300, 92);
		getContentPane().add(expire_memo);
		
		JLabel outputLbl = new JLabel("출고량 입력");
		outputLbl.setBounds(20, 347, 75, 15);
		getContentPane().add(outputLbl);
		
		JLabel expireLbl_1_1 = new JLabel("폐기량 입력");
		expireLbl_1_1.setBounds(20, 413, 75, 15);
		getContentPane().add(expireLbl_1_1);
		
		outputUnit = new JTextPane();
		outputUnit.setFont(new Font("D2Coding", Font.PLAIN, 16));
		outputUnit.setText(fto1.getUnit());
		outputUnit.setBounds(173, 363, 49, 40);
		getContentPane().add(outputUnit);
		
		expireUnit = new JTextPane();
		expireUnit.setFont(new Font("D2Coding", Font.PLAIN, 16));
		expireUnit.setText(fto1.getUnit());
		expireUnit.setBounds(171, 431, 49, 40);
		getContentPane().add(expireUnit);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(GroceryDisOut.class.getResource("/image/\uD770\uBC30\uACBD.png")));
		lblNewLabel.setBounds(-16, -13, 373, 501);
		getContentPane().add(lblNewLabel);

		btnDiscard.addActionListener(this);
		btnOutput.addActionListener(this);
		
		setSize(360, 520);
		setLocation(200, 200);
		setVisible(true);
		
btnOutput.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("출고버튼 클릭");
				state = "출고";
				F_Dao ofao = new F_Dao();
				F_DTO ofto = getOutputData();
				int oaftcnt = ofao.insertOutput(ofto);
				System.out.println(oaftcnt);
				if (oaftcnt == 1) {
					int oaftcnt1 = ofao.minusQuan(ofto, price, currQuan);
					System.out.println(oaftcnt1);
					if (oaftcnt1 == 1) {
						JOptionPane.showMessageDialog(null, "출고되었습니다 !");
						int expense = ofao.insertExpense(ofto, store, state, price, currQuan);
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "오류");
					}
				} else {
					JOptionPane.showMessageDialog(null, "출고 데이터를 다시 확인해주세요.");
				}
			
				
			}
		});
		
		btnDiscard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("폐기버튼 클릭");
				state = "폐기";
				F_Dao efao = new F_Dao();
				F_DTO efto = getExpireData();
				int eaftcnt = efao.insertExpire(efto);
				System.out.println(eaftcnt);
				if (eaftcnt == 1) {
					int eaftcnt1 = efao.minusQuan(efto, price, currQuan);
					System.out.println(eaftcnt1);
					if (eaftcnt1 == 1) {
						JOptionPane.showMessageDialog(null, "폐기되었습니다 !");
						int expense = efao.insertExpense(efto, store, state, price, currQuan);
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "오류");
					}
				} else {
					JOptionPane.showMessageDialog(null, "폐기 데이터를 다시 확인해주세요.");
				}
				
			}
		});
		
	}

	private void init() {
		
		
		setTitle("식자재 출고/폐기");
		setFont(new Font("D2Coding", Font.PLAIN, 14));
		getContentPane().setLayout(null);
		

		//상품명부터 재고량+단위까지는 DB의 자료를 출력하는 TEXTPANE
		JTextPane grocery_name = new JTextPane();
		grocery_name.setBackground(new Color(238, 251, 255));
		grocery_name.setText("상품명");
		grocery_name.setFont(new Font("D2Coding", Font.PLAIN, 16));
		grocery_name.setBounds(20, 20, 300, 40);
		getContentPane().add(grocery_name);

		JTextPane large_classific = new JTextPane();
		large_classific.setBackground(new Color(238, 251, 255));
		large_classific.setText("대분류");
		large_classific.setFont(new Font("D2Coding", Font.PLAIN, 16));
		large_classific.setBounds(20, 70, 145, 40);
		getContentPane().add(large_classific);

		JTextPane medium_classific = new JTextPane();
		medium_classific.setBackground(new Color(238, 251, 255));
		medium_classific.setText("중분류");
		medium_classific.setFont(new Font("D2Coding", Font.PLAIN, 16));
		medium_classific.setBounds(175, 70, 145, 40);
		getContentPane().add(medium_classific);

		JTextPane small_classific = new JTextPane();
		small_classific.setBackground(new Color(238, 251, 255));
		small_classific.setText("소분류");
		small_classific.setFont(new Font("D2Coding", Font.PLAIN, 16));
		small_classific.setBounds(20, 120, 145, 40);
		getContentPane().add(small_classific);

		JTextPane storage_place = new JTextPane();
		storage_place.setBackground(new Color(238, 251, 255));
		storage_place.setText("보관장소");
		storage_place.setFont(new Font("D2Coding", Font.PLAIN, 16));
		storage_place.setBounds(175, 120, 145, 40);
		getContentPane().add(storage_place);

		JTextPane quantity = new JTextPane();
		quantity.setBackground(new Color(238, 251, 255));
		quantity.setText("재고량");
		quantity.setFont(new Font("D2Coding", Font.PLAIN, 16));
		quantity.setBounds(20, 170, 230, 40);
		getContentPane().add(quantity);

		JTextPane unit = new JTextPane();
		unit.setBackground(new Color(238, 251, 255));
		unit.setText("단위");
		unit.setFont(new Font("D2Coding", Font.PLAIN, 16));
		unit.setBounds(260, 170, 60, 40);
		getContentPane().add(unit);


		//입력하는 부분
		output_quantity = new JTextField();
		output_quantity.setFont(new Font("D2Coding", Font.PLAIN, 16));
		output_quantity.setColumns(10);
		output_quantity.setBounds(20, 363, 145, 40);
		getContentPane().add(output_quantity);

		discard_quantity = new JTextField();
		discard_quantity.setFont(new Font("D2Coding", Font.PLAIN, 16));
		discard_quantity.setColumns(10);
		discard_quantity.setBounds(20, 431, 145, 40);
		getContentPane().add(discard_quantity);

		JButton btnOutput = new JButton("");
		btnOutput.setIcon(new ImageIcon(GroceryDisOut.class.getResource("/image/storageList/37.png")));
		btnOutput.setSelectedIcon(new ImageIcon(GroceryDisOut.class.getResource("/image/storageList/37.png")));
		btnOutput.setBackground(new Color(73, 153, 221));
		btnOutput.setFont(new Font("D2Coding", Font.PLAIN, 16));
		btnOutput.setBounds(230, 362, 90, 40);
		getContentPane().add(btnOutput);

		JButton btnDiscard = new JButton("");
		btnDiscard.setSelectedIcon(new ImageIcon(GroceryDisOut.class.getResource("/image/storageList/38.png")));
		btnDiscard.setIcon(new ImageIcon(GroceryDisOut.class.getResource("/image/storageList/38.png")));
		btnDiscard.setBackground(new Color(73, 153, 221));
		btnDiscard.setFont(new Font("D2Coding", Font.PLAIN, 16));
		btnDiscard.setBounds(230, 430, 90, 40);
		getContentPane().add(btnDiscard);
		
		JLabel expireLbl = new JLabel("폐기사유 * 폐기시 작성해주세요 !");
		expireLbl.setBounds(20, 230, 200, 15);
		getContentPane().add(expireLbl);
		
		expire_memo = new JTextField();
		expire_memo.setColumns(10);
		expire_memo.setBounds(20, 245, 300, 92);
		getContentPane().add(expire_memo);
		
		JLabel outputLbl = new JLabel("출고량 입력");
		outputLbl.setBounds(20, 347, 75, 15);
		getContentPane().add(outputLbl);
		
		JLabel expireLbl_1_1 = new JLabel("폐기량 입력");
		expireLbl_1_1.setBounds(20, 413, 75, 15);
		getContentPane().add(expireLbl_1_1);
		
		JTextPane ouputUnit = new JTextPane();
		ouputUnit.setFont(new Font("D2Coding", Font.PLAIN, 16));
		ouputUnit.setBounds(173, 363, 49, 40);
		getContentPane().add(ouputUnit);
		
		JTextPane expireUnit = new JTextPane();
		expireUnit.setFont(new Font("D2Coding", Font.PLAIN, 16));
		expireUnit.setBounds(171, 431, 49, 40);
		getContentPane().add(expireUnit);
		
		
		setSize(360, 520);
		setLocation(200, 200);
		setVisible(true);
		
		

	}

	public static void main(String[] args) {
		new GroceryDisOut();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		switch(e.getActionCommand()) {
//		case "출고" :
//			System.out.println("출고버튼 클릭");
//			state = "출고";
//			F_Dao ofao = new F_Dao();
//			F_DTO ofto = getOutputData();
//			int oaftcnt = ofao.insertOutput(ofto);
//			System.out.println(oaftcnt);
//			if (oaftcnt == 1) {
//				int oaftcnt1 = ofao.minusQuan(ofto, price, currQuan);
//				System.out.println(oaftcnt1);
//				if (oaftcnt1 == 1) {
//					JOptionPane.showMessageDialog(null, "출고되었습니다 !");
//					int expense = ofao.insertExpense(ofto, this.store, state, price, currQuan);
//					this.dispose();
//				} else {
//					JOptionPane.showMessageDialog(null, "오류");
//				}
//			} else {
//				JOptionPane.showMessageDialog(null, "출고 데이터를 다시 확인해주세요.");
//			}
//			
////			groceryOutput();
//			break;
//		case "폐기" :
//			System.out.println("폐기버튼 클릭");
//			state = "폐기";
//			F_Dao efao = new F_Dao();
//			F_DTO efto = getExpireData();
//			int eaftcnt = efao.insertExpire(efto);
//			System.out.println(eaftcnt);
//			if (eaftcnt == 1) {
//				int eaftcnt1 = efao.minusQuan(efto, price, currQuan);
//				System.out.println(eaftcnt1);
//				if (eaftcnt1 == 1) {
//					JOptionPane.showMessageDialog(null, "폐기되었습니다 !");
//					int expense = efao.insertExpense(efto, store, state, price, currQuan);
//					this.dispose();
//				} else {
//					JOptionPane.showMessageDialog(null, "오류");
//				}
//			} else {
//				JOptionPane.showMessageDialog(null, "폐기 데이터를 다시 확인해주세요.");
//			}
//			break;
//		}
//		
	}
	
	private F_DTO getOutputData() {
		String fname = this.grocery_name.getText();
		String large = this.large_classific.getText();
		String middle = this.medium_classific.getText();
		String small = this.small_classific.getText();
		String place = this.storage_place.getText();
//		String quan = this.quantity.getText();
		String outputQuan = this.output_quantity.getText();
		String unit = this.unit.getText();
		String uid = this.id;
		
		F_DTO fto = new F_DTO(fname, large, middle, small, place, outputQuan, unit,
				              uid);
		
		return fto;
	}

	private F_DTO getExpireData() {
		String fname = this.grocery_name.getText();
		String large = this.large_classific.getText();
		String middle = this.medium_classific.getText();
		String small = this.small_classific.getText();
		String place = this.storage_place.getText();
//		String quan = this.quantity.getText();
		String expireQuan = this.discard_quantity.getText();
		String unit = this.unit.getText();
		String memo1 = this.expire_memo.getText();
		String uid = this.id;
		
		F_DTO fto = new F_DTO(fname, large, middle, small, place, expireQuan, unit,
	               memo1, uid);
		
		return fto;
	}
}


