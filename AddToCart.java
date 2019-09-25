package Package1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddToCart extends PageObjectModel{	
	@Before
	public void before() 
	{
		housekeeping();
	}
	
	@Test
	public void TesLogin() throws InterruptedException
	{
		super.searchIphone();
		super.searchSamsung();

	}
	
	@After
	public void after() throws InterruptedException
	{
		super.driver.close();
		super.driver.quit();
	}
}
