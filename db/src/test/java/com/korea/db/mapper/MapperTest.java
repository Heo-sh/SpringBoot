package com.korea.db.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.korea.db.mapper.TimeMapper;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class MapperTest {
	
	@Autowired
	private TimeMapper timeMapper;
	
	@Test
	public void getTimeTest() {
		log.info("timeLog: " + timeMapper.getTime());
	}
}
