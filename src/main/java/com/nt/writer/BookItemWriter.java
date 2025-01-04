package com.nt.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component("biWriter")
public class BookItemWriter implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> chunk) throws Exception {
		System.out.println("BookItemWriter.write()");
		System.out.println("Processed Items::");
		chunk.forEach(item->{
			System.out.println(item+"  ");
		});
		System.out.println();
	}

}
