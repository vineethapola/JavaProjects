package com.planon.food;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class FoodRatingMain {

	static Logger logger = Logger.getLogger(FoodRatingMain.class.getName());

	public static void main(String[] args) {

		Map<String, List<String>> restaurantFeedbackMap = new HashMap<>();
		RestaurantOperations resOps = new RestaurantOperationsImpl();
		List<Restaurant> resList = new ArrayList<>();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		try {
			logger.info("Enter number of restaurants to add");
			int number = Integer.parseInt(in.readLine());
			for (int i = 0; i < number; i++) {
				logger.info("Enter Restaurant Name : ");
				String name = in.readLine();
				// get feedback from user
				// get feedbacks array/list and then append the new input.
				logger.info("Enter Feedback");
				String feedback = in.readLine();

				if (restaurantFeedbackMap.containsKey(name)) {
					List<String> feedbacksList = restaurantFeedbackMap.get(name);
					feedbacksList.add(feedback);
					restaurantFeedbackMap.put(name, feedbacksList);
				} else {
					List<String> firstFeedback = new ArrayList<>();
					firstFeedback.add(feedback);
					restaurantFeedbackMap.put(name, firstFeedback);
				}
			}
			resList = resOps.ratingsCalc(restaurantFeedbackMap);
			resList = resOps.sortRestaurants(resList);
			resOps.display(resList); 
			//RestaurantOperations.display(resList);
		} catch (Exception e) {
			logger.info(e.toString());
		}
	}
}
