package com.wipro.telstra.test.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.wipro.telstra.test.pageObjects.FlipkartHomePage;
import com.wipro.telstra.test.setup.BaseTestPage;
import com.wipro.telstra.test.utility.CommonMethods;
import com.wipro.telstra.test.utility.TelstraVerification;

public class FlipkartTestCases extends BaseTestPage {

	// Flipkart automation
	@Test
	public void tcRT_10() throws Exception {
		FlipkartHomePage flipkartHomePage = new FlipkartHomePage(driver);
		flipkartHomePage.login(userName, passWord);
		flipkartHomePage.textBoxSearch.sendKeys("Camera");
		flipkartHomePage.buttonSearchIcon.click();
		Thread.sleep(2000);
		CommonMethods.scrollToWebElement(driver, flipkartHomePage.cameraLink);
		Thread.sleep(2000);
		ArrayList<String> actDataSearchScreen = new ArrayList<String>();
		actDataSearchScreen.add(flipkartHomePage.dataCheck(driver, "Effective Pixels: 20.1 MP").getText());
		actDataSearchScreen.add(flipkartHomePage.dataCheck(driver, "Optical Zoom: 6 | Digital Zoom: 12x").getText());
		actDataSearchScreen.add(flipkartHomePage.dataCheck(driver, "Auto Focus").getText());
		actDataSearchScreen.add(flipkartHomePage.dataCheck(driver, "Display Size: 3.2").getText());
		System.out.println(actDataSearchScreen);
		flipkartHomePage.cameraLinkClick.click();
		Thread.sleep(3000);
		String parentWinHandle = driver.getWindowHandle();
		Set<String> openWindows = driver.getWindowHandles();
		for (String handle : openWindows) {
			if (!handle.equals(parentWinHandle)) {
				driver.switchTo().window(handle);
			}
		}
		System.out.println(driver.getTitle());
		TelstraVerification.verifyImagePresentOrNot(driver, flipkartHomePage.imageCamera);
		CommonMethods.scrollToWebElement(driver, flipkartHomePage.labelHighlights);
		ArrayList<String> dataCheckoutScreen = new ArrayList<String>();
		List<WebElement> actualHeaders = flipkartHomePage.dataCheckoutScreen;
		for (WebElement headers : actualHeaders) {

			dataCheckoutScreen.add(headers.getText());
		}
		TelstraVerification.verifyTwoLists(actDataSearchScreen, dataCheckoutScreen);
		Thread.sleep(2000);
		flipkartHomePage.buttonAddToCart.click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(flipkartHomePage.labelMyAccounts).perform();
		Thread.sleep(2000);
		flipkartHomePage.buttonLogout.click();
	}

}
