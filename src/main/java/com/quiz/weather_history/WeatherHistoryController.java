package com.quiz.weather_history;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_history.bo.WeatherHistoryBO;
import com.quiz.weather_history.domain.WeatherHistory;

@RequestMapping("/weather-history")
@Controller
public class WeatherHistoryController {

	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	// 날씨 추가 화면
	// http://localhost:8080/weather-history/add-weather-view
	@GetMapping("/add-weather-view")
	public String addWeatherView() {
		return "weather_history/addWeather";
	}
	
	// 날씨 추가 수행 -> 날씨 목록 화면으로 이동
	@PostMapping("/add-weather")
	public String addWeather(
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
			@RequestParam("weather") String weather,
			@RequestParam("microDust") String microDust,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("windSpeed") double windSpeed) {
		// DB insert
		// 날짜 -> String 타입으로 보내도 되고, Date 타입으로 보내도 된다.
		// String 타입으로 보낼 경우 DB에서 알아서 Date 타입으로 변경해서 받는다. 꺼낼 때는 데이터 입력 과정과 다르기에 상관없다.
		// Date 타입으로 보낼 경우 @DateTimeFormat(pattern = "yyyy-MM-dd")(패턴은 설정해놓은 모습대로)을 사용해서 변경해서 DB로 보낸다.
		weatherHistoryBO.addWeatherHistory(date, weather, microDust, temperatures, precipitation, windSpeed);
		
		// 결과 화면 -> redirect 302
		return "redirect:/weather-history/weather-list-view";
	}
	
	// 날씨 목록 화면
	// http://localhost:8080/weather-history/weather-list-view
	@GetMapping("/weather-list-view")
	public String weatherListView(Model model) {
		List<WeatherHistory> weatherHistoryList = weatherHistoryBO.getWeatherHistoryList();
		model.addAttribute("weatherHistoryList", weatherHistoryList);
		
		return "weather_history/weatherList";
	}
	
} // public class WeatherHistoryControlle