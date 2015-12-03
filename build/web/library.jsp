<%--
    Document   : library
    Created on : Dec 1, 2015, 10:17:59 PM
    Author     : Betsey McCarthy and Colin Hiriak
--%>

<head>
  <%@page import="java.text.SimpleDateFormat"%>
  <%@page contentType="text/html" pageEncoding="UTF-8"%>
  <link rel="stylesheet" type="text/css" href="styles/styles.css">
  <%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
  <%@include file="header.jsp" %>
</head>
<body>
  <h1>Belk Library</h1>
  <div class="border" id=mainBox>
    <p id='thanks'>
     Thank you for your patronage of the Belk Library. You've successfully checked
     out the book, ${param.bookTitle}. Please note that this book is due
     back on <% SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        Date date = new Date();
        date.setTime(date.getTime() + 86400000 * 14);
        out.print(sdf.format(date));
      %> 
    . A friendly email reminder will be sent to you if
    your book becomes overdue.
  <br><br>
  <a id="return" href="index.jsp?action=goToIndex&amp;"> 
  <b> Return to front page 
  </b>
  </a>
  <br><br>
  </p>    
  </div>
  <%@include file="footer.jsp" %>
</body>
