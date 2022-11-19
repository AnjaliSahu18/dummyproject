package practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JenkinParameter {
	
	@Test
	public void parameterTest() throws InterruptedException {
		WebDriver driver = null;
		String browser = System.getProperty("browser");
		String ulr = System.getProperty("url");
		
		switch(browser) {
		case "chrome" : WebDriverManager.chromedriver().setup();
		                driver = new ChromeDriver();
		                break;
		
		case "firefox": WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        break;    
         default : System.out.println("Invalid browser data");
            break;           
		}
		driver.manage().window().maximize();
		driver.get(ulr);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);
		driver.quit();
	}

}
