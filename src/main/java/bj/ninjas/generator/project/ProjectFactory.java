package bj.ninjas.generator.project;

import java.nio.file.Path;
import java.util.Objects;

import bj.ninjas.generator.AplicationGeneratorConfiguration;

interface ProjectFactory {

    String SPRING_CRON_PREFIX = "spring-cron-";
    String RESOURCE_CONFIGURATION_DIRECTORY = "src/";

    //Simple Factory Implementation
    static Project buildProject( final AplicationGeneratorConfiguration configuration ) throws ProjectTypeNotFoundException {
        final String nameApplication = configuration.getNameApplication();
        final String stringConfigurationDirectoryPath = RESOURCE_CONFIGURATION_DIRECTORY + configuration.getTypeApplication() + configuration.getNameApplication();
        final Path pathConfigurationDirectory = Path.of ( stringConfigurationDirectoryPath );
        final Project project;

        if( nameApplication.startsWith( SPRING_CRON_PREFIX ) ){
            project = new SpringCronProject( pathConfigurationDirectory );
        }else{
            project = null;
        }

        if( Objects.isNull(project) ){
            throw new ProjectTypeNotFoundException();
        }

        return project;
    }

}
