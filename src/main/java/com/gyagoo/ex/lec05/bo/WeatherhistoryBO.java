package com.gyagoo.ex.lec05.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.gyagoo.ex.lec05.dao.WeatherhistoryDAO;
import com.gyagoo.ex.lec05.model.Weather;

@Service
public class WeatherhistoryBO {

//	5) 
	@Autowired
	private WeatherhistoryDAO weatherhistoryDAO;
	
//	2)
	public List<Weather> getWeatherhistory() {
		return weatherhistoryDAO.selectWeatherhistory();	// 5)
	}
	
//	2) insert
	public int addWeather(String date,
			String weather,
			double temperatures,
			double precipitation,
			String microDust,
			double windSpeed) {
		
		return weatherhistoryDAO.insertWeatherhistory(date, weather, temperatures, precipitation, microDust, windSpeed);
	}

	public int addWeatherByObject(Weather weather) {
		return weatherhistoryDAO.insertWeatherByObject(weather);
	}
}
