package taxi.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebFilter(urlPatterns = "/*")
public class LogFilter extends HttpFilter {
    private static final Logger logger = LogManager.getLogger(LogFilter.class);

    @Override
    protected void doFilter(HttpServletRequest req,
                            HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        logger.debug("HTTP Request to {}, method: {}",
                req.getServletPath(),
                req.getMethod());
        chain.doFilter(req, res);
    }
}
