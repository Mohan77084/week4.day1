package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Html1 {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(" ");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	List<WebElement> tables = driver.findElements(By.xpath("//table"));
	System.out.println("Total number tables : "+tables.size());
	for(int i = 1;i<=tables.size();i++) {
		List<WebElement> rows = driver.findElements(By.xpath("(//table)["+i+"]//tr"));
		System.out.println("No. of rows in table " +i+ " is : " + (rows.size()-1) );
		List <WebElement> columns = driver.findElements(By.xpath("(//table)["+i+"]//tr//th"));
		System.out.println("No.class of columns in table "+i+" is : "+columns.size());
	}
driver.close();
}
}
