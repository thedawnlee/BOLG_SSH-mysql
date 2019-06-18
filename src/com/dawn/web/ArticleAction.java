package com.dawn.web;

import com.dawn.domain.Article;
import com.dawn.domain.Category;
import com.dawn.domain.PageBean;
import com.dawn.service.ArticleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Setter;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.io.IOException;
import java.util.List;

public class ArticleAction extends ActionSupport {




    @Setter
    private ArticleService articleService;


    @Setter
    private Integer parentid;

    public String list() throws IOException {

        System.out.println("进入web层");
        List<Article> allArticle = articleService.getAllArticle();


        System.out.println(allArticle);


        ActionContext.getContext().getValueStack().set("allArticle",allArticle);




        return "list";
    }

    @Setter
    private Integer currPage=1;


    //关键字
    @Setter
    private String KeyWord;

    public String pageList(){

        System.out.println("=======");
        System.out.println(KeyWord);
        System.out.println("=======");
        System.out.println(currPage);
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Article.class);


        //设置条件
        if(KeyWord!=null){

            detachedCriteria.add(Restrictions.like("article_title","%"+KeyWord+"%"));



        }


        PageBean pageBean =  articleService.getPageData(detachedCriteria,currPage,5);



        ActionContext.getContext().getValueStack().push(pageBean);

        return "list";
    }

    @Setter
    private Integer article_id;

    public String delete(){

        //调用业务层

        Article article = new Article();


        article.setArticle_id(article_id);


        articleService.delete(article);

        return "delete";
    }





    public String getCategory() throws IOException {
        System.out.println(parentid);
        System.out.println(parentid);

        List<Category> category = articleService.getCategory(parentid);
        System.out.println(category);
        JSONArray jsonArray = JSONArray.fromObject(category, new JsonConfig());


        System.out.println(jsonArray);



        ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");


        ServletActionContext.getResponse().getWriter().println(jsonArray.toString());

        return null;
    }

    public String addtext(){

        System.out.println(parentid);
        return null;


    }
}
