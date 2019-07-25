package com.wipro.telstra.test.setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.wipro.telstra.test.utility.ReadFileData;

public class BaseTestPage extends ReadFileData {

	public WebDriver edriver;
	public WebDriverWait wait;
	public static EventFiringWebDriver driver;
	public String currnetlocation = System.getProperty("user.dir");

	@Parameters({ "browser" })
	@BeforeMethod
	public void openBrowser(@Optional("chrome") String browser) {

		String os = System.getProperty("os.name").toLowerCase();
		try {

			if (browser.equalsIgnoreCase("Firefox")) {
				System.out.println("Launching Firefox browser");
				System.setProperty("webdriver.gecko.driver", currnetlocation + "/Drivers/geckodriver.exe");
				edriver = new FirefoxDriver();
				edriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			} else if (browser.equalsIgnoreCase("chrome")) {
				if (os.contains("mac")) {
					ChromeOptions options = new ChromeOptions();

					options.addArguments("disable-infobars");
					System.out.println("Launching Chrome browser for OS : " + os);
					System.setProperty("webdriver.chrome.driver", currnetlocation + "/Drivers/chromedriver");
					edriver = new ChromeDriver(options);
					edriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					edriver.manage().window().maximize();
				} else {
					ChromeOptions options = new ChromeOptions();

					options.addArguments("disable-infobars");
					System.out.println("Launching Chrome browser");
					System.setProperty("webdriver.chrome.driver", currnetlocation + "/Drivers/chromedriver.exe");
					edriver = new ChromeDriver(options);
					edriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					edriver.manage().window().maximize();

				}

			} else if (browser.equalsIgnoreCase("IE")) {
				System.out.println("Launching IE browser");
				System.setProperty("webdriver.ie.driver", currnetlocation + "/Drivers/IEDriverServer.exe");
				edriver = new InternetExplorerDriver();
				edriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			} else if (browser.equalsIgnoreCase("Edge")) {
				System.out.println("Launching Microsoft Edge browser");
				System.setProperty("webdriver.edge.driver", currnetlocation + "/Drivers/MicrosoftWebDriver.exe");
				edriver = new EdgeDriver();
				edriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			}
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}

		driver = new EventFiringWebDriver(edriver);
		driver.get(getUrl());

	}

	@AfterMethod
	public void quit() {
		driver.quit();

	}

	public WebDriver getDriver() {
		return driver;
	}

}
