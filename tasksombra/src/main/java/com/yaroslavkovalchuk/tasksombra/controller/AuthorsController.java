package com.yaroslavkovalchuk.tasksombra.controller;

import com.yaroslavkovalchuk.tasksombra.dto.request.AuthorRequest;
import com.yaroslavkovalchuk.tasksombra.dto.response.AuthorsResponse;
import com.yaroslavkovalchuk.tasksombra.service.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@CrossOrigin
public class AuthorsController {

    @Autowired
    private AuthorsService authorsService;

    @PostMapping
    public AuthorsResponse save(@RequestBody AuthorRequest authorRequest){
        return authorsService.save(authorRequest);
    }

    @PutMapping("//{id}")
    public AuthorsResponse update(@PathVariable Long id,@RequestBody AuthorRequest authorRequest){
        return authorsService.update(id,authorRequest);
    }

    @DeleteMapping("//{id}")
    public void delete(@PathVariable Long id){
        authorsService.delete(id);
    }

    @GetMapping
    public List<AuthorsResponse> getAll(){
        return authorsService.getAll();
    }

    @GetMapping("//{id}")
    public AuthorsResponse getOne(@PathVariable Long id){
        return authorsService.getOne(id);
    }

    @GetMapping("//maxBooks")
    public  AuthorsResponse getAuthorsByMaxBooks(){
        return authorsService.maxBooks();
    }

    @GetMapping("//getAuthorsOlderThen//{age}")
    public List<AuthorsResponse> authorsAge(@PathVariable Integer age) {
      return authorsService.getAuthorsOlderThen(age);
  }

}
