package com.session.spring.boot.TicketTrack1.entity;

import java.time.LocalDateTime;



import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="Ticket")
public class Ticket {
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private long id;
	 
	 @Column(nullable = false)
	 private String ticketTitle;
	 
	
	 
	 private String ticketShortDescription;
	 
	    @Lob
		private String content;
	 
	 @CreationTimestamp
	 private LocalDateTime createdOn;
	 
	
}
