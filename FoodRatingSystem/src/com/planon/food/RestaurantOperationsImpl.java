package com.planon.food;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class RestaurantOperationsImpl implements RestaurantOperations {

	@Override
	public List<Restaurant> ratingsCalc(Map<String, List<String>> restaurantFeedbackMap) {
		List<Restaurant> resList = new ArrayList<>();
		restaurantFeedbackMap.forEach((restaurant, feedbacks) -> {
			int calOccurence = 0;
			for (String feedback : feedbacks) {
				String[] feedbackArray = feedback.split(" ");
				calOccurence = occurenceCaluation(feedbackArray, calOccurence);
			}
			resList.add(new Restaurant(restaurant, feedbacks, calOccurence, 0));
		});
		return resList;
	}

	@Override
	public List<Restaurant> sortRestaurants(List<Restaurant> resList) {
		Collections.sort(resList);
		for (int i = 0; i < resList.size(); i++) {
			resList.get(i).setRank(i + 1);
		}
		return resList;
	}

	@Override
	public void display(List<Restaurant> resList) {
		for (Restaurant res : resList) {
			System.out.println(res.getResName() + " " + res.getRank() + " " + res.getOccurence());
		}
	}

	int occurenceCaluation(String[] feedbackArray, int goodWordOccurence) {
		 List<String> goodWordsList = Constants.goodWordsList;
		for (int i = 0; i < feedbackArray.length; i++) {
			for (String goodWord : goodWordsList) {
				if (goodWord.equalsIgnoreCase(feedbackArray[i])) {
					goodWordOccurence = goodWordOccurence + 1;
					break;
				}
			}
		}
		return goodWordOccurence;
	}

}