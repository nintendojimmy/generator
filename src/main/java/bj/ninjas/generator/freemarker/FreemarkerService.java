package bj.ninjas.generator.freemarker;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bj.ninjas.generator.freemarker.exception.FreemarkerTemplateProcessingException;
import bj.ninjas.generator.freemarker.exception.FreemarkerTemplateRetrievalException;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;

@Service
public class FreemarkerService {

    //The Configuraton version value will need to be updated as new versions come out
    final public Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

    public Optional<String> renderTemplate( 
        final String nameTemplate, 
        final HashMap<String,Object> dataTemplate 
    ) {
        
        try {
            final Template template = getTemplate( nameTemplate );
            final String templateRendered = processTemplate( template, dataTemplate );
            return Optional.of(templateRendered);           
        } catch ( final FreemarkerTemplateRetrievalException e ) {
            return Optional.ofNullable(null);
        } catch ( final FreemarkerTemplateProcessingException e ){
            return Optional.ofNullable(null);
        }

    }

    private Template getTemplate( 
        final String nameTemplate 
    ) throws FreemarkerTemplateRetrievalException {

        try {
            return this.configuration.getTemplate( nameTemplate );
        } catch ( final TemplateNotFoundException e ) {
            throw new FreemarkerTemplateRetrievalException( e );
        } catch ( final MalformedTemplateNameException e ) {
            throw new FreemarkerTemplateRetrievalException( e );
        } catch ( final ParseException e ) {
            throw new FreemarkerTemplateRetrievalException( e );
        } catch ( final IOException e ) {
            throw new FreemarkerTemplateRetrievalException( e );
        }

    }

    private String processTemplate( 
        final Template template, 
        final HashMap<String, Object> dataTemplate
    ) throws FreemarkerTemplateProcessingException {

        try {
            final StringWriter stringWriter = new StringWriter();
            template.process(dataTemplate, stringWriter);
            return stringWriter.toString();
        } catch ( final Exception e) {
            throw new FreemarkerTemplateProcessingException( e );
        }

    }

}
