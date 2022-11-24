package com.ll.comu.chat.controller;

import com.ll.comu.chat.dto.ChatRoomDto;
import com.ll.comu.chat.service.ChatService;
import com.ll.comu.global.Rq;

import java.util.List;

public class ChatController {
    private ChatService chatService;

    public ChatController() {
        chatService = new ChatService();
    }
    public void showCreateRoom(Rq rq) {
        rq.view("usr/chat/createRoom");
    }

    public void doCreateRoom(Rq rq) {
        String title = rq.getParam("title", "");
        String content = rq.getParam("content", "");

        if (title.length() == 0) {
            rq.historyBack("제목을 입력해주세요.");
            return;
        }

        if (content.length() == 0) {
            rq.historyBack("내용을 입력해주세요.");
            return;
        }

        long id = chatService.createRoom(title, content);

        rq.replace("/usr/chat/room/%d".formatted(id), "%d번 채팅방이 생성 되었습니다.".formatted(id));
    }

    public void showRoomList(Rq rq) {
        List<ChatRoomDto> chatRoomDtos = chatService.findAllRooms();

        rq.setAttribute("rooms", chatRoomDtos);
        rq.view("usr/chat/roomList");
    }

    public void showModifyRoom(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, -1);

        if ( id == -1 ) {
            rq.historyBack("번호를 입력해주세요.");
            return;
        }

        ChatRoomDto chatRoom = chatService.findRoomById(id);

        if ( chatRoom == null ) {
            rq.historyBack("존재하지 않는 채팅방 입니다.");
            return;
        }

        rq.setAttribute("room", chatRoom);
        rq.view("usr/chat/modifyRoom");
    }

    public void doModifyRoom(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, -1);

        if ( id == -1 ) {
            rq.historyBack("번호를 입력해주세요.");
            return;
        }

        String title = rq.getParam("title", "");

        if ( title.length() == 0 ) {
            rq.historyBack("제목을 입력해주세요.");
            return;
        }

        String content = rq.getParam("content", "");

        if ( content.length() == 0 ) {
            rq.historyBack("내용을 입력해주세요.");
            return;
        }

        ChatRoomDto chatRoom = chatService.findRoomById(id);

        if ( chatRoom == null ) {
            rq.historyBack("존재하지 않는 채팅방 입니다.");
            return;
        }

        chatService.modifyRoom(id, title, content);

        rq.replace("/usr/chat/room/%d".formatted(id), "%d번 채팅방이 수정되었습니다.".formatted(id));
    }

    public void deleteRoom(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);

        if (id == 0) {
            rq.historyBack("번호를 입력해주세요.");
            return;
        }

        ChatRoomDto chatRoomDto = chatService.findRoomById(id);

        if (chatRoomDto == null) {
            rq.historyBack("해당 글이 존재하지 않습니다.");
            return;
        }

        chatService.deleteRoom(id);

        rq.replace("/usr/chat/roomList", "%d번 채팅방이 삭제되었습니다.".formatted(id));
    }
}
