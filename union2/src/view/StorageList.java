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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import org.jfree.ui.RefineryUtilities;

import model.F_DTO;
import model.F_Dao;
import model.ListDao2;
import javax.swing.ImageIcon;

import javax.swing.UIManager;

import javax.swing.JLabel;

public class StorageList implements MouseListener {

	// 필요한 부품준비
	JPanel            p; 
	JPanel            p2; 
	JFrame            f;
				
	JButton           btnInput, btnIngredient, btnRecipe, btnmain, btnAhb;
	
	JButton           classficInput;
	JComboBox         large_classific, middle_classific, small_classific;
	
	//색상수정함
	
	MainTable01 mT01 = null;
	StorageList mSt01 = null;
	FindRacipeTest mFr   = null;
	GroceryInput mGi = null;
	GrocerySearch mGs = null;
	String id, large1, medium1, small1;
	JTable table, table2,table3;
	StorageList slist = null;
	Expire_Output mEo = null;
	
	FindName  mProc = null; 
	static StorageList  mSt = null;
	private JLabel lblNewLabel;

	
	

	
//	public StorageList() {
//		initialize();
//	}

	
	public StorageList(MainTable01 mt012) {
		this.id = mt012.id;
		initialize(id);
	}


	private void initialize(String id) {
		
		this.id = id;
		
		f = new JFrame();
		f.setTitle("보관목록");
		f.setBounds(100, 100, 1200, 800);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.getContentPane().setLayout(null);
		
		p = new JPanel();
		p.setBackground(new Color(255, 255, 255));
		p.setBounds(0, 0, 1184, 761);
		f.getContentPane().add(p);
		p.setLayout(null);
		
		
		
		btnInput = new JButton("");
		btnInput.setIcon(new ImageIcon(StorageList.class.getResource("/image/storageList/01.png")));
	
		btnInput.setForeground(Color.WHITE);
		btnInput.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnInput.setBackground(new Color(73, 153, 221));
		btnInput.setBounds(30, 50, 150, 50);
		p.add(btnInput);
		
		btnIngredient = new JButton("");
		btnIngredient.setIcon(new ImageIcon(StorageList.class.getResource("/image/storageList/02.png")));
		btnIngredient.setForeground(Color.WHITE);
		btnIngredient.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnIngredient.setBackground(new Color(73, 153, 221));
		btnIngredient.setBounds(30, 130, 150, 50);
		p.add(btnIngredient);
		
		btnRecipe = new JButton("");
		btnRecipe.setIcon(new ImageIcon(StorageList.class.getResource("/image/storageList/03.png")));
		btnRecipe.setForeground(Color.WHITE);
		btnRecipe.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnRecipe.setBackground(new Color(73, 153, 221));
		btnRecipe.setBounds(30, 210, 150, 50);
		p.add(btnRecipe);
		
		
		btnmain = new JButton("");
		btnmain.setIcon(new ImageIcon(StorageList.class.getResource("/image/storageList/08.png")));
		btnmain.setForeground(Color.WHITE);
		btnmain.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnmain.setBackground(new Color(73, 153, 221));
		btnmain.setBounds(30, 550, 150, 50);
		p.add(btnmain);
		
		btnAhb = new JButton("");
		btnAhb.setIcon(new ImageIcon(StorageList.class.getResource("/image/storageList/26.png")));
		btnAhb.setForeground(Color.WHITE);
		btnAhb.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnAhb.setBackground(new Color(73, 153, 221));
		btnAhb.setBounds(30, 630, 150, 50);
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
				mEo = new Expire_Output(id);
				
			}
		}); 
		
		btnRecipe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				mFr = new FindRacipeTest();
				
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
			
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
	      dtcr.setHorizontalAlignment(SwingConstants.CENTER);
	      TableColumnModel tcm = table.getColumnModel();
	      for(int i = 0; i < tcm.getColumnCount(); i++) {
	         tcm.getColumn(i).setCellRenderer(dtcr);
	      }
		
		table.getColumnModel().getColumn(0).setMaxWidth(400);
		table.getColumnModel().getColumn(0).setMinWidth(50);
		table.getColumnModel().getColumn(0).setWidth(50);

		table.getColumnModel().getColumn(1).setMaxWidth(400);
		table.getColumnModel().getColumn(1).setMinWidth(50);
		table.getColumnModel().getColumn(1).setWidth(50);
		
		table.getColumnModel().getColumn(2).setMaxWidth(400);
		table.getColumnModel().getColumn(2).setMinWidth(50);
		table.getColumnModel().getColumn(2).setWidth(50);
		
		table.getColumnModel().getColumn(3).setMaxWidth(400);
		table.getColumnModel().getColumn(3).setMinWidth(10);
		table.getColumnModel().getColumn(3).setWidth(10);

		table.getColumnModel().getColumn(4).setMaxWidth(400);
		table.getColumnModel().getColumn(4).setMinWidth(200);
		table.getColumnModel().getColumn(4).setWidth(200);
		
		table.getColumnModel().getColumn(5).setMaxWidth(400);
		table.getColumnModel().getColumn(5).setMinWidth(10);
		table.getColumnModel().getColumn(5).setWidth(10);

		table.getColumnModel().getColumn(6).setMaxWidth(400);
		table.getColumnModel().getColumn(6).setMinWidth(10);
		table.getColumnModel().getColumn(6).setWidth(10);
		
		table.getColumnModel().getColumn(7).setMaxWidth(400);
		table.getColumnModel().getColumn(7).setMinWidth(50);
		table.getColumnModel().getColumn(7).setWidth(50);
		
		table.getColumnModel().getColumn(8).setMaxWidth(400);
		table.getColumnModel().getColumn(8).setMinWidth(100);
		table.getColumnModel().getColumn(8).setWidth(100);
		
		table.getColumnModel().getColumn(9).setMaxWidth(400);
		table.getColumnModel().getColumn(9).setMinWidth(100);
		table.getColumnModel().getColumn(9).setWidth(100);
		
		table.getColumnModel().getColumn(10).setMaxWidth(400);
		table.getColumnModel().getColumn(10).setMinWidth(10);
		table.getColumnModel().getColumn(10).setWidth(10);
		
		table.addMouseListener(this);
			
			JScrollPane scrollPane1 = new JScrollPane();
			scrollPane1.setBounds(236, 140, 830, 479);
			p.add(scrollPane1);
			scrollPane1.setViewportView(table);
			
			p2 = new JPanel();
			p2.setBackground(new Color(255, 255, 255));
			p2.setForeground(new Color(255, 255, 255));
			p2.setBounds(236, 62, 830, 68);
			p.add(p2);
			p2.setLayout(null);
			p2.setBorder(new TitledBorder(null, "\uC2DD\uC790\uC7AC \uAC80\uC0C9", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			
			F_Dao fao = new F_Dao();
			Vector<String> large = fao.getLarge();
			
			large_classific = new JComboBox(large);
			large_classific.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
			large_classific.setBackground(new Color(250, 250, 250));
			large_classific.setToolTipText("대분류");
			large_classific.setBounds(40, 25, 150, 33);
			p2.add(large_classific);
			
			middle_classific = new JComboBox(new String [] {"중분류"});
			middle_classific.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
			middle_classific.setBackground(new Color(250, 250, 250));
			middle_classific.setToolTipText("중분류");
			middle_classific.setBounds(240, 25, 150, 33);
			p2.add(middle_classific);
			
			small_classific = new JComboBox(new String [] {"소분류"});
			small_classific.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
			small_classific.setBackground(new Color(250, 250, 250));
			small_classific.setToolTipText("소분류");
			small_classific.setBounds(440, 25, 150, 33);
			p2.add(small_classific);
			
			classficInput = new JButton("");
			classficInput.setBackground(new Color(73, 153, 221));
			classficInput.setIcon(new ImageIcon(StorageList.class.getResource("/image/storageList/09.png")));
			
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
			
			classficInput.setForeground(new Color(135, 206, 250));
			classficInput.setToolTipText("확인");
			classficInput.setBounds(630, 25, 118, 33);
			p2.add(classficInput);
			
			JButton resetInput = new JButton("");
			resetInput.setBackground(new Color(73, 153, 221));
			resetInput.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					large_classific.setSelectedItem("대분류");
					middle_classific.setSelectedItem("중분류");
					small_classific.setSelectedItem("소분류");
					
					table.setModel(
							new DefaultTableModel( getDataList(), getColumnList() )	{

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
					
					
					
				}
			});
			resetInput.setIcon(new ImageIcon(StorageList.class.getResource("/image/free-icon-reset-5307970 (1).png")));
			resetInput.setForeground(new Color(135, 206, 250));
			resetInput.setToolTipText("리셋");
			resetInput.setBounds(764, 25, 33, 33);
			p2.add(resetInput);
			
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon(StorageList.class.getResource("/image/\uD770\uBC30\uACBD.png")));
			lblNewLabel.setBounds(0, 0, 1196, 774);
			p.add(lblNewLabel);
		
			
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

			Vector<Vector> list = new Vector<Vector>();

			large1 = (String) large_classific.getSelectedItem();
			medium1 = (String) middle_classific.getSelectedItem();
			small1 = (String) small_classific.getSelectedItem();
			
			if (small1 != "소분류") {
				F_Dao fao = new F_Dao();
				list = fao.getSmallFilter(large1, medium1, small1, id);
				System.out.println(large1 + medium1 + small1 + id);
			} else if (small1.equals("소분류") && medium1 != "중분류") {
				F_Dao fao = new F_Dao();
				list = fao.getMediumFilter(large1, medium1, small1, id);
				System.out.println(large1 + medium1 + small1 + id);
			} else if (medium1.equals("중분류") && large1 != "대분류") {
				F_Dao fao = new F_Dao();
				list = fao.getLargeFilter(large1, medium1, small1, id);
				System.out.println(large1 + medium1 + small1 + id);
			} else {
				JOptionPane.showMessageDialog(null, "필터를 선택하지 않으셨습니다.");
				list = getDataList();
			}
			System.out.println(list);
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
			
			table.getColumnModel().getColumn(0).setMaxWidth(400);
			table.getColumnModel().getColumn(0).setMinWidth(50);
			table.getColumnModel().getColumn(0).setWidth(50);

			table.getColumnModel().getColumn(1).setMaxWidth(400);
			table.getColumnModel().getColumn(1).setMinWidth(50);
			table.getColumnModel().getColumn(1).setWidth(50);
			
			table.getColumnModel().getColumn(2).setMaxWidth(400);
			table.getColumnModel().getColumn(2).setMinWidth(50);
			table.getColumnModel().getColumn(2).setWidth(50);
			
			table.getColumnModel().getColumn(3).setMaxWidth(400);
			table.getColumnModel().getColumn(3).setMinWidth(10);
			table.getColumnModel().getColumn(3).setWidth(10);

			table.getColumnModel().getColumn(4).setMaxWidth(400);
			table.getColumnModel().getColumn(4).setMinWidth(200);
			table.getColumnModel().getColumn(4).setWidth(200);
			
			table.getColumnModel().getColumn(5).setMaxWidth(400);
			table.getColumnModel().getColumn(5).setMinWidth(10);
			table.getColumnModel().getColumn(5).setWidth(10);

			table.getColumnModel().getColumn(6).setMaxWidth(400);
			table.getColumnModel().getColumn(6).setMinWidth(10);
			table.getColumnModel().getColumn(6).setWidth(10);
			
			table.getColumnModel().getColumn(7).setMaxWidth(400);
			table.getColumnModel().getColumn(7).setMinWidth(50);
			table.getColumnModel().getColumn(7).setWidth(50);
			
			table.getColumnModel().getColumn(8).setMaxWidth(400);
			table.getColumnModel().getColumn(8).setMinWidth(100);
			table.getColumnModel().getColumn(8).setWidth(100);
			
			table.getColumnModel().getColumn(9).setMaxWidth(400);
			table.getColumnModel().getColumn(9).setMinWidth(100);
			table.getColumnModel().getColumn(9).setWidth(100);
			
			table.getColumnModel().getColumn(10).setMaxWidth(400);
			table.getColumnModel().getColumn(10).setMinWidth(10);
			table.getColumnModel().getColumn(10).setWidth(10);
			
			table.repaint();
		}
}