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
import javax.swing.SwingConstants;

public class AdminEdit extends JFrame  {

	GridBagLayout gbl;
	GridBagConstraints gbc;
	Font f1;
	JTextField idTxt, nameTxt, emailTxt;
	JPasswordField pwTxt, ppwTxt, pwcfTxt;
	JButton joinBtn, cancelBtn;
	JLabel title, idLbl, pwLbl, ppwLbl, pwcfLbl, nameLbl, emailLbl;
	JComboBox combo_user;
	
	public AdminEdit() {
		
		setTitle("회원정보수정");
		
		init();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(430,600);
		setVisible(true);
		
	}
	
	private void init() {
		
getContentPane().setLayout(null);
		
		title = new JLabel("\uD68C\uC6D0 \uC815\uBCF4 \uC218\uC815 ");
		title.setFont(new Font("D2Coding", Font.PLAIN, 23));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(12, 10, 410, 57);
		getContentPane().add(title);
		
		combo_user = new JComboBox();
		combo_user.setToolTipText("\uAD00\uB9AC\uC790 ");
		combo_user.setModel(
				new DefaultComboBoxModel(
						new String[] {"현회원","전회원","관리자"}
					)
				);
		combo_user.setBounds(130, 66, 166, 32);
		getContentPane().add(combo_user);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(142, 116, 230, 38);
		getContentPane().add(nameTxt);
		nameTxt.setColumns(10);
		
		pwTxt = new JPasswordField();
		pwTxt.setColumns(10);
		pwTxt.setBounds(142, 172, 230, 38);
		getContentPane().add(pwTxt);
		
		ppwTxt = new JPasswordField();
		ppwTxt.setColumns(10);
		ppwTxt.setBounds(142, 227, 230, 38);
		getContentPane().add(ppwTxt);
		
		pwcfTxt = new JPasswordField();
		pwcfTxt.setColumns(10);
		pwcfTxt.setBounds(142, 282, 230, 38);
		getContentPane().add(pwcfTxt);
		
		nameTxt = new JTextField();
		nameTxt.setColumns(10);
		nameTxt.setBounds(142, 338, 230, 38);
		getContentPane().add(nameTxt);
		
		emailTxt = new JTextField();
		emailTxt.setColumns(10);
		emailTxt.setBounds(142, 398, 230, 38);
		getContentPane().add(emailTxt);
		
		JLabel idLbl = new JLabel("\uC544\uC774\uB514 :");
		idLbl.setHorizontalAlignment(SwingConstants.CENTER);
		idLbl.setFont(new Font("D2Coding", Font.PLAIN, 15));
		idLbl.setBounds(57, 116, 85, 38);
		getContentPane().add(idLbl);
		
		JLabel pwLbl = new JLabel("\uD604\uC7AC \uBE44\uBC00\uBC88\uD638 :");
		pwLbl.setHorizontalAlignment(SwingConstants.CENTER);
		pwLbl.setFont(new Font("D2Coding", Font.PLAIN, 15));
		pwLbl.setBounds(12, 171, 130, 39);
		getContentPane().add(pwLbl);
		
		JLabel ppwLbl = new JLabel("\uC0C8 \uBE44\uBC00\uBC88\uD638 :");
		ppwLbl.setHorizontalAlignment(SwingConstants.CENTER);
		ppwLbl.setFont(new Font("D2Coding", Font.PLAIN, 15));
		ppwLbl.setBounds(22, 226, 118, 38);
		getContentPane().add(ppwLbl);
		
		JLabel pwcfLbl = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778 : ");
		pwcfLbl.setHorizontalAlignment(SwingConstants.CENTER);
		pwcfLbl.setFont(new Font("D2Coding", Font.PLAIN, 15));
		pwcfLbl.setBounds(12, 287, 130, 33);
		getContentPane().add(pwcfLbl);
		
		JLabel nameLbl = new JLabel("\uC774\uB984 :");
		nameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		nameLbl.setFont(new Font("D2Coding", Font.PLAIN, 15));
		nameLbl.setBounds(67, 338, 85, 38);
		getContentPane().add(nameLbl);
		
		JLabel emailLbl = new JLabel("\uC774\uBA54\uC77C :");
		emailLbl.setHorizontalAlignment(SwingConstants.CENTER);
		emailLbl.setFont(new Font("D2Coding", Font.PLAIN, 15));
		emailLbl.setBounds(55, 397, 85, 38);
		getContentPane().add(emailLbl);
		
		JButton joinBtn = new JButton("\uC815\uBCF4 \uC218\uC815");
		joinBtn.setBounds(108, 482, 97, 23);
		getContentPane().add(joinBtn);
		
		JButton cancelBtn = new JButton("\uC785\uB825 \uCDE8\uC18C");
		cancelBtn.setBounds(234, 482, 97, 23);
		getContentPane().add(cancelBtn);
	}



	public static void main(String[] args) {
		new AdminEdit();
		
	}

}