
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
				<span>Product Detail</span>
			</h4>
		</section>
		</section>
		<section class="main-content">
			<div class="row">
				<div class="span9">
					<div class="row">
						<div class="span4">
							<a href="${pageContext.request.contextPath}/images/1.jpg"
								class="thumbnail" data-fancybox-group="group1"
								title="Description 1"><img alt=""
								src="${pageContext.request.contextPath}/images/1.jpg"></a>

						</div>
						<div class="span5">
							<address>
								<strong>Name:</strong> <span>${product.productName}</span><br>
								<strong>Product Code:</strong> <span>${product.productId}</span><br>

							</address>
							<h4>
								<strong>Price: ${product.productPrice}</strong>
							</h4>
						</div>
						<div class="span5">
							<form class="form-inline"
								action="${pageContext.request.contextPath}/cart/addProduct/${product.productId}">
								<!-- <label class="checkbox">
                                <input type="checkbox" value=""> Option one is this and that
                            </label> -->
								<!-- <br/>
                            <label class="checkbox">
                              <input type="checkbox" value=""> Be sure to include why it's great
                            </label> -->
								<p>&nbsp;</p>
								<label>Qty:</label> <input type="text" class="span1"
									placeholder="1">
								<button class="btn btn-inverse" type="submit">
									<a
										href="${pageContext.request.contextPath}/cart/addProduct/${product.productId}">
										Add To Cart</a>
								</button>
							</form>
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
							<img src="${pageContext.request.contextPath}/images/logo.png"
								class="site_logo" alt="">
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