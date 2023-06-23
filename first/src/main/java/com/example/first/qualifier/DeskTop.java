package com.example.first.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("desktop") @Primary //주입을 요청 시 Qualifier를 적지 않는다면 default 값으로 이 객체를 반환한다.
public class DeskTop implements Computer {
	@Override
	public String getScreenWidth() {
		// TODO Auto-generated method stub
		return "1920";
	}
}
