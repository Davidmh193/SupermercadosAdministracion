<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<!-- Letra -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Open+Sans:400,600">
<!-- Iconos -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<!-- Js -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <!--Boostrap-->
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
       <div class = "contact-body">
          <div class = "contact-form">
            <form method="POST" action="InsertarProductos">
              <div style="display: inline-block;" inputs>
               
                <input  type = "text" class = "form-control" placeholder="codigo"name="codigo">
                <input  type = "text" class = "form-control" placeholder="nombre"name="nombre">
                <input  type = "text" class = "form-control" placeholder="cantidad"name="cantidad">
                <input  type = "text" class = "form-control" placeholder="precio"name="precio">
                <input  type = "Date" class = "form-control" placeholder="caducidad"name="caducidad">
             
              </div>
              <!--Botn de enviar-->
              <button style=" margin-top:2%" class="learn-more"  type="submit">
                <span class="circle" aria-hidden="true">
                <span class="icon arrow"></span>
                </span>
                <span class="button-text">Enviar</span>
              </button >
            </form>
            
          </div>

 
        </div>

</body>
</html>