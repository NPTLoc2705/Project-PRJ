<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />

        <title>Classic - Responsive Bootstrap 4.0 Template</title>

        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,400"
            />

        <link rel="stylesheet" href="CSS/bootstrap.min.css" />

        <link rel="stylesheet" href="CSS/templatemo-style.css" />

    </head>
    <body>
        <%@ include file="/nav.jsp" %>

        <div class="container" id="container">
            <div class="form-container sign-up">
                <form action="./SignUp" method = "Post">
                    <h1>Create Account</h1>
                    <span>or use your email for registeration</span>
                    <input type="text" placeholder="Name" name="user" />
                    <input type="email" placeholder="Email" name="email" />
                    <input type="password" placeholder="Ex:123" name="pass" />
                    <button>Sign Up</button>

                </form>
            </div>
            <div class="form-container sign-in">
                <form action="./Login" method="post">
                    <h1>Sign In</h1>
                    <span>or use your email password</span>
                    <input type="text" placeholder="Email or User Name" name="user" />
                    <input type="password" placeholder="Ex:123" name="pass" />
                    <a href="#">Forget Your Password?</a>
                    <style>
                        h3{
                            color:red;
                            font-size:80%;
                        }
                        
                    </style>
                    <% String error = (String) request.getAttribute("error"); %>
                    <% if (error != null) {%>
                   
                        <h3 color="red"> <%= error%> </h3>
                    
                    <% }%>
                    <button>Sign In</button>
                </form>
            </div>
            <div class="toggle-container">
                <div class="toggle">
                    <div class="toggle-panel toggle-left">
                        <h1>Hello, Friend!</h1>
                        <p>
                            You must be new here,please use your personal details to use all
                            of sites features
                        </p>
                        <button class="hidden" id="login">Sign In</button>
                    </div>
                    <div class="toggle-panel toggle-right">
                        <h1>Welcome Back!</h1>
                        <p>Enter your personal details to use all of site features</p>
                        <button class="hidden" id="register">Sign Up</button>
                    </div>
                </div>
            </div>
        </div>
        <script src="js/login.js"></script>
    </body>
</html>
