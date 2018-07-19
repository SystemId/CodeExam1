package com.barclays.submit.Barclays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.barclays.submit.Barclays.service.TrafficService;

@SpringBootApplication
public class BarclaysApplication implements CommandLineRunner {
	
	@Autowired
	private TrafficService carService;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 SpringApplication app = new SpringApplication(BarclaysApplication.class);
	     app.setBannerMode(Banner.Mode.OFF);
	       app.run(args);
		
		
	} 

	
	/* (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... args) throws Exception {
		carService.runTrafficSimulation();
		
	}
	
	
}
