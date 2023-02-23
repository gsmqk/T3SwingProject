package view;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FindName extends JFrame {
	
	JLabel        lblName;
	JTextField    txtName;
	JButton       btnFind;
	JTextArea     taResult;
	
	
	
	public  FindName() {
		setTitle("이름 찾기");
		
		initComponent();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(300, 300);
		pack();
		setVisible(true);				
	}
	
	private void initComponent() {
		
		GridBagLayout     gbl = new GridBagLayout();
		this.setLayout( gbl );
		
		this.lblName       =  new JLabel("이름");
		this.txtName       =  new JTextField(10);
		this.btnFind       =  new JButton("찾기");
		this.taResult      =  new JTextArea(10, 15);
		JScrollPane    sp  =  new JScrollPane( taResult );   
		
		// 조건 지정 
		GridBagConstraints  []  gbc  = new GridBagConstraints[4];
		
		gbc[0]           =  new GridBagConstraints();
		gbc[0].gridx     =  0;
		gbc[0].gridy     =  0;
		this.add(lblName, gbc[0]);
		
		gbc[1]             =  new GridBagConstraints();
		gbc[1].gridx       =  1;
		gbc[1].gridy       =  0;
		this.add(txtName, gbc[1]);
		
		gbc[2]             =  new GridBagConstraints();
		gbc[2].gridx       =  2;
		gbc[2].gridy       =  0;
		this.add(btnFind, gbc[2]);
		
		gbc[3]             =  new GridBagConstraints();
		gbc[3].gridx       =  0;
		gbc[3].gridy       =  1;
		gbc[3].gridwidth   =  3;     // 가로 병합 3칸 합치기  colspan
		// gbc[3].gridheight  =  2;  // 세로 병합 2줄 합치기  rowspan
		// this.add( taResult , gbc[3]);
		this.add( sp , gbc[3]);
		
		// 기능연결 -  이벤트 지정
		
		ActionListener  btnFindClick = new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = txtName.getText();
				System.out.println( str );	
				taResult.append(str + "\n");
				txtName.setText("");
				txtName.requestFocus();
			}
		};
		this.btnFind.addActionListener( btnFindClick );
			
		KeyListener  taKeyPress  =  new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {				
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				//System.out.println( e.getKeyCode() );
				if( e.getKeyCode() == KeyEvent.VK_ENTER ) {  // 10: enter key
					btnFind.doClick();			
				}
			}
		};
		this.txtName.addKeyListener( taKeyPress );
		
	}
	
	
	public static void main(String[] args) {
		new FindName();

	}

}
