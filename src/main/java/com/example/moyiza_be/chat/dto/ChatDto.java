package com.example.moyiza_be.chat.dto;

import lombok.*;

@NoArgsConstructor
@Getter
public class ChatDto {
    public enum MessageType {
        ENTER, TALK, LEAVE;
    }

    private MessageType type;
    private Long room_id;
    private String sender;
    private String message;
    private String createdAt;
    private String modifiedAt;
}
