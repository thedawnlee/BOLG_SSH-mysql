package com.dawn.service.impl;

import com.dawn.dao.CategoryDao;
import com.dawn.domain.Category;
import com.dawn.service.CategoryService;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class CategoryServiceImpl implements CategoryService {


    @Setter
    private CategoryDao categoryDao;

    @Override
    public void save(Category category) {


        System.out.println("进入业务层");

        categoryDao.save(category);

    }

    @Override
    public List<Category> getAllcategory() {

        //调用DAO层查询所有分类


        List<Category> list = categoryDao.getAllcategory();
        return list;
    }

    @Override
    public Category getOneCategory(Integer cid) {

        Category category =  categoryDao.getOneCategory(cid);

        return category;
    }

    @Override
    public void update(Category category) {

        categoryDao.update(category);

    }

    @Override
    public void delete(Category category) {

        categoryDao.delete(category);

    }

}
