<%--
  Created by IntelliJ IDEA.
  User: xuanzilan
  Date: 2018/6/9
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>SpringMVC</title>
  </head>
  <body>
  普通表格
  <form method="post" action="/my/submit.do">
    姓名：<input placeholder="请输入姓名" name="name" type="text"><br/>
    年龄：<input placeholder="请输入年龄" name="age" type="number"><br/>
    <input type="submit" value="注册">
  </form>

  <br/>
  利用参数校验器
  <form method="post" action="/my/submit1.do">
    姓名：<input placeholder="请输入姓名" name="pname" type="text"><br/>
    年龄：<input placeholder="请输入年龄" name="age" type="number"><br/>
    <input type="submit" value="注册">
  </form>

  <br/>
  传入对象
  <form method="post" action="/my/submit2.do">
    姓名：<input placeholder="请输入姓名" name="name" type="text"><br/>
    年龄：<input placeholder="请输入年龄" name="age" type="number"><br/>
    学校：<input placeholder="请输入学校名" name="school.sname" type="text"><br/>
    校址：<input placeholder="请输入学校地址" name="school.addr" type="text"><br/>
    <input type="submit" value="注册">
  </form>
  </body>
</html>
