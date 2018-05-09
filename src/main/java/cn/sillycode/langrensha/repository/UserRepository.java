package cn.sillycode.langrensha.repository;

import cn.sillycode.langrensha.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: langrensha
 * @description: ${description}
 * @author: zsq
 * @create: 2018-05-05 12-10
 */
public interface UserRepository extends JpaRepository<User, String> {
}
