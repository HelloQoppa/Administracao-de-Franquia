package filtro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		Object user = httpRequest.getSession().getAttribute("user");

		System.out.println(httpRequest.getRequestURI());
		boolean regra1 = httpRequest.getRequestURI().endsWith("login");
		boolean regra2 = httpRequest.getRequestURI().endsWith(".css");
		boolean regra3 = httpRequest.getRequestURI().endsWith(".js");
		boolean regra4 = httpRequest.getRequestURI().endsWith(".jpg");
		boolean regra5 = httpRequest.getRequestURI().endsWith(".eot");
		boolean regra6 = httpRequest.getRequestURI().endsWith(".woff");
		boolean regra7 = httpRequest.getRequestURI().endsWith(".ttf");

		if (user == null && !(regra1 || regra2 || regra3 || regra4 || regra5 || regra6 || regra7)) {
			httpResponse.sendRedirect("/Teste_Qualidade/login");
		}

		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
