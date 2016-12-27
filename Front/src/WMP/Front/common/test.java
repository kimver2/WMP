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

public class test {
	
	private static WebDriver driver;
	static String wmp_main = "http://www.wemakeprice.com";
	
  @BeforeTest
  public void beforeTest() throws Exception {
	  	  
	  // Chrome 호출
	  System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  
	  driver.get(wmp_main);

	  driver.findElement(By.className("btn_email_close")).click();

	  driver.manage().window().maximize();
  }
  
  
  
  //우측 배너(Right_Promotion_Banner)
  @Test
  public void Right_Promotion_Banner() throws Exception {
		List<WebElement> RightPromotionBanner = driver.findElements(By.id("right_top_event_banner"));
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
  
  
//  //오늘의 혜택 배너(today_deal_banner)
//  @Test
//  public void today_deal_banner() throws Exception {
//		List<WebElement> todaydealbanner = driver.findElements(By.xpath("//ul[@id='today_deal_banner']/li/a/img"));
//		System.out.println("오늘의 혜택 수 : "  + todaydealbanner.size());
//		
//		for(int i=1; i <= todaydealbanner.size(); i++){
//			driver.findElement(By.xpath("//ul[@id='today_deal_banner']/li[" + i + "]/a/img")).click();
//			System.out.println("오늘의 혜택 " + i + "번 완료.");
//			System.out.println(driver.getCurrentUrl());
//			Thread.sleep(3000);
//			driver.navigate().back();
//		}
//		Thread.sleep(2000);
//		System.out.println("오늘의 혜택 배너 Check 완료.");
//  }
  
  
  
  
  }
