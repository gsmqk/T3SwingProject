//package view;
//
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPasswordField;
//import javax.swing.JTextField;
//
//import model.U_DTO;
//import model.U_Dao;
//import java.awt.Color;
//
//public class Join extends JFrame implements ActionListener {
//	
//	private JTextField idTxt;
//	private JTextField nameTxt;
//	private JTextField emailTxt;
//	private JPasswordField pwTxt;
//	private JPasswordField pwcfTxt;
//	
//	public Join() {
//		getContentPane().setBackground(new Color(255, 255, 255));
//
//		getContentPane().setLayout(null);
//
//		setFont(new Font("D2Coding", Font.PLAIN, 14));
//		setTitle("회원가입");
//
//		init();
//
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setSize(360,440);
//		setLocation(800, 200);
//		setVisible(true);
//		
//	}
//	
//	private void init() {
//
//
//		JLabel idLbl = new JLabel("아이디");
//		idLbl.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
//		idLbl.setBounds(20, 20, 50, 20);
//		getContentPane().add(idLbl);
//
//		idTxt = new JTextField();
//		idTxt.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		idTxt.setBounds(20, 40, 210, 40);
//		getContentPane().add(idTxt);
//		idTxt.setColumns(10);
//		
//		JButton cfBtn = new JButton("중복확인");
//		cfBtn.setFont(new Font("D2Coding", Font.PLAIN, 12));
//		cfBtn.setBounds(240, 40, 85, 40);
//		getContentPane().add(cfBtn);
//		
//		JLabel pwLbl = new JLabel("비밀번호");
//		pwLbl.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
//		pwLbl.setBounds(20, 80, 100, 20);
//		getContentPane().add(pwLbl);
//		
//		pwTxt = new JPasswordField();
//		pwTxt.setBounds(20, 100, 305, 40);
//		getContentPane().add(pwTxt);
//		
//		JLabel pwcfLbl = new JLabel("비밀번호 확인");
//		pwcfLbl.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
//		pwcfLbl.setBounds(20, 140, 100, 20);
//		getContentPane().add(pwcfLbl);
//		
//		pwcfTxt = new JPasswordField();
//		pwcfTxt.setBounds(20, 160, 305, 40);
//		getContentPane().add(pwcfTxt);
//		
//		JLabel nameLbl = new JLabel("이름");
//		nameLbl.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
//		nameLbl.setBounds(20, 200, 100, 20);
//		getContentPane().add(nameLbl);
//		
//		nameTxt = new JTextField();
//		nameTxt.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		nameTxt.setColumns(10);
//		nameTxt.setBounds(20, 220, 305, 40);
//		getContentPane().add(nameTxt);
//		
//		JLabel emailLbl = new JLabel("이메일");
//		emailLbl.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
//		emailLbl.setBounds(20, 260, 100, 20);
//		getContentPane().add(emailLbl);
//		
//		emailTxt = new JTextField();
//		emailTxt.setFont(new Font("D2Coding", Font.PLAIN, 18));
//		emailTxt.setColumns(10);
//		emailTxt.setBounds(20, 280, 305, 40);
//		getContentPane().add(emailTxt);
//		
//		JButton joinBtn = new JButton("회원가입");
//		joinBtn.setFont(new Font("D2Coding", Font.PLAIN, 12));
//		joinBtn.setBounds(80, 340, 85, 40);
//		getContentPane().add(joinBtn);
//		
//		JButton cancelBtn = new JButton("취소");
//		cancelBtn.setFont(new Font("D2Coding", Font.PLAIN, 12));
//		cancelBtn.setBounds(175, 340, 85, 40);
//		getContentPane().add(cancelBtn);
//		
//		cfBtn.addActionListener(this);
//		joinBtn.addActionListener(this);
//		cancelBtn.addActionListener(this);
//	
//	
//	}
//
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		switch (e.getActionCommand()) {
//			case "회원가입" :
//				String pw = pwTxt.getText().trim();
//				String cfpw = pwcfTxt.getText().trim();
//				if (pw.equals(cfpw)) {
//					join();
//				} else {
//					JOptionPane.showMessageDialog(
//				    null,  "비밀번호를 확인해주세요.", "확인", JOptionPane.OK_OPTION);
//				}
//				break;
//			case "취소" :
//				System.out.println("취소 클릭");
//				this.dispose();
//				break;
//			case "중복확인" :
//				exist();
//				break;
//		}
//		
//		
//	}
//
//	private void join() {
//		U_Dao uao = new U_Dao();
//		U_DTO uto = getViewData();
//		int aftcnt = uao.insertUser(uto);
//		
//		JOptionPane.showMessageDialog(null, "가입되셨습니다. 환영합니다!");
//		
//		this.dispose();
//		
//	}
//
//	private void exist() {
//		String id = this.idTxt.getText();
//		U_Dao uao = new U_Dao();
//		
//		String msg = uao.checkExist(id);
//		JOptionPane.showMessageDialog(null, msg);
//		
//	}
//	
//	private U_DTO getViewData() {
//		String uid = this.idTxt.getText();
//		String upw = this.pwTxt.getText();
//		String uname = this.nameTxt.getText();
//		String umail = this.emailTxt.getText();
//		
//		U_DTO uto = new U_DTO(uid, upw, uname, umail);
//		return uto;
//	}
//
////	public static void main(String[] args) {
////		new Join();
//	
////	}
//
//}
