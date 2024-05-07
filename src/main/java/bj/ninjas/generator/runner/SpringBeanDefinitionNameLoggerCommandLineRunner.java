package bj.ninjas.generator.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Profile("PrintSpringBeanNamesOnStartup")
@Configuration
public class SpringBeanDefinitionNameLoggerCommandLineRunner implements CommandLineRunner{

    final ApplicationContext contextApplication;

    public SpringBeanDefinitionNameLoggerCommandLineRunner(
        final ApplicationContext contextApplication
    ){
        this.contextApplication = contextApplication;
    }

    @Override
    public void run(String... args) throws Exception {
        String[] arrayBeanNames = this.contextApplication.getBeanDefinitionNames();
        for ( final String nameBean : arrayBeanNames ) {
            log.info("Bean Name: " + nameBean );
        }
    }

}
