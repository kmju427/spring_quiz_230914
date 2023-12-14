package com.quiz.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/quiz02")
@RestController
public class Lesson01Quiz02RestController {
	// @ResponseBody + return String -> HttpMessageConverter -> String -> HTML 변환
	// @ResponseBody + return 객체(Map, 클래스, List...) -> HttpMessageConverter -> jackson 라이브러리 -> JSON 응답
	
	// url : http://localhost:8080/lesson01/quiz02/1
	@RequestMapping("/1")
	public List<Map<String, Object>> quiz02_1() {
		List<Map<String, Object>> movies = new ArrayList<>();
		Map<String, Object> movie = new HashMap<>(); // stack(heap의 주소와 연결되어 있는 곳) - heap(실제로 데이터가 쌓이는 공간)
		movie.put("rate", 15);
		movie.put("director", "봉준호");
		movie.put("time", 131);
		movie.put("title", "기생충");
		movies.add(movie);
		
		movie = new HashMap<>(); // stack 재활용 가능, 실제 데이터는 heap에 쌓이기 때문
		movie.put("rate", 0);
		movie.put("director", "로베르토 베니니");
		movie.put("time", 116);
		movie.put("title", "인생은 아름다워");
		movies.add(movie);
		
		movie = new HashMap<>();
		movie.put("rate", 12);
		movie.put("director", "크리스토퍼 놀란");
		movie.put("time", 147);
		movie.put("title", "인셉션");
		movies.add(movie);
		
		movie = new HashMap<>();
		movie.put("rate", 19);
		movie.put("director", "윤종빈");
		movie.put("time", 133);
		movie.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
		movies.add(movie);
		
		movie = new HashMap<>();
		movie.put("rate", 15);
		movie.put("director", "프란시스 로렌스");
		movie.put("time", 137);
		movie.put("title", "헝거게임");
		movies.add(movie);
		
		return movies; // list<map> JSON 응답
	}
	
	// url : http://localhost:8080/lesson01/quiz02/2
	@RequestMapping("/2")
	public List<Board> quiz02_2() {
		List<Board> boardList = new ArrayList<>();
		Board board = new Board();
		board.setTitle("안녕하세요. 가입인사 드립니다.");
		board.setUser("marobiana");
		board.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁드립니다. 활동 열심히 하겠습니다.");
		boardList.add(board);
		
		board = new Board();
		board.setTitle("헐 대박");
		board.setUser("bada");
		board.setContent("오늘 목요일이었어... 금요일인줄");
		boardList.add(board);
		
		board = new Board();
		board.setTitle("오늘 데이트한 이야기 해드릴게요.");
		board.setUser("dulumary");
		board.setContent("...");
		boardList.add(board);
		
		return boardList; // list<map> JSON 응답
	}
	
	// url : http://localhost:8080/lesson01/quiz02/3
	@RequestMapping("/3")
	public ResponseEntity<Board> quiz02_3() {
		Board board = new Board();
		board.setTitle("안녕하세요. 가입인사 드립니다.");
		board.setUser("marobiana");
		board.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁드립니다. 활동 열심히 하겠습니다.");
		
		return new ResponseEntity<>(board, HttpStatus.INTERNAL_SERVER_ERROR);
	}

} // public class Lesson01Quiz02RestController