<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <link href="webjars/bootstrap/5.3.2/css/bootstrap.min.css" rel="stylesheet">
        <title>Add Todo Page</title>
    </head>
    <body>
        <div class="container">
            <h1>Enter Todo Details</h1>
            <form action="add-todo" method="post">
                <div class="form-group">
                    <label for="description">Description</label>
                    <input type="text" class="form-control" id="description" name="description" />
                </div>
                <div class="form-group">
                    <label for="targetDate">Target Date</label>
                    <input type="date" class="form-control" id="targetDate" name="targetDate" />
                </div>
                <button type="submit" class="btn btn-success">Submit</button>
            </form>
        </div>
        <script src="webjars/jquery/3.7.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/5.3.2/js/bootstrap.min.js"></script>
    </body>
</html>

