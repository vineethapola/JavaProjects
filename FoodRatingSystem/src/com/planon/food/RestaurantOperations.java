package com.planon.food;

import java.util.List;
import java.util.Map;

public interface RestaurantOperations {

	public List<Restaurant> ratingsCalc(Map<String, List<String>> restaurantFeedbacksMap);
	
	public List<Restaurant> sortRestaurants(List<Restaurant> resList);
	
	default void display(List<Restaurant> resList) {
		  for(Restaurant res: resList) {
		  System.out.println(res.getResName()+" "+res.getRank()+" "+res.getOccurence()); }
		 
	}
}
