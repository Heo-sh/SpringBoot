package com.korea.db.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TimeMapper {

	//mapper.xml에 있는 query문을 호출하기 위한 interface
	//DAO 대신 @Mapper 어노테이션을 사용(mybatis 3.0 이상만 가능)
	//@Mapper 어노테이션을 사용하면 Bean으로 등록되며 Controller에서 의존성 주입응로 사용할 수 있다.
	//추상메서드의 이름은 Mapper파일으 id와 맞춰야 함
	public String getTime();
}
