package taxi.filter;

import java.io.IOException;
import java.util.Set;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "/*")
public class AuthenticationFilter extends HttpFilter {
    private Set<String> permitList;

    @Override
    public void init() {
        permitList = Set.of("/login", "/drivers/add");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if (permitList.contains(req.getServletPath())) {
            chain.doFilter(req, resp);
            return;
        }
        Long userId = (Long) req.getSession().getAttribute("userId");
        if (userId == null) {
            resp.sendRedirect("/login");
            return;
        }
        chain.doFilter(req, resp);
    }
}
