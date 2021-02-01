package com.planon.food;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Constants {

	static final String[] goodWordsArray = { "Good", "Best", "Awesome", "Nice", "Great" };
	static List<String> goodWordsList = Collections.unmodifiableList(Arrays.asList(goodWordsArray));
	// below code is added to demonstrate unmodifiableList concept in Collections

	/*
	 * public Constants() { System.out.println(goodWordsList);
	 * goodWordsList.add("very good"); System.out.println(goodWordsList); }
	 */
	  
	 
}
