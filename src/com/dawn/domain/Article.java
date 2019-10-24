package com.dawn.domain;


import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Article {


    private Integer article_id;
    private String article_title;
    private Integer article_time;
    private String article_content;
    private String article_pic;
    private String article_desc;
    private Category category;

    public Article() {
    }

    public Article(Integer article_id, String article_title, Integer article_time, String article_content, String article_pic, String article_desc, Category category) {
        this.article_id = article_id;
        this.article_title = article_title;
        this.article_time = article_time;
        this.article_content = article_content;
        this.article_pic = article_pic;
        this.article_desc = article_desc;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Article{" +
                "article_id=" + article_id +
                ", article_title='" + article_title + '\'' +
                ", article_time=" + article_time +
                ", article_content='" + article_content + '\'' +
                ", article_pic='" + article_pic + '\'' +
                ", article_desc='" + article_desc + '\'' +
                ", category=" + category +
                '}';
    }
}
