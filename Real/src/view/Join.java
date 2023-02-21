package view;

import java.awt.Dimension;
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

public class Join extends JFrame implements ActionListener{

	GridBagLayout gbl;
	GridBagConstraints gbc;
	JTextField idTxt, nameTxt, emailTxt;
	JPasswordField pwTxt, pwcfTxt;
	JButton cfBtn, joinBtn, cancelBtn;
	JLabel title, idLbl, pwLbl, pwcfLbl, nameLbl, emailLbl; 
	Font f1, f2, f3;
	
	public Join() {
		
		setTitle("회원가입");
		
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
		f2 = new Font("HY견고딕", Font.BOLD, 20);
		f3 = new Font("HY견고딕", Font.BOLD, 15);
		
		// 제목
		title = new JLabel("회원가입");
		title.setFont(f1);
		title.setHorizontalAlignment(JLabel.CENTER);
		gblAdd(title, 0, 0, 4, 1);
		
		// 아이디
//		JPanel pId = new JPanel();
		idLbl = new JLabel("아이디 :");
		idLbl.setFont(f2);
		idTxt = new JTextField(15);
		cfBtn = new JButton("중복확인");
		cfBtn.setFont(f3);
		
//		pId.add(idLbl);
//		pId.add(idTxt);
//		pId.add(cfBtn);
		
		gblAdd(idLbl,0,1,1,1);
		gblAdd(idTxt,1,1,2,1);
		gblAdd(cfBtn,3,1,1,1);
		
		// 비밀번호
//		JPanel pPw = new JPanel();
		pwLbl = new JLabel("비밀번호 :");
		pwLbl.setFont(f2);
		pwTxt = new JPasswordField(20);
		
//		pPw.add(pwLbl);
//		pPw.add(pwTxt);
		
		gblAdd(pwLbl, 0, 2, 1, 1);
		gblAdd(pwTxt, 1, 2, 3, 1);
		
		// 비밀번호 확인
//		JPanel pCF = new JPanel();
		pwcfLbl = new JLabel("비밀번호 확인:");
		pwcfLbl.setFont(f2);
		pwcfTxt = new JPasswordField(20);
		
//		pCF.add(pwcfLbl);
//		pCF.add(pwcfTxt);
		
		gblAdd(pwcfLbl, 0, 3, 1, 1);
		gblAdd(pwcfTxt, 1, 3, 3, 1);
		
		// 이름
//		JPanel pName = new JPanel();
		nameLbl = new JLabel("이름 :");
		nameLbl.setFont(f2);
		nameTxt = new JTextField(20);
		
//		pName.add(nameLbl);
//		pName.add(nameTxt);
		
		gblAdd(nameLbl, 0, 4, 1, 1);
		gblAdd(nameTxt, 1, 4, 3, 1);
		
		// 이메일
//		JPanel pMail = new JPanel();
		emailLbl = new JLabel("이메일 :");
		emailLbl.setFont(f2);
		emailTxt = new JTextField(20);
		
//		pMail.add(emailLbl);
//		pMail.add(emailTxt);
		
		gblAdd(emailLbl, 0, 5, 1, 1);
		gblAdd(emailTxt, 1, 5, 3, 1);
		
		// 버튼
		JPanel pButton = new JPanel();
		joinBtn = new JButton("회원가입");
		cancelBtn = new JButton("취소");
		joinBtn.setFont(f2);
		cancelBtn.setFont(f2);
		
		pButton.add(joinBtn);
		pButton.add(cancelBtn);
		
		gblAdd(pButton, 0, 6, 4, 1);
		
		// 기능
		
		cfBtn.addActionListener(this);
		joinBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "회원가입" :
			String pw = pwTxt.getText().trim();
			String cfpw = pwcfTxt.getText().trim();
			if (pw.equals(cfpw)) {
				join();
			} else {
				JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요", "확인",
						JOptionPane.OK_OPTION);
			}
			break;
		case "취소" : 
			System.out.println("취소 클릭");
			this.dispose();
			break;
		case "중복확인" :
			exist();
			break;
		}
		
	}

	private void exist() {
		String id = this.idTxt.getText();
		U_Dao uao = new U_Dao();
		
		String msg = uao.checkExist(id);
		JOptionPane.showMessageDialog(null, msg);
	}	

	private void join() {
		U_Dao uao = new U_Dao();
		U_DTO uto = getViewData();
		int aftcnt = uao.insertUser(uto);
		
		JOptionPane.showMessageDialog(null, aftcnt + "건 저장되었습니다");
		
		this.dispose();
	}

	private U_DTO getViewData() {
		String uid = this.idTxt.getText();
		String upw = this.pwTxt.getText();
		String uname = this.nameTxt.getText();
		String umail = this.emailTxt.getText();
		
		U_DTO uto = new U_DTO(uid, upw, uname, umail);
		return uto;
	}
	

//	public static void main(String[] args) {
//		new Join();
//	}

}
