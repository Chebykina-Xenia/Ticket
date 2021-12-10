package manager;

import repository.TicketRepository;
import ticket.Ticket;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    //добавление в репозиторий
    public void add(Ticket item) {
        repository.save(item);
    }

    //поиск
    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0];
        Ticket[] tickets = repository.findAll();
        for (Ticket ticket : tickets) {
            if (ticket.matches(from, to)) {                 //если метод matches возвращает нам true
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                Arrays.sort(tmp);
                result = tmp;
            }
        }
        return result;
    }

}
