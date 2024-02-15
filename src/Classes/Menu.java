package Classes;

import java.text.ParseException;
import java.util.Scanner;

public class Menu {
    String menu = "Digite a opção desejada: " +
            "\n 1 para criar uma nova tarefa" + "\n 2 para Listas suas tarefas" +
            "\n 3 para deletar uma tarefa" + "\n 0 para encerrar" +
            "\n ------------------------------";
    Scanner sc = new Scanner(System.in);
    Task_actions action = new Task_actions();

    public void start() throws ParseException {
        System.out.println(menu);
        int op = sc.nextInt();
        while (op != 0) {
            switch (op){
                case 1:
                    action.new_task();
                    break;
                case 2:
                    action.list_tasks();
                    break;
                case 3:
                    action.delete_Task();
                    break;
                default:
                    System.out.println("Digite uma opção válida");
                    break;
            }
            System.out.println("\n" + menu);
            op = sc.nextInt();
        }
    }
}
