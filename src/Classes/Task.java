package Classes;

import java.text.SimpleDateFormat;
import java.util.Date;
public class Task {
    String name;
    String description;
    Date final_date;
    int priority;
    String category;
    String status;

    SimpleDateFormat sdf = new SimpleDateFormat("d/M/y hh:mm a");

    public Task(String name, String description, Date final_date,
                   int priority, String category, String status) {
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

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{" +
                "NAME='" + name + '\'' +
                ", DESCRIÇÃO= " + description + '\'' +
                ", DATA FINAL= " + sdf.format(final_date) +
                ", PRIORIDADE= " + priority +
                ", CATEGORIA= " + category + '\'' +
                ", STATUS= " + status +
                "}";
    }
}
