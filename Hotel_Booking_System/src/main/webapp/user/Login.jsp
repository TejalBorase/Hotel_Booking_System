<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Hotel</title>
<style>
body {
	margin: 0;
	padding: 0;
	background-image:
		url("/Hotel_Booking_System/images/Owall-Hotel-Seoul-Exterior.jpeg");
	background-repeat: no-repeat;
	background-position: inherit;
	/* background-size: cover; */
	background-attachment: fixed;
	background-size: 100% 100%;
	/* height: 300px; */
	/* position: absolute; */
}

a {
	color: white;
}

.navbar {
	background-color: rgba(0, 0, 0, 0.5);
	/* Use RGBA with alpha value less than 1 for transparency */
}

.navbar-nav .nav-item a.nav-link {
	color: white; /* Set the text color to white */
}

#btn {
	color: white;
}

label {
	color: white;
}

h2 {
	color: white;
}
</style>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<script>
	// Listen for the onpageshow event
	window.onpageshow = function(event) {
		// Check if the page is being accessed from the cache due to back or forward navigation
		if (event.persisted) {
			// Reload the page
			window.location.reload();
			window.location.replace('/Hotel_Booking_System/user/Login.jsp');
		}
	};
</script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light navbar-expand-md">
		<a href="" class="navbar-brand" style="color: white;"> <img
			src="https://w7.pngwing.com/pngs/927/770/png-transparent-hotel-logo-resort-suite-investment-banking-letter-b-angle-company-text.png"
			width="50px" style="border-radius: 10px;" alt="No img"> Hotel
			Booking System
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link "
					href="http://localhost:8081/Hotel_Booking_System/index.jsp">Home</a>
				</li>
				<li class="nav-item"><a class="nav-link "
					href="http://localhost:8081/Hotel_Booking_System/user/SignUp.jsp">SignUp</a>
				</li>
				<li class="nav-item"><a class="nav-link "
					href="http://localhost:8081/Hotel_Booking_System/user/Login.jsp">Login</a>
				</li>
			</ul>
		</div>
	</nav>
	<%
	String message = request.getParameter("msg");
	if (message != null) {
		if (message.equals("added")) {
	%>
	<center>
		<h2 style="color: limegreen">Registration Successful!!!</h2>
		<h2 style='color: green'>Kindly Login to get Access of an
			Application.</h2>
	</center>
	<%
	} else if (message.equals("login")) {
	%>
	<center>
		<h2 style='color: red'>PLEASE ENTER VALID CREDENTIALS.</h2>
	</center>
	<%
	} else if (message.equals("logout")) {
	%>
	<center>
		<h2 style='color: limegreeen;'>LOGOUT SUCCESSFUL!!</h2>
	</center>
	<%
		}
	}
	%>

	<!-- Login Page -->
	<div class="container  w-50 p-3 m-5">
		<div class="row justify-content-left">
			<div class="col-md-8">
				<h2 class="mb-4 ">Customer Login Form</h2>
				<form action="../login" method="post">
					<div class="row mb-3">
						<div class="col">
							<label for="email" class="form-label">Email :</label> <input
								type="email" class="form-control" placeholder="Email" required
								name="email">
						</div>
						<div class="col">
							<label for="password" class="form-label">Password :</label> <input
								type="password" class="form-control" required
								placeholder="Password" name="password">
						</div>
					</div>
					<!-- <button type="submit" class="btn btn-outline-dark">Create Account</button> -->
					<input type="submit" id="btn" class="button btn btn-outline-dark"
						value="Login">
				</form>
			</div>
		</div>
	</div>

</body>
</html>