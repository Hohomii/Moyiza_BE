package com.example.moyiza_be.chat.controller;

import com.example.moyiza_be.chat.dto.ChatDto;
import com.example.moyiza_be.chat.dto.ChatRoomDto;
import com.example.moyiza_be.chat.dto.ChatRoomResponseDto;
import com.example.moyiza_be.chat.dto.ChatUserList;
import com.example.moyiza_be.chat.service.ChatService;
import com.example.moyiza_be.common.security.userDetails.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
//@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    //모두 유저가 가입된 클럽/원데이 채팅방 : user 정보 넘겨주어야
    //전체 채팅방 조회
    @GetMapping("/room")
    public ResponseEntity<List<ChatRoomResponseDto>> getRoom() {
        log.info("Controller getRoom");
        return chatService.getRoom();
    }

    //채팅방 생성
    @PostMapping("/room")
    public ResponseEntity<ChatRoomDto> createRoom(@RequestBody ChatRoomDto chatRoomDto) {
        log.info("Controller createRoom: " + chatRoomDto.getRoomName());
        return chatService.createRoom(chatRoomDto);
    }

    //채팅 내역 조회
    @GetMapping("/room/{room_id}")
    public ResponseEntity<>

    //채팅방 입장
    @MessageMapping("/enter")
    public void enterRoom(@Payload ChatDto chatDto, SimpMessageHeaderAccessor headerAccessor) {
        log.info("Controller enterRoom: " + chatDto.getRoom_id());
        return chatService.enterRoom(chatDto, headerAccessor);
    }

    //채팅방 퇴장
    @EventListener
    public void exitRoom(SessionDisconnectEvent event) {
        log.info("Controller exitRoom")
        return chatService.webSocketDisconnectListener(event);
    }

    //채팅방 전체 유저리스트 조회
    @GetMapping("/userList")
    public List<ChatUserList> getUserList() {
        log.info("Controller getUserList");
        return chatService.getUserList();
    }


    //채팅하기
    @MessageMapping("/sendMessage")
    public void sendMessage(@Payload ChatDto chatDto) {
        chatService.sendMessage(chatDto);
    }


}
