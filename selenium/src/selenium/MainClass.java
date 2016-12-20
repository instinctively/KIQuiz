package selenium;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;

public class MainClass extends SeleniumHelper {


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



	public static void main(String[] args) throws AWTException, InterruptedException, FindFailed, IOException {

		Quizes quiz = Quizes.GeometricShapes;
		WebDriver driver = BaseTestHelper.createChromeDriverInstance();
		String baseUrl = quiz.getUrl();

		driver.get(baseUrl);

		ArrayList<String> tabs_windows = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs_windows.get(1));
		driver.close();
		driver.switchTo().window(tabs_windows.get(0));

		driver.get(baseUrl);

		driver.manage().window().maximize();
		waitForWebElementVisible(driver, By.id("nextQuestion"));
		WebElement quizContainer = driver.findElement(By.className("quizTitle"));
		System.out.print("quiz name is : " + quizContainer.getText() + "\n");
		Solver.solveQuiz(driver, quiz.getName());
		driver.close();
	}
}