package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.sourceforge.jdatepicker.JDatePicker;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class GroceryInput extends JFrame implements ActionListener{
   /*-INPUT_ID             (입고ID, PK)
     -GROCERY_ID           (식자재ID, FOREIGN KEY)
     -MAJOR_CLASSIFICATION (대분류)
     -MINOR_CLASSIFICATION (중분류)
     -STORAGE_PLACE        (보관장소)
     -GROCERY_NAME         (식자재이름)
     -INPUT_QUANTITY       (입고수량)
     -UNIT                 (단위)
     -PRICE                (가격)
     -STORE_ID             (구매처ID, FOREIGN KEY)
     -INPUT_DATE           (입고일, SYSDATE)
     -EXPIRE_DATE          (소비기한, 'YYYY-MM-DD')
     -USER_ID              (유저ID, FOREIGN KEY)
    */   

   //component
   //JPanel      p;
   JTextField  groName, inQuan, price, store;
   JComboBox   majorCla, minorCla, storPlace, unit;
   JDatePicker inputD, expirD;
   JButton     btnInput, btnCancel;

   //GridBagLayout
   GridBagLayout      gbl;
   GridBagConstraints gbc;

   //constructor
   //defaultCons
   public GroceryInput() {
      init();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(500, 800);
      setLocation(200, 200);
      setVisible(true);

   }

   private void init() {
      setTitle("신규 식자재 입력");

      //component 배치
      gbl           = new GridBagLayout();
      this.setLayout(gbl);

      gbc           = new GridBagConstraints();
      gbc.fill      = GridBagConstraints.BOTH;
      gbc.weightx   = 1.0;
      gbc.weighty   = 1.0;

      //카테고리
      JLabel jlbCat = new JLabel("카테고리");
      jlbCat.setHorizontalAlignment(JLabel.CENTER);
      gblAdd (jlbCat, 0, 0, 6, 1);

      //대분류/중분류/보관장소
      JComboBox<String> major = new JComboBox<>(new String [] 
            {"과일", "쌀/잡곡", "채소", "견과", "수산물/건어물", "정육/계란",
                  "친환경/유기농", "델리/치킨/초밥", "우유/유제품", "냉장/냉동/밀키트", 
                  "두부/김치/반찬", "커피/차", "생수/음료", "과자/시리얼", 
                  "베이커리/잼", "라면/즉석식품/통조림", "장류/양념/제빵"});
      JComboBox<String> minor = new JComboBox<>(new String [] {"중분류"});
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
      JComboBox<String> place = new JComboBox<>(new String [] 
            {"실온", "냉장", "냉동"});
      //majorCla  = new JComboBox(major);
      //minorCla  = new JComboBox(minor);
      //storPlace = new JComboBox(place);
      gblAdd(major, 0, 1, 2, 1);
      gblAdd(minor, 2, 1, 2, 1);
      gblAdd(place, 4, 1, 2, 1);

      //세부정보
      JLabel jlbDet = new JLabel("세부정보");
      gblAdd (jlbDet, 0, 2, 2, 1);

      //식자재이름
      JLabel jlbName = new JLabel("이름");
      groName        = new JTextField(20);
      gblAdd(jlbName, 0, 3, 1, 1);
      gblAdd(groName, 1, 3, 5, 1);

      //식자재수량
      JLabel jlbQuan = new JLabel("수량");
      inQuan         = new JTextField(20);
      String [] units = {"g", "Kg", "ml", "L"};
      unit           = new JComboBox (units);
      gblAdd(jlbQuan, 0, 4, 1, 1);
      gblAdd(inQuan, 1, 4, 4, 1);
      gblAdd(unit, 5, 4, 1, 1);

      //식자재가격
      JLabel jlbPri  = new JLabel("가격");
      price          = new JTextField(20);
      JLabel jlbWon  = new JLabel("원");
      gblAdd(jlbPri, 0, 5, 1, 1);
      gblAdd(price, 1, 5, 4, 1);
      gblAdd(jlbWon, 5, 5, 1, 1);

      //구매처
      JLabel jlbSto  = new JLabel("구매처");
      store          = new JTextField(20);
      gblAdd(jlbSto, 0, 6, 1, 1);
      gblAdd(store, 1, 6, 5, 1);

      //입고일
      JLabel jlbInpD  = new JLabel("입고일");
      gblAdd(jlbInpD, 0, 7, 1, 1);
      UtilDateModel model = new UtilDateModel();
      JDatePanelImpl datePanel = new JDatePanelImpl(model);
      JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
      this.add(datePicker);
      gblAdd(datePicker, 1, 7, 5, 1);

      //소비기한
      JLabel jlbExpD  = new JLabel("소비기한");
      gblAdd(jlbExpD, 0, 8, 1, 1);
      UtilDateModel model1 = new UtilDateModel();
      JDatePanelImpl datePanel1 = new JDatePanelImpl(model1);
      JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1);
      this.add(datePicker1);
      gblAdd(datePicker1, 1, 8, 5, 1);
      
      //입력/취소버튼
      btnInput        = new JButton("입력");
      btnCancel       = new JButton("취소");
      gblAdd(btnInput, 1, 9, 2, 1);
      gblAdd(btnCancel, 4, 9, 2, 1);

   }

   private void gblAdd(JComponent jc, int x, int y, int w, int h) {
      gbc.gridx      = x;
      gbc.gridy      = y;
      gbc.gridwidth  = w;
      gbc.gridheight = h;
      gbl.setConstraints( jc, gbc );
      gbc.insets     = new Insets(4, 4, 4, 4);
      this.add( jc, gbc );


   }

   public static void main(String[] args) {
      new GroceryInput();
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      
   }

}