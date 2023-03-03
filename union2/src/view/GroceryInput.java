package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

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
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class GroceryInput extends JFrame implements ActionListener {
	
	//component
	MainTable01 mainTable01 = null;
	StorageList storeageList = null;
	GroceryInput groceryInput = null;
	JTextField  groName, inQuan, price, memo;
	JButton btnInput, btnCancel;
	
	//fdddddd
	
	JComboBox large_classific, middle_classific, small_classific, storage_place, unit,
	          store;
	UtilDateModel model, model1;
	String id;

	/**
	 * @wbp.parser.constructor
	 */
	public GroceryInput(MainTable01 mainTable) {
		getContentPane().setBackground(new Color(255, 255, 255));
		this.mainTable01 = mainTable;
		String id = mainTable01.id;
		System.out.println(id);
		
		init(id);
	}

	public GroceryInput(StorageList slist) {
		getContentPane().setBackground(new Color(255, 255, 255));
		
		init(slist.id);
	}

	private void init(String id) {
		
		this.id = id;
		
		setFont(new Font("D2Coding", Font.PLAIN, 14));
		setTitle("신규 식자재 입력");
		getContentPane().setLayout(null);

		//카테고리
		JLabel jlbCat = new JLabel("카테고리");
		jlbCat.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 15));
		jlbCat.setBounds(12, 10, 64, 24);
		getContentPane().add(jlbCat);

		F_Dao fao = new F_Dao();
		Vector<String> large = fao.getLarge();
		
		large_classific = new JComboBox (large);
		large_classific.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		large_classific.setBackground(new Color(250, 250, 250));
		large_classific.setToolTipText("대분류");
		large_classific.setBounds(12, 44, 155, 40);
		getContentPane().add(large_classific);
		
		middle_classific = new JComboBox(new String [] {"중분류"});
		middle_classific.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		middle_classific.setBackground(new Color(250, 250, 250));
		middle_classific.setToolTipText("중분류");
		middle_classific.setBounds(177, 44, 155, 40);
		getContentPane().add(middle_classific);

		small_classific = new JComboBox(new String [] {"소분류"});
		small_classific.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		small_classific.setBackground(new Color(250, 250, 250));
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
				}
				
			}
		});
		
		
		
		storage_place = new JComboBox(new String [] {"실온", "냉장", "냉동"});
		storage_place.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		storage_place.setBackground(new Color(250, 250, 250));
		storage_place.setToolTipText("보관장소");
		storage_place.setBounds(177, 94, 155, 40);
		getContentPane().add(storage_place);

		//세부정보
		JLabel jlbDet = new JLabel("세부정보");
		jlbDet.setHorizontalAlignment(SwingConstants.CENTER);
		jlbDet.setBackground(new Color(238, 251, 255));
		jlbDet.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 15));
		jlbDet.setBounds(12, 149, 69, 24);
		getContentPane().add(jlbDet);

		//식자재이름
		JLabel jlbName = new JLabel("이름");
		jlbName.setHorizontalAlignment(SwingConstants.CENTER);
		jlbName.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 15));
		jlbName.setBounds(12, 183, 69, 40);
		getContentPane().add(jlbName);
		
		groName        = new JTextField(20);
		groName.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		groName.setBounds(82, 183, 250, 40);
		getContentPane().add(groName);
		groName.setColumns(10);

		//식자재수량
		JLabel jlbQuan = new JLabel("수량");
		jlbQuan.setHorizontalAlignment(SwingConstants.CENTER);
		jlbQuan.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 15));
		jlbQuan.setBounds(12, 234, 69, 40);
		getContentPane().add(jlbQuan);

		inQuan         = new JTextField(20);
		inQuan.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		inQuan.setColumns(10);
		inQuan.setBounds(82, 234, 195, 40);
		getContentPane().add(inQuan);
		
		String [] units = {"G", "KG", "ML", "L", "EA"};
		unit = new JComboBox(units);
		unit.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		unit.setBackground(new Color(250, 250, 250));
		unit.setBounds(282, 234, 50, 39);
		getContentPane().add(unit);

		//식자재가격
		JLabel jlbPri  = new JLabel("가격");
		jlbPri.setHorizontalAlignment(SwingConstants.CENTER);
		jlbPri.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 15));
		jlbPri.setBounds(12, 284, 69, 40);
		getContentPane().add(jlbPri);

		price          = new JTextField(20);
		price.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		price.setColumns(10);
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
		jlbSto.setBounds(12, 334, 69, 40);
		getContentPane().add(jlbSto);

		Vector<String> storename = new Vector<String>();
		storename = fao.getStore();
		
		store = new JComboBox(storename);
		store.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		store.setBackground(new Color(250, 250, 250));
		store.setBounds(82, 334, 250, 40);
		getContentPane().add(store);

		//입고일
		JLabel jlbInpD  = new JLabel("입고일");
		jlbInpD.setHorizontalAlignment(SwingConstants.CENTER);
		jlbInpD.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 15));
		jlbInpD.setBounds(12, 384, 69, 40);
		getContentPane().add(jlbInpD);
		
		model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		datePicker.setBackground(new Color(255, 255, 255));
		getContentPane().add(datePicker);
		datePicker.setBounds(82, 390, 250, 40);

		//소비기한
		JLabel jlbExpD  = new JLabel("소비기한");
		jlbExpD.setHorizontalAlignment(SwingConstants.CENTER);
		jlbExpD.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 15));
		jlbExpD.setBounds(12, 434, 69, 40);
		getContentPane().add(jlbExpD);
		
		model1 = new UtilDateModel();
		JDatePanelImpl datePanel1 = new JDatePanelImpl(model1);
		JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1);
		datePicker1.setBackground(new Color(255, 255, 255));
		getContentPane().add(datePicker1);
		datePicker1.setBounds(82, 440, 250, 40);
		
		//입력/취소버튼
		btnInput  = new JButton("");
		btnInput.setIcon(new ImageIcon(GroceryInput.class.getResource("/image/storageList/15.png")));
		btnInput.setBackground(new Color(73, 153, 221));
		btnInput.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 15));
		btnInput.setBounds(70, 610, 90, 40);
		getContentPane().add(btnInput);
		
		groceryInput = this;

		btnInput.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				F_Dao fao = new F_Dao();
				F_DTO fto = getGroceryData(groceryInput.id);
				String groname = fto.getGrocery_name();
				String largecla = fto.getLarge_classific();
				String mediumcla = fto.getMedium_classific();
				String smallcla = fto.getSmall_classific();
				
				System.out.println("값" + largecla + " " + mediumcla + " " + smallcla);
				
				if (largecla.equals("대분류")  || 
					mediumcla.equals("중분류") || 
					smallcla.equals("소분류")) {
					JOptionPane.showMessageDialog(null, "분류를 설정해주세요 !", "확인",
							JOptionPane.OK_OPTION);
				}
				
				
				int aftcnt = fao.insertGrosery(fto);
				if (aftcnt == 1) {
					JOptionPane.showMessageDialog(null, "냉장고에 들어갔어요~");
					
					groceryInput.dispose();
					
				} else {
					JOptionPane.showMessageDialog(null, "다시 확인해주세요");
				}
				
			}
		});
		
		JButton btnCancel = new JButton("");
		btnCancel.setIcon(new ImageIcon(GroceryInput.class.getResource("/image/storageList/16.png")));
		btnCancel.setBackground(new Color(73, 153, 221));
		btnCancel.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 15));
		btnCancel.setBounds(182, 610, 90, 40);
		getContentPane().add(btnCancel);
		
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "취소하셨습니다.");
				groceryInput.dispose();
				
			}
		});
		
		JLabel jlbExpD_1 = new JLabel("메모");
		jlbExpD_1.setHorizontalAlignment(SwingConstants.CENTER);
		jlbExpD_1.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 15));
		jlbExpD_1.setBounds(12, 484, 69, 40);
		getContentPane().add(jlbExpD_1);
		
		memo = new JTextField(10);
		memo.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 12));
		memo.setBounds(82, 490, 250, 106);
		getContentPane().add(memo);

		

		setSize(370, 710);
		setLocation(200, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
//		btnInput.addActionListener(this);
		btnCancel.addActionListener(this);
		
	}
		






	@Override
	public void actionPerformed(ActionEvent e) {
//		switch(e.getActionCommand()) {
//		case "입력" :
//			F_Dao fao = new F_Dao();
//			F_DTO fto = getGroceryData(this.id);
//			
//			int aftcnt = fao.insertGrosery(fto);
//		
//			
//			if (aftcnt == 1) {
//				JOptionPane.showMessageDialog(null, "냉장고에 들어갔어요~");
//				
//				this.dispose();
//				
//			} else {
//				JOptionPane.showMessageDialog(null, "다시 확인해주세요 !");
//			}
//		
//			break;
//		case "취소" :
//			JOptionPane.showMessageDialog(null, "취소하셨습니다.");
//			this.dispose();
//			break;
//		}
		
	}



	private F_DTO getGroceryData(String id) {
		String name = this.groName.getText();
		String large = (String) this.large_classific.getSelectedItem();
		String middle = (String) this.middle_classific.getSelectedItem();
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
		System.out.println(uid);
		
		F_DTO fto = new F_DTO(name, large, middle, small, place, quan, unit, price, 
				              indate, exdate, memo, uid, store) ;
		
		return fto;
	}
}
