package com.rabbit.chat.rabbitmqchat.controller;

import com.rabbit.chat.rabbitmqchat.dto.ChatDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@Log4j2
public class StompRabbitController {

    private final RabbitTemplate template;
    private final static String CHAT_EXCHANGE_NAME = "chat.exchange";
    private final static String CHAT_QUEUE_NAME = "chat.queue";

    /**
     * 입장 알림
     * @param chat 채팅 내용
     * @param chatRoomId 채팅방 ID
     */
    @MessageMapping("chat.enter.{chatRoomId}")
    public void enter(ChatDTO chat, @DestinationVariable String chatRoomId) {   // @DestinationVariable은 @PathVariable과 비슷함

        chat.setMessage("입장하셨습니다.");
        chat.setRegDate(LocalDateTime.now());

        // convertAndSend([exchange 이름], routing-key, 전송하고자 하는것);
        template.convertAndSend(CHAT_EXCHANGE_NAME, "room" + chatRoomId, chat);     // exchange
        // template.convertAndSend("room." + chatRoomId, chat);  //queue
        // template.convertAndSend("amq.topic", "room." + chatRoomId, chat); //topic
    }

    /**
     * 메세지 전송
     * @param chat 채팅내용
     * @param chatRoomId 채팅방 ID
     */
    @MessageMapping("chat.message.{chatRoomId}")
    public void send(ChatDTO chat, @DestinationVariable String chatRoomId) {

        chat.setRegDate(LocalDateTime.now());

        template.convertAndSend(CHAT_EXCHANGE_NAME, "room." + chatRoomId, chat);
        // template.convertAndSend( "room." + chatRoomId, chat);
        // template.convertAndSend("amq.topic", "room." + chatRoomId, chat);
    }

    // 큐에서 메세지를 수신하고 처리
    @RabbitListener(queues = CHAT_QUEUE_NAME)
    public void receive(ChatDTO chat) {
        System.out.println("received : " + chat.getMessage());
    }
}
