package com.example.moyiza_be.chat.service;

import com.example.moyiza_be.chat.dto.ChatDto;
import com.example.moyiza_be.chat.dto.ChatRoomDto;
import com.example.moyiza_be.chat.dto.ChatRoomResponseDto;
import com.example.moyiza_be.chat.repository.ChatRepository;
import com.example.moyiza_be.chat.repository.ChatRoomRepository;
import com.example.moyiza_be.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ChatService {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChatRepository chatRepository;
    private final ChatRoomRepository chatRoomRepository;

    //전체 채팅방 조회
    //유저가 가입된 클럽의 채팅방 목록
    public ResponseEntity<List<ChatRoomResponseDto>> getRoom() {
        log.info("Service getRoom");
        List<ChatRoomResponseDto> chatRoomResponseDtoList = chatRepository.findAll()
                                        .stream()
                                        .map(chat -> new ChatRoomResponseDto(chat.getId(), chat.getChatRoom().getRoomName()))
                                        .collect(Collectors.toList());
        return ResponseEntity.ok(chatRoomResponseDtoList);
    }


    //채팅방 생성
    //클럽장만 생성 가능
    public ResponseEntity<ChatRoomDto> createRoom(ChatRoomDto chatRoomDto) {
        log.info("Service createRoom: " + chatRoomDto.getRoomName());
        chatRoomRepository.save(ChatRoomDto.createRoom(chatRoomDto));
        return ResponseEntity.ok(chatRoomDto);
    }


    //채팅방 입장
    //유저가 가입된 클럽의 채팅방만 입장 가능


    //채팅방 퇴장
    //유저가 가입된 클럽의 채팅방만 퇴장 가능
    //유저가 입장한 클럽의 채팅방만 퇴장 가능


    //채팅방 전체 유저리스트 조회
    //채팅방에 들어와있는 사람(ClubMember 정보 가져와야: 프로필, 닉네임)


    //채팅하기
    public void sendMessage(ChatDto chatDto) {
        chatDto.setMessage(chatDto.getMessage());
        messagingTemplate.convertAndSend("/sub/chat/room" + chatDto.getRoom_id(), chatDto);
    }




//
//    public void enterRoom(ChatDto chatDto, SimpMessageHeaderAccessor headerAccessor) {
//        ChatRoom chatRoom = loadChatRoomByRoomId(chatDto);
//
//
//
//
//        chatRoomRepository.plusUserCnt(requestDto.getRoomId());
//        String userUUID = chatRoomRepository.addUser(requestDto.getRoomId(), requestDto.getSender());
//        headerAccessor.getSessionAttributes().put("userUUID", userUUID);
//        headerAccessor.getSessionAttributes().put("roomId", requestDto.getRoomId());
//        requestDto.setMessage()
//    }
//
//
//
//    private ChatRoom loadChatRoomByRoomId(ChatDto chatDto) {
//        ChatRoom chatRoom = chatRoomRepository.findById(chatDto.getRoomId()).orElseThrow(
//                () -> new NullPointerException("해당 채팅방이 존재하지 않습니다.")
//        );
//    }
}
