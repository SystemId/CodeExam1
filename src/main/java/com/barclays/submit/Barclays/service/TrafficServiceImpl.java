package com.barclays.submit.Barclays.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.submit.Barclays.entity.Road;
import com.barclays.submit.Barclays.handlers.CarCountHandler;
import com.barclays.submit.Barclays.handlers.TrafficLightHandler;
import com.barclays.submit.Barclays.util.RoadUtil;

@Service("carService")
public class TrafficServiceImpl implements TrafficService {
	
	@Autowired
	private RoadUtil util;
	
	@Autowired
	private CarCountHandler carCountHandler;
	
	@Autowired
	private TrafficLightHandler trafficLightHandler;
	
	//Making the number 21 so we keep track of initial state as well as the 20th second
	public static final int TRAFFIC_SIMULATION_MAX_TIMER = 21;
	
	public void runTrafficSimulation() {
		int trafficSimulationTimer = 0;
		
		//I could use a Builder pattern but Object is super small right now
		Set<String> directionsSnellRoad = new HashSet<String>();
		directionsSnellRoad.add("N");
		directionsSnellRoad.add("S");		
		Set<String> directionsWeaverRoad = new HashSet<String>();
		directionsWeaverRoad.add("E"); 
		directionsWeaverRoad.add("W");
		Road snellRoad = new Road(directionsSnellRoad);
		snellRoad.setRoadWithInitialFlow(true);
		Road weaverRoad = new Road(directionsWeaverRoad);
		weaverRoad.setRedLight(true);
		List<Road> roads = new ArrayList<Road>();
		roads.add(snellRoad);
		roads.add(weaverRoad);
		int incrementalTimer =1;
		
		while(trafficSimulationTimer < TRAFFIC_SIMULATION_MAX_TIMER) {
			System.out.println(util.formatObjectToDisplayonViewer(trafficSimulationTimer, roads));			
			//I am not making the program wait as requested just looping through 		
			carCountHandler.updateMapsOfCarsOnTheRoad(roads, incrementalTimer);
			trafficLightHandler.changeTrafficLight(roads, incrementalTimer);			
			trafficSimulationTimer++;
			if(incrementalTimer == 4) {
				incrementalTimer=1;
			}else {
				incrementalTimer++;
			}	
		}
		
	}	
	

 
	



}
