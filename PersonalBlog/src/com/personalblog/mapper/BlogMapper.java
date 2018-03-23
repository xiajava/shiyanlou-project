package com.personalblog.mapper;

import java.util.List;

import com.personalblog.model.Blog;

public interface BlogMapper {

    void writeBlog(Blog blog);

    List<Blog> selectAllBlog();

    List<Blog> selectBlogById(int blogid);

    void deleteBlogById(int blogid);

}