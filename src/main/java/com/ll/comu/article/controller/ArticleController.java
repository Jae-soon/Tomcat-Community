package com.ll.comu.article.controller;

import com.ll.comu.article.service.ArticleService;
import com.ll.comu.global.Rq;
import com.ll.comu.article.dto.ArticleDto;
import com.ll.comu.global.util.Ut;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        String content = rq.getParam("content", "");

        if (title.length() == 0) {
            rq.historyBack("제목을 입력해주세요.");
            return;
        }

        if (content.length() == 0) {
            rq.historyBack("내용을 입력해주세요.");
            return;
        }

        long id = articleService.write(title, content);
        rq.replace("/usr/article/detail/%d".formatted(id), "%d번 게시물이 생성 되었습니다.".formatted(id));
    }

    public void showDetail(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);

        if (id == 0) {
            rq.historyBack("번호를 입력해주세요.");
            return;
        }

        ArticleDto articleDto = articleService.findById(id);

        if (articleDto == null) {
            rq.historyBack("해당 글이 존재하지 않습니다.");
            return;
        }

        rq.setAttribute("article", articleDto);
        rq.view("usr/article/detail");
    }

    public void doDelete(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);

        if (id == 0) {
            rq.historyBack("번호를 입력해주세요.");
            return;
        }

        ArticleDto articleDto = articleService.findById(id);

        if (articleDto == null) {
            rq.historyBack("해당 글이 존재하지 않습니다.");
            return;
        }

        articleService.delete(id);

        rq.replace("/usr/article/list", "%d번 게시물이 삭제되었습니다.".formatted(id));
    }

    public void showModify(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);

        if (id == 0) {
            rq.historyBack("번호를 입력해주세요.");
            return;
        }

        ArticleDto articleDto = articleService.findById(id);

        if (articleDto == null) {
            rq.historyBack("해당 글이 존재하지 않습니다.");
            return;
        }

        rq.setAttribute("article", articleDto);
        rq.view("usr/article/modify");
    }

    public void doModify(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);

        if (id == 0) {
            rq.historyBack("번호를 입력해주세요.");
            return;
        }

        ArticleDto articleDto = articleService.findById(id);

        if (articleDto == null) {
            rq.historyBack("해당 글이 존재하지 않습니다.");
            return;
        }

        String title = rq.getParam("title", "");
        String content = rq.getParam("content", "");

        articleService.modify(id, title, content);

        rq.replace("/usr/article/detail/%d".formatted(id), "%d번 게시물이 수정되었습니다.".formatted(id));
    }

    public void getArticles(Rq rq) {
        List<ArticleDto> articleDtos = articleService.findAll();

        Map<String, Object> resultData = new LinkedHashMap<String, Object>();

        resultData.put("resultCode", "S-1");
        resultData.put("msg", "성공");
        resultData.put("data", articleDtos);

        rq.json(resultData);
    }
}
