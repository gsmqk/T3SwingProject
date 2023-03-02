package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.ListDao2;

public class Expire_Output {

	JFrame f;
	JPanel p;
	JTable table;
	String id;
	
	public Expire_Output(String id) {
		this.id = id;
		
		initialize(this.id);
	}

	private void initialize(String id) {
		
		f = new JFrame();
		f.setTitle("폐기/출고 목록");
		f.setBounds(100, 100, 800, 800);
		f.setVisible(true);
		f.getContentPane().setLayout(null);
		
		p = new JPanel();
		p.setBounds(0, 0, 784, 761);
		f.getContentPane().add(p);
		p.setLayout(null);
		
		JButton btnNewButton = new JButton("폐기");
		btnNewButton.setBounds(183, 75, 110, 40);
		btnNewButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				table.setModel(
						new DefaultTableModel( getDataListEX(), getColumnListEX())	{

							@Override
							public boolean isCellEditable(int row, int column) {
								return false; // 모든 cell 편집불가능
							}
						}
					);
				
			}
		});
		p.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("출고");
		btnNewButton_1.setBounds(496, 75, 110, 40);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				table.setModel(
						new DefaultTableModel( getDataListEO(), getColumnListEO() )	{

							@Override
							public boolean isCellEditable(int row, int column) {
								return false; // 모든 cell 편집불가능
							}
						}
					);
				
			}
		});
		p.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 125, 719, 626);
		p.add(scrollPane);
		
		table = new JTable();
		table.setModel(
				new DefaultTableModel( getDataListEX(), getColumnListEX() )	{

					@Override
					public boolean isCellEditable(int row, int column) {
						return false; // 모든 cell 편집불가능
					}
				}
			);
		scrollPane.setViewportView(table);
	}

	private Vector<String> getColumnListEO() {
		
		Vector<String>   cols = new Vector<>(); // 문자배열
		cols.add("상품명");
		cols.add("분류");
		cols.add("재고량");
		cols.add("단위");
		cols.add("폐기날짜");

		
		return cols;
	}
	private Vector<String> getColumnListEX() {
		
		Vector<String>   cols = new Vector<>(); // 문자배열
		cols.add("상품명");
		cols.add("분류");
		cols.add("재고량");
		cols.add("단위");
		cols.add("사유");		
		cols.add("폐기날짜");
		
		
		return cols;
	}

	private Vector<Vector> getDataListEO() {
		ListDao2        dao   = new ListDao2();
		Vector<Vector> list   = dao.getGoList(id);
		
		return list;
		
	}
	private Vector<Vector> getDataListEX() {
		ListDao2        dao   = new ListDao2();
		Vector<Vector> list   = dao.getGeList(id);
		
		return list;
		
	}


//	public static void main(String[] args) {
//		new Expire_Output();
//	}

	
}
