package com.session.spring.boot.TicketTrack1.service;

import java.util.List;

import com.session.spring.boot.TicketTrack1.dto.TicketDto;
import com.session.spring.boot.TicketTrack1.entity.Ticket;

public interface TicketService {

	 List<TicketDto> findAllTickets();
	 
	 void addTicket(Ticket ticket);
	 
	 void deleteTicket(Long id);
	    
	    Ticket getTicketById(Long id);
	    
	 
		List<TicketDto> searchTickets(String query);

}
