package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.F_DTO;
import model.F_Dao;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Grocery_Edit extends JFrame {
	
	JTextField  groName, inQuan, price, memo;
	JButton btnInput, btnCancel;
	
	JComboBox large_classific, middle_classific, small_classific, storage_place, unit,
	          store;
	UtilDateModel model, model1;
	String id, preGroName;
	MainTable01 mt01 = null;
	StorageList slist = null;
	
	public Grocery_Edit(F_DTO fto) {
		getContentPane().setBackground(new Color(255, 255, 255));
		F_DTO ffto = fto;
		init(ffto);
	}
	
//	public Grocery_Edit() {
//		init();
//	}
	
	private void init(F_DTO fto) {
		
		id = fto.getUser_id();
		
		setFont(new Font("D2Coding", Font.PLAIN, 14));
		setTitle("식자재 수정");
		getContentPane().setLayout(null);

		//카테고리
		JLabel jlbCat = new JLabel("카테고리");
		jlbCat.setHorizontalAlignment(SwingConstants.CENTER);
		jlbCat.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 15));
		jlbCat.setBounds(12, 10, 64, 24);
		getContentPane().add(jlbCat);

		F_Dao fao = new F_Dao();
		Vector<String> large = fao.getLarge();
		
		String[] arrayLarge = large.toArray(new String[large.size()]);
		
		large_classific = new JComboBox (arrayLarge);
		large_classific.setBackground(new Color(250, 250, 250));
		large_classific.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		large_classific.setToolTipText("대분류");
		large_classific.setSelectedItem(fto.getLarge_classific());
		large_classific.setBounds(12, 44, 155, 40);
		getContentPane().add(large_classific);
		
