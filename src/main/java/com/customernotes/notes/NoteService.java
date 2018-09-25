package com.customernotes.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public Note createNote(Note note) {
        Optional<CustomerEntity> customer = customerRepository.findById(note.getCustomerId());
        //it could be done better, normally recommended would be throwing an exception
        if (customer.isPresent()) {
            NoteEntity entity = new NoteEntity();
            entity.setTitle(note.getTitle());
            entity.setArrangements(note.getArrangements());
            entity.setCustomer(customer.orElse(null));
            entity.setPrivateNote(note.getPrivateNote());
            entity.setCreatedDate(ZonedDateTime.now());
            NoteEntity save = noteRepository.save(entity);
            Note createdNote = mapToNote(save);
            return createdNote;
        }
        return null;
    }

    public List<Note> getNotes() {
        List<Note> notes = new ArrayList<>();
        noteRepository.findAll().forEach(noteEntity -> notes.add(mapToNote(noteEntity)));
        return notes;
    }

    public Note updateNote(Long noteId, Note note) {
        Optional<NoteEntity> noteEntity = noteRepository.findById(noteId);
        if (noteEntity.isPresent()) {
            NoteEntity noteEntityToUpdate = noteEntity.orElse(null);//this is not recommended, but for now it's enough, we will fix it next time
            noteEntityToUpdate.setPrivateNote(note.getPrivateNote());
            noteEntityToUpdate.setArrangements(note.getArrangements());
            noteEntityToUpdate.setTitle(note.getTitle());
            return mapToNote(noteRepository.save(noteEntityToUpdate));
        }
        return null;
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);

    }

    private Note mapToNote(NoteEntity entity) {
        Note createdNote = new Note();
        createdNote.setId(entity.getId());
        createdNote.setArrangements(entity.getArrangements());
        createdNote.setTitle(entity.getTitle());
        createdNote.setPrivateNote(entity.getPrivateNote());
        createdNote.setCustomerId(entity.getCustomer().getId());
        return createdNote;
    }
}
