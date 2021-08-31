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
            width: 50%;
        }
        table tr{
            height: 40px;
        }
        table tr td,th{
            border-color: #E7E7E7;
            font-size: 20px;
        }
        table tr td{
            *text-align: center;

        }
        table tr td input{
            height:38px ;
            font-size:20px ;
            border: none;
        }
        .big .action form button {
            height: 40px;
            width: 60px;
            border: none;
            background: #009f95;
            color: #FFFFFF;
            border-radius: 10px;
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
                <li class="layui-nav-item layui-nav-itemed" style="background-color: #009688">
                    <a class="" href="/user.do" target="pframe"><span class="myfont"><i class="fa fa-home" aria-hidden="true"></i>&nbsp;添加业主信息</span></a>
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
                    <center>
                        <form name="user" action="saveCar.do" method="post" onsubmit=" return validate()">
                            <table width=70% border=1>
                                <tr>
                                    <th colspan="2">修改车位信息</th>

                                </tr>
                                <tr>
                                    <th>车位号</th>
                                    <td><input type="text" id="car_id" name="car_id"></td>
                                </tr>
                                <tr>
                                    <th>类型</th>
                                    <td>
                                        <select name="type">
                                            <option>标准型车位</option>
                                            <option>大型车位</option>
                                            <option>小型车位</option>
                                            <option>超大型车位</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th>业主</th>
                                    <td>
                                        <select name="home">
                                            <option>无</option>
                                            <c:forEach items="${list}" var="user">
                                                <option>${user.username}_${user.idcard}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th>截止日期</th>
                                    <td> <input type="datetime-local" class="measureDate"  value="1900/01/01" name="outTime"></td>
                                </tr>
                                <tr>
                                    <th colspan="2"><button type="submit" >保存</button></th>
                                </tr>
                            </table>
                        </form>
                    </center>
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
<%--<script src="https://cdn.bootcss.com/jquery/3.5.0/jquery.js"></script>--%>
<%--<script type="text/javascript">
    let date = new Date()
    let yyyy = date.getFullYear()
    let MM = (date.getMonth() + 1) < 10 ? ("0" + (date.getMonth() + 1)) : (date.getMonth() + 1)
    let dd = date.getDate() < 10 ? ("0" + date.getDate()) : date.getDate()
    let HH = date.getHours() < 10 ? ("0" + date.getHours()) : date.getHours()
    let mm = date.getMinutes() < 10 ? ("0" + date.getMinutes()) : date.getMinutes()
    let curDay = yyyy + '-' + MM + '-' + dd + 'T' + HH + ':' + mm;
    $('.measureDate').val(curDay)
    console.log(date)
</script>--%>
<script type="text/javascript">
    function validate() {
        var car_id = document.getElementById("car_id");
        if (car_id.value==""){
            alert("车位号不能为空！");
            return false;
        }
        return true;
    }
</script>
</body>
</html>