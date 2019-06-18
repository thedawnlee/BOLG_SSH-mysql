package com.dawn.web;

import com.dawn.domain.Category;
import com.dawn.service.CategoryService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.util.List;

public class CategoryAction extends ActionSupport implements ModelDriven<Category> {


    private Category category = new Category();

    public void setCategory(Category category) {
        this.category = category;
    }


    private CategoryService categoryService;

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public Category getModel() {
        return category;
    }


    public String add(){


        System.out.println("category_action---");
        categoryService.save(category);
        System.out.println(category);

        return "listAction";

    }

    public String list(){

        System.out.println("list");


        List<Category> list = categoryService.getAllcategory();
        System.out.println(list);
        //把数据存到ValueStack中
        ActionContext.getContext().getValueStack().set("categoryList",list);
        return "list";



    }

    public String updateUI() throws IOException {
        System.out.println("updateUI------");

        System.out.println(category);

        // invoke service
        Category category2 = categoryService.getOneCategory(category.getCid());


        System.out.println(category2);

        //把数据给页面

        //json()形式响应给页面

        //json是一个数据格式

        JSONArray jsonArray = JSONArray.fromObject(category2, new JsonConfig());


        System.out.println(jsonArray);


        ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");


        ServletActionContext.getResponse().getWriter().println(jsonArray.toString());



        return null;
    }

    public String  update(){




        System.out.println(category);


        categoryService.update(category);

        return "listAction";

    }
    public String delete(){


        System.out.println("数据即将删除"+category.getCid());

        categoryService.delete(category);

        return "listAction";
    }

}
