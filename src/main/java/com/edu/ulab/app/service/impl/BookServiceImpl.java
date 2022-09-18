package com.edu.ulab.app.service.impl;

import com.edu.ulab.app.dto.BookDto;
import com.edu.ulab.app.entity.BookEntity;
import com.edu.ulab.app.service.BookService;
import com.edu.ulab.app.storage.Storage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.edu.ulab.app.storage.Storage.addBook;

@Slf4j
@Service
public class BookServiceImpl implements BookService {
    private static long id = 0L;

    @Override
    public BookDto createBook(BookDto bookDto) {
        id++;

        BookEntity bookEntity = new BookEntity();
        bookEntity.bookDtoToBookEntity(bookDto);
        addBook(id, bookDto.getUserId(), bookEntity);

        bookDto.setId(id);

        return bookDto;
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.bookDtoToBookEntity(bookDto);
        return bookEntity.bookEntityToBookDto(Storage.updateBook(bookDto.getId(), bookEntity));
    }

    @Override
    public BookDto getBookById(Long id) {
        BookEntity bookEntity = new BookEntity();
        return bookEntity.bookEntityToBookDto(Storage.getBookById(id));

    }

    @Override
    public void deleteBookById(Long id) {
        Storage.deleteBookById(id);
    }

    public List<Long> getBooksOfUser(Long userId) {
        return Storage.getBooksIdOfUser(userId);
    }
}