package com.gyagoo.ex.lec05.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.gyagoo.ex.lec05.model.Weather;

@Repository
public interface WeatherhistoryDAO {

//	3) 전달이 필요한 파라미터는 mapper를 만들면서 생각
	public List<Weather> selectWeatherhistory();
	
//	3) insert
	public int insertWeatherhistory(
			@Param("date") String date,
			@Param("weather") String weather,
			@Param("temperatures") double temperatures,
			@Param("precipitation") double precipitation,
			@Param("microDust") String microDust,
			@Param("windSpeed") double windSpeed);
	
	public int insertWeatherByObject(Weather weather);
}


