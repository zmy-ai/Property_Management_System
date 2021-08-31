<%--
Created by IntelliJ IDEA.
User: 明艳
Date: 2021/8/23
Time: 20:30
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 管理系统大布局 - Layui</title>
    <link rel="stylesheet" href="css/layui.css">
    <link rel="stylesheet" href="css/font-awesome.css">
    <style type="text/css">
        body{
            font-family: 华文新魏;
        }
        .myfont{
            font-size: 24px;
            font-family: 华文新魏;
        }
        .page-top{
            width: 100%;
            height: 30px;
            background-color: #ECF0F5;
        }
        .big{
            width: 80%;
            padding: 20px;
            margin: 0 auto;
            border: red solid 1px;
        }
        .big .action form:nth-child(1) input{
            height: 40px;
            width: 215px;
            border-radius: 10px;
            font-size: 20px;
            font-family: 华文新魏;
        }
        .big .action form:nth-child(1) button{
            height: 40px;
            width: 60px;
            border: none;
            background: #009f95;
            color: #FFFFFF;
            border-radius: 10px;
            font-size: 22px;
            margin-left: 10px;
        }
        table{
            margin-top: 10px;
            border-color: #fff9ec;
        }
        table tr{
            height: 45px;
        }
        table tr td,th{
            border-color: #E7E7E7;
            font-size: 20px;
        }
        table tr td{
            text-align: center;

        }
    </style>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header" >
        <div class="layui-logo layui-hide-xs layui-bg-black"><span style="color: #00F7DE;font-size: 25px;font-family: 华文新魏">物业管理平台</span></div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->
        <ul class="layui-nav layui-layout-left" >
            <!-- 移动端显示 -->
            <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-header-event="menuLeft">
                <i class="layui-icon layui-icon-spread-left"></i>
            </li>
            <!--<li class="layui-nav-item layui-hide-xs"><a href="">欢迎</a></li>
            <li class="layui-nav-item layui-hide-xs"><a href="">nav 2</a></li>-->
        </ul>
        <!--右侧头像基本信息-->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui-hide layui-show-md-inline-block">
                <a href="javascript:;">
                    <img src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" class="layui-nav-img">
                    ${Admin_username}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">个人信息</a></dd>
                    <dd><a href="">Settings</a></dd>
                    <dd><a href="">对出登录</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item" lay-header-event="menuRight" lay-unselect>
                <a href="javascript:;">
                    <i class="layui-icon layui-icon-more-vertical"></i>
                </a>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed" style="background-color: #009688">
                    <a class="" href="/user.do" target="pframe"><span class="myfont"><i class="fa fa-home" aria-hidden="true"></i>&nbsp;首页</span></a>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="building.html" target="pframe"><span class="myfont"><i class="fa fa-circle-o" aria-hidden="true"></i>&nbsp;栋楼信息</span></a>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="room.html" target="pframe"><span class="myfont"><i class="fa fa-circle-o" aria-hidden="true"></i>&nbsp;房间信息</span></a>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="index.jsp" target="pframe"><span class="myfont"><i class="fa fa-circle-o" aria-hidden="true"></i>&nbsp;房号绑定</span></a>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="index.jsp" target="pframe"><span class="myfont"><i class="fa fa-circle-o" aria-hidden="true"></i>&nbsp;车位信息</span></a>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="index.jsp" target="pframe"><span class="myfont"><i class="fa fa-circle-o" aria-hidden="true"></i>&nbsp;缴费信息</span></a>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="index.jsp" target="pframe"><span class="myfont"><i class="fa fa-circle-o" aria-hidden="true"></i>&nbsp;报修管理</span></a>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="index.jsp" target="pframe"><span class="myfont"><i class="fa fa-circle-o" aria-hidden="true"></i>&nbsp;投诉信息</span></a>
                </li>

            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 0px;">
            <div class="page-top">
                <span style="color: #777777;font-size: 18px;font-family: 华文新魏;margin: 0 auto;"><i class="fa fa-home" aria-hidden="true"></i>&nbsp;首页&nbsp;&gt;业主信息</span>
            </div>
            <div class="big">
                <div class="action">
                    <form action="selectUser.do" method="get">
                        <input type="text" name="info">
                        <button type="submit">查询</button>
                    </form>
                    <form name="myuserForm" action="myuserList.do" method="post">
                        <table width=80% border=1>
                            <tr>
                                <th>批量选择</th>
                                <th>用户名</th>
                                <th>性别</th>
                                <th>证件号</th>
                                <th>手机号</th>
                                <th>邮箱</th>
                                <th>创建时间</th>
                                <th>操作&nbsp;&nbsp;<a href="/addUser.jsp" style="color: #0000F9">添加</a>&nbsp;&nbsp;</th>
                            </tr>
                            <!-- 从第二行进行循环取值 -->
                            <c:forEach items="${list }" var="user">
                                <tr>
                                    <td><input type="checkbox" value="${user.id}" name="chick_id"></td>
                                    <td>${user.username}</td>
                                    <td>${user.sex}</td>
                                    <td>${user.idcard}</td>
                                    <td>${user.phone}</td>
                                    <td>${user.email}</td>
                                    <td>${user.createTime}</td>
                                    <td><a href="upUser.do?id=${user.id }" style="color: #0000F9">修改</a>&nbsp;&nbsp;
                                        <a href="delUser.do?id=${user.id }" style="color: #0000F9">删除</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </form>
                </div>
                </center>
            </div>
        </div>
        <div class="layui-footer">
            <!-- 底部固定区域 -->
            <i class="fa fa-at" aria-hidden="true"></i>&nbsp;物业管理平台
        </div>
    </div>
</div>
</body>
</html>