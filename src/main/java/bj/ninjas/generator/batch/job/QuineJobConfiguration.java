package bj.ninjas.generator.batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.PlatformTransactionManager;

import bj.ninjas.generator.batch.tasklet.quine.input.DirectorySourceInputQuineTasklet;
import bj.ninjas.generator.batch.tasklet.quine.input.SourceInputQuineTasklet;

@Profile("Quine")
@Configuration
public class QuineJobConfiguration {

    private static final String APPLICATION_GENERATOR_QUINE_JOB = "APPLICATION_GENERATOR_QUINE_JOB";
    private static final String TEMP_STEP = "TEMP_STEP";

    @Bean
    public Job jobQuine(
        final JobRepository jobRepository,
        final Step stepTemp
    ){
        return new JobBuilder( APPLICATION_GENERATOR_QUINE_JOB, jobRepository)
            .start( stepTemp )
            .build();
    }

    @Bean
    public Step stepTEMP(
        final JobRepository jobRepository,
        final PlatformTransactionManager platformTransactionManager,
        final SourceInputQuineTasklet taskletSourceInputQuine
    ){
        return new StepBuilder( TEMP_STEP , jobRepository )
            .tasklet( taskletSourceInputQuine, platformTransactionManager )
            .build();
    }

    @Bean
    @StepScope
    public SourceInputQuineTasklet taskletSourceInputQuine(){
        return new DirectorySourceInputQuineTasklet();
    }

}
