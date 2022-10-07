package kr.or.ddit.basic;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener, HttpSessionAttributeListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("[MyServletRequestListener] sessionCreated => " + se );

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("[MyServletRequestListener] sessionDestroyed => " + se );

	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("[MyServletRequestListener] attributeAdded => " 
				+ event.getName() + " 추가됨.");
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("[MyServletRequestListener] attributeRemoved => " 
				+ event.getName() + " 삭제됨.");
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("[MyServletRequestListener] attributeReplaced => " 
				+ event.getName() + " 변경됨.");
		
	}

}
