<%-- 
    Document   : home.jsp
    Created on : Nov 18, 2023, 7:17:15 PM
    Author     : ujucoco
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="../Stylesheets/home.css">
<link href="https://fonts.googleapis.com/css2?family=DM+Sans:opsz,wght@9..40,300;9..40,400&family=Lumanosimo&family=Poppins&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/d752e27401.js" crossorigin="anonymous"></script>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    
    
</head>
<body>
    <div class="main">
        <div class="top">
            <h1>Fetch N Flex</h1>
            <img src="../../images/anirban.jpg" alt="" onclick="showGreyBox()">
            <div class="grey-box" id="greyBox">
                <div class="top-part">
                    <img src="../../images/anirban.jpg" alt="">                    
                    <div>
                        <h2 class="username">Hi, Anirban!</h1>
                        <h5 class="e-mail">duttashaan102@gmail.com</h5>
                    </div>
                    
                </div>
                
                <div class = "line"></div>
                <a href="../JSPs/personal_info.jsp">
                <p class="link">Manage your Fetch N Flex Account</p>
                </a>
                <a href="../JSPs/pet_details.jsp">
                <p class="link">Manage your pet's information</p>
                </a>
                <div class = "line"></div>
                <p class="link">Market Place</p>
                <div class = "line"></div>
                <a href="../Pages/fed.html">
                    <p class="link">Send for Feedback or Suggestions</p>
                </a>
                <a href="../Pages/About.html">
                    <p class="link">About Us</p>
                </a>
                <a href="../Pages/contact us.html">
                    <p class="link">Get in Touch</p>
                </a>
                <div class = "line"></div>
                <p class="log-out">Log Out</p>

            </div>
        </div>
        <script src="../JS/script.js">
    </script>


        <div class="bottom">
            <div class="navbar left">
                <a href=""><i class="fa-solid fa-house"></i> Home</a>
                <a href=""><i class="fa-sharp fa-solid fa-utensils"></i> Diet Plans</a>
                <a href="./reminders.html"><i class="fa-solid fa-bell"></i> Reminders</a>
                <a href=""><i class="fa-solid fa-file-waveform"></i> Health Overview</a>
                <a href="./emergency_contacts.html"><i class="fa-solid fa-triangle-exclamation"></i> Emergency</a>
            </div>
            <div class="right">
                <div class="right-top">
                    <img src="../../images/Avatar.png" alt="">
                    <div class="right-top-right">
                        <div class="top-content">
                            <div>
                                <p class="name" style="font-size: 40px;">Zoro</p>
                                <p class="breed" style="font-size: 15px; color:#EA6D13;">German Shephard</p>
                            </div>
                            <div>
                                <p class="date" style="font-size: 15px; margin-bottom: 20px;">25 June 2021</p>
                                <p class="gender" style="text-align: right;">Male</p>
                            </div>
                        </div>
                        <div class="middle-content">
                            <div>
                                <p class="weight" style="font-size: 20px;">Weight: 25KG</p>
                                <p class="height" style="font-size: 20px; margin-bottom: 10px;">3 feet 7 inches</p>
                            </div>
                            
                            <div class="link">
                                <a href="">edit <i class="fa-solid fa-pen-to-square"></i></a>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="right-middle">
                    <div class="right-middle-left box">
                        <p class="activity">Activity</p>
                    </div>
                    <div class="right-middle-right box">
                        <p class="water-intake">Water Intake</p>
                    </div>
                </div>
                <div class="right-bottom">
                    <div class="right-bottom-left box">
                        <p class="sleep">Sleep</p>
                    </div>
                    <div class="right-bottom-right box">
                        <p class="weight">Weight</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>