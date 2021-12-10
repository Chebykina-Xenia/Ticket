import manager.TicketManager;
import org.junit.jupiter.api.Test;
import repository.TicketRepository;
import ticket.Ticket;

import static org.junit.jupiter.api.Assertions.*;

public class TicketManagerTest {
    //DME -Домодедово
    //EGO - Белгород
    //LED - Санкт-Петербург
    //KUF - Самара
    //GOJ - Нижний Новгород
    //FRU - Бишкек
    private TicketRepository repo = new TicketRepository();
    private TicketManager manager = new TicketManager(repo);

    private Ticket ticket1 = new Ticket(1, 1000, "DME", "LED", 120);
    private Ticket ticket2 = new Ticket(2, 5000, "FRU", "GOJ", 240);
    private Ticket ticket3 = new Ticket(3, 3500, "FRU", "KUF", 320);
    private Ticket ticket4 = new Ticket(4, 2550, "DME", "FRU", 60);
    private Ticket ticket5 = new Ticket(5, 2260, "FRU", "EGO", 240);
    private Ticket ticket6 = new Ticket(6, 4500, "DME", "LED", 110);
    private Ticket ticket7 = new Ticket(7, 1100, "DME", "LED", 120);

    //ПРОВЕРКА РАБОТЫ ПОИСКА — ЕСТЬ БИЛЕТЫ, УДОВЛЕТВОРЯЮЩИЕ ПОИСКУ
    @Test
    void searchByTrue() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
        repo.save(ticket7);

        Ticket[] actual = manager.searchBy("DME", "LED");
        Ticket[] expected = new Ticket[]{ticket1, ticket7, ticket6};

        //проверка ожидаемого и фактического результата
        assertArrayEquals(expected, actual);
    }

    //ПРОВЕРКА РАБОТЫ ПОИСКА — НЕТ БИЛЕТОВ, УДОВЛЕТВОРЯЮЩИЕ ПОИСКУ
    @Test
    void searchByFalse() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
        repo.save(ticket7);

        Ticket[] actual = manager.searchBy("DME", "KUF");
        Ticket[] expected = new Ticket[0];

        //проверка ожидаемого и фактического результата
        assertArrayEquals(expected, actual);
    }
}



