package com;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class AdditionTest {
	
	
	@Before
	public void avant() {
		System.out.println("Avant");
	}
	
	@After
	public void apres() {
		System.out.println("après");
	}
	
	@Test
	public void calculerTest() {
		long add = Addition.calculer(11,12);
		Assert.assertEquals(add,23);
	}
	
	
	
	
}
