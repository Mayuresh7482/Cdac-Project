<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE HTML>
<html>
<head>
	<title>Food Wastage</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport"
		content="width=device-width, initial-scale=1, maximum-scale=1">
	<link href="/css/bootstrap.css" rel="stylesheet" type="text/css" />
	<script src="/js/jquery.min.js"></script>
	<script src="/js/bootstrap.js"></script>
	<link rel="icon" href="/images/logo.png" />
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-success">
  <a class="navbar-brand" href="/">
  <img src="/images/logo.jpg" width="30" height="30" class="d-inline-block align-top" alt="">
  Food Wastage</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <c:if test="${sessionScope.user eq null }">
      <li class="nav-item active">
        <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/about">About Us</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/contact">Contact</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/mission">Our Mission</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/login">Login</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/register">Donor Register</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/aregister">Agent Register</a>
      </li>
      
      </c:if>
      <c:if test="${sessionScope.user.userid ne null }">
	      <c:if test="${sessionScope.user.role eq 'Donor' }">
		      <li class="nav-item">
		        <a class="nav-link" href="/donate">Donate</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="/mydonations">My Donations</a>
		      </li>
	      </c:if>
	      <c:if test="${sessionScope.user.role eq 'Agent' }">
		      <li class="nav-item">
		        <a class="nav-link" href="/notifications">Notifications
		        <c:if test="${sessionScope.count ne null and sessionScope.count > 0 }">
		        <span class="badge badge-primary">${sessionScope.count }</span>
		        </c:if></a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="/history">History</a>
		      </li>
	      </c:if>
	      <c:if test="${sessionScope.user.role eq 'Admin' }">
		      <li class="nav-item">
		        <a class="nav-link" href="/dashboard">Dashboard</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="/donations">Donations</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="/agents">Agents</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="/donors">Donors</a>
		      </li>
	      </c:if>
	      <li class="nav-item">
	        <a class="nav-link" href="/">Hi !${sessionScope.user.uname }</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/logout">Logout</a>
	      </li>
      </c:if>
    </ul>
  </div>
</nav>
