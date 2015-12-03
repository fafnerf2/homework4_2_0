<!--2015 Betsey McCarthy and Colin Hiriak-->

<html>
<head>
    <meta charset="utf-8">
    <title>Checkout</title>
    <link rel="stylesheet" type="text/css" href="styles/styles.css">  
    <%@include file="header.jsp" %>
</head>
<body>
  <h1>Belk Library</h1>
  <div class ="border">
  <h2>Checkout a book</h2>
    <form action="library.jsp" method="post">
      <input class="inputs" type="hidden" name="action" value="add">        
      <label>Email:</label>
      <input id="email_input"  type="email" name="email"  ><br>
      <label>First Name:</label>
      <input class="inputs" type="text" name="firstName" ><br>
      <label>Last Name:</label>
      <input class="inputs" type="text" name="lastName" ><br> 
      <label>Book Title:</label>
      <input id="book_input" type="text" name="bookTitle" ><br>
      <label>&nbsp;</label>
      <input type="submit" value="Checkout" id="check_button>
    </form>
  
    </div>
</body>
<%@include file="footer.jsp" %>
</html>