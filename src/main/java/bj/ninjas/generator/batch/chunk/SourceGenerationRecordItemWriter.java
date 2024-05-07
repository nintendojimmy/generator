package bj.ninjas.generator.batch.chunk;

import java.io.FileWriter;
import java.io.IOException;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

import bj.ninjas.generator.batch.record.GeneratedSourceRecord;
import jakarta.validation.Path;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
public class SourceGenerationRecordItemWriter implements ItemWriter<GeneratedSourceRecord>{
    final Path directoryBuild;

    @Override
    public void write( final Chunk<? extends GeneratedSourceRecord> chunk) throws Exception {
        chunk.forEach(this::writeFile);
    }

    private void writeFile( GeneratedSourceRecord record ) {

        try ( final FileWriter fileWriter = new FileWriter( this.directoryBuild.toString() + record.nameJavaFile()   ) ) {
            fileWriter.write( record.sourceGenerated() );
        } catch (IOException e) {
            log.error("Generated Source Failed To Write: " + directoryBuild + record.nameJavaFile() );
        }

    }

}
