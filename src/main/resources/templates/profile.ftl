<#import "parts/common.ftl" as c>
<@c.page>
    <div class="container" style="margin-top: 60px">
        <div class="row">
            <div class="col-md-6 col-md-offset-3" style="padding-top: 50px">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title" style="display: inline-block">${username!}</h3>
                    </div>
                    <div class="panel-body">
                        <form name="form"  method="post" autocomplete="off" novalidate
                              ng-submit="form.$valid ">

<#--                            TODO add check password in profile-->
                            <div class="form-group">
                                <label id="exampleInputFirstNameLabel" for="firstName">First name</label>
                                <input type="text"
                                       class="form-control"
                                       name="firstName"
                                       id="firstName"
                                       placeholder="First Name"
                                       value="${firstName!}"
                                       required>
                            </div>
                            <div class="form-group">
                                <label id="exampleInputLastNameLabel" for="lastName">Last name</label>
                                <input type="text"
                                       class="form-control"
                                       id="lastName"
                                       name="lastName"
                                       placeholder="Last Name"
                                       value="${lastName!}"
                                       required>
                            </div>
                            <div class="form-group">
                                <label id="passwordLabel" for="password">Password</label>
                                <input type="password"
                                       class="form-control"
                                       id="password"
                                       name="password"
                                       placeholder="Password"
                                       required>
                            </div>

                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            <button type="submit" class="btn btn-success" style="margin-top:30px"
                                    ng-disabled="form.$invalid">
                                Save
                            </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@c.page>