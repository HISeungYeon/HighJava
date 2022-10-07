package kr.or.ddit.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class T10HttpSessionListenerTest extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// HttpSession 객체 생성 및 소멸 관련 ..
		HttpSession session = req.getSession(); //디폴트 값 true
		
		// HttpSessionAttributeListener 관련 이벤트 
		session.setAttribute("Attr1", "속성1");
		session.setAttribute("Attr1", "속성11");
		session.setAttribute("Attr2", "속성2");
		session.removeAttribute("ATTR1");
		
		session.invalidate(); // 세션 종료.
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
