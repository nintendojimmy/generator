package bj.ninjas.generator.project;

import jakarta.validation.constraints.NotBlank;

public record ProjectConfigurationMetaData (
    //Name corresponds to the directory in the configuraton
    @NotBlank
    String name,
    boolean isSpringBootApplication,
    boolean isSpringBatchConfigurationPresent,
    int numberSpringBatchJobConfigurations,
    boolean isSpringMvcConfigurationPresent,
    int numberSpringMvcControllerConfigurations,
    boolean isSpringWebFluxConfigurationPresent,
    boolean isSpringWebFluxRouterConfigurationPresent,
    boolean isSpringShellConfiguratonPresent,
    int numberSpringShellCommmandConfigurationsPresent
){}
