<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page  import="isi.exo.entity.productentity , java.util.ArrayList " %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload="frm.submit()">
<h3> WELCOME HOME </h3>
<fielset>
<legend>Filter by Country</legend>
<form id="frm"action="ProductServlet" method="get">
<br>
<select name="category" >
<option value="1">Category1</option>
<option value="2">Category2</option>
<option value="3">Category3</option>
<option value="4">Category4</option>
</select>
<input type="submit" value="SUBMIT">

</form>
</fielset>


<%
ArrayList<productentity> list = (ArrayList<productentity>) request.getAttribute("productlist");
%>
<% if(list != null && list.size() > 0){ %>
<% for (productentity s : list){ %>
    <ul>
        <li>Product name:<%=s.getName() %></li>
        <li>Category: <%=s.getCategory() %></li>
        <li>Description: <%=s.getDescription() %></li>
        <li>Image :<%=s.getImage() %></li>
       
    </ul>
<%} %>
<%} else { %>
   <h2>No Data found for this request</h2>
<%} %>
</body>
</html>