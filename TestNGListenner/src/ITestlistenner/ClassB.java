package ITestlistenner;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ClassB {
	@Test
	public void sys7() {
		System.out.println("Test case starts");
		Assert.assertTrue(true);
	}
	
	@Test
	public void sys5() {
		System.out.println("Test case passes");
		Assert.assertTrue(true);
	}
	@Test
	public void sys6() {
		System.out.println("Test case fails");
		Assert.assertTrue(true);
	}

}
