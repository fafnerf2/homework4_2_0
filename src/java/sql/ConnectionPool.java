/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

/**
 *
 * 2015 Betsey McCarthy and Colin Hiriak
 */
import java.sql.*;
import javax.sql.DataSource;
import javax.naming.InitialContext; 
import javax.naming.NamingException;

/**
 * Makes connection for the database
 * @author emccarthy3
 */
public class ConnectionPool {
    private static ConnectionPool pool = null;
    private static DataSource dataSource = null;
    
    private ConnectionPool() {
        try {
            InitialContext ic = new InitialContext();
            dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/MySQLDS");
        } catch (NamingException e) {
            System.out.println(e);
        }
    }
          
    /**
     * if pool is null then create new ConnectionPool
     * @return
     */
    public static synchronized ConnectionPool getInstance() {
        if (pool == null) {
            pool = new ConnectionPool();
        }
        return pool;
    }
    
    /**
     * If there is an exception then catch the exception and return null
     * @return
     */
    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    
    /**
     * Close the connection
     * print "e"
     * @param c
     */
    public void freeConnection(Connection c) {
        try {
            c.close();
        } catch (SQLException e){
            System.out.println(e);
        }
    }
}