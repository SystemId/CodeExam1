package com.barclays.submit.Barclays.util;

import java.util.List;

import com.barclays.submit.Barclays.entity.Road;

public interface RoadUtil {
	
	
	
	/** Return an object Formatted to display on viewer (In our case Syste.out.println)
	 * @param secondTimer
	 * @param roads
	 * @return
	 */
	public String formatObjectToDisplayonViewer(int secondTimer, List<Road> roads);

}
