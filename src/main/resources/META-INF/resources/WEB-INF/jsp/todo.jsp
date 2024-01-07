<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <link href="webjars/bootstrap/5.3.2/css/bootstrap.min.css" rel="stylesheet">
        <title>Add Todo Page</title>
    </head>
    <body>
        <div class="container">
            <h1>Enter Todo Details</h1>
            <form:form action="add-todo" method="post" modelAttribute="todo">
                <div class="form-group">
                    <label for="description">Description</label>
                    <form:input type="text" class="form-control" id="description" name="description" required="required" path="description"/>
                    <form:input type="hidden" path="id" />
                    <form:input type="hidden" path="done" />
                </div>
                <div class="form-group">
                    <label for="targetDate">Target Date</label>
                    <input type="date" class="form-control" id="targetDate" name="targetDate" />
                </div>
                <button type="submit" class="btn btn-success">Submit</button>
            </form:form>
        </div>
        <script src="webjars/jquery/3.7.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/5.3.2/js/bootstrap.min.js"></script>
    </body>
</html>

