<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="java.util.Random"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dog Diet Chart</title>
    <style>
        body {
            background-color: black;
            color: white;
            font-family: comfortaa;
            margin: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
            text-align: center;
        }

        h2, h3 {
            color: #e65d0f;
        }

        p {
            margin: 5px;
        }

        .progress-bar {
            width: 80%;
            background-color: #eee;
            height: 30px;
            border-radius: 5px;
            margin-top: 10px;
            overflow: hidden;
        }

        .progress {
            height: 100%;
            border-radius: 5px;
            background-color: #4CAF50;
        }

        table {
            width: 80%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 15px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #333;
            color: white;
        }

        ul {
            list-style-type: none;
            padding: 0;
            margin: 10px;
        }

        li {
            margin-bottom: 5px;
        }
    </style>
</head>
<body>

<%
    // Retrieve parameters from the request
    int waterIntake = Integer.parseInt(request.getParameter("waterIntake"));
    int calorieIntake = Integer.parseInt(request.getParameter("calorieIntake"));
    int protein = Integer.parseInt(request.getParameter("protein"));
    int sleepDuration = Integer.parseInt(request.getParameter("sleepDuration"));
    String activityLevel = request.getParameter("activityLevel");

    // Example: Suggested total water and calorie intake for the day
    int totalWater = 650;
    int totalCalories = 800;

    // Calculate remaining intake
    int remainingWater = totalWater - waterIntake;
    int remainingCalories = totalCalories - calorieIntake;

    // Calculate percentages
    double waterPercentage = (double) waterIntake / totalWater * 100;
    double caloriePercentage = (double) calorieIntake / totalCalories * 100;

    // Generate random values for meals and schedule
    Random random = new Random();
    int morningWater = random.nextInt(201) + 100;
    int morningCalorie = random.nextInt(51) + 150;
    int morningProtein = random.nextInt(6) + 5;

    int afternoonWater = random.nextInt(201) + 200;
    int afternoonCalorie = random.nextInt(51) + 200;
    int afternoonProtein = random.nextInt(6) + 10;

    int eveningWater = random.nextInt(101) + 50;
    int eveningCalorie = random.nextInt(51) + 50;
    int eveningProtein = random.nextInt(5) + 3;
%>

<h2>Dog Diet Chart</h2>

<div style="width: 80%; display: flex; justify-content: space-between;">
    <div style="flex: 1;">
        <h3>Today's Intake:</h3>
        <p>Water: <%= waterIntake %> ml</p>
        <p>Calories: <%= calorieIntake %> kcal</p>
        <p>Protein: <%= protein %> grams</p>
        <p>Sleep Duration: <%= sleepDuration %> hours</p>
        <p>Activity Level: <%= activityLevel %></p>

        <h3>Remaining Intake for the Day:</h3>
        <div class="progress-bar">
            <div class="progress" style="width: <%= waterPercentage %>%;"></div>
        </div>
        <p><%= remainingWater %> ml of water and <%= remainingCalories %> kcal remaining for the day.</p>
    </div>

    <div style="flex: 1;">
        <h3>Diet Chart:</h3>
        <table>
            <tr>
                <th>Time</th>
                <th>Water (ml)</th>
                <th>Calories (kcal)</th>
                <th>Protein (grams)</th>
            </tr>
            <tr>
                <td>Morning</td>
                <td><%= morningWater %></td>
                <td><%= morningCalorie %></td>
                <td><%= morningProtein %></td>
            </tr>
            <tr>
                <td>Afternoon</td>
                <td><%= afternoonWater %></td>
                <td><%= afternoonCalorie %></td>
                <td><%= afternoonProtein %></td>
            </tr>
            <tr>
                <td>Evening</td>
                <td><%= eveningWater %></td>
                <td><%= eveningCalorie %></td>
                <td><%= eveningProtein %></td>
            </tr>
        </table>
    </div>
</div>

<h3>Meal Suggestions:</h3>
<ul>
    <li>Breakfast: High-protein kibble</li>
    <li>Lunch: Chicken and rice</li>
    <li>Dinner: Wet food with added vegetables</li>
</ul>

</body>
</html>
