package cn.sillycode.langrensha.controller;

import cn.sillycode.langrensha.Service.FeedbackService;
import cn.sillycode.langrensha.entity.Feedback;
import cn.sillycode.langrensha.entity.Result;
import cn.sillycode.langrensha.utility.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: langrensha
 * @description: ${description}
 * @author: zsq
 * @create: 2018-05-17 12-19
 */
@RestController
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;

    @PostMapping(value = "/feedback")
    public Result getFeedback(@RequestParam("phone") String phone,
                               @RequestParam("content") String content){
        Feedback feedback = new Feedback();
        feedback.setPhone(phone);
        feedback.setContent(content);
        if(feedbackService.save(feedback)){
            return ResultUtil.success(feedback);
        }
        return ResultUtil.error(feedback);
    }

}
