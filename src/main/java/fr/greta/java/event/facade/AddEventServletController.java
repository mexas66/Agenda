package fr.greta.java.event.facade;

import fr.greta.java.event.domain.Event;
import fr.greta.java.event.domain.EventService;
import fr.greta.java.generic.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns="/addevent")
public class AddEventServletController extends HttpServlet {

    EventService service = new EventService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/addevent.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Event event = new Event();

        event.setTitle(req.getParameter("event_title"));
        event.setDescription(req.getParameter("event_description"));

        System.out.println(req.getParameter("event_begin_date"));

        try {
            event.setBeginCalendar(service.toCalendar(req.getParameter("event_begin_date")));
            event.setEndCalendar(service.toCalendar(req.getParameter("event_end_date")));
            service.create(event);

            resp.sendRedirect(req.getContextPath()+"/eventlist");

        } catch (ServiceException e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath()+"/eventlist.jsp" /*"?errorMessage=AFFECTED_ERROR"*/);
        }
    }
}
