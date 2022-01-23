// Serkan Koç 150118073
import java.util.ArrayList;

public class Library {
    private String address;
    private java.util.ArrayList<Book> books = new java.util.ArrayList<>();
    private java.util.ArrayList<Customer> customers = new java.util.ArrayList<>();

    public Library(String address) {
        this.address = address;
    }

    public static void printOpeningHours() {
        System.out.println("Libraries are open daily from 9 am to 5 pm.");
    }

    public void printAddress() {
        System.out.println(this.address);
    }

    public boolean addBook(Book book) {
        books.add(book);
        return true;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public int findingBookObject(String bookName) { //This method matches the given string value with the book object that we created.
        int k = 0;
        if (books.size() != 0) { //if array of books return -1
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).getTitle().equals(bookName)) {  //if the given string value is equal to object itself
                    if (!books.get(i).isBorrowed()) { // checking whether the book is available or not.
                        continue;
                    } else {
                        k = i; // k equals the index number of the object
                        break;
                    }
                } else
                    k = -1;
            }
        } else k = -1;
        return k;
    }

    public int findingPersonObject(String personName) {  //This method matches the given string value with the person object that we created.
        int k = 0;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(personName)) {
                k = i;
                break;
            } else
                k = -1;
        }
        return k;
    }


    public void borrowBook(String bookName, String personName) {

        if (findingBookObject(bookName) != -1) {  // checking whether the book is in the library or not
            if (findingPersonObject(personName) != -1) {  // checking whether the customer is assigned to the correct library
                if (books.get(findingBookObject(bookName)).isBorrowed()) {  // checking whether the book is available or not
                    if (!customers.get(findingPersonObject(personName)).isBorrowABook()) { // checking the person if he has already borrowed a book or not
                        customers.get(findingPersonObject(personName)).setBorrowedBook(books.get(findingBookObject(bookName))); // assigning the book to the give customer object
                        customers.get(findingPersonObject(personName)).setBorrowABook(true); // assigning that the person has borrowed the book
                        books.get(findingBookObject(bookName)).borrowed(); // assigning that the book is not available anymore.
                        System.out.println(personName + " successfully borrowed " + bookName + ".");
                    } else
                        System.out.println("Sorry, " + personName + " already borrowed a book");
                } else
                    System.out.println("Sorry, this book is already borrowed");
            } else
                System.out.println("Sorry, " + personName + " is not a customer");
        } else
            System.out.println("Sorry, this book is not in our catalog");
    }

    public void returnBook(String personName) {
        if (findingPersonObject(personName) != -1) { //checking whether the customer is assigned to the correct library
            if (customers.get(findingPersonObject(personName)).isBorrowABook()) { // checking the person if he has already borrowed a book or not
                System.out.println(personName + " successfully returned " + customers.get(findingPersonObject(personName)).getBorrowedBook().getTitle()); // demanded string message
                customers.get(findingPersonObject(personName)).getBorrowedBook().returned(); // returning the book to library
                customers.get(findingPersonObject(personName)).setBorrowedBook(null); // after returning book we need to assign it to null because customer can't borrow another book if we dont
                customers.get(findingPersonObject(personName)).setBorrowABook(false);//
            } else
                System.out.println("Sorry " + personName + " did not borrow a book");

        } else
            System.out.println("Sorry, " + personName + " is not a customer");


    }


    public void printAvailableBooks() {
        if (books.size() != 0) {
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).isBorrowed())
                    System.out.println(books.get(i).toString());
            }
        } else
            System.out.println("No book in catalog.");
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws Exception {
        if (address.length() >= 3)
            this.address = address;
        else
            throw new Exception("Address should be validated to be no less than 3 symbols.");
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }
}
