<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <title>Diet Input</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');
*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Poppins',sans-serif;
}
body{
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 10px;
  background-color: #131415;
}
.container{
  max-width: 700px;
  width: 100%;
  background-color: #0e0b0b;
  color: white;
  padding: 25px 30px;
  border: 1px solid #ee6010;;
  border-radius: 5px;
  box-shadow: 0 5px 10px rgba(0,0,0,0.15);
}
.container .title{
  font-size: 25px;
  font-weight: 500;
  position: relative;
  color: #ee6010;
}
.container .title::before{
  content: "";
  position: absolute;
  left: 0;
  bottom: 0;
  height: 3px;
  width: 30px;
  border-radius: 5px;
}
.content form .user-details{
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  margin: 20px 0 12px 0;
}
form .user-details .input-box{
  margin-bottom: 15px;
  width: calc(100% / 2 - 20px);
}
form .input-box span.details{
  display: block;
  font-weight: 500;
  margin-bottom: 5px;
}
.user-details .input-box input{
  height: 45px;
  width: 100%;
  outline: none;
  font-size: 16px;
  border-radius: 20px;
  padding-left: 15px;
  border: transparent;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
  background-color: #2d2a2a;
  color: rgba(255, 255, 255, 0.25);
}
.user-details .input-box input:focus,
.user-details .input-box input:valid{
  border: 2px solid #ee6010 ;
}
.input-box {
  margin-bottom: 20px; /* Adjust as needed */
}

.details {
  display: block;
  margin-bottom: 8px; /* Adjust as needed */
}

select {
  width: 100%;
  padding: 8px;
  font-size: 16px;
  border: 1px solid #2D2A2A;
  border-radius: 20px;
  box-sizing: border-box;
  background-color: #2D2A2A;
  color: #fff;
}

/* Optional: Style for better visual feedback when interacting with the select box */

select:focus {
    border: 2px solid #ee6010 ;
}

/* Optional: Style for the selected option */
select option:checked {
  font-weight: bold;
  background-color: #2D2A2A; /* Change to your desired color */
}

 form .Plan-details .Plan-title{
  font-size: 20px;
  font-weight: 500;
 }
 form .category{
   display: flex;
   width: 100%;
   margin: 14px 0 ;
   justify-content: space-between;
 }
 form .category label{
   display: flex;
   align-items: center;
   cursor: pointer;
 }
 form .category label .dot{
  height: 18px;
  width: 18px;
  border-radius: 50%;
  margin-right: 10px;
  background: #d9d9d9;
  border: 5px solid transparent;
  transition: all 0.3s ease;
}
 #dot-1:checked ~ .category label .one,
 #dot-2:checked ~ .category label .two,
 #dot-3:checked ~ .category label .three{
   background: #ee6010;
  
 }
 form input[type="radio"]{
   display: none;
 }
 form .button{
   height: 45px;
   margin: 35px 0
 }
 form .button input{
   height: 100%;
   width: 100%;
   border-radius: 20px;
   border: none;
   color: #fff;
   font-size: 18px;
   font-weight: 500;
   letter-spacing: 1px;
   cursor: pointer;
   transition: all 0.3s ease;
   background-color: #ee6010;
 }
 form .button input:hover{
  /* transform: scale(0.99); */
  background-color: #ee6010;
  }
 @media(max-width: 584px){
 .container{
  max-width: 100%;
}
form .user-details .input-box{
    margin-bottom: 15px;
    width: 100%;
  }
  form .category{
    width: 100%;
  }
  .content form .user-details{
    max-height: 300px;
    overflow-y: scroll;
  }
  .user-details::-webkit-scrollbar{
    width: 5px;
  }
  }
  @media(max-width: 459px){
  .container .content .category{
    flex-direction: column;
  }
}
    </style>
  </head>
<body>
  <div class="container">
    <div class="title">Diet Tracker</div>
    <div class="content">
      <form action="calculateDiet.jsp" method="post">
        <div class="user-details">
          <div class="input-box">
            <span class="details" for="waterIntake">Water Intake (ml)</span>
            <input type="number" id="waterIntake" placeholder="Enter your dog's water intake" name="waterIntake" required>
          </div>
          
          <div class="input-box">
            <span class="details" for="calorieIntake">Calorie Intake (kcal)</span>
            <input type="number" id="calorieIntake" placeholder="Enter your dog's protein intake" name="calorieIntake" required>
          </div>
	  <div class="input-box">
            <span class="details" for="protein">Protein (gm)</span>
            <input type="number" id="protein" placeholder="Enter your dog's protein intake" name="protein" required>
          </div>
          <div class="input-box">
            <span class="details" for="sleepDuration">Sleep Duration (hours)</span>
            <input type="number" id="sleepDuration" placeholder="Enter your dog's sleep duration" name="sleepDuration" required>
          </div>
          <div class="input-box">
            <span class="details" for="activityLevel">Activity Level</span>
            <select id="activityLevel" name="activityLevel" required>
                <option value="low">Low</option>
                <option value="moderate">Moderate</option>
                <option value="high">High</option>
            </select>
          </div>
                  
        </div>
        <div class="button">
          <input type="submit" value="Submit">
        </div>
      </form>
    </div>
  </div>

</body>
</html>