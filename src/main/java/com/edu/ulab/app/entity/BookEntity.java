package com.edu.ulab.app.entity;

import com.edu.ulab.app.dto.BookDto;
import lombok.Data;

@Data
public class BookEntity {
    private String title;
    private String author;
    private long pageCount;

    public BookDto bookEntityToBookDto(BookEntity bookEntity) {
        if ( bookEntity == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        bookDto.setTitle( bookDto.getTitle() );
        bookDto.setAuthor( bookDto.getAuthor() );
        bookDto.setPageCount( bookDto.getPageCount() );

        return bookDto;
    }

    public BookEntity bookDtoToBookEntity(BookDto bookDto) {
        if ( bookDto == null ) {
            return null;
        }

        BookEntity bookEntity = new BookEntity();

        bookEntity.setTitle( bookDto.getTitle() );
        bookEntity.setAuthor( bookDto.getAuthor() );
        bookEntity.setPageCount( bookDto.getPageCount() );

        return bookEntity;
    }
}
