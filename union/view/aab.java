package view;

import javax.swing.JFrame;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class aab extends JFrame {
	private JTable table;
	private JTable table_1;
	
	public aab() {
		setTitle("냉장고를 부탁해");
		
		init();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1000,600);
		getContentPane().setLayout(null);
		
	}
	private void init() {
		
		
		JButton btnNewButton = new JButton("월간 지출 정보");
		btnNewButton.setBounds(12, 10, 118, 87);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("연간 지출 정보");
		btnNewButton_1.setBounds(12, 107, 118, 87);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("폐기 정보");
		btnNewButton_1_1.setBounds(12, 204, 118, 87);
		getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("메인 화면");
		btnNewButton_1_2.setBounds(12, 370, 118, 87);
		getContentPane().add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("보관 목록");
		btnNewButton_1_3.setBounds(12, 464, 118, 87);
		getContentPane().add(btnNewButton_1_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(164, 100, 765, 388);
		getContentPane().add(scrollPane);
		
		
		UtilDateModel model1 = new UtilDateModel();
		JDatePanelImpl datePanel1 = new JDatePanelImpl(model1);
		JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1);
		getContentPane().add(datePicker1);
		datePicker1.setBounds(363, 22, 186, 40);
		
		UtilDateModel model2 = new UtilDateModel();
		JDatePanelImpl datePanel2 = new JDatePanelImpl(model2);
		JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2);
		getContentPane().add(datePicker2);
		datePicker1.setBounds(159, 17, 186, 40);
		
	}
	public static void main(String[] args) {
		new aab();
	}
}
