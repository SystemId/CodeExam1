package com.barclays.submit.Barclays.handlers;

import java.util.List;

import com.barclays.submit.Barclays.entity.Road;

public interface CarCountHandler {
	
	/** Method used to determine how many cards are on the road
	 * @param roads
	 * @param trafficSimulationTimer
	 */
	public void updateMapsOfCarsOnTheRoad(List<Road> roads, int trafficSimulationTimer);

}


