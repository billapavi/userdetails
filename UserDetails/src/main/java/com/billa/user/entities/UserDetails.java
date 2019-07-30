package com.billa.user.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class UserDetails {

	@Id
	private String email;
	private String firstName;
	private String lasttName;
	private String phone;
	private String password;
	private String question;
	private String answer;
	private String apiKey;
	private String secKey; 
}
