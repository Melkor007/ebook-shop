package edu.bjtu.sei.simplecrud.service;

import edu.bjtu.sei.simplecrud.domain.Book;
import edu.bjtu.sei.simplecrud.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookService {
    @Autowired
    private BookMapper bookMapper;
    public List<Book> booklist() {
        return bookMapper.bookList();
    }
}
