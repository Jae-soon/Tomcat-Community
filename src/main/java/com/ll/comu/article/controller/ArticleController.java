package com.ll.comu.article.controller;

import com.ll.comu.article.service.ArticleService;
import com.ll.comu.global.Rq;
import com.ll.comu.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleController {
    private ArticleService articleService;

    public ArticleController() {
        articleService = new ArticleService();
    }
    public void showList(Rq rq) {
        List<ArticleDto> articles = articleService.findAll();

        rq.setAttribute("articles", articles);
        rq.view("usr/article/list");
    }


    public void showWrite(Rq rq) {
        rq.view("usr/article/write");
    }


    public void doWrite(Rq rq) {
        String title = rq.getParam("title", "");
        String body = rq.getParam("body", "");

        long id = articleService.write(title, body);
        rq.replace("/usr/article/detail/%d".formatted(id), "%d번 게시물이 생성 되었습니다.".formatted(id));
    }

    public void showDetail(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);

        if (id == 0) {
            rq.println("번호를 입력해주세요.");
            return;
        }

        ArticleDto articleDto = articleService.findById(id);

        if (articleDto == null) {
            rq.println("해당 글이 존재하지 않습니다.");
            return;
        }

        rq.setAttribute("article", articleDto);
        rq.view("usr/article/detail");
    }

    public void doDelete(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);

        if (id == 0) {
            rq.println("번호를 입력해주세요.");
            return;
        }

        ArticleDto articleDto = articleService.findById(id);

        if (articleDto == null) {
            rq.println("해당 글이 존재하지 않습니다.");
            return;
        }

        articleService.delete(id);

        rq.replace("/usr/article/list", "%d번 게시물이 삭제되었습니다.".formatted(id));
    }

    public void showModify(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);

        if (id == 0) {
            rq.println("번호를 입력해주세요.");
            return;
        }

        ArticleDto articleDto = articleService.findById(id);

        if (articleDto == null) {
            rq.println("해당 글이 존재하지 않습니다.");
            return;
        }

        rq.setAttribute("article", articleDto);
        rq.view("usr/article/modify");
    }

    public void doModify(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);
        String title = rq.getParam("title", "");
        String content = rq.getParam("content", "");

        articleService.modify(id, title, content);

        rq.replace("/usr/article/detail/%d".formatted(id), "%d번 게시물이 수정되었습니다.".formatted(id));
    }
}
