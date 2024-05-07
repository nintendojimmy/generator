package bj.ninjas.generator.project;

import java.nio.file.Path;
import java.util.List;

import bj.ninjas.generator.batch.record.SourceGenerationRecord;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
final class SpringCronProject extends AbstractSpringProject {
    final Path directoryConfiguration;

    @Override
    protected SourceGenerationRecord buildMainClassSourceGenerationRecord() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buildMainClassSourceGenerationRecord'");
    }

    @Override
    protected List<SourceGenerationRecord> buildSpringContextSourceGenerationRecords() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buildSpringContextSourceGenerationRecords'");
    }

}
