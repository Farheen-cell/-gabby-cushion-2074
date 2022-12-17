package com.Shopping.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CardDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer CardId;
	
	@CreditCardNumber(message="Invalid Card Number")
	private String CardNumber;
	
//	@Size(min = 3,max = 3, message = "Invalid Cvv")
	@Transient
	@JsonIgnore
	private Integer cvv;
	
	@DateTimeFormat(pattern = "mm/yy")
	private LocalDate validFrom;
	
	@DateTimeFormat(pattern = "mm/yy")
	private LocalDate validTo;
	
	
	
}
