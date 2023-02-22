package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class MainTable02 {

	// 필요한 부품준비
	JPanel            p; 
	JFrame            f;
	JTextField        txtId,  txtName,  txtIndate;
	JTextArea         taIntro;
				
	JButton           btnInput, btnIngredient, btnRecipe, btnmain, btnAhb;
	
	MainTable01 mT01 = null;
	MainTable02 mT02 = null;
	FindRecipe mFr   = null;
	GroceryInput mGi = null;
	GrocerySearch mGs = null;
	
	private JFrame frame;
	private JTable table;
	
	FindName  mProc = null; 
	static MainTable02  mList = null;

	
	public static void main(String[] args) {
		new MainTable02();
	}

	
	public MainTable02() {
		initialize();
	}

	
	private void initialize() {
		f = new JFrame();
		f.setTitle("보관목록");
		f.setBounds(100, 100, 1200, 800);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.getContentPane().setLayout(null);
		
		p = new JPanel();
		p.setBounds(0, 0, 1184, 761);
		f.getContentPane().add(p);
		p.setLayout(null);
		
		
		
		btnInput = new JButton("신규 입력");
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInput.setForeground(Color.WHITE);
		btnInput.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnInput.setBackground(new Color(135, 206, 250));
		btnInput.setBounds(30, 50, 120, 50);
		p.add(btnInput);
		
		btnIngredient = new JButton("식자재 검색");
		btnIngredient.setForeground(Color.WHITE);
		btnIngredient.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnIngredient.setBackground(new Color(135, 206, 250));
		btnIngredient.setBounds(30, 130, 120, 50);
		p.add(btnIngredient);
		
		btnRecipe = new JButton("레시피 검색");
		btnRecipe.setForeground(Color.WHITE);
		btnRecipe.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnRecipe.setBackground(new Color(135, 206, 250));
		btnRecipe.setBounds(30, 210, 120, 50);
		p.add(btnRecipe);
		
		
		btnmain = new JButton("메인 화면");
		btnmain.setForeground(Color.WHITE);
		btnmain.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnmain.setBackground(new Color(135, 206, 250));
		btnmain.setBounds(30, 550, 120, 50);
		p.add(btnmain);
		
		btnAhb = new JButton("가계부");
		btnAhb.setForeground(Color.WHITE);
		btnAhb.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnAhb.setBackground(new Color(135, 206, 250));
		btnAhb.setBounds(30, 630, 120, 50);
		p.add(btnAhb);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(209, 50, 894, 630);
		p.add(scrollPane);
		
		btnInput.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mGi != null)
					mGi.dispose();
				mGi = new GroceryInput();
				
			}
		}); 
		
		btnIngredient.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mGs != null)
					mGs.dispose();
				mGs = new GrocerySearch();
				
			}
		}); 
		
		btnRecipe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mFr != null)
					mFr.dispose();
				mFr = new FindRecipe();
				
			}
		}); 
		btnmain.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				mT01 = new MainTable01();
				
			}
		}); 
		btnAhb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		}); 
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"대분류", "소분류", "보관장소", "이름", "수량/단위", "구매처", "입고일", "소비기한", "만기일"
			}
		));
		scrollPane.setViewportView(table);
		
		
	}
}
