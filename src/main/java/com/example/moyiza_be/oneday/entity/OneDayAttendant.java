package com.example.moyiza_be.oneday.entity;

import com.example.moyiza_be.common.utils.TimeStamped;
import com.example.moyiza_be.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@NoArgsConstructor
public class OneDayAttendant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long oneDayId;

    @Column
    private Long userId;

    private String userName;
    private String userNickName;
    private String userEmail;
    private String userProfileImage;

    public OneDayAttendant(Long OneDayId, User user) {
        this.oneDayId = OneDayId;
        this.userId = user.getId();
        this.userName = user.getName();
        this.userNickName = user.getNickname();
        this.userEmail = user.getEmail();
        this.userProfileImage = user.getProfileImage();
    }
}
