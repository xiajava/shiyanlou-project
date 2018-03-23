<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AdminBlog</title>
<link href="css/index.css" rel="stylesheet">
</head>
<body>
<header>
  <div id="logo"><a href="selectAllBlog2"></a></div>
   <nav class="topnav" id="topnav">
       <a href="selectAllBlog"><span>Home</span><span class="en">主页</span></a>
      <a href="adminblog"><span>Admin Blog</span><span class="en">管理博客</span></a>
     <a href="admindiary"><span>Admin Diary</span><span class="en">管理日记</span></a>
      <a href="writeblog.jsp"><span>Write Blog</span><span class="en">写博客</span></a>
       <a href="writediary.jsp"><span>Write Diary</span><span class="en">写日记</span></a>
  </nav>
</header>

    <article>
        <h2 class="title">文章列表</h2>
        <br>
        <br><br>

        <div class="bloglist">
            <div class="wz">
            <c:forEach items="${blogs}" var="blogs">
                <h3><c:out value="${blogs.blogtitle}"/></h3>

    <ul>

      <a title="Delete"  href="deleteBlogById?blogid=<c:out value="${blogs.blogid}"/>" class="readmore">Delete>></a>
    </ul>
    </c:forEach>
    <div class="clear"></div>
    </div>
            </div>
            </div>
    </body>
    <script type="text/javascript" src="js/alert.js" ></script>
</html>