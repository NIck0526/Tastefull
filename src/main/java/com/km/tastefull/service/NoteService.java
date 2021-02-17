package com.km.tastefull.service;

import com.km.tastefull.domain.Note;
import com.km.tastefull.domain.Wine;
import com.km.tastefull.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public Long join(Note note) {
        noteRepository.save(note);
        return note.getId();
    }
}
