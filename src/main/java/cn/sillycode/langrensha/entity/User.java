package cn.sillycode.langrensha.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: langrensha
 * @description: ${description}
 * @author: zsq
 * @create: 2018-05-05 00-27
 */
@Entity
@Data
public class User {
    @Id
    private String code;

    private String name;

    private String avatarUrl;

    public User(){}

    public User(String code, String name, String avatarUrl) {
        this.code = code;
        this.name = name;
        this.avatarUrl = avatarUrl;
    }
}
