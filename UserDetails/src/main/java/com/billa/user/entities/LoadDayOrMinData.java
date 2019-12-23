package com.billa.user.entities;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class LoadDayOrMinData {

//	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//	String currDate = "2019-05-17";
//	String prevDate = "2019-01-01";
	//load/{exchange}/{dayormin}/{currDate}/{prevDate}
	
	private String fromDate = "2019-01-16";
	private String toDate = "2019-01-16";
	private String stockName = "";
	private String exchange = "FO";
	private String dayormin = "day";
	
	
}
