package Package1;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectModel {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public Actions actions;
	public String emailStr = "allan.carlo.t.ramos@gmail.com";
	public String passwordStr = "Alvar0Del";
	public String iphoneStr = "Apple iPhone 6, GSM Unlocked, 64GB - Space Gray (Renewed)";
	public String altStr = "Apple iPhone 6, GSM Unlocked, 64GB - Space Gray (Renewed)";
	public String samsungStr = "Net10 Samsung Galaxy J7 Crown 4G LTE Prepaid Smartphone";
	public String shoppingCartStr = "shopping cart";
	public String authenticationRequiredStr = "authentication required";

	/**
	 * Login Page 
	 */
	
	public By accountLists = 
		By.xpath("//a[@id='nav-link-accountList']");
	public By signIn = By.xpath("//a[@data-nav-ref='nav_signin']");
	public By email = By.id("ap_email");
	public By continueButton = By.id("continue");
	public By password = By.id("ap_password");
	public By signInSubmit = By.id("signInSubmit");
	public By signOut = By.id("nav-item-signout");

	/**
	 * Selection of Cart
	 * Add To Cart
	 */
	
	public By searchBox = By.id("twotabsearchtextbox");
	public By searchButton = By.xpath("//input[@value='Go']");
	public By iphoneByElement = By.xpath("//img[contains(@alt,'Apple iPhone 6, GSM Unlocked, 64GB - Space Gray (Renewed)')]");
	public By addToCartButton = By.id("add-to-cart-button");
	public By closeSide = By.cssSelector("#attach-close_sideSheet-link");
	public By addToCart = By.id("nav-cart");
	public By shoppingCartTitleH2 = By.xpath("//h2[contains(text(),'Shopping Cart')]");
	public By samsungByElement = By.xpath("//img[contains(@alt,'Net10 Samsung Galaxy J7 Crown 4G LTE Prepaid Smartphone')]");

	/**
	 * Checkout
	 */
	
	public By proceedToCheckout = By.xpath("//input[@name='proceedToCheckout']");
	public By autheticationRequired = By.xpath("//h1[contains(text(), 'Authentication required')]");
	
	
	public void housekeeping()
	{
		System.out.println("Before -- Open Webdriver Chrome Driver");
        String operatingSystem = System.getProperty("os.name").trim();
        
        if (operatingSystem.equalsIgnoreCase("linux"))
        {
        		System.setProperty("webdriver.chrome.driver", "driverLinux/geckodriver");
        }
        else if (operatingSystem.contains("mac") || operatingSystem.contains("Mac"))
        {
        		System.out.println("Chrome Driver in Mac");
        		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        }
        else if (operatingSystem.contains("Windows"))
        {
        	System.setProperty("webdriver.chrome.driver", "driverFirefoxWindows/geckodriver.exe");
        }
        
        System.out.println(operatingSystem.toString());
        
        try {
        		driver = new ChromeDriver();
        		wait = new WebDriverWait(driver,10);
        		actions = new Actions(driver);
        		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        		driver.get("http://www.amazon.com");
        }catch(Exception e)
        {
        		e.printStackTrace();
        }
        
	}
	
	/**
	 * Login Page 
	 */
		
	public void accountListHover()
	{
		actions.moveToElement(driver.findElement(accountLists)).click().build().perform();
		actions.moveToElement(driver.findElement(signIn)).click().build().perform();
	}
	
	public void signIn() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(email))).sendKeys(emailStr);
		driver.findElement(continueButton).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(password))).sendKeys(passwordStr);
		driver.findElement(signInSubmit).click();
	}
	
	public void signOutHover()
	{
		accountListHover();
		driver.findElement(signOut).click();
	}
	
	public void autheticate() 
	{
		String actualH1 = driver.findElement(autheticationRequired).getText().trim().toLowerCase();
		assertEquals(authenticationRequiredStr, actualH1);	
		System.out.println("----------Authentication Required Is shown--------");
	}
	
	/**
	 * Selection of Cart
	 * Add To Cart
	 */	
	
	public void searchIphone() throws InterruptedException
	{
		driver.findElement(searchBox).sendKeys(iphoneStr);
		driver.findElement(searchButton).click();
		
		List<WebElement> webElement = driver.findElements(iphoneByElement);
		webElement.get(0).click();	
		
		driver.findElement(addToCartButton).click();
		Thread.sleep(10000);
		
		try {
			driver.findElement(closeSide).click();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		Thread.sleep(10000);
		driver.findElement(addToCart).click();
		
		
		String actualH2 = driver.findElement(shoppingCartTitleH2).getText().trim().toLowerCase();
		System.out.println("Actual H2: "+ actualH2);
		assertEquals(shoppingCartStr, actualH2);
		System.out.println("Actual H2: " + actualH2 + " Successfully Added To Cart");
	}
	
	public void searchSamsung() throws InterruptedException
	{
		driver.findElement(searchBox).sendKeys(samsungStr);
		driver.findElement(searchButton).click();
		
		driver.findElement(samsungByElement).click();
		
		
		driver.findElement(addToCartButton).click();
		Thread.sleep(10000);
		try {
			driver.findElement(closeSide).click();
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		Thread.sleep(10000);
		driver.findElement(addToCart).click();
		
		String actualH2 = driver.findElement(shoppingCartTitleH2).getText().trim().toLowerCase();
		System.out.println("Actual H2: "+ actualH2);
		assertEquals(shoppingCartStr, actualH2);
		System.out.println("Actual H2: " + actualH2 + " Successfully Added To Cart");
		
	}
	
	/**
	 * Checkout
	 */
	
	public void proceedToCheckout() throws InterruptedException
	{
		driver.findElement(proceedToCheckout).click();
		signIn();
		autheticate();
	}
	
	
	
	

	
	
	
	
}
