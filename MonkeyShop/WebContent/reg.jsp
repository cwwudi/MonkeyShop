<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <link rel="stylesheet" type="text/css" href="layDate/laydate/theme/default/laydate.css"/>
    <script src="js/jquery-1.12.4.min.js"></script>
    <script src="layDate/laydate/laydate.js"></script>
    <script src="js/function.js"></script>
</head>
<body><!-------------------reg-------------------------->
<div class="reg">
    <form action="register" method="post" onsubmit="return checkForm(this)"><h1><a href="index.html"><img src="img/temp/logo.png"></a></h1>
        <h1 style="padding: 0px;margin: 0px;font-size: 30px;background: #3344AA;text-align: center;line-height: 60px;color: #FFFFFF">用户注册</h1>
        <p><input type="text" name="userId" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)"    placeholder="请输入用户名"><span></span></p>
        <p><input type="text" name="UserName" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输姓名"><span></span></p>
        <p><input type="password" name="password" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入密码"><span></span></p>
        <p><input type="password" name="rePassword" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请确认密码"><span></span></p>
        
        <p>
        	<input style="width:15px;height: 15px" type="radio" name="sex" value="T" checked="checked" >男
        	<input style="width:15px;height: 15px" type="radio" name="sex" value="F">女
        </p>
        
        <p><input type="text" name="birthday" id="birthday" value=""  placeholder="请输入出生日期"><span></span></p>
        <p><input type="text" name="email" value=""  placeholder="请输入邮箱"><span></span></p>
        <p><input type="text" name="mobile" value=""  placeholder="请输入手机号"><span></span></p>
        <p><input type="text" name="address" value=""  placeholder="请确认地址"><span></span></p>
        <p><input class="code" type="text" name="code" onfocus="FocusItem(this)" onblur="CheckItem(this)" value="" placeholder="验证码"><img src="getcode" alt="看不清，换一张" onclick="change(this)"><span></span></p>
                
        <p><input type="submit" name="" value="注册"></p>
        <p class="txtL txt">完成此注册，即表明您同意了我们的<a href="#">
            <使用条款和隐私策略>
        </a></p>
        <p class="txt"><a href="#"><span></span>已有账号登录</a></p>
        <!--<a href="#" class="off"><img src="img/temp/off.png"></a>--></form>
</div>

<script>
    laydate.render({
        elem: '#birthday' //指定元素
    });

</script>
</body>
</html>