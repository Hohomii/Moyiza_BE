package com.example.moyiza_be.chat.dto;

import com.example.moyiza_be.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatUserList {
    private String nickName;
    private String profileImage;

    public ChatUserList(User user) {
        this.nickName = user.getNickname();
        this.profileImage = user.getProfileImage();
    }
}
