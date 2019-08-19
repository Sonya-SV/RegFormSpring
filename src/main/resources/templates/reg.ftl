<#import "parts/common.ftl" as c>
<@c.page>
    <div class="container" style="margin-top: 60px">
        <div class="row">
            <div class="col-md-6 col-md-offset-3" style="padding-top: 50px">
                <div class="panel panel-default">
                    <div class=" panel-heading">
                        <h3 class="panel-title" style="display: inline-block">Registration</h3>
                    </div>
                    <div class="panel-body">
                        <h3 style="color: red">${message!}</h3>
                        <form action="/reg" method="post" autocomplete="off" novalidate
                              ng-submit="form.$valid ">

                            <div class="form-group">
                                <label id="usernameLabel" for="username"> Username</label>
                                <input type="text"
                                       class="form-control"
                                       name="username"
                                       id="username"
                                       placeholder="username"
                                       required>
                            </div>
                            <div class="form-group">
                                <label id="exampleInputFirstNameLabel" for="firstName">First name</label>
                                <input type="text"
                                       class="form-control"
                                       name="firstName"
                                       id="firstName"
                                       placeholder="First Name"
                                       required>
                                <!--                   ng-model="auth.firstName">-->
                            </div>
                            <div class="form-group">
                                <label id="exampleInputLastNameLabel" for="lastName">Last name</label>
                                <input type="text"
                                       class="form-control"
                                       id="lastName"
                                       name="lastName"
                                       placeholder="Last Name"
                                       required>
                            </div>
                            <div class="form-group">
                                <label id="exampleInputPasswordLabel" for="password">Password</label>
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
                                Registration
                            </button>
                        </form>
                    </div>

                </div>
            </div>
        </div>
    </div>
</@c.page>