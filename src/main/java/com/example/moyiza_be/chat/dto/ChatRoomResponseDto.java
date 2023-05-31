package com.example.moyiza_be.chat.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatRoomResponseDto {
    private Long room_id;
    private String roomName;

    public ChatRoomResponseDto(Long room_id, String roomName) {
        this.room_id = room_id;
        this.roomName = roomName;
    }
}
