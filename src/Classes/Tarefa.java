package Classes;

import Enums.PriorityEnum;
import Enums.StatusEnum;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Tarefa {
    String name;
    String description;
    Date final_date;
    PriorityEnum priority;
    String category;
    StatusEnum status;

    SimpleDateFormat sdf = new SimpleDateFormat("d/M/y hh:mm a");

    public Tarefa(String name, String description, Date final_date,
                   PriorityEnum priority, String category, StatusEnum status) {
        this.name = name;
        this.description = description;
        this.final_date = final_date;
        this.priority = priority;
        this.category = category;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getFinal_date() {
        return final_date;
    }

    public void setFinal_date(Date final_date) {
        this.final_date = final_date;
    }

    public PriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(PriorityEnum priority) {
        this.priority = priority;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Classes.Tarefa{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", final_date=" + sdf.format(final_date) +
                ", priority=" + priority +
                ", category='" + category + '\'' +
                ", status=" + status +
                '}';
    }
}
