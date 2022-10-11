package ITestlistenner;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener1Class.class)
public class CLassA {
	
	
	
	@Test
	public void sys() {
		System.out.println("Test case starts");
		Assert.assertTrue(true);
	}
	
	@Test
	public void sys1() {
		System.out.println("Test case passes");
		Assert.assertTrue(false);
	}
	@Test(dependsOnMethods = "sys1")
	public void sys2() {
		System.out.println("Test case fails");
		Assert.assertTrue(false);
	}


}
