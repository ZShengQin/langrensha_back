package cn.sillycode.langrensha.controller;

import cn.sillycode.langrensha.Service.RoomService;
import cn.sillycode.langrensha.entity.Result;
import cn.sillycode.langrensha.entity.User;
import cn.sillycode.langrensha.utility.ResultUtil;
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
     * 创建游戏房间请求
     * @param creator 创建者信息
     * @return 带有生成的roomId的Room对象
     */
    @PostMapping(value = "/room")
    public Result createRoom(User creator,
                           @RequestParam("roleList") String roleString){
        return ResultUtil.success(roomService.createRoom(creator, roleString));
    }

    //输入的roomId有误，返回一个roomId == null的Room对象
    @GetMapping(value = "/room/{roomId}")
    public Result joinRoom(@PathVariable("roomId") Integer roomId,
                         User user){
        if(!roomService.findone(roomId)){
            return ResultUtil.enterError(new String("User Enter Error!"));
        }
        return ResultUtil.success(roomService.joinRoom(roomId, user));
    }

    @DeleteMapping(value = "/room/{roomId}")
    public Result deleteRoom(@PathVariable("roomId") Integer roomId){
        if(roomService.deleteRoom(roomId)){
            return ResultUtil.success(new String("房间销毁成功"));
        }
        return ResultUtil.error(new String("房间销毁失败"));
    }

}
