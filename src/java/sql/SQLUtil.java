/**
 * Copyright 2015 Betsey McCarthy Colin Hiriak
 * 
 */
package sql;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
  * Gets table from sql results
  */
public class SQLUtil
{
  
  //private static Connection connection = null;
    /**
     * Gets table from the result set
     * @param results
     * @return 
     * @throws SQLException 
     */
  public static String getHtmlTable(ResultSet results)
    throws SQLException {
    StringBuilder htmlTable = new StringBuilder();
    ResultSetMetaData metaData = results.getMetaData();
    int columnCount = metaData.getColumnCount();
    htmlTable.append("<table>");  
    // add header row
    htmlTable.append("<tr>");
    for (int i = 1; i <= columnCount; i++) {
      htmlTable.append("<th>");
      htmlTable.append(metaData.getColumnName(i));
      htmlTable.append("</th>");
    }
    htmlTable.append("</tr>");
        
    // add all other rows
    while (results.next()) {
      htmlTable.append("<tr>");
      for (int i = 1; i <= columnCount; i++) {
        htmlTable.append("<td>");
        htmlTable.append(results.getString(i));
        htmlTable.append("</td>");
        }
        htmlTable.append("</tr>");
      }
      htmlTable.append("</table>");
      return htmlTable.toString();
    }    

  public static void closeStatement(Statement s) {
        try {
            if (s != null) {
                s.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void closePreparedStatement(Statement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}