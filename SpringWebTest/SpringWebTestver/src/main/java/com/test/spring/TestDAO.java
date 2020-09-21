package com.test.spring;

import java.util.Random;

public class TestDAO {
	
	public int getCount() {
		Random rnd = new Random();
		
		return rnd.nextInt();
	}
	
}
