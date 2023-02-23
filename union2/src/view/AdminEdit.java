package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.U_DTO;
import model.U_Dao;

public class AdminEdit extends JFrame  {
// 관리자 수정창!!!
	GridBagLayout gbl;
	GridBagConstraints gbc;

	JTextField idTxt, pwTxt, nameTxt, emailTxt, gradeTxt, statusTxt;
	JButton intoBtn, joinBtn, cancelBtn;
	JLabel title, idLbl, pwLbl, nameLbl, emailLbl, gradeLbl, statusLbl;
	
	
	Admin Admin = null;
	
	public AdminEdit() {
		
		setTitle("회원정보수정");
		
		init();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(430,600);
		setVisible(true);
		
	}
	public AdminEdit(Admin Admin) {
	
		this();
		this.Admin = Admin;
	}
	public AdminEdit(String id ,Admin Admin) {
		this();
		this.Admin = Admin;
		
		idTxt.setText(id);
		intoBtn.doClick();
		
	}
	
	private void init() {
		
        getContentPane().setLayout(null);
		
		title = new JLabel("\uD68C\uC6D0 \uC815\uBCF4 \uC218\uC815 ");
		title.setFont(new Font("D2Coding", Font.PLAIN, 23));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(12, 10, 410, 57);
		getContentPane().add(title);
		
	
		
		idTxt = new JTextField();
		idTxt.setBounds(124, 116, 185, 38);
		getContentPane().add(idTxt);
		idTxt.setColumns(10);
		
		pwTxt = new JTextField();
		pwTxt.setColumns(10);
		pwTxt.setBounds(124, 179, 185, 38);
		getContentPane().add(pwTxt);
		
		nameTxt = new JTextField();
		nameTxt.setColumns(10);
		nameTxt.setBounds(124, 234, 185, 38);
		getContentPane().add(nameTxt);
		
		emailTxt = new JTextField();
		emailTxt.setColumns(10);
		emailTxt.setBounds(124, 290, 185, 38);
		getContentPane().add(emailTxt);
		
		gradeTxt = new JTextField();
		gradeTxt.setColumns(10);
		gradeTxt.setBounds(124, 338, 185, 38);
		getContentPane().add(gradeTxt);
		
		statusTxt = new JTextField();
		statusTxt.setColumns(10);
		statusTxt.setBounds(124, 398, 185, 38);
		getContentPane().add(statusTxt);
		
		idLbl = new JLabel("\uC544\uC774\uB514 :");
		idLbl.setHorizontalAlignment(SwingConstants.CENTER);
		idLbl.setFont(new Font("D2Coding", Font.PLAIN, 15));
		idLbl.setBounds(45, 115, 67, 38);
		getContentPane().add(idLbl);
		
		pwLbl = new JLabel("\uBE44\uBC00\uBC88\uD638 :");
		pwLbl.setHorizontalAlignment(SwingConstants.CENTER);
		pwLbl.setFont(new Font("D2Coding", Font.PLAIN, 15));
		pwLbl.setBounds(12, 171, 123, 46);
		getContentPane().add(pwLbl);
		
		nameLbl = new JLabel("\uC774\uB984 :");
		nameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		nameLbl.setFont(new Font("D2Coding", Font.PLAIN, 15));
		nameLbl.setBounds(55, 223, 61, 44);
		getContentPane().add(nameLbl);
		
		emailLbl = new JLabel("\uC774\uBA54\uC77C :");
		emailLbl.setHorizontalAlignment(SwingConstants.CENTER);
		emailLbl.setFont(new Font("D2Coding", Font.PLAIN, 15));
		emailLbl.setBounds(34, 281, 85, 38);
		getContentPane().add(emailLbl);
		
		gradeLbl = new JLabel("\uB4F1\uAE09 :");
		gradeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		gradeLbl.setFont(new Font("D2Coding", Font.PLAIN, 15));
		gradeLbl.setBounds(45, 337, 77, 38);
		getContentPane().add(gradeLbl);
		
		statusLbl = new JLabel("\uC720\uC800\uC0C1\uD0DC :");
		statusLbl.setHorizontalAlignment(SwingConstants.CENTER);
		statusLbl.setFont(new Font("D2Coding", Font.PLAIN, 15));
		statusLbl.setBounds(12, 393, 113, 46);
		getContentPane().add(statusLbl);
		
		intoBtn = new JButton("조회");
		intoBtn.setBounds(323, 115, 65, 38);
		getContentPane().add(intoBtn);

		joinBtn = new JButton("\uC815\uBCF4 \uC218\uC815");
		joinBtn.setBounds(108, 482, 97, 23);
		getContentPane().add(joinBtn);
		
		cancelBtn = new JButton("\uC785\uB825 \uCDE8\uC18C");
		cancelBtn.setBounds(234, 482, 97, 23);
		getContentPane().add(cancelBtn);
		
		
		intoBtn.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("조회버튼 클릭...");
				findMember();
			}

			
		}
		);
	}
	

	protected void findMember() {
		String u_id = this.idTxt.getText();

		if(u_id.trim().equals(""))
			return;
		
		U_Dao dao = new U_Dao();
		U_DTO dto = dao.getMember(u_id);
		setViewData(dto);
		
	}


	private void setViewData(U_DTO dto) {
		String u_id    = dto.getU_id();
		String passwd    = dto.getU_password();
		String username  = dto.getU_name();
		String useremail  = dto.getU_email();
		String usergrade  = dto.getU_grade();
		String status  = dto.getU_status();
		
		this.idTxt.setText(u_id);
		this.pwTxt.setText(passwd);
		this.nameTxt.setText(username);
		this.emailTxt.setText(useremail);
		this.gradeTxt.setText(usergrade);
		this.statusTxt.setText(status);
	}

	public static void main(String[] args) {
		new AdminEdit();
		
	}
}