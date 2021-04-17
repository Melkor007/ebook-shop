package simplecrud.mapper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class OrderMapperTest {
    @Autowired
    private OrderMapper orderMapper;

    @Before
    public void setUp() throws Exception {
        System.out.println("@Before");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("@After");
    }

    @Test
    public void insert() {
        List list = orderMapper.orderList(10000003);
        System.out.println("插入前记录数：" + list.size());
        orderMapper.insert(10000003,1,"三国演义",20);
        list = orderMapper.orderList(10000003);
        System.out.println("插入后记录数：" + list.size());
    }

    @Test
    public void delete() {
        List list = orderMapper.orderList(10000000);
        System.out.println("删除前记录数：" + list.size());
        orderMapper.delete(3);
        list = orderMapper.orderList(10000000 );
        System.out.println("删除后记录数：" + list.size());
    }

    @Test
    public void orderList() {
        List list = orderMapper.orderList(10000003);
        System.out.println("记录总数：" + list.size());
    }
}