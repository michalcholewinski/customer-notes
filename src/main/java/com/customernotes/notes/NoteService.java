package com.customernotes.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public Note createNote(Note note, Long customerId) {
        return null;
    }

    public List<Note> getNotes() {
        return null;
    }

    public Note updateNote(Long noteId, Note note){
        return null;
    }

    public void deleteNote(Long id){

    }
}
