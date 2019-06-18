package com.dawn.dao.impl;

import com.dawn.dao.ArticleDao;
import com.dawn.domain.Article;
import com.dawn.domain.Category;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class ArticleDaoImpl extends HibernateDaoSupport implements ArticleDao {
    @Override
    public List<Article> getAllArticle() {


        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Article.class);

        List<Article> byCriteria = (List<Article>) this.getHibernateTemplate().findByCriteria(detachedCriteria);

        return byCriteria;
    }

    @Override
    public Integer getTotalCount(DetachedCriteria detachedCriteria) {

        //查询数据库记录条数
        detachedCriteria.setProjection(Projections.rowCount());

        List<Long> byCriteria = (List<Long>)this.getHibernateTemplate().findByCriteria(detachedCriteria);

        if (byCriteria.size()>0){

            return byCriteria.get(0).intValue();
        }


        return null;
    }

    @Override
    public void delete(Article article) {

        this.getHibernateTemplate().delete(article);
    }

    @Override
    public List<Category> getCategory(Integer parentid) {


        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Category.class);
        detachedCriteria.add(Restrictions.eq("parentid",parentid));
        List<Category> byCriteria = (List<Category>)this.getHibernateTemplate().findByCriteria(detachedCriteria);

        return byCriteria;
    }

    @Override
    public List<Article> getPageData(DetachedCriteria detachedCriteria, Integer index, Integer pageSize) {

        //清空查询总记录数的条件
        detachedCriteria.setProjection(null);


        List<Article> byCriteria = (List<Article>)this.getHibernateTemplate().findByCriteria(detachedCriteria, index, pageSize);



        return byCriteria;
    }


}
