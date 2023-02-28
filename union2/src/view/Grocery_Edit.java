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
import javax.swing.JTextField;

import model.F_DTO;
import model.F_Dao;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class Grocery_Edit extends JFrame implements ActionListener {
	
	JTextField  groName, inQuan, price, memo;
	JButton btnInput, btnCancel;
	
	JComboBox large_classific, middle_classific, small_classific, storage_place, unit,
	          store;
	UtilDateModel model, model1;
	String id;
	
	public Grocery_Edit(F_DTO fto) {
		F_DTO ffto = fto;
		init(ffto);
	}
	
//	public Grocery_Edit() {
//		init();
//	}
	
	private void init(F_DTO fto) {
		setFont(new Font("D2Coding", Font.PLAIN, 14));
		setTitle("식자재 수정");
		getContentPane().setLayout(null);

		//카테고리
		JLabel jlbCat = new JLabel("카테고리");
		jlbCat.setFont(new Font("D2Coding", Font.PLAIN, 16));
		jlbCat.setBounds(12, 10, 64, 24);
		getContentPane().add(jlbCat);

		F_Dao fao = new F_Dao();
		Vector<String> large = fao.getLarge();
		
		large_classific = new JComboBox (large);
		large_classific.setToolTipText("대분류만 정해주세요");
		large_classific.setSelectedItem(fto.getLarge_classific());
		large_classific.setBounds(12, 44, 155, 40);
		getContentPane().add(large_classific);
		
		
		middle_classific = new JComboBox(new String [] {"중분류"});
		middle_classific.setToolTipText("중분류");
		middle_classific.setBounds(177, 44, 155, 40);
		getContentPane().add(middle_classific);

		small_classific = new JComboBox(new String [] {"소분류"});
		small_classific.setToolTipText("소분류");
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
					middle_classific.setModel(new DefaultComboBoxModel<>(mList1));
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
		storage_place.setToolTipText("보관장소");
		storage_place.setSelectedItem(fto.getStorage_place());
		storage_place.setBounds(177, 94, 155, 40);
		getContentPane().add(storage_place);

		//세부정보
		JLabel jlbDet = new JLabel("세부정보");
		jlbDet.setFont(new Font("D2Coding", Font.PLAIN, 16));
		jlbDet.setBounds(12, 149, 64, 24);
		getContentPane().add(jlbDet);

		//식자재이름
		JLabel jlbName = new JLabel("이름");
		jlbName.setFont(new Font("D2Coding", Font.PLAIN, 16));
		jlbName.setBounds(12, 183, 50, 40);
		getContentPane().add(jlbName);
		
		groName        = new JTextField(20);
		groName.setBounds(82, 183, 250, 40);
		groName.setText(fto.getGrocery_name());
		System.out.println(fto.getGrocery_name());
		getContentPane().add(groName);
		groName.setColumns(10);

		//식자재수량
		JLabel jlbQuan = new JLabel("수량");
		jlbQuan.setFont(new Font("D2Coding", Font.PLAIN, 16));
		jlbQuan.setBounds(12, 234, 50, 40);
		getContentPane().add(jlbQuan);

		inQuan         = new JTextField(20);
		inQuan.setColumns(10);
		inQuan.setText(fto.getQuantity());
		inQuan.setBounds(82, 234, 195, 40);
		getContentPane().add(inQuan);
		
		String [] units = {"G", "KG", "ML", "L", "EA"};
		unit = new JComboBox(units);
		unit.setSelectedItem(fto.getUnit());
		unit.setBounds(282, 234, 50, 39);
		getContentPane().add(unit);

		//식자재가격
		JLabel jlbPri  = new JLabel("가격");
		jlbPri.setFont(new Font("D2Coding", Font.PLAIN, 16));
		jlbPri.setBounds(12, 284, 50, 40);
		getContentPane().add(jlbPri);

		price          = new JTextField(20);
		price.setColumns(10);
		price.setText(fto.getPrice());
		price.setBounds(82, 284, 195, 40);
		getContentPane().add(price);

		JLabel jlbWon  = new JLabel("원");
		jlbWon.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jlbWon.setBounds(284, 284, 40, 40);
		getContentPane().add(jlbWon);

		//구매처
		JLabel jlbSto  = new JLabel("구매처");
		jlbSto.setFont(new Font("D2Coding", Font.PLAIN, 16));
		jlbSto.setBounds(12, 334, 64, 40);
		getContentPane().add(jlbSto);

		Vector<String> storename = new Vector<String>();
		storename = fao.getStore();
		
		store = new JComboBox(storename);
		store.setSelectedItem(fto.getStorage_place());
		// info에서 구매처 표시하게 만들어야함 
		///////////////////////////////////////////////////
		store.setBounds(82, 334, 250, 40);
		getContentPane().add(store);

		//입고일
		JLabel jlbInpD  = new JLabel("입고일");
		jlbInpD.setFont(new Font("D2Coding", Font.PLAIN, 16));
		jlbInpD.setBounds(12, 384, 64, 40);
		getContentPane().add(jlbInpD);
		
		model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		int dateY1 = Integer.parseInt(fto.getInput_date().substring(0, 4));
		int dateM1 = Integer.parseInt(fto.getInput_date().substring(5, 7));
		int dateD1 = Integer.parseInt(fto.getInput_date().substring(8));
		model.setDate(dateY1, dateM1, dateD1);
		model.setSelected(true);
		
		getContentPane().add(datePicker);
		datePicker.setBounds(82, 390, 250, 40);

		//소비기한
		JLabel jlbExpD  = new JLabel("소비기한");
		jlbExpD.setFont(new Font("D2Coding", Font.PLAIN, 16));
		jlbExpD.setBounds(12, 434, 64, 40);
		getContentPane().add(jlbExpD);
		
		model1 = new UtilDateModel();
		JDatePanelImpl datePanel1 = new JDatePanelImpl(model1);
		JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1);
		int dateY2 = Integer.parseInt(fto.getExpire_date().substring(0, 4));
		int dateM2 = Integer.parseInt(fto.getExpire_date().substring(5, 7));
		int dateD2 = Integer.parseInt(fto.getExpire_date().substring(8));
		model1.setDate(dateY2, dateM2, dateD2);
		model1.setSelected(true);
		
		getContentPane().add(datePicker1);
		datePicker1.setBounds(82, 440, 250, 40);
		
		//입력/취소버튼
		btnInput  = new JButton("수정");
		btnInput.setFont(new Font("D2Coding", Font.PLAIN, 18));
		btnInput.setBounds(70, 610, 90, 40);
		getContentPane().add(btnInput);

		JButton btnCancel = new JButton("닫기");
		btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 18));
		btnCancel.setBounds(182, 610, 90, 40);
		getContentPane().add(btnCancel);
		
		JLabel jlbExpD_1 = new JLabel("메모");
		jlbExpD_1.setFont(new Font("D2Coding", Font.PLAIN, 16));
		jlbExpD_1.setBounds(12, 484, 64, 40);
		getContentPane().add(jlbExpD_1);
		
		memo = new JTextField(10);
		memo.setText(fto.getMemo());
		memo.setBounds(82, 490, 250, 106);
		getContentPane().add(memo);

		

		setSize(370, 710);
		setLocation(200, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}

@Override
public void actionPerformed(ActionEvent e) {
	switch(e.getActionCommand()) {
		
	}
		
}

//	public static void main(String[] args) {
//		new Grocery_Edit();
//	}
}
