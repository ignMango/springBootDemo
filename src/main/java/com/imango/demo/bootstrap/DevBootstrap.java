package com.imango.demo.bootstrap;

import com.imango.demo.model.Autor;
import com.imango.demo.model.Libro;
import com.imango.demo.repositories.AutorRepository;
import com.imango.demo.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private AutorRepository autorRepository;
    private LibroRepository libroRepository;

    @Autowired
    public DevBootstrap(AutorRepository autorRepository, LibroRepository libroRepository) {
        this.autorRepository = autorRepository;
        this.libroRepository = libroRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.initData();
    }

    private void initData() {
        Autor eric = new Autor("Eric", "Evans");
        Libro libro = new Libro("Domain Driven Design", "1234", "Harper Collins");
        eric.getLibros().add(libro);
        libro.getAutores().add(eric);

        autorRepository.save(eric);
        libroRepository.save(libro);

        Autor rod = new Autor("Rod", "Jhonson");
        Libro otherBook = new Libro("J2EE Development", "12344", "Worx");
        rod.getLibros().add(otherBook);

        autorRepository.save(rod);
        libroRepository.save(otherBook);

    }
}
