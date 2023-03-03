package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.U_Dao;
import java.awt.Color;

public class Exit extends JFrame  {
//회원탈퇴창
	GridBagConstraints gbc;
	GridBagLayout gbl;
	JLabel title, idLbl, pwLbl, pwcfLbl;
	JPasswordField pwTxt, pwcfTxt;
	JTextField idTxt;
	JButton exitBtn, cancelBtn;
	Font f1, f2, f3, f4;
	String id;
	ExitCf ecf1 = null;
	
	public Exit() {
		
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("회원 탈퇴");
		
		init();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500,700);
		setVisible(true);
		
		
	}
	
	
	public Exit(Edit edit) {
		this.id = edit.id;
		
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("회원 탈퇴");
		
		init();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500,700);
		setVisible(true);
		setResizable(false);
		setLocation(200, 200);
	}


	private void init() {
		
		gbl = new GridBagLayout();
		getContentPane().setLayout(gbl);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;

		f1 = new Font("한컴산뜻돋움", Font.BOLD, 40);
		f2 = new Font("한컴산뜻돋움", Font.BOLD, 20);
		f3 = new Font("한컴산뜻돋움", Font.PLAIN, 15);
		f4 = new Font("한컴산뜻돋움", Font.BOLD, 15);
		
		// 제목
		title = new JLabel("회원탈퇴");
		title.setFont(f1);
		title.setHorizontalAlignment(JLabel.CENTER);
		gblAdd(title, 0, 0, 4, 1);
		
		// 아이디
//		JPanel pId = new JPanel();
		idLbl = new JLabel("아이디");
		idLbl.setFont(f3);
		idLbl.setHorizontalAlignment(JLabel.CENTER);
		idTxt = new JTextField(20);
		idTxt.setText(id);
		idTxt.setEditable(false);
		idTxt.setBackground(new Color(255, 255, 255));

//		pId.add(idLbl);
//		pId.add(idTxt);

		gblAdd(idLbl, 0, 1, 1, 1);
		gblAdd(idTxt, 1, 1, 3, 1);
		
		// 이전 비밀번호
//		JPanel pPw = new JPanel();
		pwLbl = new JLabel("비밀번호");
		pwLbl.setFont(f3);
		pwLbl.setHorizontalAlignment(JLabel.CENTER);
		pwTxt = new JPasswordField(20);
		pwTxt.setBackground(new Color(255, 255, 255));

//		pPw.add(pwLbl);
//		pPw.add(pwTxt);

		gblAdd(pwLbl, 0, 2, 1, 1);
		gblAdd(pwTxt, 1, 2, 3, 1);

		// 비밀번호 확인
//		JPanel pCF = new JPanel();
		pwcfLbl = new JLabel("비밀번호 확인");
		pwcfLbl.setFont(f3);
		pwcfLbl.setHorizontalAlignment(JLabel.CENTER);
		pwcfTxt = new JPasswordField(20);
		pwcfTxt.setBackground(new Color(255, 255, 255));

//		pCF.add(pwcfLbl);
//		pCF.add(pwcfTxt);

		gblAdd(pwcfLbl, 0, 3, 1, 1);
		gblAdd(pwcfTxt, 1, 3, 3, 1);
		
		// 버튼
		JPanel pButton = new JPanel();
		exitBtn = new JButton("");
		cancelBtn = new JButton("");
		
		
		exitBtn.setBackground(new Color(73, 153, 221));
		exitBtn.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 15));
		exitBtn.setIcon(new ImageIcon(Join.class.getResource("/image/storageList/34.png")));
		cancelBtn.setBackground(new Color(73, 153, 221));
		cancelBtn.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 15));
		cancelBtn.setIcon(new ImageIcon(Join.class.getResource("/image/storageList/33.png")));
		exitBtn.setFont(f4);
		cancelBtn.setFont(f4);

		pButton.add(exitBtn);
		pButton.add(cancelBtn);
		gblAdd(pButton, 0, 4, 4, 1);
		pButton.setBackground(new Color(255, 255, 255));
		
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				exit();
				
			}
		});
		
	}

	private void gblAdd(JComponent c, int x, int y, int w, int h) {
		gbc.gridx      = x;
		gbc.gridy      = y;
		gbc.gridwidth  = w;
		gbc.gridheight = h;
		gbl.setConstraints(c, gbc);
		gbc.insets     = new Insets(5, 5, 5, 5);
		getContentPane().add(c, gbc);
	}
	
	public static void main(String[] args) {
		new Exit();
		
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		switch(e.getActionCommand()) {
//		case "취소" :
//			this.dispose();
//			break;
//		case "회원탈퇴" :
//			System.out.println("탈퇴버튼 클릭");
//			
//			exit();
//			break;
//		}
//		
//	}

	public void exit() {
		String id = idTxt.getText();
		String pw = pwTxt.getText();
		String cfpw = pwcfTxt.getText();
	
		if(pw.equals("")) {
			JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요", "탈퇴실패", JOptionPane.OK_OPTION);
			pwTxt.grabFocus();
		}
		U_Dao uao = new U_Dao();
		if (pw.equals(cfpw)) {
			uao.eXit(id,pw);
		} else { 
			JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요.");
		}
		
	}

	

}
