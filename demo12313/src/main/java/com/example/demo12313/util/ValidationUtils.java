package com.example.demo12313.util;

import com.example.demo12313.entity.BookEntity;

import javax.xml.bind.ValidationException;

public class ValidationUtils {
    public static void validateBook(BookEntity book) throws ValidationException{
        String bookTitle = book.getTitle();
        if(bookTitle == null || bookTitle.isBlank() || bookTitle.length() < 3 || bookTitle.length() > 35)
            throw new ValidationException("Название книги должно быть в приделах от 3 до 35 символов");
        String author = book.getAuthor();
        if(author == null || author.isBlank() || author.length() < 3 || author.length() > 15)
            throw new ValidationException("Имя автора должно быть в приделах от 4 до 15");
        String publishing = book.getPublishing();
        if (publishing == null || publishing.isBlank() || publishing.length() < 3 || publishing.length() > 30)
            throw new ValidationException("Название издательства должна быть от 3 до 30 символов");
        String kind = book.getKind();
        if (kind == null || kind.isBlank() || kind.length() < 3 || kind.length() > 30)
            throw new ValidationException("Жанр должен быть от 3 до 30 символов");
    }
}
