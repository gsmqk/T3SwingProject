package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.G_Dao;
import java.awt.Color;
import java.awt.Font;

public class CategoryTable extends JFrame implements ActionListener {

	
	JButton      largeAdd, mediumAdd, smallAdd, cleanBtn, refreshBtn;
	JPanel       topPane, south, east, west;
	JTable       jTable;
	JScrollPane  pane;
	
	public CategoryTable() {
		initComponent();

		setTitle("카테고리");
		setSize(800,700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
	private void initComponent() {
		topPane = new JPanel();
		topPane.setBackground(new Color(255, 255, 255));
		largeAdd = new JButton("대분류추가");
		largeAdd.setBackground(new Color(238, 251, 255));
		largeAdd.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		topPane.add(largeAdd);
		mediumAdd = new JButton("중분류추가");
		mediumAdd.setBackground(new Color(238, 251, 255));
		mediumAdd.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		topPane.add(mediumAdd);
		smallAdd = new JButton("소분류추가");
		smallAdd.setBackground(new Color(238, 251, 255));
		smallAdd.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		topPane.add(smallAdd);
		refreshBtn = new JButton("  새로고침  ");
		refreshBtn.setBackground(new Color(238, 251, 255));
		refreshBtn.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		topPane.add(refreshBtn);
		cleanBtn = new JButton("      닫기      ");
		cleanBtn.setBackground(new Color(238, 251, 255));
		cleanBtn.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		topPane.add(cleanBtn);
		
		south = new JPanel();
		south.setBackground(new Color(255, 255, 255));
		east = new JPanel();
		east.setBackground(new Color(255, 255, 255));
		west = new JPanel();
		west.setBackground(new Color(255, 255, 255));
		getContentPane().add(south, BorderLayout.SOUTH);
		getContentPane().add(east, BorderLayout.EAST);
		getContentPane().add(west, BorderLayout.WEST);
		
		
		getContentPane().add(topPane, BorderLayout.NORTH);
		
		jTable = new JTable();
		jTable.setModel(new DefaultTableModel(getDataList(),getColumnList()));
		getContentPane().add(jTable);
		
		pane = new JScrollPane(jTable);
		getContentPane().add(pane);
		
		largeAdd.addActionListener(this);
		mediumAdd.addActionListener(this);
		smallAdd.addActionListener(this);
		refreshBtn.addActionListener(this);
		cleanBtn.addActionListener(this);
		//완성ㅇㅇ
	}
	private Vector<String> getColumnList() {
		Vector<String> cols = new Vector<>();
		cols.add("대분류 id");
		cols.add("대분류");
		cols.add("중분류 id");
		cols.add("중분류");
		cols.add("소분류 id");
		cols.add("소분류");
		
		return cols;
	}


	private Vector<Vector> getDataList() {
		G_Dao gdao = new G_Dao();
		Vector<Vector> glist = gdao.getGrocerylist();
		
		return glist;
	}


	public static void main(String[] args) {
		new CategoryTable();

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch(e.getActionCommand()) {
		case "대분류추가":
			new Large_Add();
			break;
		case "중분류추가":
			new Medium_Add();
			break;
		case "소분류추가":
			System.out.println();
			new Small_Add();
			System.out.println();
			break;
		case "새로고침":	
			
			refresh();
			System.out.println("새로고침클릭");
			break;
		case "닫기":
			dispose();
			break;	
		}
		
	}

	private void refresh() {
		jTable.setModel(
				new DefaultTableModel( getDataList(), getColumnList()) {
					
					@Override
					public boolean isCellEditable(int row, int column) {		
						return false;
					}	
				});
	
		jTable.repaint();
		
	}


	public void JTableRefresh() {
		jTable.setModel(
				new DefaultTableModel( getDataList(), getColumnList()) {
					
					@Override
					public boolean isCellEditable(int row, int column) {		
						return false;
					}	
				});
		System.out.println("새로고침클릭");
		jTable.repaint();
	}
	
	
	
}
