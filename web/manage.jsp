<!-- 2015 Betsey McCarthy and Colin Hiriak -->
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
  <h2>Currently checked out books</h2>
  <section>   
    <table id="checkedOut">
       <c:forEach var="book" items="${books}">
      <tr id="table_header">
        <th>Patron Name</th>
          <td>${Book.firstName}</td>
        <th></th>
        <th>Email Address</th>
          <td>${Book.email}</td>
        <th></th>
        <th>Book Title</th>
          <td>${Book.bookTitle}</td>
        <th></th>
        <th>Due Date</th>
        <td>${Book.dueDate}</td>
        <th></th>
        <th>Overdue</th>
        <th></th>
      </tr>
       </c:forEach>
    </table>  
    <p>
    <a id="return" href="index.jsp?action=goToIndex&amp;">Return to front page
    </a>
    <br><br>
    </p>
    </section>

   
</div>
    
    <%@include file="footer.jsp" %>


</body>
</html>