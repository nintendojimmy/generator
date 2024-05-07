package bj.ninjas.generator.batch.chunk;

import org.springframework.batch.item.ItemProcessor;

import bj.ninjas.generator.batch.record.GeneratedSourceRecord;
import bj.ninjas.generator.batch.record.SourceGenerationRecord;
import bj.ninjas.generator.freemarker.FreemarkerService;
import lombok.Builder;

@Builder
public class SourceGenerationRecordItemProcessor implements ItemProcessor<SourceGenerationRecord, GeneratedSourceRecord>{
    final FreemarkerService serviceFreemarker;


    @Override
    public GeneratedSourceRecord process( final SourceGenerationRecord record ) throws Exception {
        return 
            new GeneratedSourceRecord(
                record.nameJavaFile(),
                record.nameTemplate(),
                record.dataTemplate(),
                serviceFreemarker.renderTemplate( record.nameTemplate(), record.dataTemplate() ).orElseThrow() 
            );
    }

}
