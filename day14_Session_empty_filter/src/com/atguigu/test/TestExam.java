package com.atguigu.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestExam {

	@Test
	public void test() {
		String myString;
		int x=100;
//		if(x <100) 
			myString="x is less than 100";
//		if(x >100)
			myString="x is greater than 100";
		System.out.println(myString.length());
	}

}
