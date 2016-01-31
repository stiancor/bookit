<!doctype html>
<html>
<head>
    <asset:stylesheet href="login.css"/>
    <title>Login</title>
    <meta name="layout" content="main">
    <g:if env="development"><asset:stylesheet src="errors.css"/></g:if>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="pr-wrap">
                <div class="pass-reset">
                    <label>
                        Enter the email you signed up with</label>
                    <input type="email" placeholder="Email"/>
                    <input type="submit" value="Submit" class="pass-reset-submit btn btn-success btn-sm"/>
                </div>
            </div>

            <div class="wrap">
                <p class="form-title">
                    Sign In</p>

                <form class="login" action="/login/authenticate">
                    <input type="text" placeholder="Email"/>
                    <input type="password" placeholder="Password"/>
                    <input type="submit" value="Sign In" class="btn btn-success btn-sm"/>

                    <div class="remember-forgot">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox"/>
                                        Remember Me
                                    </label>
                                </div>
                            </div>

                            <div class="col-md-6 forgot-pass-content">
                                <a href="javascription:void(0)" class="forgot-pass">Forgot Password</a>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

</div>
</body>
</html>