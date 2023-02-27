package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

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

import model.F_Dao;
import model.Renderer;
import model.U_Dao;


public class MainTable01 implements MouseListener {
	
	// 필요한 부품준비
	JPanel            p; 
	JFrame            f;
	JTextField        txtId,  txtName,  txtIndate;
	JTextArea         taIntro;
			
	JButton           btnInput, btnIngredient, btnRecipe, btnStorage, btnAhb, btnSet, btnEdit, btnLogout;
	
	FindName  mProc = null; 
	Category  mCate = null;
	Login     mLog  = null;
	MainTable01 mT01 = null;
	StorageList mT02 = null;
	FindRecipe mFr   = null;
	GroceryInput mGi = null;
	public MainTable01 mt01 = null;
	GrocerySearch mGs = null;
	public String id;
	Edit e1 = null;
	GroceryInfo info = null;
	StorageList slist = null;

	private JFrame frame;
	private JTextField textField;
	private JTable table;

	public static void main(String[] args) {
		new MainTable01();
	}

	public MainTable01() {
//		initialize();
	}

	public MainTable01(Login login) {
		this.id = login.idTxt.getText();
		System.out.println("메인테이블" + id);
		initialize(id);
	}


	public MainTable01(StorageList slist2) {
		this.id = slist2.id;
		System.out.println("보관목록에서온 아이디" + id);
		initialize(id);
	}

	private void initialize(String id) {
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
		btnStorage.setBounds(30, 530, 120, 50);
		p.add(btnStorage);
		
		btnAhb = new JButton("가계부");
		btnAhb.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnAhb.setBackground(new Color(135, 206, 250));
		btnAhb.setForeground(Color.WHITE);
		btnAhb.setBounds(30, 450, 120, 50);
		p.add(btnAhb);
		
		btnEdit = new JButton("개인정보수정");
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnEdit.setBackground(new Color(135, 206, 250));
		btnEdit.setBounds(30, 610, 120, 50);
		p.add(btnEdit);
	
		
		btnLogout = new JButton("로그아웃");
		btnLogout.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnLogout.setBackground(new Color(135, 206, 250));
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setBounds(30, 690, 120, 50);
		p.add(btnLogout);
		
		mt01 = this;
		
		btnInput.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		
				if(mGi != null)
					mGi.dispose();
				mGi = new GroceryInput(mt01);
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
				mT02 = new StorageList(mt01);
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

		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				e1 = new Edit(mt01);
				
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
						id + "님 로그아웃 하시겠습니까?",
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
		scrollPane.setBounds(236, 140, 830, 479);
		p.add(scrollPane);
		
		
		
		Renderer ren = new Renderer(); // 색깔바꾸는거 나중에
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(
				new DefaultTableModel(getDataList(), getColumnList())
				
				);
		
		table.addMouseListener(this);
	}

	private Vector<String> getColumnList() {
		Vector<String> cols = new Vector<>();
		cols.add("재료이름");
		cols.add("보관");
		cols.add("수량");
		cols.add("단위");
		cols.add("입고일");
		cols.add("소비기한");
		cols.add("D-Day");
		
		return cols;
	}

	private Vector<Vector> getDataList() {
		U_Dao uao = new U_Dao();
		Vector<Vector> list = uao.getUserList(id); 
		System.out.println(list);
		System.out.println(id);
		return list;
	}

	// 이거부터해야함.!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	@Override
	public void mouseClicked(MouseEvent e) {
		// 마우스를 클릭하면
		// 마우스버튼 누르고 있는 동안
		// button = 1 : 왼쪽
		// button = 2 : 가운데
		// button = 3 : 오른쪽
		int row = table.getSelectedRow();
		int col = table.getSelectedColumn();
		String id = (String) table.getValueAt(row, 0);
		System.out.println(e);
		
		System.out.println(id);
		
		F_Dao fao = new F_Dao();
		fao.goInfo(id);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
