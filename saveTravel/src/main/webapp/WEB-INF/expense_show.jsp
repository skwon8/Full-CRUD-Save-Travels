<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title></title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/main.js"></script>
</head>
<body>
	<div class = "container p2 grid gap2">
        <div class = "card">
            <div class = "card_head">
                <h1 class = "col_white1">${expense.name}</h1>
                <p><a href = "/expenses"></a>Go Back</p>
            </div>

            <div class = "card_body">
                <p>Vendor: ${expense.vendor}</p>
                <p>Amount: ${expense.amount}</p>
                <p>Description: ${expense.description}</p>
            </div>
        </div>
    </div>
</body>
</html>