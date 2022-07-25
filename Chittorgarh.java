package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {
	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.chittorgarh.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//a[text()='STOCK MARKET ']")).click();
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
		WebElement table = driver.findElement(By.xpath("//div[@class='col-12 table-responsive']"));
		List<WebElement> rows = table.findElements(By.xpath("//div[@class='col-12 table-responsive']//tr"));
		List<String> securityNames = new ArrayList<>();
		for(int i =1;i<rows.size();i++) {
		List<WebElement> column = table.findElements(By.xpath("//div[@class='col-12 table-responsive']//tr["+i+"]//td[3]"));
		for (WebElement eachElement : column) {
			securityNames.add(eachElement.getText());
		}
		}
		System.out.println(securityNames);
		Set<String> securityNames2 = new LinkedHashSet<>(securityNames);
		System.out.println(securityNames2);
		if(securityNames.size()>securityNames2.size()) {
			System.out.println("The list contains duplicate elements");
		}
		driver.quit();
	}
	}


