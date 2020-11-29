package fr.greta.java.event.facade;

import fr.greta.java.event.domain.EventService;
import fr.greta.java.generic.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/remove")
public class RemoveEventServletController extends HttpServlet {

    EventService service = new EventService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strId = req.getParameter("eventToRemove");
        int id = Integer.parseInt(strId);

        try {
            service.removeById(id);
            resp.sendRedirect(req.getContextPath()+"/eventlist");

        } catch (ServiceException e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath()+"/eventlist.jsp" /*"?errorMessage=AFFECTED_ERROR"*/);
        }


    }
}
