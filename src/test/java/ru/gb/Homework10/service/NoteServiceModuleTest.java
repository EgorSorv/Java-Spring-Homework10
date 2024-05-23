package ru.gb.Homework10.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.gb.Homework10.model.Note;
import ru.gb.Homework10.repository.NoteRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


// модульный тест
@ExtendWith(MockitoExtension.class)
public class NoteServiceModuleTest {
    @InjectMocks
    private NoteServiceImplement service;

    @Mock
    private NoteRepository repository;

    // Проверка поиска по ID
    @Test
    public void getNoteByIdTest() {
        //Блок предусловия//........................
        Note note1 = new Note();
        note1.setId(1L);
        note1.setTitle("Заметка 1");
        note1.setDescription("Тестовая заметка");

        Note note2 = new Note();
        note2.setId(2L);
        note2.setTitle("Заметка 2");
        note2.setDescription("Тестовая заметка");

        Note note3 = new Note();
        note3.setId(3L);
        note3.setTitle("Заметка 3");
        note3.setDescription("Тестовая заметка");

        Note note4 = new Note();
        note4.setId(4L);
        note4.setTitle("Заметка 4");
        note4.setDescription("Тестовая заметка");

        given(repository.findById(note2.getId())).willReturn(Optional.of(note2));
        //........................

        //Блок действия (вызова метода)//........................
        String noteName = service.getNoteById(2L).getTitle();
        //........................

        //Блок проверки действия//........................
        assertThat(noteName).isEqualTo("Заметка 2");
        //........................
    }
}
