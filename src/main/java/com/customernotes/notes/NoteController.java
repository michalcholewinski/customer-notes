package com.customernotes.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteService service;

    @GetMapping
    public List<Note> getNotes() {
        return service.getNotes();
    }

    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return service.createNote(note);
    }

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable("id")Long id, @RequestBody Note note){
        return service.updateNote(id, note);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable("id")Long id){
        service.deleteNote(id);
    }
}
