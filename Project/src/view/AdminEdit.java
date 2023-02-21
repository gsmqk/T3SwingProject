package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminEdit extends JFrame  {

	GridBagLayout gbl;
	GridBagConstraints gbc;
	Font f1;
	JTextField idTxt, nameTxt, emailTxt;
	JPasswordField pwTxt, ppwTxt, pwcfTxt;
	JButton joinBtn, cancelBtn;
	JLabel title, idLbl, pwLbl, ppwLbl, pwcfLbl, nameLbl, emailLbl, user_grade;
	JComboBox combo_user;
	
	public AdminEdit() {
		
		setTitle("회원정보수정");
		
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
		
		// 제목
		title = new JLabel("회원 정보 수정");
		title.setFont(f1);
		title.setHorizontalAlignment(JLabel.CENTER);
		gblAdd(title, 0, 0, 4, 1);
		
		// 유저등급
		combo_user = new JComboBox();
		combo_user.setFont(new Font("D2Coding", Font.PLAIN, 20));
		combo_user.setModel(
				new DefaultComboBoxModel(
						new String[] {"현회원","전회원","관리자"}
					)
				);
		JPanel pcom = new JPanel();
		pcom.add(combo_user);
		gblAdd(pcom,0,1,4,1);
		
		// 아이디
		JPanel pId = new JPanel();
		idLbl = new JLabel("아이디 :");
		idTxt = new JTextField(20);
		idTxt.setEditable(false);
		
		pId = new JPanel();
		pId.add(idLbl);
		pId.add(idTxt);
		
		gblAdd(pId,0,2,4,1);

		// 이전 비밀번호
		JPanel ppPw = new JPanel();
		ppwLbl = new JLabel("이전 비밀번호 :");
		ppwTxt = new JPasswordField(20);

		ppPw.add(ppwLbl);
		ppPw.add(ppwTxt);

		gblAdd(ppPw, 0, 3, 4, 1);
		
		// 비밀번호
		JPanel pPw = new JPanel();
		pwLbl = new JLabel("새 비밀번호 :");
		pwTxt = new JPasswordField(20);

		pPw.add(pwLbl);
		pPw.add(pwTxt);

		gblAdd(pPw, 0, 4, 4, 1);
		
		// 비밀번호 확인
		JPanel pCF = new JPanel();
		pwcfLbl = new JLabel("비밀번호 확인:");
		pwcfTxt = new JPasswordField(20);

		pCF.add(pwcfLbl);
		pCF.add(pwcfTxt);

		gblAdd(pCF, 0, 5, 4, 1);
		
		// 이름
		JPanel pName = new JPanel();
		nameLbl = new JLabel("이름 :");
		nameTxt = new JTextField(20);
		
		pName.add(nameLbl);
		pName.add(nameTxt);
		
		gblAdd(pName, 0, 6, 4, 1);
		
		// 이메일
		JPanel pMail = new JPanel();
		emailLbl = new JLabel("이메일 :");
		emailTxt = new JTextField(20);
		
		pMail.add(emailLbl);
		pMail.add(emailTxt);
		
		gblAdd(pMail, 0, 7, 4, 1);
		
		// 버튼
		JPanel pButton = new JPanel();
		joinBtn = new JButton("정보수정");
		cancelBtn = new JButton("입력취소");
		
		pButton.add(joinBtn);
		pButton.add(cancelBtn);
		
		gblAdd(pButton, 0, 8, 4, 1);
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
		new AdminEdit();
		
	}

}