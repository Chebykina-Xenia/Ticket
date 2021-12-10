package repository;

import ticket.Ticket;

public class TicketRepository {
    private Ticket[] items = new Ticket[0];

    //сохраняем продукты
    public void save(Ticket item) {
        int length = items.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    //выводим все продукты
    public Ticket[] findAll() {
        return items;
    }

    //удаляем по id
    public void removeById(int id) {
        int lenght = items.length - 1;
        Ticket[] tmp = new Ticket[lenght];
        int index = 0;
        for (Ticket item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}