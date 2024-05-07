package bj.ninjas.generator.project;

import java.util.List;

import bj.ninjas.generator.AplicationGeneratorConfiguration;
import bj.ninjas.generator.batch.record.SourceGenerationRecord;

public interface Project {

    static Project buildProject( AplicationGeneratorConfiguration configuration ) {
        return ProjectFactory.buildProject( configuration );
    }

    List<SourceGenerationRecord> buildSourceGenerationRecords();

}
