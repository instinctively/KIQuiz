package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class Finder extends MainClass {

	private static final long MAX_WAIT_MILLI_SEC = 60000;
	public String quizNameXPath = "//div[contains(@class,'quizTitle')]";
	public String quizQuestionXPath = "//div[contains(@class,'quizQuestion')]";
	public String quizAnswerXPath = "//span[contains(@class,'answerText')]";
	public String quizAnswerBox = "//span[contains(.,'Stars')]/../span[contains(@class,'answerBox')]";
	public String nextQuestion = "nextQuestion";
	WebDriver driver = null;
	
	public WebElement findElement(By by) {
		WebDriver driver = LocalDriverManager.getBrowserInstance();
		return driver.findElement(by);
	}

	public void solveQuiz(WebDriver driver) {
		System.out.print("Inside solveQuiz \n");
		//waitForPageContainsWebElement(By.xpath("//div[contains(@class,'quizTitle')]"));
		driver.findElement(By.xpath("//div[contains(@class,'quizTitle')]"));
		driver.findElement(By.id("quizContainer"));
		System.out.print("quiz text is : " + driver.findElement(By.id("quizContainer")).getText());
	}
}
