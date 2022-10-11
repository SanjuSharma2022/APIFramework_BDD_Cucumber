package com.testNGpackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestAnnotationsExec {
	
	@BeforeSuite
	
	public void beforesuite() {
		System.out.println("beforesuite");
	}

	@AfterSuite
	
	public void aftersuite() {
		System.out.println("aftersuite");
	}
	
	@BeforeTest
	
	public void beforetest() {
		System.out.println("beforetest");
	}
	
	@AfterTest
	
	public void aftertest() {
		System.out.println("aftertest");
	}
	
	@BeforeClass
	
	public void beforeclass() {
		System.out.println("beforeclass");
		
	}
	@AfterClass
	
	public void afterclass() {
		System.out.println("afterclass");
		
	}
	
	@BeforeMethod
	
	public void beforemethod() {
		System.out.println("beforemethod");
	}
	
	@AfterMethod
	
	public void aftermethod() {
		System.out.println("aftermethod");
	}
	
	@Test
	
	public void test() {
		System.out.println("Test executed");
	}
	
	@Test
	
	public void test1() {
		System.out.println("Test1 executed");
	}
}
