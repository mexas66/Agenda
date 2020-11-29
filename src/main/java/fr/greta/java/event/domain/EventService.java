package fr.greta.java.event.domain;

import fr.greta.java.event.persistance.EventEntity;
import fr.greta.java.event.persistance.EventRepository;
import fr.greta.java.generic.exception.RepositoryException;
import fr.greta.java.generic.exception.ServiceException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class EventService {

    EventRepository repository = new EventRepository();
    EventWrapper wrapper = new EventWrapper();


    public Calendar toCalendar(String strDate) throws ServiceException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

        try {
            Date date = format.parse(strDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar;
        } catch (ParseException e) {
            throw new ServiceException(e);
        }


    }

    public void create(Event event) throws ServiceException {
        if(event.isValid()) {
            try {
                repository.create(wrapper.toEntity(event));
            } catch (RepositoryException e) {
                throw new ServiceException(e);
            }
        }else{
            throw new ServiceException();
        }
    }
    
    

    public List<Event> findAll() throws ServiceException {
        List<Event> events = new ArrayList();
        try{
            List<EventEntity> entities= repository.findAllEvent();
            for(EventEntity entity: entities){
                events.add(wrapper.fromEntity(entity));
            }
            return events;
        }catch (RepositoryException e){
            throw new ServiceException(e);
        }
    }

    public void removeById(int id) throws ServiceException {
        try {
            repository.removeById(id);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }



}
