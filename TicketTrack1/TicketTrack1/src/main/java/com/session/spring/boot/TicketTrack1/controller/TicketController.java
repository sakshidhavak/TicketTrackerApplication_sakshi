package com.session.spring.boot.TicketTrack1.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.session.spring.boot.TicketTrack1.dto.TicketDto;
import com.session.spring.boot.TicketTrack1.entity.Ticket;
import com.session.spring.boot.TicketTrack1.service.TicketServiceImpl;

@Controller
public class TicketController {
	
	private TicketServiceImpl ticketServiceImpl;
	
	@Autowired
	public TicketController(TicketServiceImpl ticketservice) {
		this.ticketServiceImpl = ticketservice;
	}
	
	
	@GetMapping("/allTickets")
	public String Tickets(Model model) {
		List<TicketDto> ticket = ticketServiceImpl.findAllTickets();
		model.addAttribute("ticketsAttribute", ticket);
		return "listOfTickets";
		
	}

	
	
	@GetMapping("/newTicket")
	public String createTicketForm(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute("ticketAttribute", ticket);
		return "addTicket";
	}

	
	@PostMapping("/saveTicket")
	public String saveTicket(@ModelAttribute("ticketAttribute") Ticket ticket) {
	   
          ticket.setContent(ticket.getContent()); 
	   
	    ticketServiceImpl.addTicket(ticket);
	    return "redirect:/allTickets";
	}
	
	@GetMapping("/tickets/delete/{id}")
	public String deleteTicket(@PathVariable Long id) {
		ticketServiceImpl.deleteTicket(id);
		return "redirect:/allTickets";
	}
	

	
	@GetMapping("/tickets/edit/{id}")
	public String editTicketForm(@PathVariable Long id, Model model) {
		model.addAttribute("ticketsAttribute", ticketServiceImpl.getTicketById(id));
		return "updateTicket";
	}

	@PostMapping("/updateTicket/{id}")
	public String updateTicket(@PathVariable Long id, @ModelAttribute("ticketsAttribute") Ticket ticket) {
	    Ticket existingTicket = ticketServiceImpl.getTicketById(id);
	    
        existingTicket.setContent(ticket.getContent());
	    existingTicket.setId(id);
	    existingTicket.setTicketTitle(ticket.getTicketTitle());
	    existingTicket.setTicketShortDescription(ticket.getTicketShortDescription());
	    ticketServiceImpl.addTicket(existingTicket);
	    return "redirect:/allTickets";
	}
	 @GetMapping("/search")
	 public String searchTickets(@RequestParam(value = "query") String query, Model model) {

			List<TicketDto> tickets = ticketServiceImpl.searchTickets(query);
			model.addAttribute("ticketsAttribute", tickets);
			return "listOfTickets";

		}
	 @GetMapping("/view/{id}")
	 public String viewPost(@PathVariable long id, Model model) {
	     Ticket ticketDto = ticketServiceImpl.getTicketById(id);
	     model.addAttribute("ticketsAttribute", ticketDto);
	     return "viewTicket";
	 }



}