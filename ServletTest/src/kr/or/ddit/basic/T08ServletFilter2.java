package kr.or.ddit.basic;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class T08ServletFilter2 implements Filter {

	/*
	 * 서블릿 필터에 대하여....ㅋㅎ
	 * 1. 사용목적
	 *  - 클라이언트의 요청을 수행하기 전에 가로채서 필요한 작업을 수행할 수 있다. // 서블릿을 계속 꺼내서 수정하기 힘드니까..!
	 *  - 클라이언트에 응답정보를 제공하기 전에 응답정보에 필요한 작업을 수행할 수 있다.
	 *  
	 * 2. 사용 예
	 * 	- 인증필터
	 *  - 데이터 압축필터
	 *  - 인코딩 필터
	 *  - 로깅 및 감사처리 필터
	 *  - 이미지 변환 필터 등.
	 *  
	 */
	
	@Override
	public void destroy() {
		// 필터 객체가 컨테이너에 의해 서비스로부터 제거되기 전에 호출됨.
		System.out.println("T08ServletFilter2 => distroy() 호출됨.");
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fc)
			throws IOException, ServletException {
		System.out.println("T08ServletFilter2 = > deFilter() 시작.");
		
		//서블릿 수행시간 계산하기
		long startTime = System.currentTimeMillis();
		
		// 필터 체인 실행하기
		fc.doFilter(req, resp);
		
		System.out.println("수행시간(ms) : " + (System.currentTimeMillis() - startTime));	
		System.out.println("T08ServletFilter2 = > deFilter() 끝.");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("T08ServletFilter2 => init() 호출됨.");
		
		// 초기화 파라미터 정보 가져오기 
		String initParam = filterConfig.getInitParameter("init-param");
		System.out.println("init-param : " + initParam);
		
		
	}

}