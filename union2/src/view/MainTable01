
package view;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

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
	Expire_Output mEo = null;
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

	/**
	 * @wbp.parser.entryPoint
	 */
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
		btnInput.setBounds(30, 40, 150, 50);
		p.add(btnInput);
		
		btnIngredient = new JButton("폐기/출고 목록");
		btnIngredient.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnIngredient.setBackground(new Color(135, 206, 250));
		btnIngredient.setForeground(Color.WHITE);
		btnIngredient.setBounds(30, 120, 150, 50);
		p.add(btnIngredient);
		
		btnRecipe = new JButton("레시피 검색");
		btnRecipe.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnRecipe.setBackground(new Color(135, 206, 250));
		btnRecipe.setForeground(Color.WHITE);
		btnRecipe.setBounds(30, 200, 150, 50);
		p.add(btnRecipe);
		
		btnStorage = new JButton("보관 목록");
		btnStorage.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnStorage.setBackground(new Color(135, 206, 250));
		btnStorage.setForeground(Color.WHITE);
		btnStorage.setBounds(30, 530, 150, 50);
		p.add(btnStorage);
		
		btnAhb = new JButton("가계부");
		btnAhb.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnAhb.setBackground(new Color(135, 206, 250));
		btnAhb.setForeground(Color.WHITE);
		btnAhb.setBounds(30, 450, 150, 50);
		p.add(btnAhb);
		
		btnEdit = new JButton("개인정보수정");
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnEdit.setBackground(new Color(135, 206, 250));
		btnEdit.setBounds(30, 610, 150, 50);
		p.add(btnEdit);
	
		
		btnLogout = new JButton("로그아웃");
		btnLogout.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnLogout.setBackground(new Color(135, 206, 250));
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setBounds(30, 690, 150, 50);
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
				mEo = new Expire_Output(id);
				
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
				
		/*		if(mLog != null)
					mLog.dispose();
				mLog = new Login();
				f.setVisible(false);    */
			}

			private void LogoutBtn() {
				
	/*			JOptionPane.showMessageDialog(null, 
						id + "님 로그아웃 하시겠습니까?",
						"로그아웃",
						JOptionPane.OK_OPTION); */
				
				int result = JOptionPane.showConfirmDialog(null, 
						 "로그아웃 하시겠습니까?",
						
						"로그아웃",
						JOptionPane.YES_NO_OPTION);

				if(result == JOptionPane.YES_OPTION) {
					if(mLog != null)
						mLog.dispose();
					mLog = new Login();
					f.setVisible(false);
				} 
				else 
				if(result == JOptionPane.NO_OPTION){
					
				}
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
		
		
		
		Renderer ren = new Renderer(); 
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(getDataList(), getColumnList()));

		// 7번째 컬럼에 대한 색상 설정
		TableColumn column = table.getColumnModel().getColumn(6);
		column.setCellRenderer(new ColorRenderer());

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

		// TableCellRenderer 클래스 작성
		class ColorRenderer extends DefaultTableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		if (column == 6) { // 7번째 컬럼에 대해서만 적용
		int dday = Integer.parseInt(value.toString());
		if (dday <= 0) {
		renderer.setForeground(Color.BLACK);
		renderer.setBackground(Color.RED);
		} else if (dday <= 3) {
		renderer.setForeground(Color.BLACK);
		renderer.setBackground(Color.YELLOW);
		} else if (dday <= 7) {
		renderer.setForeground(Color.BLACK);
		renderer.setBackground(Color.GREEN);
		} else {
		renderer.setForeground(table.getForeground());
		renderer.setBackground(table.getBackground());
		}
		} else {
		renderer.setForeground(table.getForeground());
		renderer.setBackground(table.getBackground());
		}
		return renderer;
		}
		
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

	public void jTableRefresh() {
		table.setModel(new DefaultTableModel(getDataList(), getColumnList()));

		TableColumn column = table.getColumnModel().getColumn(6);
		column.setCellRenderer(new ColorRenderer());
		
		table.repaint();
		
	}
}
