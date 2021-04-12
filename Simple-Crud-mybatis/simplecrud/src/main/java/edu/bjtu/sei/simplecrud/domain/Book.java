package edu.bjtu.sei.simplecrud.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Validated
@Getter
@Setter
public class Book {

    private int book_id;
    private String book_name;
    private String book_author;
    private double book_price;

    public Book(int book_id,String book_name,String book_author, double book_price) {
        this.book_id= book_id;
        this.book_name = book_name;
        this.book_author = book_author;
        this.book_price = book_price;
    }

    public int getId() {
        return book_id;
    }

    public String getName() {
        return book_name;
    }

    public String getAuthor() {
        return book_author;
    }



    @Override
    public String toString() {
        return "Role{" +
                "id=" + book_id +
                ", name='" + book_name +
                ", book_author='" + book_author +
                ", price='" + book_price +
                '\'' +
                '}';
    }
}
