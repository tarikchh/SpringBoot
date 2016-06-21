package com.boot.test;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/application")
public class ApplicationController {

	@RequestMapping(method = RequestMethod.GET)
	public String getMSG(){
	return "Bonjour tout le monde";
}	
	@RequestMapping(value="/{shortName}",method = RequestMethod.GET)
	public String getMSGName(@PathVariable("shortName") String shortName){
	return "Bonjour : "+shortName;
}	
}
