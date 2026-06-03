package com.secure.notes.service;

import com.secure.notes.entity.Note;

import java.util.List;

public interface NoteService {

    Note createNoteForUser(String username, String content);

    Note updateNoteForUser(Long noteId, String username, String newContent);

    void deleteNoteForUser(Long noteId, String username);

    List<Note> getNotesForUser(String username);

}
