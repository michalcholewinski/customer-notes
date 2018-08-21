package com.customernotes.notes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @GetMapping
    public List<Note> getNotes() {
        return getFakeNotes();
    }

    private List<Note> getFakeNotes() {
        List<Note> notes = new ArrayList<>();
        notes.add(createFakeNote(1L, "No arrangements", "Customer had funny tie", "Final negotiation"));
        notes.add(createFakeNote(2L, "Arrangements 1", "Boring meeting", "Initial negotiation"));
        notes.add(createFakeNote(3L, "Any other arrangements", "Nice office with big window with view to Warsaw", "Conversation about future contract"));
        return notes;
    }

    private Note createFakeNote(long id, String arrangements, String privateNote, String title) {
        Note note = new Note();
        note.setId(id);
        note.setArrangements(arrangements);
        note.setPrivateNote(privateNote);
        note.setTitle(title);
        return note;
    }
}
