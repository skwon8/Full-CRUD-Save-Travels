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

		<form:form class = "card" action = "/expense/${expense.id}/update" method = "POST" modelAttribute = "expense">
			<div class = "card_head">
				<h1 class = "col_while1">Edit Expense:</h1>
			</div>

			<div class = "card_body">
				<form:label class = "col_red" path = "name">Expense Name: </form:label>
				<form:input placeholder = "Expense Name" path = "name" />
				<form:errors path = "name" />

				<form:label class = "col_red" path = "vendor">Vendor: </form:label>
				<form:input placeholder = "Vendor" path = "vendor" />
				<form:errors path = "vendor" />

				<form:label class = "col_red" path = "amount">Amount: </form:label>
				<form:input placeholder = "Amount" path = "amount" />
				<form:errors path = "amount" />

				<form:label class = "col_red" path = "description">Description: </form:label>
				<form:input placeholder = "Description" path = "description" />
				<form:errors path = "description" />

				<input type = "submit" value = "Submit" />
			</div>
		</form:form>
	</div>
</body>
</html>