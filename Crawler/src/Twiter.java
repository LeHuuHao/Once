import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Twiter {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "F:\\Eclipse\\SpringMVC\\Crawler\\lib\\chromedriver.exe");		 
        WebDriver webDriver= new ChromeDriver();
        webDriver.get("https://coinmarketcap.com/");
//        for(int i=2;i<=400;i++) {

//        	List<WebElement> elements=  webDriver.findElements(By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div[2]"));
        WebElement element=webDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div/div[5]/table/tbody/tr[2]/td[3]/div/a/div/div/p"));
        System.out.println(element.getText());
        String url = "https://twitter.com/"+element.getText() ;
        System.out.println(url);
        webDriver.get(url);
    	WebElement element2=webDriver.findElement(By.id("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div/div/div[2]/div/div/div[2]/section/div/div/div[1]/div/div/article/div/div/div/div[2]"));
    	System.out.println(element2.getText());
    	//*[@id="react-root"]/div/div/div[2]/main/div/div/div/div/div/div[2]/div/div/div[2]/section/div/div
      //*[@id="__next"]/div/div[1]/div[2]/div/div[1]/div[5]/table/tbody/tr[3]/td[3]/div/a/div/div/p
      //*[@id="__next"]/div/div[1]/div[2]/div/div[1]/div[5]/table/tbody/tr[2]/td[3]/div/a/div/div/p
    	//*[@id="react-root"]/div/div/div[2]/main/div/div/div/div/div/div[2]/div/div/div[2]/section/div/div/div[1]/div/div/article/div/div/div/div[2]/div[2]
    	//*[@id="react-root"]/div/div/div[2]/main/div/div/div/div/div/div[2]/div/div/div[2]/section/div/div/div[1]/div/div/article/div/div/div/div[2]/div[2]
	//*[@id="content"]/div[2]/div/div[2]/div[2]/table/tbody/tr[1]/td[3]
    //*[@id="content"]/div[2]/div/div[2]/div[2]/table/tbody/tr[2]/td[3]
        ////*[@id="react-root"]/div/div/div[2]/main/div/div/div/div/div/div[2]/div/div/div[2]/section/div/div
	}

}
