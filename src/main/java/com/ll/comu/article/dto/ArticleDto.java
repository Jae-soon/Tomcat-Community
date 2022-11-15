package com.ll.comu.article.dto;

public class ArticleDto {
    private long id;
    private String title;
    private String content;

    @Override
    public String toString() {
        return "ArticleDto{" +
                "id =" + id +
                ", title = '" + title + '\'' +
                ", content = '" + content + '\'' +
                '}';
    }

    public ArticleDto(long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
