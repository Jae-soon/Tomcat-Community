package com.ll.comu.article.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class ArticleDto {
    private long id;
    private String title;
    private String content;
}
