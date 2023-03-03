package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import model.ListDao2;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Expire_Output {

	JFrame f;
	JPanel p;
	JTable table;
	String id;
	private JLabel lblNewLabel;
	
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
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Expire_Output.class.getResource("/image/storageList/10.png")));
		btnNewButton.setBackground(new Color(73, 153, 221));
		btnNewButton.setBounds(181, 63, 150, 50);
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
				
				resizeColumnWidth(table);
				
				
				DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
			      dtcr.setHorizontalAlignment(SwingConstants.CENTER);
			      TableColumnModel tcm = table.getColumnModel();
			      for(int i = 0; i < tcm.getColumnCount(); i++) {
			         tcm.getColumn(i).setCellRenderer(dtcr);
			      }
			}
		});
		p.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(Expire_Output.class.getResource("/image/storageList/11.png")));
		btnNewButton_1.setBackground(new Color(73, 153, 221));
		btnNewButton_1.setBounds(494, 63, 150, 50);
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
				
				resizeColumnWidth(table);
				
				DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
			      dtcr.setHorizontalAlignment(SwingConstants.CENTER);
			      TableColumnModel tcm = table.getColumnModel();
			      for(int i = 0; i < tcm.getColumnCount(); i++) {
			         tcm.getColumn(i).setCellRenderer(dtcr);
			      }
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

		resizeColumnWidth(table);
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
	      dtcr.setHorizontalAlignment(SwingConstants.CENTER);
	      TableColumnModel tcm = table.getColumnModel();
	      for(int i = 0; i < tcm.getColumnCount(); i++) {
	         tcm.getColumn(i).setCellRenderer(dtcr);
	      }
		
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Expire_Output.class.getResource("/image/흰배경.png")));
		lblNewLabel.setBounds(0, 0, 784, 761);
		p.add(lblNewLabel);
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

	public void resizeColumnWidth(JTable table) {
		final TableColumnModel columnModel = table.getColumnModel();
		for (int column = 0; column < table.getColumnCount(); column++) {
			int width = 10; // 최소 가로길이
			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer renderer = table.getCellRenderer(row, column);
				Component comp = table.prepareRenderer(renderer, row, column);
				width = Math.max(comp.getPreferredSize().width + 1, width);
			}
			columnModel.getColumn(column).setPreferredWidth(width);
		}
	}
	
}
