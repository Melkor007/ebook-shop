package simplecrud.service;

import org.springframework.stereotype.Service;
import simplecrud.domain.Book;
import simplecrud.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;
    public List<Book> bookList() {
        return bookMapper.bookList();
    }
}
