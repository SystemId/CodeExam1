package com.barclays.submit.Barclays.handlers;

import java.util.List;

import com.barclays.submit.Barclays.entity.Road;

public interface TrafficLightHandler { 
	
	/** Change and maintain the traffic light signals
	 * @param roads
	 * @param timer
	 */
	public void changeTrafficLight(List<Road> roads, int timer);

}
