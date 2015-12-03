/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.io.Serializable;

/**
 *
 * @author Betsey McCarthy and Colin Hiriak 2015
 */
public class Book implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String bookTitle;
    private String dueDate;
    /**
     *
     */
    public Book() {
        firstName = "";
        lastName = "";
        email = "";
        bookTitle = "";
        dueDate = "";
    }

    /**
     * 
     * @param first set to first name
     * @param last set to last name
     * @param email set to email
     * @param bookTitle set to bookTitle
     */
    public Book(String first, String last, String email, String bookTitle, String dueDate) {
        this.firstName = first;
        this.lastName = last;
        this.email = email;
        this.bookTitle = bookTitle;
        this.dueDate = dueDate;
    }

    /**
     * get first name
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * get last name
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * get email
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * get book title
     * @return
     */
    public String getTitle() {
        return bookTitle;
    }
    
    public String getdueDate() {
      return dueDate;
    }

    /**
     * set first name
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * set last name
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * set email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * set book title
     * @param bookTitle
     */
    public void setTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    
    public void setdueDate(String dueDate) {
      this.dueDate = dueDate;
    }
     @Override
    public String toString() {
        return "Book [firstName=" + firstName
                + ", lastName=" + lastName + ", dueDate=" + dueDate + ", email="
                + email + ",bookTitle=" + bookTitle + "]";
    }    
    
}