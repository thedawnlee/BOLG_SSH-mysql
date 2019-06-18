package com.dawn.web;

import com.dawn.domain.User;
import com.dawn.service.LoginService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User>{
    private User user = new User();
    @Override
    public User getModel() {
        return user;
    }

    //注入业务层
    private LoginService loginService;
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public String login(){
        System.out.println("login来了");
        System.out.println("123");
        System.out.println(user);
        //登录业务逻辑
        User login = loginService.login(user);

        if (login==null){


            this.addActionError("用户名密码错误");
            return LOGIN;
        }else{

            //保存用户信息
            ActionContext.getContext().getSession().put("User",login);

            return SUCCESS;

        }


    }

    public String loginout(){

        /*
        清空当前用户session
         */
        ActionContext.getContext().getSession().clear();
        System.out.println("tuichu");

        return "login_out";

    }
}
