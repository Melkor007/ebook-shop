package simplecrud.service;

import simplecrud.domain.Book;
import simplecrud.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookService {
    @Autowired
    private BookMapper bookMapper;
    public List<Book> booklist() {
        return bookMapper.bookList();
    }
}
