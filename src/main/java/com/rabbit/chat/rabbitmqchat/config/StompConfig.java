package com.rabbit.chat.rabbitmqchat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class StompConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/stomp/chat")     // 클라이언트는 해당 엔드포인트로 웹소켓 연결 가능하도록 엔드포인트 추가
                .setAllowedOriginPatterns("http://*.*.*.*:8081", "http://*:8081")   // 웹 애플리케이션 도메인 또는 IP주소의 원본 패턴 지정
                .withSockJS();  // SocketJS를 사용하여 웹소켓 지원 (웹소켓이 지원되지 않는 환경에서도 가능하도록 브라우저 호환성을 높임)
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setPathMatcher(new AntPathMatcher("."));   // url을 chat/room/3 -> chat.room.3으로 참조하기 위한 설정
        registry.setApplicationDestinationPrefixes("/pub");     // 클라이언트가 메세지를 보낼때 사용할 접두사 설정 (/pub로 시작하는 경로에 메세지를 보낼 수 있음)

        // registry.enableSimpleBroker("/sub");
        registry.enableStompBrokerRelay("/queue", "/topic", "/exchange", "/amp/queue"); // 해당 대상으로 메시지를 특정대상에게 전달하겠음.
    }
}
