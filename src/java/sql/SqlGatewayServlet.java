/**
 *
 * @author Betsey McCarthy and Colin Hiriak 2015
 */
        

 
package sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author emccarthy3
 */
@WebServlet("/BookServlet")
public class SqlGatewayServlet extends HttpServlet {

    /**
     * Gets parameters and sets attributes from HTTPServletRequest
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
      
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
         }

    
    
    protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {        
      String url = "index.jsp";        
      String action = request.getParameter("action");  
      
      if(action != null && action.equals("goToCheckout")) {
        url = "checkout.jsp";
      }        
      if(action != null && action.equals("goToBooks")) {            
        ArrayList<Book> books = BookDB.selectBooks();            
        request.setAttribute("books", books);            
        url = "manage.jsp";
      }        
      if(action != null && action.equals("goToIndex")) {
        url = "index.jsp";
      }
      if(action != null && action.equals("Checkout")) {
        url = "library.jsp";
      }
      
      if(action != null && action.equals("doCheckout")) {                
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String bookTitle = request.getParameter("bookTitle");
        String dueDate = request.getParameter("dueDate");
        Book book = new Book(firstName, lastName, email, bookTitle, dueDate);
        BookDB.insert(book);
        String sqlResult = "";
        try {
            // load the driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // get a connection
            String dbURL = "jdbc:mysql://localhost:3306/mvc";
            String username = "root";
            String password = "mysqluser";
            
            String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
            if((host!= null) && (host.trim().length()>1)){
                String port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
                String appname = System.getenv("OPENSHIFT_APP_NAME");
                username = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
                password = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
                dbURL = "jdbc:mysql://" + host + ":" + port + "/" + appname;
            }
            
            Connection connection = DriverManager.getConnection(
                    dbURL, username, password);

            // create a statement
            Statement statement = connection.createStatement();
               
                    // create the HTML for the result set
                    ResultSet resultSet
                            = statement.executeQuery("SELECT * FROM book");
                    sqlResult = SQLUtil.getHtmlTable(resultSet);
                    resultSet.close();     
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            sqlResult = "<p>Error loading the databse driver: <br>"
                    + e.getMessage() + "</p>";
        } catch (SQLException e) {
            sqlResult = "<p>Error executing the SQL statement: <br>"
                    + e.getMessage() + "</p>";
        }
        getServletContext().getRequestDispatcher(url)
          .forward(request, response);
        }
    }
}