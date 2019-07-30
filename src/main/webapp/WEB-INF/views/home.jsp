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
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">

<link href="css/bootstrappage.css" rel="stylesheet" />

<!-- global styles -->
<link href="css/flexslider.css" rel="stylesheet" />
<link href="css/main.css" rel="stylesheet" />

<!-- scripts -->
<script src="js/jquery-1.7.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/superfish.js"></script>
<script src="js/jquery.scrolltotop.js"></script>
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
		<section class="homepage-slider" id="home-slider">
			<div class="flexslider">
				<ul class="slides">
					<li><img src="images/banner-1.jpg" alt="" /></li>
					<li><img src="images/banner-2.jpg" alt="" />
						<div class="intro">
							<h1>Mid season sale</h1>
							<p>
								<span>Up to 50% Off</span>
							</p>
							<p>
								<span>On selected items online and in stores</span>
							</p>
						</div></li>
				</ul>
			</div>
		</section>
		<section class="header_text">
			Welcome to your one stop solution for all your fashion woes!! <br />Don't
			miss out the grand sale
		</section>
		<section class="main-content">
			<div class="row">
				<div class="span12">
					<div class="row">
						<div class="span12">
							<h4 class="title">
								<span class="pull-left"><span class="text"><span
										class="line">Feature <strong>Products</strong></span></span></span> <span
									class="pull-right"> <a class="left button"
									href="#myCarousel" data-slide="prev"></a><a
									class="right button" href="#myCarousel" data-slide="next"></a>
								</span>
							</h4>
							<div id="myCarousel" class="myCarousel carousel slide">
								<div class="carousel-inner">
									<div class="active item">
										<ul class="thumbnails">
											<li class="span3">
												<div class="product-box">
													<span class="sale_tag"></span>
													<p>
														<a href="product_detail.html"><img
															src="themes/images/ladies/1.jpg" alt="" /></a>
													</p>
													<a href="product_detail.html" class="title">Ut wisi
														enim ad</a><br /> <a href="products.html" class="category">Commodo
														consequat</a>
													<p class="price">$17.25</p>
												</div>
											</li>
											<li class="span3">
												<div class="product-box">
													<span class="sale_tag"></span>
													<p>
														<a href="product_detail.html"><img
															src="themes/images/ladies/2.jpg" alt="" /></a>
													</p>
													<a href="product_detail.html" class="title">Quis
														nostrud exerci tation</a><br /> <a href="products.html"
														class="category">Quis nostrud</a>
													<p class="price">$32.50</p>
												</div>
											</li>
											<li class="span3">
												<div class="product-box">
													<p>
														<a href="product_detail.html"><img
															src="themes/images/ladies/3.jpg" alt="" /></a>
													</p>
													<a href="product_detail.html" class="title">Know
														exactly turned</a><br /> <a href="products.html"
														class="category">Quis nostrud</a>
													<p class="price">$14.20</p>
												</div>
											</li>
											<li class="span3">
												<div class="product-box">
													<p>
														<a href="product_detail.html"><img
															src="themes/images/ladies/4.jpg" alt="" /></a>
													</p>
													<a href="product_detail.html" class="title">You think
														fast</a><br /> <a href="products.html" class="category">World
														once</a>
													<p class="price">$31.45</p>
												</div>
											</li>
										</ul>
									</div>
									<div class="item">
										<ul class="thumbnails">
											<li class="span3">
												<div class="product-box">
													<p>
														<a href="product_detail.html"><img
															src="themes/images/ladies/5.jpg" alt="" /></a>
													</p>
													<a href="product_detail.html" class="title">Know
														exactly</a><br /> <a href="products.html" class="category">Quis
														nostrud</a>
													<p class="price">$22.30</p>
												</div>
											</li>
											<li class="span3">
												<div class="product-box">
													<p>
														<a href="product_detail.html"><img
															src="themes/images/ladies/6.jpg" alt="" /></a>
													</p>
													<a href="product_detail.html" class="title">Ut wisi
														enim ad</a><br /> <a href="products.html" class="category">Commodo
														consequat</a>
													<p class="price">$40.25</p>
												</div>
											</li>
											<li class="span3">
												<div class="product-box">
													<p>
														<a href="product_detail.html"><img
															src="themes/images/ladies/7.jpg" alt="" /></a>
													</p>
													<a href="product_detail.html" class="title">You think
														water</a><br /> <a href="products.html" class="category">World
														once</a>
													<p class="price">$10.45</p>
												</div>
											</li>
											<li class="span3">
												<div class="product-box">
													<p>
														<a href="product_detail.html"><img
															src="themes/images/ladies/8.jpg" alt="" /></a>
													</p>
													<a href="product_detail.html" class="title">Quis
														nostrud exerci</a><br /> <a href="products.html"
														class="category">Quis nostrud</a>
													<p class="price">$35.50</p>
												</div>
											</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
					<br />
					<div class="row">
						<div class="span12">
							<h4 class="title">
								<span class="pull-left"><span class="text"><span
										class="line">Latest <strong>Products</strong></span></span></span> <span
									class="pull-right"> <a class="left button"
									href="#myCarousel-2" data-slide="prev"></a><a
									class="right button" href="#myCarousel-2" data-slide="next"></a>
								</span>
							</h4>
							<div id="myCarousel-2" class="myCarousel carousel slide">
								<div class="carousel-inner">
									<div class="active item">
										<ul class="thumbnails">
											<li class="span3">
												<div class="product-box">
													<span class="sale_tag"></span>
													<p>
														<a href="product_detail.html"><img
															src="themes/images/cloth/bootstrap-women-ware2.jpg"
															alt="" /></a>
													</p>
													<a href="product_detail.html" class="title">Ut wisi
														enim ad</a><br /> <a href="products.html" class="category">Commodo
														consequat</a>
													<p class="price">$25.50</p>
												</div>
											</li>
											<li class="span3">
												<div class="product-box">
													<p>
														<a href="product_detail.html"><img
															src="themes/images/cloth/bootstrap-women-ware1.jpg"
															alt="" /></a>
													</p>
													<a href="product_detail.html" class="title">Quis
														nostrud exerci tation</a><br /> <a href="products.html"
														class="category">Quis nostrud</a>
													<p class="price">$17.55</p>
												</div>
											</li>
											<li class="span3">
												<div class="product-box">
													<p>
														<a href="product_detail.html"><img
															src="themes/images/cloth/bootstrap-women-ware6.jpg"
															alt="" /></a>
													</p>
													<a href="product_detail.html" class="title">Know
														exactly turned</a><br /> <a href="products.html"
														class="category">Quis nostrud</a>
													<p class="price">$25.30</p>
												</div>
											</li>
											<li class="span3">
												<div class="product-box">
													<p>
														<a href="product_detail.html"><img
															src="themes/images/cloth/bootstrap-women-ware5.jpg"
															alt="" /></a>
													</p>
													<a href="product_detail.html" class="title">You think
														fast</a><br /> <a href="products.html" class="category">World
														once</a>
													<p class="price">$25.60</p>
												</div>
											</li>
										</ul>
									</div>
									<div class="item">
										<ul class="thumbnails">
											<li class="span3">
												<div class="product-box">
													<p>
														<a href="product_detail.html"><img
															src="themes/images/cloth/bootstrap-women-ware4.jpg"
															alt="" /></a>
													</p>
													<a href="product_detail.html" class="title">Know
														exactly</a><br /> <a href="products.html" class="category">Quis
														nostrud</a>
													<p class="price">$45.50</p>
												</div>
											</li>
											<li class="span3">
												<div class="product-box">
													<p>
														<a href="product_detail.html"><img
															src="themes/images/cloth/bootstrap-women-ware3.jpg"
															alt="" /></a>
													</p>
													<a href="product_detail.html" class="title">Ut wisi
														enim ad</a><br /> <a href="products.html" class="category">Commodo
														consequat</a>
													<p class="price">$33.50</p>
												</div>
											</li>
											<li class="span3">
												<div class="product-box">
													<p>
														<a href="product_detail.html"><img
															src="themes/images/cloth/bootstrap-women-ware2.jpg"
															alt="" /></a>
													</p>
													<a href="product_detail.html" class="title">You think
														water</a><br /> <a href="products.html" class="category">World
														once</a>
													<p class="price">$45.30</p>
												</div>
											</li>
											<li class="span3">
												<div class="product-box">
													<p>
														<a href="product_detail.html"><img
															src="themes/images/cloth/bootstrap-women-ware1.jpg"
															alt="" /></a>
													</p>
													<a href="product_detail.html" class="title">Quis
														nostrud exerci</a><br /> <a href="products.html"
														class="category">Quis nostrud</a>
													<p class="price">$25.20</p>
												</div>
											</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</section>
		<section class="our_client">
			<h4 class="title">
				<span class="text">Manufactures</span>
			</h4>
			<div class="row">
				<div class="span2">
					<a href="#"><img alt="" src="images/14.png"></a>
				</div>
				<div class="span2">
					<a href="#"><img alt="" src="images/35.png"></a>
				</div>
				<div class="span2">
					<a href="#"><img alt="" src="images/1.png"></a>
				</div>
				<div class="span2">
					<a href="#"><img alt="" src="images/2.png"></a>
				</div>
				<div class="span2">
					<a href="#"><img alt="" src="images/3.png"></a>
				</div>
				<div class="span2">
					<a href="#"><img alt="" src="images/4.png"></a>
				</div>
			</div>
		</section>
		<section id="footer-bar">
			<div class="row">
				<div class="span3">
					<h4>Navigation</h4>
					<ul class="nav">
						<li><a href="./index.html">Homepage</a></li>

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
	<script src="js/common.js"></script>
	<script src="js/jquery.flexslider-min.js"></script>
	<script type="text/javascript">
		$(function() {
			$(document).ready(function() {
				$('.flexslider').flexslider({
					animation : "fade",
					slideshowSpeed : 4000,
					animationSpeed : 600,
					controlNav : false,
					directionNav : true,
					controlsContainer : ".flex-container" // the container that holds the flexslider
				});
			});
		});
	</script>
</body>
</html>
