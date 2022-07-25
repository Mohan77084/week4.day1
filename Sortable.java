package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
// To drag and drop 'Item 7' as first element
public class Sortable {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://www.leafground.com/pages/sortable.html");
	WebElement source = driver.findElement(By.xpath("//li[text()='Item 7']"));
	WebElement target = driver.findElement(By.xpath("//li[text()='Item 1']"));
	Actions builder = new Actions(driver);
	builder.dragAndDrop(source, target).perform();
	String text = driver.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle'])[1]")).getText();
	if(text.equals("Item 7")){
		System.out.println(text+" is drag and dropped correctly");
	}
	else {
		System.out.println(text+" is not drag and dropped correctly");
	}
	Thread.sleep(3000);
	driver.close();
}
}
