package com.barclays.submit.Barclays.util;

import java.util.List;

import org.springframework.stereotype.Service;

import com.barclays.submit.Barclays.entity.Road;

@Service("util")
public class RoadUtilImpl implements RoadUtil{
	
	
	//Although its a small method I broke it into its own method so that this would have the resposibility to 
	//format the final object
	public String formatObjectToDisplayonViewer(int secondTimer, List<Road> roads) {
		String carVolumeOnRoad = secondTimer + ":";
		for(Road road :roads) {
			carVolumeOnRoad += road.displayMap();		
		}
		return carVolumeOnRoad.substring(0, carVolumeOnRoad.length() -1);
	};
	
	

}
