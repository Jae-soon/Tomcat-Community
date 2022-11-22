package com.ll.comu.global;

import com.ll.comu.article.controller.ArticleController;
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


        switch (rq.getMethod()) {
            case "GET":
                switch (rq.getPath()) {
                    case "/usr/article/list":
                        articleController.showList(rq);
                        break;
                    case "/usr/member/login":
                        memberController.showLogin(rq);
                        break;
                    case "/usr/article/write":
                        articleController.showWrite(rq);
                        break;
                }
                break;
            case "POST":
                switch (rq.getPath()) {
                    case "/usr/article/write":
                        articleController.doWrite(rq);
                        break;
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }
}
