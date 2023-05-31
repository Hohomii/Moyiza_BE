package com.example.moyiza_be.chat.dto;

import com.example.moyiza_be.chat.entity.ChatRoom;
import lombok.Data;

import java.util.HashMap;
import java.util.UUID;

@Data
public class ChatRoomDto {
    private Long id;
    private String roomId;
    private String roomName;
    private long userCount;

    private HashMap<String, String> userList = new HashMap<String, String>();

    public static ChatRoom createRoom(ChatRoomDto chatRoomDto) {
        return ChatRoom.of(
                UUID.randomUUID().toString(),
                chatRoomDto.getRoomName()
        );
    }
}
