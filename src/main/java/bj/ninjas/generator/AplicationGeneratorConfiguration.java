package bj.ninjas.generator;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import jakarta.validation.Path;
import lombok.Data;

//TODO: Migrate to record when record works with configuration properies
@Data
@Configuration
@ConfigurationProperties( prefix = "generator" )
public class AplicationGeneratorConfiguration{
    String nameApplication;
    String typeApplication;
    Path directoryBuild;
}
