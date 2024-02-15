package Classes;

import Enums.PriorityEnum;
import Enums.StatusEnum;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Task_actions {
    ArrayList<Task> all_tasks = new ArrayList<>();
    public void new_task() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome da nova tarefa");
        String name = sc.nextLine();
        System.out.println("Digite o descrição da nova tarefa");
        String description = sc.nextLine();
        System.out.println("Digite a data final no formato dd/MM/yyyy hh:mm PM/AM");
        String date = sc.nextLine();
        System.out.println("Digite a prioridade (1,2,3 4 ou 5)");
        int priority = sc.nextInt();
        while (!valid_Priority(priority)) {
            System.out.println("Digite apenas os valores (1,2,3 4 ou 5)");
            priority = sc.nextInt();
        }
        System.out.println("Digite a categoria");
        String category = sc.next();
        System.out.println("Digite o status (todo, doing ou done)");
        String status = sc.next();
        while (!valid_Status(status)) {
            System.out.println("Digite apenas os valores (todo, doing ou done)");
            status = sc.next();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/y hh:mm a");
        Task task = new Task ( name, description, sdf.parse(date), priority, category, status);
        all_tasks.add(task);
        Collections.sort(all_tasks);
    }

    public void list_tasks() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Como deseja filtrar as tarefas? \n " +
                "\n 1 para vizualizar todas as suas tarefas" + "\n 2 para vizaulizar suas tarefas por categoria" +
                "\n 3 para vizualizar suas tarefas por prioridade" + "\n 4 para vizualizar suas tarefas por status "  +
                "\n ------------------------------");
        int op = sc.nextInt();
        switch (op){
            case 1:
                show_Tasks(all_tasks);
                break;
            case 2:
                show_For_Category_Tasks();
                break;
            case 3:
                show_For_Priority();
                break;
            case 4:
                show_For_Status();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    public void delete_Task() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome da task que deseja deletar: ");
        String name = sc.nextLine();
        List<Task> for_name = all_tasks.stream().filter((task) -> (task.name.equals(name))).collect(Collectors.toList());
        if (for_name.isEmpty()) {
            System.out.println("Nenhum Task encontrada para deletar");
        } else {
            all_tasks.removeAll(for_name);
            System.out.printf("Todas as tasks com o nome [%s] foram deletaas com sucesso!%n", name);
        }
    }

    private Boolean valid_Priority(int priority) {
        boolean b = false;
        PriorityEnum[] prioritys = PriorityEnum.values();
        for (PriorityEnum p : prioritys) {
            if (priority == p.getPriority()) {
                b = true;
                break;
            }
        }
        return b;
    }

    private Boolean valid_Status(String status) {
        boolean b = false;
        StatusEnum[] all_status = StatusEnum.values();
        for (StatusEnum s : all_status) {
            if (status.equals(s.getStatus())) {
                b = true;
                break;
            }
        }
        return b;
    }

    private void show_Tasks(List<Task> tasks) {
        for(Task task : tasks) {
            System.out.println(task);
        }
    }

    private void show_For_Category_Tasks() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a descrição que deseja buscar: ");
        String categoty = sc.nextLine();
        List<Task> show_for_category = all_tasks.stream().filter((task) -> (task.category.equals(categoty))).collect(Collectors.toList());
        if (show_for_category.isEmpty()) {
            System.out.println("Nenhum resultado para essa categoria");
        } else {
            show_Tasks(show_for_category);
        }
    }

    private void show_For_Priority() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a prioriade que deseja buscar: ");
        int priority = sc.nextInt();
        while (!valid_Priority(priority)){
            System.out.println("Digite apenas os valores (1,2,3 4 ou 5)");
            priority = sc.nextInt();
        }
        int finalPriority = priority;
        List<Task> for_priority = all_tasks.stream().filter((task) -> (task.getPriority() == finalPriority)).collect(Collectors.toList());
        if (for_priority.isEmpty()) {
            System.out.println("Nenhum resultado para essa prioridade");
        } else {
            show_Tasks(for_priority);
        }
    }

    private void show_For_Status() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a status que deseja buscar: ");
        String status = sc.next();
        while (!valid_Status(status)) {
            System.out.println("Digite apenas os valores (todo, doing ou done)");
            status = sc.next();
        }
        String finalStatus = status;
        List<Task> for_status = all_tasks.stream().filter((task) -> (task.getStatus().equals(finalStatus))).collect(Collectors.toList());
        if (for_status.isEmpty()) {
            System.out.println("Nenhum resultado para essa prioridade");
        } else {
            show_Tasks(for_status);
        }
    }
}

