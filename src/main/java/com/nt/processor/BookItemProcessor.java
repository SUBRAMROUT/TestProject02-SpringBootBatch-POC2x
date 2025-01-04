package com.nt.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component("biProcessor")
public class BookItemProcessor implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {
		System.out.println("BookItemProcessor.process()");
		if(item.equalsIgnoreCase("TIJ"))
			return item+"--BE";
		else if(item.equalsIgnoreCase("EJ"))
			return item+"--JS";
		else if(item.equalsIgnoreCase("HFJ"))
			return item+"--KS";
		else if(item.equalsIgnoreCase("BBJ"))
			return item+"--RNR";
		else if(item.equalsIgnoreCase("CRJ"))
			return item+"--HS";
		else
		return null;
	}

}
