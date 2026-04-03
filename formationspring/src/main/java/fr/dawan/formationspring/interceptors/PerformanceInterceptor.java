package fr.dawan.formationspring.interceptors;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class PerformanceInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("start", System.currentTimeMillis());
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
		long start = (long) request.getAttribute("start");
		long tempsExecution = System.currentTimeMillis() - start;
		System.out.println(request.getRequestURI() + " temps d'exécution="+ tempsExecution + " ms");
	}

}
