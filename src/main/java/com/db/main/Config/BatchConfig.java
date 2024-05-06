package com.db.main.Config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import com.db.main.entity.Person;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory,
			StepBuilderFactory stepBuilderFactory,
			ItemReader<Person> itemReader,
			ItemProcessor<Person, Person> itemProcessor, 
			ItemWriter<Person> itemWriter) {

		Step step = stepBuilderFactory.get("ETL-file-load")
				.<Person, Person>chunk(100).
				reader(itemReader)
				.processor(itemProcessor).
				writer(itemWriter)
				.build();

		return jobBuilderFactory.get("ETL-Load")
				.incrementer(new RunIdIncrementer())
				.start(step)
				.build();
	}


	@Bean
	public FlatFileItemReader<Person> reader() {
		
		FlatFileItemReader<Person> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource(new FileSystemResource("src/main/resources/lol.csv"));
		flatFileItemReader.setName("CSV-Reader");
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setLineMapper(getLineMapper());
		return flatFileItemReader;
	}

	@Bean
	public LineMapper<Person> getLineMapper() {
		
		DefaultLineMapper<Person> lineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String[] { "FirstName", "LastName", "Dob", "Gender", "Age", "Email", "Phonno",
				"Education", "Occupation", "MaritalStatus", "Hobby", "StreetAddress", "City", "Pincode", "State",
				"Country", "personid" });
		lineTokenizer.setIncludedFields(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 });

		BeanWrapperFieldSetMapper<Person> fieldsetter = new BeanWrapperFieldSetMapper<>();
		fieldsetter.setTargetType(Person.class);

		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldsetter);

		return lineMapper;
	}

}
