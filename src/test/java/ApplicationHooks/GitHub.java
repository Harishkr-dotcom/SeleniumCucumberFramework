package ApplicationHooks;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.browser.DriverFactory;
import com.qa.browser.DriverManager;
import com.qa.utils.ReadProperty;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class GitHub {
	private WebDriver driver;
	private DriverFactory driverFactory;
	public static Logger log = Logger.getLogger(GitHub.class.getClass());
	
	@Before
	public void launchBrowser(){
		driverFactory = new DriverFactory();
		driver = driverFactory.setupDriver(ReadProperty.getProperty("Browser"));
		log.info("Browser launched...!");
	}
	
	@After(order=0)
	public void quiteBrowser(){
		driver.quit();
		DriverManager.unloadDriver();
		log.info("Quiting the browser...!");
	}
	
	@After(order=1)
	public void tearDown(Scenario sc){
		if (sc.isFailed()) {
			String screenshotName = sc.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
			sc.attach(sourcePath, "image/png", screenshotName);
		}
	}
	
}
