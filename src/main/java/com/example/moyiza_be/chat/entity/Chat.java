package com.example.moyiza_be.chat.entity;

import com.example.moyiza_be.common.utils.TimeStamped;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Chat extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String sender;
    @Column(nullable = false)
    private String message;

    @ManyToOne
    private ChatRoom chatRoom;

    @Builder
    public Chat(String sender, String message, ChatRoom chatRoom) {
        this.sender = sender;
        this.message = message;
        this.chatRoom = chatRoom;
    }
}
