package com.session.spring.boot.TicketTrack1.mapper;

import com.session.spring.boot.TicketTrack1.dto.TicketDto;
import com.session.spring.boot.TicketTrack1.entity.Ticket;

public class TicketMapper {
	
	public static TicketDto mapToTicketDto(Ticket ticket) {
		
		TicketDto ticketDto = TicketDto.builder()
				.ticketTitle(ticket.getTicketTitle())
				.id(ticket.getId())
				.ticketShortDescription(ticket.getTicketShortDescription())
				.content(ticket.getContent())
				.createdOn(ticket.getCreatedOn()).
				
				build();
		return ticketDto;
	}
	
	public static Ticket mapTicketDtoToTicket(TicketDto ticketDto) {
		
		Ticket ticket = Ticket.builder()
				.ticketTitle(ticketDto.getTicketTitle())
				.id(ticketDto.getId())
				.ticketShortDescription(ticketDto.getTicketShortDescription())
				.content(ticketDto.getContent())
				.createdOn(ticketDto.getCreatedOn()).
				
				build();
		return ticket;
		
	}

}
