package view;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CategoryTable extends JFrame {

	
	JButton      addBtn, cleanBtn;
	JPanel       topPane;
	JTable       jTable;
	
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
		
	}
	private Vector<String> getColumnList() {
		Vector<String> cols = new Vector<>();
		cols.add("id");
		cols.add("대분류");
		cols.add("id");
		cols.add("중분류");
		cols.add("id");
		cols.add("소분류");
		
		return cols;
	}


	private Vector<? extends Vector> getDataList() {
		// TODO Auto-generated method stub
		return null;
	}


	public static void main(String[] args) {
		new CategoryTable();

	}

}
