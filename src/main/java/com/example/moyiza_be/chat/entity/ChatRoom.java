package com.example.moyiza_be.chat.entity;

import com.example.moyiza_be.common.utils.TimeStamped;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class ChatRoom extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long id;
    @Column(name = "room_uuid")
    private String roomId;
    @Column(nullable = false)
    private String roomName;
    @OneToMany(mappedBy = "chatRoom", cascade = CascadeType.REMOVE)
    private List<Chat> chatList;

    @Builder
    public ChatRoom(String roomName) {
        this.roomName = roomName;
    }

    public ChatRoom(String roomId, String roomName) {
        this.roomId = roomId;
        this.roomName = roomName;
    }

    public static ChatRoom of(String roomId, String roomName) {
        return new ChatRoom(roomId, roomName);
    }
}
