package Test;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainTable extends JFrame{

	// 필요한 부품준비
		JPanel            p; 
		JTextField        txtId,  txtName,  txtIndate;
		JPasswordField    txtPwd;
		JComboBox         cbJob;
		JRadioButton      rbMan, rbWoman;
		ButtonGroup       group;
		JTextArea         taIntro;
		
		JButton           btnInput, btnIngredient, btnRecipe, btnStorage, btnAhb, btnSet, btnLogout;
		
		// GridBagLayout  
		GridBagLayout        gb;
		GridBagConstraints   gbc;
		
	public  MainTable() {
		initComponent();
	}
		
	private void initComponent() {
		
		setTitle("메인 화면");
		
		//component 베치
		gb           =  new GridBagLayout();
		getContentPane().setLayout(gb);
				
		gbc          =  new GridBagConstraints();
		gbc.fill     =  GridBagConstraints.BOTH;
		gbc.weightx  =  100.0; 
		gbc.weighty  =  100.0;
		
	
	// 버튼들
		JPanel   pButton  = new JPanel();
		btnInput          = new JButton("신규 입고");
		gbAdd(btnInput,12, 33, 85, 23);
		btnIngredient     = new JButton("식자재 검색");
		gbAdd(btnIngredient,12, 33, 97, 23);
		btnRecipe         = new JButton("레시피 검색");
		gbAdd(btnRecipe,12, 99, 97, 23);
		btnStorage        = new JButton("보관목록");
		gbAdd(btnStorage,12, 132, 81, 23);
		btnAhb            = new JButton("가계부");
		gbAdd(btnAhb,12, 209, 69, 23);
		btnSet            = new JButton("템플릿 설정");
		gbAdd(btnSet,12, 242, 97, 23);
		btnLogout         = new JButton("로그아웃");
		gbAdd(btnLogout,12, 267, 81, 23);
	pButton.setLayout(null);
	
		

	//------------------------------
	
	// 버튼들을 panel 에 추가
	pButton.add( btnInput );
	pButton.add( btnIngredient );
	pButton.add( btnRecipe );
	pButton.add( btnStorage );
	pButton.add( btnAhb );
	pButton.add( btnSet );
	pButton.add( btnLogout );
	}
	
	private void gbAdd(JComponent c, int x, int y, int w, int h) {
		gbc.gridx        = x;
		gbc.gridy        = y;
		gbc.gridwidth    = w;
		gbc.gridheight   = h;
		gb.setConstraints(c, gbc);
		gbc.insets       = new Insets(200, 200, 200, 200);
		this.add( c, gbc );
	}
	public static void main(String[] args) {
		new MainTable();
	}

}
