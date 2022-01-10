package com.gyagoo.ex.lec05;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gyagoo.ex.lec05.bo.WeatherhistoryBO;
import com.gyagoo.ex.lec05.model.Weather;

@Controller
@RequestMapping("/lec05")
public class WeatherhistoryController {

//	6)
	@Autowired
	private WeatherhistoryBO weatherhistoryBO;
	
//	1) 
//	@ResponseBody
	@GetMapping("/weather_history")
	public String weatherHistory(Model model) {		
		
/*
		7)
		model 필요
		model에 add 할 데이터 필요 (list)
		화면에 표시할 jsp
		
		query의 내용이 하나일 경우 그대로 return, 여러개일 경우 list로 return => 객체 자체가 list임을 의미 ! ! !
*/
		
		List<Weather> weatherlist = weatherhistoryBO.getWeatherhistory();	// 6) 결과가 json 형태로 나열되는 것 확인
		model.addAttribute("weatherhistory", weatherlist);
		
		return "lec05/weatherHistory";	
	}
	
//	1) ResponseBody 확인
	
	@PostMapping("/add_weather")
	public String addWeather(
			@RequestParam("date") String date,						// Date가 아닌 String -> workbench에 저장됨 -> 포맷만 맞추면 알아서 저장
			@RequestParam("weather") String weather,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("microDust") String microDust,
			@RequestParam("windSpeed") double windSpeed) {
		
		int count = weatherhistoryBO.addWeather(date, weather, temperatures, precipitation, microDust, windSpeed); // 추가된 내용이 포함되어 메인 화면이 뜬다면 좋을 듯 -> redirect
		
		return "redirect:lec05/weatherHistory";
	}
	
	public String addWeatherByObject(@ModelAttribute Weather weather, Model model) {
		return "redirect:lec05/weatherHistory";
	}
	
	/*
	 Date 클래스 사용 -> error 발생
	 문자열로 판단을 해서 Date 객체로 변환을 할 수 없다고 판단 -> 연, 월, 일이 뭔지 표현해야 함
	 	 
	 @DateTimeFormat(pattern="yyyy-MM-dd") 
	 
	 */
	
	
	
}
