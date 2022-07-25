package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Html2 {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://html.com/tags/table/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	List <WebElement> rows = driver.findElements(By.xpath("(//table)[1]//tr"));
	for(int i=0;i<rows.size()-1;i++) {
		System.out.println(rows.get(i).getText());
	}
	driver.close();
}
}
