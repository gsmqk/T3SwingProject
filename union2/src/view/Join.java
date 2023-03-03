package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.U_DTO;
import model.U_Dao;

import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Join {

	private JFrame frame;
	private JTextField idTxt;
	private JPasswordField pwTxt;
	private JPasswordField pwcfTxt;
	private JTextField nameTxt;
	private JTextField emailTxt;
	private JButton cfBtn;
	private JButton joinBtn;
	private JButton cancelBtn;
	Join jtest = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Join window = new Join();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Join() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("회원가입");
		frame.setBounds(100, 100, 360, 440);

		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 344, 401);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel idLbl = new JLabel("아이디");
		idLbl.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		idLbl.setBounds(20, 20, 50, 20);
		panel.add(idLbl);
		
		idTxt = new JTextField();
		idTxt.setBounds(20, 40, 210, 40);
		panel.add(idTxt);
		idTxt.setColumns(10);
		
		cfBtn = new JButton("");
		cfBtn.setBackground(new Color(73, 153, 221));
		cfBtn.setIcon(new ImageIcon(Join.class.getResource("/image/storageList/19.png")));
		cfBtn.setBounds(240, 40, 85, 40);
		panel.add(cfBtn);
		
		JLabel pwLbl = new JLabel("비밀번호");
		pwLbl.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		pwLbl.setBounds(20, 80, 100, 20);
		panel.add(pwLbl);
		
		pwTxt = new JPasswordField();
		pwTxt.setColumns(10);
		pwTxt.setBounds(20, 100, 305, 40);
		panel.add(pwTxt);
		
		JLabel pwcfLbl = new JLabel("비밀번호 확인");
		pwcfLbl.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		pwcfLbl.setBounds(20, 140, 100, 20);
		panel.add(pwcfLbl);
		
		pwcfTxt = new JPasswordField();
		pwcfTxt.setColumns(10);
		pwcfTxt.setBounds(20, 160, 305, 40);
		panel.add(pwcfTxt);
		
		JLabel nameLbl = new JLabel("이름");
		nameLbl.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		nameLbl.setBounds(20, 200, 100, 20);
		panel.add(nameLbl);
		
		nameTxt = new JTextField();
		nameTxt.setColumns(10);
		nameTxt.setBounds(20, 220, 305, 40);
		panel.add(nameTxt);
		
		JLabel emailLbl = new JLabel("이메일");
		emailLbl.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		emailLbl.setBounds(20, 260, 100, 20);
		panel.add(emailLbl);
		
		emailTxt = new JTextField();
		emailTxt.setColumns(10);
		emailTxt.setBounds(20, 280, 305, 40);
		panel.add(emailTxt);
		
		
		
		joinBtn = new JButton("");
		joinBtn.setBackground(new Color(73, 153, 221));
		joinBtn.setIcon(new ImageIcon(Join.class.getResource("/image/storageList/17.png")));
		joinBtn.setBounds(70, 340, 100, 40);
		panel.add(joinBtn);
		
		cancelBtn = new JButton("");
		cancelBtn.setBackground(new Color(73, 153, 221));
		cancelBtn.setIcon(new ImageIcon(Join.class.getResource("/image/storageList/18.png")));
		cancelBtn.setBounds(180, 340, 100, 40);
		panel.add(cancelBtn);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Join.class.getResource("/image/흰배경.png")));
		lblNewLabel.setBounds(0, 0, 344, 401);
		panel.add(lblNewLabel);
		
		jtest = this;
		
		cfBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				exist();
				
			}
		});
		joinBtn.addActionListener(new ActionListener() {
			
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String id = idTxt.getText();
					String name = nameTxt.getText();
					String email = emailTxt.getText();
					String pw = pwTxt.getText().trim();
					String cfpw = pwcfTxt.getText().trim();
					if (id.equals("") && pw.equals("") && cfpw.equals("") && name.equals("") && email.equals("")) {
						JOptionPane.showMessageDialog(
								null,  "정보를 입력해주세요 !", "확인", JOptionPane.OK_OPTION);
					} else {
						if (name.equals("") || email.equals("")) {
							JOptionPane.showMessageDialog(
									null,  "이메일과 이름을 입력해주세요 !", "확인", JOptionPane.OK_OPTION);
						} else {
							if (pw.equals(cfpw)) {
								join();
							} else {
								JOptionPane.showMessageDialog(
										null,  "비밀번호를 확인해주세요.", "확인", JOptionPane.OK_OPTION);
							}
						}
					}
				}
			
		});
		cancelBtn.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("취소 클릭");
				frame.setVisible(false);
				
				
			}
		});
	}
	private void join() {
		U_Dao uao = new U_Dao();
		U_DTO uto = getViewData();
		int aftcnt = uao.insertUser(uto);
		
		JOptionPane.showMessageDialog(null, "가입되셨습니다. 환영합니다!");
		
		frame.setVisible(false);
		
	}
	private void exist() {
		String id = this.idTxt.getText();
		U_Dao uao = new U_Dao();
		
		if(id.equals("")) {
			JOptionPane.showMessageDialog(null, "아이디를 입력해주세요 !");
		} else {
			String msg = uao.checkExist(id);
			JOptionPane.showMessageDialog(null, msg);
		}
		
		
	}
	
	private U_DTO getViewData() {
		String uid = this.idTxt.getText();
		String upw = this.pwTxt.getText();
		String uname = this.nameTxt.getText();
		String umail = this.emailTxt.getText();
		
		U_DTO uto = new U_DTO(uid, upw, uname, umail);
		return uto;
	}
}
