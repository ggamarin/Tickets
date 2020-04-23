package ru.netology.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Ticket;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketRepository {
    Ticket[] tickets = new Ticket[0];

    public void save(Ticket ticket) {
        int length = tickets.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public Ticket[] getAll() {
        return tickets;
    }
}
