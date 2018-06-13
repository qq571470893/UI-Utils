package site.lyun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.lyun.dao.UserMapper;
import site.lyun.pojo.User;

import java.util.List;


@Transactional
@Service
public class UserService {

    @Autowired
    public UserMapper userMapper;

    public List<User> findAll(){
        return userMapper.findAll();
    }
}
