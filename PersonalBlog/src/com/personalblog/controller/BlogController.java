package com.personalblog.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.personalblog.model.Blog;
import com.personalblog.service.BlogService;
//标注controller层
@Controller
public class BlogController {

    //自动注解
    @Autowired
    private BlogService blogservice;
    //存储博客信息
    @RequestMapping("writeBlog")
    public String writeBlog(Blog blog){
                //获取当前日期
                Date currentTime = new Date();
                 //将日期转化为指定格式
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String dateString = formatter.format(currentTime);
                blog.setTime(dateString);
                this.blogservice.writeBlog(blog);
                return "success";
    }
    //查找全博客，用于主页显示
    @RequestMapping("selectAllBlog")
    public String selectAllBlog(HttpServletRequest request){

        try {
            List<Blog> blogs = new ArrayList<Blog>();
            blogs =  this.blogservice.selectAllBlog();
            //将查询结果的list放入request返回给页面，页面用JSTL表达式获取显示
            request.setAttribute("blogs", blogs);
            return "index";
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    //与selectAllBlog的操作一样，但是返回跳转的页面不同
    @RequestMapping("selectAllBlog2")
    public String selectAllBlog2(HttpServletRequest request){

        try {
            List<Blog> blogs = new ArrayList<Blog>();
            blogs =  this.blogservice.selectAllBlog();
            System.out.println("title:"+blogs.get(0).getBlogtitle());
            request.setAttribute("blogs", blogs);
            return "admin";
        } catch (Exception e) {
            System.out.println(e);
            return "admin";
        }
    }
    //通过id查找博客，用于显示博客的正文
    @RequestMapping("selectBlogById")
    public String selectBlogById(HttpServletRequest request){
        try {
            //获取id并转化类型
            String id = request.getParameter("blogid");
            int blogid = Integer.parseInt(id);
            List<Blog> blogs = new ArrayList<Blog>();
            blogs =  this.blogservice.selectBlogById(blogid);
            //将查询结果返回
            request.setAttribute("blog", blogs.get(0));
            return "blog";
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    //同样是查询所有博客信息，用于管理博客
    @RequestMapping("adminblog")
    public String adminblog(HttpServletRequest request){
        try {
            List<Blog> blogs = new ArrayList<Blog>();
            blogs =  this.blogservice.selectAllBlog();
            request.setAttribute("blogs", blogs);
            return "adminblog";
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    //删除博客信息
    @RequestMapping("deleteBlogById")
    public String deleteBlogById(HttpServletRequest request){
        try {
            String id = request.getParameter("blogid");
            int blogid = Integer.parseInt(id);
            //调用删除
            this.blogservice.deleteBlogById(blogid);
            return "redirect:adminblog";
        } catch (Exception e) {
            return null;    
        }
    }
}