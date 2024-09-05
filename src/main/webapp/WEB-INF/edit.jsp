<%--
  Created by IntelliJ IDEA.
  User: keimh
  Date: 9/5/2024
  Time: 1:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
    <title>Burger Tracker</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<h2 class="mt-4">Edit Burger</h2>
<form:form modelAttribute="burger" action="/burgers/update/${burger.id}" method="post">
    <input type="hidden" name="_method" value="put" />
    <div class="form-group mb-3">
        <form:label path="burgerName">Burger Name:</form:label>
        <form:input path="burgerName" class="form-control" />

        <form:errors path="burgerName"/>

    </div>
    <div class="form-group mb-3">
        <form:label path="restaurantName">Restaurant Name:</form:label>
        <form:input path="restaurantName" class="form-control" />

        <form:errors path="restaurantName"/>

    </div>
    <div class="form-group mb-3">
        <form:label path="rating">Rating:</form:label>
        <form:input path="rating" class="form-control" />

        <form:errors path="rating"/>

    </div>
    <div class="form-group mb-3">
        <form:label path="notes">Notes:</form:label>
        <form:textarea path="notes" class="form-control" />

        <form:errors path="notes"/>

    </div>
    <button type="submit" class="btn btn-primary w-100">Submit</button>
</form:form>

</body>
</html>
