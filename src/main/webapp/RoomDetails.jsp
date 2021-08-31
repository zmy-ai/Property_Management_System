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
            font-size: 50px;
        }
        table tr td{
            text-align: center;

        }

        .layui-btn {
            font-size: 20px;
        }
        .layui-table thead tr th{
            font-size:20px ;
            text-align: center;
        }
        .layui-table tbody tr td{
            font-size:20px ;
        }
        .layui-table tbody tr td a{
            margin-left: 4px;
            border: none;
            width: 180px;
            height: 60px;
            color: #FFFFFF;
            padding: 10px;
        }
        .layui-table tbody tr td a:nth-child(1){
            background: #009688;
        }
        .layui-table tbody tr td a:nth-child(2){
            background: #FF5722;
        }
        .big .Form{
            display: inline-block;
        }
        .big .Form input:nth-child(1){
            height: 36px;
            width: 200px;
            border: #EEEEEE solid 1px;
            border-radius: 5px;
            font-size: 20px;
        }
        .big .Form input:nth-child(2){
            height: 36px;
            width: 65px;
            border-radius: 5px;
            background: #FFFFFF;
            border: #eeeeee solid 2px;
            font-size: 20px;
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
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="/room_bingding.do" style="background-color: #009688"><span class="myfont"><i class="fa fa-circle-o" aria-hidden="true"></i>&nbsp;房号绑定</span></a>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 0px;">
            <div class="page-top">
                <span style="color: #777777;font-size: 18px;font-family: 华文新魏;margin: 0 auto;"><i class="fa fa-home" aria-hidden="true"></i>&nbsp;首页&nbsp;&gt;房间号绑定&gt;绑定详情</span>
            </div>
            <div class="big"  >
                <form action="" method="get" name="Fname">
                <table class="layui-table" lay-data="{width: 1005, height:800, page:true}">
                    <thead>
                    <tr>
                        <th lay-data="{field:'src', width:117}">批量操作</th>
                        <th lay-data="{field:'username', width:140, sort: true}">所属楼栋</th>
                        <th lay-data="{field:'sex', width:120}">所属单元</th>
                        <th lay-data="{field:'idcard', width:260, sort: true}">房间号</th>
                        <th lay-data="{field:'phone', width:180}">面积（平方米）</th>
                        <th lay-data="{field:'abc', width:180}">操作</th>
                    </tr>
                    </thead>
                        <tbody>
                        <c:forEach items="${list}" var="room">
                            <tr>
                                <td><input type="checkbox" value="${room.room_id }" name="chick"></td>
                                <td>${room.floor_name}</td>
                                <td>${room.floor_unit}</td>
                                <td>${room.room_number}</td>
                                <td>${room.room_area}</td>
                                <td><a href="/relieveRoom.do?id=${room.room_id}&user_id=${room.user_id}">解除绑定</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                </table>
                </form>
                <script src="js/layui.js" charset="utf-8"></script>
                <!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->
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