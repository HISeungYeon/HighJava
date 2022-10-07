package kr.or.ddit.basic;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener, ServletContextAttributeListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("[MyServletRequestListener] contextDestroyed => " + sce );
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("[MyServletRequestListener] contextInitialized => " + sce );
		
	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("[MyServletRequestListener] attributeAdded => " 
					+ event.getName() + " 추가됨." );
		
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("[MyServletRequestListener] attributeRemoved => " 
					+ event.getName() + "  삭제됨." );
		
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("[MyServletRequestListener] attributeReplaced => " 
				+ event.getName() + "  변경됨." );
		
	}
	
}
