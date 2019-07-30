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
				<span>LOGIN</span>
			</h4>
		</section>
		</section>
		<section class="main-content">
			
			<spring-form:form method="post" action="${pageContext.request.contextPath}/customer/loginStatus"
				modelAttribute="customer">
				<form>
					<div class="container border" align="center">
						<div class="form-group" align="center">
							<h5>
								<font color="red">${message}</font>
							</h5>
							<spring-form:label path="email">Email</spring-form:label>
							<spring-form:input path="email" type="email" class="form-control"
								id="exampleInputEmail1" placeholder="Enter email" size="60" />
							<spring-form:errors path="email" type="email" />
						</div>
						<div class="form-group" align="center">
							<spring-form:label path="password">Password</spring-form:label>
							<spring-form:input path="password" type="password"
								class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" placeholder="Enter Password"
								size="60" />
							<spring-form:errors path="password" type="password" />
						</div>
						<br>
						<div class="form-group">
							<a href="${pageContext.request.contextPath}/forgotPassword"
								class="btn btn-secondary btn-sm active" aria-pressed="true">Forgot
								Password?</a>
						</div>
						<br>
						<div class="form-group">
							<button type="submit" class="btn btn-primary">
							<a href="${pageContext.request.contextPath}/customer/loginStatus"
								class="btn btn-secondary btn-sm active" aria-pressed="true"></a>
							Submit</button>
						</div>
					</div>

				</form>
			</spring-form:form>
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
	</div>
	<script src="${pageContext.request.contextPath}/js/common.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/jquery.flexslider-min.js"></script>
</body>
</html>
