package com.barclays.submit.Barclays.handlers;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.barclays.submit.Barclays.entity.Road;

@Service("carCountHandler")
public class CarCountHandlerImpl implements CarCountHandler {
	
	
	public void updateMapsOfCarsOnTheRoad(List<Road> roads, int trafficSimulationTimer) {

		for (Road road : roads) {
			Map<String, Integer> carsPerDirection = road.getCarsPerDirection();
			if (road.isRedLight()) {
				for (String direction : carsPerDirection.keySet()) {
					int cars = carsPerDirection.get(direction);
					cars++;
					carsPerDirection.put(direction, cars);
				}
			}else {
				//Green Light
				if((!road.isRedLight()) && trafficSimulationTimer ==1) {
					if(road.isRoadWithInitialFlow()) {
						road.setRoadWithInitialFlow(false);
					}else {
						for (String direction : carsPerDirection.keySet()) {
							
							int cars = carsPerDirection.get(direction);
							cars++;
							carsPerDirection.put(direction, cars);
						
					}
			
					
				}
				}
				
			}
			
		}

	}

}
