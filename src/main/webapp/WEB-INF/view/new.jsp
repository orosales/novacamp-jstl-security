<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE <!DOCTYPE html>
<html>

<head>

    <title>YelpCamp</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="/"> YelCamp </a>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="/">Login</a>
                    </li>
                    <li>
                        <a href="/">Sign In</a>
                    </li>
                    <li>
                        <a href="/">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>


    <div class="container">

            <div class="row">
                <h1 style="text-align: center">Create a New Campground</h1>

                <div style="width:30%; margin: 25px auto">
                    <form:form action="/camps" method="POST" modelAttribute="camp">
                        <div class="form-group">
                            <input class="form-control" type="text" placeholder="name" name="name">
                            <form:errors path="name" class="text-danger" />
                        </div>

                         <div class="form-group">
                             <select class="form-control" name="idTypeCamp" id="idTypeCamp">
                                 <c:forEach var="item" items="${typeCamps}" >
                                     <option value='${item.id}'>
                                                <c:out value="${item.name}" />
                                     </option>
                                 </c:forEach>
                             </select>
                         </div>


                        <div class="form-group">
                            <input class="form-control" type="text" placeholder="image" name="image">
                             <form:errors path="image" class="text-danger" />
                        </div>
                        <div class="form-group">
                            <input class="form-control" type="text" placeholder="description" name="description">
                             <form:errors path="description"  class="text-danger" />
                        </div>

                        <div class="form-group">
                          <label for="sel1">Size:</label> <br>
                            <c:forEach var="item" items="${sizeList}" >
                              <form:radiobutton path="size" value="${item.id}"  />${item.name}
                             </c:forEach>
                             <form:errors path="size"  class="text-danger" />
                        </div>

                        <div class="form-group">
                            <button class="btn btn-lg btn-primary btn-block">Submit</button>
                        </div>
                    </form:form>

                    <a href="/camps">Go Back </a>

                </div>

            </div>
        </div>