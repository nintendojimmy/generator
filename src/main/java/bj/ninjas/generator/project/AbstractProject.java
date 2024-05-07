package bj.ninjas.generator.project;

import java.util.ArrayList;
import java.util.List;

import bj.ninjas.generator.batch.record.SourceGenerationRecord;

abstract class AbstractSpringProject implements Project{

    @Override
    public List<SourceGenerationRecord> buildSourceGenerationRecords() {
        final List<SourceGenerationRecord> records = new ArrayList<>();
        records.add( buildMainClassSourceGenerationRecord() );
        records.addAll( buildSpringContextSourceGenerationRecords() );
        return records;
    }

    protected abstract SourceGenerationRecord buildMainClassSourceGenerationRecord();
    
    protected abstract List<SourceGenerationRecord> buildSpringContextSourceGenerationRecords();

}
