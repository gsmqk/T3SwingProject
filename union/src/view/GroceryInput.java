package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.F_DTO;
import model.F_Dao;
import model.U_DTO;
import net.sourceforge.jdatepicker.JDatePicker;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class GroceryInput extends JFrame implements ActionListener {
	
	//component
	JTextField  groName, inQuan, price, store;
	JComboBox<String>   major, minor, place, unit;
	private JDatePicker inputD, expirD;
	JLabel jlbName, jlbQuan, jlbPri, jlbSto;
	UtilDateModel model, model1;
	String [] units;
	//private JButton     btnInput, btnCancel;

	//constructor
	//defaultCons
	public GroceryInput() {
		init();
		
	}

	private void init() {
		setFont(new Font("D2Coding", Font.PLAIN, 14));
		setTitle("신규 식자재 입력");
		getContentPane().setLayout(null);

		//카테고리
		JLabel jlbCat = new JLabel("카테고리");
		jlbCat.setFont(new Font("D2Coding", Font.PLAIN, 16));
		jlbCat.setBounds(12, 10, 64, 24);
		getContentPane().add(jlbCat);

		//대분류/중분류/보관장소
		major = new JComboBox<>(new String [] 
				{"대분류", "과일", "쌀/잡곡", "채소", "견과", "수산물/건어물", "정육/계란",
						"친환경/유기농", "델리/치킨/초밥", "우유/유제품", "냉장/냉동/밀키트", 
						"두부/김치/반찬", "커피/차", "생수/음료", "과자/시리얼", 
						"베이커리/잼", "라면/즉석식품/통조림", "장류/양념/제빵"});
		minor = new JComboBox<>(new String [] {"중분류"});
		major.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				String selectedItem = (String)major.getSelectedItem();

				if(selectedItem.equals("과일")) {
					minor.setModel(new DefaultComboBoxModel<>(new String[] {
							"사과/배", "감귤/만감류", "토마토", "딸기/체리/블루베리", 
							"감/홍시/곶감/밤", "수박/메론/참외", "포도/자두/복숭아", 
							"바나나/파인애플", "오렌지/자몽/레몬", "키위/석류/아보카도", 
							"망고/열대과일", "기타 과일", "과일세트/바구니", 
							"냉동/건조/간편과일"}));
				} else if (selectedItem.equals("쌀/잡곡")) {
					minor.setModel(new DefaultComboBoxModel<>(new String[] {
							"백미", "찹쌀/현미/흑미", "혼합곡/수입잡곡", "수수/조/깨", 
							"콩/팥/보리/귀리"}));
				} else if (selectedItem.equals("채소")) {
					minor.setModel(new DefaultComboBoxModel<>(new String[] {
							"고구마/감자", "양파/마늘/파/생강", "당근/우엉/연근/마", 
							"오이/가지/호박/옥수수", "파프리카/브로콜리/피망", 
							"양배추/양상추/샐러리/아스파라거스", "상추/깻잎/쌈채소/고추", 
							"배추/무/김장채소", "버섯", "반찬채소", "나물/해초", 
							"샐러드/드레싱/편의채소", "건채소/기타", "인삼/더덕/약선재료"}));
				} else if (selectedItem.equals("견과")) {
					minor.setModel(new DefaultComboBoxModel<>(new String[] {
							"곡물가공/건강분말", "아몬드/호두/땅콩", "캐슈넛/피스타치오", 
							"브라질넛/마카다미아", "믹스넛/하루견과", "씨앗/잣/견과스낵", "선물세트"}));
				} else if (selectedItem.equals("수산물/건어물")) {
					minor.setModel(new DefaultComboBoxModel<>(new String[] {
							"생선", "연체갑각류", "어패류", "건어물/다시팩", 
							"김/미역/기타해조류", "간편/냉동수산물"}));
				} else if (selectedItem.equals("정육/계란")) {
					minor.setModel(new DefaultComboBoxModel<>(new String[] {
							"한우", "닭/오리고기", "돼지고기", "수입육", "계란/알류", 
							"양념육/가공육", "축산선물세트"}));
				} else if (selectedItem.equals("친환경/유기농")) {
					minor.setModel(new DefaultComboBoxModel<>(new String[] {
							"과일/채소", "쌀/잡곡"}));
				} else if (selectedItem.equals("델리/치킨/초밥")) {
					minor.setModel(new DefaultComboBoxModel<>(new String[] {
							"초밥/김밥", "치킨/튀김/구이", "샌드위치/사이드메뉴"}));
				} else if (selectedItem.equals("우유/유제품")) {
					minor.setModel(new DefaultComboBoxModel<>(new String[] {
							"우유", "요거트/요구르트", "두유", "치즈/버터", "냉장디저트/음료"}));
				} else if (selectedItem.equals("냉장/냉동/밀키트")) {
					minor.setModel(new DefaultComboBoxModel<>(new String[] {
							"돈까스/떡갈비/너겟", "피자/핫도그/치킨", "냉동밥/죽/스프", 
							"떡볶이/면류", "밀키트", "전/볶음/국탕", "만두", "아이스크림/디저트/얼음"}));
				} else if (selectedItem.equals("두부/김치/반찬")) {
					minor.setModel(new DefaultComboBoxModel<>(new String[] {
							"두부/나물", "햄/소시지", "유부초밥/김밥재료", "어묵/맛살/단무지", 
							"반찬/젓갈", "김치", "냉장소스/냉장장류"}));
				} else if (selectedItem.equals("커피/차")) {
					minor.setModel(new DefaultComboBoxModel<>(new String[] {
							"커피믹스", "원두커피/캡슐커피", "드립백/더치커피", 
							"커피음료", "녹차/보리차/기타차", "전통차/액상차/꿀", 
							"코코아/핫초코"}));
				} else if (selectedItem.equals("생수/음료")) {
					minor.setModel(new DefaultComboBoxModel<>(new String[] {
							"생수/탄산수", "과일/야채음료", "탄산/이온/비타민음료", 
							"전통/차/기타음료", "전통주"}));
				} else if (selectedItem.equals("과자/시리얼")) {
					minor.setModel(new DefaultComboBoxModel<>(new String[] {
							"과자/쿠키/파이", "떡/한과/전통과자", "시리얼/간식류", 
							"초콜릿/캔디/젤리/껌"}));
				} else if (selectedItem.equals("베이커리/잼")) {
					minor.setModel(new DefaultComboBoxModel<>(new String[] {
							"식빵/모닝롤/베이글", "케이크/머핀/쿠키", "베이커리생지/냉동생지", 
							"기타빵류", "잼/스프레드"}));
				} else if (selectedItem.equals("라면/즉석식품/통조림")) {
					minor.setModel(new DefaultComboBoxModel<>(new String[] {
							"라면/수입면류", "당면/건면/스파게티", "즉석식품/누룽지/죽", 
							"카레/짜장", "참치/스팸/축수산통조림", "옥수수/피클/과일통조림"}));
				} else if (selectedItem.equals("장류/양념/제빵")) {
					minor.setModel(new DefaultComboBoxModel<>(new String[] {
							"고추장/된장/쌈장/간장", "소스", "케찹/마요네즈", 
							"밀가루/분말류", "소금/설탕", "고추가루/깨/향신료", 
							"다시다/미원/맛소금", "식초/물엿/말술/액젓", 
							"식용유/참기름", "시럽/제빵믹스"}));
				}
			}
		});
		place = new JComboBox<>(new String [] 
				{"실온", "냉장", "냉동"});
		
		major.setToolTipText("대분류");
		major.setBounds(12, 44, 100, 40);
		getContentPane().add(major);
		
		minor.setToolTipText("중분류");
		minor.setBounds(122, 44, 100, 40);
		getContentPane().add(minor);
		
		place.setToolTipText("보관장소");
		place.setBounds(232, 44, 100, 40);
		getContentPane().add(place);

		//세부정보
		JLabel jlbDet = new JLabel("세부정보");
		jlbDet.setFont(new Font("D2Coding", Font.PLAIN, 16));
		jlbDet.setBounds(12, 99, 64, 24);
		getContentPane().add(jlbDet);

		//식자재이름
		JLabel jlbName = new JLabel("이름");
		jlbName.setFont(new Font("D2Coding", Font.PLAIN, 16));
		jlbName.setBounds(12, 133, 50, 40);
		getContentPane().add(jlbName);
		
		groName        = new JTextField(20);
		groName.setBounds(82, 133, 260, 40);
		getContentPane().add(groName);
		groName.setColumns(10);

		//식자재수량
		JLabel jlbQuan = new JLabel("수량");
		jlbQuan.setFont(new Font("D2Coding", Font.PLAIN, 16));
		jlbQuan.setBounds(12, 183, 50, 40);
		getContentPane().add(jlbQuan);

		inQuan         = new JTextField(20);
		inQuan.setColumns(10);
		inQuan.setBounds(82, 184, 200, 40);
		getContentPane().add(inQuan);
		
		String [] units = {"g", "Kg", "ml", "L"};
		unit = new JComboBox(units);
		unit.setBounds(282, 184, 50, 40);
		getContentPane().add(unit);

		//식자재가격
		JLabel jlbPri  = new JLabel("가격");
		jlbPri.setFont(new Font("D2Coding", Font.PLAIN, 16));
		jlbPri.setBounds(12, 233, 50, 40);
		getContentPane().add(jlbPri);

		price          = new JTextField(20);
		price.setColumns(10);
		price.setBounds(82, 234, 200, 40);
		getContentPane().add(price);

		JLabel jlbWon  = new JLabel("원");
		jlbWon.setFont(new Font("D2Coding", Font.PLAIN, 18));
		jlbWon.setBounds(284, 234, 40, 40);
		getContentPane().add(jlbWon);

		//구매처
		JLabel jlbSto  = new JLabel("구매처");
		jlbSto.setFont(new Font("D2Coding", Font.PLAIN, 16));
		jlbSto.setBounds(12, 283, 64, 40);
		getContentPane().add(jlbSto);

		store          = new JTextField(20);
		store.setColumns(10);
		store.setBounds(82, 284, 260, 40);
		getContentPane().add(store);

		//입고일
		JLabel jlbInpD  = new JLabel("입고일");
		jlbInpD.setFont(new Font("D2Coding", Font.PLAIN, 16));
		jlbInpD.setBounds(12, 333, 64, 40);
		getContentPane().add(jlbInpD);
		
		model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		this.add(datePicker);
		datePicker.setBounds(82, 334, 250, 40);

		//소비기한
		JLabel jlbExpD  = new JLabel("소비기한");
		jlbExpD.setFont(new Font("D2Coding", Font.PLAIN, 16));
		jlbExpD.setBounds(12, 383, 64, 40);
		getContentPane().add(jlbExpD);
		
		model1 = new UtilDateModel();
		JDatePanelImpl datePanel1 = new JDatePanelImpl(model1);
		JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1);
		this.add(datePicker1);
		datePicker1.setBounds(82, 384, 250, 40);
		
		//입력/취소버튼
		JButton	btnInput  = new JButton("입력");
		btnInput.setFont(new Font("D2Coding", Font.PLAIN, 18));
		btnInput.setBounds(70, 458, 90, 40);
		getContentPane().add(btnInput);

		JButton btnCancel = new JButton("취소");
		btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 18));
		btnCancel.setBounds(182, 458, 90, 40);
		getContentPane().add(btnCancel);

		
		setSize(360, 600);
		setLocation(200, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		btnInput.addActionListener(this);
		btnCancel.addActionListener(this);
		
	}


	public static void main(String[] args) {
		new GroceryInput();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "입력" : 
			System.out.println("식자재 입력 클릭");
			inGrosery();
			break;
		case "취소" :
			this.dispose();
			break;
		}
		
	}

	private void inGrosery() {
		F_Dao fao = new F_Dao();
		F_DTO fto = getViewFood();
		int aftcnt = fao.insertGrosery(fto);
		
		JOptionPane.showMessageDialog(null, aftcnt + "건 저장되었습니다.");
		
		this.dispose();
	}

	private F_DTO getViewFood() {
		String major = this.major.getSelectedItem().toString();
		String minor = this.minor.getSelectedItem().toString();
		String place = this.place.getSelectedItem().toString();
		String fname = this.groName.getText();
		String quan = this.inQuan.getText();
		String unit = this.unit.getSelectedItem().toString();
		String price = this.price.getText();
		String store = this.store.getText();
		String indate = this.model.getYear() + "-" + (this.model.getMonth() + 1) + "-" + this.model.getDay();
		String sobi = this.model1.getYear() + "-" + (this.model1.getMonth() + 1) + "-" + this.model1.getDay();
		
		F_DTO fto = new F_DTO(major, minor, place, fname, quan, unit, price,
				              store, indate, sobi);
		return fto;
	}


}

