package Test;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.DropMode;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JScrollPane;


public class MainTable01 {
	
	// 필요한 부품준비
	JPanel            p; 
	JTextField        txtId,  txtName,  txtIndate;
	JTextArea         taIntro;
			
	JButton           btnInput, btnIngredient, btnRecipe, btnStorage, btnAhb, btnSet, btnLogout;
	
	FindName  mProc = null; 
	static MainTable02  mList = null;

	private JFrame frame;
	private JTextField textField;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainTable01 window = new MainTable01();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainTable01() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("메인 화면");
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBounds(0, 0, 1184, 761);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnInput = new JButton("신규 입고");
		btnInput.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnInput.setBackground(new Color(135, 206, 250));
		btnInput.setForeground(Color.WHITE);
		btnInput.setBounds(30, 40, 120, 50);
		panel.add(btnInput);
		
		JButton btnIngredient = new JButton("식자재 검색");
		btnIngredient.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnIngredient.setBackground(new Color(135, 206, 250));
		btnIngredient.setForeground(Color.WHITE);
		btnIngredient.setBounds(30, 120, 120, 50);
		panel.add(btnIngredient);
		
		JButton btnRecipe = new JButton("레시피 검색");
		btnRecipe.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnRecipe.setBackground(new Color(135, 206, 250));
		btnRecipe.setForeground(Color.WHITE);
		btnRecipe.setBounds(30, 200, 120, 50);
		panel.add(btnRecipe);
		
		JButton btnStorage = new JButton("보관 목록");
		btnStorage.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnStorage.setBackground(new Color(135, 206, 250));
		btnStorage.setForeground(Color.WHITE);
		btnStorage.setBounds(30, 370, 120, 50);
		panel.add(btnStorage);
		
		JButton btnAhb = new JButton("가계부");
		btnAhb.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnAhb.setBackground(new Color(135, 206, 250));
		btnAhb.setForeground(Color.WHITE);
		btnAhb.setBounds(30, 450, 120, 50);
		panel.add(btnAhb);
		
		JButton btnSet = new JButton("템플릿 설정");
		btnSet.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnSet.setBackground(new Color(135, 206, 250));
		btnSet.setForeground(Color.WHITE);
		btnSet.setBounds(30, 530, 120, 50);
		panel.add(btnSet);
		
		JButton btnLogout = new JButton("로그아웃");
		btnLogout.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnLogout.setBackground(new Color(135, 206, 250));
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setBounds(30, 610, 120, 50);
		panel.add(btnLogout);
		
		
		btnInput.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mProc != null)
					mProc.dispose();
				mProc = new FindName();
				
			}
		}); 
		
		btnIngredient.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mProc != null)
					mProc.dispose();
				mProc = new FindName();
				
			}
		}); 
		
		btnRecipe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mProc != null)
					mProc.dispose();
				mProc = new FindName();
				
			}
		}); 
		btnStorage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mProc != null)
					mProc.dispose();
				mProc = new FindName();
				
			}
		}); 
		btnAhb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mProc != null)
					mProc.dispose();
				mProc = new FindName();
				
			}
		}); 
		btnSet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mProc != null)
					mProc.dispose();
				mProc = new FindName();
				
			}
		}); 
		btnLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mProc != null)
					mProc.dispose();
				mProc = new FindName();
				
			}
		}); 
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		textField.setBackground(new Color(255, 218, 185));
		textField.setText("유통기한임박");
		textField.setBounds(236, 40, 839, 50);
		panel.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(236, 140, 830, 479);
		panel.add(scrollPane);
		
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"\uC774\uB984", "\uBCF4\uAD00\uC7A5\uC18C", "\uC218\uB7C9", "\uC785\uACE0\uC77C", "\uC18C\uBE44\uAE30\uD55C", "\uB9CC\uAE30\uC77C"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(79);
	}

}
