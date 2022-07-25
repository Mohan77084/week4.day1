package week4.day1;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Table {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://www.leafground.com/pages/table.html");
	WebElement tableElement = driver.findElement(By.tagName("table"));
	List<WebElement> rows = tableElement.findElements(By.tagName("tr"));
	System.out.println("Count of no. of rows : " + (rows.size()-1));
	List<WebElement> columns = tableElement.findElements(By.tagName("th"));
	System.out.println("Count of no. of columns : " + columns.size());
	for(int i=1;i<rows.size();i++) {
		WebElement eachRow = rows.get(i);
		List<WebElement> elementCol = eachRow.findElements(By.tagName("td"));
		for(int j= 0; j < elementCol.size() ;j++) {
			if(elementCol.get(j).getText().contains("Learn to interact with Elements")) {
			System.out.println("Progress : "+(rows.get(i).getText()));
			}
			}
	}
	List<WebElement> progressValueElement = driver.findElements(By.xpath("//table//tr//td[2]"));
	List<Integer> progressValue = new ArrayList<>();
	for (WebElement eachElement : progressValueElement) {
		progressValue.add(Integer.parseInt(eachElement.getText().replace("%", "")) );
	}
	int value = progressValue.get(0);
	int minValue = 0;
	for(int i = 0;i<progressValue.size();i++) {
		if(value>progressValue.get(i)) {
			value = progressValue.get(i);
			minValue = minValue+2;
		}
	}
	driver.findElement(By.xpath("//table//tr["+minValue+"]//td[3]")).click();
	boolean enabled = driver.findElement(By.xpath("(//input[@name='vital'])[5]")).isEnabled();
	if(enabled) {
		System.out.println("Vital task for the least completed progress is checked");
	}
	else {
		System.out.println("Vital task for the least completed progress is not checked");
	}
	driver.close();
}
}