//		String selectedItem = (String) large_classific.getSelectedItem();
		String selectedItem = fto.getLarge_classific();
		Vector<String> mList1 = new Vector<String>();
		mList1 = fao.getMiddle(selectedItem);
		String[] arrayMedium = mList1.toArray(new String[mList1.size()]);
		
		middle_classific = new JComboBox(arrayMedium);
		middle_classific.setBackground(new Color(250, 250, 250));
		middle_classific.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		middle_classific.setToolTipText("중분류");
		middle_classific.setSelectedItem(fto.getMedium_classific());
		middle_classific.setBounds(177, 44, 155, 40);
		getContentPane().add(middle_classific);

		String selectedItem2 = fto.getMedium_classific();
		Vector<String> sList1 = new Vector<String>();
		System.out.println(fto.getMedium_classific());
		sList1 = fao.getSmall(fto.getMedium_classific());
		String[] arraySmall = sList1.toArray(new String[sList1.size()]);
		
		small_classific = new JComboBox(arraySmall);
		small_classific.setBackground(new Color(250, 250, 250));
		small_classific.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		small_classific.setToolTipText("소분류");
		small_classific.setSelectedItem(fto.getSmall_classific());
		small_classific.setBounds(12, 94, 155, 40);
		getContentPane().add(small_classific);

		large_classific.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				String selectedItem = (String) large_classific.getSelectedItem();
				Vector<String> mList1 = new Vector<String>();
				
				if (selectedItem != null) {
					mList1 = fao.getMiddle(selectedItem);
					System.out.println(mList1);
					String[] arrayMedium = mList1.toArray(new String[mList1.size()]);
					middle_classific.setModel(new DefaultComboBoxModel<>(arrayMedium));
					middle_classific.setSelectedItem(fto.getMedium_classific());
				}
			}
				
		});
		
		middle_classific.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				String selectedItem = (String) middle_classific.getSelectedItem();
				Vector<String> sList1 = new Vector<String>();
				
				if (selectedItem != null) {
					sList1 = fao.getSmall(selectedItem);
					System.out.println(sList1);
					small_classific.setModel(new DefaultComboBoxModel<>(sList1));
					small_classific.setSelectedItem(fto.getSmall_classific());
				}
				
			}
		});
		
		
		
		storage_place = new JComboBox(new String [] {"실온", "냉장", "냉동"});
		storage_place.setBackground(new Color(250, 250, 250));
		storage_place.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		storage_place.setToolTipText("보관장소");
		storage_place.setSelectedItem(fto.getStorage_place());
		storage_place.setBounds(177, 94, 155, 40);
		getContentPane().add(storage_place);

		//세부정보
		JLabel jlbDet = new JLabel("세부정보");
		jlbDet.setHorizontalAlignment(SwingConstants.CENTER);
		jlbDet.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 15));
		jlbDet.setBounds(12, 149, 64, 24);
		getContentPane().add(jlbDet);

		//식자재이름
		JLabel jlbName = new JLabel("이름");
		jlbName.setHorizontalAlignment(SwingConstants.CENTER);
		jlbName.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 15));
		jlbName.setBounds(12, 183, 50, 40);
		getContentPane().add(jlbName);
		
		groName        = new JTextField(20);
		groName.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		groName.setBounds(82, 183, 250, 40);
		groName.setText(fto.getGrocery_name());
		preGroName = fto.getGrocery_name();
		System.out.println(fto.getGrocery_name());
		getContentPane().add(groName);
		groName.setColumns(10);

		//식자재수량
		JLabel jlbQuan = new JLabel("수량");
		jlbQuan.setHorizontalAlignment(SwingConstants.CENTER);
		jlbQuan.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 15));
		jlbQuan.setBounds(12, 234, 50, 40);
		getContentPane().add(jlbQuan);

		inQuan         = new JTextField(20);
		inQuan.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		inQuan.setColumns(10);
		inQuan.setText(fto.getQuantity());
		inQuan.setBounds(82, 234, 195, 40);
		getContentPane().add(inQuan);
		
		String [] units = {"G", "KG", "ML", "L", "EA"};
		unit = new JComboBox(units);
		unit.setBackground(new Color(250, 250, 250));
		unit.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		unit.setSelectedItem(fto.getUnit());
		unit.setBounds(282, 234, 50, 39);
		getContentPane().add(unit);

		//식자재가격
		JLabel jlbPri  = new JLabel("가격");
		jlbPri.setHorizontalAlignment(SwingConstants.CENTER);
		jlbPri.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 15));
		jlbPri.setBounds(12, 284, 50, 40);
		getContentPane().add(jlbPri);

		price          = new JTextField(20);
		price.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		price.setColumns(10);
		price.setText(fto.getPrice());
		price.setBounds(82, 284, 195, 40);
		getContentPane().add(price);

		JLabel jlbWon  = new JLabel("원");
		jlbWon.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 18));
		jlbWon.setBounds(284, 284, 40, 40);
		getContentPane().add(jlbWon);

		//구매처
		JLabel jlbSto  = new JLabel("구매처");
		jlbSto.setHorizontalAlignment(SwingConstants.CENTER);
		jlbSto.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 15));
		jlbSto.setBounds(12, 341, 64, 40);
		getContentPane().add(jlbSto);

		Vector<String> storename = new Vector<String>();
		storename = fao.getStore();
		
		store = new JComboBox(storename);
		store.setBackground(new Color(250, 250, 250));
		store.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		store.setSelectedItem(fto.getStore_name());
		System.out.println(fto.getStore_name());
		store.setBounds(82, 339, 250, 45);
		getContentPane().add(store);

		//입고일
		JLabel jlbInpD  = new JLabel("입고일");
		jlbInpD.setHorizontalAlignment(SwingConstants.CENTER);
		jlbInpD.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 15));
		jlbInpD.setBounds(12, 394, 69, 40);
		getContentPane().add(jlbInpD);
		
		model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		datePicker.setBackground(new Color(255, 255, 255));
		int dateY1 = Integer.parseInt(fto.getInput_date().substring(0, 4));
		int dateM1 = Integer.parseInt(fto.getInput_date().substring(5, 7)) - 1;
		int dateD1 = Integer.parseInt(fto.getInput_date().substring(8));
		model.setDate(dateY1, dateM1, dateD1);
		model.setSelected(true);
		
		getContentPane().add(datePicker);
		datePicker.setBounds(82, 405, 250, 40);

		//소비기한
		JLabel jlbExpD  = new JLabel("소비기한");
		jlbExpD.setHorizontalAlignment(SwingConstants.CENTER);
		jlbExpD.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 15));
		jlbExpD.setBounds(12, 444, 69, 40);
		getContentPane().add(jlbExpD);
		
		model1 = new UtilDateModel();
		JDatePanelImpl datePanel1 = new JDatePanelImpl(model1);
		JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1);
		datePicker1.setBackground(new Color(255, 255, 255));
		int dateY2 = Integer.parseInt(fto.getExpire_date().substring(0, 4));
		int dateM2 = Integer.parseInt(fto.getExpire_date().substring(5, 7)) - 1;
		int dateD2 = Integer.parseInt(fto.getExpire_date().substring(8));
		model1.setDate(dateY2, dateM2, dateD2);
		model1.setSelected(true);
		
		getContentPane().add(datePicker1);
		datePicker1.setBounds(82, 455, 250, 40);
		
		//입력/취소버튼
		btnInput  = new JButton("");
		btnInput.setBackground(new Color(73, 153, 221));
		btnInput.setIcon(new ImageIcon(Grocery_Edit.class.getResource("/image/storageList/35.png")));
		btnInput.setFont(new Font("D2Coding", Font.PLAIN, 18));
		btnInput.setBounds(70, 659, 90, 40);
		getContentPane().add(btnInput);

		JButton btnCancel = new JButton("");
		btnCancel.setBackground(new Color(73, 153, 221));
		btnCancel.setIcon(new ImageIcon(Grocery_Edit.class.getResource("/image/storageList/36.png")));
		btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 18));
		btnCancel.setBounds(187, 659, 90, 40);
		getContentPane().add(btnCancel);
		
		JLabel jlbExpD_1 = new JLabel("메모");
		jlbExpD_1.setHorizontalAlignment(SwingConstants.CENTER);
		jlbExpD_1.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 15));
		jlbExpD_1.setBounds(12, 505, 69, 40);
		getContentPane().add(jlbExpD_1);
		
		memo = new JTextField(10);
		memo.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		memo.setText(fto.getMemo());
		memo.setBounds(82, 512, 250, 123);
		getContentPane().add(memo);

		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnInput.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("수정버튼 클릭");
     			updateGrocery();
				
			}
		});

		setSize(370, 765);
		setLocation(200, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}

