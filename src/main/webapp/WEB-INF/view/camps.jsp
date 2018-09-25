 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
    <title>YelpCamp</title>
     <link href="/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>

<div class="container">
    <header class="jumbotron">
        <div class="container">
            <h1> Welcome to Camps of Nova Scotia!! </h1>
            <p>View our hand-picked campgrounds from all over the World</p>
            <p>
                <a class="btn btn-primary btn-large" href="/camps/new"> Add new Campground</a>
            </p>
        </div>
    </header>



     <div class="row text-center" style="display:flex; flex-wrap: wrap;">

          <c:forEach var="camp" items="${listCamps}" >

            <div class="col-md-3 col-sm-6">

              <div class="thumbnail">
                <img src="${camp.image}">
                <div class="caption">
                  <h4>
                   <c:out value="${camp.name}"/>
                  </h4>
                </div>
                 <p>
                              <a href="/camps/<c:out value="${camp.id}"/>" class="btn btn-primary">More Info!!!</a>
                              <a href="/camps/comments/<c:out value="${camp.id}"/>" class="btn btn-primary">Comment</a>
                   </p>

              </div>
            </div>

           </c:forEach>
        </div>

</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/js/bootstrap.min.js"></script>

</body>
</html>