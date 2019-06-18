package com.dawn.dao;

import com.dawn.domain.Article;
import com.dawn.domain.Category;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface ArticleDao {

    List<Article> getAllArticle();



    //获取页面数据信息
    List<Article> getPageData(DetachedCriteria detachedCriteria, Integer index, Integer pageSize);
//获取记录总条数
    Integer getTotalCount(DetachedCriteria detachedCriteria);

    void delete(Article article);

    List<Category> getCategory(Integer parentid);

}
