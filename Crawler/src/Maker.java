import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Maker {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "F:\\Eclipse\\SpringMVC\\Crawler\\lib\\chromedriver.exe");		 
        WebDriver webDriver= new ChromeDriver();
        webDriver.get("https://bscscan.com/dextracker?q=0xfb62ae373aca027177d1c18ee0862817f9080d08");
//        for(int i=2;i<=400;i++) {

        	List<WebElement> elements=  webDriver.findElements(By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div[2]"));
            for (WebElement webElement : elements) {
//            	WebElement text=webElement.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div[1]/div[5]/table/tbody/tr[1]/td[3]/div/a/div/div"));
//            	System.out.println(text.getText());
            	int i=1;
            	while(i<=25) {
            		String xpat="//*[@id=\"content\"]/div[2]/div/div[2]/div[2]/table/tbody/tr[1]/td[3]";
            		System.out.println(xpat);
            	String text=webElement.findElement(By.xpath(xpat)).getText();
            	System.out.println(text);
            	i++;
            	}
            	//*[@id="__next"]/div/div[1]/div[2]/div/div[1]/div[5]/table/tbody/tr[3]/td[3]/div/a/div/div
            	//*[@id="__next"]/div/div[1]/div[2]/div/div[1]/div[5]/table/tbody/tr[4]/td[3]/div/a/div/div
            	//*[@id="__next"]/div/div[1]/div[2]/div/div[1]/div[5]/table/tbody/tr[5]/td[3]/div/a/div/div
//            }
//            String url = "https://coinmarketcap.com/?page=" + String.valueOf(i+1);
//            System.out.println(url);
//            webDriver.get(url);
//        }
        }
	//*[@id="content"]/div[2]/div/div[2]/div[2]/table/tbody/tr[1]/td[3]
    //*[@id="content"]/div[2]/div/div[2]/div[2]/table/tbody/tr[2]/td[3]
}
}
