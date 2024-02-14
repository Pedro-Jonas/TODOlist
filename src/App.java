import Classes.Tarefa;
import Enums.PriorityEnum;
import Enums.StatusEnum;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;

public class App {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/y hh:mm a");
        Date data2 = sdf.parse("22/02/2024  2:50 PM");

        Tarefa tarefa1 = new Tarefa ( "criar o botão", "botão do altura 100px e largura 300px",
                data2, PriorityEnum.P4, "layout", StatusEnum.TODO);
        System.out.println(tarefa1);
    }
}
