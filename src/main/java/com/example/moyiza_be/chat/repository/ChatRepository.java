package com.example.moyiza_be.chat.repository;

import com.example.moyiza_be.chat.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {

}
