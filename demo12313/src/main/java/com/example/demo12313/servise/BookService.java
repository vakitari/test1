package com.example.demo12313.servise;


import com.example.demo12313.entity.BookEntity;
import com.example.demo12313.repo.BookRepo;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepo repo;

    public BookService(BookRepo repo) {
        this.repo = repo;
    }

    public void save(BookEntity book){ repo.save(book); }
    public void delete(Long id){ repo.deleteById(id); }
    public Iterable<BookEntity> getAll(){ return  repo.findAll(); }
}
