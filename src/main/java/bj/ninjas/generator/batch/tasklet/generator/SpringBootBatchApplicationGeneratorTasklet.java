package bj.ninjas.generator.batch.tasklet.generator;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import bj.ninjas.generator.AplicationGeneratorConfiguration;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SpringBootBatchApplicationGeneratorTasklet implements Tasklet{

    final AplicationGeneratorConfiguration configuration;

    @Override
    public RepeatStatus execute(
        final StepContribution contribution, 
        final ChunkContext chunkContext
    ) throws Exception {
        // Create New Folder
        
        // Create Main Class

        // Create Application.properties File

        // Create pom.xml file
        return RepeatStatus.FINISHED;
    }
    
}
