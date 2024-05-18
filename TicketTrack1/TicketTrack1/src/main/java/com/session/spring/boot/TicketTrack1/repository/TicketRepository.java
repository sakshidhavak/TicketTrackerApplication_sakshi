package com.session.spring.boot.TicketTrack1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.session.spring.boot.TicketTrack1.dto.TicketDto;
import com.session.spring.boot.TicketTrack1.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket,Long>{
 //create query using method name , spring jpa will pass internally and uses hibernate to create the query
	
	//JPQL for search operation : use JPA entity and its field names
	@Query("SELECT p from Ticket p WHERE " +
            " p.ticketTitle LIKE CONCAT('%', :query, '%') OR " +
            " p.ticketShortDescription LIKE CONCAT('%', :query, '%')")
	List<Ticket> searchTickets(String query);
	
   

	
}
