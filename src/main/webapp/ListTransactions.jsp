<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import=" ma.ensa.dao.TransactionDao" %>    
<%@ page import=" ma.ensa.dao.impl.TransactionDaoImpl" %>  
<%@ page import="java.util.List" %>
<%@ page import="ma.ensa.Transaction" %>
<%@ page import="jakarta.annotation.security.RolesAllowed" %>

<%@ page import="java.security.Principal" %>

<%--
    Principal userPrincipal = request.getUserPrincipal();
    if (userPrincipal != null && request.isUserInRole("user")) {
        
    } else {
    	response.setHeader("Authorization", "Bearer");
        response.sendRedirect("http://localhost:8080/auth/realms/my-realm/protocol/openid-connect/auth?client_id=ouss-client&redirect_uri=http://localhost:8088/WebTransactions/callback&response_type=code&scope=read");
    }
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ListTrasactions</title>
</head>

<body>
 	
 	<%
 		TransactionDao dao = new TransactionDaoImpl();  
		List<Transaction> transactions = dao.selectAll();
	 	String trs=""; 
	 	
	 	for(Transaction t:transactions) trs+="<tr><td>"+t.getRef()+"</td>"+
			"<td>"+t.getCptDeb()+"</td>"+
			"<td>"+t.getCptCred()+"</td>"+
			"<td>"+t.getMontant()+"</td>"+
			"<td>"+t.getType()+"</td>"+
			"<td>"+t.getDate()+"</td></tr>"; %>	
	
		<h2>List of transactions </h2>
			<table>
				<tr><td>reference</td><td>compteDeb</td><td>compteCred</td>
				<td>montant</td><td>type</td><td>date</td></tr>
			<%= trs %>
			</table>	
				
</body>
</html>