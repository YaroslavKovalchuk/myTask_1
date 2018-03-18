package com.yaroslavkovalchuk.tasksombra.controller;

import com.yaroslavkovalchuk.tasksombra.dto.request.BooksRequest;
import com.yaroslavkovalchuk.tasksombra.dto.response.BooksResponse;
import com.yaroslavkovalchuk.tasksombra.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin
public class BooksController {

    @Autowired
    private BooksService booksService;

    @PostMapping
    public BooksResponse save(@RequestBody BooksRequest booksRequest){
        return booksService.save(booksRequest);
    }

    @GetMapping
    public List<BooksResponse> getAll(){
        return booksService.getAll();
    }

    @GetMapping("//{id}")
    public BooksResponse getOne(@PathVariable Long id){
    return booksService.getOne(id);
    }
    @PutMapping("//{id}")
    public BooksResponse update(@PathVariable Long id,@RequestBody BooksRequest boksRequest){
        return booksService.update(id,boksRequest);
    }
    @DeleteMapping("//{id}")
    public void delete(@PathVariable Long id){
        booksService.delete(id);
    }

    @GetMapping("//countByGenre")
    public Long countBooksByGenre(@RequestParam String genre){
        return booksService.countBooksByGenre(genre);
    }

    @GetMapping("//authorHasBooks")
    public List<BooksResponse> booksAuthorHasBooks(){
        return booksService.authorHasBooks();
    }

}
