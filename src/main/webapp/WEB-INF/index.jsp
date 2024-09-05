<%--
  Created by IntelliJ IDEA.
  User: keimh
  Date: 9/4/2024
  Time: 5:32 PM
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
<div class="container mt-5">
  <div class="row justify-content-center">
    <div class="col-md-8">
      <div class="card">
        <div class="card-header text-center">
          <h1>Burger Tracker</h1>
        </div>
        <div class="card-body">
          <table class="table table-striped">
            <thead>
            <tr>
              <th>Burger Name</th>
              <th>Restaurant Name</th>
              <th>Rating (out of 5)</th>
              <th>Notes</th>
              <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="burger" items="${burgers}">
              <tr>
                <td>${burger.burgerName}</td>
                <td>${burger.restaurantName}</td>
                <td>${burger.rating}</td>
                <td>${burger.notes}</td>
                <td><a href="/burgers/edit/${burger.id}" class="btn btn-warning">Edit</a></td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
          <h2 class="mt-4">Add a Burger</h2>
          <form:form modelAttribute="burger" action="/burgers/create" method="post">
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

        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
