package bj.ninjas.generator.project;

import java.nio.file.Path;

final class Constants {

    // Default Values
    static final String DEFAULT_PROJECT_NAME = "DEFAULT_PROJECT_NAME";

    // Default_File Names
    static String BATCH_CONFIGURATION_FILE_NAME = "spring-batch-configuration.yml";

    // Paths
    static final Path RESOURCES_DIRECTORY_PATH = Path.of("src/main/resources");
    static final Path CONFIGURATION_DIRECTORY_PATH = Path.of("src/main/resources/configuration");
    static final Path SPRING_BATCH_CONFIGURATION_DIRECTORY_PATH = Path.of("src/main/resources/configuration/batch");

    static final Path BATCH_CONFIGURATION_YAML_PATH = Path.of("src/main/resources/configuration/batch/spring-batch-configuration.yml");

    static final Path SPRING_MVC_CONFIGURATION_DIRECTORY_PATH = Path.of("src/main/resources/configuration");

    // Default Paths
    static final Path DEFAULT_PROJECT_CONFIGURATION_PATH = Path.of("src/main/resources/configuration");

    // Template Data keys
    static final String PROJECT_NAME = "PROJECT_NAME";


}
