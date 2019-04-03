package tbschedule;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class InitServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {

        System.out.printf("success");
        super.init();
        System.out.printf("success");

    }
}
