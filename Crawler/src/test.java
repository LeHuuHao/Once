import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
	@Test
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Eclipse\\SpringMVC\\Crawler\\lib\\chromedriver.exe");		 
        WebDriver webDriver= new ChromeDriver();
        webDriver.get("https://coinmarketcap.com/?fbclid=IwAR0JHgsp2ZUaj_IV4T9_MvmpD4tXqt5tZNH0vEbgfraAmiqjc2qJB-bi6dM");
//        webDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div[1]/div[6]/div/ul/li[*[i]]/a")).click();
        
    for(int i=0;i<76;i++) {
        
//      WebElement word= webDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div[1]/div[5]/table/tbody"));
        List<WebElement> elements=  webDriver.findElements(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div/div[5]"));
        for (WebElement webElement : elements) {
//        	WebElement text=webElement.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div[1]/div[5]/table/tbody/tr[1]/td[3]/div/a/div/div"));
//        	System.out.println(text.getText());
        	String text=webElement.getText();
        	System.out.println(text);

        }
        String url = "https://coinmarketcap.com/?page=" + String.valueOf(i+1);
        System.out.println(url);
        webDriver.get(url);
    }
        
        

//        boolean isCO=true;
//        while(isCO) {
//       	 JavascriptExecutor jaExecutor=  (JavascriptExecutor) webDriver;
//       	 jaExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//       	 isCO=false;
//       	 List<WebElement> elements=  word.findElements(By.xpath("//*[@id=\"news\"]"));
//       	for (WebElement webElement : elements) {
//        	
//       	 String text=webElement.getText();
//      	 System.out.println(text);
//       	 try {
//				FileWriter fw= new FileWriter("data.txt");
//				BufferedWriter bw= new BufferedWriter(fw);
//				bw.write(text);
//				bw.close();
//				fw.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//       	 
//		}
       	 }
      
        ////html/body/div[1]/div[2]/div[1]/div/div[1]/div[1]/div[1]/div[2]
        
        	 
             
             
//             List<WebElement> element2=  word.findElements(By.tagName("span"));
//             for (WebElement webElement : element2) {
//                 
//            	 String text=webElement.getText();
////            	 System.out.println(text);
//            	
//            	 
//     		}
			
		}
	
	//*[@id="detail_pane"]/div[1]/h1/a[2]/span[1]
//        List<WebElement> elements=  webDriver.findElements(By.xpath("/html/body/div[1]"));
//        for (WebElement webElement : elements) {
//        
//        	 System.out.println(webElement.getText());
//		}
        


//	<div class="app-footer"><div class="social-networks"><a href="https://facebook.com/CryptoPanic" target="_blank"><span class="icon icon-facebook"></span></a> <a href="https://twitter.com/CryptoPanicCom" target="_blank"><span class="icon icon-twitter"></span></a> <a href="/discord/"><span class="icon icon-discord"></span></a> <a href="https://t.me/CryptoPanicCom" target="_blank"><span class="icon icon-telegram"></span></a> <a href="https://itunes.apple.com/it/app/cryptopanic/id1290506871?l=en&amp;mt=8" target="_blank"><span class="icon icon-apple"></span></a> <a href="https://play.google.com/store/apps/details?id=com.cryptopanic.android" target="_blank"><span class="icon icon-android"></span></a></div> <div class="nav"><a href="/advertise/">Advertise</a> <a href="/developers/" class="">Developers</a> <a href="/about/">About</a> <a href="/contact/">Contact</a> <a href="/terms/">Terms</a></div> <div class="copy">
//    © CryptoPanic.com //*[@id="detail_pane"]/div[1]/h1/a[2]/span[1]
//</div></div><div class="mobile-header hidden-mobile-up border-bottom"><a href="" class="back-link"><span class="icon icon-left-open"></span> <span class="text">BACK</span></a> <a href="" class="home-link"><span class="text">HOME</span> <img src="https://static.cryptopanic.com/static/img/cryptopanic-logo-wolf-only.7f4291fcd61f.svg" alt="" class="mobile-logo"></a></div>
