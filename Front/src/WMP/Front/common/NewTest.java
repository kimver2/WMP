package WMP.Front.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
	
	private static WebDriver driver;
	static String wmp_main = "http://www.wemakeprice.com";

  @BeforeTest
  public void beforeTest() {
	  // Chrome 호출
	  System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  
	  // main 호출
	  driver.get(wmp_main);
		
		//간소화 팝업 차단.
		driver.findElement(By.className("btn_email_close")).click();
		
				
		try{
		     File f2 = new File("browser.data");
		     FileReader fr = new FileReader(f2);
		     BufferedReader br = new BufferedReader(fr);
		     String line;
		     while((line=br.readLine())!=null){
		         StringTokenizer str = new StringTokenizer(line,";");
		         while(str.hasMoreTokens()){
		             String name = str.nextToken();
		             String value = str.nextToken();
		             String domain = str.nextToken();
		             String path = str.nextToken();
		             Date expiry = null;
		             String dt;
		             if(!(dt=str.nextToken()).equals("null")){
		                 //expiry = new Date(dt);
		             }
		             boolean isSecure = new Boolean(str.nextToken()).booleanValue();
		             Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);
		             driver.manage().addCookie(ck);
		         }
		     }
		}catch(Exception ex){
		     ex.printStackTrace();
		}
		driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

  @Test
  public void banner_check() {
	  System.out.println("오늘의 혜택");
		List<WebElement> tb = driver.findElements(By.xpath("//ul[@id='today_deal_banner']/li/a/img"));
		int tbc = tb.size();
		System.out.println("오늘의 혜택 수 :"  + tbc);
		
		int i = 0;
		while(i < tbc){
			i++;
			driver.findElement(By.xpath("//ul[@id='today_deal_banner']/li[" + i + "]/a/img")).click();
			Thread.sleep(3000);
//			if (driver.getCurrentUrl().contains("404"))
//			{
//			takeScreenshotofpage(driver, screenpath + "404 error " + getDateTimeStamp()  + ".png");
//		}
//			driver.navigate().back();
//		}
//	  
  }
  
  
  
  
  
  
  
  
  
  /*
    @Test
  //main 접속
  public void TC001() throws Exception {
		driver.get(wmp_main);
		Thread.sleep(2000);
  }
  
  
  @Test
  //BEST카테고리 접속
  public void TC002() throws Exception {
	  driver.get(wmp_main + "/best");
	  Thread.sleep(2000);
  }
   */
  

  
  
}
