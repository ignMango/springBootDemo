package com.imango.demo.repositories;

import com.imango.demo.model.Libro;
import org.springframework.data.repository.CrudRepository;

public interface LibroRepository extends CrudRepository<Libro, Long>{
}
