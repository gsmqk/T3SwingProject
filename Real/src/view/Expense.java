package view;

import javax.swing.JFrame;

public class Expense extends JFrame {

	public Expense() {
		setTitle("냉장고를 부탁해");
		
		init();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1000,600);
		setVisible(true);
	}
	
	private void init() {
		
		
		
	}

	public static void main(String[] args) {
		new Expense();
		
	}

}
