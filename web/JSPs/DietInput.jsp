<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Diet Tracker</title>
    <style>
    body {
        font-family: 'Arial', sans-serif;
        background-color: #191b1d;
        margin: 20px;
    }

    h2 {
        color: white;
        margin:0 auto;
        font-family:Comfortaa;
        text-align:center;
        font-size:30px;
        margin-bottom:5rem;
        margin-top:2rem;
    }

    form {
            max-width: 800px;
            margin: 0 auto; /* Set left and right margins to auto */
            background-color: #0e0b0b;
            color:white;
            border:2px #e65d0f solid;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            font-family: DM Sans;
            font-size:1.6rem;
      }


    label {
        display: block;
        margin-bottom: 10px;
    }

    input {
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
        color: white;
        margin-bottom:1rem
}

    input[type="submit"] {
        background-color: #e65d0f; /* Set button background color to #e65d0f */
        color: #fff;
        cursor: pointer;
        border:none;
        border-radius:30px;
        margin-top: 1.2rem;
    }
</style>

</head>
<body>
    <h2>Dog Diet Tracker</h2>

    <form action="calculateDiet.jsp" method="post">
    <label for="waterIntake">Water Intake (ml):</label>
    <input type="number" id="waterIntake" name="waterIntake" required><br>

    <label for="calorieIntake">Calorie Intake (kcal):</label>
    <input type="number" id="calorieIntake" name="calorieIntake" required><br>

    <label for="protein">Protein (grams):</label>
    <input type="number" id="protein" name="protein" required><br>

    <label for="sleepDuration">Sleep Duration (hours):</label>
    <input type="number" id="sleepDuration" name="sleepDuration" required><br>

    <label for="activityLevel">Activity Level:</label>
    <select id="activityLevel" name="activityLevel" required>
        <option value="low">Low</option>
        <option value="moderate">Moderate</option>
        <option value="high">High</option>
    </select><br>

    <input type="submit" value="Submit">
    
</form>


</body>
</html>
