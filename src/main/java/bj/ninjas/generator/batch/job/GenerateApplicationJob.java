package bj.ninjas.generator.batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import bj.ninjas.generator.AplicationGeneratorConfiguration;
import bj.ninjas.generator.batch.chunk.SourceGenerationRecordItemProcessor;
import bj.ninjas.generator.batch.chunk.SourceGenerationRecordItemReader;
import bj.ninjas.generator.batch.chunk.SourceGenerationRecordItemWriter;
import bj.ninjas.generator.batch.record.GeneratedSourceRecord;
import bj.ninjas.generator.batch.record.SourceGenerationRecord;
import bj.ninjas.generator.freemarker.FreemarkerService;
import bj.ninjas.generator.project.Project;

//@Profile("GenerateSpringBootBatch")
@Configuration
public class GenerateApplicationJob {

    private static final String GENERATION_PROJECT_JOB = "GENERATION_PROJECT_JOB";
    private static final String GENERATE_SOURCES_STEP = "GENERATE_SOURCES_STEP";

    @Bean
    public Job jobGenerateApplication(
        final JobRepository jobRepository,
        final Step stepGenerateSources
    ){
        return new JobBuilder( GENERATION_PROJECT_JOB, jobRepository )
            .start( stepGenerateSources )
            .build();
    }

    @Bean
    public Step stepGenerateSources(
        final JobRepository jobRepository,
        final PlatformTransactionManager platformTransactionManager,
        final SourceGenerationRecordItemReader reader,
        final SourceGenerationRecordItemProcessor processor,
        final FlatFileItemWriter<GeneratedSourceRecord> writer
    ){
        return new StepBuilder( GENERATE_SOURCES_STEP, jobRepository )
            .<SourceGenerationRecord,GeneratedSourceRecord>chunk(1, platformTransactionManager )
            .reader(reader)
            .processor(processor)
            .writer(writer)
            .build();
    }

    @Bean
    @StepScope
    public SourceGenerationRecordItemReader readerSourceGenerationRecord(
        final AplicationGeneratorConfiguration configuration
    ){
        return 
            SourceGenerationRecordItemReader.builder()
                .iterator( Project.buildProject( configuration ).buildSourceGenerationRecords().iterator() )
                .build();
    }

    @Bean
    @StepScope
    public SourceGenerationRecordItemProcessor processSourceGenerationRecord(
        final AplicationGeneratorConfiguration configuration,
        final FreemarkerService serviceFreemarker
    ){
        return 
            SourceGenerationRecordItemProcessor.builder()
                .serviceFreemarker(serviceFreemarker)
                .build();
    }

    @Bean
    @StepScope
    public SourceGenerationRecordItemWriter  writerGeneratedSource(
        final AplicationGeneratorConfiguration configuration
    ){
        return 
            SourceGenerationRecordItemWriter.builder()
                .directoryBuild( configuration.getDirectoryBuild() )
                .build();
    }

}
