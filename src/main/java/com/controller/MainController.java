package com.controller;

import com.domain.Notebook;
import com.repository.NotebookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
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

    /**
     * Adds new note with creation date and id
     *
     * @param tag - tag of note
     * @param text - text of note
     *
     * @return 'notebook.mustache'
     * */
    @PostMapping("add")
    public String add(
            @RequestParam String tag,
            @RequestParam String text,
            Map<String, Object> model
    ) {
        Date date = new Date();
        Notebook notebook = new Notebook(tag, text, date);

        notebookRepository.save(notebook);

        Iterable<Notebook> notebooks = notebookRepository.findAll();
        model.put("notes", notebooks);

        return "notebook";
    }

    /**
     * Shows notes with specified tag
     *
     * @param filter - specified tag
     *
     * If filter is empty shows all list of notes
     * If filter is not empty but note with such tag does not exist shows nothing
     **/
    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Notebook> notes;

        if(filter !=null && !filter.isEmpty()){
            notes = notebookRepository.findByTag(filter);
        } else {
            notes = notebookRepository.findAll();
        }

        model.put("notes", notes);

        return "notebook";
    }

    /**
     * Removes note with specified id
     *
     * @param id - specified id
     *
     * If 'id' parameter is empty or note with such id does not exist then method
     * does nothing but shows full list of notes
     * */
    @PostMapping("remove")
    public String remove(@RequestParam String id, Map<String, Object> model){

        int i;

        try{
            i = Integer.parseInt(id);
        } catch (Exception e){
            i = 0;
        }

        Notebook note = notebookRepository.findById(i);
        Iterable<Notebook> notes;

        if(note!=null && !note.toString().isEmpty()){
            notebookRepository.delete(note);
            notes = notebookRepository.findAll();
        } else {
            notes = notebookRepository.findAll();
        }

        model.put("notes", notes);
        return "notebook";
    }
}
