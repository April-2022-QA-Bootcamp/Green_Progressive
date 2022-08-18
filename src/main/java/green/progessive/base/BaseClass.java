package green.progessive.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import green.progressive.utils.ReadConfigFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public ReadConfigFile readConfigFile = new ReadConfigFile(null);
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = localDriver("chrome");
		driver.get(readConfigFile.getReadConfigFile("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(
				Duration.ofSeconds(Integer.parseInt(readConfigFile.getReadConfigFile("pageLoadWait"))));
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(readConfigFile.getReadConfigFile("implicitWait"))));

	}

	private WebDriver localDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();

		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();

		} else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
		}
		return driver;
	}
	protected WebDriver getDriver() {
		return driver;
	}
	private void initClasses() {
		
	}
	@AfterMethod
	public void terminate() {
		driver.quit();
	}

}
