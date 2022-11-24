package com.ll.comu.article.dto;

import lombok.*;

@ToString
@AllArgsConstructor
@Getter
@Setter
public class ArticleDto {
    private long id;
    private String title;
    private String content;
}
