package com.yaqin.fundamental.repository;

import com.yaqin.fundamental.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
