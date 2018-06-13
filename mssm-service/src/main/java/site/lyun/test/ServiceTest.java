package site.lyun.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import site.lyun.dao.UserMapper;
import site.lyun.pojo.User;
import site.lyun.service.UserService;

import java.util.List;

public class ServiceTest {

    @Test
    public void fun1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:applicationContext-*.xml");
        UserService userService = applicationContext.getBean(UserService.class);
        List<User> list = userService.findAll();
        System.out.println(list);
    }
}
