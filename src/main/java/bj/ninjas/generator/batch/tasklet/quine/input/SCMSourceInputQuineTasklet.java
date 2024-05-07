package bj.ninjas.generator.batch.tasklet.quine.input;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;

public class SCMSourceInputQuineTasklet extends SourceInputQuineTasklet{

    @Override
    public RepeatStatus execute(
        final StepContribution contribution, 
        final ChunkContext chunkContext
    ) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }

}
