package bj.ninjas.generator.batch.record;

import java.util.HashMap;

public record SourceGenerationRecord(
    String nameJavaFile,
    String nameTemplate,
    HashMap<String,Object> dataTemplate,
    String sourceGenerated
) {}
