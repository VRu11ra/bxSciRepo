/**
 * @author Artur
 *
 */
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Scanner;
public class Student extends Borrower {
	public Student(String username){
		super(username);
	}

	@Override
	public void checkOut(Book in) {
		ArrayList<String>choices = new ArrayList<String>();
		Category.getKey(); 
		@SuppressWarnings("resource")
		Scanner temp = new Scanner(System.in);
		for(int i = 0; i<2; i++){
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
			Book in1 = new Book(isbnNumber, name, authorPerson, catogoryType, statusOfBook);
			if(statusOfBook.equals("avalible")){
				choices.add(name);
				Calendar calStudent = Calendar.getInstance();
				System.out.println("Check Out Date:"+ calStudent.getTime());
				int Student = 14;
				calStudent.add(Calendar.DATE,Student);
				System.out.println("Student due date is :"+calStudent.getTime());
				Library.lib.remove(in1);
			}
			else 
				System.out.print("Unfortunatly, book is unavailable. Please enter another book choice.");
		}
		//public ArrayList<String> books_has = new ArrayList<String>() use this to place the books that will be checked out
		//make the due dates from the book class
		//make sure the amount ckecked is legal for that respecive student

		// TODO Auto-generated method stub <-Nicky&Justin
		//cannot complete until borrower completed <-Nicky

	}

	@Override
	public void UI() {
		System.out.println("Successfully logged in");
		/*go to Catogory.getKey for book*/
		// TODO Auto-generated method stub <-Nicky
		//remember to only use scanner scnr, saves system resources and makes it better to close

	}
}