import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner insert = new Scanner(System.in);
        TicketManager ticketManager = new TicketManager();
        System.out.println("Введите команду help для вывода списка команд!");
        while(true)
        {
            String line = insert.nextLine();
                if(line.contains("exit"))
                    break;
                else if(line.contains("help"))
                    System.out.println("info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                            "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                            "add : добавить новый элемент в коллекцию\n"+
                            "update {id} : обновить значение элемента коллекции, id которого равен заданному\n"+
                            "remove_by_id {id} : удалить элемент из коллекции по его id\n"+
                            "clear : очистить коллекцию\n"+
                            "exit : завершить программу (без сохранения в файл)\n"+
                            "remove_at {index} : удалить элемент, находящийся в заданной позиции коллекции (index)\n"+
                            "remove_first : удалить первый элемент из коллекции\n"+
                            "filter_greater_than_type {type} : вывести элементы, значение поля type которых больше заданного\n"+
                            "print_field_descending_person : вывести значения поля person всех элементов в порядке убывания");
                else if(line.contains("info"))
                    ticketManager.info();
                else if(line.contains("show"))
                    ticketManager.show();
                else if(line.contains("add"))
                    ticketManager.add();
        }
    }
}
