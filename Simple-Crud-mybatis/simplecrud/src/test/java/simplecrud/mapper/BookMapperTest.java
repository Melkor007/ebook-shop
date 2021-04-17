package simplecrud.mapper;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import simplecrud.domain.Book;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Before
    public void setUp() throws Exception {
        System.out.println("@Before");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("@After");
    }

    @Test
    public void findById() {
        Book book = bookMapper.findById(2);
        System.out.println(book.toString());
    }

    @Test
    public void delete() {
        List list = bookMapper.bookList();
        System.out.println("删除前记录数：" + list.size());
        bookMapper.delete(4);
        list = bookMapper.bookList();
        System.out.println("删除后记录数：" + list.size());

    }

    @Test
    public void update() {
        bookMapper.update(1,9.9);
        Book book = bookMapper.findById(1);
        System.out.println(book.toString());
    }

    @Test
    public void bookList() {
        List list = bookMapper.bookList();
        System.out.println("记录总数：" + list.size());
    }
}