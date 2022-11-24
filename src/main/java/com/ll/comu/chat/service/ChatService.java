package com.ll.comu.chat.service;

import com.ll.comu.chat.dto.ChatMessageDto;
import com.ll.comu.chat.dto.ChatRoomDto;
import com.ll.comu.chat.repository.ChatMessageRepository;
import com.ll.comu.chat.repository.ChatRoomRepository;

import java.util.List;

public class ChatService {
    private ChatRoomRepository chatRoomRepository;
    private ChatMessageRepository chatMessageRepository;

    public ChatService() {
        chatRoomRepository = new ChatRoomRepository();
        chatMessageRepository = new ChatMessageRepository();
    }
    public long createRoom(String title, String content) {
        return chatRoomRepository.create(title, content);
    }

    public List<ChatRoomDto> findAllRooms() {
        return chatRoomRepository.findAll();
    }

    public ChatRoomDto findRoomById(long id) {
        return chatRoomRepository.findById(id);
    }

    public void modifyRoom(long id, String title, String content) {
        chatRoomRepository.modify(id, title, content);
    }

    public void deleteRoom(long id) {
        chatRoomRepository.deleteRoom(id);
    }

    public long writeMessage(long roomId, String content) {
        return chatMessageRepository.write(roomId, content);
    }

    public List<ChatMessageDto> findMessagesByRoomId(long id) {
        return chatMessageRepository.findByRoomId(id);
    }

    public List<ChatMessageDto> findMessagesByRoomIdGreaterThan(long roomId, long fromId) {
        return chatMessageRepository.findByRoomIdGreaterThan(roomId, fromId);
    }

    public ChatMessageDto findMessageById(long id) {
        return chatMessageRepository.findById(id);
    }

    public void deleteMessage(long id) {
        chatMessageRepository.deleteMessage(id);
    }
}
