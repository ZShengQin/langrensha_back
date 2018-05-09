package cn.sillycode.langrensha.controller;

import cn.sillycode.langrensha.Service.UserService;
import cn.sillycode.langrensha.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: langrensha
 * @description: ${description}
 * @author: zsq
 * @create: 2018-05-05 12-04
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;


}
