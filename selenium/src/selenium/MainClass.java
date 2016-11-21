package selenium;

import java.awt.AWTException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;

import quiz.WorldCapitals;

public class MainClass {

	private static final long MAX_WAIT_MILLI_SEC = 60000;
	public static class LocalDriverManager {
		private static ThreadLocal<WebDriver> browserInstanceHolder = new ThreadLocal<WebDriver>();

		/**
		 * @return the driver instance of the particular thread
		 */
		public static WebDriver getBrowserInstance() {
			return browserInstanceHolder.get();
		}

		public void setBrowserInstance(WebDriver driver) {
			browserInstanceHolder.set(driver);
		}
	}

	public static WebElement waitForPageContainsWebElement(WebDriver driver, By by) {
		long end = System.currentTimeMillis() + MAX_WAIT_MILLI_SEC;
		WebElement webElement = null;
		while (System.currentTimeMillis() < end) {
			try {
				webElement = driver.findElement(by);
				if (webElement != null) {
					break;
				}
			} catch (NoSuchElementException e) {
				// fine
			}
		}
		return webElement;
	}

	public static void main(String[] args) throws AWTException, InterruptedException, FindFailed {
		WorldCapitals worldCapitals = new WorldCapitals();

		WebDriver driver = BaseTestHelper.createChromeDriverInstance();
		Finder finder = new Finder();
		String baseUrl = worldCapitals.url;

		driver.get(baseUrl);

		ArrayList<String> tabs_windows = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs_windows.get(1));
		driver.close();
		driver.switchTo().window(tabs_windows.get(0));

		driver.get(baseUrl);

		driver.manage().window().maximize();  
		waitForPageContainsWebElement(driver, By.className("quizTitle"));
		Thread.sleep(3000);
		WebElement quizContainer = driver.findElement(By.className("quizTitle"));
		System.out.print("quiz name is : " + quizContainer.getText() + "\n");

		finder.solveQuiz(driver);
		driver.close();
	}
}