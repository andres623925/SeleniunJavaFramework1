package listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class TestNGListenerDemo2 {

	@Test
	public void test1() {
		System.out.println("I am inseide Test 4");
	}
	
	@Test
	public void test2() {
		System.out.println("I am inseide Test 5");
	}

	@Test
	public void test3() {
		System.out.println("I am inseide Test 6");
		throw new SkipException("this test is skipped");
	}

}
