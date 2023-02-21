package Test;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;


public class MainTable01 {
	
	// 필요한 부품준비
	JPanel            p; 
	JFrame            f;
	JTextField        txtId,  txtName,  txtIndate;
	JTextArea         taIntro;
			
	JButton           btnInput, btnIngredient, btnRecipe, btnStorage, btnAhb, btnSet, btnManager, btnLogout;
	
	FindName  mProc = null; 
	Category  mCate = null;
	Login     mLog  = null;
	MainTable01 mT01 = null;
	MainTable02 mT02 = null;
	admin     madmin = null;
	FindRecipe mFr   = null;
	GroceryInput mGi = null;
	GrocerySearch mGs = null;

	private JFrame frame;
	private JTextField textField;
	private JTable table;

	public static void main(String[] args) {
		new MainTable01();
	}

	public MainTable01() {
		initialize();
	}

	private void initialize() {
		f = new JFrame();
		f.setTitle("메인 화면");
		f.setBounds(100, 100, 1200, 800);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.getContentPane().setLayout(null);
		
		p = new JPanel();
		p.setBackground(SystemColor.menu);
		p.setBounds(0, 0, 1184, 761);
		f.getContentPane().add(p);
		p.setLayout(null);
		
		btnInput = new JButton("신규 입고");
		btnInput.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnInput.setBackground(new Color(135, 206, 250));
		btnInput.setForeground(Color.WHITE);
		btnInput.setBounds(30, 40, 120, 50);
		p.add(btnInput);
		
		btnIngredient = new JButton("식자재 검색");
		btnIngredient.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnIngredient.setBackground(new Color(135, 206, 250));
		btnIngredient.setForeground(Color.WHITE);
		btnIngredient.setBounds(30, 120, 120, 50);
		p.add(btnIngredient);
		
		btnRecipe = new JButton("레시피 검색");
		btnRecipe.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnRecipe.setBackground(new Color(135, 206, 250));
		btnRecipe.setForeground(Color.WHITE);
		btnRecipe.setBounds(30, 200, 120, 50);
		p.add(btnRecipe);
		
		btnStorage = new JButton("보관 목록");
		btnStorage.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnStorage.setBackground(new Color(135, 206, 250));
		btnStorage.setForeground(Color.WHITE);
		btnStorage.setBounds(30, 370, 120, 50);
		p.add(btnStorage);
		
		btnAhb = new JButton("가계부");
		btnAhb.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnAhb.setBackground(new Color(135, 206, 250));
		btnAhb.setForeground(Color.WHITE);
		btnAhb.setBounds(30, 450, 120, 50);
		p.add(btnAhb);
		
		btnSet = new JButton("템플릿 설정");
		btnSet.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnSet.setBackground(new Color(135, 206, 250));
		btnSet.setForeground(Color.WHITE);
		btnSet.setBounds(30, 530, 120, 50);
		p.add(btnSet);
		
		btnManager = new JButton("관리자");
		btnManager.setForeground(Color.WHITE);
		btnManager.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnManager.setBackground(new Color(135, 206, 250));
		btnManager.setBounds(30, 610, 120, 50);
		p.add(btnManager);
	
		
		btnLogout = new JButton("로그아웃");
		btnLogout.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnLogout.setBackground(new Color(135, 206, 250));
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setBounds(30, 690, 120, 50);
		p.add(btnLogout);
		
		
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
		btnStorage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				mT02 = new MainTable02();
			}
		}); 
		btnAhb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mProc != null)
					mProc.dispose();
				mProc = new FindName();
				
			}
		}); 
		btnSet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mCate != null)
					mCate.dispose();
				mCate = new Category();
				
			}
		}); 
		btnManager.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(madmin != null)
					madmin.dispose();
				madmin = new admin();
				
			}
		}); 
		btnLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LogoutBtn();
				
				if(mLog != null)
					mLog.dispose();
				mLog = new Login();
				f.setVisible(false);
				
				
			}

			private void LogoutBtn() {
				
				
				JOptionPane.showMessageDialog(null, 
						 "님 로그아웃 하시겠습니까?",
						"로그아웃",
						JOptionPane.OK_OPTION);
				
			}
		}); 
		
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		textField.setBackground(new Color(255, 218, 185));
		textField.setText("유통기한임박");
		textField.setBounds(236, 40, 839, 50);
		p.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setBounds(236, 140, 830, 479);
		p.add(scrollPane);
		
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"\uC774\uB984", "\uBCF4\uAD00\uC7A5\uC18C", "\uC218\uB7C9", "\uC785\uACE0\uC77C", "\uC18C\uBE44\uAE30\uD55C", "\uB9CC\uAE30\uC77C"
			}
		));
		
		
	}
}
