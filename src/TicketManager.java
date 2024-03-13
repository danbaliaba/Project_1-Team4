//Тут будут написаны методы
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class TicketManager {

    private int elements;
    List<Ticket> ticketList = new ArrayList<>();

    public void add(){
        Ticket ticket = new Ticket();
        ticket.setName();
        ticket.setPrice();
        ticket.setType();
        ticket.setPerson();
        ticket.setId();
        ticketList.add(ticket);
        elements++;
    }
    public static class NameComparator implements Comparator<Ticket>{
        @Override
        public int compare(Ticket o1, Ticket o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    public void show(){
            Collections.sort(ticketList, new NameComparator());
            for(Ticket ticket : ticketList)
            {
                System.out.println(ticket);
            }
    }
    public void info(){
        System.out.println("Всего элементов : " + elements);
        System.out.println("Пуст ли список : " + ticketList.isEmpty());
        System.out.println("Тип списка : ArrayList");
    }

    public void removeFirst() {
        if (!ticketList.isEmpty()) {
            ticketList.remove(0);
        } else {
            System.out.println("Коллекция пустая");
        }
    }

    // Метод фильтрации по полю type
    public void filterGreaterThanType(TicketType type) {
        for (Ticket ticket : ticketList) {
            if (ticket.getType() != null && ticket.getType().compareTo(type) > 0) {
                System.out.println(ticket);
            }
        }
    }

    // Метод сортировки значений поля person в порядке убывания
    public void printFieldDescendingPerson() {
        ticketList.sort(Comparator.comparing(Ticket::getPerson).reversed());
        for (Ticket ticket : ticketList) {
            System.out.println(ticket.getPerson());
        }
    }
}





