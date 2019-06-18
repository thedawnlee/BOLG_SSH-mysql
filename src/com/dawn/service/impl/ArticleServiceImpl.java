package com.dawn.service.impl;

import com.dawn.dao.ArticleDao;
import com.dawn.domain.Article;
import com.dawn.domain.Category;
import com.dawn.domain.PageBean;
import com.dawn.service.ArticleService;
import lombok.Setter;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class ArticleServiceImpl  implements ArticleService {

    @Setter
    private ArticleDao articleDao;





    @Override
    public List<Article> getAllArticle() {

        List<Article> allArticle = articleDao.getAllArticle();

        return allArticle;
    }

    @Override
    public PageBean getPageData(DetachedCriteria detachedCriteria, Integer currPage, int i) {

        PageBean<Article> articlePageBean = new PageBean<>();

        articlePageBean.setCurrentPage(currPage);


        //设置一页有多少条数据
        articlePageBean.setPageSize(i);

        //总共多少条记录


        //database query

        Integer total  = articleDao.getTotalCount(detachedCriteria);

        articlePageBean.setTotalCount(total);

        //设置总页数

        articlePageBean.setTotalPage(articlePageBean.getTotalPage());



        //设置当前页数据

        List<Article> list =  articleDao.getPageData(detachedCriteria,articlePageBean.getIndex(),articlePageBean.getPageSize());

        articlePageBean.setList(list);

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println(articlePageBean.getTotalPage());
        System.out.println(articlePageBean.getCurrentPage());
        System.out.println(articlePageBean.getTotalCount());
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println(articlePageBean);
        return articlePageBean;



    }

    @Override
    public void delete(Article article) {




        articleDao.delete(article);





    }

    @Override
    public List<Category> getCategory(Integer parentid) {


        List<Category> list = articleDao.getCategory(parentid);
        return list;

    }
}
