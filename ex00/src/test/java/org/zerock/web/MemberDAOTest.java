package org.zerock.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.MemberVO;
import org.zerock.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDAOTest {

	@Inject
	private MemberDAO dao;
	
//	@Test
	public void testTime() throws Exception {
		
		System.out.println(dao.getTime());
	}
	
//	@Test
	public void testInsertMember() throws Exception {
		
		MemberVO vo = new MemberVO();
		vo.setUserid("user00");
		vo.setUserpw("user00");
		vo.setUsername("USER00");
		vo.setEmail("user00@aaa.com");
		
		dao.insertMember(vo);
	}
	
//	@Test
	public void testReadMember() throws Exception {
		
		MemberVO vo = (MemberVO)dao.readMember("user00");
		
		System.out.println(vo.toString());
	}
	
	@Test
	public void testReadWithPW() throws Exception {
		
		MemberVO vo = (MemberVO)dao.readWithPW("user00", "user00");
		
		System.out.println(vo.toString());
	}
}
