package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;//
import javax.swing.JTextField;

public class FindRecipe extends JFrame {

   JLabel lbl;
   JTextField food , foodList ; 
   JButton    btnAdd, btnSmall, btnFind , btnCancel;
   
   GridBagLayout      gb;
   GridBagConstraints gbc;
   
   public FindRecipe(){

      initComponent();
      
      setTitle("레시피 검색");
      setSize(400,600);   
      setVisible(true);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      
   }
   
   private void initComponent() {
      gb = new GridBagLayout();
      this.setLayout(gb);
      
      // 카테고리 
      
      gbc = new GridBagConstraints();
      gbc.fill    = GridBagConstraints.BOTH;
      gbc.weightx = 1.0; // 기본넓이.. x,y 1:1로정함.
      gbc.weighty = 1.0;
      
      lbl = new JLabel("다음의 식자재를 포함한 레시피 검색");
      lbl.setHorizontalAlignment(JLabel.LEFT);
      lbl.setFont(new Font("D2Coding", Font.PLAIN, 20));
      gbAdd(lbl, 0, 0, 4, 1);
      
      
      //   Bigp.add(large);
      //   Bigp.add(btnlarge);

      // 레시피 검색
      food   = new JTextField(20);
      btnAdd = new JButton("추가");
      gbAdd(food,0,1,3,1);
      gbAdd(btnAdd,3,1,1,1);
      
      // 검색 대상 식자재 목록
      lbl = new JLabel("검색 대상 식자재 목록");
      lbl.setHorizontalAlignment(JLabel.LEFT);
      lbl.setFont(new Font("D2Coding", Font.PLAIN, 20));
      gbAdd(lbl, 0, 2, 4, 1);
            
      foodList = new JTextField(20);
      gbAdd(foodList, 0, 3, 4, 1);
  
      // 버튼
      JPanel p = new JPanel();
      btnFind    = new JButton("검색");
      btnCancel  = new JButton("취소");
      p.add(btnFind);
      p.add(btnCancel);
      gbAdd(p, 0, 4, 0, 0);
      
      
   }
   
   // 컴포넌트를 받아서 위치 넓이 지정
   
   private void gbAdd(JComponent c, int x, int y, int w, int h) {
      gbc.gridx      = x;
      gbc.gridy      = y;
      gbc.gridwidth  = w;
      gbc.gridheight = h;
      
      gb.setConstraints(c, gbc);
      gbc.insets     = new Insets(5, 7, 5, 7);
      this.add(c , gbc );
      
      
   }
   public static void main(String[] args) {
      new FindRecipe();

   }

}
