package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketManager {
    private TicketRepository repository;

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];

        for (Ticket ticket : repository.getAll()) {
            int length = result.length;
            if (ticket.getDeparture().equals(from) && ticket.getArrival().equals(to)) {
                Ticket[] tmp = new Ticket[length + 1];
                System.arraycopy(result, 0, tmp, 0, length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                result = tmp;
            }
        }
        if (result.length != 1) {
            Arrays.sort(result);
        }
        return result;
    }
}