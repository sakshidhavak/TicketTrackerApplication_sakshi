package com.session.spring.boot.TicketTrack1.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
 @Builder
 @NoArgsConstructor
 @AllArgsConstructor
public class TicketDto { 
	
     private Long id;
	 
	 private String ticketTitle;
	 
	 private String ticketShortDescription;
	 

	 private String content;
	 
	 private LocalDateTime createdOn;
	 

	 
	
}
