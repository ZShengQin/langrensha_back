package cn.sillycode.langrensha.repository;

import cn.sillycode.langrensha.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: langrensha
 * @description: ${description}
 * @author: zsq
 * @create: 2018-05-17 12-26
 */
public interface FeedbackRepository extends JpaRepository<Feedback, String> {
}
