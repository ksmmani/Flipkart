package com.wipro.telstra.test.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wipro.telstra.test.setup.BasePage;

public class FlipkartHomePage extends BasePage {

	public FlipkartHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	WebDriver driver;

	// Xpath for the Login button
	@FindBy(xpath = "//*[@href='/account/login?ret=/']")
	public WebElement buttonLoginSignUp;

	// Xpath for the email/phone number input
	@FindBy(xpath = "//input[@class='_2zrpKA _1dBPDZ']")
	public WebElement inputEmail;

	// Xpath for the password
	@FindBy(xpath = "//input[@class='_2zrpKA _3v41xv _1dBPDZ']")
	public WebElement inputPassword;

	// Xpath for the login button
	@FindBy(xpath = "//button//span")
	public WebElement buttonLogin;

	public void login(String userName, String passWord) throws InterruptedException {

		inputEmail.sendKeys(userName);
		inputPassword.sendKeys(passWord);
		buttonLogin.click();
		Thread.sleep(5000);
	}

	// Xpath for the search in home screen
	@FindBy(xpath = "//input[@class='LM6RPg']")
	public WebElement textBoxSearch;

	// Xpath for the search icon
	@FindBy(xpath = "//button[@class='vh79eN']")
	public WebElement buttonSearchIcon;

	// Xpath for a random camera link
	@FindBy(xpath = "//div[text()='Sony CyberShot DSC-W800/SC IN5']")
	public WebElement cameraLink;
	
	//Xpath for the link
	@FindBy(xpath = "//div[@data-id='CAMDVGUGJ4G5FVDM']")
	public WebElement cameraLinkClick;
	
	public WebElement dataCheck(WebDriver driver, String data) {
		return driver.findElement(By.xpath("//li[text()='"+ data+ "']"));
	}
	
	//Xpath for the camera image
	@FindBy(xpath = "//div[@class='_3BTv9X _3iN4zu']/img")
	public WebElement imageCamera;
	
	//Xpath for the data in checkout screen
	@FindBy(xpath = "//div[@class='_3WHvuP']/ul")
	public List<WebElement> dataCheckoutScreen;
	
	//Xpath for the data section
	@FindBy(xpath = "//div[text()='Highlights']")
	public WebElement labelHighlights;
	
	//Xpath for the Add to cart
	@FindBy(xpath = "//button[text()='ADD TO CART']")
	public WebElement buttonAddToCart;
	
	//Xpath for the My Accounts
	@FindBy(xpath = "//*[@class='_2aUbKa']")
	public WebElement labelMyAccounts;
	
	//Xpath for logout button
	@FindBy(xpath = "//*[contains(text(),'Logout')]")
	public WebElement buttonLogout;
	

}