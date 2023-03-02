package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

import org.jfree.ui.RefineryUtilities;

import model.F_DTO;
import model.F_Dao;
import model.ListDao2;
import javax.swing.ImageIcon;

public class StorageList implements MouseListener {

	// 필요한 부품준비
	JPanel            p; 
	JPanel            p2; 
	JFrame            f;
				
	JButton           btnInput, btnIngredient, btnRecipe, btnmain, btnAhb;
	
	JButton           classficInput;
	JComboBox         large_classific, middle_classific, small_classific;
	
	
	
	MainTable01 mT01 = null;
	StorageList mSt01 = null;
	FindRecipe mFr   = null;
	GroceryInput mGi = null;
	GrocerySearch mGs = null;
	String id, large1, medium1, small1;
	JTable table, table2,table3;
	StorageList slist = null;
	
	FindName  mProc = null; 
	static StorageList  mSt = null;

	
	

	
//	public StorageList() {
//		initialize();
//	}

	
	public StorageList(MainTable01 mt012) {
		this.id = mt012.id;
		initialize();
	}


	private void initialize() {
		
		this.id = id;
		
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
		
		btnAhb = new JButton("연간 그래프");
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
				RealChart chart = new RealChart();		
				chart.pack();
				RefineryUtilities.centerFrameOnScreen(chart);
				chart.setVisible(true);
				
			}
		}); 
		
		
		table = new JTable();
		table.setModel(
				new DefaultTableModel( getDataList(), getColumnList() )	{

					@Override
					public boolean isCellEditable(int row, int column) {
						
						
						return false; // 모든 cell 편집불가능
					}
				}
			);
			
		table.addMouseListener(this);
			
			JScrollPane scrollPane1 = new JScrollPane();
			scrollPane1.setBounds(236, 140, 830, 479);
			p.add(scrollPane1);
			scrollPane1.setViewportView(table);
			
			p2 = new JPanel();
			p2.setBounds(236, 62, 830, 68);
			p.add(p2);
			p2.setLayout(null);
			p2.setBorder(new TitledBorder(null, "\uC2DD\uC790\uC7AC \uAC80\uC0C9", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			
			F_Dao fao = new F_Dao();
			Vector<String> large = fao.getLarge();
			
			large_classific = new JComboBox(large);
			large_classific.setToolTipText("대분류");
			large_classific.setBounds(40, 25, 150, 33);
			p2.add(large_classific);
			
			middle_classific = new JComboBox(new String [] {"중분류"});
			middle_classific.setToolTipText("중분류");
			middle_classific.setBounds(240, 25, 150, 33);
			p2.add(middle_classific);
			
			small_classific = new JComboBox(new String [] {"소분류"});
			small_classific.setToolTipText("소분류");
			small_classific.setBounds(440, 25, 150, 33);
			p2.add(small_classific);
			
			classficInput = new JButton("확인");	
			
			classficInput.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					table.setModel(
							new DefaultTableModel( getFilterList(), getColumnList() )	{

								@Override
								public boolean isCellEditable(int row, int column) {
									return false; // 모든 cell 편집불가능
								}
							}
						);
					
				}
			});
			
			
			classficInput.setToolTipText("확인");
			classficInput.setBounds(630, 25, 118, 33);
			p2.add(classficInput);
			
			JButton resetInput = new JButton("");
			resetInput.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					table.setModel(
							new DefaultTableModel( getDataList(), getColumnList() )	{

								@Override
								public boolean isCellEditable(int row, int column) {
									return false; // 모든 cell 편집불가능
								}
							}
						);
				}
			});
			resetInput.setIcon(new ImageIcon(StorageList.class.getResource("/image/free-icon-reset-5307970 (1).png")));
			resetInput.setToolTipText("리셋");
			resetInput.setBounds(764, 25, 33, 33);
			p2.add(resetInput);
		
			
			large_classific.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					String selectedItem = (String) large_classific.getSelectedItem();
					Vector<String> mList1 = new Vector<String>();
					
					if (selectedItem != null) {
						mList1 = fao.getMiddle(selectedItem);
						System.out.println(mList1);
						middle_classific.setModel(new DefaultComboBoxModel<>(mList1));
					}
				}
					
			});
			
			middle_classific.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					String selectedItem = (String) middle_classific.getSelectedItem();
					Vector<String> sList1 = new Vector<String>();
					
					if (selectedItem != null) {
						sList1 = fao.getSmall(selectedItem);
						System.out.println(sList1);
						small_classific.setModel(new DefaultComboBoxModel<>(sList1));
					}
					
				}
			});
			
		}

		protected Vector<Vector> getFilterList() {
			F_Dao fao = new F_Dao();
			large1 = (String) large_classific.getSelectedItem();
			medium1 = (String) middle_classific.getSelectedItem();
			small1 = (String) small_classific.getSelectedItem();
			Vector<Vector> list = fao.getFilter(large1, medium1, small1, id);
			System.out.println(large1 + medium1 + small1 + id);
			return list;
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
//		public static void main(String[] args) {
//			new StorageList();
//		}

		@Override
		public void mouseClicked(MouseEvent e) {
			
			int row = table.getSelectedRow();
			int col = table.getSelectedColumn();
			String id = (String) table.getValueAt(row, 4);
			System.out.println(e);
			
			System.out.println(id);
			System.out.println(this.id);
			
			F_Dao fao = new F_Dao();
			fao.goInfo(id, this.id);
			
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
		
		
		
		
		
		private F_DTO getGroceryData(String id) {
			String large = (String) this.large_classific.getSelectedItem();
			String middle = (String) this.middle_classific.getSelectedItem();
			String small = (String) this.small_classific.getSelectedItem();
			String uid = this.id;
			System.out.println(uid);
			int f = 1;

			F_DTO fto = new F_DTO();

			return fto;
		}
		
		public void jTableRefresh() {
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
			table.repaint();
		}
}