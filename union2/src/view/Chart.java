package view;

	 
	import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

import model.ExpenseChart_Dao;
import model.ExpireChart_DTO;
import model.ExpireChart_Dao;
import model.G_Dao;

	 

	/**

	 * A simple demonstration application showing how to create a bar chart overlaid

	 * with a line chart.

	 */

	public class Chart extends JFrame {

		public Chart() {
			init();
		}
		
		private void init() {
			 Chart demo = new Chart();

			 ExpireChart_Dao expire_dao = new ExpireChart_Dao();
			 String id = "sky";
			 ArrayList<ExpireChart_DTO> elist = expire_dao.getExpireChartList(id);
			 

             JFreeChart chart = demo.getChart(elist);

             ChartFrame frame1=new ChartFrame("Bar Chart",chart);

             frame1.setSize(800,500); 

             frame1.setVisible(true);

             
             
		}
		

	       // Run As > Java Application 으로 실행하면 바로 확인할 수 있음.

	  
	   

	    public JFreeChart getChart(ArrayList<ExpireChart_DTO> elist) {

	      

	        // 데이터 생성

	        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();                // bar chart 1

	     // DefaultCategoryDataset dataset12 = new DefaultCategoryDataset();         // bar chart 2

	        
	        //

	 

	        // 데이터 입력 ( 값, 범례, 카테고리 )

	        // 지출액 그래프 1       
	        String ii = String.valueOf(elist.get(2));
	        dataset1.addValue(Integer.parseInt(ii), "지출액", "1월");
	        System.out.println(Integer.parseInt(ii));
	        
	       
	        
//	        dataset1.addValue(getExpire_amount(2), "지출액", "2월");
//
//	        dataset1.addValue(getExpire_amount(2), "지출액", "3월");
//
//	        dataset1.addValue(getExpire_amount(2), "지출액", "4월");
//
//	        dataset1.addValue(getExpire_amount(2), "지출액", "5월");
//
//	        dataset1.addValue(getExpire_amount(2), "지출액", "6월");
//
//	        dataset1.addValue(getExpire_amount(2), "지출액", "7월");
//
//	        dataset1.addValue(getExpire_amount(2), "지출액", "8월");
//
//	        dataset1.addValue(getExpire_amount(2), "지출액", "9월");
//
//	        dataset1.addValue(getExpire_amount(2), "지출액", "10월");
//
//	        dataset1.addValue(getExpire_amount(2), "지출액", "11월");
//
//	        dataset1.addValue(getExpire_amount(2), "지출액", "12월");

	 

	        // 폐기액 그래프 2     

	        dataset1.addValue(5000, "폐기액", "1월");

	        dataset1.addValue(4000, "폐기액", "2월");

	        dataset1.addValue(3000, "폐기액", "3월");

	        dataset1.addValue(5000, "폐기액", "4월");

	        dataset1.addValue(6000, "폐기액", "5월");

	        dataset1.addValue(1000, "폐기액", "6월");

	        dataset1.addValue(2000, "폐기액", "7월");

	        dataset1.addValue(3000, "폐기액", "8월");

	        dataset1.addValue(6000, "폐기액", "9월");

	        dataset1.addValue(8000, "폐기액", "10월");

	        dataset1.addValue(9000, "폐기액", "11월");

	        dataset1.addValue(5000, "폐기액", "12월");

	 

	        // 렌더링 생성 및 세팅

	        // 렌더링 생성

	        final BarRenderer renderer = new BarRenderer();

	  //    final BarRenderer renderer12 = new BarRenderer();


	       

	        // 공통 옵션 정의

	        final CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();

	        final ItemLabelPosition p_center = new ItemLabelPosition(

	                ItemLabelAnchor.CENTER, TextAnchor.CENTER

	            );

	        final ItemLabelPosition p_below = new ItemLabelPosition(

	                     ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_LEFT

	                     );

	        Font f = new Font("D2Coding", Font.BOLD, 14);

	        Font axisF = new Font("D2Coding", Font.PLAIN, 14);
	        

	       

	        // 렌더링 세팅

	        // 그래프 1

	        renderer.setBaseItemLabelGenerator(generator);

	        renderer.setBaseItemLabelsVisible(true);

	        renderer.setBasePositiveItemLabelPosition(p_center);

	        renderer.setBaseItemLabelFont(f);

//	        renderer.setGradientPaintTransformer(new StandardGradientPaintTransformer(

//	                GradientPaintTransformType.VERTICAL));

//	        renderer.setSeriesPaint(0, new GradientPaint(1.0f, 1.0f, Color.white, 0.0f, 0.0f, Color.blue));

	        renderer.setSeriesPaint(0, new Color(0,162,255));

	 

	        // 그래프 2       

	        renderer.setSeriesPaint(0, new Color(232,168,255));

	        renderer.setBaseItemLabelFont(f);

	        renderer.setBasePositiveItemLabelPosition(p_center);

	        renderer.setBaseItemLabelGenerator(generator);

	        renderer.setBaseItemLabelsVisible(true);
	       

	        // plot 생성

	        final CategoryPlot plot = new CategoryPlot();

	       

	        // plot 에 데이터 적재

	        plot.setDataset(dataset1);

	        plot.setRenderer(renderer);

//	        plot.setDataset(1,dataset1);

//	        plot.setRenderer(1,renderer);


	        // plot 기본 설정

	        plot.setOrientation(PlotOrientation.VERTICAL);             // 그래프 표시 방향

	        plot.setRangeGridlinesVisible(true);                       // X축 가이드 라인 표시여부

	        plot.setDomainGridlinesVisible(true);                      // Y축 가이드 라인 표시여부

	 

	        // 렌더링 순서 정의 : dataset 등록 순서대로 렌더링 ( 즉, 먼저 등록한게 아래로 깔림 )

	        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

	       

	        // X축 세팅

	        plot.setDomainAxis(new CategoryAxis());              // X축 종류 설정

	        plot.getDomainAxis().setTickLabelFont(axisF); // X축 눈금라벨 폰트 조정

	        plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD);       // 카테고리 라벨 위치 조정

	 

	        // Y축 세팅

	        plot.setRangeAxis(new NumberAxis());                 // Y축 종류 설정

	        plot.getRangeAxis().setTickLabelFont(axisF);  // Y축 눈금라벨 폰트 조정

	       

	        // 세팅된 plot을 바탕으로 chart 생성

	        final JFreeChart chart = new JFreeChart(plot);

	        chart.setTitle("연간 지출액/폐기액 비교 그래프"); // 차트 타이틀

//	        TextTitle copyright = new TextTitle("JFreeChart WaferMapPlot", new Font("SansSerif", Font.PLAIN, 9));
	        

//	        copyright.setHorizontalAlignment(HorizontalAlignment.RIGHT);

//	        chart.addSubtitle(copyright);  // 차트 서브 타이틀

	        return chart;

	    }

	    public static void main(final String[] args) {
		      new Chart();
	    }



	 

	}
