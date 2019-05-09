<html>
<#include "../common/header.ftl">

<body>
<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal" action="/sell/seller/generalLogin">
                <span class="heading">用户登录</span>
                <div class="form-group">
                    <input type="text" class="form-control" id="userName" name="userName" placeholder="用户名或电子邮件">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group help">
                    <input type="password" class="form-control" id="passWord" name="passWord"  placeholder="密　码">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>
                <div class="form-group">
                    <div class="main-checkbox">
                        <input type="checkbox" value="None" id="checkbox1" name="check"/>
                        <label for="checkbox1"></label>
                    </div>
                    <span class="text">Remember me</span>
                    <button type="submit" class="btn btn-default">登录</button>
                </div>
            </form>
        </div>
    </div>
</div>





</body>
</html>