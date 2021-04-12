package edu.bjtu.sei.simplecrud.domain;

import java.io.Serializable;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
//import org.hibernate.annotations.Cache;
//import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.validation.annotation.Validated;

@Validated
@Getter
@Setter
public class Order implements Serializable {

    private static final long serialVersionUID = 4048798961366546485L;

    @NotBlank
    private int order_id;
    
    //@Pattern(regexp ="^(0[0-9]{2,3}/-)?([2-9][0-9]{6,7})+(/-[0-9]{1,4})?$", message = "Phone number")
    private int user_id;

    private int book_id;

    private double user_price;

    public void setOrder(int order_id, int user_id, int book_id,  double user_price) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.book_id = book_id;
        this.user_price = user_price;
    }
}
