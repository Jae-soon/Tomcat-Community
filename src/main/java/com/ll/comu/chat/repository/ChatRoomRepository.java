package com.ll.comu.chat.repository;

import com.ll.comu.chat.dto.ChatRoomDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ChatRoomRepository {
    private static List<ChatRoomDto> datum;
    private static long lastId;

    static {
        datum = new ArrayList<>();
        lastId = 0;

        makeTestData();
    }

    private static void makeTestData() {
        IntStream.rangeClosed(1, 10).forEach(id -> {
            String title = "이름%d".formatted(id);
            String content = "주제%d".formatted(id);
            create(title, content);
        });
    }

    public static long create(String title, String content) {
        long id = ++lastId;
        ChatRoomDto newChatRoomDto = new ChatRoomDto(id, title, content);

        datum.add(newChatRoomDto);

        return id;
    }

    public List<ChatRoomDto> findAll() {
        return datum;
    }
}
