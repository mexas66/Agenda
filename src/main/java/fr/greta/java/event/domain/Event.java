package fr.greta.java.event.domain;

import java.util.Calendar;
import java.util.Date;

public class Event {
    private int id;

    private Calendar beginCalendar;
    private Calendar endCalendar;

    private String title;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getBeginCalendar() {
        return beginCalendar;
    }

    public void setBeginCalendar(Calendar date) {
        this.beginCalendar = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getEndCalendar() {
        return endCalendar;
    }

    public void setEndCalendar(Calendar endCalendar) {
        this.endCalendar = endCalendar;
    }

    public boolean isValid() {
        if (beginCalendar.compareTo(endCalendar) <= 0){
            return true;
        }
        return false;
    }
}
