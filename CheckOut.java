package Package1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CheckOut extends PageObjectModel{
	
	@Before
	public void before() 
	{
		housekeeping();
	}
	
	@Test
	public void CheckOutTest() throws InterruptedException 
	{
		searchIphone();
		searchSamsung();
		proceedToCheckout();
	}
	
	@After
	public void after() throws InterruptedException
	{
		super.driver.close();
		super.driver.quit();
	}

}
