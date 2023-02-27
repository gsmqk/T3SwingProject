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

public class CategoryTable extends JFrame implements ActionListener {

	
	JButton      largeAdd, mediumAdd, smallAdd, cleanBtn;
	JPanel       topPane;
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
		largeAdd = new JButton("대분류추가");
		topPane.add(largeAdd);
		mediumAdd = new JButton("중분류추가");
		topPane.add(mediumAdd);
		smallAdd = new JButton("소분류추가");
		topPane.add(smallAdd);
		cleanBtn = new JButton("닫기");
		topPane.add(cleanBtn);
		
		getContentPane().add(topPane, BorderLayout.NORTH);
		
		jTable = new JTable();
		jTable.setModel(new DefaultTableModel(getDataList(),getColumnList()));
		add(jTable);
		
		pane = new JScrollPane(jTable);
		getContentPane().add(pane);
		
		largeAdd.addActionListener(this);
		mediumAdd.addActionListener(this);
		smallAdd.addActionListener(this);
		cleanBtn.addActionListener(this);
		
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
			new Small_Add();
			break;
		case "닫기":
			dispose();
			break;
			
		}
		
	}
	
	
}
