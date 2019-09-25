package Package1;

import org.junit.Before;
import org.junit.Test;

public class Logout extends PageObjectModel{

	@Before
	public void before() 
	{
		housekeeping();
	}
	
	@Test
	public void testSignOut()
	{
		signOutHover();
	}
}
