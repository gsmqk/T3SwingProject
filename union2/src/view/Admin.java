package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


import model.U_Dao;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JLabel;

public class Admin extends JFrame implements MouseListener, ActionListener {
        
	JTable       jTable;
	JScrollPane  pane;
	JButton      btnRefresh, btnCategory;
	JPanel       topPane, ta;
	
	AdminEdit aEdit = null;
	static Admin list = null;
	
	public Admin() {
		
		initComponent();
		
		setTitle("회원관리");
		setSize(600,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	//22222222222222222222222222222222222222222222222222222222222
	}

	private void initComponent() {
		topPane = new JPanel();
		btnRefresh  = new JButton("새로고침");
		topPane.add(btnRefresh);
		btnCategory = new JButton("카테고리");
		topPane.add(btnCategory);
		
		getContentPane().add(topPane, BorderLayout.NORTH);
		
		jTable = new JTable();
		jTable.setModel(new DefaultTableModel(getDataList(),getColumnList()));
		
		jTable.addMouseListener(this);
		
		pane = new JScrollPane(jTable);
		getContentPane().add(pane);
		
		btnRefresh.addActionListener(this);
		btnCategory.addActionListener(this);
	}
	

	private Vector<Vector> getDataList() {
		U_Dao dao  = new U_Dao();
		Vector<Vector>  list = dao.getMemberList();
		
		return list;
	}

	private Vector<String> getColumnList() {
		Vector<String> cols = new Vector<>();
		cols.add("아이디");
		cols.add("이름");
		cols.add("비밀번호");
		cols.add("이메일");
		cols.add("유저상태");
		
		
		return cols;
	}


	

	public static void main(String[] args) {
		list = new Admin();

	}

	// jTable 에 마우스 리스너 연결해서 클릭효과만들기
	@Override
	public void mouseClicked(MouseEvent e) {
		
		int row = jTable.getSelectedRow();
		int col = jTable.getSelectedColumn();
		String id = (String)jTable.getValueAt(row, 0);
		System.out.println( e );
		if(aEdit != null)
			aEdit.dispose();
		aEdit = new AdminEdit(id, this);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}//ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ

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

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch(e.getActionCommand()) {
		case "새로고침":
			System.out.println("새로고침 클릭");
			JTableRefresh();
			break;
		}
		
	}

	public void JTableRefresh() {
		jTable.setModel(
				new DefaultTableModel( getDataList(), getColumnList()) {

					@Override
					public boolean isCellEditable(int row, int column) {
						
						return false;
					}
					
				});
		
		jTable.repaint();
	}



}

















