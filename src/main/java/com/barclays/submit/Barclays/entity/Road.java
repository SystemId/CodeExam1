package com.barclays.submit.Barclays.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Road {
		
	//used to tell if road has redLight or Green
	private boolean redLight;
	
	//used to tell changedlightAfterNextSecondPasses
	private boolean changeLightAfterDelay;
		
	//used to set row in initial flow state when there is no cards going through
	private boolean roadWithInitialFlow;


	//Making this a generic set in case there are roads in the future that contain more than one two directions
	private Set<String> directions;
	
	Map<String, Integer> carsPerDirection = new HashMap<String, Integer>();
	
	public Road (Set<String> directions) {
		this.directions = directions;
		for(String dir: directions) {
			carsPerDirection.put(dir, 0);
		}
	}
	

	
	public boolean isRedLight() {
		return redLight;
	}



	public void setRedLight(boolean redLight) {
		this.redLight = redLight;
	}



	public Set<String> getDirections() {
		return directions;
	}

	public void setDirections(Set<String> directions) {
		this.directions = directions;
	}

	public Map<String, Integer> getCarsPerDirection() {
		return carsPerDirection;
	}

	public void setCarsPerDirection(Map<String, Integer> carsPerDirection) {
		this.carsPerDirection = carsPerDirection;
	}
	public boolean isChangeLightAfterDelay() {
		return changeLightAfterDelay;
	}

	public void setChangeLightAfterDelay(boolean changeLightAfterDelay) {
		this.changeLightAfterDelay = changeLightAfterDelay;
	}
	
	
	//This method is to return a display for each potential road that could be displayed 
	//in the same format including spacing and ; However if its not the resposibility 
	// of this method to remove the last unessary ; from the final road
	//this was done to allow potentially adding more roads in the future in mind
	public String displayMap() {
		String carsWaitingOnRoad = "";
		for(String key: carsPerDirection.keySet()) {
			carsWaitingOnRoad +=  key + " = " +  carsPerDirection.get(key) + ";";
		}
		return carsWaitingOnRoad;
		
	}



	public boolean isRoadWithInitialFlow() {
		return roadWithInitialFlow;
	}



	public void setRoadWithInitialFlow(boolean roadWithInitialFlow) {
		this.roadWithInitialFlow = roadWithInitialFlow;
	}
	
	

}
