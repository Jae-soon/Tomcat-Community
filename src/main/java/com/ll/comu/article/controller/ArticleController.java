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
        rq.appendBody("%d번 게시물이 생성되었습니다.".formatted(id));
    }
}
