package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JLabel;

public class admin extends JFrame {
        
	JTable       jTable;
	JScrollPane  pane;
	JButton      btnRefresh, btnCategory;
	JPanel       topPane;
	
	public admin() {
		
		initComponent();
		
		setTitle("회원관리");
		setSize(600,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
	}

	private void initComponent() {
		topPane = new JPanel();
		btnRefresh  = new JButton("새로고침");
		btnCategory = new JButton("카테고리");
		topPane.add(btnRefresh);
		topPane.add(btnCategory);
		
		this.add(topPane, BorderLayout.NORTH);
		
		jTable = new JTable();
		jTable.setModel(new DefaultTableModel(getDataList(),getColumnList()));
		pane = new JScrollPane(jTable);
		this.add(pane);
		
	}
	

	private Vector<? extends Vector> getDataList() {
		// TODO Auto-generated method stub
		return null;
	}

	private Vector<String> getColumnList() {
		Vector<String> cols = new Vector<>();
		cols.add("아이디");
		cols.add("비밀번호");
		cols.add("이름");
		cols.add("이메일");
		
		return cols;
	}


	

	public static void main(String[] args) {
		new admin();

	}

}


















