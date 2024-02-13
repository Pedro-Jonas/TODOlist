import Classes.Tarefa;
import Enums.PriorityEnum;
import Enums.StatusEnum;

import java.util.Date;

public class App {
    public static void main(String[] args) {
        Tarefa tarefa1 = new Tarefa ( "criar o botão", "botão do altura 100px e largura 300px",
                new Date(), PriorityEnum.P3, "layout", StatusEnum.TODO);
        System.out.println(tarefa1);
    }
}
