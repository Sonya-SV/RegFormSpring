package com.training.regform.spring.config.service;

import com.training.regform.spring.config.entity.Note;
import com.training.regform.spring.config.repository.NoteRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> findNoteByTag(String tag) {
        return noteRepository.findByTag(tag);
    }

    public List<Note> findAllNotes() {
        return noteRepository.findAll();
    }

    public void saveNewNote(@NonNull Note note) {
        noteRepository.save(note);
    }

}
