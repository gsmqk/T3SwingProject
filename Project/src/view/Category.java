package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Category extends JFrame {

	JLabel lbl;
	JTextField large ,medium, small ; 
	JButton    btnLarge, btnMedium, btnSmall, btnOk , btnBack;
	
	GridBagLayout      gb;
	GridBagConstraints gbc;
	
	public Category(){

		initComponent();
		
		setTitle("카테고리");
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
		
		lbl = new JLabel("카테고리 추가 및 수정");
		lbl.setHorizontalAlignment(JLabel.CENTER);
		lbl.setFont(new Font("D2Coding", Font.PLAIN, 20));
		gbAdd(lbl, 0, 0, 4, 1);
		
		
		//	Bigp.add(large);
		//	Bigp.add(btnlarge);

		// 대분류
		large = new JTextField(20);
		btnLarge = new JButton("추가");
		gbAdd(large,0,1,3,1);
		gbAdd(btnLarge,3,1,1,1);
		
		// 중분류 
		medium = new JTextField(20);
		btnMedium = new JButton("추가");
		gbAdd(medium,0,2,3,1);
		gbAdd(btnMedium,3,2,1,1);
		
		// 소분류 
		small = new JTextField(20);
		btnSmall = new JButton("추가");
		gbAdd(small, 0, 3, 3, 1);
		gbAdd(btnSmall, 3, 3, 1, 1);
		
		// 버튼
		JPanel p = new JPanel();
		btnOk    = new JButton("수정완료");
		btnBack  = new JButton("    취소    ");
		p.add(btnOk);
		p.add(btnBack);
		gbAdd(p, 0, 4, 0, 0);
		
		
	}
	
	// 컴포넌트를 받아서 위치 넓이 지정!!! 
	
	private void gbAdd(JComponent c, int x, int y, int w, int h) {
		gbc.gridx      = x;
		gbc.gridy      = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		
		gb.setConstraints(c, gbc);
		gbc.insets     = new Insets(5, 7, 5, 7);
		this.add(c , gbc );
		
		
	}
	public static void main(String[] args) {
		new Category();

	}

}









