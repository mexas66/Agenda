package fr.greta.java.event.facade;

import fr.greta.java.event.domain.Event;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EventDTOWrapper {
    public EventDTO todto(Event model){
        EventDTO dto = new EventDTO();
        dto.setId(model.getId());

        dto.setBeginDate(toDateDTO(model.getBeginCalendar()));
        dto.setEndDate(toDateDTO(model.getEndCalendar()));

        dto.setTitle(model.getTitle());
        dto.setDescription(model.getDescription());

        return dto;
    }


    public List<EventDTO> todtos(List<Event> events) {
        List<EventDTO> dtos = new ArrayList();
        for (Event event: events){
            dtos.add(todto(event));
        }
        return dtos;
    }



    private DateDTO toDateDTO(Calendar calendar) {
        DateDTO dto = new DateDTO();
        dto.setDay(calendar.get(Calendar.DAY_OF_MONTH));
        dto.setMonth(calendar.get(Calendar.MONTH));
        dto.setYear(calendar.get(Calendar.YEAR));
        dto.setHour(calendar.get(Calendar.HOUR));
        dto.setMinute(calendar.get(Calendar.MINUTE));

        return dto;
    }
}
