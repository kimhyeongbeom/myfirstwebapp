<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <h1>Enter Todo Details</h1>
    <form:form method="post" modelAttribute="todo">
        <div class="form-group">
            <fieldset class="form-group mb-3">
                <form:label path="description">Description</form:label>
                <form:input type="text" class="form-control" id="description" name="description" required="required" path="description"/>
                <form:errors path="description" cssClass="text-danger" />
            </fieldset>
            <fieldset class="form-group mb-3">
                <form:label path="targetDate">Target Date</form:label>
                <form:input type="text" class="form-control" id="targetDate" name="targetDate" path="targetDate" />
                <form:errors path="targetDate" cssClass="text-danger" />
            </fieldset>
            <form:input type="hidden" path="id" />
            <form:input type="hidden" path="done" />
        </div>
        <button type="submit" class="btn btn-success">Submit</button>
    </form:form>
</div>
<%@ include file="common/footer.jspf" %>
<script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd'
    });
</script>