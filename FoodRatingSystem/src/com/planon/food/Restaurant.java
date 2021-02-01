package com.planon.food;

import java.util.List;

public class Restaurant implements Comparable<Restaurant>{

	private String resName;
	private List<String> reviewComments;
	private Integer occurence;
	private Integer rank;

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public List<String> getReviewComments() {
		return reviewComments;
	}

	public void setReviewComments(List<String> reviewComments) {
		this.reviewComments = reviewComments;
	}

	public Integer getOccurence() {
		return occurence;
	}

	public void setOccurence(Integer occurence) {
		this.occurence = occurence;
	}
	
	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Restaurant(String resName, List<String> reviewComments, Integer occurence, Integer rank) {
		this.resName = resName;
		this.reviewComments = reviewComments;
		this.occurence = occurence;
		this.rank = rank;
	}

	@Override
	public int compareTo(Restaurant o) {
		return Double.compare(o.occurence,occurence);
	}

}
