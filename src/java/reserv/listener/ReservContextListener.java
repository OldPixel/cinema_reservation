/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reserv.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import reserv.config.DBManager;

/**
 * Web application lifecycle listener.
 *
 * @author muody
 */
@WebListener()
public class ReservContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) { 
        DBManager.getManager().createEntityManagerFactory();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DBManager.getManager().closeEntityManagerFactory();
    }
}
