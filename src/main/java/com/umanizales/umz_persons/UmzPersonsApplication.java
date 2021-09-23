package com.umanizales.umz_persons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class UmzPersonsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UmzPersonsApplication.class, args);
    }


    /*BEAN: clase java con atributos encapsulados a nivel de setters y getters
    tienen un constructor vacio,
    tambien tiene logica de aplicacion*/

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();

        //de la base de microservicio que nombre vaa buscar en los archivos que empiecen por messages
        messageSource.setBasename("classpath:messages");

        //UTF-8 para que resista caracteres especiales
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    //se inyecta a la aplicacion el Bean de arriba que es el que carga los mensajes
    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();

        //para mensajes de validacion que use el bean de arriba
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
}
