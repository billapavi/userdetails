package com.billa.user.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.billa.user.entities.LoadData;
import com.billa.user.entities.LoadDayOrMinData;
import com.billa.user.entities.SummaryDetails;
import com.billa.user.entities.UserDetails;

@RequestMapping("/api")
@CrossOrigin(origins = { "http://172.94.4.193:4200" }, maxAge = 3600)
@RestController
public class UserController {
	public static final String url = "http://172.94.4.193:1987/";
	@Autowired
	private SummaryDetails details;
	public static Map<String, List<String>> summaryList = new ConcurrentHashMap<String, List<String>>();
	public static final String TG = "TG";
	public static final String TL = "TL";
	public static final String GP = "GP";
	public static final String GD = "GD";
	public static Map<String,UserDetails> userDetailsMap = new ConcurrentHashMap<String, UserDetails>();
	static {
		userDetailsMap.put("RP5337", new UserDetails("billa.pavi@gmail.com", "RP5337", "", "9833206256", "yati1234", "male", "1eemehdad6ljgh42", "aoytftjnb70su2lhctr61egfmt21zm1z"));
		summaryList.put("TG", new ArrayList<String>());
		summaryList.put("TL", new ArrayList<String>());
		summaryList.put("GP", new ArrayList<String>());
		summaryList.put("GD", new ArrayList<String>());

		summaryList.get(TG).add("LUPIN");
		summaryList.get(TG).add("YESBANK");
		summaryList.get(TG).add("JETAIRWAYS");
		summaryList.get(TG).add("SBIN");
		summaryList.get(TL).add("SBIN");
		summaryList.get(TL).add("DRREDDY");
		summaryList.get(TL).add("TATA");
		summaryList.get(TL).add("ABC");
		summaryList.get(GP).add("DLF");
		summaryList.get(GP).add("OIL");
		summaryList.get(GP).add("BAJAFIN");
		summaryList.get(GP).add("TATA");
		summaryList.get(GD).add("ACC");
		summaryList.get(GD).add("LL");
		summaryList.get(GD).add("SFSF");
		summaryList.get(GD).add("SFFD");
		
	}
	
//	@PostMapping("/demo")
//	public UserDetails createUser(@RequestBody UserDetails details) {
//		System.out.println("create user called" + details); 
//		return null;
//	}

	//load/{exchange}/{dayormin}/{currDate}/{prevDate}
	@PostMapping("/load")
	public LoadData LoadDayOrMinData(@RequestBody LoadDayOrMinData dayorMinData) {
		System.out.println("create user called load called " + dayorMinData); 
		RestTemplate template = new RestTemplate();
		String ur =url+ "update/"+dayorMinData.getExchange()+"/"+dayorMinData.getDayormin()+"/"+dayorMinData.getToDate()+"/"+dayorMinData.getFromDate();
		System.out.println(ur);
		ResponseEntity<String> respEntity = template.getForEntity(ur, String.class);
//		ResponseEntity<List> respEntity = template.getForEntity("http://localhost:1987/get/LUPIN", List.class);
		System.out.println("response entity");
		System.out.println(respEntity);
		System.out.println(respEntity.getBody().toString());
		String jsonstr = respEntity.getBody().toString();
		LoadData d = new LoadData();
		d.setDataloaded(jsonstr);
		String dataloaded = "khatam";
		return d;
	}
	//load/{exchange}/{dayormin}/{currDate}/{prevDate}
	@PostMapping("/updw")
	public LoadData gapupdown(@RequestBody LoadDayOrMinData dayorMinData) {
		System.out.println("create user called" + dayorMinData); 
		RestTemplate template = new RestTemplate();
		String ur =url+"updw/"+dayorMinData.getExchange()+"/"+dayorMinData.getFromDate()+"/"+dayorMinData.getStockName();
		System.out.println(ur);
		ResponseEntity<String> respEntity = template.getForEntity(ur, String.class);
//		ResponseEntity<List> respEntity = template.getForEntity("http://localhost:1987/get/LUPIN", List.class);
		System.out.println("response entity");
		System.out.println(respEntity);
		System.out.println(respEntity.getBody().toString());
		String jsonstr = respEntity.getBody().toString();
		LoadData d = new LoadData();
		d.setDataloaded(jsonstr);
		String dataloaded = "khatam";
		return d;
	}
	
	@GetMapping("/demo")
	public LoadData createUser() {
		System.out.println("create user called" + details); 
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> respEntity = template.getForEntity(url+"demo", String.class);
//		ResponseEntity<List> respEntity = template.getForEntity("http://localhost:1987/get/LUPIN", List.class);
		System.out.println("response entity");
		System.out.println(respEntity);
		System.out.println(respEntity.getBody().toString());
		String jsonstr = respEntity.getBody().toString();
		LoadData d = new LoadData();
		d.setDataloaded(jsonstr);
		return d;
	}
	
	@GetMapping("/summary")
	public  SummaryDetails getSummary() {
		System.out.println("Summary called.." + summaryList);
		details.setGD(summaryList.get(GD).toArray(new String[summaryList.get(GD).size()]));
		details.setGU(summaryList.get(GP).toArray(new String[summaryList.get(GP).size()]));
		details.setTG(summaryList.get(TG).toArray(new String[summaryList.get(TG).size()]));
		details.setTL(summaryList.get(TL).toArray(new String[summaryList.get(TL).size()]));
//		return summaryList;
		return details;
	}
	@GetMapping(path = "/getUser/{userID}")
	public UserDetails getUserDetils(@PathVariable String userID)
	{
		//TODO This would be mapped to actual db in the later purpose
		return userDetailsMap.get(userID);
	}
}
