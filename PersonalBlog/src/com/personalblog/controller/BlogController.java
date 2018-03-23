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
//��עcontroller��
@Controller
public class BlogController {

    //�Զ�ע��
    @Autowired
    private BlogService blogservice;
    //�洢������Ϣ
    @RequestMapping("writeBlog")
    public String writeBlog(Blog blog){
                //��ȡ��ǰ����
                Date currentTime = new Date();
                 //������ת��Ϊָ����ʽ
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String dateString = formatter.format(currentTime);
                blog.setTime(dateString);
                this.blogservice.writeBlog(blog);
                return "success";
    }
    //����ȫ���ͣ�������ҳ��ʾ
    @RequestMapping("selectAllBlog")
    public String selectAllBlog(HttpServletRequest request){

        try {
            List<Blog> blogs = new ArrayList<Blog>();
            blogs =  this.blogservice.selectAllBlog();
            //����ѯ�����list����request���ظ�ҳ�棬ҳ����JSTL���ʽ��ȡ��ʾ
            request.setAttribute("blogs", blogs);
            return "index";
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    //��selectAllBlog�Ĳ���һ�������Ƿ�����ת��ҳ�治ͬ
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
    //ͨ��id���Ҳ��ͣ�������ʾ���͵�����
    @RequestMapping("selectBlogById")
    public String selectBlogById(HttpServletRequest request){
        try {
            //��ȡid��ת������
            String id = request.getParameter("blogid");
            int blogid = Integer.parseInt(id);
            List<Blog> blogs = new ArrayList<Blog>();
            blogs =  this.blogservice.selectBlogById(blogid);
            //����ѯ�������
            request.setAttribute("blog", blogs.get(0));
            return "blog";
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    //ͬ���ǲ�ѯ���в�����Ϣ�����ڹ�����
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
    //ɾ��������Ϣ
    @RequestMapping("deleteBlogById")
    public String deleteBlogById(HttpServletRequest request){
        try {
            String id = request.getParameter("blogid");
            int blogid = Integer.parseInt(id);
            //����ɾ��
            this.blogservice.deleteBlogById(blogid);
            return "redirect:adminblog";
        } catch (Exception e) {
            return null;    
        }
    }
}