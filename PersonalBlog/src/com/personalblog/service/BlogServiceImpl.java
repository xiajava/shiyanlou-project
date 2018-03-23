package com.personalblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalblog.mapper.BlogMapper;
import com.personalblog.model.Blog;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    private  BlogMapper blogMapper;

    @Override
    public void writeBlog(Blog blog) {
        System.out.println(blog.getArticle());
        blogMapper.writeBlog(blog);
    }

    @Override
    public List<Blog> selectAllBlog() {
        List<Blog> blogs = this.blogMapper.selectAllBlog();
        return blogs;
    }

    @Override
    public List<Blog> selectBlogById(int blogid) {
        List<Blog> blogs = this.blogMapper.selectBlogById(blogid);
        return blogs;
    }

    @Override
    public void deleteBlogById(int blogid) {
        blogMapper.deleteBlogById(blogid);

    }

}