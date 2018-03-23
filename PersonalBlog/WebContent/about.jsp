<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>about</title>
        <link a href="css/index.css" rel="stylesheet"/>
        <link a href="css/about.css" rel="stylesheet"/>
        <script type="text/javascript" src="js/alert.js" ></script>
</head>
<body>
<header>
  <div id="logo"><a href="selectAllBlog"></a></div>
  <nav class="topnav" id="topnav">
      <a href="selectAllBlog"><span>Home</span><span class="en">主页</span></a>
      <a href="about.jsp"><span>About</span><span class="en">关于我</span></a>
     <a href="selectAllDiary"><span>Diary</span><span class="en">日记心得</span></a>
      <a href="gustbook.jsp"><span>Gustbook</span><span class="en">留言板</span></a>
      <a href="#" onclick="fun1()"><span>Admin</span><span class="en">管理</span></a>
  </nav>
</header>
<article class="aboutcon">
<h1 class="t_nav"><span>止于至善</span></h1><br />
<div class="about">
  <h2>About me</h2><br />
  <div id="me_text">
       <p>实验楼<a href="https://www.shiyanlou.com/courses/930" target="_blank">《Java实现个人博客项目》</a>学习示例。</p>

  </div>

</div>
<aside class="left">  
    <div class="about_c">
        <br />
    <p>Github: <a href="https://github.com/xiajava" target="_blank">@xiajava</a></p>

</div>     
</aside>
</article>
<footer>
<p>
    <span>网站地图</span>
    <span>网站统计</span>
</p>
</footer>
<script src="js/nav.js"></script>
</body>
<script type="text/javascript" src="js/alert.js" ></script>
</html>