package model;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Renderer extends DefaultTableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
		
		String val1 = String.valueOf(table.getValueAt(row, column));
		System.out.println(val1);
//		int val2 = Integer.parseInt(val1);
		
		switch (val1) {
		case "7" :
		case "6" :
		case "5" : 
			c.setBackground(Color.green);
			c.setForeground(Color.white);
			break;
		case "4" :
		case "3" :
		case "2" :
			c.setBackground(Color.yellow);
			c.setForeground(Color.black);
			break;
		case "1" :
		case "0" :
			c.setBackground(Color.red);
			c.setForeground(Color.white);
			break;
		default :
			c.setBackground(Color.blue);
			c.setForeground(Color.black);
		}
		
		return c;
	}
	
}
