package com.jcircle.email.batch.config;

import java.io.IOException;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.jcircle.email.batch.processors.FeedItemProcessor;

@Configuration
@EnableBatchProcessing
public class WorkFeedBatchConfig {
/*
	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	


	@Bean
	public MultiResourceItemReader<String> multiResourceItemReader() {
		MultiResourceItemReader<String> multiResourceItemReader = new MultiResourceItemReader();
		try {
			ClassLoader loader = WorkFeedBatchConfig.class.getClassLoader();
			ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(loader);
			Resource[] inputResources = resolver.getResources("file:C:/xmls/Test1.xml");

			multiResourceItemReader.setResources(inputResources);
			multiResourceItemReader.setDelegate(reader());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return multiResourceItemReader;

	}

	@Bean
	public FeedItemProcessor processor() {
		System.out.println("Trigerring the processor");
		return new FeedItemProcessor();
	}

	@Bean
	public Job importUserJob() {
		System.out.println("Trigerring the Job");
		return jobBuilderFactory.get("importUserJob").flow(step1()).end().build();
	}

	@Bean
	public FlatFileItemWriter<String> writer() {
		ClassLoader loader = WorkFeedBatchConfig.class.getClassLoader();
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(loader);
		Resource outputResource = resolver.getResource("file:C:/xmls/Test.txt");
		// Create writer instance
		FlatFileItemWriter<String> writer = new FlatFileItemWriter<>();

		// Set output file location
		writer.setResource(outputResource);

		// All job repetitions should "append" to same output file
		writer.setAppendAllowed(true);

		// Name field values sequence based on object properties
		writer.setLineAggregator(new DelimitedLineAggregator<String>() {
			{
				setDelimiter(",");
				
				
			}
		});
		return writer;
	}

	@Bean
	public StaxEventItemReader<String> reader() {
		System.out.println("Trigerring the Reader");
		StaxEventItemReader<String> xmlFileReader = new StaxEventItemReader<>();
		Jaxb2Marshaller studentMarshaller = new Jaxb2Marshaller();
		xmlFileReader.setFragmentRootElementName("ServiceBusEnvelope");
		studentMarshaller.setClassesToBeBound(String.class);

		xmlFileReader.setUnmarshaller(studentMarshaller);
		return xmlFileReader;
	}

	@Bean
	public Step step1() {
		System.out.println("Trigerring the step1");
		return stepBuilderFactory.get("step1").<String, String>chunk(30).reader(reader()).processor(processor())
				.writer(writer()).build();
	}
	
	*/

}
