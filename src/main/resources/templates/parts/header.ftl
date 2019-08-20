<div class="header">
    <nav class="navbar nav-tabs fixed-top navbar-light" id="nav-tab" role="tablist">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">MySite</a>
            </div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="/main"">Main Page</a></li>
                <#if isAdmin>
                    <li ><a href="/user">Users</a></li>
                </#if>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/reg"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a>
                </li>
            </ul>
            <#--                    <a href="<%=request.getContextPath()%>?languageVar=en">EN</a>-->
            <#--                    <a href="<%=request.getContextPath()%>?languageVar=ru">RU</a>-->
    </nav>
</div>
