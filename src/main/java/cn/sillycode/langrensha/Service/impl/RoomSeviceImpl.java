package cn.sillycode.langrensha.Service.impl;

import cn.sillycode.langrensha.Service.RoomService;
import cn.sillycode.langrensha.entity.Room;
import cn.sillycode.langrensha.entity.User;
import cn.sillycode.langrensha.repository.RoomRepository;
import cn.sillycode.langrensha.repository.UserRepository;
import cn.sillycode.langrensha.utility.HttpUtil;
import cn.sillycode.langrensha.utility.RoomUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @program: langrensha
 * @description: ${description}
 * @author: zsq
 * @create: 2018-05-06 19-02
 */
@Service
public class RoomSeviceImpl implements RoomService{

    @Autowired
    RoomRepository roomRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    HttpUtil httpClientService;

    /**
     *
     * @param user 传递一个游戏房间创建者的User对象
     * @param roleString 用于分配角色的字符串
     * @return 生成roomId后返回Room对象
     */
    @Override
    public Room createRoom(User user, String roleString) {

        String appid = "wx52e0d1182420144d";
        String appsecret = "65ff4d537bdaab8f485775f74f58a675";
        String grant_type = "authorization_code";
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        String params = "appid=" + appid + "&secret=" + appsecret +
                "&js_code=" + user.getCode() + "&grant_type=" + grant_type;
        System.out.println("openid = " + HttpUtil.client(requestUrl, params));

        userRepository.save(user);
        Integer roomId = RoomUtility.genRoomId();
        Room room = new Room(roomId, user, roleString);
        roomRepository.save(room);
        return room;
    }

    /**
     *
     * @param roomId: 通过roomId查找已经创建的房间
     * @param user: 将user加入房间号所属的Room
     * @return 返回加入了user的Room对象
     */
    @Override
    public Room joinRoom(Integer roomId, User user) {

        //存在输入的房间号
        Room room = roomRepository.findOne(roomId);
        Set<User> userList = room.getUserList();

        //该用户已经加入当前房间
        if(userList.contains(user)){
            return room;
        }
        userRepository.save(user);
        userList.add(user);
        room.setNumCurrent(room.getNumCurrent() + 1);
        roomRepository.save(room);
        return room;
    }

    /**
     * 创建者离开创建页面，房间销毁
     * @param roomId 需要销毁的房间id
     * @return 是否销毁成功
     */
    @Override
    public Boolean deleteRoom(Integer roomId) {
        //房间号不存在
        if(roomRepository.findOne(roomId) == null) {
            return false;
        }
        roomRepository.delete(roomId);
        return true;
    }

    @Override
    public Boolean findone(Integer roomId) {
        if(roomRepository.findOne(roomId) == null){
            return false;
        }
        return true;
    }
}
