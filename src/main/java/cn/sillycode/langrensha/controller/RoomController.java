package cn.sillycode.langrensha.controller;

import cn.sillycode.langrensha.Service.RoomService;
import cn.sillycode.langrensha.entity.Room;
import cn.sillycode.langrensha.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: langrensha
 * @description: 提供给前端的接口
 * @author: zsq
 * @create: 2018-05-06 18-58
 */
@RestController
public class RoomController {
    @Autowired
    RoomService roomService;

    /**
     * Method：创建游戏房间请求
     * @param creator: 创建者信息
     * @return: 带有生成的roomId的Room对象
     */
    @PostMapping(value = "/room")
    public Room createRoom(User creator,
                           @RequestParam("roleList") String roleString){
        return roomService.createRoom(creator, roleString);
    }

    //输入的roomId有误，返回一个roomId == null的Room对象
    @GetMapping(value = "/room/{roomId}")
    public Room joinRoom(@PathVariable("roomId") Integer roomId, User user){
        return roomService.joinRoom(roomId, user);
    }

    @DeleteMapping(value = "/room/{roomId}")
    public Boolean deleteRoom(@PathVariable("roomId") Integer roomId){
        return roomService.deleteRoom(roomId);
    }

}
