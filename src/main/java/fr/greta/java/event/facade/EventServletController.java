package fr.greta.java.event.facade;

import fr.greta.java.event.domain.EventService;
import fr.greta.java.generic.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/eventlist")
public class EventServletController extends HttpServlet {
    EventDTOWrapper dtoWrapper = new EventDTOWrapper();

    EventService eventService = new EventService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<EventDTO> dtos = dtoWrapper.todtos(eventService.findAll());

            req.setAttribute("events", dtos);

            req.getRequestDispatcher("eventlist.jsp").forward(req,resp);
        } catch (ServiceException e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() +"/eventlist.jsp" /*"?errorMessage=AFFECTED_ERROR"*/);
        }
    }
}
