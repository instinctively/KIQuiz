package selenium;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class BaseTestHelper {

	static WebDriver driver;
	public static WebDriver createChromeDriverInstance() {
		String driverLocation = null;
		driverLocation = ".\\driver\\win\\chromedriver.exe";
		driver = new ChromeDriver(chromeDriverSetup(driverLocation));
		return driver;
	}

	private static DesiredCapabilities chromeDriverSetup(String driverLocation) {
		System.setProperty("webdriver.chrome.driver", driverLocation);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.addArguments("--disable-extensions");
		chromeOptions.addArguments("test-type");
		chromeOptions.addExtensions(new File(".\\dropIn\\AdblockPlusv1.12.4.crx"));
		capabilities.setCapability("chrome.binary", driverLocation);
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		return capabilities;
	}
}