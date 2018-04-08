package com.imango.demo.bootstrap;

import com.imango.demo.model.Autor;
import com.imango.demo.model.Editor;
import com.imango.demo.model.Libro;
import com.imango.demo.repositories.AutorRepository;
import com.imango.demo.repositories.EditorRepository;
import com.imango.demo.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private AutorRepository autorRepository;
    private LibroRepository libroRepository;
    private EditorRepository editorRepository;

    @Autowired
    public DevBootstrap(AutorRepository autorRepository, LibroRepository libroRepository, EditorRepository editorRepository) {
        this.autorRepository = autorRepository;
        this.libroRepository = libroRepository;
        this.editorRepository = editorRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.initData();
    }

    private void initData() {
        Editor editor = new Editor("Harper Collins", "123 abc");
        Editor editor2 = new Editor("Worx", "456 def");

        editorRepository.save(editor);
        editorRepository.save(editor2);

        Autor eric = new Autor("Eric", "Evans");
        Libro libro = new Libro("Domain Driven Design", "1234", editor);
        eric.getLibros().add(libro);
        libro.getAutores().add(eric);

        autorRepository.save(eric);
        libroRepository.save(libro);

        Autor rod = new Autor("Rod", "Jhonson");
        Libro otherBook = new Libro("J2EE Development", "12344", editor2);
        rod.getLibros().add(otherBook);

        autorRepository.save(rod);
        libroRepository.save(otherBook);

    }
}
