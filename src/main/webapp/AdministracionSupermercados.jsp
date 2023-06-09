<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!--Links CSS-->

<link rel="stylesheet" href="css/Administracion.css">



<!--Links letras-->
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
<title>Panel de control</title>
</head>
<body class="hideScroll">


	<!--Tablas De administrador-->
	<form method="GET" action="PrecioBucadorMax" class="form"
		style="display: inline-block;">
		<div class="input-group mb-3">
			<input type="text" class="form-control" placeholder="Busca Productos"
				aria-label="Recipient's username" aria-describedby="basic-addon2"
				name="buscador">
			<div class="input-group-append">
				<button class="btn btn-outline-secondary" type="submit">Buscar</button>
			</div>
		</div>
	</form>

	<form method="GET" action="PrecioBucadorMax" class="form"
		style="display: inline-block;">
		<div class="input-group mb-3">
			<input type="number" class="form-control"
				placeholder="Precio maximo ↑" aria-label="Recipient's username"
				aria-describedby="basic-addon2" name="maximo">
			<div class="input-group-append">
				<button class="btn btn-outline-secondary" type="submit">Buscar</button>
			</div>
		</div>
	</form>

	<form method="GET" action="PrecioMinimo" class="form"
		style="display: inline-block;">
		<div class="input-group mb-3">
			<input type="number" class="form-control"
				placeholder="Precio minimo ↓" aria-label="Recipient's username"
				aria-describedby="basic-addon2" name="minimo">
			<div class="input-group-append">
				<button class="btn btn-outline-secondary" type="submit">Buscar</button>
			</div>
		</div>
	</form>



	<section id="tabs" class="project-tab"
		style="margin-top: 30px; margin-bottom: 25%;">

		<div class="container">

			<div class="row">

				<div class="col-md-12">

					<nav>

						<div class="nav nav-tabs nav-fill" id="nav-tab" role="tablist">

							<a class="nav-item nav-link active" id="nav-home-tab"
								data-toggle="tab" href="#nav-home" role="tab"
								aria-controls="nav-home" aria-selected="true">Productos </a> <a
								class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab"
								href="#nav-profile" role="tab" aria-controls="nav-profile"
								aria-selected="false">Supermercados </a> <a
								class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab"
								href="#nav-contact" role="tab" aria-controls="nav-contact"
								aria-selected="false">Secciones </a>

						</div>

					</nav>

					<div class="tab-content" id="nav-tabContent">

						<div class="tab-pane fade show active" id="nav-home"
							role="tabpanel" aria-labelledby="nav-home-tab">

							<table
								class="table table-striped table-bordered table-sm table-list-search">

								<thead>

									<tr>

										<th>Check box</th>

										<th>Id</th>

										<th>Codigo | <a href="/Pruebas_clase/OrdenarAscenDes?orden=asc">Ascendente | </a><a href="/Pruebas_clase/OrdenarAscenDes?orden=desc">Descendente</a>
									</th>

										<th>Nombre</th>

										<th>Cantidad</th>

										<th>Precio</th>

										<th>Caducidad</th>

										<th>Seccion</th>

										<th>Modificar</th>

										<th>Eliminar</th>

										<th>Insertar</th>

									</tr>

								</thead>

								<tbody>

									<c:forEach items="${pruductos}" var="productos1">

										<tr>
											<td>
											<form method="POST" action="EliminarMultipleProductos" class="form">
											<div class="form-check">
											  <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault" name ="checkBox">
											  <label class="form-check-label" for="flexCheckDefault">
											  </label>
											  
											</div>

											</td>
											<td>${productos1.id}</td>

											<td>${productos1.codigo}</td>

											<td>${productos1.nombre}</td>

											<td>${productos1.cantidad}</td>

											<td>${productos1.precio}</td>

											<td>${productos1.caducidad}</td>

											<td>${productos1.seccion.nombre}</td>
											

											<!-- actualizar y eliminar -->

											<td>
												<div class="dropdown">
													<button class="continue-application"
														id="dropdownMenuButton" data-toggle="dropdown">
														<div>
															<div class="pencil"></div>
															<div class="folder">
																<div class="top">
																	<svg viewBox="0 0 24 27">
										                    <path
																			d="M1,0 L23,0 C23.5522847,-1.01453063e-16 24,0.44771525 24,1 L24,8.17157288 C24,8.70200585 23.7892863,9.21071368 23.4142136,9.58578644 L20.5857864,12.4142136 C20.2107137,12.7892863 20,13.2979941 20,13.8284271 L20,26 C20,26.5522847 19.5522847,27 19,27 L1,27 C0.44771525,27 6.76353751e-17,26.5522847 0,26 L0,1 C-6.76353751e-17,0.44771525 0.44771525,1.01453063e-16 1,0 Z"></path>
										                </svg>
																</div>
																<div class="paper"></div>
															</div>
														</div>
														Modificar
													</button>
													<div class="dropdown-menu"
														aria-labelledby="dropdownMenuButton">

														<form method="POST" action="ModificarProductos"
															class="form">
															<label for="idhabitacion" class="label">id</label> <input
																type="number" id="id" name="id" required=""
																class="input"> 
																<label for="precio" class="label">codigo</label>
															<input type="number" id="codigo" name="codigo"
																required="" class="input"> 
																<label for="password"
																class="label">nombre</label> 
																<input type=text
																id="nombre" name="nombre" required="" class="input">

															<label for="tipohabitacion" class="label">cantidad</label>
															<input type="number" id="cantidad" name="cantidad"
																required="" class="input"> 
																<label
																for="tipohabitacion" class="label">precio</label> <input
																type="number" id="precio" name="precio" required=""
																class="input"> 
																<label for="tipohabitacion"
																class="label">caducidad</label> 
																<input type="Date"
																id="caducidad" name="caducidad" required=""
																class="input"> 
																
															<select name="Desplegable" required>
																<c:forEach items="${secciones}" var="seccion">
																	<option value="${seccion.id}">${seccion.nombre}</option>
																</c:forEach>
															</select>
																
																<c:forEach items="${supermercados}" var="supermercado">
																<div class="form-check">
																	<input class="form-check-input" type="checkbox"
																		value="${supermercado.id }" id="flexCheckDefault" name="supermercados">
																	<!--  -->
																	<label class="form-check-label" for="flexCheckDefault">
																		${supermercado.nombre} </label>
																</div>
															</c:forEach>
													

															<button type="submit" class="submit">Modificar</button>
														</form>
													</div>
												</div>


											</td>

											<td><a
												href="/Pruebas_clase/EliminarProductos?id=${productos1.id}&tipo=productos"><i
													class="fa-solid fa-trash-can fa-lg"></i></a></td>


											<td><a href="InsertarProducto"><i
													class="fa fa-user-plus"></i></a></td>

										</tr>

									</c:forEach>


								</tbody>

							</table>
							<button type="submit" class="submit">Eliminar Multiple</button>
							</form>

						<div class="tab-pane fade" id="nav-profile" role="tabpanel"
							aria-labelledby="nav-profile-tab">

							<table
								class="table table-striped table-bordered table-sm table-list-search">

								<thead>

									<tr>

										<!-- Gestionar Actividades -->

										<th>Id</th>

										<th>Nombre Supermercado</th>

										<th>Modificar</th>

										<th>Eliminar</th>

										<th>Insertar</th>

									</tr>

								</thead>

								<tbody>

									<c:forEach items="${supermercado}" var="supermercado2">
										<tr>

											<td>${supermercado2.id}</td>

											<td>${supermercado2.nombre}</td>


											<!-- actualizar y eliminar -->

											<td>
												<div class="dropdown">
													<button class="continue-application"
														id="dropdownMenuButton" data-toggle="dropdown">
														<div>
															<div class="pencil"></div>
															<div class="folder">
																<div class="top">
																	<svg viewBox="0 0 24 27">
										                    <path
																			d="M1,0 L23,0 C23.5522847,-1.01453063e-16 24,0.44771525 24,1 L24,8.17157288 C24,8.70200585 23.7892863,9.21071368 23.4142136,9.58578644 L20.5857864,12.4142136 C20.2107137,12.7892863 20,13.2979941 20,13.8284271 L20,26 C20,26.5522847 19.5522847,27 19,27 L1,27 C0.44771525,27 6.76353751e-17,26.5522847 0,26 L0,1 C-6.76353751e-17,0.44771525 0.44771525,1.01453063e-16 1,0 Z"></path>
										                </svg>
																</div>
																<div class="paper"></div>
															</div>
														</div>
														Modificar
													</button>
													<div class="dropdown-menu"
														aria-labelledby="dropdownMenuButton">
														<form method="POST" action="ModificarActiviades"
															class="form">
															<label for="idhabitacion" class="label">Nombre
																Actividad</label> <input type="text" id="username"
																name="NombreActividad" required="" class="input">

															<label for="precio" class="label">Codigo
																Actividad</label> <input type="text" id="email"
																name="CodigoActividad" required="" class="input">

															<label for="password" class="label">Participantes</label>
															<input type="descripcion" id="password"
																name="Participantes" required="" class="input">

															<label for="tipohabitacion" class="label">PrecioActividad</label>
															<input type="text" id="username" name="PrecioActividad"
																required="" class="input">

															<button type="submit" class="submit">Modificar</button>
														</form>
													</div>
												</div>

											</td>


											<td><a
												href="/Aurorium/EliminarDatos?id=${supermercado2.id}&tipo=actividad"><i
													class="fa-solid fa-trash-can fa-lg"></i></a></td>


											<td><a href="InsertarActividades.jsp"><i
													class="fa fa-user-plus"></i></a></td>

										</tr>

									</c:forEach>

								</tbody>

							</table>

						</div>

						<!-- Gestionar Clases (BUSCADOR) -->

						<div class="tab-pane fade" id="nav-contact" role="tabpanel"
							aria-labelledby="nav-contact-tab">

							<table
								class="table table-striped table-bordered table-sm table-list-search">

								<thead>

									<tr>

										<!-- Gestionar Clases -->

										<th>Id</th>

										<th>Id producto</th>

										<th>Id Supermercado</th>

										<th>Modificar</th>

										<th>Eliminar</th>

										<th>Insertar</th>

									</tr>

								</thead>

								<tbody>

									<c:forEach items="${ProductosSupermercado}" var="productoSuper">
										<tr>

											<td>${productoSuper.id}</td>

											<td>${productoSuper.id_productos}</td>

											<td>${productoSuper.id_supermercado}</td>



											<!-- actualizar y eliminar -->


											<td>
												<div class="dropdown">
													<button class="continue-application"
														id="dropdownMenuButton" data-toggle="dropdown">
														<div>
															<div class="pencil"></div>
															<div class="folder">
																<div class="top">
																	<svg viewBox="0 0 24 27">
										                    <path
																			d="M1,0 L23,0 C23.5522847,-1.01453063e-16 24,0.44771525 24,1 L24,8.17157288 C24,8.70200585 23.7892863,9.21071368 23.4142136,9.58578644 L20.5857864,12.4142136 C20.2107137,12.7892863 20,13.2979941 20,13.8284271 L20,26 C20,26.5522847 19.5522847,27 19,27 L1,27 C0.44771525,27 6.76353751e-17,26.5522847 0,26 L0,1 C-6.76353751e-17,0.44771525 0.44771525,1.01453063e-16 1,0 Z"></path>
										                </svg>
																</div>
																<div class="paper"></div>
															</div>
														</div>
														Modificar
													</button>
													<div class="dropdown-menu"
														aria-labelledby="dropdownMenuButton">
														<form method="POST" action="ModificarHabitaciones"
															class="form">
															<label for="idhabitacion" class="label">Id </label> <input
																type="text" id="username" name="id" required=""
																class="input"> <label for="precio" class="label">Id
																producto</label> <input type="text" id="email"
																name="id_producto" required="" class="input"> <label
																for="password" class="label">Id super</label> <input
																type="descripcion" id="password" name="id_supermercado"
																required="" class="input">


															<button type="submit" class="submit">Modificar</button>
														</form>
													</div>
												</div>

											</td>

											<td><a
												href="/Aurorium/EliminarDatos?id=${productoSuper.id}&tipo=habitaciones"><i
													class="fa-solid fa-trash-can fa-lg"></i></a></td>

											<td><a href="InsertarProductosSuper"><i
													class="fa fa-user-plus"></i></a></td>
										</tr>

									</c:forEach>

								</tbody>

							</table>

						</div>

					</div>

				</div>

			</div>

		</div>

	</section>





</body>
</html>