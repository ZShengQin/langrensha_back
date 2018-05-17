package cn.sillycode.langrensha.Service.impl;

import cn.sillycode.langrensha.Service.FeedbackService;
import cn.sillycode.langrensha.entity.Feedback;
import cn.sillycode.langrensha.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: langrensha
 * @description: ${description}
 * @author: zsq
 * @create: 2018-05-17 12-29
 */
@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    FeedbackRepository feedbackRepository;

    @Override
    public Boolean save(Feedback feedback) {
        if(feedbackRepository.save(feedback) != null) {
            return true;
        }
        return false;
    }
}
