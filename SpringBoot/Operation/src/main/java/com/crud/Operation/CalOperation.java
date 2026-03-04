package com.crud.Operation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalOperation {

	int a = 10;
	int b = 10;
	
	@GetMapping("/add")
	public int add() {
		return a+b;
	}
	
	@GetMapping("sub")
	public int sub() {
		return a-b;
	}
	
	@GetMapping("/mul")
	public int mul() {
		return a*b;
	}
}