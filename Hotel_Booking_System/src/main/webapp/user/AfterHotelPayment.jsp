<!DOCTYPE html>
<%@page import="org.jsp.entity.BookingDetails"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel</title>
    <style>
      body{
        margin: 0;
        padding: 0;
        background-image: url("/Hotel_Booking_System/images/Owall-Hotel-Seoul-Exterior.jpeg");
        background-repeat:no-repeat;
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
        background-color: rgba(0, 0, 0, 0.5); /* Use RGBA with alpha value less than 1 for transparency */
      }
      .navbar-nav .nav-item a.nav-link {
        color: white; /* Set the text color to white */
      } 
      #btn, label{
        color: white;
      }
      h1 {
        color: white;
        text-align: center;
        padding-top: 120px;
        
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
                <li class="nav-item active"><a class="nav-link "
					href="/Hotel_Booking_System/user/Home.jsp">Home</a></li>
				<li class="nav-item"><a class="nav-link "
					href="/Hotel_Booking_System/user/HotelList.jsp">Hotels</a></li>
				<li class="nav-item"><a class="nav-link "
					href="/Hotel_Booking_System/user/BookingHistory.jsp">Booking
						History</a></li>
				<li class="nav-item"><a class="nav-link "
					href="/Hotel_Booking_System/user/Payment.jsp">Payment</a></li>
              </ul>
            </div>
            <ul class="navbar-nav ml-auto">  <!--  Add ml-auto class to push "Contact" to the right -->
                <li class="nav-item">
                  <a class="nav-link" href="../logout">LogOut</a>
                </li>
              </ul>
        </nav>
<!-- After Click on  -->

<div class="container  w-50 p-3 m-5">
    <div class="row justify-content-left">
      <div class="col-md-8">
          <h1 class="mb-4 " >ADD CARD DETAILS</h1>
          <form action="../payment"  method="post">
              <div class="row mb-3">
                  <div class="col">
                      <label for="cardnumber" class="form-label">Card Number :</label>
                      <input type="number" class="form-control"  placeholder="Card Number" required 
                      name="cardnumber">
                  </div>
                  <div class="col">
                      <label for="cardname" class="form-label">Card Holder Name:</label>
                      <input type="text" class="form-control" placeholder="Card Name "  required 
                      name="cardHolderName">
                  </div>
              </div>
              <div class="row mb-3">
                    <div class="col">
                        <label for="expiredate" class="form-label">Expire Date :</label>
                        <input type="date" class="form-control"  placeholder="Expire Date"  required 
                        name="expiryDate">
                    </div>
                    <%
                    	BookingDetails details = (BookingDetails)session.getAttribute("bookingDetails");
                    %>
                    <div class="col">
                        <label for="price" class="form-label">Total Price :</label>
                        <input type="number" class="form-control"  placeholder="Total Price" required 
                        readonly="readonly" value="<%= details.getTotalPrice()%>">
                    </div>	
              </div>
              <div class="row mb-3">
                    <div class="col">
                        <label for="cvv" class="form-label">CVV :</label>
                        <input type="number" class="form-control"  placeholder="CVV"  required 
                        name="cvv">
                    </div>
                    <div class="col">
          
                    </div>	
              </div>
              <button type="submit" class="btn btn-outline-dark">Create Account</button> -->
              
          </form>
      </div>        
    </div>
  </div>
</body>
</html>