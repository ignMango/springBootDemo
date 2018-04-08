package com.imango.demo.repositories;

import com.imango.demo.model.Editor;
import org.springframework.data.repository.CrudRepository;

public interface EditorRepository extends CrudRepository<Editor, Long> {
}
