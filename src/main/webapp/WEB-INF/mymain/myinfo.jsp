<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>订单管理-车速递</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mymain.mymain.css">
    <script type="application/javascript"
            src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.js"></script>
    <script type="application/javascript"
            src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue"></script>

</head>
<body style="position: static">

<div id="app" class="bgGray">
    <div data-v-95ac8d30="" class="header3">
        <div data-v-95ac8d30="" class="layout clear">
            <div data-v-95ac8d30="" class="left logo">
                <a data-v-95ac8d30="" href="index.html">
                    <img data-v-95ac8d30=""
                         src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAKYAAAAqCAYAAAA5+iDUAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAA3FpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNS1jMDE0IDc5LjE1MTQ4MSwgMjAxMy8wMy8xMy0xMjowOToxNSAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDo1NWY1ODZmZS0yNGNjLTg2NGMtODFmMi0yNjYzODhhNjczYTMiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6QjgwRkFGQ0U4MzFDMTFFNzkzM0FCMEZGM0ZFMDMzQ0UiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6QjgwRkFGQ0Q4MzFDMTFFNzkzM0FCMEZGM0ZFMDMzQ0UiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIChXaW5kb3dzKSI+IDx4bXBNTTpEZXJpdmVkRnJvbSBzdFJlZjppbnN0YW5jZUlEPSJ4bXAuaWlkOmU1YTliNDEzLTU2NDEtMDc0MS05OTA2LTZhNDg5YjU1NzNlYyIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDo1NWY1ODZmZS0yNGNjLTg2NGMtODFmMi0yNjYzODhhNjczYTMiLz4gPC9y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">
                </a>
            </div>
            <div data-v-95ac8d30="" class="header3Nav right">|<a data-v-95ac8d30="" href="orderManage.html">我的订单</a>|<a
                    data-v-95ac8d30="" href="helpCenter.html">帮助中心</a>|<a data-v-95ac8d30=""
                                                                          href="${pageContext.request.contextPath}/view/quit">退出</a>
            </div>
            <div data-v-95ac8d30="" class="header3User right">
                <i data-v-95ac8d30="" class="iconfont icon-phone"></i>
                <span data-v-95ac8d30="" class="sp1">400-919-8000</span>
                <span data-v-95ac8d30="" class="sp2">欢迎您，${sessionScope.USERNAME}</span>
                <span data-v-95ac8d30="" class="sp3"></span>
            </div>
        </div>
    </div>
    <div class="userInfo">
        <div class="layout">
            <div class="userInfoCom clear">
                <div class="userInfoL left">
                    <div data-v-1cae2c34="" class="userNav">
                        <dl data-v-1cae2c34="" class="userMsg">
                            <dt data-v-1cae2c34="">
                                <img data-v-1cae2c34=""
                                     src="data:image/png;base64,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">
                            </dt>
                            <dd data-v-1cae2c34="">
                                <p data-v-1cae2c34=""></p>
                                <p data-v-1cae2c34="" class="p5 pp" style="">普卡会员</p>
                            </dd>
                        </dl>
                        <ul data-v-1cae2c34="" class="manNav">
                            <li data-v-1cae2c34="">
                                <a data-v-1cae2c34="" href="${pageContext.request.contextPath}/view/myMain" class="">订单管理</a>
                            </li>
                            <li data-v-1cae2c34="">
                                <a data-v-1cae2c34="" href="${pageContext.request.contextPath}/view/user" class="sel">个人信息</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="userInfoR right">

                    <div class="orderManage manage">
                        <div class="orderManageTit manageTit clear">
                            <div class="left tit">个人信息</div>
                        </div>
                        <div class="site-demo-button" id="layerDemo" style="margin-bottom: 0;">
                            <div class="orderList list" id="noda">
                                <table class="tableinfo">
                                    <tr>
                                        <td>手机号：{{tel}}</td>
                                        <td>
                                            <button data-method="offset" data-type="auto"
                                                    class="layui-btn layui-btn-normal">修改
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>邮箱：{{email}}</td>
                                        <td><a href="#" style="color: orangered">修改</a></td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td>
                                            <a href="#" style="color: orangered">修改密码</a>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div data-v-3aaf9db2="" class="footer2">
        <div data-v-3aaf9db2="" class="layout clear">
            <div data-v-3aaf9db2="" class="d1">
                <a data-v-3aaf9db2="" href="${pageContext.request.contextPath}/view/about">关于车速递</a></div>
        </div>
    </div>

</div>

<script type="text/javascript">
    var vm = new Vue({
        el: '#noda',
        data: {
            tel: '',
            email: ''
        },
    });

    $(function () {
        $.ajax({
            type: "get",
            url: "${pageContext.request.contextPath}/user/loginTel",
            dataType: "json",
            success: function (data) {
                //id为0时为父类
                if (data.code == 1) {
                    vm.tel = data.info.tel;
                    vm.email = data.info.email;
                }
            }
        });
    })

</script>


<script>
    layui.use('layer', function () { //独立版的layer无需执行这一句
        var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句

        //触发事件
        var active = {
            setTop: function () {
                var that = this;
                //多窗口模式，层叠置顶
            }
            , offset: function (othis) {
                var type = othis.data('type')
                    , text = othis.text();

                layer.open({
                    type: 1
                    ,
                    offset: type //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
                    ,
                    id: 'layerDemo' + type //防止重复弹出
                    ,
                    content: '<div style="width: 300px; height: 200px;">' +
                        '<form>' +
                        '请输入修改后的手机号：<br>' +
                        '<input type="text" name="tel" id="tel"><br/>'
                        + '请输入修改后的邮箱：<br>' +
                        '<input type="text" name="email" id="email"><br/>'
                        + '请输入修改后的密码：<br>' +
                        '<input type="text" name="password" id="password"><br/>' +
                        '</form>' +
                        '</div>'
                    ,
                    btn: '修改'
                    ,
                    btnAlign: 'c' //按钮居中
                    ,
                    shade: 0 //不显示遮罩
                    ,
                    yes: function () {
                        $.ajax({
                            url: "${pageContext.request.contextPath}/user/update",
                            type: "post",
                            data: $("form").serialize(),
                            dataType: 'json',
                            success: function (msg) {
                                alert("修改成功");
                                window.location.href = ("${pageContext.request.contextPath}/view/quit");
                            },
                            error: function () {
                                elert("ajax错误");
                            }
                        });


                    }
                });
            }
        };

        $('#layerDemo .layui-btn').on('click', function () {
            var othis = $(this), method = othis.data('method');
            active[method] ? active[method].call(this, othis) : '';
        });
    });
</script>


</body>
</html>
dy>
</html>