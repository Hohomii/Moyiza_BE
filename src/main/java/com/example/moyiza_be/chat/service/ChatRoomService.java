//package com.example.moyiza_be.chat.service;
//
//import com.example.moyiza_be.chat.dto.ChatRoomRequestDto;
//import com.example.moyiza_be.chat.dto.ChatRoomResponseDto;
//import com.example.moyiza_be.chat.entity.ChatRoom;
//import com.example.moyiza_be.chat.repository.ChatRoomRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.UUID;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//@Transactional
//public class ChatRoomService {
//
//    private final ChatRoomRepository chatRoomRepository;
//
//    public ChatRoomResponseDto getChatRoom(Long roomId) {
//        ChatRoom chatRoom = loadChatRoomById(roomId);
//        return new ChatRoomResponseDto(chatRoom);
//    }
//
//    public List<ChatRoomResponseDto> getChatRoomList() {
//        Sort sort = Sort.by(Sort.Direction.DESC, "roomId");
//        List<ChatRoom> chatRoomList = this.chatRoomRepository.findAll(sort);
//        return chatRoomList.stream().map(ChatRoomResponseDto::new).collect(Collectors.toList());
//    }
//
//    public ChatRoomResponseDto createChatRoom(String roomName) {
//        ChatRoomRequestDto requestDto = new ChatRoomRequestDto();
//
//
//
//        chatRoomRepository.save(requestDto);
//
//
//
//        return this.chatRoomRepository.save(requestDto.toEntity()).getId();
//    }
//
//    public Long updateChatRoom(Long id, ChatRoomRequestDto requestDto) {
//        ChatRoom chatRoom = loadChatRoomById(id);
//        return chatRoom.update(requestDto);
//    }
//
//    //방장만 채팅 삭제 가능하게 하는 로직 추가 필요
//    //일반회원은 채팅방 나가기 기능 따로 필요
//    public void deleteChatRoom(Long id) {
//        ChatRoom chatRoom = loadChatRoomById(id);
//        this.chatRoomRepository.delete(chatRoom);
//    }
//
//    //////private method//////
//    private ChatRoom loadChatRoomById(Long roomId) {
//        ChatRoom chatRoom = chatRoomRepository.findById(roomId).orElseThrow(
//                () -> new NullPointerException("해당 채팅방이 존재하지 않습니다.")
//        );
//        return chatRoom;
//    }
//}
