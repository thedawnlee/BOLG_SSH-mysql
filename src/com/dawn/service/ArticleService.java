package com.dawn.service;

import com.dawn.domain.Article;
import com.dawn.domain.Category;
import com.dawn.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface ArticleService {

    List<Article> getAllArticle();

    PageBean getPageData(DetachedCriteria detachedCriteria, Integer currPage, int i);

    void delete(Article article);

    List<Category> getCategory(Integer parentid);
}
