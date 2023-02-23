package T3Project.view;


import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.sourceforge.jdatepicker.JDatePicker;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class GrocerySearch extends JFrame {
	
	//component
	private JTextField  groName, inQuan, price, store;
	
	//constructor
	//defaultCons
	public GrocerySearch() {
		init();
		
	}

	private void init() {
		setFont(new Font("D2Coding", Font.PLAIN, 14));
		setTitle("보관중인 식자재 검색");
		

		//카테고리
		JLabel jlbCat = new JLabel("카테고리");
		jlbCat.setFont(new Font("D2Coding", Font.PLAIN, 16));
		jlbCat.setBounds(12, 10, 64, 24);
		getContentPane().add(jlbCat);
		
		JComboBox large_classific = new JComboBox(new String [] {"대분류"});
		large_classific.setToolTipText("대분류");
		large_classific.setBounds(12, 44, 155, 40);
		getContentPane().add(large_classific);
		
		JComboBox middle_classific = new JComboBox(new String [] {"중분류"});
		middle_classific.setToolTipText("중분류");
		middle_classific.setBounds(177, 44, 155, 40);
		getContentPane().add(middle_classific);
		
		JComboBox small_classific = new JComboBox(new String [] {"소분류"});
		small_classific.setToolTipText("소분류");
		small_classific.setBounds(12, 94, 155, 40);
		getContentPane().add(small_classific);
		
		JComboBox storage_place = new JComboBox(new String [] {"실온", "냉장", "냉동"});
		storage_place.setToolTipText("보관장소");
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
		groName.setBounds(82, 183, 260, 40);
		getContentPane().add(groName);
		groName.setColumns(10);

		//식자재수량
		JLabel jlbQuan = new JLabel("수량");
		jlbQuan.setFont(new Font("D2Coding", Font.PLAIN, 16));
		jlbQuan.setBounds(12, 234, 50, 40);
		getContentPane().add(jlbQuan);

		inQuan         = new JTextField(20);
		inQuan.setColumns(10);
		inQuan.setBounds(82, 234, 195, 40);
		getContentPane().add(inQuan);
		
		String [] units = {"g", "Kg", "ml", "L"};
		JComboBox unit = new JComboBox(units);
		unit.setBounds(282, 234, 50, 39);
		getContentPane().add(unit);

		//식자재가격
		JLabel jlbPri  = new JLabel("가격");
		jlbPri.setFont(new Font("D2Coding", Font.PLAIN, 16));
		jlbPri.setBounds(12, 284, 50, 40);
		getContentPane().add(jlbPri);

		price          = new JTextField(20);
		price.setColumns(10);
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

		store          = new JTextField(20);
		store.setColumns(10);
		store.setBounds(82, 334, 260, 40);
		getContentPane().add(store);

		//입고일
		JLabel jlbInpD  = new JLabel("입고일");
		jlbInpD.setFont(new Font("D2Coding", Font.PLAIN, 16));
		jlbInpD.setBounds(12, 384, 64, 40);
		getContentPane().add(jlbInpD);
		
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		this.add(datePicker);
		datePicker.setBounds(82, 390, 250, 40);

		//소비기한
		JLabel jlbExpD  = new JLabel("소비기한");
		jlbExpD.setFont(new Font("D2Coding", Font.PLAIN, 16));
		jlbExpD.setBounds(12, 434, 64, 40);
		getContentPane().add(jlbExpD);
		
		UtilDateModel model1 = new UtilDateModel();
		JDatePanelImpl datePanel1 = new JDatePanelImpl(model1);
		JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1);
		this.add(datePicker1);
		datePicker1.setBounds(82, 440, 250, 40);
		
		//입력/취소버튼
		JButton	btnInput  = new JButton("검색");
		btnInput.setFont(new Font("D2Coding", Font.PLAIN, 18));
		btnInput.setBounds(70, 488, 90, 40);
		getContentPane().add(btnInput);

		JButton btnCancel = new JButton("취소");
		btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 18));
		btnCancel.setBounds(182, 488, 90, 40);
		getContentPane().add(btnCancel);

		
		setSize(360, 600);
		setLocation(200, 200);
		getContentPane().setLayout(null);
		setVisible(true);
	}


	public static void main(String[] args) {
		new GrocerySearch();
	}


}