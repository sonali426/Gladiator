<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

						<li><a
							href="${pageContext.request.contextPath}/customer/addCustomerForm">Sign
								Up</a></li>
						<li><a
							href="${pageContext.request.contextPath}/customer/${action}">${action}</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<section class="header_text sub">
		<img class="pageBanner"
			src="${pageContext.request.contextPath}/images/pageBanner.png"
			alt="New products">
		<h4>
			<span>Customer Detail</span>
		</h4>
	</section>
	<div id="wrapper" class="container">
		<section class="navbar main-menu">
			<div class="navbar-inner main-menu">
				<a href="index.html" class="logo pull-left"><img
					src="images/logo.png" class="site_logo" alt=""></a>
				<nav id="menu" class="pull-right">
					<ul>
						<li><a href="./products.html">Categories</a>
							<ul>
								<c:forEach items="${categoryList}" var="categoryItem">
									<li><a
										href="${pageContext.request.contextPath}/product/showProductList/${categoryItem.categoryId}">${categoryItem.categoryName}</a></li>

								</c:forEach>
							</ul></li>
						<!-- <li><a href="./products.html">Man</a></li>			
                    <li><a href="./products.html">Sport</a>
                        <ul>									
                            <li><a href="./products.html">Gifts and Tech</a></li>
                            <li><a href="./products.html">Ties and Hats</a></li>
                            <li><a href="./products.html">Cold Weather</a></li>
                        </ul>
                    </li>							
                    <li><a href="./products.html">Hangbag</a></li>
                    <li><a href="./products.html">Best Seller</a></li>
                    <li><a href="./products.html">Top Seller</a></li> -->
					</ul>
				</nav>
			</div>
		</section>
		<div class="container border border-primary" align="center">
			<h1>Welcome! Please enter your details</h1>
			<%-- <c:url var="myaction" value="/customer/addCustomer"></c:url> --%>
			<spring-form:form method="post"
				action="${pageContext.request.contextPath}/customer/addCustomer"
				modelAttribute="customer">
				<h3>${msg}</h3>
				<table>
					<tr>
						<td><spring-form:label path="firstName">First Name</spring-form:label></td>
						<td><spring-form:input path="firstName" type="text"
								pattern="[A-Za-z]{2,20}" required="required"
								title="Please enter valid Name" /></td>
						<td><spring-form:errors path="firstName" type="text" />
					</tr>
					<tr>
						<td><spring-form:label path="lastName">Last Name</spring-form:label></td>
						<td><spring-form:input path="lastName" type="text"
								pattern="[A-Za-z]{2,20}" required="required"
								title="Please enter valid Name" /></td>
						<td><spring-form:errors path="lastName" type="text" />
					</tr>

					<tr>
						<td><spring-form:label path="address">Address</spring-form:label></td>
						<td><spring-form:input path="address"
								pattern="[A-Za-z0-9]{6,}" required="required"
								title="Please enter valid address" /></td>
						<td><spring-form:errors path="address" type="text" />
					</tr>
					<tr>
						<td><spring-form:label path="email">Email</spring-form:label></td>
						<td><spring-form:input path="email" /></td>
						<td><spring-form:errors path="username" type="text" />
					</tr>
					<tr>
						<h5>
							<font color="red">${message}</font>
						</h5>
						<td><spring-form:label path="username">Username</spring-form:label></td>
						<td><spring-form:input path="username" /></td>
						<td><spring-form:errors path="username" type="text" />
					</tr>
					<tr>
						<td><spring-form:label path="password">Password</spring-form:label></td>
						<td><spring-form:input path="password" type="password"
								pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
								title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
								required="required" /></td>
						<td><spring-form:errors path="password" type="text" />
					</tr>
					<tr>
						<td><input type="submit" value="Submit" /></td>
					</tr>
				</table>
			</spring-form:form>
		</div>
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
	</div>
	<script src="${pageContext.request.contextPath}/js/common.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/jquery.flexslider-min.js"></script>
</body>
</html>