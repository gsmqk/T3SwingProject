
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.jfree.ui.RefineryUtilities;

import model.F_Dao;
import model.Renderer;
import model.U_Dao;


public class MainTable01 implements MouseListener {
	
	// 필요한 부품준비
	JPanel            p; 
	JFrame            f;
	JTextField        txtId,  txtName,  txtIndate;
	JTextArea         taIntro;
			
	JButton           btnInput, btnIngredient, btnRecipe, btnStorage, btnAhb, btnSet, btnEdit, btnLogout, btnRefresh;
	
	RealChart mchart = null;
	FindName  mProc = null;
	Category  mCate = null;
	Login     mLog  = null;
	MainTable01 mT01 = null;
	StorageList mT02 = null;
	FindRacipeTest mFr   = null;
	GroceryInput mGi = null;
	public MainTable01 mt01 = null;
	Expire_Output mEo = null;
	public String id;
	Edit e1 = null;
	GroceryInfo info = null;
	StorageList slist = null;

	private JFrame frame;
	private JLabel textField;
	private JTable table;
	private JLabel lblNewLabel;

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
		f.getContentPane().setForeground(new Color(255, 255, 255));
		f.setTitle("메인 화면");
		f.setBounds(100, 100, 1200, 800);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.getContentPane().setLayout(null);
		
		p = new JPanel();
		p.setBackground(new Color(255, 255, 255));

		p.setForeground(new Color(255, 255, 255));
		p.setBackground(SystemColor.menu);

		p.setBounds(0, 0, 1184, 761);
		f.getContentPane().add(p);
		p.setLayout(null);
		
		btnInput = new JButton("");
		btnInput.setIcon(new ImageIcon(MainTable01.class.getResource("/image/storageList/01.png")));
		btnInput.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnInput.setBackground(new Color(73, 153, 221));
		btnInput.setForeground(Color.WHITE);
		btnInput.setBounds(30, 40, 150, 50);
		p.add(btnInput);
		
		btnIngredient = new JButton("");
		btnIngredient.setIcon(new ImageIcon(MainTable01.class.getResource("/image/storageList/02.png")));
		btnIngredient.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnIngredient.setBackground(new Color(73, 153, 221));
		btnIngredient.setForeground(Color.WHITE);
		btnIngredient.setBounds(30, 120, 150, 50);
		p.add(btnIngredient);
		
		btnRecipe = new JButton("");
		btnRecipe.setIcon(new ImageIcon(MainTable01.class.getResource("/image/storageList/03.png")));
		btnRecipe.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnRecipe.setBackground(new Color(73, 153, 221));
		btnRecipe.setForeground(Color.WHITE);
		btnRecipe.setBounds(30, 200, 150, 50);
		p.add(btnRecipe);
		
		btnStorage = new JButton("");
		btnStorage.setIcon(new ImageIcon(MainTable01.class.getResource("/image/storageList/05.png")));
		btnStorage.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnStorage.setBackground(new Color(73, 153, 221));
		btnStorage.setForeground(Color.WHITE);
		btnStorage.setBounds(30, 530, 150, 50);
		p.add(btnStorage);
		
		btnAhb = new JButton("");
		btnAhb.setIcon(new ImageIcon(MainTable01.class.getResource("/image/storageList/26.png")));
		btnAhb.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnAhb.setBackground(new Color(73, 153, 221));
		btnAhb.setForeground(Color.WHITE);
		btnAhb.setBounds(30, 450, 150, 50);
		p.add(btnAhb);
		
		btnEdit = new JButton("");
		btnEdit.setIcon(new ImageIcon(MainTable01.class.getResource("/image/storageList/06.png")));
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnEdit.setBackground(new Color(73, 153, 221));
		btnEdit.setBounds(30, 610, 150, 50);
		p.add(btnEdit);
	
		
		btnLogout = new JButton("");
		btnLogout.setIcon(new ImageIcon(MainTable01.class.getResource("/image/storageList/07.png")));
		btnLogout.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnLogout.setBackground(new Color(73, 153, 221));
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
				
				
				mFr = new FindRacipeTest();
	
				
				
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
				RealChart chart = new RealChart();		
				chart.pack();
				RefineryUtilities.centerFrameOnScreen(chart);
				chart.setVisible(true);
				
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
		
		
		textField = new JLabel();
		textField.setIcon(new ImageIcon(MainTable01.class.getResource("/image/storageList/List-008.png")));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		textField.setBackground(new Color(255, 218, 185));
		
		textField.setBounds(236, 40, 839, 50);
		p.add(textField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(236, 140, 830, 479);
		p.add(scrollPane);
		
		Renderer ren = new Renderer(); 
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(getDataList(), getColumnList()){
			
			
			@Override
			public boolean isCellEditable(int row, int column) {
				
				
				return false; // 모든 cell 편집불가능
			}
		}
				
				
				);
//		table.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
	      dtcr.setHorizontalAlignment(SwingConstants.CENTER);
	      TableColumnModel tcm = table.getColumnModel();
	      for(int i = 0; i < tcm.getColumnCount(); i++) {
	         tcm.getColumn(i).setCellRenderer(dtcr);
	      }
		
	    resizeColumnWidth(table);
	    
	     
		btnRefresh = new JButton("");
		btnRefresh.setIcon(new ImageIcon(MainTable01.class.getResource("/image/storageList/39.png")));
		btnRefresh.setForeground(Color.WHITE);
		btnRefresh.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnRefresh.setBackground(new Color(73, 153, 221));
		btnRefresh.setBounds(963, 100, 103, 32);
		p.add(btnRefresh);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MainTable01.class.getResource("/image/흰배경.png")));
		lblNewLabel.setBounds(0, 0, 1184, 761);
		p.add(lblNewLabel);
		
		btnRefresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jTableRefresh();
				
			}
		});
		
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
		
		if (dday >= -7 && dday < 0) {
		renderer.setForeground(Color.WHITE);
		renderer.setBackground(Color.BLACK);
		} else if (dday <= 0) {
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
		} 
//		else {
//		renderer.setForeground(table.getForeground());
//		renderer.setBackground(table.getBackground());
//		}
		
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
			
			System.out.println(id + this.id);
			
			
			F_Dao fao = new F_Dao();
			fao.goInfo(id, this.id);
			
			jTableRefresh();
			
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
		table.setModel(new DefaultTableModel(getDataList(), getColumnList()){
			
			
			@Override
			public boolean isCellEditable(int row, int column) {
				
				
				return false; // 모든 cell 편집불가능
			}
		}
				);

		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
	      dtcr.setHorizontalAlignment(SwingConstants.CENTER);
	      TableColumnModel tcm = table.getColumnModel();
	      for(int i = 0; i < tcm.getColumnCount(); i++) {
	         tcm.getColumn(i).setCellRenderer(dtcr);
	      }
	      
		TableColumn column = table.getColumnModel().getColumn(6);
		column.setCellRenderer(new ColorRenderer());
		
		resizeColumnWidth(table);
		
		table.repaint();
	}
	
	public void resizeColumnWidth(JTable table) {
		final TableColumnModel columnModel = table.getColumnModel();
		for (int column = 0; column < table.getColumnCount(); column++) {
			int width = 10; // 최소 가로길이
			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer renderer = table.getCellRenderer(row, column);
				Component comp = table.prepareRenderer(renderer, row, column);
				width = Math.max(comp.getPreferredSize().width + 1, width);
			}
			columnModel.getColumn(column).setPreferredWidth(width);
		}
	}
}
