package cn.sillycode.langrensha.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @program: langrensha
 * @description: ${description}
 * @author: zsq
 * @create: 2018-05-16 00-17
 */
@Entity
@Data
public class UserInfo {

    @Id
    private String openid;

    private String sessionKey;
}
