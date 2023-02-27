package view;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.F_Dao;
import model.ListDao2;

public class StorageList implements MouseListener {

	// 필요한 부품준비
	JPanel            p; 
	JFrame            f;
				
	JButton           btnInput, btnIngredient, btnRecipe, btnmain, btnAhb;
	
	MainTable01 mT01 = null;
	StorageList mSt01 = null;
	FindRecipe mFr   = null;
	GroceryInput mGi = null;
	GrocerySearch mGs = null;
	String id;
	private JTable table;
	StorageList slist = null;
	
	FindName  mProc = null; 
	static StorageList  mSt = null;

	
	

	
	public StorageList() {
		initialize();
	}

	
	public StorageList(MainTable01 mt012) {
		this.id = mt012.id;
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
		
		slist = this;
		
		btnInput.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mGi != null)
					mGi.dispose();
				mGi = new GroceryInput(slist);
				
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
				mT01 = new MainTable01(slist);
				
			}
		}); 
		btnAhb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		}); 
		
		
		table = new JTable();
		table.setModel(
				new DefaultTableModel( getDataList(), getColumnList() )	{

					// 기본 option 설정 - 각 cell 에 대한 편집가능여부 : isCellEditable
					@Override
					public boolean isCellEditable(int row, int column) {
						//int currLine = jTable.getSelectedRow(); // 선택한 줄만 수정
						//if(row == currLine)
						//	return true;
						//if(column == 0)
						//	return true;
						return false; // 모든 cell 편집불가능
					}
				}
			);
			
		table.addMouseListener(this);
			
			JScrollPane scrollPane1 = new JScrollPane();
//			scrollPane.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseClicked(MouseEvent e) {
//					table.addMouseListener(this);
//					
//					pane = new JScrollPane(table);
//					table.add(pane);
//				}
//			});
			scrollPane1.setBounds(236, 140, 830, 479);
			p.add(scrollPane1);
			scrollPane1.setViewportView(table);
			table.addMouseListener(this);
			


			
		}
		private Vector<Vector> getDataList() {
			ListDao2        dao   = new ListDao2();
			Vector<Vector> list  = dao.getList(id);
			return list;
		}
		
		private Vector<String> getColumnList(){
			Vector<String>   cols = new Vector<>(); // 문자배열
			cols.add("대분류");
			cols.add("중분류");
			cols.add("소분류");
			cols.add("보관장소");
			cols.add("상품명");
			cols.add("수량");
			cols.add("단위");
			cols.add("구매처");
			cols.add("입고일");
			cols.add("소비기한");
			cols.add("만기일");
			
			return cols;
		}
		public static void main(String[] args) {
			new StorageList();
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			
			int row = table.getSelectedRow();
			int col = table.getSelectedColumn();
			String id = (String) table.getValueAt(row, 4);
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
