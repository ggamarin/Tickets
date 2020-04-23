package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.domain.TicketByPriceAscComparator;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class TicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    private Ticket testticket1 = new Ticket(1, 1300, "KUF", "OGZ", 90);
    private Ticket testticket2 = new Ticket(2, 1700, "MOW", "TOF", 175);
    private Ticket testticket3 = new Ticket(9, 4200, "KUF", "OGZ", 115);
    private Ticket testticket4 = new Ticket(6, 1500, "MOW", "UFA", 150);


    @BeforeEach
    void setUp() {
        repository.save(testticket1);
        repository.save(testticket2);
        repository.save(testticket3);
        repository.save(testticket4);
    }

    @Test
    void shouldFindAll() {
        Ticket[] actual = manager.findAll("KUF", "OGZ", new TicketByPriceAscComparator());
        Ticket[] expected = {
                testticket1,
                testticket3
        };
        assertArrayEquals(expected, actual);
    }

    @Test

    void shouldFindNothing() {
        Ticket[] actual = manager.findAll("KZN", "LED", new TicketByPriceAscComparator());
        Ticket[] expected = {};
        assertArrayEquals(expected, actual);
    }
}

