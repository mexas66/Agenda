package fr.greta.java.event;

import fr.greta.java.event.domain.Event;
import fr.greta.java.event.domain.EventService;
import fr.greta.java.event.domain.EventWrapper;
import fr.greta.java.event.persistance.EventEntity;
import fr.greta.java.event.persistance.EventRepository;
import fr.greta.java.generic.exception.RepositoryException;
import fr.greta.java.generic.exception.ServiceException;
import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class EventServiceTest {
    EventRepository repository = mock(EventRepository.class);
    EventWrapper wrapper = mock(EventWrapper.class);

    EventService service = new EventService(repository, wrapper);

    @Test
    public void serviceCreateGoesWell() throws RepositoryException, ServiceException {
        Event event = mock(Event.class);
        EventEntity entity = mock(EventEntity.class);

        when(event.isValid()).thenReturn(true);
        when(wrapper.toEntity(event)).thenReturn(entity);
        when(repository.create(entity)).thenReturn(entity);
        when(wrapper.fromEntity(entity)).thenReturn(event);

        service.create(event);

        InOrder inOrder = inOrder(wrapper, repository);
        inOrder.verify(wrapper).toEntity(event);
        inOrder.verify(repository).create(entity);
        inOrder.verify(wrapper).fromEntity(entity);
    }

    @Test
    public void serviceCreateGoesWrongWithInvalidEvent() {
        Event event = mock(Event.class);

        when(event.isValid()).thenReturn(false);

        try {
            service.create(event);
        } catch (ServiceException e) {
        }

        verify(wrapper, never()).toEntity(any());
    }
}