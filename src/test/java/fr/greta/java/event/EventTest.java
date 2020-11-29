package fr.greta.java.event;

import fr.greta.java.event.domain.Event;
import fr.greta.java.event.domain.EventService;
import fr.greta.java.generic.exception.ServiceException;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EventTest {
    EventService service = new EventService();

    @Test
    public void eventIsValid() throws ServiceException {
        Event event = new Event();
        event.setBeginCalendar(service.toCalendar("29-11-2020T11:30"));
        event.setEndCalendar(service.toCalendar("29-11-2020T12:30"));
        assertTrue(event.isValid());
    }

    @Test
    public void eventIsNotValidWithEndBeforeBeginning() throws ServiceException {
        Event event = new Event();
        event.setBeginCalendar(service.toCalendar("29-11-2020T12:30"));
        event.setEndCalendar(service.toCalendar("29-11-2020T11:30"));
        assertFalse(event.isValid());
    }
}
