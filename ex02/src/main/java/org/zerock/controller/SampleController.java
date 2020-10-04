package org.zerock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;

@RestController
@RequestMapping("/sample")
public class SampleController {

	@RequestMapping("/hello")
	public String sayHello() {
		
		return "Hello World";
	}
	
	@RequestMapping("/sendVO")
	public SampleVO sendVO() {
		
		SampleVO vo = new SampleVO();
		vo.setFirstName("길동");
		vo.setLastName("홍");
		vo.setMno(123);
		
		return vo;
	}
	
	@RequestMapping("/sendList")
	public List<SampleVO> sendList(){
		
		List<SampleVO> list = new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			SampleVO vo = new SampleVO();
			vo.setFirstName("길동");
			vo.setLastName("홍");
			vo.setMno(i);
			
			list.add(vo);
		}
		
		return list;
	}
	
	@RequestMapping("/sendMap")
	public Map<Integer, SampleVO> sendMap(){
		
		Map<Integer, SampleVO> map = new HashMap<>();
		
		for(int i=0; i<10; i++) {
			SampleVO vo = new SampleVO();
			vo.setFirstName("길동");
			vo.setLastName("홍");
			vo.setMno(i);
			
			map.put(i, vo);
		}
		
		return map;
	}
	
	/**
	 * 100번대 : 현재 데이터의 처리 중인 상태
	 *  - 100 : 데이터의 일부를 서버가 받은 상태
	 * 200번대 : 정상적인 응답
	 *  - 200 : 에러 없이 정상 처리
	 *  - 204 : 정상 처리되었으나 서버에서 보내줄 데이터가 없을때
	 * 300번대 : 다른 URL 처리
	 *  - 301 : 요청된 페이지가 새 URL로 변경되었음
	 *  - 304 : 이미 기존의 데이터와 변경된 것이 없음
	 * 400번대 : 서버에서 인식할 수 없음
	 *  - 400 : 전송된 Request에 문제가 있어서 서버가 인식할 수 없음
	 *  - 403 : 서버에서 허락되지 않음
	 *  - 404 : URL에 해당하는 자원을 찾을 수 없음
	 *  - 406 : 전송 방식이 허락되지 않음(REST에서 자주 발생)
	 * 500번대 : 서버 내부의 문제
	 *  - 500 : 서버에서 처리 시 문제가 발생
	 *  - 502 : 게이트웨이나 프록시 상태의 문제(과부화 등)
	 *  - 503 : 일시적인 과부하나 서비스 중단 상태
	 *  - 504 : 지정된 처리시간이 지나서 처리되지 못함 
	 */
	@RequestMapping("/sendErrorAuth")
	public ResponseEntity<Void> sendListAuth(){
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * 특이한 점은 일반적인 404메시지와는 달리 전송한 결과는 그대로 보여주면서 상태 코드를 전달한다는 점이다.
	 * 이런 방식은 주로 호출한 쪽으로 에러의 원인 메시지를 전송할 때 사용하는 방식이다.
	 */
	@RequestMapping("/sendErrorNot")
	public ResponseEntity<List<SampleVO>> sendlistNot(){
		
		List<SampleVO> list = new ArrayList<>();
		for(int i=0; i<10; i++) {
			SampleVO vo = new SampleVO();
			vo.setFirstName("길동");
			vo.setLastName("홍");
			vo.setMno(i);
			
			list.add(vo);
		}
		
		return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
	}
}
