package MainPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FacebookTest {

	@Test
	public void loginPage() throws Exception {
		// setting the chrome browser property and passing the chrome driver path
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		// driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("swapnil");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("s");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9595976127");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("12345");
		Thread.sleep(2000);
		WebElement dd = driver.findElement(By.xpath("//select[@id='day']"));
		Select bm = new Select(dd);
		bm.selectByValue("7");
		System.out.println(bm.getFirstSelectedOption().getText());
		Thread.sleep(2000);
		List<WebElement> drop = driver.findElements(By.xpath("//select[@id='month']/option"));
		System.out.println("Total month size-" + drop.size());
		drop.get(2).click();
		// dd.sendKeys("3");
		WebElement year = driver.findElement(By.id("year"));
		// Select select = new Select(year);
		year.sendKeys("1994");

		Thread.sleep(2000);
		// handle radio button
		List<WebElement> radios = driver.findElements(By.xpath("//label[@class='_58mt']"));
		Thread.sleep(2000);

		System.out.println("Total radios=" + radios.size());
		Thread.sleep(2000);
		String male = "Male";
		String female = "Female";
		String custome = "Custome";

		for (int i = 0; i < radios.size(); i++) {

			if (radios.get(i).getText().equalsIgnoreCase(male)) {
				radios.get(i).click();
				System.out.println("button clicked=" + male);
			}

			else if (radios.get(i).getText().equals(female)) {
				radios.get(i).click();
				System.out.println("clicked=" + female);
			} else if (radios.get(i).getText().equalsIgnoreCase(custome)) {
				radios.get(i).click();
				System.out.println("cliked=" + custome);

				break;
			}
		}
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		System.out.println("create account page working properly");
		Thread.sleep(2000);
	

		driver.close();
		
		System.out.println("create new account page working properly");

	}

}
