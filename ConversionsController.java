package com.console.converter;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sun.tools.sjavac.Log;

/**
 * @author Vuyisa
 *
 */
@RestController
public class ConversionsController {

	
	@GetMapping("conversions/ktoc/{value}")
	public String convertKelvinToCelcius(@PathVariable("value")Float value ) {
		
		float celcius =   0.0f;
		try {
			celcius = value - 273.17f;
			
		}catch(Exception e) {
			System.out.println("Something went wrong, please look at the StackTrace below for more details");
			e.printStackTrace();
		}
		return "This is the value of Kelvin in Celcius : " +String.valueOf(celcius);
	}
	
	@GetMapping("conversions/ctok/{value}")
	public String convertCelciusToKelvin(@PathVariable("value")Float value ) {
		
		float kelvin =   0.0f;
		try {
			kelvin = value + 273.17f;
			
		}catch(Exception e) {
			System.out.println("Something went wrong, please look at the StackTrace below for more details");
			e.printStackTrace();
		}
		return "This is the value of Celcius in Kelvin : " +String.valueOf(kelvin);
	}
	
	@GetMapping("conversions/mtok/{value}")
	public String convertKmToMiles(@PathVariable("value")Float value ) {
		
		float miles =   0.0f;
		try {
			miles = value * 0.62137f;
			
		}catch(Exception e) {
			System.out.println("Something went wrong, please look at the StackTrace below for more details");
			e.printStackTrace();
		}
		return "This is the value of KMs in Miles : " +String.valueOf(miles);
	}
	
	@GetMapping("conversions/ktom/{value}")
	public String convertMilesToKms(@PathVariable("value")Float value ) {
		
		float kilometers =   0.0f;
		try {
			kilometers = kilometers / 0.62137f;
			
		}catch(Exception e) {
			System.out.println("Something went wrong, please look at the StackTrace below for more details");
			e.printStackTrace();
		}
		return "This is the value of Miles in KMs : " +String.valueOf(kilometers);
	}
}
