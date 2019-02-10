package com.repository;

import com.domain.Notebook;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NotebookRepository extends CrudRepository<Notebook, Long> {

    List<Notebook> findByTag(String tag);
}
