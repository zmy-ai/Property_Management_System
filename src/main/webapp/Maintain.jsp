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
    <link rel="stylesheet" href="/css/layui.css">
    <link rel="stylesheet" href="/css/font-awesome.css">
    <style type="text/css">
        body{
            font-family: 华文新魏;
        }
        .myfont{
            font-size: 19px;
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
        .layui-table tbody tr td:nth-child(8) input{
            border: none;
        }
        .layui-table tbody tr td a:nth-child(1){
            background: #009688;
        }
        .layui-table tbody tr td a:nth-child(2){
            background: #FF5722;
        }

    </style>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header" >
        <div class="layui-logo layui-hide-xs layui-bg-black"><a href="Home.jsp"><span style="color: #00F7DE;font-size: 25px;font-family: 华文新魏">物业管理平台</span></a></div>
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
                    ${user_account.username}
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
                    <a class="" href="/showMaintain.do" style="background-color: #009688"><span class="myfont"><i class="fa fa-circle-o" aria-hidden="true"></i>&nbsp;报修管理</span></a>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="/Complaintshow.do" target="pframe"><span class="myfont"><i class="fa fa-circle-o" aria-hidden="true"></i>&nbsp;投诉信息</span></a>
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
            <div class="big"  >
                <form action="" method="get" name="Fname">
                <table class="layui-table" lay-data="{width: 1598, height:800, page:true}">
                    <thead>
                    <tr>
                        <th lay-data="{field:'src', width:117}">批量操作</th>
                        <th lay-data="{field:'title', width:160, sort: true}">报修标题</th>
                        <th lay-data="{field:'detail', width:260}">报修详情</th>
                        <th lay-data="{field:'username', width:150, sort: true}">报修人</th>
                        <th lay-data="{field:'address', width:180}">地址</th>
                        <th lay-data="{field:'phone', width:180}">联系电话</th>
                        <th lay-data="{field:'property_state', width:180, sort: true}">物业完成状态</th>
                        <th lay-data="{field:'user_state', width:180, sort: true}">用户确认状态</th>
                        <th lay-data="{field:'abc', width:180}">操作</th>
                    </tr>
                    </thead>
                        <tbody>
                        <input type="text" value="${user_account.id}" name="userId" hidden/>
                        <c:forEach items="${list}" var="maintain">
                            <tr>
                                <td><input type="checkbox" value="${maintain.id }" name="chick"></td>
                                <td>${maintain.title}</td>
                                <td>${maintain.detail}</td>
                                <td>${maintain.name}</td>
                                <td>${maintain.address}</td>
                                <td>${maintain.phone}</td>
                                <td>${maintain.property_state}</td>
                                <td >${maintain.user_state}</td>
                                <td><a href="/updateMaintain.do?id=${maintain.id}&userId=${user_account.id}">确认</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                </table>
                </form>
                <script src="js/layui.js" charset="utf-8"></script>
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