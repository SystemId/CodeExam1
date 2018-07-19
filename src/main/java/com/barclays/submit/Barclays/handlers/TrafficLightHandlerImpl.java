package com.barclays.submit.Barclays.handlers;

import java.util.List;

import org.springframework.stereotype.Service;

import com.barclays.submit.Barclays.entity.Road;

@Service("trafficLightHandler")
public class TrafficLightHandlerImpl implements TrafficLightHandler  { 
	

	public void changeTrafficLight(List<Road> roads, int timer) {
		if (timer ==3) {
			for (Road road : roads) {
				if(!road.isRedLight()) {					
					road.setRedLight(!road.isRedLight());
				}else {
					road.setChangeLightAfterDelay(true);
				}				
			}			
		}else {
			
			for (Road road : roads) {
				if(road.isChangeLightAfterDelay()) {
					road.setRedLight(!road.isRedLight());
					road.setChangeLightAfterDelay(false);
				}
			}
		}
	}
	

}
