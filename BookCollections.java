/**
 *
 * @author logan
 */

package logandeal.a3;

import java.util.*;

// Author class
class Author {
    private String firstname;
    private String lastname;
    
    public Author(Author author){ 
        firstname = author.getFirstName();
        lastname = author.getLastName();
    }
    
    public Author(String firstname, String lastname){
        setName(firstname, lastname);
    }
    
    public String getName(){ // Gets the full name
        return firstname + " " + lastname;
    }
    
    public String getFirstName(){
        return firstname;
    }
    
    public String getLastName(){
        return lastname;        
    }
    
    public final void setName(String firstname, String lastname){ 
        this.firstname = firstname;
        this.lastname = lastname;
    }
}

// Book class
class Book {
    String title;
    Author author;
    int yearpublished;
    
    public Book(String title, Author author, int yearpublished){
        this.title = title;
        this.author = new Author(author);
        this.yearpublished = yearpublished;
    }
    
    public String getInfo(){ // Returns all fields of the class separated by newlines
        return title + "\n" + "By " + author.getName() + "\n" + yearpublished;
    }
    
//    public String toString(){
//        return "Title: " + this.title + " Author: " + this.author + " Year Published: " + this.yearpublished;
//    }  
}

class BookCollection { // ArrayList of Books
    ArrayList<Book> books = new ArrayList(); 
    
    public BookCollection(){ 
      
    }
    
    public BookCollection(BookCollection collection){
      //this.books = collection.books;
        for (Book book : collection.books){ // Iterates through collection to add each book
            AddBook(book);
        }
    }
    
    public BookCollection(Book...books){ 
        for (Book book : books){ // Iterates through collection to add each book
            AddBook(book);
        }
    }
    
    public final void AddBook(Book book){ // Adds one book to the ArrayList
        books.add(book); 
    }
    
    public void PrintBooks(){ // Prints out all books in the collection
        System.out.println("**** Books in collection ****");
         for (Book book : books){ // Iterates through the books ArrayList and prints the book info and a newline
            System.out.println(book.getInfo());
            System.out.println();
//            System.out.println(book.title);
//            System.out.println("By " + book.author.getName());
//            System.out.println(book.yearpublished);            
        }
        System.out.println("*****************************");
        System.out.println();
    }
   
}

// Main class
public class A3 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        // TODO code application logic here
        
        // Driver code
        String firstname = "Jim";
        String lastname = "Ries";
        
        Author author = new Author(firstname,lastname);
        System.out.println(author.getName());
        firstname = "Larry";
        System.out.println(author.getName());
        Author a2 = new Author("Larry","Ries");
        System.out.println(a2.getName());
        
        Book book = new Book("Some famous title", author, 2022);
        System.out.println(book.getInfo());
        author.setName("Ferd", "Berkle");
        System.out.println(book.getInfo());
        
        Book bookMMM = new Book("The Mythical Man-Month", new Author("Fred", "Brooks"), 1995);
        Book bookCC = new Book("Code Complete", new Author("Steve", "McConnel"), 2004);
        Book bookDragon = new Book("Compilers", new Author("Alfred","Aho"), 1985);
        BookCollection collection = new BookCollection(bookMMM, bookCC, bookDragon);
        collection.PrintBooks();
        BookCollection collection2 = new BookCollection(collection);
        collection.AddBook(book);
        collection.PrintBooks();
        collection2.PrintBooks();
        BookCollection collection3 = new BookCollection();
        collection3.PrintBooks();
    }
}
