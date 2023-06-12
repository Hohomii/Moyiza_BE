package com.example.moyiza_be.user.dto;

import com.example.moyiza_be.club.dto.ClubDetailResponse;
import com.example.moyiza_be.club.dto.ClubListOnMyPage;
import com.example.moyiza_be.common.enums.TagEnum;
import com.example.moyiza_be.oneday.dto.OneDayDetailOnMyPage;
import com.example.moyiza_be.oneday.dto.OneDayListOnMyPage;
import com.example.moyiza_be.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class MyPageResponseDto {
    //유저 정보, 운영중 클럽, 참여중 클럽, 운영중 원데이, 참여중 원데이
    private Long user_id;
    private String nickname;
    private String email;
    private String profileImage;
    private List<String> tags;
    private Integer clubsInOperationCount;
    private Integer clubsInParticipatingCount;
    private Integer oneDaysInOperationCount;
    private Integer oneDaysInParticipatingCount;
    private List<ClubDetailResponse> clubsInOperationInfo;
    private List<ClubDetailResponse> clubsInParticipatingInfo;
    private List<OneDayDetailOnMyPage> oneDaysInOperationInfo;
    private List<OneDayDetailOnMyPage> oneDaysInParticipatingInfo;


    public MyPageResponseDto(User user, ClubListOnMyPage clubListOnMyPage, OneDayListOnMyPage oneDayListOnMyPage) {
        this.user_id = user.getId();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
        this.profileImage = user.getProfileImage();
        this.tags = TagEnum.parseTag(user.getTagString());
        this.clubsInOperationCount = clubListOnMyPage.getClubsInOperationInfo().size();
        this.clubsInParticipatingCount = clubListOnMyPage.getClubsInParticipatingInfo().size();
        this.oneDaysInOperationCount = oneDayListOnMyPage.getOneDaysInOperationInfo().size();
        this.oneDaysInParticipatingCount = oneDayListOnMyPage.getOneDaysInParticipatingInfo().size();
        this.clubsInOperationInfo = clubListOnMyPage.getClubsInOperationInfo();
        this.clubsInParticipatingInfo = clubListOnMyPage.getClubsInParticipatingInfo();
        this.oneDaysInOperationInfo = oneDayListOnMyPage.getOneDaysInOperationInfo();
        this.oneDaysInParticipatingInfo = oneDayListOnMyPage.getOneDaysInParticipatingInfo();
    }
}
