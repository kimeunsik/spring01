package org.zerock.web;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //테스트 코드 실행시 스프링 로드
@ContextConfiguration( 
	locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}
)// locations 속성 경로에 xml 파일을 이용해서 스프링이 로딩
public class DataSourceTest {

	@Inject
	private DataSource ds;
	
	@Test
	public void testConnection() throws Exception {
		
		try(Connection con = ds.getConnection()){
			
			System.out.println(con);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
