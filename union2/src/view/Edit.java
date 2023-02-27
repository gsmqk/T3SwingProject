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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.U_DTO;
import model.U_Dao;

public class Edit extends JFrame implements ActionListener {

	GridBagLayout gbl;
	GridBagConstraints gbc;
	Font f1, f2, f3, f4;
	JTextField idTxt, nameTxt, emailTxt;
	JPasswordField pwTxt, ppwTxt, pwcfTxt;
	JButton editBtn, cancelBtn, exitBtn;
	JLabel title, idLbl, pwLbl, ppwLbl, pwcfLbl, nameLbl, emailLbl;
	String id;
	Exit e1 = null;
	
	public Edit() {
		setTitle("회원정보수정");
		
		init();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500,700);
		setVisible(true);
	}
	
	public Edit(MainTable01 mt01) {
		this.id = mt01.id;
		
		setTitle("회원정보수정");

		init();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 700);
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
		f2 = new Font("HY견고딕", Font.BOLD, 20);
		f3 = new Font("HY견고딕", Font.PLAIN, 15);
		f4 = new Font("HY견고딕", Font.BOLD, 15);
		
		// 제목
		title = new JLabel("회원 정보 수정");
		title.setFont(f1);
		title.setHorizontalAlignment(JLabel.CENTER);
		gblAdd(title, 0, 0, 4, 1);
		
		// 아이디
//		JPanel pId = new JPanel();
		idLbl = new JLabel("아이디");
		idLbl.setFont(f3);
		idLbl.setHorizontalAlignment(JLabel.CENTER);
		idTxt = new JTextField(20);
		idTxt.setText(this.id);
		idTxt.setEditable(false);
		
//		pId = new JPanel();
//		pId.add(idLbl);
//		pId.add(idTxt);
		
		gblAdd(idLbl,0,1,1,1);
		gblAdd(idTxt,1,1,3,1);

		// 이전 비밀번호
//		JPanel ppPw = new JPanel();
		ppwLbl = new JLabel("이전 비밀번호");
		ppwLbl.setFont(f3);
		ppwLbl.setHorizontalAlignment(JLabel.CENTER);
		ppwTxt = new JPasswordField(20);

//		ppPw.add(ppwLbl);
//		ppPw.add(ppwTxt);

		gblAdd(ppwLbl, 0, 2, 1, 1);
		gblAdd(ppwTxt, 1, 2, 3, 1);
		
		// 비밀번호
//		JPanel pPw = new JPanel();
		pwLbl = new JLabel("새 비밀번호");
		pwLbl.setFont(f3);
		pwLbl.setHorizontalAlignment(JLabel.CENTER);
		pwTxt = new JPasswordField(20);

//		pPw.add(pwLbl);
//		pPw.add(pwTxt);

		gblAdd(pwLbl, 0, 3, 1, 1);
		gblAdd(pwTxt, 1, 3, 3, 1);
		
		// 비밀번호 확인
//		JPanel pCF = new JPanel();
		pwcfLbl = new JLabel("비밀번호 확인");
		pwcfLbl.setHorizontalAlignment(JLabel.CENTER);
		pwcfLbl.setFont(f3);
		pwcfTxt = new JPasswordField(20);

//		pCF.add(pwcfLbl);
//		pCF.add(pwcfTxt);

		gblAdd(pwcfLbl, 0, 4, 1, 1);
		gblAdd(pwcfTxt, 1, 4, 3, 1);
		
		// 이름
//		JPanel pName = new JPanel();
		nameLbl = new JLabel("이름");
		nameLbl.setHorizontalAlignment(JLabel.CENTER);
		nameLbl.setFont(f3);
		nameTxt = new JTextField(20);
		
		
//		pName.add(nameLbl);
//		pName.add(nameTxt);
		
		gblAdd(nameLbl, 0, 5, 1, 1);
		gblAdd(nameTxt, 1, 5, 3, 1);
		
		// 이메일
//		JPanel pMail = new JPanel();
		emailLbl = new JLabel("이메일");
		emailLbl.setHorizontalAlignment(JLabel.CENTER);
		emailLbl.setFont(f3);
		emailTxt = new JTextField(20);
		
//		pMail.add(emailLbl);
//		pMail.add(emailTxt);
		
		gblAdd(emailLbl, 0, 6, 1, 1);
		gblAdd(emailTxt, 1, 6, 3, 1);
		
		// 버튼
		JPanel pButton = new JPanel();
		exitBtn = new JButton("회원탈퇴");
		editBtn = new JButton("정보수정");
		cancelBtn = new JButton("입력취소");
		
		exitBtn.setFont(f4);
		editBtn.setFont(f4);
		cancelBtn.setFont(f4);
		
		pButton.add(exitBtn);
		pButton.add(editBtn);
		pButton.add(cancelBtn);
		
		gblAdd(pButton, 0, 7, 4, 1);

		editBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		
	}

	private void gblAdd(JComponent c, int x, int y, int w, int h) {
		gbc.gridx      = x;
		gbc.gridy      = y;
		gbc.gridwidth  = w;
		gbc.gridheight = h;
		gbl.setConstraints(c, gbc);
		gbc.insets     = new Insets(5, 5, 5, 5);
		this.add(c, gbc);
	}

	public static void main(String[] args) {
		new Edit();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "회원탈퇴" : 
			e1 = new Exit(this);
			break;
		case "입력취소" :
			JOptionPane.showMessageDialog(null, "취소하셨습니다.");
			this.dispose();
			break;
		case "정보수정" :
			sujung();
			break;
		}
		
	}

	private void sujung() {
		String id = idTxt.getText();
		String pw = ppwTxt.getText();
		String npw = pwTxt.getText();
		String cfnpw = pwcfTxt.getText();
		String name = nameTxt.getText();
		String email = emailTxt.getText();

		U_Dao uao = new U_Dao();
		boolean flag = uao.checkPw(id, pw);
		
		if (pw.equals("") || email.equals("")) {
			JOptionPane.showMessageDialog(null, "비밀번호와 이메일은 필수 입력사항입니다 !");
			ppwTxt.grabFocus();
		} else {
			if (flag == true) {
				if (npw.equals(cfnpw)) {
					U_DTO dto = new U_DTO(id, name, npw, email);
					uao.updateUser(dto);
					JOptionPane.showMessageDialog(null, "수정되었습니다 !");
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "새 비밀번호를 다시 확인해주세요.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "이전 비밀번호가 맞지않습니다.");
			}
		}
		
	}

}
