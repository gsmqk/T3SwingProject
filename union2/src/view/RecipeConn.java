package view;


import static com.teamdev.jxbrowser.engine.RenderingMode.*;
 
import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.view.swing.BrowserView;
 
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public final class RecipeConn extends FindRecipe {
	private Engine engine;
	private static Browser browser;
	private static BrowserView view;
	
	public static void findrecipe() {
		Engine engine = Engine.newInstance(
				EngineOptions.newBuilder(HARDWARE_ACCELERATED)
				.licenseKey("6P830J66YC0VMLH8ONZ4PQ0KLT7YG0JXQME37LH3IGBXQ35F5EIKU07WRCQFERM91A0T")
				.build());

		browser = engine.newBrowser();

		SwingUtilities.invokeLater(() -> {
			view = BrowserView.newInstance(browser);

			JFrame frame = new JFrame("레시피 검색");
			frame.add(view, BorderLayout.CENTER);
			frame.setSize(900, 1000);
			frame.setVisible(true);

			//	browser.navigation().loadUrl("https://naver.com");
			
			
			// 레시피 네이버 검색
			String url  = "https://search.naver.com/search.naver";
			url        += "?where=nexearch&sm=top_hty&fbm=1&ie=utf8";
			url        += "&query=";
			url        += foodList.getText();
			url        += "레시피";
			browser.navigation().loadUrl( url );
		
		});
	}
	
public static void main(String[] args) {

}

}