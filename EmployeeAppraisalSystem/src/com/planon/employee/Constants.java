package com.planon.employee;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Constants {

	
	  static final Map<String, Integer> salCalc = createMap();

	    private static Map<String, Integer> createMap() {
	        Map<String, Integer> result = new HashMap<>();
	        result.put("Developer", 15);
	        result.put("Manager", 12);
	        result.put("Sales", 10);
	        result.put("Operation", 8);
	        return Collections.unmodifiableMap(result);
	    }
}
