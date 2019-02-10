package com.controller;

import com.domain.Notebook;
import com.repository.NotebookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private NotebookRepository notebookRepository;

    @GetMapping("/")
    public String notebook(Map<String, Object> model){
        Iterable<Notebook> notebooks = notebookRepository.findAll();
        model.put("notes", notebooks);
        return "notebook";
    }

    @PostMapping("/")
    public String add(
            @RequestParam String tag,
            @RequestParam String text,
            Map<String, Object> model
    ) {
        Notebook notebook = new Notebook(tag, text);

        notebookRepository.save(notebook);

        Iterable<Notebook> notebooks = notebookRepository.findAll();
        model.put("notes", notebooks);

        return "notebook";
    }

    @PostMapping("filter")
    public String filter(
            @RequestParam String filter,
            Map<String, Object> model
    ) {
       Iterable<Notebook> notebooks;

       if(filter !=null && !filter.isEmpty()){
           notebooks = notebookRepository.findByTag(filter);
       } else {
           notebooks = notebookRepository.findAll();
       }

       model.put("notes", notebooks);

       return "notebook";
    }
}
