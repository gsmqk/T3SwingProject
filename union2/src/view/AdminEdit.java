package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.U_DTO;
import model.U_Dao;
import java.awt.Color;
import javax.swing.ImageIcon;

public class AdminEdit extends JFrame  {
// 관리자 수정창!!!
	GridBagLayout gbl;
	GridBagConstraints gbc;

	JTextField idTxt, pwTxt, nameTxt, emailTxt, gradeTxt, statusTxt;
	JButton intoBtn, updateBtn, cancelBtn;
	JLabel title, idLbl, pwLbl, nameLbl, emailLbl, gradeLbl, statusLbl;
	
	
	Admin Admin = null;
	private JLabel lblNewLabel;
	
	public AdminEdit() {
		getContentPane().setForeground(new Color(255, 255, 255));
		
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
		
		gradeTxt = new JTextField();
		
		idTxt = new JTextField();
		idTxt.setBounds(124, 127, 185, 38);
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
		
		
		statusTxt = new JTextField();
		statusTxt.setColumns(10);
		statusTxt.setBounds(124, 356, 185, 38);
		getContentPane().add(statusTxt);
		
		idTxt.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_ENTER ) {
					intoBtn.doClick();
				}	
			}
			
		});
		
		
		idLbl = new JLabel("\uC544\uC774\uB514 :");
		idLbl.setHorizontalAlignment(SwingConstants.CENTER);
		idLbl.setFont(new Font("D2Coding", Font.PLAIN, 15));
		idLbl.setBounds(35, 126, 77, 38);
		getContentPane().add(idLbl);
		
		pwLbl = new JLabel("\uBE44\uBC00\uBC88\uD638 :");
		pwLbl.setHorizontalAlignment(SwingConstants.CENTER);
		pwLbl.setFont(new Font("D2Coding", Font.PLAIN, 15));
		pwLbl.setBounds(2, 174, 123, 46);
		getContentPane().add(pwLbl);
		
		nameLbl = new JLabel("\uC774\uB984 :");
		nameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		nameLbl.setFont(new Font("D2Coding", Font.PLAIN, 15));
		nameLbl.setBounds(51, 230, 61, 44);
		getContentPane().add(nameLbl);
		
		emailLbl = new JLabel("\uC774\uBA54\uC77C :");
		emailLbl.setHorizontalAlignment(SwingConstants.CENTER);
		emailLbl.setFont(new Font("D2Coding", Font.PLAIN, 15));
		emailLbl.setBounds(27, 289, 90, 38);
		getContentPane().add(emailLbl);
		
		
		
		statusLbl = new JLabel("\uC720\uC800\uC0C1\uD0DC :");
		statusLbl.setHorizontalAlignment(SwingConstants.CENTER);
		statusLbl.setFont(new Font("D2Coding", Font.PLAIN, 15));
		statusLbl.setBounds(12, 351, 113, 46);
		getContentPane().add(statusLbl);
		
		intoBtn = new JButton("조회");
		intoBtn.setBounds(325, 126, 65, 38);
		getContentPane().add(intoBtn);

		updateBtn = new JButton("수정하기");
		updateBtn.setBounds(103, 437, 97, 23);
		getContentPane().add(updateBtn);
		
		cancelBtn = new JButton("취소");
		cancelBtn.setBounds(225, 437, 97, 23);
		getContentPane().add(cancelBtn);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(AdminEdit.class.getResource("/image/\u3147\u3147\u3147\u3147\u3147\u3147.png")));
		lblNewLabel.setBounds(-11, -14, 433, 592);
		getContentPane().add(lblNewLabel);
		
		
		intoBtn.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("조회버튼 클릭...");
				findMember();
			}			
		 }
		);
		updateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("수정버튼 클릭...");
				editMember();
			}
		});
		
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("취소버튼 클릭...");
				cancleMember();
				
			}

		});
		
	}//-----------이까지 ----------------------생성자
	
	protected void cancleMember() {
		clearViewData();
		
	}
	
	private void clearViewData() {
		
		this.idTxt.setText("");
		this.pwTxt.setText("");
		this.nameTxt.setText("");
		this.emailTxt.setText("");
		this.statusTxt.setText("");
		
		
	}
	//맴버 조회
	protected void editMember() {
		
		String u_id = this.idTxt.getText();
		U_Dao  dao  = new U_Dao();
		
		int choice = JOptionPane.showConfirmDialog(null,
				u_id + "를 수정하시겠습니까?",
				"수정확인",
				JOptionPane.OK_CANCEL_OPTION);
		int aftcnt = 0;
		String msg = "";
		if (choice == 0 ) {
			U_DTO dto = getViewData();
			aftcnt    = dao.update(dto);
			if(aftcnt > 0)
				msg = u_id + "수정되었습니다";
			else
				msg = u_id + "수정되지 않았습니다";
		} else {
			msg = "취소를 선택하였습니다";
		}
		JOptionPane.showMessageDialog(null, 
				msg,
				"수정",
				 JOptionPane.OK_OPTION);
		
		 Admin.JTableRefresh();
		 
		 this.dispose();
		}
		

	private U_DTO getViewData() {
		String u_id = this.idTxt.getText();
		String username  = this.nameTxt.getText();
		String passwd    = this.pwTxt.getText();
		String useremail  = this.emailTxt.getText();
		String status  = this.statusTxt.getText();
		String grade = this.gradeTxt.getText();
		
		U_DTO dto = new U_DTO(u_id, username, passwd, useremail, status, grade);
		System.out.println("getViewData"+dto);
		return dto;
	}
	
	//조회!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	protected void findMember() {
		String u_id = this.idTxt.getText();

		if(u_id.trim().equals(""))
			return;
		
		U_Dao dao = new U_Dao();
		U_DTO dto = dao.getMember(u_id);
		setViewData(dto);
		System.out.println(dto);
	}


	private void setViewData(U_DTO dto) {
		String u_id    = dto.getU_id();
		String passwd    = dto.getU_password();
		String username  = dto.getU_name();
		String useremail  = dto.getU_email();
		String status  = dto.getU_status();
		String grade  = dto.getU_grade();
		
		this.idTxt.setText(u_id);
		this.pwTxt.setText(passwd);
		this.nameTxt.setText(username);
		this.emailTxt.setText(useremail);
		this.statusTxt.setText(status);
		this.gradeTxt.setText(grade);
		System.out.println("setView" + dto);
	}

	public static void main(String[] args) {
		new AdminEdit();
		
	}
}