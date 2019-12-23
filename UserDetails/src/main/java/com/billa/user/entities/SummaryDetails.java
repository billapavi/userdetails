package com.billa.user.entities;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class SummaryDetails {

	private String[] TG = new String[10];
	private String[] TL = new String[10];
	private String[] GD = new String[10];
	private String[] GU = new String[10];
}
