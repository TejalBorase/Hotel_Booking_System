<!DOCTYPE html>
<%@page import="org.jsp.dao.AdminDaoImpl"%>
<%@page import="org.jsp.dao.AdminDao"%>
<%@page import="org.jsp.entity.Hotel"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel</title>
    <style>
        body {
        margin: 0;
        padding: 0;
        background-image: url("http://localhost:8081/Hotel_Booking_System/images/Owall-Hotel-Seoul-Exterior.jpeg");
        background-repeat:no-repeat;
        background-position: inherit;
        /* background-size: cover; */
        background-attachment: fixed;
        background-size: 100% 100%;
        /* height: 300px; */
        /* position: absolute; */
       }
       a{
        color: white;
       }
      .navbar {
        background-color: rgba(0, 0, 0, 0.5); /* Use RGBA with alpha value less than 1 for transparency */
        }
        .navbar-nav .nav-item a.nav-link {
        color: white; /* Set the text color to white */
        }
        #btn{
        color: white;
      }
      label,h1,th,td{
        color: white;
      }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light navbar-expand-md">
        <a href="" class="navbar-brand" style="color: white;"> <img src="https://w7.pngwing.com/pngs/927/770/png-transparent-hotel-logo-resort-suite-investment-banking-letter-b-angle-company-text.png" width="50px" style="border-radius: 10px;" alt="No img"> Hotel Booking System</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
              <ul class="navbar-nav">
                <li class="nav-item active">
                  <a class="nav-link " href="http://localhost:8081/Hotel_Booking_System/admin/Home.jsp">Home</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      Hotels
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                      <li><a class="dropdown-item" href="http://localhost:8081/Hotel_Booking_System/admin/AddHotel.jsp">Add Hotel</a></li>
                      <li><a class="dropdown-item" href="http://localhost:8081/Hotel_Booking_System/admin/HotelList.jsp">Hotel List</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      Users
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                      <li><a class="dropdown-item" href="http://localhost:8081/Hotel_Booking_System/admin/AddUser.jsp">Add Users</a></li>
                      <li><a class="dropdown-item" href="http://localhost:8081/Hotel_Booking_System/admin/UserList.jsp">User List</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      Booking
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                      <li><a class="dropdown-item" href="BookingList.html">Booking List</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                  <a class="nav-link " href="PaymentList.html">Payment</a>
                </li>
              </ul>
        </div>
        <ul class="navbar-nav ml-auto"> <!-- Add ml-auto class to push "Contact" to the right -->
          <li class="nav-item">
            <a class="nav-link" href="LogOut.html">LogOut</a>
          </li>
        </ul>
    </nav>
    <%
    	String update = request.getParameter("msg");
    	if(update != null){
    		if(update.equals("added")){
    %>
    		<center><h2 style='color:green;'>Hotel Added Successfully!!!</h2></center>
    <%
    	}
    	else if(update.equals("update")){		
    %>
    		<center><h2 style='color:green;'>Hotel Edited Successfully!!!</h2></center>
    <% 
    		}
    	}
    	AdminDao dao = new AdminDaoImpl();
    	List<Hotel> hotels = dao.getAllHotelsDetails();
    	if(hotels != null){
    %>
    <div class="container">
        <h1>Hotel List</h1>
            <table class="table ">
                <thead>
                  <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Hotel Name</th>
                    <th scope="col">Contact Number</th>
                    <th scope="col">Price</th>
                    <th scope="col">City</th>
                    <th scope="col">Address</th>
                    <th scope="col">No. Of Rooms</th>
                    <th scope="col">Booked Rooms</th>
                    <th scope="col">Action</th>
                  </tr>
                </thead>
                <tbody>
                <%
                	for(Hotel hotel : hotels){
                %>
                  <tr>
                    <th scope="row"><%= hotel.getId()%></th>
                    <td><%= hotel.getHotelName()%></td>
                    <td><%= hotel.getMobile()%></td>
                    <td><%= hotel.getPrice()%></td>
                    <td><%= hotel.getCity()%></td>
                    <td><%= hotel.getAddress()%></td>
                    <td><%= hotel.getTotalNoOfRoom()%></td>
                    <td><%= hotel.getNoOfBookedRoom()%></td>
                    <td>
                         <a href="/Hotel_Booking_System/admin/EditHotel.jsp?hotelId=<%= hotel.getId()%>" id="btn" class="button btn btn-outline-dark">Update</a>
                         &nbsp; 
                         <a href="/Hotel_Booking_System/DeleteHotel?hotelId=<%= hotel.getId()%>" id="btn" class="button btn btn-outline-dark">Delete</a> 
                    </td>
                  </tr>
                 <%
                	}
                	
                 %>
                </tbody>
              </table>
    </div>
    <%
    	}
    	else{
    %>
    	<center><h2 style='color:red'>NO RECORD FOUND.</h2></center>
    <%
    	}
    %>

</body>
</html>