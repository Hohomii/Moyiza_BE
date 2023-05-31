package com.example.moyiza_be.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    private final StompHandler stompHandler; // jwt 인증

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //stomp 접속 주소
        registry.addEndpoint("/chat"); //핸드쉐이크를 통한 커넥션
        registry.addEndpoint("/chat")
                .setAllowedOrigins("http://localhost:3000",
                                    "http://moyiza.s3-website.ap-northeast-2.amazonaws.com/",
                                    "chrome-extension://pfdhoblngboilpfeibdedpjgfnlcodoo/index.html",
                                    "https://chrome-extension://pfdhoblngboilpfeibdedpjgfnlcodoo/index.html",
                                    "http://chrome-extension://pfdhoblngboilpfeibdedpjgfnlcodoo/index.html",
                                    "http://localhost:8080",
                                    "ws://localhost:8080",
                                    "http://localhost:8080/index.html")

//                .setAllowedOriginPatterns("*")
//                .setAllowedOrigins("ws://localhost:8080", "http://localhost:8080")
                .withSockJS(); //SocketJS 연결
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //메시지 구독 요청 : 메시지 수신
        registry.enableSimpleBroker("/sub"); //topic

        //메시지 발행 요청 : 메시지 발신
        registry.setApplicationDestinationPrefixes("/pub"); //app
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(stompHandler);
    }
}
