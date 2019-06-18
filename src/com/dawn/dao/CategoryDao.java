package com.dawn.dao;

import com.dawn.domain.Category;

import java.util.List;

public interface CategoryDao {

    public void save(Category category);

    List<Category> getAllcategory();

    Category getOneCategory(Integer cid);


    void update(Category category);

    void delete(Category category);
}
