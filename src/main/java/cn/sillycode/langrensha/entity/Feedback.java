package cn.sillycode.langrensha.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @program: langrensha
 * @description: ${description}
 * @author: zsq
 * @create: 2018-05-17 12-18
 */
@Entity
@Data
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String phone;

    private String content;
}
