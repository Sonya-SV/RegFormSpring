<#macro page>
    <!DOCTYPE HTML>
    <html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta charset="UTF-8">
        <title>Registration form</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <#--        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<#--        <script type="text/javascript">-->
<#--            $(document).ready(function () {-->
<#--                $("#locales").change(function () {-->
<#--                    var selectedOption = $('#locales').val();-->
<#--                    if (selectedOption !== '') {-->
<#--                        window.location.replace('locale?lang=' + selectedOption);-->
<#--                    }-->
<#--                });-->
<#--            });-->
<#--        </script>-->
    </head>
    <body>
    <#include "sec.ftl">
<#--    <#include "navbar.ftl">-->
    <div class="container">
        <div class="row">
            <!-- MAIN -->
            <main class="col-md-8 col-lg-9">
                <div class="header">
                    <div class="navbar-fixed-top">
                        <div class="container">
                            <div class="navbar navbar-default">
                                <a class="navbar-brand" href="/">MySite</a>
                                <ul class="nav navbar-nav">
                                    <li><a href="/main">Main</a></li>
                                    <#if isAdmin>
                                        <li><a href="/user">Users</a></li>
                                    </#if>
                                    <#if user??>
                                        <li><a href="/profile">Profile</a></li>
                                    </#if>
                                </ul>
                                <ul class="nav navbar-nav navbar-right">
                                    <#if name=="">
                                        <li><a href="/reg"><span class="glyphicon glyphicon-user"></span> Sign Up </a>
                                        </li>
                                        <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login </a>
                                        </li>
                                    <#else>
                                        <li><a><span class="glyphicon glyphicon-user"></span> Hello, ${name}</a></li>
                                        <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span>Log
                                                out</a>
                                        </li>
                                    </#if>
                                </ul>

                                <#--                                <#if (language.change)??>-->
                                <#--                                <span th:text="#{language.change}"></span>:-->
                                <#--&lt;#&ndash;                                </#if>&ndash;&gt;-->
                                <#--                                <label for="locales">-->
                                <#--                                    <select id="locales">-->
                                <#--                                        <option value=""></option>-->
                                <#--                                        <option value="en" th:text="#{lang.eng}">EN</option>-->
                                <#--                                        <option value="uk" th:text="#{lang.uk}">UA</option>-->
                                <#--                                    </select>-->
                                <#--                                </label>-->

                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </div>

    <div class="container theme-showcase" role="main">
        <#nested >
    </div>
   <#include "footer.ftl">
    </body>
    </html>

</#macro>