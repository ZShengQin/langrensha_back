package cn.sillycode.langrensha.Service.impl;

import cn.sillycode.langrensha.Service.UserService;
import cn.sillycode.langrensha.entity.User;
import cn.sillycode.langrensha.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: langrensha
 * @description: ${description}
 * @author: zsq
 * @create: 2018-05-05 12-22
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    @Override
    public User findOne(String code) {
        return userRepository.findOne(code);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