//@Override
//public void actionPerformed(ActionEvent e) {
//	switch(e.getActionCommand()) {
//	case "수정" :
//		System.out.println("수정버튼 클릭");
//		updateGrocery();
//		
//		break;
//	case "닫기" :
//		this.dispose();
//		break;
//	}
//		
//}

private void updateGrocery() {
	F_Dao fao = new F_Dao();
	F_DTO fto = getGroceryData();
	String preGroName = this.preGroName;
	int aftcnt = fao.updateGrocery(fto, preGroName);
	
	this.dispose();
	
	
}

private F_DTO getGroceryData() {
	String fname = this.groName.getText();
	String large = (String) this.large_classific.getSelectedItem();
	String medium = (String) this.middle_classific.getSelectedItem();
	String small = (String) this.small_classific.getSelectedItem();
	String place = (String) this.storage_place.getSelectedItem();
	String quan = this.inQuan.getText();
	String unit = (String) this.unit.getSelectedItem();
	String price = this.price.getText();
	String indate = this.model.getYear() + "/" + (this.model.getMonth() + 1) + "/" + this.model.getDay();
	String exdate = this.model1.getYear() + "/" + (this.model1.getMonth() + 1) + "/" + this.model1.getDay();
	String memo = this.memo.getText();
	String uid = this.id;
	String store = (String) this.store.getSelectedItem();

	
	F_DTO fto = new F_DTO(fname, large, medium, small, place, quan, unit,
            price, indate, exdate, memo, uid, store);
	return fto;
}
}