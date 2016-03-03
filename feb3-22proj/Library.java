/**
 * @author Artur
 *
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Library {
 protected static ArrayList<Book> lib = new ArrayList<Book>();
 protected static ArrayList<Borrower> users = new ArrayList<Borrower>(); 
 protected static Borrower currentUser;
 protected static Scanner scnr = new Scanner(System.in);
 public String name;

 public Library(String name) {
  this.name = name;
  launch(true);
 }
 
 public String toString(){
  return name;
 }
 
 public static void launch(boolean firstStart){
  if(firstStart == false){
   populateUsers();
   populateLib(fetch());
  }
  getUser();
  currentUser.UI(); //TODO finish UI <-Nicky
  
  updateUsers();
  updateLib();
  System.exit(0);
 }
 
 private static void updateUsers() {
  // TODO Auto-generated method stub <-Artur
  
 }

 private static void populateUsers() {
  // TODO Auto-generated method stub <-Artur
  
 }

 private static void populateLib(ArrayList<String> out){
  String book_name, author, category, status, isbn;

  Date time_of_checkout = new Date();
  for(int i=0;i<out.size()-1;i++){
   String current = out.get(i);
   isbn = Integer.parseInt(current.substring(current.indexOf("ISBNID="), current.indexOf(" BookName=")));
   book_name =current.substring(current.indexOf(" BookName="),current.indexOf(" Author="));
   author =current.substring(current.indexOf(" Author="),current.indexOf(" Category="));
   category =current.substring(current.indexOf(" Category="),current.indexOf(" Status="));
   status =current.substring(current.indexOf(" Status="),current.indexOf(" TimeOfMostRecentCheckout"));
   time_of_checkout.setTime(Long.parseLong(current.substring(current.indexOf(" TimeOfMostRecentCheckout"),current.length())));
   Book temp = new Book(isbn,book_name,author,category,status);
   temp.setTime_of_checkout(time_of_checkout);
   lib.add(temp);
  }
 }

 private static void updateLib(){
  //TODO write out arraylist to books.txt <-Artur
  //mad work
  //warn user if could not save
 }
 
 /**
  * Creates user specific instance
  */
 private static void getUser(){
  System.out.println("Sign in: 'i' %nSign up: 'u'");
  String in = scnr.next().toLowerCase();
  System.out.printf("Are you a teacher or a student? %n Student:'S', Teacher'T'");
  String type = scnr.next().toLowerCase();
  System.out.println("enter your username: (case sensitive)");
  String username =scnr.next();
  if(in.equals("u")){
   if(type.equals("s")){
    Student temp = new Student(username);
    users.add(temp);
    currentUser = temp;
    
   }else if(type.equals("t")){
    Teacher temp = new Teacher(username);
    users.add(temp);
    currentUser = temp;
   }

  }else if(in.equals("i")){
   boolean a = false;
   Borrower user = null;
   for(Borrower temp: users){
    if(temp.username.equals(username)){
     a = true;
     temp = user;
     break;
    }
   }
   if(a){
    currentUser = user;
   }
  }else{
   System.out.printf("you have entered a username that does not exist, returning you to sign in/sign up screen");
   getUser();
  }
 }

 /**
  * fills out with input from Books.txt
  */
 protected static ArrayList<String> fetch(){
  ArrayList<String> out = new ArrayList<String>();
  try{
   System.out.println("fetching file");
   FileReader fileReader = new FileReader("Books.txt");
   BufferedReader bufferedReader = new BufferedReader(fileReader);
   boolean b = true;
   while(b){
    String temp = bufferedReader.readLine(); //saves current iteration into temp var
    if(temp.equals(null)){ //when reading empty line, temp var = null
     b = false; //prevent more looping
     break; //do not continue loop
    }
    out.add(temp); //if not null, or error, write to arraylist
   }
   bufferedReader.close(); //close importstream to prevent mem leak
  } catch (IOException e) {
   e.printStackTrace();
   System.out.println("failed to fetch file");
  }
  return out;

 }
}