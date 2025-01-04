package com.nt.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nt.listener.JobMonitoringListener;
import com.nt.processor.BookItemProcessor;
import com.nt.reader.BookItemReader;
import com.nt.writer.BookItemWriter;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	private StepBuilderFactory stepFactory;
	@Autowired
	private JobBuilderFactory jobFactory;
	@Autowired
	private BookItemReader reader;
	@Autowired
	private BookItemProcessor processor;
	@Autowired
	private BookItemWriter writer;
	@Autowired
	private JobMonitoringListener listener;
	
	@Bean(name="step1")
	public Step createStep1() {
		return stepFactory.get("step1")
				.<String, String>chunk(2)
				.reader(reader)
				.processor(processor)
				.writer(writer)
				.build();
	}
	
	@Bean(name="job1")
	public Job createJob1() {
		System.out.println("BatchConfig.createJob1()");
		return jobFactory.get("job1")
		        .listener(listener)
		        .incrementer(new RunIdIncrementer())
		        .start(createStep1())
		        .build();
	}

}
