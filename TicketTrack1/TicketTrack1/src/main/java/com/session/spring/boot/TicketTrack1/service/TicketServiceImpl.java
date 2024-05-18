package com.session.spring.boot.TicketTrack1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.session.spring.boot.TicketTrack1.dto.TicketDto;
import com.session.spring.boot.TicketTrack1.entity.Ticket;
import com.session.spring.boot.TicketTrack1.mapper.TicketMapper;
import com.session.spring.boot.TicketTrack1.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {
	
	

	private TicketRepository ticketrepository;
	
	@Autowired
	public TicketServiceImpl(TicketRepository ticketrepo) {
		this.ticketrepository = ticketrepo;
	}
	
	

	@Override
	public List<TicketDto> findAllTickets() {
		List<Ticket> ticket = ticketrepository.findAll();
		
		// TODO Auto-generated method stub
		return ticket.stream().map(TicketMapper::mapToTicketDto).collect(Collectors.toList());
	}

	@Override
	public void addTicket(Ticket ticket) {
		ticketrepository.save(ticket);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTicket(Long id) {
		ticketrepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Ticket getTicketById(Long id) {
		// TODO Auto-generated method stub
		return ticketrepository.findById(id).get();
	}



	@Override
	public List<TicketDto> searchTickets(String query) {
		List<Ticket> tickets = ticketrepository.searchTickets(query);
		// TODO Auto-generated method stub
		return tickets.stream().map(TicketMapper::mapToTicketDto).collect(Collectors.toList());
	}



	

}
