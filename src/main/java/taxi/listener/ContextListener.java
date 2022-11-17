package taxi.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener("application context listener")
public class ContextListener implements ServletContextListener {
 
    /**
     * Initialize log4j when the application is being started
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
        // initialize log4j here
    }
     
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // do nothing
    }  
}
