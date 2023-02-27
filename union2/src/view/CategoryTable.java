package view;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.G_Dao;

public class CategoryTable extends JFrame {

	
	JButton      addBtn, cleanBtn;
	JPanel       topPane;
	JTable       jTable;
	JScrollPane  pane;
	
	public CategoryTable() {
		initComponent();

		setTitle("카테고리");
		setSize(600,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
	private void initComponent() {
		topPane = new JPanel();
		addBtn = new JButton("추가");
		topPane.add(addBtn);
		cleanBtn = new JButton("취소");
		topPane.add(cleanBtn);
		
		getContentPane().add(topPane, BorderLayout.NORTH);
		
		jTable = new JTable();
		jTable.setModel(new DefaultTableModel(getDataList(),getColumnList()));
		add(jTable);
		
		pane = new JScrollPane(jTable);
		getContentPane().add(pane);
		
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

	public void JTableRefresh() {
		
	}
}
