/**
 * @author Artur
 *
 */
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Scanner;
public class Teacher extends Borrower {
 public Teacher(String username){
  super(username);
 }



 @Override
 public ArrayList<Book> checkOut(Book in) {
  ArrayList<String>choices = new ArrayList<String>(); //we should probably break this into two methods, one for removal and verification and the other for getting all books that satisfy params
  Category.getKey(); 
  @SuppressWarnings("resource")
  Scanner temp = new Scanner(System.in);
  int i =0;
  if(i<5){
   System.out.print("Would you like to checkout a book? Enter yes or no.");
   String answer = temp.next().toLowerCase();
   if(answer.equals("yes")){
     System.out.print("Please enter the ISBN#:");
     String isbnNumber = temp.next().toLowerCase();
     System.out.print("Please enter the book name:");
     String name = temp.next().toLowerCase();
     System.out.print("Please enter the author:");
     String authorPerson = temp.next().toLowerCase();
     System.out.print("Please enter the catogory:");
     String catogoryType = temp.next().toLowerCase();
     System.out.print("Please enter the status of the book:");
     String statusOfBook = temp.next().toLowerCase();
     Book in1 = new Book(isbnNumber, name, authorPerson, catogoryType, statusOfBook); //in1 never used
     if(statusOfBook=="avalible"){
       choices.add(name);
       Calendar calTeacher = Calendar.getInstance();
       System.out.println("Check Out Date:"+ calTeacher.getTime());
       int Teacher = 7; //poorly named int, also never used
       System.out.println("Teacher due date is :"+calTeacher.getTime());
       Library.lib.remove(in);
       i++;
     }
     else 
       System.out.print("Unfortunatly, book is unavailable. Please enter another book choice.");
   }
   else
     break;
  }
  return choices;
  //public ArrayList<String> books_has = new ArrayList<String>() use this to place the books that will be checked out
  //make the due dates from the book class
  //make sure the amount ckecked is legal for that respecive student

  // TODO Auto-generated method stub <-Nicky&Justin
  //cannot complete until borrower completed <-Nicky
 }








 @Override
 public void UI() {
  System.out.println("Successfully logged in");
  // TODO Auto-generated method stub <-Nicky
  //remember to only use scanner scnr, saves system resources and makes it better to close
 }
}