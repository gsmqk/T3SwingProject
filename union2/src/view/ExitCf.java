package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.U_DTO;
import model.U_Dao;

public class ExitCf extends JFrame implements ActionListener {

	GridBagLayout gbl;
	GridBagConstraints gbc;
	Font f1;
	String id;
	
	public ExitCf() {
		setTitle("회원탈퇴 확인");
		
		init();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500,700);
		setVisible(true);
	}
	
	public ExitCf(String id) {
		this.id = id;
		
		setTitle("회원탈퇴 확인");
		
		init();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500,700);
		setVisible(true);
		
	}

	private void init() {
		
		gbl = new GridBagLayout();
		this.setLayout(gbl);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		f1 = new Font("HY견고딕", Font.BOLD, 40);
		
		JLabel title = new JLabel("정말 탈퇴하시겠습니까?");
		title.setFont(f1);
		title.setHorizontalAlignment(JLabel.CENTER);
		gblAdd(title, 0, 0, 4, 1);
		
		JButton yes = new JButton("네");
		JButton no = new JButton("아니오");
		
		gblAdd(yes, 0, 1, 2, 1);
		gblAdd(no, 2, 1, 2, 1);
		
		no.addActionListener(this);
		yes.addActionListener(this);
		
	}
	
	public void gblAdd(JComponent c, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gbl.setConstraints(c, gbc);
		gbc.insets = new Insets(5,5,5,5);
		this.add(c,gbc);
	}

//	public static void main(String[] args) {
//		new ExitCf();
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "아니오" : 
			JOptionPane.showMessageDialog(null, "취소하셨습니다.");
			this.dispose();
			break;
		case "네" :
			System.out.println("탈퇴 확인");
			deleteUser();
			JOptionPane.showMessageDialog(null, "탈퇴되었습니다. 이용해주셔서 감사합니다.");
			System.exit(1);;
			break;
		}
		
	}

	private void deleteUser() {
		U_Dao uao = new U_Dao();
		int aftcnt = 0;
		String id = this.id; 
		aftcnt = uao.removeUser(id);
	}

}
