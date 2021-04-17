package simplecrud.mapper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import simplecrud.domain.Role;
import simplecrud.domain.User;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

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
        User user = userMapper.findById(10000003);
        System.out.println(user.toString());
    }

    @Test
    public void findByName() {
        User user = userMapper.findByName("蔡凌涵");
        System.out.println(user.toString());
    }

    @Test
    public void userList() {
        List list = userMapper.userList();
        System.out.println("记录数：" + list.size());
    }

    @Test
    public void deleteUser() {
        List list = userMapper.userList();
        System.out.println("删除前记录数：" + list.size());
        userMapper.deleteUser(10000003);
        list = userMapper.userList();
        System.out.println("删除后记录数：" + list.size());
    }
}