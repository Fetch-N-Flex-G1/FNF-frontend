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
                                    <a href="./payment_gateway.jsp"><button>Subscribe</button></a>
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
                                    <a href="./payment_gateway.jsp"><button>Subscribe</button></a>
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
                                    <a href="./payment_gateway.jsp"><button>Subscribe</button></a>
                                </div>
                            </div>
                        </div>
                    </div>    
                </div>
            </div>
        </div>
    </section>
</body>
</html>