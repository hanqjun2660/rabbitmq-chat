package com.rabbit.chat.rabbitmqchat.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ChatDTO {

    private Long id;
    private Long chatRoomId;
    private Long memberId;
    private String message;
    private String region;

    // json을 객체로 역직렬화 함 (json -> LocalDateTime 객체로 변환)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime regDate;
}
