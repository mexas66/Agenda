package fr.greta.java.event.facade;

public class EventDTO {
    private int id;

    private DateDTO beginDate;
    private DateDTO endDate;

    private String title;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DateDTO getDate() {
        return beginDate;
    }

    public void setDate(DateDTO date) {
        this.beginDate = date;
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

    public DateDTO getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(DateDTO beginDate) {
        this.beginDate = beginDate;
    }

    public DateDTO getEndDate() {
        return endDate;
    }

    public void setEndDate(DateDTO endDate) {
        this.endDate = endDate;
    }
}
