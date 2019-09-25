package Package1;


import org.junit.runner.RunWith;		
import org.junit.runners.Suite;		

@RunWith(Suite.class)				
@Suite.SuiteClasses({				
  Login.class,
  SelectionOfCart.class,  	
  AddToCart.class,
  CheckOut.class
})

public class TestSuiteAmazon {
		

}
