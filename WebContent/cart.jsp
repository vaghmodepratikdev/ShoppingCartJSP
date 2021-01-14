<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page language="java"
	import="isi.exo.entity.productentity,java.util.Map,java.util.HashMap,java.util.ArrayList,java. util. Iterator"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table, th, td {
  border: 1px solid black;
    border: 1px solid black;
  
}
th, td {
  padding: 5px;
}
th {
  text-align: left;
}
img{
  width:100px;
  height:100px;
  }
</style>
</head>
<body>
<h3>Your Cart</h3>
<% HashMap<Integer,productentity> productListInSession = (HashMap<Integer,productentity>)session.getAttribute("sessionCart") ; %>
	<%Iterator hmIterator = productListInSession.entrySet().iterator(); %>
<table>
<tr><th>Image</th><th>Product name</th><th>Category</th><th>Description</th><th></th></tr>	
<%while (hmIterator.hasNext()) {  %>
			<% Map.Entry mapElement = (Map.Entry)hmIterator.next(); %>
			<% productentity product = (productentity)mapElement.getValue(); %>
<tr><td><img src = "<%=product.getImage() %>"></td><td><%=product.getName() %></td><td><%=product.getCategory() %></td><td><%=product.getDescription() %></td><td><a href="CartServlet?action=remove&remove_id=<%= product.getProductID() %>">remove</a></td></tr>			
		
<%} %></table><br>
<a href="OrderServlet">Proceed to check out</a><br>
<a href="ProductServlet">homepage</a>
</body>
</html>