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
       .myfont{
           font-size: 19px;
           font-family: 华文新魏;
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
                    <dd><a href="">Your Profile</a></dd>
                    <dd><a href="">Settings</a></dd>
                    <dd><a href="">Sign out</a></dd>
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
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="/user.do"><span class="myfont"><i class="fa fa-home" aria-hidden="true"></i>&nbsp;业主信息</span></a>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="/Floorshow.do"><span class="myfont"><i class="fa fa-circle-o" aria-hidden="true"></i>&nbsp;栋楼信息</span></a>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="/roomshow.do" ><span class="myfont"><i class="fa fa-circle-o" aria-hidden="true"></i>&nbsp;房间信息</span></a>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="/room_bingding.do"><span class="myfont"><i class="fa fa-circle-o" aria-hidden="true"></i>&nbsp;房号绑定</span></a>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="/Carshow.do" ><span class="myfont"><i class="fa fa-circle-o" aria-hidden="true"></i>&nbsp;车位信息</span></a>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="/showPay.do"><span class="myfont"><i class="fa fa-circle-o" aria-hidden="true"></i>&nbsp;缴费信息</span></a>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="/showMaintain.do" ><span class="myfont"><i class="fa fa-circle-o" aria-hidden="true"></i>&nbsp;报修管理</span></a>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="/Complaintshow.do"><span class="myfont"><i class="fa fa-circle-o" aria-hidden="true"></i>&nbsp;投诉信息</span></a>
                </li>

            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 5px;">
            欢迎进小区物业管理系统--&gt;--&gt;
        </div>
    </div>
    <div class="layui-footer">
        <!-- 底部固定区域 -->
        <i class="fa fa-at" aria-hidden="true"></i>&nbsp;物业管理平台
    </div>
</div>
<script src="js/layui.js">
</script>
</body>
</html>