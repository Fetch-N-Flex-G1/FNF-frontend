<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.text.DecimalFormat"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dog Diet Chart</title>
    <style>
        body {
            background-color: black;
            color: white;
            font-family: 'Arial', sans-serif;
            margin: 20px;
        }

        h2, h3 {
            color: #e65d0f;
        }

        p {
            margin-bottom: 10px;
        }

        .progress-bar {
            width: 100%;
            background-color: #eee;
            height: 30px;
            border-radius: 5px;
            margin-top: 10px;
        }

        .progress {
            height: 100%;
            border-radius: 5px;
            background-color: #4CAF50;
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        li {
            margin-bottom: 5px;
        }
    </style>
</head>
<body>

    <h2>Dog Diet Chart</h2>

    <%-- Retrieve parameters from the request --%>
    <%
        int waterIntake = Integer.parseInt(request.getParameter("waterIntake"));
        int calorieIntake = Integer.parseInt(request.getParameter("calorieIntake"));
        int protein = Integer.parseInt(request.getParameter("protein"));
        int sleepDuration = Integer.parseInt(request.getParameter("sleepDuration"));
        String activityLevel = request.getParameter("activityLevel");

        int totalWater = 650; // Example: Suggested total water intake for the day
        int totalCalories = 800; // Example: Suggested total calorie intake for the day

        int remainingWater = totalWater - waterIntake;
        int remainingCalories = totalCalories - calorieIntake;

        double waterPercentage = (double) waterIntake / totalWater * 100;
        double caloriePercentage = (double) calorieIntake / totalCalories * 100;
    %>

    <p>Today's Water Intake: <%= waterIntake %> ml</p>
    <p>Today's Calorie Intake: <%= calorieIntake %> kcal</p>
    <p>Today's Protein: <%= protein %> grams</p>
    <p>Sleep Duration: <%= sleepDuration %> hours</p>
    <p>Activity Level: <%= activityLevel %></p>

    <h3>Remaining Intake for the Day:</h3>
    <div class="progress-bar">
        <div class="progress" style="width: <%= waterPercentage %>%;"></div>
    </div>
    <p><%= remainingWater %> ml of water and <%= remainingCalories %> kcal remaining for the day.</p>

    <!-- Add sleep and activity charts or any other information as needed -->

    <h3>Diet Chart:</h3>
    <p>Suggested Schedule:</p>
    <ul>
        <li>Morning: Water - 200 ml, Calorie - 150 kcal, Protein - 10 grams</li>
        <li>Afternoon: Water - 300 ml, Calorie - 200 kcal, Protein - 15 grams</li>
        <li>Evening: Water - 150 ml, Calorie - 100 kcal, Protein - 8 grams</li>
    </ul>

    <h3>Meal Suggestions:</h3>
    <ul>
        <li>Breakfast: High-protein kibble</li>
        <li>Lunch: Chicken and rice</li>
        <li>Dinner: Wet food with added vegetables</li>
    </ul>

</body>
</html>
