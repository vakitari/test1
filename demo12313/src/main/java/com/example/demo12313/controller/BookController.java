package com.example.demo12313.controller;


import com.example.demo12313.entity.BookEntity;
import com.example.demo12313.response.BaseResponse;
import com.example.demo12313.response.BookListResponse;
import com.example.demo12313.servise.BookService;
import com.example.demo12313.util.ValidationUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.executable.ValidateOnExecution;

@RestController
@RequestMapping("api/v1/book")
public class BookController {
    private BookService service;
    private BookController(BookService service){ this.service = service; }

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll(){
        return ResponseEntity.ok(new BookListResponse(service.getAll()));
    }
    @ValidateOnExecution
    @PostMapping("/add")
    public ResponseEntity <BaseResponse> registration (@RequestBody BookEntity data){
        try {
            ValidationUtils.validateBook(data);
            service.save(data);
            return  ResponseEntity.ok(new BaseResponse(true, "Книга добавлена"));
        } catch (Exception e) {
            return  ResponseEntity. badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }
    @PostMapping("/update")
    public ResponseEntity <BaseResponse> update(@RequestBody BookEntity data){
        try {
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "В книгу внесене изменения"));
        } catch (Exception e) {
            return ResponseEntity. badRequest().body(new BaseResponse(false,e.getMessage()));
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity <BaseResponse> delete(@RequestParam Long id){
        try {
            service.delete(id);
            return ResponseEntity.ok(new BaseResponse(true, "Книга успешно удалена"));
        } catch (Exception e) {
            return ResponseEntity. badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }
}
