package wenzhong.springmvc.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import wenzhong.springmvc.model.SystemContext;

public class SystemContextFilter implements Filter {
	
	static public void main(String[] args) {
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		int offset=0;
		try{
		offset=Integer.parseInt(req.getParameter("pager.offset"));
		}catch(NumberFormatException e){
		}
		try{
			SystemContext.setOffset(offset);
			SystemContext.setSize(15);
			chain.doFilter(req, resp);
		}finally{
			SystemContext.removeSize();
			SystemContext.removeOffset();
		}
		
		

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
