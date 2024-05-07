package bj.ninjas.generator.batch.chunk;

import java.util.Iterator;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import bj.ninjas.generator.batch.record.SourceGenerationRecord;
import lombok.Builder;

@Builder
public class SourceGenerationRecordItemReader implements ItemReader<SourceGenerationRecord>{
    final Iterator<SourceGenerationRecord> iterator;

    @Override
    public SourceGenerationRecord read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return iterator.hasNext() ? iterator.next() : null; 
    }

}
