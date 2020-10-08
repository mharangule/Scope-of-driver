import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignMent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("#checkBoxOption3")).click();
		String text=driver.findElement(By.cssSelector("label[for='honda']")).getText();
		Select s=new Select (driver.findElement(By.cssSelector("select#dropdown-class-example")));
		s.selectByVisibleText(text);
		driver.findElement(By.cssSelector("#name")).sendKeys(text);
		driver.findElement(By.cssSelector("#alertbtn")).click();
		Alert alert = driver.switchTo().alert();
		if(alert.getText().contains(text))
		{
			System.out.println("Alert contains the selecte checkbox's text");
			alert.accept();
		}
		
	}
	

}
