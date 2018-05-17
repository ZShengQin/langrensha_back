package cn.sillycode.langrensha.Service;

import cn.sillycode.langrensha.entity.Room;
import cn.sillycode.langrensha.entity.User;

/**
 * @program: langrensha
 * @description: ${description}
 * @author: zsq
 * @create: 2018-05-06 19-00
 */
public interface RoomService {

    Room createRoom(User user, String roleString);

    Room joinRoom(Integer roomId, User user);

    Boolean deleteRoom(Integer roomId);

    Boolean findone(Integer roomId);
}
