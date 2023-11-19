<%-- 
    Document   : subscription_fees
    Created on : 18 Nov, 2023, 9:03:42 PM
    Author     : Subhajit-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Subscriptionfees</title>
    <link rel="stylesheet" href="../Stylesheets/subscription_fees.css">
</head>
<body>
    <section class="pricing-section">
        <div class="pricing">
            <div class="pricing-body">
                <div class="pricing-body-header">
                    <h2>Our Plans</h2>
                </div>
                <div class="pricing-body-plans">
                    <div class="active" id="pricing__monthly__plan">
                        <div>
                            <div class="card">
                                <div class="card-header">
                                    <span class="card-title">Starter</span>
                                    <h2 class="card-price"> &#8377;200</h2>
                                </div>
                                <div class="card-body">
                                    <ul>
                                        <li>Diet Chart</li>
                                    </ul>
                                </div>
                                <div class="card-footer">
                                    <button>Subscribe</button>
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-header">
                                    <span class="card-title">Standard</span>
                                    <h2 class="card-price">&#8377;1000</h2>
                                </div>
                                <div class="card-body">
                                    <ul>
                                        
                                        <li>Diet Chart</li>
                                        <li>24/7 Technical Support</li>
                                        
                                    </ul>
                                </div>
                                <div class="card-footer">
                                    <button>Subscribe</button>
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-header">
                                    <span class="card-title">Supreme</span>
                                    <h2 class="card-price">&#8377;2000</h2>
                                </div>
                                <div class="card-body">
                                    <ul>
                                        
                                        <li>Diet Chart</li>
                                        <li>24/7 Technical Support</li>
                                        <li>Free Upgrade</li>
                                    </ul>
                                </div>
                                <div class="card-footer">
                                    <button>Subscribe</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="pricing__anually__plan">
                        <div>
                            <div class="card">
                                <div class="card-header">
                                    <span class="card-title">Starter</span>
                                    <h2 class="card-price">$19</h2>
                                </div>
                                <div class="card-body">
                                    <ul>
                                        <li>500 MAUs</li>
                                        <li>3 projects</li>
                                        <li>Unlimited guides</li>
                                        <li>Unlimited flows</li>
                                        <li>Unlimited branded themes</li>
                                        <li>Email support</li>
                                    </ul>
                                </div>
                                <div class="card-footer">
                                    <button>Choose Plan</button>
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-header">
                                    <span class="card-title">Pro</span>
                                    <h2 class="card-price">$99<span>/month</span></h2>
                                    <div class="card-users">
                                        <input list="pro__users__limit" name="pro__users__input" id="pro__users__input">
                                        <datalist id="pro__users__limit">
                                            <option value="50 MAUs">
                                            <option value="100 MAUs">
                                            <option value="500 MAUs">
                                            <option value="1000 MAUs">
                                            <option value="2500 MAUs">
                                        </datalist>
                                        <span>Monthly active users</span>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <ul>
                                        <li>All starter features, plus:</li>
                                        <li>Unlimited projects</li>
                                        <li>Unlimited fully customizable themes</li>
                                        <li>A dedicated Customer Success Manager</li>
                                    </ul>
                                </div>
                                <div class="card-footer">
                                    <button>Choose Plan</button>
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-header">
                                    <span class="card-title">Enterprise</span>
                                    <h2 class="card-price">Let's Talk!</h2>
                                </div>
                                <div class="card-body">
                                    <ul>
                                        <li>All Pro features</li>
                                        <li>Unlimited MAUs</li>
                                        <li>Dedicated environment</li>
                                        <li>Enterprise account administration</li>
                                        <li>Premium support and services</li>
                                    </ul>
                                </div>
                                <div class="card-footer">
                                    <button>Contact Us</button>
                                </div>
                            </div>
                        </div>
                    </div>
    
                </div>
            </div>
        </div>
    </section>
    <script>
        const planBtn = document.getElementById("custom-checkbox");
        const plans = document.querySelectorAll(".pricing-body-plans > div");

        planBtn.addEventListener("click", function() {
            this.classList.toggle("anually");
            plans[0].classList.toggle("active");
            plans[1].classList.toggle("active");
        })
    </script>
</body>
</html>