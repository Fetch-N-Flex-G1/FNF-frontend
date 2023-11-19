<%-- 
    Document   : payment_gateway
    Created on : 18 Nov, 2023, 9:08:46 PM
    Author     : Subhajit-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <title>Paymentgateway</title>
    <link rel="stylesheet" href="../Stylesheets/payment_gateway.css">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
<body>
  <div class="container">
    <div class="title">Payment</div>
    <div class="content">
      <form action="#">
        <div class="user-details">
          <div class="input-box">
            <span class="details">First Name</span>
            <input type="text" id="f_name" name="f_name" placeholder="Enter your first name" required>
          </div>
          <div class="input-box">
            <span class="details">Last Name</span>
            <input type="text" id="l_name" name="l_name" placeholder="Enter your last name" required>
          </div>
          <div class="input-box">
            <span class="details">Name On Card</span>
            <input type="text" id="noc" name="noc" placeholder="Enter card holder name" required>
          </div>
          
          <div class="input-box">
            <span class="details">Card Number</span>
            <input type="text" id="number" name="number" placeholder="Enter your card number" required>
          </div>
          <div class="input-box">
            <span class="details">Expiry Date</span>
            <input type="date" id="date" name="date" placeholder="Enter your expiry date" required>
          </div>
          <div class="input-box">
            <span class="details">CVV</span>
            <input type="text" id="cvv" name="cvv" placeholder="Enter your cvv" required>
          </div>
         
        </div>
        <div class="Plan-details">
          <input type="radio" name="Plan" id="dot-1">
          <input type="radio" name="Plan" id="dot-2">
          <input type="radio" name="Plan" id="dot-3">
          <span class="gender-title">Plan</span>
          <div class="category">
            <label for="dot-1">
            <span class="dot one"></span>
            <span class="Plan">Starter</span>
          </label>
          <label for="dot-2">
            <span class="dot two"></span>
            <span class="Plan">Standard</span>
          </label>
          <label for="dot-3">
            <span class="dot three"></span>
            <span class="Plan">Supreme</span>
            </label>
          </div>
        </div>
        <div class="button">
          <input type="submit" value="Pay">
        </div>
      </form>
    </div>
  </div>

</body>
</html>