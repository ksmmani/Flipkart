package com.wipro.telstra.test.utility;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.wipro.telstra.test.setup.BaseTestPage;

public class CommonMethods extends BaseTestPage {

	public void useJavaScriptClick(WebDriver driver, WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click -->" + element.getText());

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
				driver.quit();
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			throw new ElementNotVisibleException("Element not Visible to click");
		} catch (Exception e) {
			System.out.println("Unable to click on element " + e.getStackTrace());
		}
	}

	// Scrolling to bottom of page
	public static void scrollingToBottomofAPage(WebDriver driver, String url) {
		driver.navigate().to(url);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	// Scrolling to top of page
	public static void scrollingToTopofAPage(WebDriver driver, String url) {
		driver.navigate().to(url);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -250)", "");
	}

	// Scrolling to the particular Web elements
	public static void scrollToWebElement(WebDriver driver, WebElement locator) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", locator);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
}
