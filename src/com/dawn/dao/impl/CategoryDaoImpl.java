package com.dawn.dao.impl;

import com.dawn.dao.CategoryDao;
import com.dawn.domain.Category;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class CategoryDaoImpl extends HibernateDaoSupport implements CategoryDao {
    @Override
    public void save(Category category) {

        System.out.println("进入Dao层");


        this.getHibernateTemplate().save(category);


    }

    @Override
    public List<Category> getAllcategory() {

        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Category.class);

        List<Category> byCriteria = (List<Category>) this.getHibernateTemplate().findByCriteria(detachedCriteria);


        return byCriteria;
    }

    @Override
    public Category getOneCategory(Integer cid) {

        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Category.class);


        detachedCriteria.add(Restrictions.eq("cid", cid));

        List<Category> byCriteria = (List<Category>)this.getHibernateTemplate().findByCriteria(detachedCriteria);


        if(byCriteria.size()>0){

            return byCriteria.get(0);

        }
        return null;
    }

    @Override
    public void update(Category category) {


        this.getHibernateTemplate().update(category);
    }

    @Override
    public void delete(Category category) {
        this.getHibernateTemplate().delete(category);

    }


}
