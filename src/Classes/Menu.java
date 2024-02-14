package Classes;

import Enums.PriorityEnum;
import Enums.StatusEnum;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Menu {
    String menu = "Digite a opção desejada: " +
            "\n 1 para criar uma nova tarefa" + "\n 2 para Listas suas tarefas" +
            "\n 3 para deletar uma tarefa" + "\n 0 para encerrar";
    Scanner sc = new Scanner(System.in);

    public void start() throws ParseException {
        System.out.println(menu);
        int op = sc.nextInt();
        while (op != 0) {
            switch (op){
                case 1:
                    new_task();
                    break;
                case 2:
                    System.out.println("não implementado");
                    break;
                case 3:
                    System.out.println("não implementado");
                    break;
                default:
                    System.out.println("Digite uma opção válida");
                    break;
            }
            System.out.println(menu);
            op = sc.nextInt();
        }
    }

    private void new_task() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome da nova tarefa");
        String name = sc.nextLine();
        System.out.println("Digite o descrição da nova tarefa");
        String description = sc.nextLine();
        System.out.println("Digite a data final no formato dd/MM/yyyy hh:mm PM/AM");
        String date = sc.nextLine();
        System.out.println("Digite a prioridade (1,2,3 4 ou 5)");
        int priority = sc.nextInt();
        while (!valid_Priority(priority)){
            System.out.println("Digite apenas os valores (1,2,3 4 ou 5)");
            priority = sc.nextInt();
        }
        System.out.println("Digite a categoria");
        String category = sc.next();
        System.out.println("Digite o status (todo, doing ou done)");
        String status = sc.next();
        while (!valid_status(status)){
            System.out.println("Digite apenas os valores (todo, doing ou done)");
            status = sc.next();
        }

        SimpleDateFormat sdf = new SimpleDateFormat("d/M/y hh:mm a");
        Task task = new Task ( name, description, sdf.parse(date), priority, category, status);
        System.out.println(task);
    }

    private Boolean valid_Priority(int priority){
        boolean b = false;
        PriorityEnum[] prioritys = PriorityEnum.values();
        for (PriorityEnum p : prioritys) {
            if (priority == p.getPriority()){
                b = true;
            }
        }
        return b;
    }

    private Boolean valid_status(String status){
        boolean b = false;
        StatusEnum[] all_status = StatusEnum.values();
        for (StatusEnum s : all_status) {
            if (status.equals(s.getStatus())){
                b = true;
            }
        }
        return b;
    }

}
