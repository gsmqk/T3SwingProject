package Test;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DetailInfo extends JFrame {
	
	JLabel title, fdName, category, amount, price, 
	       pYear, eYear, inDate, dDate, won1, won2, dang;
	JTextField fdNameTa, amountTa, priceTa, pPriceTa,
	          pYearTa, eYearTa, inDateTa, dDateTa;
	JComboBox bigC, middleC, storage, danw1, danw2;
	JButton   editBtn, processBtn, cancelBtn;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	Font f1;
//
	public DetailInfo() {
		setTitle("재료 상세 정보");
		
		init();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500,700);
		setVisible(true);
	}
	
	private void init() {
		gbl = new GridBagLayout();
		getContentPane().setLayout(gbl);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		// 제목
		f1 = new Font("HY견고딕", Font.BOLD, 40);
		title = new JLabel("재료 상세 정보");
		title.setFont(f1);
		title.setHorizontalAlignment(JLabel.CENTER);
		gblAdd(title, 0, 0, 4, 1);
		
		// 재료 이름
		JPanel pName = new JPanel();
		fdName = new JLabel("재료 이름");
		fdNameTa = new JTextField(20);
		pName.add(fdName);
		pName.add(fdNameTa);
		gblAdd(pName, 0, 1, 4, 1);
		
		// 분류 칸
		JPanel pCat = new JPanel();
		String[] big = {"대분류","과일", "육류", "어류", "야채"};
		String[] middle = {"중분류","그림", "만그", "렸습", "니다"};
		String[] stor = {"보관 장소", "책상", "신발", "냉장고", "이불안"};
		bigC = new JComboBox(big);
		middleC = new JComboBox(middle);
		storage = new JComboBox(stor);
		pCat.add(bigC);
		pCat.add(middleC);
		pCat.add(storage);
		
		gblAdd(pCat, 0, 2, 4, 1);
		
//		gblAdd(bigC, 0, 2, 1, 1);
//		gblAdd(middleC, 1, 2, 1, 1);
//		gblAdd(storage, 2, 2, 1, 1);
		
		// 재료 수량
		JPanel pAmount = new JPanel();
		amount = new JLabel("재료 수량/중량");
		amountTa = new JTextField(20);
		String[] danw = {"kg","L"};
		danw1 = new JComboBox(danw);
		
		pAmount.add(amount);
		pAmount.add(amountTa);
		pAmount.add(danw1);
		gblAdd(pAmount, 0, 3, 4, 1);
//		gblAdd(amount, 0, 3, 1, 1);
//		gblAdd(amountTa, 1, 3, 1, 1);
//		gblAdd(danw1, 2, 3, 1, 1);
		
		// 가격
		JPanel panePrice = new JPanel(); 
		price = new JLabel("가격");
		priceTa = new JTextField(20);
		won1 = new JLabel("원");
		
		panePrice.add(price);
		panePrice.add(priceTa);
		panePrice.add(won1);
		gblAdd(panePrice, 0, 4, 4, 1);
		
		// 단위 당 가격
		JPanel panepPrice = new JPanel();
		won2 = new JLabel("원");
		dang = new JLabel("당");
		panePrice.add(dang);
		pPriceTa = new JTextField(20);
		panePrice.add(pPriceTa);
		panePrice.add(won2);
		gblAdd(panepPrice, 0, 5, 4, 1);
		
		// 기한
		JPanel paneYear = new JPanel();
		pYear = new JLabel("제조연월일");
		pYearTa = new JTextField(20);
		
		eYear = new JLabel("유통기한");
		eYearTa = new JTextField(20);
		
		paneYear.add(pYear);
		paneYear.add(pYearTa);
		paneYear.add(eYear);
		paneYear.add(eYearTa);
		gblAdd(paneYear, 0, 6, 4, 1);
		
		
	}

	public void gblAdd(JComponent c, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gbl.setConstraints(c, gbc);
		gbc.insets = new Insets(5,5,5,5);
		getContentPane().add(c,gbc);
	}
	
	public static void main(String[] args) {
		new DetailInfo();
		
	}

}
