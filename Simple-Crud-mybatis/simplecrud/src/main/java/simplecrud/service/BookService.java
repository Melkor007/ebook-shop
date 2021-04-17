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

    public void update(int book_id, double price){bookMapper.update(book_id,price);};

    public void delete(int book_id){
        bookMapper.delete(book_id);
    }
}
