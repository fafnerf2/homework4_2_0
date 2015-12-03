<%-- 
    Document   : index
    Created on : Dec 2, 2015, 4:15:44 AM
    Author     : Betsey McCarthy and Colin Hiriak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="styles/styles.css">
    <title>CSC 330 Homework 4</title>
    <%@include file="header.jsp" %>
    </head>
    <body>
      <h1> Belk Library </h1>
        <div class="border">
          <a href="checkout.jsp?action=goToCheckout&amp;"> 
            <b id="gotocheckout">Check out a book 
            </b></a><br><br>
          <a href="manage.jsp?action=goToBooks&amp;">
            <b> Manage checked out books
            </b>  
          </a>
          <br><br>
        </div>
    </body>
<%@include file="footer.jsp" %>
</html>

