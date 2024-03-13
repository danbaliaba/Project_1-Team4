import java.util.Objects;
import java.util.Scanner;
public class Ticket implements Comparable<Ticket>{
    private static int counter = 0;
    private long id ; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private int price; //Значение поля должно быть больше 0
    private TicketType type; //Поле может быть null
    private String person;//Поле не может быть null


    Scanner scan = new Scanner (System.in);

    public Ticket(String name, int price, TicketType type, String person) {
        this.id = ++counter;
        this.name = name;
        this.price = price;
        this.type = type;
        this.person = person;
    }

    public Ticket() {

    }


    public void setId()
    {
        this.id = 2348972 + Ticket.counter;
        Ticket.counter++;
    }
    public long getId(){
        return  id;
    }

    public void setName(){
        System.out.print("Введите имя : ");
        this.name = scan.nextLine();
        if(this.name == null )
        {
            System.out.print("Это поле не может быть пустым, введите имя : ");
            this.name = scan.nextLine();
        }
    }
    public String getName(){
        return this.name;
    }
    public void setPrice(){
        do {
            System.out.print("Введите цену : ");
            this.price = scan.nextInt();

        } while (this.price < 0);
    }
    public int getPrice(){
        return this.price;
    }
    public void setType(){
        System.out.println("Выберите один из статусов : " +
                "\n1." + TicketType.VIP +
                "\n2." + TicketType.BUDGETARY +
                "\n3." + TicketType.CHEAP +
                "\n4." + TicketType.USUAL);
        do
        {
            String insert = scan.nextLine();
            switch (insert) {
                case "VIP":
                    this.type = TicketType.VIP;
                    break;
                case "BUDGETARY":
                    this.type = TicketType.BUDGETARY;
                    break;
                case "CHEAP":
                    this.type = TicketType.CHEAP;
                    break;
                case "USUAL":
                    this.type = TicketType.USUAL;
                    break;
                case " ":
                    this.type = null;
                    break;
                default:
                    System.out.print("Выбериет тип из списка : ");
                    continue;
            }
            break;
        }while(true);
    }
    public TicketType getType(){
        return this.type;
    }
    public void setPerson(){
        Person pers  = new Person();
        pers.setPassportID();
        this.person = pers.getPassportID();
        if (this.person == null){
            System.out.print("Поле person не может быть пустым!");
            pers.setPassportID();
            this.person = pers.getPassportID();
        }
    }
    public String getPerson(){
        return this.person;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && price == ticket.price && Objects.equals(name, ticket.name) && type == ticket.type && Objects.equals(person, ticket.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, type, person);
    }

    public String toString(){
        return "Название : " + this.name + "\nЦена : " + this.price +"\nСтатус : " + this.type +"\nPerson : "+ this.person + "\nID : " + this.id +"\n";
    }
    @Override
    public int compareTo(Ticket o) {
        return Math.max(o.getPrice(), this.getPrice());
    }
    public String showPerson(){
        return "Идентификационный номер персоны " + person;
    }
}

