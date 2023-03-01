package view;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

import model.DBConn;

//public class RealChart extends ApplicationFrame {
  public class RealChart extends JFrame {
	
	private Connection conn = null;
	
	public RealChart() {
		//super(applicationTitle);	
		JFreeChart barChart = ChartFactory.createBarChart("연간 지출액/폐기액 비교 그래프", "월", "금액", createDataset(),
				PlotOrientation.VERTICAL, true, true, false);
		
		// 차트 배경색 지정
		barChart.setBackgroundPaint(Color.PINK);

		 
		//한글 인코딩
		// 그래프 제목, 범례에 한글 적용
		Font f = new Font("맑은 고딕", Font.BOLD, 18);
				
		barChart.getTitle().setFont(f);
		barChart.getLegend().setItemFont(f);
		
		// x축, y축 한글 적용
		CategoryPlot plot1 = barChart.getCategoryPlot();
		plot1.getDomainAxis().setLabelFont(f);     // x축 서브제목
		plot1.getDomainAxis().setTickLabelFont(f); // x축
		plot1.getRangeAxis().setLabelFont(f);      // y축 서브제목
		plot1.getRangeAxis().setTickLabelFont(f);  // y축
		
		plot1.setBackgroundPaint(Color.WHITE);
		//plot1.setBackgroundPaint(Color.CYAN);
		
		
				
				
		
		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(800, 500)); // 크기 설정
		setContentPane(chartPanel);
	}
	

	public CategoryDataset createDataset() {
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		try {
			
			conn = DBConn.getInstance();
			/*
			String driver = "oracle.jdbc.OracleDriver";
			String dburl = "jdbc:oracle:thin:@team3_medium?TNS_ADMIN=D:/Wallet/Wallet_team3";
			String dbuid = "admin";
			String dbpwd = "Swingproject1234";
			Connection conn = null;
			
			Class.forName(driver);
			
			conn = DriverManager.getConnection(dburl, dbuid, dbpwd);
			System.out.println("연결성공");
			*/
			String  sql = "";
			sql    += "SELECT     TO_CHAR(G.INPUT_DATE, 'MM') MONTH, "
					+ "           SUM(G.PRICE) EXPENSE_PRICE, "
					+ "           SUM(E.AMOUNT) DISCARD_PRICE "
					+ " FROM      EXPENSES E, GROCERIES G, GROCERY_EXPIRE GE "
					+ " WHERE     E.GROCERY_ID = G.GROCERY_ID "
					+ " AND       G.GROCERY_ID = GE.GROCERY_ID "
					+ " AND       INPUT_DATE LIKE '22/%' "
					+ " AND       G.USER_ID = 'sky' "
		//			+ " AND       G.USER_ID = ? "
					+ " GROUP BY  TO_CHAR(G.INPUT_DATE, 'MM') "
					+ " ORDER BY  TO_CHAR(G.INPUT_DATE, 'MM') ASC ";
			
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet         rs    = pstmt.executeQuery(); 
			
			while(rs.next()) {
				System.out.println("MONTH : " + rs.getString("MONTH"));
				System.out.println("EXPENSE_PRICE : " + rs.getString("EXPENSE_PRICE"));
				System.out.println("DISCARD_PRICE : " + rs.getString("DISCARD_PRICE"));
				
				// 도표에 지출액 값을 대입, 막대그래프 MONTH, 막대그래프의 값 MONTH
				dataset.addValue(rs.getInt("EXPENSE_PRICE"), "지출액", rs.getString("MONTH"));
				dataset.addValue(rs.getInt("DISCARD_PRICE"), "폐기액", rs.getString("MONTH"));
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return dataset;
	}

	public static void main(String[] args) {
		//new RealChart();
		RealChart chart = new RealChart();		
		chart.pack();
		RefineryUtilities.centerFrameOnScreen(chart);
		chart.setVisible(true);

	}

}
