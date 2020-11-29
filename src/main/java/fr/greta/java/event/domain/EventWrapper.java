package fr.greta.java.event.domain;

import fr.greta.java.event.persistance.EventEntity;
import java.util.Date;
import java.util.Calendar;

public class EventWrapper {

    public EventEntity toEntity(Event model){
        EventEntity entity = new EventEntity();
        entity.setId(model.getId());

        entity.setTitle(model.getTitle());
        entity.setDescription(model.getDescription());

        entity.setBeginDate(model.getBeginCalendar().getTime());
        entity.setEndDate(model.getEndCalendar().getTime());


        return entity;
    }

    public Event fromEntity(EventEntity entity){
        Event model = new Event();

        model.setId(entity.getId());
        model.setTitle(entity.getTitle());
        model.setDescription(entity.getDescription());

        Calendar beginCalendar = toCalendar(entity.getBeginDate());
        Calendar endCalendar = toCalendar(entity.getEndDate());

        model.setBeginCalendar(beginCalendar);
        model.setEndCalendar(endCalendar);

        return model;
    }



    private Calendar toCalendar(Date Date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Date);
        return calendar;
    }
}
