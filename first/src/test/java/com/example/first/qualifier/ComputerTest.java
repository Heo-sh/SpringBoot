package com.example.first.qualifier;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class ComputerTest {

	@Autowired
	@Qualifier("laptop")
	Computer laptop;//인터페이스 -> 자동으로 구현을 한 클래스의 객체

	@Autowired
	@Qualifier("desktop")
	Computer desktop;
	
	@Autowired
	Computer computer;
	
	@Test
	public void computerTest() {
		log.info(laptop.getScreenWidth());
		log.info(desktop.getScreenWidth());
		log.info(computer.getScreenWidth());
	}
	
}
