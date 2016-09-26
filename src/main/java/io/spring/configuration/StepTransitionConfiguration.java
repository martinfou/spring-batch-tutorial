package io.spring.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StepTransitionConfiguration {
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step step1(){
		return stepBuilderFactory.get("step1")
				.tasklet(new Tasklet() {
					@Override
					public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContest)
							throws Exception {
						System.out.println("I am running");
						return RepeatStatus.FINISHED;
					}
				}).build();
	}
	
	@Bean
	public Step step2(){
		return stepBuilderFactory.get("step2")
				.tasklet(new Tasklet() {
					@Override
					public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContest)
							throws Exception {
						System.out.println("I am running");
						return RepeatStatus.FINISHED;
					}
				}).build();
	}
	
	@Bean
	public Step step3(){
		return stepBuilderFactory.get("step3")
				.tasklet(new Tasklet() {
					@Override
					public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContest)
							throws Exception {
						System.out.println("I am running");
						return RepeatStatus.FINISHED;
					}
				}).build();
	}
	
	public Job transiJobSimpleNext(){
		return jobBuilderFactory.get("transitionJobNext")
				.start(step1())
				.next(step2())
				.next(step3())
				.build();
	}

}
