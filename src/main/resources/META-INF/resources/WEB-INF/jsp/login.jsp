<html>
    <head>
        <link href="webjars/bootstrap/5.3.2/css/bootstrap.min.css" rel="stylesheet">
        <title>Login Page</title>
    </head>
    <body>
        <div class="container">
            <h1> Login Page </h1>
            <pre>${errorMessage}</pre>

            <form method="post">
                Name : <input type="text" name="name" />
                Password : <input type="password" name="password" />
                <input type="submit" />
            </form>
        </div>
    </body>
    <script src="webjars/jquery/3.7.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/5.3.2/js/bootstrap.min.js"></script>
</html>
