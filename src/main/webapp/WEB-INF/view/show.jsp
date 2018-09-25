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
                <a class="navbar-brand" href="/camps"> YelCamp </a>
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

             <div style="width:30%; margin: 25px auto">
                <h1>${camp.name}</h1>

                <img src="${camp.image}" class="img-responsive">
                <p>${camp.description} </p>

                 <a href="/camps">Go Back </a>

              </div>
        </div>
     </div>