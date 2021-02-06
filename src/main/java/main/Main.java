package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.AllRequestsServlet;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class Main {
    public static void main(String[] args) throws Exception {
        AllRequestsServlet allRequestsServlet = new AllRequestsServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
// любой запрос по /* на сервлет allRequestServlet
        context.addServlet(new ServletHolder(allRequestsServlet), "/*");
// jetty сервер по порту
        Server server = new Server(8080);
//передаем handler
        server.setHandler(context);

        server.start();
//логгер по заданию курса
        java.util.logging.Logger.getGlobal().info("Server started");
        server.join();
    }
}
