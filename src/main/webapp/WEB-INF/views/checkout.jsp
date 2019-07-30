<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring-form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>G.A.E.M</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<!--[if ie]><meta content='IE=8' http-equiv='X-UA-Compatible'/><![endif]-->
<!-- bootstrap -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css"
	rel="stylesheet">

<link href="${pageContext.request.contextPath}/css/bootstrappage.css"
	rel="stylesheet" />

<!-- global styles -->
<link href="${pageContext.request.contextPath}/css/flexslider.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/main.css"
	rel="stylesheet" />

<!-- scripts -->
<script src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/superfish.js"></script>
<script
	src="${pageContext.request.contextPath}/js/jquery.scrolltotop.js"></script>
</head>
<body>
	<div id="top-bar" class="container">
		<div class="row">
			<div class="span4">
				<form method="POST" class="search_form">
					<input type="text" class="input-block-level search-query"
						Placeholder="eg. T-sirt">
				</form>
			</div>
			<div class="span8">
				<div class="account pull-right">
					<ul class="user-menu">
						 <li><a href="${pageContext.request.contextPath}/customer/addCustomerForm">Sign Up</a></li>				
                        <li><a href="${pageContext.request.contextPath}/customer/${action}">${action}</a></li>	
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div id="wrapper" class="container">
		<section class="navbar main-menu">
			<div class="navbar-inner main-menu">
				<a href="${pageContext.request.contextPath}/" class="logo pull-left"><img
					src="${pageContext.request.contextPath}/images/logo.png"
					class="site_logo" alt=""></a>
				<nav id="menu" class="pull-right">
					<ul>
						<li><a href="./products.html">Categories</a>
							<ul>
								<c:forEach items="${categoryList}" var="categoryItem">
									<li><a
										href="${pageContext.request.contextPath}/product/showProductList/${categoryItem.categoryId}">${categoryItem.categoryName}</a></li>

								</c:forEach>
							</ul></li>
					</ul>
				</nav>
			</div>
		</section>
		<section class="header_text sub">
			<img class="pageBanner"
				src="${pageContext.request.contextPath}/images/pageBanner.png"
				alt="New products">
			<h4>
				<span>Checkout</span>
			</h4>
		</section>
		<section class="main-content">
<div class="row">
        <div class="span12">
            <div class="accordion" id="accordion2">
                <div class="accordion-group">
                    <div class="accordion-heading">
                        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">Checkout Options</a>
                    </div>
                    <div id="collapseOne" class="accordion-body in collapse">
                        <div class="accordion-inner">
                            <div class="row-fluid">
                                <div class="span6">
                                    <h4>Payment Options</h4>
                                    
                                        <fieldset>
                                            <label class="radio" for="register">
                                                <input type="radio" name="account" value="register" id="register" checked="checked">Cash On Delivery
                                            </label>
                                            <label class="radio" for="guest">
                                                <input type="radio" name="account" value="guest" id="guest">Card Payment
                                            </label>
                                            <br>
                                            
                                        </fieldset>
                                    </form>
                                 </div>
                                 
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="accordion-group">
                    <div class="accordion-heading">
                        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">Account &amp; Billing Details</a>
                    </div>
                    <div id="collapseTwo" class="accordion-body collapse">
                        <div class="accordion-inner">
                            <div class="row-fluid">
                                
                                <div class="span6">
                                    <h4>Your Address</h4>
                                    <div class="control-group">
                                        <label class="control-label">House no.</label>
                                        <div class="controls">
                                            <input type="text" placeholder="" class="input-xlarge">
                                        </div>
                                    </div>
                                  					  
                                    <div class="control-group">
                                        <label class="control-label"><span class="required">*</span> Address 1:</label>
                                        <div class="controls">
                                            <input type="text" placeholder="" class="input-xlarge">
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">Address 2:</label>
                                        <div class="controls">
                                            <input type="text" placeholder="" class="input-xlarge">
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label"><span class="required">*</span> City:</label>
                                        <div class="controls">
                                            <input type="text" placeholder="" class="input-xlarge">
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label"><span class="required">*</span> Post Code:</label>
                                        <div class="controls">
                                            <input type="text" placeholder="" class="input-xlarge">
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label"><span class="required">*</span> Country:</label>
                                        <div class="controls">
                                            <select class="input-xlarge">
                                                <option value="1">India</option>
                                                <option value="2">Albania</option>
                                                <option value="3">Algeria</option>
                                                <option value="4">American Samoa</option>
                                                <option value="5">Andorra</option>
                                                <option value="6">Angola</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label"><span class="required">*</span> Region / State:</label>
                                        <div class="controls">
                                            <select name="zone_id" class="input-xlarge">
                                                <option value=""> --- Please Select --- </option>
                                                <option value="3513">Maharashtra</option>
                                                <option value="3514">Uttarakhand</option>
                                                <option value="3515">Gujarat</option>
                                                <option value="3516">Uttar Pradesh</option>
                                                <option value="3517">Bihar</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="accordion-group">
                    <div class="accordion-heading">
                        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseThree">Confirm Order</a>
                    </div>
                    <div id="collapseThree" class="accordion-body collapse">
                        <div class="accordion-inner">
                            <div class="row-fluid">
                                <div class="control-group">
                                    <label for="textarea" class="control-label">Comments</label>
                                    <div class="controls">
                                        <textarea rows="3" id="textarea" class="span12"></textarea>
                                    </div>
                                </div>									
                                <button class="btn btn-inverse pull-right">
                                <a href="${pageContext.request.contextPath}/order/placeOrder">
                                Confirm order</a></button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>				
        </div>
    </div>
		</section>
		<div id="wrapper" class="container">
			<section id="footer-bar">
				<div class="row">
					<div class="span3">
						<h4>Navigation</h4>
						<ul class="nav">
							<li><a href="${pageContext.request.contextPath}/">Homepage</a></li>
							
						</ul>
					</div>
					<div class="span5">
						<p class="logo">
							<img src="themes/images/logo.png" class="site_logo" alt="">
						</p>
						<p>Lorem Ipsum is simply dummy text of the printing and
							typesetting industry. the Lorem Ipsum has been the industry's
							standard dummy text ever since the you.</p>
						<br /> <span class="social_icons"> <a class="facebook"
							href="#">Facebook</a> <a class="twitter" href="#">Twitter</a> <a
							class="skype" href="#">Skype</a> <a class="vimeo" href="#">Vimeo</a>
						</span>
					</div>
				</div>
			</section>
			<section id="copyright">
				<span>Copyright 2013 bootstrappage template All right
					reserved.</span>
			</section>
		</div>

		<script src="${pageContext.request.contextPath}/js/common.js"></script>
		<script
			src="${pageContext.request.contextPath}/js/jquery.flexslider-min.js"></script>
</body>
</html>
