package com.bibek.open.api.controller;

import com.bibek.open.api.model.Book;
import com.bibek.open.api.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "This is used to fetch all the Books stored in Db")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
            description = "Fetched All the book From Db",
            content = {@Content(mediaType = "application/json")}
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Avaliable",
                    content = @Content
            )
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Book getAllBook(){
        return bookService.getAllBook();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createdBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book updateBook(@RequestBody Book book,@PathVariable Long id){
        return bookService.updateBook(id,book);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable Long id){
         bookService.deleteUser(id);
    }
}
