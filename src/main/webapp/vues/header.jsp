<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
	<title>BLOG</title>
	<style type="text/css">a{text-decoration: none;}</style>
</head>
<body>

	<header class="bg-dark p-4 text-center border border-0 border-bottom border-info border-4">

		<h1 class="text-uppercase">
			<a href="${pageContext.request.contextPath}/Article"> 
				<i class="fas fa-microphone"></i> encore un blog ?! #maisnonallo 
			</a>

		</h1>
		<nav class="text-end">
			<a href="${pageContext.request.contextPath}/Article?action=admin" class="text-info"><i class="fas fa-cogs"></i> Administration</a>
		</nav>
	</header>
	
	<main class="container-fluid bg-ligth">
		