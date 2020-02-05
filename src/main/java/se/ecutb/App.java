package se.ecutb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.ecutb.config.AppConfig;
import se.ecutb.data.PersonRepository;
import se.ecutb.model.Person;

import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PersonRepository repository = context.getBean(PersonRepository.class);


    }
}
