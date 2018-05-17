package cn.sillycode.langrensha.utility;

/**
 * @program: langrensha
 * @description: ${description}
 * @author: zsq
 * @create: 2018-05-06 20-13
 */
public class RoomUtility {

    public static final Integer MAX_ROOM_ID = 99999999;
    public static final Integer MIN_ROOM_ID = 100000;

    public static Integer genRoomId(){
        return (Integer)(MIN_ROOM_ID + (int)(Math.random() * (MAX_ROOM_ID - MIN_ROOM_ID)));
    }
}
