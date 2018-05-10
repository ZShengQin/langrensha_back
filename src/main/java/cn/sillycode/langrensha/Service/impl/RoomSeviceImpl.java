package cn.sillycode.langrensha.Service.impl;

import cn.sillycode.langrensha.Service.RoomService;
import cn.sillycode.langrensha.entity.Room;
import cn.sillycode.langrensha.entity.User;
import cn.sillycode.langrensha.repository.RoomRepository;
import cn.sillycode.langrensha.repository.UserRepository;
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

    /**
     *
     * @param user : 传递一个游戏房间创建者的User对象
     * @param roleString
     * @return: 生成roomId后返回Room对象
     */
    @Override
    public Room createRoom(User user, String roleString) {
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
     * @return: 返回加入了user的Room对象
     */
    @Override
    public Room joinRoom(Integer roomId, User user) {
        //输入房间号有误,返回roomId为null
        if(roomRepository.findOne(roomId) == null){
            return new Room();
        }

        //存在输入的房间号
        userRepository.save(user);
        Room room = roomRepository.findOne(roomId);
        room.getUserList().add(user);
        room.setNumCurrent(room.getNumCurrent() + 1);
        roomRepository.save(room);
        return room;
    }

    /**
     * 创建者离开创建页面，房间销毁
     * @param roomId
     * @return
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
}
