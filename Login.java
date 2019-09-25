package Package1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Login extends PageObjectModel{
		@Before
		public void before() 
		{
			housekeeping();
		}
		
		@Test
		public void TesLogin() throws InterruptedException
		{
			accountListHover();
			signIn();
			autheticate();			

		}
		
		@After
		public void after()
		{
			super.driver.close();
			super.driver.quit();
		}
}
