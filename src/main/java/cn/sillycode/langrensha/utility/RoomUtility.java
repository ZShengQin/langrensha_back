package cn.sillycode.langrensha.utility;

/**
 * @program: langrensha
 * @description: ${description}
 * @author: zsq
 * @create: 2018-05-06 20-13
 */
public class RoomUtility {
    public static Integer genRoomId(){
        return (Integer)(100000 + (int)(Math.random() * (999999-100000)));
    }
}
