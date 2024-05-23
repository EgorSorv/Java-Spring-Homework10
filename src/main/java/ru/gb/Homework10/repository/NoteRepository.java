package ru.gb.Homework10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.Homework10.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
