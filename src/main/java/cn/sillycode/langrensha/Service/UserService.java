package cn.sillycode.langrensha.Service;

import cn.sillycode.langrensha.entity.User;

import java.util.List;

/**
 * @program: langrensha
 * @description: ${description}
 * @author: zsq
 * @create: 2018-05-05 12-28
 */
public interface UserService {

    List<User> getAllUser();

    User findOne(String code);

    User save(User user);
}
