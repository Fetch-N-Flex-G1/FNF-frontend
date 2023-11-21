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
      <form action="http://localhost:8080/Fetch-N-Flex/PaymentGateway" method="post">
        <div class="user-details">
          <div class="input-box">
            <span class="details">Full Name</span>
            <input type="text" id="name" name="name" placeholder="Enter your full name" required>
          </div>
          <div class="input-box">
            <span class="details">Email</span>
            <input type="email" id="email" name="email" placeholder="Enter your email" required>
          </div>
          <div class="input-box">
            <span class="details">Name On Card</span>
            <input type="text" id="noc" name="noc" placeholder="Enter card holder name" required>
          </div>
          
          <div class="input-box">
            <span class="details">Card Number</span>
            <input type="number" inputmode="numeric" id="card_number" name="card_number" placeholder="Enter your card number" required>
          </div>
          <div class="input-box">
            <span class="details">Expiry Date</span>
            <input type="date" id="date" name="date" placeholder="Enter your expiry date" required>
          </div>
          <div class="input-box">
            <span class="details">CVV</span>
            <input type="password" inputmode="numeric" id="cvv" name="cvv" placeholder="Enter your cvv" required>
          </div>
         
        </div>
        <label for="package">Select a package:</label>
        <input list="packageOptions" name="package" id="package" onchange="updatePrice()" required>
        <datalist id="packageOptions">
          <option value="Starter">
          <option value="Supreme">
          <option value="Standard">
        </datalist>
      <br>
      <label for="price">Price:</label>
      <input type="number" name="price" id="price" readonly>

      
        <div class="button">
          <input type="submit" value="Pay">
        </div>
      </form>
    </div>
  </div>
  <script>
    function updatePrice() {
        var packageInput = document.getElementById('package');
        var priceInput = document.getElementById('price');

        var selectedPackage = packageInput.value;

        if (selectedPackage === 'Starter') {
            priceInput.value = '200';
        } else if (selectedPackage === 'Standard') {
            priceInput.value = '1000';
        } else if (selectedPackage === 'Supreme') {
            priceInput.value = '2000';
        } else {
            priceInput.value = ''; // Clear the value if none of the packages are selected
        }
    }
    const input = document.getElementById('cvv');

    input.addEventListener('keyup', () => {
      if (input.value.length > 3) {
        input.value = input.value.substring(0, 3);
      }
    });
    
    const input2 = document.getElementById('card_number');

    input2.addEventListener('keyup', () => {
      if (input2.value.length > 16) {
        input2.value = input2.value.substring(0, 16);
      }
    });
    
    const input3 = document.getElementById('card_number');

    input3.style.appearance = 'none';
    input3.style.margin = '0';
</script>

</body>
</html>