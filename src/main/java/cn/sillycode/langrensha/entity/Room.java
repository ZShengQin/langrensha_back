package cn.sillycode.langrensha.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: langrensha
 * @description: ${description}
 * @author: zsq
 * @create: 2018-05-05 12-47
 */
@Entity
@Data
public class Room {
    @Id
    private Integer roomId;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_list")
    private Set<User> userList = new HashSet<User>();

    private String roleString;

    public Room(){}

    //房主创建房间
    public Room(Integer roomId, User roomCreator, String roleString) {
        this.roomId = roomId;
        this.userList.add(roomCreator);
        this.roleString = roleString;
    }

    //有人加入已经创建的房间
    public Room(Integer roomId, Set<User> userList){
        this.roomId = roomId;
        this.userList = userList;
    }
}
