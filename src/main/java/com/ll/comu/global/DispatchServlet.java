package com.ll.comu.global;

import com.ll.comu.article.controller.ArticleController;
import com.ll.comu.chat.controller.ChatController;
import com.ll.comu.member.controller.MemberController;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/usr/*")
public class DispatchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Rq rq = new Rq(req, resp);

        MemberController memberController = new MemberController();
        ArticleController articleController = new ArticleController();
        ChatController chatController = new ChatController();

        switch (rq.getRouteMethod()) {
            case "GET":
                switch (rq.getActionPath()) {
                    case "/usr/article/list" -> articleController.showList(rq);
                    case "/usr/member/login" -> memberController.showLogin(rq);
                    case "/usr/article/write" -> articleController.showWrite(rq);
                    case "/usr/article/detail" -> articleController.showDetail(rq);
                    case "/usr/article/modify" -> articleController.showModify(rq);
                    case "/usr/article/getArticles" -> articleController.getArticles(rq);
                    case "/usr/article/listAuto" -> articleController.showListAuto(rq);
                    case "/usr/chat/createRoom" -> chatController.showCreateRoom(rq);
                    case "/usr/chat/roomList" -> chatController.showRoomList(rq);
                    case "/usr/chat/modifyRoom" -> chatController.showModifyRoom(rq);
                    case "/usr/chat/room" -> chatController.showRoom(rq);
                    case "/usr/chat/roomManual" -> chatController.showRoomMamual(rq);
                    case "/usr/chat/getMessages" -> chatController.getMessages(rq);
                }
                break;
            case "POST":
                switch (rq.getActionPath()) {
                    case "/usr/article/write" -> articleController.doWrite(rq);
                    case "/usr/article/modify" -> articleController.doModify(rq);
                    case "/usr/chat/createRoom" -> chatController.doCreateRoom(rq);
                    case "/usr/chat/modifyRoom" -> chatController.doModifyRoom(rq);
                    case "/usr/chat/writeMessage" -> chatController.doWriteMessage(rq);
                    case "/usr/chat/writeMessageAjax" -> chatController.doWriteMessageAjax(rq);
                }
                break;
            case "DELETE":
                switch (rq.getActionPath()) {
                    case "/usr/article/delete" -> articleController.doDelete(rq);
                    case "/usr/chat/deleteRoom" -> chatController.deleteRoom(rq);
                    case "/usr/chat/deleteMessage" -> chatController.deleteMessage(rq);
                }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }
}
