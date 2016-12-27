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

public class MainPage {
	
	private static WebDriver driver;
	static String wmp_main = "http://www.wemakeprice.com";
	
	/* [BeforeTest]
	 * 1. Chrome 호출.
	 * 2. www.wemakeprice.com 접속 > 간소화 팝업 닫기.
	 * 3. 로그인 쿠키 적용 > www.wemakeprice.com 호출. 
	 */
	
  @BeforeTest
  public void beforeTest() throws Exception {
	  	  
	  // Chrome 호출
	  System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  System.out.println("Browser Open.");
	  
	  // main 호출
	  driver.get(wmp_main);
	  System.out.println("Main Page Opne.");
		
	  //간소화 팝업 차단.
	  driver.findElement(By.className("btn_email_close")).click();
	  System.out.println("간소화 팝업 제거 완료.");
				
	  // 로그인 쿠키 적용.		
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
		
		System.out.println("로그인 쿠키 적용 완료.");
		
		// Browser 최대화
		driver.manage().window().maximize();
		System.out.println("Browser 최대화 완료.");
		
		// www.wemakeprice.com 호출.
		driver.get(wmp_main);
		Thread.sleep(2000);
		System.out.println("BeforeTest 수행 완료.");
  }
  
 
  @AfterTest
  public void afterTest() {
	  driver.close();
	  System.out.println("Browser Close");
  }
  
  
  
  
  //우측 배너(Right_Promotion_Banner)
  @Test
  public void Right_Promotion_Banner() throws Exception {
		List<WebElement> RightPromotionBanner = driver.findElements(By.xpath("//ul[@id='right_top_event_banner']/li/a/img"));
		System.out.println("우측 배너 수 : "  + RightPromotionBanner.size());
				
		for (int i=1; i<=RightPromotionBanner.size(); i++){
			driver.findElement(By.xpath("//ul[@id='right_top_event_banner']/li[" + i + "]/a/img")).click();
			System.out.println("우측 배너 " + i + "번 완료.");
			System.out.println(driver.getCurrentUrl());
			Thread.sleep(2000);
			driver.navigate().back();
		}
		Thread.sleep(2000);
		System.out.println("우측 배너 Check 완료.");
  }
  
  
  //오늘의 혜택 배너(today_deal_banner)
  @Test
  public void today_deal_banner() throws Exception {
		List<WebElement> todaydealbanner = driver.findElements(By.xpath("//ul[@id='today_deal_banner']/li/a/img"));
		System.out.println("오늘의 혜택 수 : "  + todaydealbanner.size());
		
		for(int i=1; i <= todaydealbanner.size(); i++){
			driver.findElement(By.xpath("//ul[@id='today_deal_banner']/li[" + i + "]/a/img")).click();
			System.out.println("오늘의 혜택 " + i + "번 완료.");
			System.out.println(driver.getCurrentUrl());
			Thread.sleep(3000);
			driver.navigate().back();
		}
		Thread.sleep(2000);
		System.out.println("오늘의 혜택 배너 Check 완료.");
  }
  
  

  
  
  
  
  
  
  
  
 
//  @Test
//  //main 접속
//  public void TC001() throws Exception {
//		driver.get(wmp_main);
//		Thread.sleep(2000);
//		System.out.println("main");
//		
//  }
//  
//  
//  @Test
//  //BEST카테고리 접속
//  public void TC002() throws Exception {
//	  driver.get(wmp_main + "/best");
//	  Thread.sleep(2000);
//  }
  
  

  
  
  }
