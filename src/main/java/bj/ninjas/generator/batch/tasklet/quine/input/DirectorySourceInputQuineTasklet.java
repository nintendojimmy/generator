package bj.ninjas.generator.batch.tasklet.quine.input;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DirectorySourceInputQuineTasklet extends SourceInputQuineTasklet{

    @Override
    public RepeatStatus execute(
        final StepContribution contribution, 
        final ChunkContext chunkContext
    ) throws Exception {
        log.info("DirectorySourceInputQuineTasklet START");

        final Path pathParentDirectory = Paths.get("").toAbsolutePath().getParent();
        log.info("Path Parent Directory: " + pathParentDirectory.toString() );

        final Path pathSelfDirectory = Paths.get("").toAbsolutePath();
        log.info("Path Self Directory: " + pathSelfDirectory.toString() );

        final String stringSelfDirectoryName = pathSelfDirectory.getFileName().toString();
        log.info("Self Directory name: " + stringSelfDirectoryName );

        final String[] arraySelfDirectoryNameStrings = stringSelfDirectoryName.split("-",2);
        final String stringSelfDirectoryNameRoot = arraySelfDirectoryNameStrings[0];
        log.info("" + stringSelfDirectoryNameRoot);
        final String stringSelfDirectoryNameVersion = arraySelfDirectoryNameStrings[1];
        log.info("" + stringSelfDirectoryNameVersion);
        
        final String stringChildDirectoryNameVersion = String.valueOf( Integer.valueOf( stringSelfDirectoryNameVersion ) + 1 );
        final String stringChildDirectoryName = stringSelfDirectoryNameRoot + "-" + stringChildDirectoryNameVersion;
        log.info("" + stringChildDirectoryName);

        final Path pathChildDirectory = pathParentDirectory.resolve(stringChildDirectoryName);
        pathChildDirectory.toFile().mkdir();
        log.info("" + pathChildDirectory.toString() );

        final Process process = new ProcessBuilder("java", "--version").start();
        
        List<String> results;
        try ( final InputStream inputStream = process.getInputStream(); ) {
            results =  new BufferedReader( new InputStreamReader(inputStream, StandardCharsets.UTF_8) ).lines().toList();
        } catch (Exception e) {
            log.info("Exception");
            results = null;    
        }
        
        //final List<String> = new InputStreamReader(inputStream);
        log.info("Results:" + results.size());
        results.stream().forEach( result -> log.info("Result: " + result ));
        
        int exitCode = process.waitFor();
        log.info("Exit Code: " + exitCode );

        log.info("DirectorySourceInputQuineTasklet FINISHED");
        return RepeatStatus.FINISHED;
    }

}
