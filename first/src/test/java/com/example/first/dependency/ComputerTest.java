package com.example.first.dependency;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j //롬복에 있는 로그를 찍어볼수 있는 어노테이션
public class ComputerTest {
	
	@Autowired//스프링이 만들어놓은 객체를 달라고 요청
	Coding coding;//우리가 만든객체가 아니라 스프링이 만들어 놓은 객체를 받아야 한다.
	
	@Test
	public void computerTest() {
		log.info(coding.getComputer().toString());
		//객체를 메모리에 올리지 않았기 때문에 호출이 안된다.
	}
	
}
