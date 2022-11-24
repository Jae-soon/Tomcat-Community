package com.ll.comu.chat.repository;

import com.ll.comu.chat.dto.ChatMessageDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ChatMessageRepository {
    private static List<ChatMessageDto> datum;
    private static long lastId;

    static {
        datum = new ArrayList<>();
        lastId = 0;

        makeTestData();
    }

    private static void makeTestData() {
        IntStream.rangeClosed(1, 10).forEach(roomId -> {
            IntStream.rangeClosed(1, 10).forEach(id -> {
                String content = "메세지 %d".formatted(id);
                write(roomId, content);
            });
        });
    }

    public static long write(long roomId, String content) {
        long id = ++lastId;
        ChatMessageDto newChatMessageDto = new ChatMessageDto(id, roomId, content);

        datum.add(newChatMessageDto);

        return id;
    }

    public List<ChatMessageDto> findByRoomId(long roomId) {
        return datum
                .stream()
                .filter(chatMessageDto -> chatMessageDto.getRoomId() == roomId)
                .collect(Collectors.toList());
    }
}