package com.korea.board.mybatis;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.RequiredArgsConstructor;

@Configuration //Spring한테 해당 클래스가 설정파일임을 알려주는 어노테이션
@RequiredArgsConstructor //생성자주입 어노테이션
public class MybatisConfig {
	//생성자 주입을 하려면 final을 붙여야 한다.
	private final ApplicationContext applicationContext;
	
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	@Bean //HikariCP(Hikari Connetion Pool): 가벼운 용량과 빠른 속도를 가지는 JDBC의 커넥션 풀 프레임워크
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}
	
	//userName, password에 대한 설정을 HikariConfig 객체에 넣어줘야 한다.
	//application.yml 파일에 작성한다.
	
	@Bean
	public DataSource dataSource() {
		return new HikariDataSource(hikariConfig());
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws IOException {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		//classpath가 resource까지의 경로를 알고 있다.
		//vo에서 DB에서 넘어올 data를 담을 변수명에 "_"를 쓰면 안된다.
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath*:/mapper/*.xml"));
		sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:/config/config.xml"));
		
		SqlSessionFactory sqlSessionFactory;
		try {
			sqlSessionFactory = sqlSessionFactoryBean.getObject();
			sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
			return sqlSessionFactory;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
