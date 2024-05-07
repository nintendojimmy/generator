package bj.ninjas.generator.freemarker.exception;

import java.io.IOException;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateNotFoundException;

public class FreemarkerTemplateRetrievalException extends Exception{

    public FreemarkerTemplateRetrievalException( final TemplateNotFoundException e ) {
        super( e );
    }

    public FreemarkerTemplateRetrievalException( final MalformedTemplateNameException e) {
        super( e );
    }

    public FreemarkerTemplateRetrievalException( final ParseException e) {
        super( e );
    }

    public FreemarkerTemplateRetrievalException( final IOException e) {
        super( e );
    }

}
