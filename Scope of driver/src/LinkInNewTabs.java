import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkInNewTabs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// get the count of links present on webpage
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		// get the link counts which are present in footer section
		// and here limiting scope of driver concept come into picture
		WebElement footerDriver=driver.findElement(By.id("gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		// we have limited scope of driver only to footer section
		
		//to get the count of links present in first column of footer section 
		WebElement columndriver=footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		//click the links present on the first column except first link "Discounts coupons"
		// because it is pointing to same page
		for(int i=1;i<columndriver.findElements(By.tagName("a")).size();i++)
		{
			//String clickOnLink=Keys.chord(Keys.CONTROL,Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(Keys.CONTROL,Keys.ENTER);
			// we use ctrl + click to open a link in new tab
			// same we used ctrl + entr button to open link in new tab
		}
		
		// get the titles of all the windows opened in browser
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		while(i1.hasNext())
		{
			driver.switchTo().window(i1.next());
			System.out.println(driver.getTitle());
			
		}

	}

}
