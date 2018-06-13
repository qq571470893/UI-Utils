package site.lyun.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import site.lyun.dao.UserMapper;
import site.lyun.pojo.User;

import java.util.List;

public class MapperTest {

    @Test
    public void fun1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:applicationContext-*.xml");
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);
        List<User> list = userMapper.findAll();
        System.out.println(list.toString());
    }
}
