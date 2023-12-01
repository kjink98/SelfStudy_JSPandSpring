package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestWebController {
	// 테스트
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	// 요청 파라미터 처리
	@GetMapping("/hello2")
	@ResponseBody
	public String hello2(@RequestParam(value="msg", required=false) String msg) {
		return msg;
	}
	
	// 데이터를 포함한 뷰 포워딩
	@GetMapping("/hello3/{msg}")
	public String hello3(@PathVariable String msg, Model m) {
		m.addAttribute("msg", msg);
		return "hello";
	}
}
